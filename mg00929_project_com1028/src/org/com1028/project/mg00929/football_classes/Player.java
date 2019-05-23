/**
 * Player.java
 */
package org.com1028.project.mg00929.football_classes;

import java.time.LocalDate;

/**
 * The class is describing the properties and actions of a football player.
 * It inherits from Person and extends it.
 * @author Milen Georgiev
 *
 */
public class Player extends Person {

	/** The position in the football field of the player */
	private Position postition = null;

	/**
	 * A parametrised constructor of the player. Initialises its fields.
	 * @param name
	 * @param dateOfBirth
	 * @param nationality
	 * @param position
	 * @throws NullPointerException
	 */
	public Player(String name, LocalDate dateOfBirth, String nationality,
			Position position) throws NullPointerException {
		super(name, dateOfBirth, nationality);

		if (position == null) {
			throw new NullPointerException("Position must not be null!");
		}

		this.postition = position;
	}

	/**
	 * Getter for the position of the player.
	 * @return position
	 */
	public Position getPostition() {
		return this.postition;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.postition.getName() + "\n";
	}

}
