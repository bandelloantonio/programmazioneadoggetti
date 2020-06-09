package univpm.Progetto;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.text.ParseException;

import org.primefaces.json.JSONObject;

public class FetchCLASS {

	public String getJsonFromUrl() {
		//vengono definite due variabili di tipo String
		String line="";
		String data="";
		
		try {
			  URLConnection openConnection = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat=37.781157&long=-122.398720&granularity=neighborhood&max_results")
					  BufferedInputStream in= new BufferInputStream(openConnection.getIputStream);
			  try {
				  InputStreamReader inR = new InputStreamReader(in);
				  BufferedReader buf=new InputStreamReader(inR);
				  
				while ((line=buf.readLine()) != null)  {
					data +=(line); //serve per avere una lettura riga per riga 
				}
			  } 
			  finally {
				  in.close();
			  }
		} catch (IOException e) {
			System.out.println("I/O Error" + e);
		}
		return data;
	}



//metodo che si utilizza per effettuare il PARSING dal JSON

public JSONObject parsing ( ) {
	JSONObject obj= null;
	// inizializzo e definisco un oggetto JSONObject
	String data = getJsonFromUrl();
	
	try {
		obj=(JSONObject)JsonValue.parseWithException(data);
	
	}catch (ParseException e) {
		e.printStackTrace();
	} 
	//parse Json Object
	return obj;
   }

}