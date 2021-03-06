package univpm.Progetto.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import univpm.Progetto.eccezioni.eccezioniInterne;
import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;

/**
 * Classe che gestisce la lettura dell 'url e le eventuali eccezzioni
 * 
 * @author Antonio
 */
public class Definizione {
	/**
	 * Ricerca l'URL per il download del dataset nel JSON e inizzializza l'intero
	 * array di record 
	 * @throws eccezioniInterne
	 * @return informazioni scaricate
	 */
	public String[] getJsonFromUrl() throws eccezioniInterne {

		String line = "";
		String[] longitudine;
		String[] latitudine;
		try {
			BufferedReader input = new BufferedReader(new FileReader("coordinate.txt"));
			longitudine = input.readLine().split(",");
			latitudine = input.readLine().split(",");
		} catch (IOException e) {
			throw new eccezioniInterne();
		}
		String[] data = new String[longitudine.length];
		int k = 0;
		for (int i = 0; i < longitudine.length; i++) {
			data[k] = "";
			try {
				URL link = new URL(
						"https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/reverse_geocode.json?lat="
								+ latitudine[i] + "&long=" + longitudine[i] + "&granularity=neighborhood&max_results");
				URLConnection openConnection = link.openConnection();
				wait(1);
				BufferedReader in = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
				try {

					while ((line = in.readLine()) != null) {
						data[k] += line + "\n";

					}
					if (!data[k].contains("errors"))
						k++;
				} finally {
					in.close();
				}
			} catch (IOException e) {
				throw new eccezioniInterne();

			} catch (Exception e) {
				i++;
			}
		}
		String[] datacompleti = new String[k];
		for (int i = 0; i < k; i++)
			datacompleti[i] = data[i];
		return datacompleti;
	}

	/**
	 * Il metodo che si utilizza per effettuare il PARSING dal JSON Inizzializzo e
	 * definisco un oggetto JSONObject
	 * @throws eccezioniInterne
	 * @return un array contenente le informazioni richieste
	 */
	public ArrayList<Informazioni> parsing() throws eccezioniInterne {

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
				Coordinate dainserire = new Coordinate();
				dainserire.setLatitudine(appo.getDouble(0));
				dainserire.setLongitudine(appo.getDouble(1));
				info.setCoordinate(dainserire);
				informazionitotali.add(info);
			}
		}
		return informazionitotali;
	}
}