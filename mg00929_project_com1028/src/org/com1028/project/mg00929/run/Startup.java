/**
 * Startup.java
 */
package org.com1028.project.mg00929.run;

import java.awt.EventQueue;

import org.com1028.project.mg00929.user_interface.UserInterface;

/**
 * This is the class used for starting the application.
 * @author Milen Georgiev
 *
 */
public class Startup {

	/**
	 * Main method. Starts the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = UserInterface.getInstance();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
