package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.FetchCLASS;
import univpm.Progetto.Utente;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
	Utente UtenteRequest= new Utente();
	@GetMapping("/metadata")
	public JSONArray getMetadata() {
		FetchCLASS obj = new FetchCLASS();
		return obj.parsing();
	}
}
 
