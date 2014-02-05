package br.com.jomow.integratorMDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.jomow.integratorMDB.bean.Movimentacao;

import com.beust.jcommander.JCommander;

public class Main {
	public static void main(String[] args) throws IOException {		
		JCommanderParameter commanderParameter = new JCommanderParameter();
		JCommander jc = new JCommander(commanderParameter, args);
	
	  try {              	               
             Connection con = new Connector(commanderParameter.table).getConnection();
             
             Statement stmt = con.createStatement();
               
             stmt.execute(commanderParameter.query);
               
             ResultSet results = stmt.getResultSet();
             
             while(results.next()){
            	 System.out.println(results.getObject(commanderParameter.index));
             }  
             
             Movimentacao movimentacao = new Movimentacao();
             movimentacao.setNome("TEste");
             movimentacao.setData(new Date(System.currentTimeMillis()));
             
             ObjectMapper mapper = new ObjectMapper();
             System.out.println(mapper.writeValueAsString(movimentacao));             
             sendPost(mapper.writeValueAsString(movimentacao), commanderParameter.urlPost);       
             con.close();
             
          } catch(Exception e) {   
             System.out.println(e);   
          }
	}
	
	
	private static void sendPost(String body, String urlPost) throws Exception {
		 
		try {
			 
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(urlPost);
	 
			StringEntity input = new StringEntity(body);
			input.setContentType("application/json");
			postRequest.setEntity(input);
	 
			HttpResponse response = httpClient.execute(postRequest);
	  
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			httpClient.getConnectionManager().shutdown();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
	 
		
 
	}
}