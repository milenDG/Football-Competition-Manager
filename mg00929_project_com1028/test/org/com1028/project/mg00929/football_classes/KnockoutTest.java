package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("unused")
public class KnockoutTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTeamsCountConstruction() {
		List<Team> teams = new ArrayList<Team>();
		
		Manager manager = new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc");
		Stadium stadium = new Stadium("Bernabeu", "Spain", 100000, "Nowhere");
		
		Team team1 = new Team("test", "Test1", manager, stadium);
		Team team2 = new Team("test", "Test2", manager, stadium);
		Team team3 = new Team("test", "Test3", manager, stadium);
		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
	
		Knockout knockout = new Knockout("Test", "England", teams);
	}
	
	@Test
	public void testCorrectConstruction() {
		List<Team> teams = new ArrayList<Team>();
		
		Stadium stadium = new Stadium("Bernabeu", "Spain", 100000, "Nowhere");
		
		Team team1 = new Team("test", "Test1", null, stadium);
		Team team2 = new Team("test", "Test2", null, stadium);
		Team team3 = new Team("test", "Test3", null, stadium);
		Team team4 = new Team("test", "Test4", null, stadium);

		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
		teams.add(team4);
	
		Knockout knockout = new Knockout("Test", "England", teams);
		assertEquals("Test", knockout.getName());
		assertEquals("England", knockout.getCountry());
		assertEquals("Test4", knockout.getTeamNames()[3]);
		
	}
}
