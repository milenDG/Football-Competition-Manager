/**
 * Knockout.java
 */
package org.com1028.project.mg00929.football_classes;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * The class is describing the properties and actions of a knock-out football competition.
 * It inherits from FootballCompetition and extends it.
 * @author Milen Georgiev
 *
 */
public class Knockout extends FootballCompetition {
	/** The possible count of teams in the competition */
	private static final int[] POSSIBLE_TEAMS_COUNT = { 2, 4, 8, 16, };
	/** Has the match in the addMatch() method been added */
	private boolean hasMatchBeenAdded = false;
	/** Competition information returned by the getCompetitionInformation() */
	private StringBuffer competitionInformation = null;
	/** Was the team removed by the removeTeam() method */
	private boolean wasTeamRemoved = false;
	/** The final stage of the competition */
	private KnockoutStage finalStage = null;

	/**
	 * A parametrised constructor for the class. Initialises the class.
	 * @param name
	 * @param country
	 * @param teams
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Knockout(String name, String country, List<Team> teams)
			throws NullPointerException, IllegalArgumentException {
		super(name, country, teams);
		if (teams == null) {
			throw new NullPointerException("Teams must not be null!");
		}
		if (!IntStream.of(Knockout.POSSIBLE_TEAMS_COUNT).anyMatch(x -> x == teams.size())) {
			throw new IllegalArgumentException("The count of the teams must be a power of 2 between 2 and 32!");
		}
		
		// Logarithm with base 2 of the count of teams. Calculates the needed stages.
		int treeDepth = (int) (Math.log(teams.size()) / Math.log(2));

		if (treeDepth == 1) {
			this.finalStage = new KnockoutStage(null, teams.get(0), teams.get(1));
		} else {
			// Creating a new stack with all the teams and passing it to the initialiseTree() method.
			Stack<Team> teamsStack = new Stack<Team>();
			teamsStack.addAll(teams);
			
			this.finalStage = new KnockoutStage();
			this.initialiseTree(this.finalStage, treeDepth, teamsStack);
		}
	}

	/**
	 * Private auxiliary method initialising the binary tree of KnockoutStages using recursion.
	 * @param node
	 * @param treeDepth
	 * @param teams
	 */
	private void initialiseTree(KnockoutStage node, int treeDepth, Stack<Team> teams) {
		// If the recursion needs to end.
		if (treeDepth == 2) {
			// Taking new teams from the stack.
			node.setPreviousFirstTeamStage(new KnockoutStage(node, teams.pop(), teams.pop()));
			node.setPreviousSecondTeamStage(new KnockoutStage(node, teams.pop(), teams.pop()));
		}
		
		// Continue the recursion
		else {
			node.setPreviousFirstTeamStage(new KnockoutStage(node));
			this.initialiseTree(node.getPreviousFirstTeamStage(), treeDepth - 1, teams);
			node.setPreviousSecondTeamStage(new KnockoutStage(node));
			this.initialiseTree(node.getPreviousSecondTeamStage(), treeDepth - 1, teams);
		}
	}

	/**
	 * Adding a played match to the tree of stages.
	 * @param match
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addPlayedMatch(Match match) throws NullPointerException, IllegalArgumentException {
		if (match == null) {
			throw new NullPointerException("Match must not be null!");
		}

		if (!this.teams.contains(match.getHomeTeam())) {
			throw new IllegalArgumentException("First team is not in the knockout!");
		}
		if (!this.teams.contains(match.getAwayTeam())) {
			throw new IllegalArgumentException("Second team is not in the knockout!");
		}

		// Initially make the variable false.
		this.hasMatchBeenAdded = false;
		this.addPlayedMatchInTree(this.finalStage, match);

		if (!hasMatchBeenAdded) {
			throw new IllegalArgumentException("The match is not due to be played!");
		}

	}

	/**
	 * Auxiliary method to the addPlayedMatch() method.
	 * Uses recursion to add the match in the tree.
	 * @param node
	 * @param match
	 */
	private void addPlayedMatchInTree(KnockoutStage node, Match match) {
		// End recursion
		if (node == null) {
			return;
		} 
		// If this is the right stage add the match and stop the recursion
		else if (node.getFirstTeam() == match.getHomeTeam() && node.getSecondTeam() == match.getAwayTeam()
				|| node.getFirstTeam() == match.getAwayTeam() && node.getSecondTeam() == match.getHomeTeam()) {
			node.addMatch(match);
			
			// Remove the team, which lost
			if (node.getLoser() != null) {
				this.removedTeams.add(node.getLoser());
			}
			// Change the field to show the adding.
			this.hasMatchBeenAdded = true;
		} 
		// Continue recursion
		else {
			this.addPlayedMatchInTree(node.getPreviousFirstTeamStage(), match);
			this.addPlayedMatchInTree(node.getPreviousSecondTeamStage(), match);
		}
	}

	@Override
	protected String getWinnerName() {
		return this.finalStage.getWinner().getName();
	}

	@Override
	public boolean hasEnded() {
		boolean hasEnded = false;
		
		if (this.finalStage.getWinner() != null) {
			hasEnded = true;
		}
		
		return hasEnded;
	}

	/**
	 * Removing a team from the tree of KnockoutStages.
	 * @param team
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	@Override
	public void removeTeam(Team team) throws NullPointerException, IllegalArgumentException {
		if (team == null) {
			throw new NullPointerException("Team must not be null!");
		}
		if (this.hasEnded()) {
			throw new IllegalArgumentException("The competition has already ended!");
		}
		if (!this.teams.contains(team)) {
			throw new IllegalArgumentException("The team is not in the competition!");
		}

		// Initially set the field to false.
		this.wasTeamRemoved = false;

		this.removeTeamInTree(this.finalStage, team);

		if (!this.wasTeamRemoved) {
			throw new IllegalArgumentException("The team was not removed from the competition!");
		}
		
		this.removedTeams.add(team);
	}
	
	/**
	 * An auxiliary method to remove the team in the specific tree.
	 * Uses recursion.
	 * @param node
	 * @param team
	 */
	private void removeTeamInTree(KnockoutStage node, Team team) {
		// Stop the recursion
		if (node == null || (node.getFirstMatch() != null && node.getSecondMatch() != null)) {
			return;
		} 
		
		// Remove the team from a specific node and stop the recursion. 
		else if (node.getFirstTeam() == team || node.getSecondTeam() == team) {
			node.removeTeam(team);
			this.wasTeamRemoved = true;
		}
		
		// Continue recursion.
		else {
			this.removeTeamInTree(node.getPreviousFirstTeamStage(), team);
			this.removeTeamInTree(node.getPreviousSecondTeamStage(), team);
		}
	}

	@Override
	public String getCompetitionInformation() {
		// Clear the field.
		this.competitionInformation = new StringBuffer();
		
		// Call the recursion function filling the field.
		this.printTree(this.finalStage, null, false);
		
		// Returning the information.
		return this.competitionInformation.toString();
	}

	/**
	 * Prints the tree in the local field competitionInformation.
	 * Uses recursion.
	 * @param node
	 * @param previous
	 * @param isFirst
	 */
	private void printTree(KnockoutStage node, Trunk previous, boolean isFirst) {
		// Stop recursion.
		if (node == null) {
			return;
		}

		// Initial distance
		String previousString = "               ";
		
		// Create the auxiliary class.
		Trunk trunk = new Trunk(previous, previousString);

		// start recursion
		this.printTree(node.getPreviousFirstTeamStage(), trunk, true);

		// If there is no previous add initial distance
		if (previous == null) {
			trunk.setString("      ");
		} 
		
		// if the node is from a firstTeamStage
		else if (isFirst) {
			trunk.setString(".---- ");
			previousString = "              |";
		} 
		
		// if the node is from a secondTeamStage
		else {
			trunk.setString("`---- ");
			previous.setString(previousString);
		}

		// using the function in the auxiliary class chaining the trunks.
		trunk.showTrunks();

		// appending the info for the node and adding a new line
		this.competitionInformation.append(node.toString() + "\n");

		if (previous != null) {
			previous.setString(previousString);
		}

		trunk.setString("              |");

		// Recursion for the other side.
		this.printTree(node.getPreviousSecondTeamStage(), trunk, false);
	}

	/**
	 * An auxiliary class for the getCompetitionMethod().
	 * It is used by chaining the strings for the competition information, by taking into account 
	 * the current depth inside the tree and the direction for the branches.
	 * @author Milen Georgiev
	 *
	 */
	class Trunk {
		/** The previous trunk in the chain */
		private Trunk previous;
		/** The string in the current Trunk */
		private String string;

		/**
		 * Parametrised constructor. Initialises the fields.
		 * @param previous
		 * @param string
		 */
		public Trunk(Trunk previous, String string) {
			this.previous = previous;
			this.string = string;
		}

		/**
		 * Setter for the string.
		 * @param string
		 */
		public void setString(String string) {
			this.string = string;
		}

		/**
		 * Adding the information to the competitionInformation field.
		 */
		public void showTrunks() {
			if (this.previous != null) {
				this.previous.showTrunks();
			}

			competitionInformation.append(this.string);
		}
	}

	@Override
	public String toString() {
		return "[Knockout] " + super.toString();
	}
	
}
