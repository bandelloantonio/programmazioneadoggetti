package JsonArray;

import java.io.IOException;
import javax.tools.JavaFileObject;
import univpm.Progetto.BufferedReader;
import univpm.Progetto.InputStream;
import univpm.Progetto.InputStreamReader;
import univpm.Progetto.URL;
import univpm.Progetto.URLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JsonArray {
	
		public static void main(String[] args) {

			String url = ""; //e.g. https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat=37.781157&long=-122.398720&granularity=neighborhood
			String fileName = "";
			if(args.length == 1) {
				url = args[0]; //Url by args ;-)
			}
			else
			{
				return;
			}
			try {
				
				URLConnection openConnection = new URL(url).openConnection();
				InputStream in = openConnection.getInputStream();
				
				 String data = "";
				 String line = "";
				 try {
				   InputStreamReader inR = new InputStreamReader( in );
				   BufferedReader buf = new BufferedReader( inR );
				  
				   while ( ( line = buf.readLine() ) != null ) {
					   data+= line;
				   }
				 } finally {
				   in.close();
				 
				 }
					System.out.println( data );
					JsonArray obj = (JsonArray) JSONValue.parseWithException(data);	//parse JSON Array
					JavaFileObject obj = (JavaFileObject) JSONValue.parseWithException(data);	 //parse JSON Object
					System.out.println( "OK" );
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

