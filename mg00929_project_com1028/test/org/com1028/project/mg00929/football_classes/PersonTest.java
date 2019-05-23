package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testConstruction() {
		class TestPerson extends Person {

			public TestPerson(String name, LocalDate dateOfBirth, String nationality)
					throws IllegalArgumentException, NullPointerException {
				super(name, dateOfBirth, nationality);
			}

		}
		Person p = new TestPerson("John Smith", LocalDate.of(1999, 8, 8), "English");

		assertEquals("John Smith", p.getName());
		assertEquals("English", p.getNationality());

		Team t = new Team("abcd", "Abcde", new Manager("John Smith", LocalDate.of(1999, 8, 8), "English", "abc"),
				new Stadium("Bernabeu", "Spain", 100000, "Nowhere"));
		p.setTeam(t);
		assertEquals(t, p.getTeam());

	}
}
