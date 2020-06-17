package univpm.Progetto.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import univpm.Progetto.model.Informazioni;

/**
 * @return l'URL per il download del dataset nel JSON e inizzializza l'intero
 *         array di record
 * @param url che ci restituisce un JSON contenente il link al dataset
 */

public class Definizione {

	public String[] getJsonFromUrl() throws IOException {

		/**
		 * definisco due variabili di tipo String
		 * 
		 * ed effettuo una lettura riga per riga
		 */
		String line = "";
		BufferedReader input = new BufferedReader(new FileReader("coordinate.txt"));
		String[] longitudine = input.readLine().split(",");
		String[] latitudine = input.readLine().split(",");
		String[] data = new String[longitudine.length];
		int k=0;
		for (int i = 0; i < longitudine.length; i++) {
			data[k] = "";
			try {
				URL link = new URL(
						"https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat="
								+ latitudine[i] + "&long=" + longitudine[i] + "&granularity=neighborhood&max_results");
				URLConnection openConnection = link.openConnection();
				BufferedInputStream in = new BufferedInputStream(openConnection.getInputStream());
				try {
					InputStreamReader inR = new InputStreamReader(in);
					BufferedReader buf = new BufferedReader(inR);
					while ((line = buf.readLine()) != null) {
						data[k] += line + "\n";

					}
					if(!data[k].contains("errors"))
						k++;
				} finally {
					in.close();
				}
			} catch (IOException e) {
				System.out.println("I/O Error" + e);

			} catch (Exception e) {
				i++;
			}
		}
		String[] datacompleti = new String[k];
		for(int i=0;i<k;i++) 
			datacompleti[i]=data[i];
		return datacompleti;
	}

	/**
	 * metodo che si utilizza per effettuare il PARSING dal JSON
	 * 
	 * @return un array contenente le informazioni richieste
	 * 
	 */
	public ArrayList<Informazioni> parsing() throws IOException {
		/**
		 * inizializzo e definisco un oggetto JSONObject
		 */
		String[] data = getJsonFromUrl();
		ArrayList<Informazioni> informazionitotali = new ArrayList<Informazioni>();
		for (int i = 0; i < data.length; i++) {
			JSONObject jobject = new JSONObject(data[i]);
			JSONObject jarra = jobject.getJSONObject("result");
			JSONArray jarray = jarra.getJSONArray("places");
			for (int j = 0; j < jarray.length(); j++) {
				Informazioni info = new Informazioni();
				info.setCountry(jarray.getJSONObject(j).getString("country"));
				info.setCountry_code(jarray.getJSONObject(j).getString("country_code"));
				info.setFull_name(jarray.getJSONObject(j).getString("full_name"));
				info.setName(jarray.getJSONObject(j).getString("name"));
				info.setType_place(jarray.getJSONObject(j).getString("place_type"));
				JSONArray appo = ((jarray.getJSONObject(j)).getJSONArray("centroid"));
				info.setLatitudine(appo.getDouble(0));
				info.setLongitudine(appo.getDouble(1));
				informazionitotali.add(info);
			}
		}
		return informazionitotali;
	}
}