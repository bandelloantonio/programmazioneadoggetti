package JsonArray;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

public class JsonArray () {

	String[] info = new String[50];
		int ne=0;
		for (int i = 0; i < id.length; i++) {
			StringBuilder content = new StringBuilder();

			// alcune di queste chiamate possono causare eccezioni quindi le ho messe in un try/catch
			
			try {
				// crea un oggetto url
				URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat=37.781157&long=-122.398720&granularity=neighborhood");

				// crea un ogetto urlconnection 
				URLConnection urlConnection = url.openConnection();

				// metto  urlconnection in una bufferedreader
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String line;

				// letto dalla urlconnection tramite il bufferedreader
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line + "\n");
				}
				bufferedReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			info[i]=content.toString();

		}

		while(info[ne]!=null) {
			ne++;
		}
			    // crea un arrey piu grande
		String[] eff = Arrays.copyOf(info, ne);
		return eff;

	


	/**
	 * Descrizione del metodo RichiestaInformazioni.
	 * Descrizione del metodo SalvataggioInformazioni.
	 */
	public void RichiestaInformazioni() {
		// inizio del metodo  RichiestaInformazioni
	public ArrayList<RecordInfo> SalvataggioInformazioni() {
		// inizio del metodo SalvataggioInformazioni
		// fine codici
	}

		String[] daParsare=RichiestaInformazioni();
		ArrayList<RecordInfo> informazioni = new ArrayList<RecordInfo>();
		for(int i =0;i<daParsare.length;i++) {
			RecordInfo  x = new RecrdInfo();

			JSONObject obj = new JSONObject(daParsare[i]);
			JSONArray arr = (obj).getJSONArray("data");
	        for (int j = 0; j < arr.length(); j++) {
		        String idAuto = arr.getJSONObject(j).getString("place_type");
		        x.setIdAutore(Double.parseDouble(idAuto));
		        String id = arr.getJSONObject(j).getString("name");
		        x.setId(Double.parseDouble(idAuto));
		        x.setDataCreazione(arr.getJSONObject(j).getString("full_name"));
		        x.setLinguaggio(arr.getJSONObject(j).getString("country_code"));
		        x.setSorgente(arr.getJSONObject(j).getString("country"));
		       
		  
		        }
	        }
		
		return informazioni;
	}
	}