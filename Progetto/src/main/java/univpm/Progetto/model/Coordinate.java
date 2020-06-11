package univpm.Progetto.model;

public class Coordinate {
	private Double longitudine;
	private Double latitudine;

	/**
	 * @param longitudine
	 * @param latitudine
	 */
	public void setCoordinate(String appo) {
		appo=appo.substring(1, appo.length()-2);
		this.longitudine = Double.parseDouble(appo.split(",")[1]);
		this.latitudine = Double.parseDouble(appo.split(",")[0]);
	}

	/**
	 * @return the longitudine
	 */
	public Double getLongitudine() {
		return longitudine;
	}
	/**
	 * @param longitudine the longitudine to set
	 */
	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}
	/**
	 * @return the latitudine
	 */
	public Double getLatitudine() {
		return latitudine;
	}
	/**
	 * @param latitudine the latitudine to set
	 */
	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}
	
}