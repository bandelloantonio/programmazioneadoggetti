package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.Definizione;
import univpm.Progetto.Stats;
import univpm.Progetto.model.Informazioni;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
	Definizione DefinizioneRequest= new Definizione();
	@GetMapping("/dati")
	public ArrayList<Informazioni> getMetadata() {
		Definizione obj = new Definizione();
		return obj.parsing();
	}
	@PostMapping("/statistica")
	public ArrayList<Informazioni> getStatistica(@RequestBody JSONObject coordinates){
		Stats statistiche = new Stats();
		return statistiche.funzione(coordinates);
		return null;
	}
}
 
