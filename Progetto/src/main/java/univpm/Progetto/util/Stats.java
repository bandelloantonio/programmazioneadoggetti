
package univpm.Progetto.util;

/**
 * <p>
 * <b>Classe</b> per la gestione delle statistiche
 * <p>
 * @author Antonio
 */
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;

/**
 * crea una lista in base alle coordinate che vengono fornite
 */
public class Stats implements StatsInterfaccia {
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data){
		Coordinate[] contenitore = riconoscitore(coordinates);
		ArrayList<Informazioni> lista = new ArrayList<Informazioni>();
		for(int i=0;i<data.size();i++) {
			if(contenitore[1].getLatitudine()<data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLatitudine()>data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLongitudine()<data.get(i).getCoordinate().getLongitudine()&&contenitore[1].getLongitudine()>data.get(i).getCoordinate().getLongitudine())
				lista.add(data.get(i));
		}
		return lista;
	}
	
	/**
	 * @param coordinates
	 * @return le coordinate top left e botomright per formare un rettangolo identificativo 
	 */
	private Coordinate[] riconoscitore(JSONObject coordinates) {
		Coordinate[] riconosciuto = new Coordinate[2];
		JSONArray appoggio1 = coordinates.getJSONArray("angolo_sinistro_alto");
		riconosciuto[0].setCoordinate(appoggio1.toString());
		JSONArray appoggio2 = coordinates.getJSONArray("angolo_destro_basso");
		riconosciuto[1].setCoordinate(appoggio2.toString());
		return riconosciuto;
	}
}