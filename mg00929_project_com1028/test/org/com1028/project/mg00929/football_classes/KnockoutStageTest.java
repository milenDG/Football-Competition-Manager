package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class KnockoutStageTest {
	@Test
	public void testConstructionWithEmptyConstructor(){
		KnockoutStage knockoutStage = new KnockoutStage();
		assertNull(knockoutStage.getFirstMatch());
		assertNull(knockoutStage.getFirstTeam());
		assertNull(knockoutStage.getSecondMatch());
		assertNull(knockoutStage.getSecondTeam());
		assertNull(knockoutStage.getNextStage());
		assertNull(knockoutStage.getLoser());
		assertNull(knockoutStage.getWinner());
		assertNull(knockoutStage.getPreviousFirstTeamStage());
		assertNull(knockoutStage.getPreviousSecondTeamStage());
	}
	
	@Test
	public void testConstructionWith1ParamConstructor(){
		KnockoutStage nextStage = new KnockoutStage();
		KnockoutStage knockoutStage = new KnockoutStage(nextStage);
		assertNull(knockoutStage.getFirstMatch());
		assertNull(knockoutStage.getFirstTeam());
		assertNull(knockoutStage.getSecondMatch());
		assertNull(knockoutStage.getSecondTeam());
		assertEquals(nextStage, knockoutStage.getNextStage());
		assertNull(knockoutStage.getLoser());
		assertNull(knockoutStage.getWinner());
		assertNull(knockoutStage.getPreviousFirstTeamStage());
		assertNull(knockoutStage.getPreviousSecondTeamStage());
	}
	
	@Test
	public void testConstructionWith3ParamConstructor(){
		Stadium stadium = new Stadium("Bernabeu", "Spain", 100000, "Nowhere");
		Team team1 = new Team("test", "Test1", null, stadium);
		Team team2 = new Team("test", "Test2", null, stadium);
		
		
		KnockoutStage nextStage = new KnockoutStage();
		KnockoutStage knockoutStage = new KnockoutStage(nextStage, team1, team2);
		assertNull(knockoutStage.getFirstMatch());
		assertEquals(team1, knockoutStage.getFirstTeam());
		assertNull(knockoutStage.getSecondMatch());
		assertEquals(team2, knockoutStage.getSecondTeam());
		assertEquals(nextStage, knockoutStage.getNextStage());
		assertNull(knockoutStage.getLoser());
		assertNull(knockoutStage.getWinner());
		assertNull(knockoutStage.getPreviousFirstTeamStage());
		assertNull(knockoutStage.getPreviousSecondTeamStage());
	}
}
