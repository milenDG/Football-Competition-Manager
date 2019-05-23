/**
 * Manager.java
 */
package org.com1028.project.mg00929.football_classes;

import java.time.LocalDate;

/**
 * The class is describing the properties and actions of a football manager.
 * It inherits from Person and extends it.
 * @author Milen Georgiev
 *
 */
public class Manager extends Person {
	/** The tactics of the manager. */
	private String tactics = null;

	/**
	 * Parametrised constructor, creating an instance of a Manager.
	 * @param name
	 * @param dateOfBirth
	 * @param nationality
	 * @param tactics
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Manager(String name, LocalDate dateOfBirth, String nationality,
			String tactics) throws NullPointerException, IllegalArgumentException {
		super(name, dateOfBirth, nationality);
		if (tactics == null) {
			throw new NullPointerException("Tactics must not be null!");
		}
		if (tactics.isBlank()) {
			throw new IllegalArgumentException("Tactics must not be an empty string!");
		}
		
		this.tactics = tactics;
	}

	/**
	 * Getter for the tactics of the manager.
	 * @return the tactics.
	 */
	public String getTactics() {
		return this.tactics;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.tactics + "\n";
	}
}
