/**
 * Stadium.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * This class describes the state and action of a football stadium.
 * @author Milen Georgiev
 *
 */
public class Stadium {
	/** A regex matching a name - words starting only with capital letters */
	private static final String NAME_REGEX = "[A-Z][a-z]+( [A-Z][a-z]+)*";
	/** The name of the stadium */
	private String name = null;
	/** The country, where the stadium is located */
	private String country = null;
	/** The capacity of people which the stadium can hold in a match */
	private int capacity = 0;
	/** The address of the stadium */
	private String address = null;

	/**
	 * Parametrised constructor for the class. Initialises teh fields.
	 * @param name
	 * @param country
	 * @param capacity
	 * @param address
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Stadium(String name, String country, int capacity, String address)
			throws NullPointerException, IllegalArgumentException {
		super();
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}
		if (!name.matches(Stadium.NAME_REGEX)) {
			throw new IllegalArgumentException(
					"Name must consist only names with a capital letter separated by a space!");
		}
		if (country == null) {
			throw new NullPointerException("Country must not be null!");
		}
		if (!country.matches(Stadium.NAME_REGEX)) {
			throw new IllegalArgumentException(
					"All words int the name of the country must start with a capital letter!");
		}
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		if (address == null) {
			throw new NullPointerException("Address must not be null!");
		}
		if (address.isBlank()) {
			throw new IllegalArgumentException("Address muss not be blank!");
		}
		
		this.name = name;
		this.country = country;
		this.capacity = capacity;
		this.address = address;
	}
	
	/**
	 * Getter for the address.
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Getter for the capacity.
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * Getter for the country.
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Getter for the name.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name).append(" ").append(this.country).append(" ").append(this.capacity).append(" ").append(this.address).append("\n");
		return buffer.toString();
	}
}
