/**
 * Match.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * The class describes the action and state of a real-life football match.
 * @author Milen Georgiev
 *
 */
public class Match {
	/** The home team in the match */
	private Team homeTeam = null;
	/** The away team in the match */
	private Team awayTeam = null;
	/** The number of goals of the home team in the match */
	private int homeTeamGoals = 0;
	/** The number of goals of the away team in the match */
	private int awayTeamGoals = 0;
	/** The stadium in which the match was played */
	private Stadium stadium = null;

	/**
	 * A parametrised constructor initialising the match.
	 * @param homeTeam
	 * @param awayTeam
	 * @param homeTeamGoals
	 * @param awayTeamGoals
	 * @param stadium
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Match(Team homeTeam, Team awayTeam, int homeTeamGoals, int awayTeamGoals, Stadium stadium)
			throws NullPointerException, IllegalArgumentException {
		super();
		if (homeTeam == null) {
			throw new NullPointerException("Home team must not be null!");
		}
		if (awayTeam == null) {
			throw new NullPointerException("Away team must not be null");
		}
		if (homeTeam == awayTeam) {
			throw new IllegalArgumentException("Home team must be different from away team!");
		}
		if (homeTeamGoals < 0) {
			throw new IllegalArgumentException("Home team goals must not be negative!");
		}
		if (awayTeamGoals < 0) {
			throw new IllegalArgumentException("Away team goals must not be negative!");
		}
		if (stadium == null) {
			throw new NullPointerException("Stadium must not be null!");
		}

		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamGoals = homeTeamGoals;
		this.awayTeamGoals = awayTeamGoals;
		this.stadium = stadium;
	}

	/**
	 * Getter for the away team.
	 * @return away team
	 */
	public Team getAwayTeam() {
		return this.awayTeam;
	}

	/**
	 * Getter for the away team goals.
	 * @return away team goals
	 */
	public int getAwayTeamGoals() {
		return this.awayTeamGoals;
	}

	/**
	 * Getter for the home team.
	 * @return home team
	 */
	public Team getHomeTeam() {
		return this.homeTeam;
	}

	/**
	 * Getter for the home team goals.
	 * @return home team goals
	 */
	public int getHomeTeamGoals() {
		return this.homeTeamGoals;
	}

	/**
	 * Getter for the stadium.
	 * @return stadium
	 */
	public Stadium getStadium() {
		return this.stadium;
	}

}
