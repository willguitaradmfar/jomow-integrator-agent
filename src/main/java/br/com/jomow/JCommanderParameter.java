package br.com.jomow;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;
 
public class JCommanderParameter {
  @Parameter
  private List<String> parameters = new ArrayList<String>();
 
  @Parameter(names = "-h", help = true)
  public boolean help;
  
  @Parameter(names = "-install", help = true)
  public boolean install;
  
  @Parameter(names = "-fonte", description = "Fonte de dados ODBC")
  public String fonte;
  
  @Parameter(names = "-urlPost", description = "HOST server ex. http://serverhost.com.br")
  public String urlPost;
  
  @Parameter(names = "-fileCache", description = "Arquivo de Cache")
  public String fileCache;
  
  @Parameter(names = "-limit", description = "Limite de registro : defatul = 100")
  public long limit = 100;
  
}
