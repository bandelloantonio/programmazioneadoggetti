package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.FetchCLASS;
import univpm.Progetto.Utente;
import univpm.Progetto.model.Informazioni;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
	Utente UtenteRequest= new Utente();
	@GetMapping("/metadata")
	public ArrayList<Informazioni> getMetadata() {
		FetchCLASS obj = new FetchCLASS();
		return obj.parsing();
	}
}
 
