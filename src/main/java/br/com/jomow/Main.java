package br.com.jomow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jomow.connectors.Connector;
import br.com.jomow.model.ajrc.AJRCProcess;
import br.com.jomow.model.ajrc.Pedido;

import com.beust.jcommander.JCommander;

public class Main {
	public static void main(String[] args) throws IOException {		
		JCommanderParameter commanderParameter = new JCommanderParameter();
		JCommander jc = new JCommander(commanderParameter, args);
		
		if(commanderParameter.help){
			jc.usage();
			System.exit(1);
		}
		
		if(commanderParameter.install){			
			Runtime.getRuntime().exec("odbcad32");			
			System.exit(1);
		}
	
	  try {              	               
             Connection con = new Connector(commanderParameter.fonte).getConnection();
             
             Statement stmt = con.createStatement();
               
             stmt.execute("SELECT top "+commanderParameter.limit+" * FROM PEDIDO");
               
             ResultSet results = stmt.getResultSet();
             
             List<Pedido> pedidos = new ArrayList<Pedido>();
             
             while(results.next()){            	 
            	 pedidos.add(new Pedido(results));
             }
             
             File fileCache = new File(commanderParameter.fileCache);
             if(!fileCache.isFile()){
            	 BufferedWriter br = new BufferedWriter(new FileWriter(fileCache));
            	 br.write("{}");  
            	 br.close(); 
             }
             
             AJRCProcess ajrcProcess = new AJRCProcess(pedidos, commanderParameter.urlPost, fileCache);
             
             ajrcProcess.tranformListToMD5();
             ajrcProcess.integrar();
                    
             con.close();
             
          } catch(Exception e) {   
             e.printStackTrace();   
          }
	}
	
}