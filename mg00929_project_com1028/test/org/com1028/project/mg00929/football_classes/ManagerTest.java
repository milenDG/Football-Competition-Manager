package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class ManagerTest {
	@Test
	public void testConstruction(){
		Manager m = new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "test");

		assertEquals("John Smith", m.getName());
		assertEquals("English", m.getNationality());
		assertEquals("test", m.getTactics());

		Team t = new Team("abcd", "Abcde", new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc"),
				new Stadium("Bernabeu", "Spain", 100000, "Nowhere"));
		m.setTeam(t);
		assertEquals(t, m.getTeam());
	}
	
}