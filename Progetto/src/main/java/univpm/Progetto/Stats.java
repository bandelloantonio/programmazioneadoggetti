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
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data){
		Coordinate[] contenitore = riconoscitore(coordinates);
		ArrayList<Informazioni> lista = new ArrayList<Informazioni>();
		for(int i=0;i<data.size();i++) {
			if(contenitore[1].getLatitudine()<data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLatitudine()>data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLongitudine()<data.get(i).getCoordinate().getLongitudine()&&contenitore[1].getLongitudine()>data.get(i).getCoordinate().getLongitudine())
				lista.add(data.get(i));
		}
		return lista;
	}
	private Coordinate[] riconoscitore(JSONObject coordinates) {
		Coordinate[] riconosciuto = new Coordinate[2];
		JSONArray appoggio1 = coordinates.getJSONArray("angol_sinistro_alto");
		riconosciuto[0].setCoordinate(appoggio1.toString());
		JSONArray appoggio2 = coordinates.getJSONArray("angolo_destro_basso");
		riconosciuto[1].setCoordinate(appoggio2.toString());
		return riconosciuto;
	}
}