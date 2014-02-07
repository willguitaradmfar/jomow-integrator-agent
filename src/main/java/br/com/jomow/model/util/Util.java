package br.com.jomow.model.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

public class Util {

	public static String  transformStringToMD5(String str) {
		return DigestUtils.md5Hex(str);
	}
	
	public static void sendPost(String body, String urlPost) throws Exception {		 
		
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(urlPost);
			
			StringEntity input = new StringEntity(body);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			
	 
			HttpResponse response = httpClient.execute(postRequest);	  
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));			
			
			Map result = new ObjectMapper().readValue(br, Map.class);
			
			if(!result.get("status").equals("Ok")){
				throw new Exception("Resposta da Plataforma negativa");
			}
			
			httpClient.getConnectionManager().shutdown();
	}
	
}
