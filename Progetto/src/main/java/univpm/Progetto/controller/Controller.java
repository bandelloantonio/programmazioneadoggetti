package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.Utente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
	Utente UtenteRequest= new Utente();
	@GetMapping("/metadata")
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(UtenteRequest.fillup(),HttpStatus.OK);
	}
}

