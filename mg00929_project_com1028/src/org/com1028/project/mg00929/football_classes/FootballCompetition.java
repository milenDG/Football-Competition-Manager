/**
 * FootballCompetition.java
 */
package org.com1028.project.mg00929.football_classes;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is describing the properties and actions of a football competition - an abstract class.
 * @author Milen Georgiev
 *
 */
public abstract class FootballCompetition {
	/** Regex matching a string containing a name. */
	private static final String NAME_REGEX = "[A-Z][a-z]+( [A-Z][a-z]+)*";
	/** The name of the football competition */
	private String name = null;
	/** The country of the football competition */
	private String country = null;
	/** All the teams in the football competition */
	protected List<Team> teams = null;
	/** The removed teams from the competition */
	protected List<Team> removedTeams = null;

	/**
	 * Parametrised constructor of the class.
	 * Initialises the fields.
	 * @param name
	 * @param country
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public FootballCompetition(String name, String country, List<Team> teams) throws NullPointerException, IllegalArgumentException {
		super();
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}
		if (!name.matches(FootballCompetition.NAME_REGEX)) {
			throw new IllegalArgumentException("Name must contain only words starting with a capital letter!");
		}
		if (country == null) {
			throw new NullPointerException("Country must not be null!");
		}
		if (!country.matches(FootballCompetition.NAME_REGEX)) {
			throw new IllegalArgumentException("Country must contain only words starting with a capital letter!");
		}
		if (teams == null) {
			throw new NullPointerException("Teams must not be null!");
		}

		this.name = name;
		this.country = country;
		this.teams = teams;
		this.removedTeams = new ArrayList<Team>();
	}

	/**
	 * Adding a played match to the competition
	 * @param match
	 */
	public abstract void addPlayedMatch(Match match);

	/**
	 * Ending the competition.
	 * @return The winner if the competition has ended.
	 */
	public String endCompetition() {
		String message = null;
		if (this.hasEnded()) {
			message = "The competition ended and the winner is: " + this.getWinnerName();
		}

		return message;
	}

	/**
	 * Getter for all the teams, which are still in the competition.
	 * @return
	 */
	public String[] getTeamNames() {
		String[] teamNames = new String[this.teams.size() - this.removedTeams.size()];
		
		int index = 0;
		for (Team team : this.teams) {
			if (!this.removedTeams.contains(team)) {
				teamNames[index++] = team.getName();
			}
		}
		
		return teamNames;
	}

	/**
	 * Get the needed information about the competition.
	 * @return
	 */
	public abstract String getCompetitionInformation();

	/**
	 * Getter for the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the country.
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Decides who the winner is and returns it.
	 * @return the winner
	 */
	protected abstract String getWinnerName();

	/**
	 * Has the competition ended
	 * @return
	 */
	public abstract boolean hasEnded();

	/**
	 * Removes a team from the competition.
	 * @param team
	 */
	public abstract void removeTeam(Team team);

	/**
	 * Overridden toString() method, returns information about the competition.
	 */
	@Override
	public String toString() {
		return this.getName() + " " + this.getCountry() + " ["
				+ String.join(", ", this.getTeamNames()) + "] ";
	}
}
