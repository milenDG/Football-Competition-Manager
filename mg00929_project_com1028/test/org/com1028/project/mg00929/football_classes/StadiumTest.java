package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class StadiumTest {
	@Test
	public void testConstruction(){
		Stadium s = new Stadium("John Smith", "England", 100000, "Somewhere");

		assertEquals("John Smith", s.getName());
		assertEquals("England", s.getCountry());
		assertEquals(100000 , s.getCapacity());
		assertEquals("Somewhere", s.getAddress());
	}
	
}