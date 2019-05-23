package org.com1028.project.mg00929.all_tests;
import org.com1028.project.mg00929.football_classes.*;
import org.com1028.project.mg00929.user_interface.UserInterfaceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllFootballClassesTests.class, UserInterfaceTest.class })
public class AllTest {

}