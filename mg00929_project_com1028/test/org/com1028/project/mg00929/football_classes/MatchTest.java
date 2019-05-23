package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class MatchTest {
	@Test
	public void testConstruction(){
		Team team1 = new Team("abcd", "Abcde", new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc"),
				new Stadium("Bernabeu", "Spain", 100000, "Nowhere"));
		Team team2 = new Team("abcd", "Abcde", new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc"),
				new Stadium("Bernabeu", "Spain", 100000, "Nowhere"));
		
		Match match = new Match(team1, team2, 2, 0, team1.getStadium());

		assertEquals(team1, match.getHomeTeam());
		assertEquals(team2, match.getAwayTeam());
		assertEquals(2, match.getHomeTeamGoals());
		assertEquals(0, match.getAwayTeamGoals());
		assertEquals(team1.getStadium(), match.getStadium());
	}
	
}