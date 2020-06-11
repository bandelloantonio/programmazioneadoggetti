package univpm.Progetto;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;


public class Definizione {
	public String[] getJsonFromUrl() {
		//vengono definite due variabili di tipo String
		String line="";
	String[] longitudine= {"-122.398720","13.516850","40.4376161","55.5769116","40.9962036","-22.9131475"};
	String[] latitudine= {"37.781157","43.616967","3.9597326","36.2644586","17.1815004",",-44.0065071"};
	String[] data=new String[longitudine.length];
	for(int i=0;i<longitudine.length;i++) {
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

public ArrayList<Informazioni> parsing ( ) {
	// inizializzo e definisco un oggetto JSONObject
	String[] data = getJsonFromUrl();
	ArrayList<Informazioni> informazionitotali = new ArrayList<Informazioni>();
	for (int  i=0;i<data.length;i++) {
	JSONObject jobject = new JSONObject(data[i]);
	JSONObject jarra = jobject.getJSONObject("result");
	JSONArray jarray = jarra.getJSONArray("places");
	Informazioni info = new Informazioni();
	info.setCountry(jarray.getJSONObject(0).getString("country"));
	info.setCountry_code(jarray.getJSONObject(0).getString("country_code"));
	info.setFull_name(jarray.getJSONObject(0).getString("full_name"));
	info.setName(jarray.getJSONObject(0).getString("name"));
	info.setType_place(jarray.getJSONObject(0).getString("place_type"));

	String appo=(jarray.getJSONObject(0).getString("centroid"));
	long lat=Long.parseLong(appo.split(",")[0]);
	long lon=Long.parseLong(appo.split(",")[1]);
	Coordinate app = new Coordinate(lat,lon);
	info.setCoordinate(app);
	informazionitotali.add(info);
	}
	return informazionitotali;
   }
}