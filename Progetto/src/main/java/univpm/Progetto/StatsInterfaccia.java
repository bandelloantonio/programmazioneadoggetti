package univpm.Progetto;

import java.util.ArrayList;

import org.json.JSONObject;

import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;

public interface StatsInterfaccia {
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data);
	/**
	 * @param coordinates
	 * @return le coordinate top left e botomright per formare un rettangolo identificativo 
	 */
	private Coordinate[] riconoscitore(JSONObject coordinates) {
		return null;
	}
}
