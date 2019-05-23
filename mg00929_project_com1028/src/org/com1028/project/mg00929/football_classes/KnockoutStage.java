/**
 * KnockoutStage.java
 */
package org.com1028.project.mg00929.football_classes;

/**
 * The class is describing the properties and actions of a knock-out stage of a football competition.
 *
 * @author Milen Georgiev
 *
 */
public class KnockoutStage {
	/** The first team in the stage */
	private Team firstTeam = null;
	/** The second team in the stage */
	private Team secondTeam = null;
	/** The first match in the stage */
	private Match firstMatch = null;
	/** The second match in the stage */
	private Match secondMatch = null;
	/** The next stage following this one */
	private KnockoutStage nextStage = null;
	/** The previous stage of the first team */
	private KnockoutStage previousFirstTeamStage = null;
	/** The previous stage of the second team */
	private KnockoutStage previousSecondTeamStage = null;

	/**
	 * Parametrised constructor with known next stage and teams.
	 * Used to initialise first stages.
	 * @param nextStage
	 * @param firstTeam
	 * @param secondTeam
	 * @throws NullPointerException
	 */
	public KnockoutStage(KnockoutStage nextStage, Team firstTeam, Team secondTeam) throws NullPointerException {
		super();
		this.nextStage = nextStage;
		this.previousFirstTeamStage = null;
		this.previousSecondTeamStage = null;

		this.firstMatch = null;
		this.firstTeam = firstTeam;
		this.secondMatch = null;
		this.secondTeam = secondTeam;
	}

	/**
	 * Parametrised constructor with known next stage.
	 * Used to initialise intermediate stages.
	 * @param nextStage
	 * @throws NullPointerException
	 */
	public KnockoutStage(KnockoutStage nextStage) throws NullPointerException {
		super();
		this.nextStage = nextStage;
		this.previousFirstTeamStage = null;
		this.previousSecondTeamStage = null;

		this.firstMatch = null;
		this.firstTeam = null;
		this.secondMatch = null;
		this.secondTeam = null;
	}

	/**
	 * Default constructor initialising the fields.
	 * Used to initialise a final stage.
	 * @throws NullPointerException
	 */
	public KnockoutStage() throws NullPointerException {
		super();
		this.nextStage = null;
		this.previousFirstTeamStage = null;
		this.previousSecondTeamStage = null;

		this.firstMatch = null;
		this.firstTeam = null;
		this.secondMatch = null;
		this.secondTeam = null;
	}

	/**
	 * Getter of the first match
	 * @return the first match
	 */
	public Match getFirstMatch() {
		return this.firstMatch;
	}

	/**
	 * Getter of the first team
	 * @return the first team
	 */
	public Team getFirstTeam() {
		return this.firstTeam;
	}

	/**
	 * Getter of the second match
	 * @return the second match
	 */
	public Match getSecondMatch() {
		return this.secondMatch;
	}

	/**
	 * Getter of the second team
	 * @return the second team
	 */
	public Team getSecondTeam() {
		return this.secondTeam;
	}

	/**
	 * Getter of the next stage
	 * @return the next stage
	 */
	public KnockoutStage getNextStage() {
		return this.nextStage;
	}

	/**
	 * Getter of the previous stage of the first team
	 * @return the previous stage
	 */
	public KnockoutStage getPreviousFirstTeamStage() {
		return this.previousFirstTeamStage;
	}

	/**
	 * Getter of the previous stage of the second team
	 * @return the previous stage
	 */
	public KnockoutStage getPreviousSecondTeamStage() {
		return this.previousSecondTeamStage;
	}

	/**
	 * Setter for the next stage
	 * @param nextStage
	 */
	public void setNextStage(KnockoutStage nextStage) {
		this.nextStage = nextStage;
	}

	/**
	 * setter for the previous stage of the first stage
	 * @param previousFirstTeamStage
	 */
	public void setPreviousFirstTeamStage(KnockoutStage previousFirstTeamStage) {
		this.previousFirstTeamStage = previousFirstTeamStage;
	}

	/**
	 * setter for the previous stage of the second stage
	 * @param previousFirstTeamStage
	 */
	public void setPreviousSecondTeamStage(KnockoutStage previousSecondTeamStage) {
		this.previousSecondTeamStage = previousSecondTeamStage;
	}

	/**
	 * Adding a new team to the Knock-out Stage
	 * @param team
	 * @return was the adding successful
	 */
	public boolean addTeam(Team team) {
		boolean wasSuccessful = true;
		if (team == null) {
			wasSuccessful = false;
		} else if (this.firstTeam == null) {
			this.firstTeam = team;
		} else {
			if (this.secondTeam == null) {
				this.secondTeam = team;
			} else {
				wasSuccessful = false;
			}
		}

		return wasSuccessful;
	}

	/**
	 * Adding a match to the stage
	 * @param the match to be added
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void addMatch(Match match) throws NullPointerException, IllegalArgumentException {
		if (match == null) {
			throw new NullPointerException("Match must not be null!");
		}
		
		// If the teams from the match do not match the ones from the stage
		if (!(match.getHomeTeam() == this.firstTeam && match.getAwayTeam() == this.secondTeam
				|| match.getHomeTeam() == this.secondTeam && match.getAwayTeam() == this.firstTeam)) {
			throw new IllegalArgumentException("The teams in the match do not match these in the stage!");
		}
		
		// If the new match is the first one
		if (this.firstMatch == null ) {
			if (this.firstTeam == match.getHomeTeam()) {
				this.firstMatch = match;
			} else {
				throw new IllegalArgumentException("The first team must be the home team in the first match!");
			}
		} else if (this.secondMatch == null) {
			if (this.firstMatch.getHomeTeam() != match.getAwayTeam()) {
				throw new IllegalArgumentException("The home and away teams must be replaced in the second match!");
			}

			// Checking that the aggregate score is not equal.
			if (this.firstMatch.getHomeTeamGoals() + match.getAwayTeamGoals() == this.firstMatch.getAwayTeamGoals()
					+ match.getHomeTeamGoals()) {
				throw new IllegalArgumentException("The aggregate result must not be equal!");
			} else {
				this.secondMatch = match;
				if (!(this.nextStage == null)) {
					// The winner continues forward.
					this.nextStage.addTeam(this.getWinner());
				}
			}
		} else {
			throw new IllegalArgumentException("Both matches have already been added!");
		}
	}

	/**
	 * Getter for the winner of the specific stage.
	 * @return the winner
	 */
	public Team getWinner() {
		Team winner;

		if (this.secondMatch == null) {
			winner = null;
		} else if (this.firstMatch.getHomeTeamGoals() + this.secondMatch.getAwayTeamGoals() > this.firstMatch
				.getAwayTeamGoals() + this.secondMatch.getHomeTeamGoals()) {
			winner = this.firstMatch.getHomeTeam();
		} else {
			winner = this.firstMatch.getAwayTeam();
		}

		return winner;
	}
	
	/**
	 * Getter for the team that lost the stage
	 * @return the team that lost
	 */
	public Team getLoser() {
		Team loser;

		if (this.secondMatch == null) {
			loser = null;
		} else if (this.firstMatch.getHomeTeamGoals() + this.secondMatch.getAwayTeamGoals() > this.firstMatch
				.getAwayTeamGoals() + this.secondMatch.getHomeTeamGoals()) {
			loser = this.firstMatch.getAwayTeam();
		} else {
			loser = this.firstMatch.getHomeTeam();
		}

		return loser;
	}

	/**
	 * Overridden toString() method printing the matches in a specific format using the Padding class.
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		// Adding the first team.
		if (this.firstTeam == null) {
			buffer.append("NoDet");
		} else {
			buffer.append(this.firstTeam.getShortName() + " ");
		}

		// Adding the results of the matches.
		if (this.firstMatch == null) {
			buffer.append("   :   ");
		} else if (this.secondMatch == null) {
			buffer.append(Padding.padLeft(String.valueOf(this.firstMatch.getHomeTeamGoals()), 3) + ":"
					+ Padding.padRight(String.valueOf(this.firstMatch.getAwayTeamGoals()), 3));
		} else {
			buffer.append(Padding.padLeft(String.valueOf(this.firstMatch.getHomeTeamGoals()), 1) + "+"
					+ Padding.padRight(String.valueOf(this.secondMatch.getAwayTeamGoals()), 1) + ":"
					+ Padding.padLeft(String.valueOf(this.firstMatch.getAwayTeamGoals()), 1) + "+"
					+ Padding.padRight(String.valueOf(this.secondMatch.getHomeTeamGoals()), 1));
		}

		// Adding the second team.
		if (this.secondTeam == null) {
			buffer.append("NoDet");
		} else {
			buffer.append(" " + this.secondTeam.getShortName());
		}

		return buffer.toString();
	}

	/**
	 * Removing a team from the specific stage
	 * @param team
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void removeTeam(Team team) throws NullPointerException, IllegalArgumentException {
		if (team == null) {
			throw new NullPointerException("Team must not be null!");
		}
		if (this.firstTeam != team && this.secondTeam != team) {
			throw new IllegalArgumentException("The team is not participating in this knockout stage!");
		}
		if (this.firstTeam == null || this.secondTeam == null) {
			throw new IllegalArgumentException("The team is alone in its knock out stage!");
		}
		
		// If no matches have been played
		if (this.firstMatch == null && this.secondMatch == null) {
			if (this.firstTeam == team) {
				this.addMatch(new Match(team, this.secondTeam, 0, 3, team.getStadium()));
				this.addMatch(new Match(this.secondTeam, team, 3, 0, this.secondTeam.getStadium()));
			} else {
				this.addMatch(new Match(this.firstTeam, team, 3, 0, this.firstTeam.getStadium()));
				this.addMatch(new Match(team, this.firstTeam, 0, 3, team.getStadium()));
			}
		} 
		
		// If the first match has already been played
		else if (this.firstMatch != null && this.secondMatch == null) {
			if (this.firstTeam == team) {
				// Used to make sure the aggregate is at least 3 goals difference
				int firstMatchGoalDifference = this.firstMatch.getHomeTeamGoals() - this.firstMatch.getAwayTeamGoals();
				
				if (firstMatchGoalDifference <= 0) {
					this.addMatch(new Match(this.secondTeam, team, 3, 0, this.secondTeam.getStadium()));
				} else {
					this.addMatch(new Match(this.secondTeam, team, 3 + firstMatchGoalDifference, 0, this.secondTeam.getStadium()));
				}
			} else {
				int firstMatchGoalDifference = this.firstMatch.getAwayTeamGoals() - this.firstMatch.getHomeTeamGoals();
				
				if (firstMatchGoalDifference <= 0) {
					this.addMatch(new Match(team, this.secondTeam, 0, 3, team.getStadium()));
				} else {
					this.addMatch(new Match(team, this.secondTeam, 0, 3 + firstMatchGoalDifference, team.getStadium()));
				}
			}
		} else {
			throw new IllegalArgumentException("Cannot remove a team from an already finished stage!!");
		}

	}
}
