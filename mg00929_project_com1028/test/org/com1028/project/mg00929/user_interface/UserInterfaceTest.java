package org.com1028.project.mg00929.user_interface;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserInterfaceTest {

	private UserInterface ui1, ui2;
	@Test
	public void testInstanceGetting() {
		Thread thread1 = new Thread() {
			public void run() {
				ui1 = UserInterface.getInstance();
			};
		};
		Thread thread2 = new Thread() {
			public void run() {
				ui2 = UserInterface.getInstance();
			};
		};
		
		thread1.start();
		thread2.start();
		
		assertEquals(true, ui1 == ui2);
	}
}
