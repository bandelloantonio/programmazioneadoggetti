package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;
import univpm.Progetto.model.Informazioni;
import univpm.Progetto.util.funzionidelcontroller;
import java.util.ArrayList;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Classe controller che gestisce le chiamate
 * @author Antonio
 */
@RestController
public class Controller {
	private funzionidelcontroller gestore = new funzionidelcontroller();
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
}
