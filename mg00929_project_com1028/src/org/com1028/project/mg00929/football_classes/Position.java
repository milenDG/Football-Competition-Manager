/**
 * Position.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * An enumeration defining the possible postition of a football player.
 * @author Milen Georgiev
 *
 */
public enum Position {
	GOALKEEPER("Goalkeeper"),
	DEFENDER("Defender"),
	MIDFIELDER("Midfielder"),
	FORWARD("Forward");
	
	/**
	 * String version of the name not containing only capital letters.
	 */
	private String name = null;
	
	/**
	 * Parametrised constructor, initialises the name of the position.
	 * @param name
	 */
	private Position(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for the name of the position.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
}
