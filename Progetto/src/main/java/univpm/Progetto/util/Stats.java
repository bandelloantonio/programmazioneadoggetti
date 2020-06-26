package univpm.Progetto.util;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import univpm.Progetto.eccezioni.eccezioniEsterne;
import univpm.Progetto.model.Coordinate;
import univpm.Progetto.model.Informazioni;

/**
 * Classe per la gestione delle statistiche geografiche 
 * @author Antonio
 */
public class Stats implements StatsInterfaccia {
	/**
	 * Crea una lista di informazioni in base alle coordinate che vengono passate 
	 * 
	 * @param data il database contenente tutte le informazioni da verificare
	 * @param coordinates
	 * @return una lista di record informazioni che soddisfano l'appartenenza al bounding box
	 * @throws eccezioniEsterne 
	 */
	
	public ArrayList<Informazioni> funzione(JSONObject coordinates, ArrayList <Informazioni> data) throws eccezioniEsterne
	{
		Coordinate[] contenitore = riconoscitore(coordinates);
		ArrayList<Informazioni> lista = new ArrayList<Informazioni>();
		for(int i=0;i<data.size();i++) {
			if(contenitore[1].getLatitudine()<data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLatitudine()>data.get(i).getCoordinate().getLatitudine()&&contenitore[0].getLongitudine()<data.get(i).getCoordinate().getLongitudine()&&contenitore[1].getLongitudine()>data.get(i).getCoordinate().getLongitudine())
				lista.add(data.get(i));
		}
		return lista;
	}
	
	/**
	 * E' la funzione che riconosce dal JSON le coordinate limite della bounding box
	 * @param coordinates
	 * @return le coordinate dell'angolo sinistro altro e dell'angolo destro basso 
	 * @throws eccezioniEsterne 
	 */
	private Coordinate[] riconoscitore(JSONObject coordinates) throws eccezioniEsterne {
		
		Coordinate[] riconosciuto = new Coordinate[2];
		riconosciuto[0]=new Coordinate();
		try {
		JSONArray appoggio1 = coordinates.getJSONArray("angolo_sinistro_alto");
		riconosciuto[0].setLatitudine(appoggio1.getDouble(0));
		riconosciuto[0].setLongitudine(appoggio1.getDouble(1));
		riconosciuto[1]=new Coordinate();
		}catch(Exception e){
			throw new eccezioniEsterne(null, null);
		}
		JSONArray appoggio2 = coordinates.getJSONArray("angolo_destro_basso");
		riconosciuto[1].setLatitudine(appoggio2.getDouble(0));
		riconosciuto[1].setLongitudine(appoggio2.getDouble(1));
		return riconosciuto;
	}
}