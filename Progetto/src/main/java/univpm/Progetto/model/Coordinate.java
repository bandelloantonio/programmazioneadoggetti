package univpm.Progetto.model;

public class Coordinate {
	private long longitudine;
	private long latitudine;
	
	/**
	 * @param longitudine
	 * @param latitudine
	 */
	public Coordinate(long longitudine, long latitudine) {
		super();
		this.longitudine = longitudine;
		this.latitudine = latitudine;
	}
	/**
	 * @return the longitudine
	 */
	public long getLongitudine() {
		return longitudine;
	}
	/**
	 * @param longitudine the longitudine to set
	 */
	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}
	/**
	 * @return the latitudine
	 */
	public long getLatitudine() {
		return latitudine;
	}
	/**
	 * @param latitudine the latitudine to set
	 */
	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}

}
