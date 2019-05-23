/**
 * TeamStatistics.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * This class holds all the needed data about a specific team participating in a
 * football league.
 * 
 * @author Milen Georgiev
 *
 */
public class TeamStatistics {
	/** Count of played matches */
	private int matchesPlayed = 0;
	/** Count of scored goals */
	private int goalsScored = 0;
	/** Count of conceded goals */
	private int goalsConceded = 0;
	/** Count of total points */
	private int totalPoints = 0;

	/**
	 * Default constructor. Initialises the fields.
	 */
	public TeamStatistics() {
		super();
		this.matchesPlayed = 0;
		this.goalsConceded = 0;
		this.goalsScored = 0;
		this.totalPoints = 0;
	}

	/**
	 * Getter for the played matches
	 * 
	 * @return count of matches
	 */
	public int getMatchesPlayed() {
		return this.matchesPlayed;
	}

	/**
	 * Getter for total point.
	 * 
	 * @return total points
	 */
	public int getTotalPoints() {
		return this.totalPoints;
	}

	/**
	 * Calculates the goals difference and returns it.
	 * 
	 * @return goal-difference
	 */
	public int getGoalDifference() {
		return this.goalsScored - this.goalsConceded;
	}

	/**
	 * Adds data about a played match.
	 * 
	 * @param goalsScored
	 * @param goalsConceded
	 * @throws IllegalArgumentException
	 */
	public void addMatch(int goalsScored, int goalsConceded) throws IllegalArgumentException {
		if (goalsScored < 0 || goalsConceded < 0) {
			throw new IllegalArgumentException("The goals must not be negative!");
		}

		if (goalsScored > goalsConceded) {
			this.totalPoints += 3;
		} else if (goalsScored == goalsConceded) {
			this.totalPoints += 1;
		}

		this.goalsScored += goalsScored;
		this.goalsConceded += goalsConceded;
		this.matchesPlayed++;
	}

	/**
	 * Removes the data about a specific match.
	 * 
	 * @param goalsScored
	 * @param goalsConceded
	 * @throws IllegalArgumentException
	 */
	public void removeMatch(int goalsScored, int goalsConceded) throws IllegalArgumentException {
		if (goalsScored < 0 || goalsConceded < 0) {
			throw new IllegalArgumentException("The goals must not be negative!");
		}

		if (goalsScored > goalsConceded) {
			this.totalPoints -= 3;
		} else if (goalsScored == goalsConceded) {
			this.totalPoints -= 1;
		}

		this.goalsScored -= goalsScored;
		this.goalsConceded -= goalsConceded;
		this.matchesPlayed--;
	}

	/**
	 * Overridden toString() method. Used to print the table of a league.
	 */
	@Override
	public String toString() {
		return Padding.padLeft(String.valueOf(this.matchesPlayed), 4)
				+ Padding.padLeft(String.valueOf(this.goalsScored), 4)
				+ Padding.padLeft(String.valueOf(this.goalsConceded), 4)
				+ Padding.padLeft(String.valueOf(this.getGoalDifference()), 4)
				+ Padding.padLeft(String.valueOf(this.totalPoints), 4) + "\n";
	}
}
