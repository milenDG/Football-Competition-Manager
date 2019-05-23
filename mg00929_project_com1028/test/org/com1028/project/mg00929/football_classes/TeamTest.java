package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class TeamTest {
	@Test
	public void testConstruction(){
		Manager manager = new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc");
		Stadium stadium = new Stadium("Bernabeu", "Spain", 100000, "Nowhere");
		Team team = new Team("test", "Test", manager, stadium);
		
		
		assertEquals("test", team.getShortName());
		assertEquals("Test", team.getName());
		assertEquals(manager, team.getManager());
		assertEquals(stadium, team.getStadium());
	}
}
