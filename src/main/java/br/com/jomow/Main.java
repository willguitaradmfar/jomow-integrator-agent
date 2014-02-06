package br.com.jomow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.jomow.connectors.Connector;
import br.com.jomow.model.ajrc.AJRCProcess;
import br.com.jomow.model.ajrc.Pedido;

import com.beust.jcommander.JCommander;

public class Main {
	public static void main(String[] args) throws IOException {		
		JCommanderParameter commanderParameter = new JCommanderParameter();
		JCommander jc = new JCommander(commanderParameter, args);
	
	  try {              	               
             Connection con = new Connector(commanderParameter.fonte).getConnection();
             
             Statement stmt = con.createStatement();
               
             stmt.execute("SELECT * FROM PEDIDO");
               
             ResultSet results = stmt.getResultSet();
             
             List<Pedido> pedidos = new ArrayList<Pedido>();
             
             while(results.next()){            	 
            	 pedidos.add(new Pedido(results));
             }
             
             AJRCProcess ajrcProcess = new AJRCProcess(pedidos, commanderParameter.urlPost, new File(commanderParameter.fileCache));
             
             ajrcProcess.tranformListToMD5();
             ajrcProcess.integrar();
                    
             con.close();
             
          } catch(Exception e) {   
             e.printStackTrace();   
          }
	}
	
}