package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */
@SuppressWarnings("serial")
public class MovimientosDTO implements Serializable {
	private int num, pp, power;
	private String name, type, categoryURL, accuracy;

	public MovimientosDTO() {
	}

	/**
	 * Constructor method
	 * 
	 * @param num
	 * @param pp
	 * @param power
	 * @param name
	 * @param type
	 * @param categoryURL
	 * @param accuracy
	 */
	public MovimientosDTO(int num, int pp, int power, String name, String type, String categoryURL, String accuracy) {
		super();
		this.name = name;
		this.num = num;
		this.pp = pp;
		this.power = power;
		this.type = type;
		this.categoryURL = categoryURL;
		this.accuracy = accuracy;
	}

	/**
	 * Method that gets and displays the attribute name
	 * 
	 * @return Attribute name value
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method that sets the attribute name
	 * 
	 * @param name Name of the movement
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that gets and displays the attribute num
	 * 
	 * @return attribute num value
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Method that sets the attribute num
	 * 
	 * @param num Number of the movement
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * Method that gets and displays the attribute pp
	 * 
	 * @return attribute pp value
	 */
	public int getPp() {
		return pp;
	}

	/**
	 * Method that sets the attribute pp
	 * 
	 * @param pp Number of pp
	 */
	public void setPp(int pp) {
		this.pp = pp;
	}

	/**
	 * Method that gets and displays the attribute power
	 * 
	 * @return attribute power value
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Method that sets the attribute power
	 * 
	 * @param power Number of power
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * Method that gets and displays the attribute Type
	 * 
	 * @return attribute Type value
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method that sets the attribute Type
	 * 
	 * @param type Movement type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method that gets and displays the attribute CategoryURL
	 * 
	 * @return attribute CategoryURL value
	 */
	public String getCategoryURL() {
		return categoryURL;
	}

	/**
	 * Method that sets the attribute CategoryURL
	 * 
	 * @param categoryURL Url of the movement category
	 */
	public void setCategoryURL(String categoryURL) {
		this.categoryURL = categoryURL;
	}

	/**
	 * Method that gets and displays the attribute Accuracy
	 * 
	 * @return attribute Accuracy value
	 */
	public String getAccuracy() {
		return accuracy;
	}

	/**
	 * Method that sets the attribute accuracy
	 * 
	 * @param accuracy Number of movement accuracy
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	/**
	 * toString method
	 * 
	 * @return values of the attributes movement object
	 */
	public String toString() {
		return "MovimientosDTO [num=" + num + ", pp=" + pp + ", power=" + power + ", name=" + name + ", type=" + type
				+ ", categoryURL=" + categoryURL + ", accuracy=" + accuracy + "]";
	}
}
