package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TeamStatisticsTest {
	@Test
	public void testConstruction(){
		TeamStatistics ts = new TeamStatistics();
		ts.addMatch(2, 0);
		
		assertEquals(3, ts.getTotalPoints());
		assertEquals(2, ts.getGoalDifference());
		assertEquals(1, ts.getMatchesPlayed());
	}
}
