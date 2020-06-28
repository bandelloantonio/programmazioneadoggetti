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
	 * {@inheritDoc}
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
	 * @throws eccezioniEsterne
	 * @return le coordinate dell'angolo sinistro altro e dell'angolo destro basso 
	 */
	private Coordinate[] riconoscitore(JSONObject coordinates) throws eccezioniEsterne {
		
		Coordinate[] riconosciuto = new Coordinate[2];
		riconosciuto[0]=new Coordinate();
		JSONArray appoggio1;
		String errore = null;
		try {
		appoggio1 = coordinates.getJSONArray("angolo_sinistro_alto");
		}catch(Exception e){
			throw new eccezioniEsterne("angolo_sinistro_alto");
		}
		try {
		errore=appoggio1.getDouble(0)+", "+appoggio1.getDouble(1);
		riconosciuto[0].setLatitudine(appoggio1.getDouble(0));
		riconosciuto[0].setLongitudine(appoggio1.getDouble(1));
		}catch(Exception e){
			throw new eccezioniEsterne("angolo_sinistro_alto",errore);
		}
		Controllo(riconosciuto[0]);
		JSONArray appoggio2;
		try {
		appoggio2 = coordinates.getJSONArray("angolo_destro_basso");
		riconosciuto[1]=new Coordinate();
		}catch(Exception e) {
			throw new eccezioniEsterne("angolo_destro_basso");
		}
		errore = new String();
		try {
			errore=appoggio2.getDouble(0)+", "+appoggio2.getDouble(1);
		riconosciuto[1].setLatitudine(appoggio2.getDouble(0));
		riconosciuto[1].setLongitudine(appoggio2.getDouble(1));
		}catch(Exception e) {
			throw new eccezioniEsterne("angolo_destro_basso",errore);
			
		}
		Controllo(riconosciuto[1]);
		return riconosciuto;
	}
	/**
	 * Funzione per il controllo dei valori immessi
	 * @param daverificare la coordinata da sottoporre a verifica del rispetto del range
	 */
	private void Controllo (Coordinate daverificare) {
		if(daverificare.getLatitudine()<-90||daverificare.getLatitudine()>90)
			throw new eccezioniEsterne(daverificare.getLatitudine(),"della latitudine (-90,90)");
		if(daverificare.getLongitudine()<-180||daverificare.getLongitudine()>180)
			throw new eccezioniEsterne(daverificare.getLongitudine(),"della longitudine (-180,180)");
	}
}