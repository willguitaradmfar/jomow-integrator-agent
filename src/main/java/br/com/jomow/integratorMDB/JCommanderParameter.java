package br.com.jomow.integratorMDB;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;
 
public class JCommanderParameter {
  @Parameter
  private List<String> parameters = new ArrayList<String>();
 
  @Parameter(names = "-h", help = true)
  public boolean help;
  
  
  @Parameter(names = "-filemdb", description = "Arquivo MDB")
  public String fileMdb;  
  
  
  @Parameter(names = "-query", description = "Query")
  public String query;
  
  @Parameter(names = "-index", description = "Index")
  public String index;
  
  @Parameter(names = "-table", description = "Table")
  public String table;
  
  @Parameter(names = "-urlPost", description = "urlPost")
  public String urlPost;
  
}
