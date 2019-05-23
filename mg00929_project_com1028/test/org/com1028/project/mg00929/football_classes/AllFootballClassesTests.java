package org.com1028.project.mg00929.football_classes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PersonTest.class, PlayerTest.class, ManagerTest.class, StadiumTest.class, MatchTest.class,
		TeamStatisticsTest.class, TeamTest.class, FootballCompetitionTest.class, KnockoutStageTest.class,
		KnockoutTest.class, LeagueTest.class, PaddingTest.class })
public class AllFootballClassesTests {

}
