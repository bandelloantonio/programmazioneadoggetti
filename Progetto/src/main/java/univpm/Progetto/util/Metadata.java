package univpm.Progetto.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import univpm.Progetto.eccezioni.eccezioniInterne;

public class Metadata {
	private HashMap<String,String> SingoloMetadati;
	private ArrayList<HashMap<String,String>> Metadati = new ArrayList<HashMap<String,String>>();
	public Metadata() throws eccezioniInterne {
		//lettura di informazioni.txt
		String line = new String();
		BufferedReader lettore;
		try {
			lettore = new BufferedReader(new FileReader("Informazioni.txt"));
			while ((line = lettore.readLine()) != null) {
				SingoloMetadati = new HashMap<String, String>();
				String[] campi = line.split(";");
				SingoloMetadati.put("Variabile",campi[0]);
				SingoloMetadati.put("Significato",campi[1]);
				SingoloMetadati.put("tipo variabile", campi[2]);
				Metadati.add(SingoloMetadati);
			}
			
		} catch (FileNotFoundException e) {
			throw new eccezioniInterne("Informazioni.txt");
		} catch (IOException e) {
			throw new eccezioniInterne();
		}
	}
	/**
	 * @return the metadati
	 */
	public ArrayList<HashMap<String,String>> getMetadati() {
		return Metadati;
	}

}
