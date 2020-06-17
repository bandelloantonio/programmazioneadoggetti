package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.model.Informazioni;
import univpm.Progetto.util.funzionidelcontroller;

import java.util.ArrayList;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
	private funzionidelcontroller gestore= new funzionidelcontroller();
	@GetMapping("/dati")
	public ArrayList<Informazioni> getDati(){
		return gestore.getDatipercontroller();
	}
	@PostMapping("/statistica")
	public ArrayList<Informazioni> getStatistica(@RequestBody JSONObject coordinates){
		return gestore.getStatisticapercontroller(coordinates);
		
	}
}
 
