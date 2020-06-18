package univpm.Progetto.model;

/**
 * Creo una classe per il salvataggio delle informazioni, che eredita la classe coordinate
 * @author Antonio
 */
public class Informazioni extends Coordinate{
	/**
	 * Il tipo di luogo
	 */
	private  String type_place;
	/**
	 * Il tipo di nome
	 */
	private  String name;
	/**
	 * Il tipo di nome completo
	 */
	private  String full_name;
	/**
	 * Il tipo di codice del paese 
	 */
	private  String country_code;
	/**
	 * Il tipo di paese
	 */
	private  String country;
	/**
	 * La funzione che permette di ottiene il tipo di luogo
	 * @return il tipo di luogo
	 */
	public String getType_place() {
		return type_place;
	}
	/**
	 * La funzione che permette di impostare il tipo di luogo
	 * @param Type_place il tipo di luogo da impostare
	 */
	public void setType_place(String type_place) {
		this.type_place = type_place;
	}
	/**
	 * La funzione che permette di ottenere il nome
	 * @return nome
	 */
	public String getName() {
		return name;
	}
	/**
	 * La funzione che permette di impostare il nome
	 * @param name il tipo di nome da impostare
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * La funzione che permette di ottenere il nome completo
	 * @return il nome completo 
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * La funzione che permette di impostare il nome completo
	 * @param full_name il tipo di nome completo da impostare
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * La funzione che permette di ottenere il codice del paese
	 * @return il codice del paese
	 */
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * La funzione che permette di impostare il codice del paese
	 * @param country_code il codice del paese da impostare
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	/**
	 * La funzione che permette di ottenere il paese
	 * @return il paese
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * La funzione che permette di impostare il paese
	 * @param country il paese da impostare
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
