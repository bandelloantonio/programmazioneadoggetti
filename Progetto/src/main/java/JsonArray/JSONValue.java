package JsonArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.primefaces.json.JSONObject;

public class JSONValue {

      
    private STRING place_type;
    private STRING name;
    private STRING full_name;
    private STRING country_code;
    private STRING country;
   
    public STRING getPlace_type() {
    	return place_type;
    }
    public void setPlace_type(STRING place_type) {
    	this.place_type = place_type;
    }
    public STRING getName() {
    	return name;
    }
    public void setName(STRING name) {
    	this.name = name;
    }
    public STRING getFull_name() {
    	return full_name;
    }
    public void setFull_name(STRING full_name) {
    	this.full_name = full_name;
    }
    public STRING getCountry_code() {
    	return country_code;
    }
    public void setCountry_code(STRING country_code) {
    	this.country_code = country_code;
    }
    public STRING getCountry() {
    	return country;
    }
    public void setCountry(STRING country) {
    	this.country = country;
    }
    
	public static JSONObject parseWithException(String data) 
	
		throws IOException {
			  FileReader f;
			    f= ;

		    BufferedReader b;
		    b=new BufferedReader(f);
		    String s;

		    while(true) {
		      s=b.readLine();
		      if(s==null)
		        break;
		      
		      System.out.println(s);
	}
	
    
    
  }
}

	


