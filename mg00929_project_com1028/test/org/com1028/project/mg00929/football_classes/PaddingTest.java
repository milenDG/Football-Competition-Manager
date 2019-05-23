package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaddingTest {
	@Test
	public void testLeftPadding() {
		assertEquals("   test", Padding.padLeft("test", 7));
	}
	
	@Test
	public void testRightPadding() {
		assertEquals("test   ", Padding.padRight("test", 7));
	}
	
	@Test
	public void testShortLeftPadding() {
		assertEquals("test", Padding.padLeft("test", 3));
	}
	
	@Test
	public void testShortRightPadding() {
		assertEquals("test", Padding.padRight("test", 3));
	}
}
