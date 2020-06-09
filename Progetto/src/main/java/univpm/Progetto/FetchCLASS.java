package univpm.Progetto;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONObject;


public class FetchCLASS {

	public String[] getJsonFromUrl() {
		//vengono definite due variabili di tipo String
		String line="";
		String[] data=new String[100];
	String[] longitudine= {"-122.398720","",""};
	String[] latitudine= {"37.781157","",""};
	for(int i=0;i<1;i++) {
		data[i]="";
		try {
			  URL link =new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat="+latitudine[i]+"&long="+longitudine[i]+"&granularity=neighborhood&max_results");
			  URLConnection openConnection =link.openConnection();
			  BufferedInputStream in= new BufferedInputStream (openConnection.getInputStream());
			  try {
				  InputStreamReader inR = new InputStreamReader(in);
				  BufferedReader buf = new BufferedReader(inR);

				while ((line=buf.readLine()) != null)  {
					data[i]+=line+"\n"; //serve per avere una lettura riga per riga
				
				}
			  } 
			  finally {
				  in.close();
			  }
		} catch (IOException e) {
			System.out.println("I/O Error" + e);
		}
	}
		return data;
	}



//metodo che si utilizza per effettuare il PARSING dal JSON

public JSONArray parsing ( ) {
	// inizializzo e definisco un oggetto JSONObject
	String[] data = getJsonFromUrl();
	JSONObject jobject = new JSONObject(data[0]);
	JSONArray jarray = jobject.getJSONArray("result");
	//parse Json Object
	return jarray;
   }

}