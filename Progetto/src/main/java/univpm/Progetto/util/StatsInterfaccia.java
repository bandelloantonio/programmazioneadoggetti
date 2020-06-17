package univpm.Progetto.util;

import java.util.ArrayList;

import org.json.JSONObject;

import univpm.Progetto.model.Informazioni;

public interface StatsInterfaccia {
	
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data);
}
