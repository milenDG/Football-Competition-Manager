/**
 * League.java
 */
package org.com1028.project.mg00929.football_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class is describing the properties and actions of a league football
 * competition. It inherits from FootballCompetition and extends it.
 * 
 * @author Milen Georgiev
 *
 */
public class League extends FootballCompetition {
	/** A map holding the data about the statistics of each team in the league */
	private Map<Team, TeamStatistics> teamStatistics = null;
	/** List of all the played matches in the competition */
	private List<Match> playedMatches = null;

	/**
	 * A parametrised constructor of the class. Initialises the fields and creates
	 * the league table with no played matches.
	 * 
	 * @param name
	 * @param country
	 * @param teams
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public League(String name, String country, List<Team> teams) throws NullPointerException, IllegalArgumentException {
		super(name, country, teams);
		if (teams == null) {
			throw new NullPointerException("Teams must not be null!");
		}
		if (teams.size() < 2) {
			throw new IllegalArgumentException("The teams must be at least 2!");
		}
		this.teams = teams;
		this.teamStatistics = new HashMap<Team, TeamStatistics>();
		this.playedMatches = new ArrayList<Match>();

		// Creates a new empty statistics for each team.
		for (Team team : this.teams) {
			this.teamStatistics.put(team, new TeamStatistics());
		}

		// Sorts the teams alphabetically.
		Collections.sort(this.teams, new LeagueTeamsComparator());
	}

	/**
	 * A comparator for the teams in the league.
	 * 
	 * @author Milen Georgiev
	 *
	 */
	public class LeagueTeamsComparator implements Comparator<Team> {

		/**
		 * First checks the total points, then the goal-difference and finally compares
		 * them alphabetically.
		 */
		@Override
		public int compare(Team team1, Team team2) {
			// If the teams are removed then they must go to the end of the table.
			if (removedTeams.contains(team1) && removedTeams.contains(team2)) {
				return 0;
			}
			if (removedTeams.contains(team1)) {
				return 1;
			}
			if (removedTeams.contains(team2)) {
				return -1;
			}
			int team1TotalPoints = teamStatistics.get(team1).getTotalPoints();
			int team2TotalPoints = teamStatistics.get(team2).getTotalPoints();
			int team1GoalDifference = teamStatistics.get(team1).getGoalDifference();
			int team2GoalDifference = teamStatistics.get(team2).getGoalDifference();

			if (team1TotalPoints > team2TotalPoints) {
				return -1;
			} else if (team1TotalPoints < team2TotalPoints) {
				return 1;
			} else if (team1GoalDifference > team2GoalDifference) {
				return -1;
			} else if (team1GoalDifference < team2GoalDifference) {
				return 1;
			} else {
				return team1.getName().compareToIgnoreCase(team2.getName());
			}
		}

	}

	@Override
	public void addPlayedMatch(Match match) throws NullPointerException, IllegalArgumentException {
		if (match == null) {
			throw new NullPointerException("Match must not be null!");
		}
		if (!this.teams.contains(match.getHomeTeam()) || !this.teams.contains(match.getAwayTeam())) {
			throw new IllegalArgumentException("The league does not contain the teams!");
		}
		if (this.removedTeams.contains(match.getHomeTeam()) || this.removedTeams.contains(match.getAwayTeam())) {
			throw new IllegalArgumentException("Some of the teams have been removed from the league!");
		}
		for (Match playedMatch : this.playedMatches) {
			if (playedMatch.getHomeTeam() == match.getHomeTeam() && playedMatch.getAwayTeam() == match.getAwayTeam()) {
				throw new IllegalArgumentException("The match has already been played!");
			}
		}

		this.playedMatches.add(match);
		this.teamStatistics.get(match.getHomeTeam()).addMatch(match.getHomeTeamGoals(), match.getAwayTeamGoals());
		this.teamStatistics.get(match.getAwayTeam()).addMatch(match.getAwayTeamGoals(), match.getHomeTeamGoals());
		Collections.sort(this.teams, new LeagueTeamsComparator());
	}

	@Override
	public String getCompetitionInformation() {
		StringBuffer buffer = new StringBuffer();

		int teamsSize = this.teams.size();
		buffer.append(" #   " + Padding.padLeft("Team Name", 20) + "   " + " MP  GS  GC  GD  TP\n");

		// There are teams in the league, which are removed and although they are
		// supposed to be in the end of the list of teams, this variable is even more
		// assuring that the numbers of positions in the league table will be correct.
		int removedTeams = 0;
		for (int i = 0; i < teamsSize; i++) {
			Team currentTeam = teams.get(i);
			if (this.removedTeams.contains(currentTeam)) {
				removedTeams++;
				continue;
			}
			// Remove the count of the removed teams so the position number is correct.
			buffer.append(Padding.padLeft((String.valueOf(i + 1 - removedTeams)), 2) + ". "
					+ Padding.padLeft(currentTeam.getName(), 20) + " : "
					+ this.teamStatistics.get(currentTeam).toString());
		}

		return buffer.toString();
	}

	@Override
	protected String getWinnerName() {
		if (this.hasEnded()) {
			return this.teams.get(0).getName();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasEnded() {
		boolean hasEnded = false;
		int teamsCount = this.teams.size() - this.removedTeams.size();
		// Each team plays against each other 2 times.
		if (this.playedMatches.size() == teamsCount * (teamsCount - 1)) {
			hasEnded = true;
		}
		return hasEnded;
	}

	@Override
	public void removeTeam(Team team) throws NullPointerException, IllegalArgumentException {
		if (this.hasEnded()) {
			throw new IllegalArgumentException("The league has already ended!");
		}
		if (this.teams.size() - this.removedTeams.size() == 2) {
			throw new IllegalArgumentException("The league has only 2 teams!");
		}
		if (team == null) {
			throw new NullPointerException("Team must not be null!");
		}
		if (!this.teams.contains(team) || this.removedTeams.contains(team)) {
			throw new IllegalArgumentException("The team is not in the league or has been removed!");
		}

		// Create a list of the matches to be removed, because removing them while
		// iterating would lead to an exception.
		List<Match> toBeRemoved = new ArrayList<Match>();
		for (Match match : this.playedMatches) {
			if (match.getHomeTeam() == team || match.getAwayTeam() == team) {
				this.removeMatch(match);
				toBeRemoved.add(match);
			}
		}

		this.playedMatches.removeAll(toBeRemoved);

		this.teamStatistics.remove(team);
		this.removedTeams.add(team);

		// Updating the league table, because of the removed team.
		Collections.sort(this.teams, new LeagueTeamsComparator());
	}

	/**
	 * Auxiliary method for the removeTeam() method.
	 * Removes a match from the competition.
	 * @param match
	 * @return whether the removal was successful
	 */
	private boolean removeMatch(Match match) {
		boolean wasSuccessful = true;

		if (match == null) {
			wasSuccessful = false;
		} else {
			this.teamStatistics.get(match.getHomeTeam()).removeMatch(match.getHomeTeamGoals(),
					match.getAwayTeamGoals());
			this.teamStatistics.get(match.getAwayTeam()).removeMatch(match.getAwayTeamGoals(),
					match.getHomeTeamGoals());

		}

		return wasSuccessful;
	}

	@Override
	public String toString() {
		return "[League] " + super.toString();
	}

}
