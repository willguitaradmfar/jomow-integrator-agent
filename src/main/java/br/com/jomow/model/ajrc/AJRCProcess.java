package br.com.jomow.model.ajrc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.jomow.exception.PlataformResponseException;
import br.com.jomow.model.util.Util;

public class AJRCProcess {
	private ObjectMapper mapper = new ObjectMapper();
    
	private List<Pedido> pedidos;
	private Map<String, String> pedidosMD5;
	private Map<String, String> pedidosMD5Cache;
	private String urlPost;
	private File fileCacheIntegraator;
		
	public AJRCProcess(List<Pedido> pedidos, String urlPost, File fileCacheIntegraator) throws JsonParseException, JsonMappingException, IOException {
		this.pedidos = pedidos;
		pedidosMD5 = new HashMap<String, String>();
		this.urlPost = urlPost;		
		this.fileCacheIntegraator = fileCacheIntegraator;
		pedidosMD5Cache = mapper.readValue(fileCacheIntegraator, Map.class);		
	}
	
	public void tranformListToMD5() throws JsonGenerationException, JsonMappingException, IOException{		
		for(Pedido p : pedidos){
			pedidosMD5.put(p.getCodigo().toString(), Util.transformStringToMD5(p.toString()));
		}
	}
	
	public List<Pedido> getListToPost() throws JsonGenerationException, JsonMappingException, IOException{
		List<Pedido> listPost = new ArrayList<Pedido>();		
		for(Pedido p : pedidos){			
			if(pedidosMD5Cache.get(p.getCodigo().toString()) == null){				
				listPost.add(p);
			}			
			if(pedidosMD5Cache.get(p.getCodigo().toString()) != null && !pedidosMD5Cache.get(p.getCodigo().toString()).equals(pedidosMD5.get(p.getCodigo().toString()))){			
				
				listPost.add(p);
			}		
			
		}
		return listPost;
	}	
	
	public void integrar() throws JsonGenerationException, JsonMappingException, IOException, Exception{
		List<Pedido> pListPost = getListToPost();		
		for(Pedido p : pListPost){
			try{
				System.out.println(p);
				String json = mapper.writeValueAsString(p);
				Util.sendPost(json, this.urlPost);
				pedidosMD5Cache.put(p.getCodigo().toString(), Util.transformStringToMD5(p.toString()));
				mapper.writeValue(fileCacheIntegraator, pedidosMD5Cache);
			}catch(PlataformResponseException ex){
				System.err.println(ex.getMessage());
			}
		}
		
	}
}
