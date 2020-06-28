package univpm.Progetto.controller;


import univpm.Progetto.eccezioni.*;
import univpm.Progetto.model.Informazioni;
import univpm.Progetto.service.funzionidelController;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Classe controller che gestisce le chiamate
 * @author Antonio
 */
@RestController
public class Controller {
	/**
	 * Il gestore ha il compito di eseguire le funzioni richieste 
	 */
	@Autowired
	private funzionidelController gestore;
/**
 * Con la rotta "/dati" l'utente richiede e ottiene tutte le informazioni 
 * @return database 
 */
	@GetMapping("/dati")
	public ArrayList<Informazioni> getDati() {
		return gestore.getDatipercontroller();
	}
/**
 * Con la rotta "/statistica" l'utente richiede e ottiene tutte le informazioni che soddisfano l'appartenenza 
 * di una regione definita da una coppia di coordinate
 * @param coordinates in formato JSON la coppia di coordinate
 * @throws eccezioniEsterne  
 * @return database filtrato
 */
	@PostMapping("/statistica")
	public ArrayList<Informazioni> getStatistica(@RequestBody String coordinates) throws eccezioniEsterne {
		JSONObject json = new JSONObject(coordinates);
		return gestore.getStatisticapercontroller(json);

	}
/**
 * Con la rotta "/metadata" l'utente richiede e ottiene tutte le informazioni su come per poter analizzare i dati
 * @return database
 */
   @GetMapping("/metadata")
   public ArrayList<HashMap<String, String>> getMetadati(){
   return gestore.VisualizzaMetadata();
   }
   /**
    * Il gestore delle eccezzioni sollevate a causa di una richiesta incorretta
    * @return errore
    */
  @ExceptionHandler(eccezioniEsterne.class)
  public ResponseEntity<Object> gestioneEccezioniEsterne(eccezioniEsterne erroregenerato){
	  Erroremostrato risposta = new Erroremostrato(erroregenerato.getIstante(), erroregenerato.getErrorepresente());
	return new ResponseEntity<Object>(risposta,HttpStatus.BAD_REQUEST);
  }

 }
