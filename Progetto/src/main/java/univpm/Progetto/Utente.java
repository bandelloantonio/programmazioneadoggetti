package univpm.Progetto;

import java.util.Vector;

import org.json.JSONArray;
import univpm.Progetto.model.Informazioni;

public class Utente {
	
	public Vector <Utente> fillup() {
		FetchCLASS FetchObject = new FetchCLASS();
		JSONArray  jArray = FetchObject.parsing();
		Vector<Informazioni>userVector = new Vector<Informazioni>();

				Informazioni temp;
				
				for(int i=0;i<jArray.length();i++) {
					temp= new Informazioni();
				
				temp.setType_place(jArray.getJSONObject(i).getString("type_place"));
				temp.setName(jArray.getJSONObject(i).getString("name"));
				temp.setFull_name(jArray.getJSONObject(i).getString("full_name"));
				temp.setCountry_code(jArray.getJSONObject(i).getString("country_code"));
				temp.setCountry(jArray.getJSONObject(i).getString("country"));
				userVector.add(temp);
				}
				return null;
			
		
	}

}
