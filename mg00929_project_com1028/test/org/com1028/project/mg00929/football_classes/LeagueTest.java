package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LeagueTest {
	private List<Team> teams = new ArrayList<Team>();
	private League league = null;
	
	@Before
	public void initialise() {
		Stadium stadium = new Stadium("Bernabeu", "Spain", 100000, "Nowhere");
		
		Team team1 = new Team("test", "Test1", null, stadium);
		Team team2 = new Team("test", "Test2", null, stadium);
		Team team3 = new Team("test", "Test3", null, stadium);
		Team team4 = new Team("test", "Test4", null, stadium);

		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
		teams.add(team4);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullNameConctruction() {
		league = new League(null, "England", teams);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullCountryConctruction() {
		league = new League("Test", null, teams);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullTeamsConctruction() {
		league = new League("Test", "England", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalNameConctruction1() {
		league = new League("Test1", "England", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalNameConctruction2() {
		league = new League("Test abv", "England", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalNameConctruction3() {
		league = new League("test Abv", "England", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalCountryConctruction1() {
		league = new League("Test", "England1", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalCountryConctruction2() {
		league = new League("Test", "england", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalCountryConctruction3() {
		league = new League("Test", "England e", teams);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalTeamsCount1() {
		league = new League("Test", "England", teams.subList(0, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalTeamsCount2() {
		league = new League("Test", "England", teams.subList(0, 0));
	}
	
	@Test
	public void TestValidCounstruction() {
		league = new League("Test", "England", new ArrayList<Team>(teams));
		
		assertEquals("Test", league.getName());
		assertEquals("England", league.getCountry());
		
		assertEquals(4, league.getTeamNames().length);
		assertEquals("Test1", league.getTeamNames()[0]);
		assertEquals("Test2", league.getTeamNames()[1]);
		assertEquals("Test3", league.getTeamNames()[2]);
		assertEquals("Test4", league.getTeamNames()[3]);
		
		assertNull(league.getWinnerName());
		
		assertEquals(" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    0   0   0   0   0\n" + 
				" 2.                Test2 :    0   0   0   0   0\n" + 
				" 3.                Test3 :    0   0   0   0   0\n" + 
				" 4.                Test4 :    0   0   0   0   0\n"
				, league.getCompetitionInformation());
	}
	
	@Test
	public void TestAddPlayedMatchWithEqualScore() {
		league = new League("Test", "England", new ArrayList<Team>(teams));
		
		
		Team.playMatch(league, teams.get(0), teams.get(1), 0, 0);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    1   0   0   0   1\n" + 
				" 2.                Test2 :    1   0   0   0   1\n" + 
				" 3.                Test3 :    0   0   0   0   0\n" + 
				" 4.                Test4 :    0   0   0   0   0\n"
				, league.getCompetitionInformation());
	}
	
	@Test
	public void TestAddPlayedMatchWithHomeTeamWin() {
		league = new League("Test", "England", new ArrayList<Team>(teams));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 0);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    1   1   0   1   3\n" + 
				" 2.                Test3 :    0   0   0   0   0\n" + 
				" 3.                Test4 :    0   0   0   0   0\n" +
				" 4.                Test2 :    1   0   1  -1   0\n"
				, league.getCompetitionInformation());
	}
	
	@Test
	public void TestAddPlayedMatchWithAwayTeamWin() {
		league = new League("Test", "England", new ArrayList<Team>(teams));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 2, 3);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test2 :    1   3   2   1   3\n" + 
				" 2.                Test3 :    0   0   0   0   0\n" + 
				" 3.                Test4 :    0   0   0   0   0\n" +
				" 4.                Test1 :    1   2   3  -1   0\n"
				, league.getCompetitionInformation());
	}
	
	@Test
	public void TestAddSeveralPlayedMatches() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 1);
		Team.playMatch(league, teams.get(0), teams.get(2), 2, 0);
		Team.playMatch(league, teams.get(1), teams.get(2), 2, 3);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    2   3   1   2   4\n" + 
				" 2.                Test3 :    2   3   4  -1   3\n" + 
				" 3.                Test2 :    2   3   4  -1   1\n"
				, league.getCompetitionInformation());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestAddAlreadyPlayedMatch() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 1);
		Team.playMatch(league, teams.get(0), teams.get(1), 2, 1);
	}
	
	@Test
	public void TestAddAllMatchesAndEndCompetition() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 1);
		Team.playMatch(league, teams.get(0), teams.get(2), 2, 0);
		Team.playMatch(league, teams.get(1), teams.get(2), 2, 3);
		
		assertFalse(league.hasEnded());
		assertNull(league.endCompetition());
		
		Team.playMatch(league, teams.get(1), teams.get(0), 4, 1);
		Team.playMatch(league, teams.get(2), teams.get(0), 2, 2);
		Team.playMatch(league, teams.get(2), teams.get(1), 2, 1);
		
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test3 :    4   7   7   0   7\n" + 
				" 2.                Test1 :    4   6   7  -1   5\n" + 
				" 3.                Test2 :    4   8   7   1   4\n"
				, league.getCompetitionInformation());
		
		assertTrue(league.hasEnded());
		assertEquals("The competition ended and the winner is: Test3", league.endCompetition());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestAddPlayedMatchWithIllegalTeam() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 2)));
		Team.playMatch(league, teams.get(0), teams.get(3), 2, 3);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestRemoveTeamFromNewCompetition() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		league.removeTeam(this.teams.get(0));
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test2 :    0   0   0   0   0\n" + 
				" 2.                Test3 :    0   0   0   0   0\n"
				, league.getCompetitionInformation());
		
		assertEquals("Test2", league.getTeamNames()[0]);
		assertEquals("Test3", league.getTeamNames()[1]);
		
		@SuppressWarnings("unused")
		String name = league.getTeamNames()[2];
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestRemoveTeamFromPlayedCompetition() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 1);
		Team.playMatch(league, teams.get(0), teams.get(2), 2, 0);
		Team.playMatch(league, teams.get(1), teams.get(2), 2, 3);
		
		league.removeTeam(this.teams.get(0));
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test3 :    1   3   2   1   3\n" + 
				" 2.                Test2 :    1   2   3  -1   0\n"
				, league.getCompetitionInformation());
		
		assertEquals("Test3", league.getTeamNames()[0]);
		assertEquals("Test2", league.getTeamNames()[1]);
		
		@SuppressWarnings("unused")
		String name = league.getTeamNames()[2];
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestRemoveTeamAfterEnd() {
		this.TestAddAllMatchesAndEndCompetition();
		league.removeTeam(this.teams.get(0));
	}
	
	@Test(expected = NullPointerException.class)
	public void TestRemoveTeamWithNull() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		league.removeTeam(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestRemoveTeamWithIllegalteam() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		league.removeTeam(this.teams.get(3));
	}
	
	@Test
	public void TestComparatorForSortingWithPointsAndNameDifference() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		Team.playMatch(league, teams.get(0), teams.get(1), 1, 1);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    1   1   1   0   1\n" + 
				" 2.                Test2 :    1   1   1   0   1\n" + 
				" 3.                Test3 :    0   0   0   0   0\n"
				, league.getCompetitionInformation());
		
		Team.playMatch(league, teams.get(1), teams.get(0), 2, 1);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test2 :    2   3   2   1   4\n" + 
				" 2.                Test1 :    2   2   3  -1   1\n" + 
				" 3.                Test3 :    0   0   0   0   0\n"
				, league.getCompetitionInformation());
		
	}
	
	@Test
	public void TestComparatorForSortingWithGoalDifference() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		Team.playMatch(league, teams.get(0), teams.get(2), 3, 0);
		Team.playMatch(league, teams.get(1), teams.get(2), 4, 0);
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test2 :    1   4   0   4   3\n" + 
				" 2.                Test1 :    1   3   0   3   3\n" + 
				" 3.                Test3 :    2   0   7  -7   0\n"
				, league.getCompetitionInformation());
		
		Team.playMatch(league, teams.get(1), teams.get(0), 2, 1);
	}
	
	@Test
	public void TestComparatorForRemovedTeams() {
		league = new League("Test", "England", new ArrayList<Team>(teams.subList(0, 3)));
		Team.playMatch(league, teams.get(0), teams.get(2), 3, 0);
		Team.playMatch(league, teams.get(1), teams.get(2), 4, 0);
		league.removeTeam(teams.get(1));
		
		assertEquals(
				" #              Team Name    MP  GS  GC  GD  TP\n" + 
				" 1.                Test1 :    1   3   0   3   3\n" + 
				" 2.                Test3 :    1   0   3  -3   0\n"
				, league.getCompetitionInformation());
		
	}
	
}
