package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void testConstruction(){
		Player p = new Player("John Smith", LocalDate.of(1999, 8, 8), "English", Position.DEFENDER);

		assertEquals("John Smith", p.getName());
		assertEquals("English", p.getNationality());
		assertEquals(Position.DEFENDER, p.getPostition());

		Team t = new Team("abcd", "Abcde", new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc"),
				new Stadium("Bernabeu", "Spain", 100000, "Nowhere"));
		p.setTeam(t);
		assertEquals(t, p.getTeam());
	}
	
}
