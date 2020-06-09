package univpm.Progetto.controller;

import org.springframework.web.bind.annotation.RestController;

import univpm.Progetto.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
	User userRequest= new User();
	@GetMapping("/metadata")
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(userRequest.fillup(),HttpStatus.OK);
	}
}

