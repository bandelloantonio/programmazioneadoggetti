package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;
import univpm.Progetto.eccezioni.eccezioniEsterne;
import univpm.Progetto.model.Informazioni;
import univpm.Progetto.service.funzionidelController;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Classe controller che gestisce le chiamate
 * @author Antonio
 */
@RestController
public class Controller {
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
 * @return database filtrato
 */
	@PostMapping("/statistica")
	public ArrayList<Informazioni> getStatistica(@RequestBody String coordinates) {
		JSONObject json = new JSONObject(coordinates);
		return gestore.getStatisticapercontroller(json);

	}
/**
 * Con la rotta "/metadata" l'utente richiede e ottiene tutte le informazioni su come per poter analizzare i dati
 * @return database
 */
   @GetMapping("/metadata")
   public ArrayList<Informazioni> getMetadati(){
   return gestore.VisualizzaMetadata();
   }
  @ExceptionHandler(eccezioniEsterne.class)
  public ResponseEntity<Object> gestioneEccezioniEsterne(){
	  eccezioniEsterne erroregenerato = new eccezioniEsterne(Calendar.getInstance(),"Le coordinate inserite presentano dei problemi in lettura, non sono scritte correttamente.\n La forma corretta è:\r\n"+
            "{\r\n" +
	  		"    \"angolo_sinistro_alto\":\r\n" + 
			"    [\r\n" + 
	  		"        num1\r\n" + 
	  		"        num2\r\n" + 
	  		"    ],\r\n" + 
	  		"    \"angolo_destro_basso\":\r\n" + 
	  		"    [\r\n" + 
	  		"        num3\r\n" + 
	  		"        num4\r\n" + 
	  		"    ]\r\n" + 
	  		"}");
	return new ResponseEntity<>(erroregenerato,HttpStatus.BAD_REQUEST);
	  
  }

 }
