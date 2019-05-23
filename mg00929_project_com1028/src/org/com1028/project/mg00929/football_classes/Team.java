/**
 * Team.java
 */
package org.com1028.project.mg00929.football_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class describes the state and action of a football team.
 * 
 * @author Milen Georgiev
 *
 */
public class Team {
	/** The name of the team */
	private String name = null;
	/** The name of the team written shortly with only 4 letters */
	private String shortName = null;
	/** A list holding the players playing in the team */
	private List<Player> players = null;
	/** The manager of the team */
	private Manager manager = null;
	/** The stadium in which the team plays its home matches */
	private Stadium stadium = null;

	/**
	 * Parametrised constructor initialising the team.
	 * 
	 * @param shortName
	 * @param name
	 * @param manager
	 * @param stadium
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Team(String shortName, String name, Manager manager, Stadium stadium)
			throws NullPointerException, IllegalArgumentException {
		super();
		if (shortName == null) {
			throw new NullPointerException("Short name must not be null!");
		}
		if (shortName.length() != 4) {
			throw new IllegalArgumentException("Short name must be exaclly 4 symbols long!");
		}
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}
		if (stadium == null) {
			throw new NullPointerException("Stadium must not be null!");
		}

		this.shortName = shortName;
		this.name = name;
		this.manager = manager;

		// Setting the players.
		this.players = new ArrayList<Player>();
		this.stadium = stadium;
	}

	/**
	 * Getter for the manager.
	 * 
	 * @return manager
	 */
	public Manager getManager() {
		return this.manager;
	}

	/**
	 * Getter for the short name.
	 * 
	 * @return short name
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * Getter for the whole name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Checks whether a player is in the team.
	 * 
	 * @param player
	 * @return containsPlayer
	 * @throws NullPointerException
	 */
	public boolean containsPlayer(Player player) throws NullPointerException {
		if (player == null) {
			throw new NullPointerException("Player must not be null!");
		}
		return this.players.contains(player);
	}

	/**
	 * Getter for the stadium.
	 * 
	 * @return stadium
	 */
	public Stadium getStadium() {
		return this.stadium;
	}

	/**
	 * Add a player to the team.
	 * 
	 * @param player
	 * @return was successful
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {
		if (player == null) {
			throw new NullPointerException("Player must not be null!");
		}
		if (this.players.contains(player)) {
			throw new IllegalArgumentException("The team already contains the player!");
		}

		this.players.add(player);
	}

	/**
	 * Removes a player from the team.
	 * 
	 * @param player
	 * @return was successful
	 */
	public boolean removePlayer(Player player) {
		boolean wasSuccessfull = true;
		if (player == null) {
			wasSuccessfull = false;
		} else if (!this.players.contains(player)) {
			wasSuccessfull = false;
		} else {
			this.players.remove(player);
		}

		return wasSuccessfull;
	}

	/**
	 * Change the manager of the team.
	 * 
	 * @param manager
	 * @return was successful
	 */
	public boolean changeManager(Manager manager) {
		boolean wasSuccessfull = true;
		if (this.manager == manager) {
			wasSuccessfull = false;
		} else {
			this.manager = manager;
		}

		return wasSuccessfull;
	}

	/**
	 * Adds a match to a specific competition.
	 * 
	 * @param competition
	 * @param homeTeam
	 * @param awayTeam
	 * @param homeTeamGoals
	 * @param awayTeamGoals
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public static void playMatch(FootballCompetition competition, Team homeTeam, Team awayTeam, int homeTeamGoals,
			int awayTeamGoals) throws NullPointerException, IllegalArgumentException {
		if (competition == null || homeTeam == null || awayTeam == null) {
			throw new NullPointerException("The competition and the teams must not be null!");
		}
		if (homeTeam == awayTeam) {
			throw new IllegalArgumentException("Home and away team must be different!");
		}
		if (homeTeamGoals < 0 || awayTeamGoals < 0) {
			throw new IllegalArgumentException("The goals scored must be non-negative!");
		}

		competition.addPlayedMatch(new Match(homeTeam, awayTeam, homeTeamGoals, awayTeamGoals, homeTeam.getStadium()));
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name).append(" (").append(this.shortName).append(") ");

		if (this.manager != null) {
			buffer.append(this.manager.getName()).append(" ");
		} else {
			buffer.append("No manager ");
		}

		buffer.append(this.stadium.getName()).append(" [")
				.append(String.join(", ", this.players.stream().map(p -> p.getName()).collect(Collectors.toList())))
				.append("]\n");
		return buffer.toString();
	}
}
