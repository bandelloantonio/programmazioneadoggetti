/**
 * 
 */
package univpm.Progetto;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;

/**
 * @author Antonio
 *
 */
public class Stats {
	public ArrayList<Informazioni> funzione(JSONObject coordinates){
		Coordinate[] contenitore = riconoscitore(coordinates);
		return null;
		
	}
	private Coordinate[] riconoscitore(JSONObject coordinates) {
		Coordinate[] riconosciuto = new Coordinate[2];
		JSONArray appoggio1 = coordinates.getJSONArray("angolo_destro_alto");
		riconosciuto[0].setCoordinate(appoggio1.toString());
		JSONArray appoggio2 = coordinates.getJSONArray("angolo_sinistro_basso");
		riconosciuto[0].setCoordinate(appoggio2.toString());
		return riconosciuto;
	}
}