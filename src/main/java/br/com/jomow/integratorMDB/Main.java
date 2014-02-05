package br.com.jomow.integratorMDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.beust.jcommander.JCommander;

public class Main {
	public static void main(String[] args) throws IOException {		
		JCommanderParameter commanderParameter = new JCommanderParameter();
		JCommander jc = new JCommander(commanderParameter, args);
	
	  try { 
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();	               
             Connection con = DriverManager.getConnection("jdbc:odbc:"+commanderParameter.table,"","");	                
             Statement stmt = con.createStatement();
               
             stmt.execute(commanderParameter.query);  
               
             ResultSet results = stmt.getResultSet();
             
             while(results.next()){
            	 System.out.println(results.getObject(commanderParameter.index));
             }  
             con.close();  
          } catch(Exception e) {   
             System.out.println(e);   
          }
	}
}


