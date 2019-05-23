package org.com1028.project.mg00929.football_classes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FootballCompetitionTest {
	@Test
	public void testConstruction() {
		FootballCompetition competition = new FootballCompetition("Test", "Country", new ArrayList<Team>()) {

			@Override
			public void removeTeam(Team team) {
			}

			@Override
			public boolean hasEnded() {
				return false;
			}

			@Override
			protected String getWinnerName() {
				return null;
			}

			@Override
			public String getCompetitionInformation() {
				return null;
			}

			@Override
			public void addPlayedMatch(Match match) {
			}
		};

		assertEquals("Test", competition.getName());
		assertEquals("Country", competition.getCountry());
	}
}
