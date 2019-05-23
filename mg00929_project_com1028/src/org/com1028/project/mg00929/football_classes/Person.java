/**
 * Person.java
 */
package org.com1028.project.mg00929.football_classes;

import java.time.LocalDate;
import java.time.Period;

/**
 * The class is describing the properties and actions of a real-life person, which is an abstract class.
 * @author Milen Georgiev
 *
 */
public abstract class Person {
	/** Regex matching a string containing a name. */
	private static final String NAME_REGEX = "[A-Z][a-z]+( [A-Z][a-z]+)*";
	/** The name of the person */
	private String name = null;
	/** The date of birth of the person*/
	private LocalDate dateOfBirth = null;
	/** The nationality of the person*/
	private String nationality = null;
	/** The football team, related to the person*/
	private Team team = null;

	/** Constructor
	 * Initialises the fields of the person, without its team.
	 * @param name
	 * @param dateOfBirth
	 * @param nationality
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Person(String name, LocalDate dateOfBirth, String nationality)
			throws IllegalArgumentException, NullPointerException {
		super();
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}
		if (!name.matches(Person.NAME_REGEX)) {
			throw new IllegalArgumentException(
					"Name must consist only names with a capital letter separated by a space!");
		}
		if (dateOfBirth == null) {
			throw new NullPointerException("DateOfBirth must not be null!");
		}
		if (dateOfBirth.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("DateOfBirth must be befor today's date!");
		}
		if (nationality == null) {
			throw new NullPointerException("Nationality must not be null!");
		}
		if (!nationality.matches(Person.NAME_REGEX)) {
			throw new IllegalArgumentException(
					"Nationality must start with a capital letter and include other only lowercase letters!");
		}

		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}

	/**
	 * Getter of the age.
	 * @return the age of the Person
	 */
	public int getAge() {
		return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
	}

	/**
	 * Getter of the name.
	 * @return the name of the Person
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter of the nationality.
	 * @return the nationality of the Person
	 */
	public String getNationality() {
		return this.nationality;
	}

	/**
	 * Getter of the team.
	 * @return the team of the Person
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * Setter of the team.
	 * @param team
	 */
	public void setTeam(Team team){
		this.team = team;
	}

	/**
	 * Overridden toString() method, returning data about the person in a specific format.
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name + " ")
				.append(this.getAge() + " ").append(this.nationality + " ")
				.append(" ");
		if (this.team == null) {
			buffer.append("No Team").append(" ");
		}else {
			buffer.append(this.team.getName()).append(" ");
		}
		
		return buffer.toString();
	}

}
