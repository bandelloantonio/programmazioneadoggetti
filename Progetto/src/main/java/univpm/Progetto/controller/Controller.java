package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.Definizione;
import univpm.Progetto.model.Informazioni;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
	Definizione DefinizioneRequest= new Definizione();
	@GetMapping("/metadata")
	public ArrayList<Informazioni> getMetadata() {
		Definizione obj = new Definizione();
		return obj.parsing();
	}
}
 
