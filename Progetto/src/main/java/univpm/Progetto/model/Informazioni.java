package univpm.Progetto.model;

/**
 * creo una classe ereditarietà nella quale genero i get e i set
 * @author Antonio
 */
public class Informazioni extends Coordinate{
	
	private  String type_place;
	private  String name;
	private  String full_name;
	private  String country_code;
	private  String country;
	private  Coordinate coordinate;
	/**
	 * @return the type_place
	 */
	public String getType_place() {
		return type_place;
	}
	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	/**
	 * @param type_place the type_place to set
	 */
	public void setType_place(String type_place) {
		this.type_place = type_place;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
