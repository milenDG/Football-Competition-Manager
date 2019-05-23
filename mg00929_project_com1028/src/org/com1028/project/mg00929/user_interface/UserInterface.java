/**
 * UserInterface.java
 */
package org.com1028.project.mg00929.user_interface;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.com1028.project.mg00929.football_classes.FootballCompetition;
import org.com1028.project.mg00929.football_classes.Knockout;
import org.com1028.project.mg00929.football_classes.League;
import org.com1028.project.mg00929.football_classes.Manager;
import org.com1028.project.mg00929.football_classes.Player;
import org.com1028.project.mg00929.football_classes.Position;
import org.com1028.project.mg00929.football_classes.Stadium;
import org.com1028.project.mg00929.football_classes.Team;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 * This class defines the whole user interface for the application. Uses Java's
 * WindowBuilder. It is singleton.
 * 
 * @author Milen Georgiev
 *
 */
public class UserInterface {

	/** Only instance of the class */
	private static UserInterface instance = null;

	/** List of the players created */
	private List<Player> players = null;
	/** List of the managers created */
	private List<Manager> managers = null;
	/** List of the stadiums created */
	private List<Stadium> stadiums = null;
	/** List of the teams created */
	private List<Team> teams = null;
	/** List of the football competitions created */
	private List<FootballCompetition> competitions = null;

	/**
	 * The current specific football competition. Used for panelSpecificCompetition
	 */
	private FootballCompetition specificCompetition = null;

	/** The frame of the UI */
	private JFrame frame;

	/** The initial panel with the initial menu of the application */
	private JPanel panelInitialMenu;

	/** The panel for the players */
	private JPanel panelPlayers;
	private JRadioButton addPlayerRadioButton;
	private JRadioButton removePlayerRadioButton;
	private JPanel addPlayerPanel;
	private JPanel removePlayerPanel;
	private JTextField addPlayerNameTextField;
	private JTextField dayPlayerTextField;
	private JTextField monthPlayerTextField;
	private JTextField yearPlayerTextField;
	private JTextField nationalityPlayerTextField;
	private JComboBox<Position> playerPositionComboBox;
	private JButton addPlayerButton;
	private JTextArea addExceptionPlayerTextArea;
	private JTextArea removeExceptionPlayerTextArea;
	private JComboBox<String> addPlayerTeamComboBox;
	private JComboBox<String> removePlayerComboBox;

	/** The panel for the managers */
	private JPanel panelManagers;
	private JRadioButton addManagerRadioButton;
	private JRadioButton removeManagerRadioButton;
	private JPanel addManagerPanel;
	private JTextField addManagerNameTextField;
	private JTextField dayManagerTextField;
	private JTextField monthManagerTextField;
	private JTextField yearManagerTextField;
	private JTextField nationalityManagerTextField;
	private JTextArea addExceptionManagerTextArea;
	private JTextField tacticsManagerTextField;
	private JPanel removeManagerPanel;
	private JTextArea removeExceptionManagerTextArea;
	private JComboBox<String> addManagerTeamComboBox;
	private JComboBox<String> removeManagerComboBox;

	/** The panel for the stadiums */
	private JPanel panelStadiums;
	private JTextField addStadiumNameTextField;
	private JTextField addStadiumCountryTextField;
	private JTextField addStadiumCapacityTextField;
	private JTextField addStadiumAddressTextField;
	private JTextArea addExceptionStadiumTextArea;

	/** The panel for the teams */
	private JPanel panelTeams;
	private JTextField teamNameTeamTextField;
	private JTextField shortTeamNameTeamTextField;
	private JTextField exceptionTeamsTextField;
	private JTextArea teamsInfoTextArea;
	private JTextArea stadiumsInfoTextArea;
	private JTextArea managersInfoTextArea;
	private JTextArea playersInfoTextArea;

	/** The panel for all competitions */
	private JPanel panelFootballCompetition;
	private JTextArea competitionsInfoTextArea;
	private JTextField createCompetitionNameTextField;
	private JTextField createCompetitionCountryTextField;
	private JTextArea competitionExceptionTextArea;
	private JRadioButton createNewLeagueRadioButton;
	private JRadioButton createNewKnockoutRadioButton;
	private JComboBox<String> teamStadiumComboBox;
	private JComboBox<String> teamManagerComboBox;
	private JComboBox<String> chooseSpecificCompetitionComboBox;

	/** The panel for a specific competition */
	private JPanel panelSpecificFootballCompetition;
	private JTextArea specificCompetitionInfoTextArea;
	private JTextArea specificCompetitionExceptionTextArea;
	private JComboBox<String> addMatchHomeTeamNameComboBox;
	private JComboBox<String> addMatchAwayTeamNameComboBox;
	private JComboBox<String> removeTeamFromSpecificCompetitionComboBox;
	private JButton addMatchInCompetitionButton;
	private JButton removeTeamFromSpecificCompetition;
	private JList<String> playersOfTeamList;
	private JComboBox<Integer> addMatchHomeTeamGoalsComboBox;
	private JComboBox<Integer> addMatchAwayTeamGoalsComboBox;
	private JList<String> addCompetitionTeamsList;

	/**
	 * Create the user interface.
	 */
	private UserInterface() {
		initialize();
		this.players = new ArrayList<Player>();
		this.managers = new ArrayList<Manager>();
		this.stadiums = new ArrayList<Stadium>();
		this.teams = new ArrayList<Team>();
		this.competitions = new ArrayList<FootballCompetition>();
		Manager manager = new Manager("Jose Mourinho", LocalDate.of(1975, 1, 1), "Portugese", "Defensive");
		Stadium stadium = new Stadium("Camp Nou", "Spain", 99000, "Camp Nou street 14");
		Player player1 = new Player("Cristiano Ronaldo", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		Player player2 = new Player("Lionel Messi", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		Player player3 = new Player("Luka Modric", LocalDate.of(1975, 1, 1), "English", Position.MIDFIELDER);
		Player player4 = new Player("Antoine Grizemann", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		Player player5 = new Player("Paul Pogba", LocalDate.of(1975, 1, 1), "English", Position.MIDFIELDER);
		Player player6 = new Player("Sergio Aguero", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		Player player7 = new Player("Sadio Mane", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		Player player8 = new Player("Mohammad Salah", LocalDate.of(1975, 1, 1), "English", Position.FORWARD);
		this.players.add(player1);
		this.players.add(player2);
		this.players.add(player3);
		this.players.add(player4);
		this.players.add(player5);
		this.players.add(player6);
		this.players.add(player7);
		this.players.add(player8);
		Team team1 = new Team("Arsl", "Arsenal", manager, stadium);
		Team team2 = new Team("ManU", "Man Utd", null, stadium);
		Team team3 = new Team("CSKA", "CSKA", null, stadium);
		Team team4 = new Team("Lvsk", "Levski", null, stadium);
		Team team5 = new Team("Totm", "Totenham", null, stadium);
		Team team6 = new Team("ManC", "Man City", null, stadium);
		Team team7 = new Team("Botv", "Botev Plovdiv", null, stadium);
		Team team8 = new Team("LokS", "Loko Sofia", null, stadium);
		Team team9 = new Team("Brca", "Barcelona", null, stadium);
		Team team10 = new Team("Slva", "Slavia", null, stadium);
		Team team11 = new Team("RMad", "Real Madrid", null, stadium);
		Team team12 = new Team("Slke", "Schalke", null, stadium);
		Team team13 = new Team("Valc", "Valencia", null, stadium);
		Team team14 = new Team("AtlM", "Atletico Madrid", null, stadium);
		Team team15 = new Team("AtlB", "Atletic Bilbao", null, stadium);
		Team team16 = new Team("Hues", "Hueska", null, stadium);
		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
		teams.add(team4);
		teams.add(team5);
		teams.add(team6);
		teams.add(team7);
		teams.add(team8);
		teams.add(team9);
		teams.add(team10);
		teams.add(team11);
		teams.add(team12);
		teams.add(team13);
		teams.add(team14);
		teams.add(team15);
		teams.add(team16);
		this.competitions.add(new League("La Liga", "Spain", new ArrayList<Team>(teams.subList(0, 4))));
		this.competitions.add(new Knockout("Copa Del Rey", "Spain", new ArrayList<Team>(teams.subList(4, 8))));

		this.managers.add(manager);
		this.stadiums.add(stadium);
	}

	/**
	 * Gets the instance of the singleton.
	 * 
	 * @return instance
	 */
	synchronized public static UserInterface getInstance() {
		if (UserInterface.instance == null) {
			UserInterface.instance = new UserInterface();
		}

		return UserInterface.instance;
	}

	/**
	 * Getter for the frame
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelInitialMenu = new JPanel();
		this.panelInitialMenu.setVisible(true);
		frame.getContentPane().add(panelInitialMenu, "name_1233850504057400");
		GridBagLayout gbl_panelInitialMenu = new GridBagLayout();
		gbl_panelInitialMenu.columnWidths = new int[] { 0, 0 };
		gbl_panelInitialMenu.rowHeights = new int[] { 0, 50, 50, 50, 50, 50, 0 };
		gbl_panelInitialMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelInitialMenu.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInitialMenu.setLayout(gbl_panelInitialMenu);

		JTextArea InitialMenuTextArea = new JTextArea();
		InitialMenuTextArea.setEditable(false);
		InitialMenuTextArea.setText("Choose what to view.");
		GridBagConstraints gbc_InitialMenuTextArea = new GridBagConstraints();
		gbc_InitialMenuTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_InitialMenuTextArea.fill = GridBagConstraints.BOTH;
		gbc_InitialMenuTextArea.gridx = 0;
		gbc_InitialMenuTextArea.gridy = 0;
		panelInitialMenu.add(InitialMenuTextArea, gbc_InitialMenuTextArea);

		JButton initialMenuPlayersButton = new JButton("Players");
		initialMenuPlayersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInitialMenu.setVisible(false);
				updatePlayersInformation();
				updateAddPlayerTeamsComboBox();
				panelPlayers.setVisible(true);
			}
		});
		GridBagConstraints gbc_initialMenuPlayersButton = new GridBagConstraints();
		gbc_initialMenuPlayersButton.fill = GridBagConstraints.BOTH;
		gbc_initialMenuPlayersButton.insets = new Insets(0, 0, 5, 0);
		gbc_initialMenuPlayersButton.gridx = 0;
		gbc_initialMenuPlayersButton.gridy = 1;
		panelInitialMenu.add(initialMenuPlayersButton, gbc_initialMenuPlayersButton);

		JButton initialMenuManagersButton = new JButton("Managers");
		initialMenuManagersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInitialMenu.setVisible(false);
				updateManagersInformation();
				updateAddManagerTeamsComboBox();
				panelManagers.setVisible(true);
			}
		});
		GridBagConstraints gbc_initialMenuManagersButton = new GridBagConstraints();
		gbc_initialMenuManagersButton.fill = GridBagConstraints.BOTH;
		gbc_initialMenuManagersButton.insets = new Insets(0, 0, 5, 0);
		gbc_initialMenuManagersButton.gridx = 0;
		gbc_initialMenuManagersButton.gridy = 2;
		panelInitialMenu.add(initialMenuManagersButton, gbc_initialMenuManagersButton);

		JButton initialMenuStadiumsButton = new JButton("Stadiums");
		initialMenuStadiumsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInitialMenu.setVisible(false);
				updateStadiumsInformation();
				panelStadiums.setVisible(true);
			}
		});
		GridBagConstraints gbc_initialMenuStadiumsButton = new GridBagConstraints();
		gbc_initialMenuStadiumsButton.fill = GridBagConstraints.BOTH;
		gbc_initialMenuStadiumsButton.insets = new Insets(0, 0, 5, 0);
		gbc_initialMenuStadiumsButton.gridx = 0;
		gbc_initialMenuStadiumsButton.gridy = 3;
		panelInitialMenu.add(initialMenuStadiumsButton, gbc_initialMenuStadiumsButton);

		JButton initialMenuTeamsButton = new JButton("Teams");
		initialMenuTeamsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInitialMenu.setVisible(false);
				updateTeamsInformation();
				updateManagerComboBox();
				updateStadiumsInformation();
				updateRemovePlayerComboBox();
				panelTeams.setVisible(true);
			}
		});
		GridBagConstraints gbc_initialMenuTeamsButton = new GridBagConstraints();
		gbc_initialMenuTeamsButton.fill = GridBagConstraints.BOTH;
		gbc_initialMenuTeamsButton.insets = new Insets(0, 0, 5, 0);
		gbc_initialMenuTeamsButton.gridx = 0;
		gbc_initialMenuTeamsButton.gridy = 4;
		panelInitialMenu.add(initialMenuTeamsButton, gbc_initialMenuTeamsButton);

		JButton initialMenuFootballCompetitionsButton = new JButton("Football Competitions");
		initialMenuFootballCompetitionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInitialMenu.setVisible(false);
				updateCompetitionsInformation();
				updateAddPlayerTeamsComboBox();
				panelFootballCompetition.setVisible(true);
			}
		});
		GridBagConstraints gbc_initialMenuFootballCompetitionsButton = new GridBagConstraints();
		gbc_initialMenuFootballCompetitionsButton.fill = GridBagConstraints.BOTH;
		gbc_initialMenuFootballCompetitionsButton.gridx = 0;
		gbc_initialMenuFootballCompetitionsButton.gridy = 5;
		panelInitialMenu.add(initialMenuFootballCompetitionsButton, gbc_initialMenuFootballCompetitionsButton);

		panelPlayers = new JPanel();
		this.panelPlayers.setVisible(false);
		frame.getContentPane().add(panelPlayers, "name_1233852405962900");
		GridBagLayout gbl_panelPlayers = new GridBagLayout();
		gbl_panelPlayers.columnWidths = new int[] { 282, 100, 100, 0 };
		gbl_panelPlayers.rowHeights = new int[] { 240, 0, 103, 0 };
		gbl_panelPlayers.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPlayers.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelPlayers.setLayout(gbl_panelPlayers);

		JScrollPane playersScrollPane = new JScrollPane();
		GridBagConstraints gbc_playersScrollPane = new GridBagConstraints();
		gbc_playersScrollPane.gridwidth = 3;
		gbc_playersScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_playersScrollPane.fill = GridBagConstraints.BOTH;
		gbc_playersScrollPane.gridx = 0;
		gbc_playersScrollPane.gridy = 0;
		panelPlayers.add(playersScrollPane, gbc_playersScrollPane);

		playersInfoTextArea = new JTextArea();
		playersInfoTextArea.setEditable(false);
		playersScrollPane.setViewportView(playersInfoTextArea);

		JTextArea addOrRemovePlayerTextArea = new JTextArea();
		addOrRemovePlayerTextArea.setEditable(false);
		addOrRemovePlayerTextArea.setText("Add/remove player to the system:");
		GridBagConstraints gbc_addOrRemovePlayerTextArea = new GridBagConstraints();
		gbc_addOrRemovePlayerTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_addOrRemovePlayerTextArea.fill = GridBagConstraints.BOTH;
		gbc_addOrRemovePlayerTextArea.gridx = 0;
		gbc_addOrRemovePlayerTextArea.gridy = 1;
		panelPlayers.add(addOrRemovePlayerTextArea, gbc_addOrRemovePlayerTextArea);

		addPlayerRadioButton = new JRadioButton("Add");
		addPlayerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayerRadioButton.setSelected(true);
				removePlayerRadioButton.setSelected(false);
				removePlayerPanel.setVisible(false);
				addPlayerPanel.setVisible(true);
			}
		});
		addPlayerRadioButton.setSelected(true);
		GridBagConstraints gbc_addPlayerRadioButton = new GridBagConstraints();
		gbc_addPlayerRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPlayerRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_addPlayerRadioButton.gridx = 1;
		gbc_addPlayerRadioButton.gridy = 1;
		panelPlayers.add(addPlayerRadioButton, gbc_addPlayerRadioButton);

		removePlayerRadioButton = new JRadioButton("Remove");
		removePlayerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayerRadioButton.setSelected(false);
				removePlayerRadioButton.setSelected(true);
				updateRemovePlayerComboBox();
				removePlayerPanel.setVisible(true);
				addPlayerPanel.setVisible(false);
			}
		});
		GridBagConstraints gbc_removePlayerRadioButton = new GridBagConstraints();
		gbc_removePlayerRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_removePlayerRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_removePlayerRadioButton.gridx = 2;
		gbc_removePlayerRadioButton.gridy = 1;
		panelPlayers.add(removePlayerRadioButton, gbc_removePlayerRadioButton);

		JPanel addOrRemovePlayerPanel = new JPanel();
		GridBagConstraints gbc_addOrRemovePlayerPanel = new GridBagConstraints();
		gbc_addOrRemovePlayerPanel.gridwidth = 3;
		gbc_addOrRemovePlayerPanel.fill = GridBagConstraints.BOTH;
		gbc_addOrRemovePlayerPanel.gridx = 0;
		gbc_addOrRemovePlayerPanel.gridy = 2;
		panelPlayers.add(addOrRemovePlayerPanel, gbc_addOrRemovePlayerPanel);
		addOrRemovePlayerPanel.setLayout(new CardLayout(0, 0));

		addPlayerPanel = new JPanel();
		addOrRemovePlayerPanel.add(addPlayerPanel, "name_1279240387750700");
		GridBagLayout gbl_addPlayerPanel = new GridBagLayout();
		gbl_addPlayerPanel.columnWidths = new int[] { 170, 0, 0, 0, 0 };
		gbl_addPlayerPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 33, 0, 0 };
		gbl_addPlayerPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_addPlayerPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addPlayerPanel.setLayout(gbl_addPlayerPanel);

		JTextArea txtrPlayerName = new JTextArea();
		txtrPlayerName.setEditable(false);
		txtrPlayerName.setText("Player  Name");
		GridBagConstraints gbc_txtrPlayerName = new GridBagConstraints();
		gbc_txtrPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrPlayerName.fill = GridBagConstraints.BOTH;
		gbc_txtrPlayerName.gridx = 0;
		gbc_txtrPlayerName.gridy = 0;
		addPlayerPanel.add(txtrPlayerName, gbc_txtrPlayerName);

		addPlayerNameTextField = new JTextField();
		GridBagConstraints gbc_addPlayerNameTextField = new GridBagConstraints();
		gbc_addPlayerNameTextField.gridwidth = 3;
		gbc_addPlayerNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addPlayerNameTextField.fill = GridBagConstraints.BOTH;
		gbc_addPlayerNameTextField.gridx = 1;
		gbc_addPlayerNameTextField.gridy = 0;
		addPlayerPanel.add(addPlayerNameTextField, gbc_addPlayerNameTextField);
		addPlayerNameTextField.setColumns(10);

		JTextArea txtrDateOfBirth = new JTextArea();
		txtrDateOfBirth.setEditable(false);
		txtrDateOfBirth.setText("Date Of Birth (day/month/year)");
		GridBagConstraints gbc_txtrDateOfBirth = new GridBagConstraints();
		gbc_txtrDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_txtrDateOfBirth.fill = GridBagConstraints.BOTH;
		gbc_txtrDateOfBirth.gridx = 0;
		gbc_txtrDateOfBirth.gridy = 1;
		addPlayerPanel.add(txtrDateOfBirth, gbc_txtrDateOfBirth);

		dayPlayerTextField = new JTextField();
		GridBagConstraints gbc_dayPlayerTextField = new GridBagConstraints();
		gbc_dayPlayerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dayPlayerTextField.fill = GridBagConstraints.BOTH;
		gbc_dayPlayerTextField.gridx = 1;
		gbc_dayPlayerTextField.gridy = 1;
		addPlayerPanel.add(dayPlayerTextField, gbc_dayPlayerTextField);
		dayPlayerTextField.setColumns(10);

		monthPlayerTextField = new JTextField();
		GridBagConstraints gbc_monthPlayerTextField = new GridBagConstraints();
		gbc_monthPlayerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_monthPlayerTextField.fill = GridBagConstraints.BOTH;
		gbc_monthPlayerTextField.gridx = 2;
		gbc_monthPlayerTextField.gridy = 1;
		addPlayerPanel.add(monthPlayerTextField, gbc_monthPlayerTextField);
		monthPlayerTextField.setColumns(10);

		yearPlayerTextField = new JTextField();
		GridBagConstraints gbc_yearPlayerTextField = new GridBagConstraints();
		gbc_yearPlayerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_yearPlayerTextField.fill = GridBagConstraints.BOTH;
		gbc_yearPlayerTextField.gridx = 3;
		gbc_yearPlayerTextField.gridy = 1;
		addPlayerPanel.add(yearPlayerTextField, gbc_yearPlayerTextField);
		yearPlayerTextField.setColumns(10);

		JTextArea txtrNationality = new JTextArea();
		txtrNationality.setEditable(false);
		txtrNationality.setText("Nationality");
		GridBagConstraints gbc_txtrNationality = new GridBagConstraints();
		gbc_txtrNationality.insets = new Insets(0, 0, 5, 5);
		gbc_txtrNationality.fill = GridBagConstraints.BOTH;
		gbc_txtrNationality.gridx = 0;
		gbc_txtrNationality.gridy = 2;
		addPlayerPanel.add(txtrNationality, gbc_txtrNationality);

		nationalityPlayerTextField = new JTextField();
		GridBagConstraints gbc_nationalityPlayerTextField = new GridBagConstraints();
		gbc_nationalityPlayerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nationalityPlayerTextField.gridwidth = 3;
		gbc_nationalityPlayerTextField.fill = GridBagConstraints.BOTH;
		gbc_nationalityPlayerTextField.gridx = 1;
		gbc_nationalityPlayerTextField.gridy = 2;
		addPlayerPanel.add(nationalityPlayerTextField, gbc_nationalityPlayerTextField);
		nationalityPlayerTextField.setColumns(10);

		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setEditable(false);
		txtrPosition.setText("Position");
		GridBagConstraints gbc_txtrPosition = new GridBagConstraints();
		gbc_txtrPosition.insets = new Insets(0, 0, 5, 5);
		gbc_txtrPosition.fill = GridBagConstraints.BOTH;
		gbc_txtrPosition.gridx = 0;
		gbc_txtrPosition.gridy = 3;
		addPlayerPanel.add(txtrPosition, gbc_txtrPosition);

		playerPositionComboBox = new JComboBox<Position>();
		playerPositionComboBox.setModel(new DefaultComboBoxModel<Position>(Position.values()));
		GridBagConstraints gbc_playerPositionComboBox = new GridBagConstraints();
		gbc_playerPositionComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_playerPositionComboBox.gridwidth = 3;
		gbc_playerPositionComboBox.fill = GridBagConstraints.BOTH;
		gbc_playerPositionComboBox.gridx = 1;
		gbc_playerPositionComboBox.gridy = 3;
		addPlayerPanel.add(playerPositionComboBox, gbc_playerPositionComboBox);

		JTextArea txtrTeamName = new JTextArea();
		txtrTeamName.setEditable(false);
		txtrTeamName.setText("Team");
		GridBagConstraints gbc_txtrTeamName = new GridBagConstraints();
		gbc_txtrTeamName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTeamName.fill = GridBagConstraints.BOTH;
		gbc_txtrTeamName.gridx = 0;
		gbc_txtrTeamName.gridy = 4;
		addPlayerPanel.add(txtrTeamName, gbc_txtrTeamName);

		addPlayerButton = new JButton("Add Player");
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayer();
			}
		});

		addPlayerTeamComboBox = new JComboBox<String>();
		GridBagConstraints gbc_addPlayerTeamComboBox = new GridBagConstraints();
		gbc_addPlayerTeamComboBox.gridwidth = 3;
		gbc_addPlayerTeamComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_addPlayerTeamComboBox.fill = GridBagConstraints.BOTH;
		gbc_addPlayerTeamComboBox.gridx = 1;
		gbc_addPlayerTeamComboBox.gridy = 4;
		addPlayerPanel.add(addPlayerTeamComboBox, gbc_addPlayerTeamComboBox);
		GridBagConstraints gbc_addPlayerButton = new GridBagConstraints();
		gbc_addPlayerButton.insets = new Insets(0, 0, 5, 0);
		gbc_addPlayerButton.fill = GridBagConstraints.BOTH;
		gbc_addPlayerButton.gridwidth = 4;
		gbc_addPlayerButton.gridx = 0;
		gbc_addPlayerButton.gridy = 5;
		addPlayerPanel.add(addPlayerButton, gbc_addPlayerButton);

		addExceptionPlayerTextArea = new JTextArea();
		addExceptionPlayerTextArea.setBackground(Color.CYAN);
		addExceptionPlayerTextArea.setEditable(false);
		GridBagConstraints gbc_addExceptionPlayerTextArea = new GridBagConstraints();
		gbc_addExceptionPlayerTextArea.gridwidth = 3;
		gbc_addExceptionPlayerTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_addExceptionPlayerTextArea.fill = GridBagConstraints.BOTH;
		gbc_addExceptionPlayerTextArea.gridx = 0;
		gbc_addExceptionPlayerTextArea.gridy = 6;
		addPlayerPanel.add(addExceptionPlayerTextArea, gbc_addExceptionPlayerTextArea);

		JButton addPlayersInitialMenuButton = new JButton("Initial Menu");
		addPlayersInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_addPlayersInitialMenuButton = new GridBagConstraints();
		gbc_addPlayersInitialMenuButton.fill = GridBagConstraints.VERTICAL;
		gbc_addPlayersInitialMenuButton.gridx = 3;
		gbc_addPlayersInitialMenuButton.gridy = 6;
		addPlayerPanel.add(addPlayersInitialMenuButton, gbc_addPlayersInitialMenuButton);

		removePlayerPanel = new JPanel();
		addOrRemovePlayerPanel.add(removePlayerPanel, "name_1279242886627800");
		GridBagLayout gbl_removePlayerPanel = new GridBagLayout();
		gbl_removePlayerPanel.columnWidths = new int[] { 39, 0, 0 };
		gbl_removePlayerPanel.rowHeights = new int[] { 0, 40, 0, 0, 0 };
		gbl_removePlayerPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_removePlayerPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		removePlayerPanel.setLayout(gbl_removePlayerPanel);

		JTextArea txtrPayerName = new JTextArea();
		txtrPayerName.setText("Player");
		txtrPayerName.setEditable(false);
		GridBagConstraints gbc_txtrPayerName = new GridBagConstraints();
		gbc_txtrPayerName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrPayerName.fill = GridBagConstraints.BOTH;
		gbc_txtrPayerName.gridx = 0;
		gbc_txtrPayerName.gridy = 0;
		removePlayerPanel.add(txtrPayerName, gbc_txtrPayerName);

		JButton btnNewButton = new JButton("Remove Player");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePlayer();
			}
		});

		removePlayerComboBox = new JComboBox<String>();
		GridBagConstraints gbc_removePlayerComboBox = new GridBagConstraints();
		gbc_removePlayerComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_removePlayerComboBox.fill = GridBagConstraints.BOTH;
		gbc_removePlayerComboBox.gridx = 1;
		gbc_removePlayerComboBox.gridy = 0;
		removePlayerPanel.add(removePlayerComboBox, gbc_removePlayerComboBox);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		removePlayerPanel.add(btnNewButton, gbc_btnNewButton);

		removeExceptionPlayerTextArea = new JTextArea();
		removeExceptionPlayerTextArea.setBackground(Color.CYAN);
		removeExceptionPlayerTextArea.setEditable(false);
		GridBagConstraints gbc_removeExceptionPlayerTextArea = new GridBagConstraints();
		gbc_removeExceptionPlayerTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_removeExceptionPlayerTextArea.gridwidth = 2;
		gbc_removeExceptionPlayerTextArea.fill = GridBagConstraints.BOTH;
		gbc_removeExceptionPlayerTextArea.gridx = 0;
		gbc_removeExceptionPlayerTextArea.gridy = 2;
		removePlayerPanel.add(removeExceptionPlayerTextArea, gbc_removeExceptionPlayerTextArea);

		JButton removePlayersInitialMenuButton = new JButton("Initial Menu");
		removePlayersInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_removePlayersInitialMenuButton = new GridBagConstraints();
		gbc_removePlayersInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_removePlayersInitialMenuButton.gridwidth = 2;
		gbc_removePlayersInitialMenuButton.gridx = 0;
		gbc_removePlayersInitialMenuButton.gridy = 3;
		removePlayerPanel.add(removePlayersInitialMenuButton, gbc_removePlayersInitialMenuButton);

		panelManagers = new JPanel();
		this.panelManagers.setVisible(false);
		frame.getContentPane().add(panelManagers, "name_1233859158129500");
		GridBagLayout gbl_panelManagers = new GridBagLayout();
		gbl_panelManagers.columnWidths = new int[] { 277, 100, 100, 0 };
		gbl_panelManagers.rowHeights = new int[] { 240, 0, 0, 0, 0, 0 };
		gbl_panelManagers.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelManagers.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelManagers.setLayout(gbl_panelManagers);

		JScrollPane managersScrollPane = new JScrollPane();
		GridBagConstraints gbc_managersScrollPane = new GridBagConstraints();
		gbc_managersScrollPane.gridwidth = 3;
		gbc_managersScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_managersScrollPane.fill = GridBagConstraints.BOTH;
		gbc_managersScrollPane.gridx = 0;
		gbc_managersScrollPane.gridy = 0;
		panelManagers.add(managersScrollPane, gbc_managersScrollPane);

		managersInfoTextArea = new JTextArea();
		managersInfoTextArea.setEditable(false);
		managersScrollPane.setViewportView(managersInfoTextArea);

		JTextArea addOrRemoveManagerTextArea = new JTextArea();
		addOrRemoveManagerTextArea.setText("Add/remove player to the system:");
		addOrRemoveManagerTextArea.setEditable(false);
		GridBagConstraints gbc_addOrRemoveManagerTextArea = new GridBagConstraints();
		gbc_addOrRemoveManagerTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_addOrRemoveManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_addOrRemoveManagerTextArea.gridx = 0;
		gbc_addOrRemoveManagerTextArea.gridy = 1;
		panelManagers.add(addOrRemoveManagerTextArea, gbc_addOrRemoveManagerTextArea);

		addManagerRadioButton = new JRadioButton("Add");
		addManagerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addManagerRadioButton.setSelected(true);
				removeManagerRadioButton.setSelected(false);
				removeManagerPanel.setVisible(false);
				addManagerPanel.setVisible(true);
			}
		});
		addManagerRadioButton.setSelected(true);
		GridBagConstraints gbc_addManagerRadioButton = new GridBagConstraints();
		gbc_addManagerRadioButton.fill = GridBagConstraints.BOTH;
		gbc_addManagerRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_addManagerRadioButton.gridx = 1;
		gbc_addManagerRadioButton.gridy = 1;
		panelManagers.add(addManagerRadioButton, gbc_addManagerRadioButton);

		removeManagerRadioButton = new JRadioButton("Remove");
		removeManagerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addManagerRadioButton.setSelected(false);
				removeManagerRadioButton.setSelected(true);
				updateManagerComboBox();
				removeManagerPanel.setVisible(true);
				addManagerPanel.setVisible(false);
			}
		});
		GridBagConstraints gbc_removeManagerRadioButton = new GridBagConstraints();
		gbc_removeManagerRadioButton.fill = GridBagConstraints.BOTH;
		gbc_removeManagerRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_removeManagerRadioButton.gridx = 2;
		gbc_removeManagerRadioButton.gridy = 1;
		panelManagers.add(removeManagerRadioButton, gbc_removeManagerRadioButton);

		JPanel addOrRemoveManagerPanel = new JPanel();
		GridBagConstraints gbc_addOrRemoveManagerPanel = new GridBagConstraints();
		gbc_addOrRemoveManagerPanel.gridheight = 3;
		gbc_addOrRemoveManagerPanel.gridwidth = 3;
		gbc_addOrRemoveManagerPanel.fill = GridBagConstraints.BOTH;
		gbc_addOrRemoveManagerPanel.gridx = 0;
		gbc_addOrRemoveManagerPanel.gridy = 2;
		panelManagers.add(addOrRemoveManagerPanel, gbc_addOrRemoveManagerPanel);
		addOrRemoveManagerPanel.setLayout(new CardLayout(0, 0));

		addManagerPanel = new JPanel();
		addOrRemoveManagerPanel.add(addManagerPanel, "name_1293155319751400");
		GridBagLayout gbl_addManagerPanel = new GridBagLayout();
		gbl_addManagerPanel.columnWidths = new int[] { 170, 0, 0, 0, 0 };
		gbl_addManagerPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 33, 0, 0 };
		gbl_addManagerPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_addManagerPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addManagerPanel.setLayout(gbl_addManagerPanel);

		JTextArea txtrManagerName = new JTextArea();
		txtrManagerName.setText("Manager  Name");
		txtrManagerName.setEditable(false);
		GridBagConstraints gbc_txtrManagerName = new GridBagConstraints();
		gbc_txtrManagerName.fill = GridBagConstraints.BOTH;
		gbc_txtrManagerName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrManagerName.gridx = 0;
		gbc_txtrManagerName.gridy = 0;
		addManagerPanel.add(txtrManagerName, gbc_txtrManagerName);

		addManagerNameTextField = new JTextField();
		addManagerNameTextField.setColumns(10);
		GridBagConstraints gbc_addManagerNameTextField = new GridBagConstraints();
		gbc_addManagerNameTextField.fill = GridBagConstraints.BOTH;
		gbc_addManagerNameTextField.gridwidth = 3;
		gbc_addManagerNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addManagerNameTextField.gridx = 1;
		gbc_addManagerNameTextField.gridy = 0;
		addManagerPanel.add(addManagerNameTextField, gbc_addManagerNameTextField);

		JTextArea dateOfBirthManagertextArea = new JTextArea();
		dateOfBirthManagertextArea.setText("Date Of Birth (day/month/year)");
		dateOfBirthManagertextArea.setEditable(false);
		GridBagConstraints gbc_dateOfBirthManagertextArea = new GridBagConstraints();
		gbc_dateOfBirthManagertextArea.fill = GridBagConstraints.BOTH;
		gbc_dateOfBirthManagertextArea.insets = new Insets(0, 0, 5, 5);
		gbc_dateOfBirthManagertextArea.gridx = 0;
		gbc_dateOfBirthManagertextArea.gridy = 1;
		addManagerPanel.add(dateOfBirthManagertextArea, gbc_dateOfBirthManagertextArea);

		dayManagerTextField = new JTextField();
		dayManagerTextField.setColumns(10);
		GridBagConstraints gbc_dayManagerTextField = new GridBagConstraints();
		gbc_dayManagerTextField.fill = GridBagConstraints.BOTH;
		gbc_dayManagerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dayManagerTextField.gridx = 1;
		gbc_dayManagerTextField.gridy = 1;
		addManagerPanel.add(dayManagerTextField, gbc_dayManagerTextField);

		monthManagerTextField = new JTextField();
		monthManagerTextField.setColumns(10);
		GridBagConstraints gbc_monthManagerTextField = new GridBagConstraints();
		gbc_monthManagerTextField.fill = GridBagConstraints.BOTH;
		gbc_monthManagerTextField.insets = new Insets(0, 0, 5, 5);
		gbc_monthManagerTextField.gridx = 2;
		gbc_monthManagerTextField.gridy = 1;
		addManagerPanel.add(monthManagerTextField, gbc_monthManagerTextField);

		yearManagerTextField = new JTextField();
		yearManagerTextField.setColumns(10);
		GridBagConstraints gbc_yearManagerTextField = new GridBagConstraints();
		gbc_yearManagerTextField.fill = GridBagConstraints.BOTH;
		gbc_yearManagerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_yearManagerTextField.gridx = 3;
		gbc_yearManagerTextField.gridy = 1;
		addManagerPanel.add(yearManagerTextField, gbc_yearManagerTextField);

		JTextArea nationalityManagerTextArea = new JTextArea();
		nationalityManagerTextArea.setText("Nationality");
		nationalityManagerTextArea.setEditable(false);
		GridBagConstraints gbc_nationalityManagerTextArea = new GridBagConstraints();
		gbc_nationalityManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_nationalityManagerTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_nationalityManagerTextArea.gridx = 0;
		gbc_nationalityManagerTextArea.gridy = 2;
		addManagerPanel.add(nationalityManagerTextArea, gbc_nationalityManagerTextArea);

		nationalityManagerTextField = new JTextField();
		nationalityManagerTextField.setColumns(10);
		GridBagConstraints gbc_nationalityManagerTextField = new GridBagConstraints();
		gbc_nationalityManagerTextField.fill = GridBagConstraints.BOTH;
		gbc_nationalityManagerTextField.gridwidth = 3;
		gbc_nationalityManagerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nationalityManagerTextField.gridx = 1;
		gbc_nationalityManagerTextField.gridy = 2;
		addManagerPanel.add(nationalityManagerTextField, gbc_nationalityManagerTextField);

		JTextArea txtrTactics = new JTextArea();
		txtrTactics.setText("Tactics");
		txtrTactics.setEditable(false);
		GridBagConstraints gbc_txtrTactics = new GridBagConstraints();
		gbc_txtrTactics.fill = GridBagConstraints.BOTH;
		gbc_txtrTactics.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTactics.gridx = 0;
		gbc_txtrTactics.gridy = 3;
		addManagerPanel.add(txtrTactics, gbc_txtrTactics);

		tacticsManagerTextField = new JTextField();
		GridBagConstraints gbc_tacticsManagerTextField = new GridBagConstraints();
		gbc_tacticsManagerTextField.gridwidth = 3;
		gbc_tacticsManagerTextField.insets = new Insets(0, 0, 5, 0);
		gbc_tacticsManagerTextField.fill = GridBagConstraints.BOTH;
		gbc_tacticsManagerTextField.gridx = 1;
		gbc_tacticsManagerTextField.gridy = 3;
		addManagerPanel.add(tacticsManagerTextField, gbc_tacticsManagerTextField);
		tacticsManagerTextField.setColumns(10);

		JTextArea teamNameManagerTextArea = new JTextArea();
		teamNameManagerTextArea.setText("Team");
		teamNameManagerTextArea.setEditable(false);
		GridBagConstraints gbc_teamNameManagerTextArea = new GridBagConstraints();
		gbc_teamNameManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_teamNameManagerTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_teamNameManagerTextArea.gridx = 0;
		gbc_teamNameManagerTextArea.gridy = 4;
		addManagerPanel.add(teamNameManagerTextArea, gbc_teamNameManagerTextArea);

		JButton addManagerButton = new JButton("Add Manager");
		addManagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addManager();
			}
		});

		addManagerTeamComboBox = new JComboBox<String>();
		GridBagConstraints gbc_addManagerTeamComboBox = new GridBagConstraints();
		gbc_addManagerTeamComboBox.gridwidth = 3;
		gbc_addManagerTeamComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_addManagerTeamComboBox.fill = GridBagConstraints.BOTH;
		gbc_addManagerTeamComboBox.gridx = 1;
		gbc_addManagerTeamComboBox.gridy = 4;
		addManagerPanel.add(addManagerTeamComboBox, gbc_addManagerTeamComboBox);
		GridBagConstraints gbc_addManagerButton = new GridBagConstraints();
		gbc_addManagerButton.fill = GridBagConstraints.BOTH;
		gbc_addManagerButton.gridwidth = 4;
		gbc_addManagerButton.insets = new Insets(0, 0, 5, 0);
		gbc_addManagerButton.gridx = 0;
		gbc_addManagerButton.gridy = 5;
		addManagerPanel.add(addManagerButton, gbc_addManagerButton);

		addExceptionManagerTextArea = new JTextArea();
		addExceptionManagerTextArea.setEditable(false);
		addExceptionManagerTextArea.setBackground(Color.CYAN);
		GridBagConstraints gbc_addExceptionManagerTextArea = new GridBagConstraints();
		gbc_addExceptionManagerTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_addExceptionManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_addExceptionManagerTextArea.gridwidth = 3;
		gbc_addExceptionManagerTextArea.gridx = 0;
		gbc_addExceptionManagerTextArea.gridy = 6;
		addManagerPanel.add(addExceptionManagerTextArea, gbc_addExceptionManagerTextArea);

		JButton addManagerInitialMenuButton = new JButton("Initial Menu");
		addManagerInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_addManagerInitialMenuButton = new GridBagConstraints();
		gbc_addManagerInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_addManagerInitialMenuButton.gridx = 3;
		gbc_addManagerInitialMenuButton.gridy = 6;
		addManagerPanel.add(addManagerInitialMenuButton, gbc_addManagerInitialMenuButton);

		removeManagerPanel = new JPanel();
		addOrRemoveManagerPanel.add(removeManagerPanel, "name_1296693179092600");
		GridBagLayout gbl_removeManagerPanel = new GridBagLayout();
		gbl_removeManagerPanel.columnWidths = new int[] { 39, 0, 0 };
		gbl_removeManagerPanel.rowHeights = new int[] { 0, 40, 0, 0, 0 };
		gbl_removeManagerPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_removeManagerPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		removeManagerPanel.setLayout(gbl_removeManagerPanel);

		JTextArea removeManagerTextArea = new JTextArea();
		removeManagerTextArea.setText("Manager");
		removeManagerTextArea.setEditable(false);
		GridBagConstraints gbc_removeManagerTextArea = new GridBagConstraints();
		gbc_removeManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_removeManagerTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_removeManagerTextArea.gridx = 0;
		gbc_removeManagerTextArea.gridy = 0;
		removeManagerPanel.add(removeManagerTextArea, gbc_removeManagerTextArea);

		JButton removeManagerButton = new JButton("Remove Manager");
		removeManagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeManager();
			}
		});

		removeManagerComboBox = new JComboBox<String>();
		GridBagConstraints gbc_removeManagerComboBox = new GridBagConstraints();
		gbc_removeManagerComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_removeManagerComboBox.fill = GridBagConstraints.BOTH;
		gbc_removeManagerComboBox.gridx = 1;
		gbc_removeManagerComboBox.gridy = 0;
		removeManagerPanel.add(removeManagerComboBox, gbc_removeManagerComboBox);
		GridBagConstraints gbc_removeManagerButton = new GridBagConstraints();
		gbc_removeManagerButton.fill = GridBagConstraints.BOTH;
		gbc_removeManagerButton.gridwidth = 2;
		gbc_removeManagerButton.insets = new Insets(0, 0, 5, 0);
		gbc_removeManagerButton.gridx = 0;
		gbc_removeManagerButton.gridy = 1;
		removeManagerPanel.add(removeManagerButton, gbc_removeManagerButton);

		removeExceptionManagerTextArea = new JTextArea();
		removeExceptionManagerTextArea.setEditable(false);
		removeExceptionManagerTextArea.setBackground(Color.CYAN);
		GridBagConstraints gbc_removeExceptionManagerTextArea = new GridBagConstraints();
		gbc_removeExceptionManagerTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_removeExceptionManagerTextArea.fill = GridBagConstraints.BOTH;
		gbc_removeExceptionManagerTextArea.gridwidth = 2;
		gbc_removeExceptionManagerTextArea.gridx = 0;
		gbc_removeExceptionManagerTextArea.gridy = 2;
		removeManagerPanel.add(removeExceptionManagerTextArea, gbc_removeExceptionManagerTextArea);

		JButton removeManagerInitialMenuButton = new JButton("Initial Menu");
		removeManagerInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_removeManagerInitialMenuButton = new GridBagConstraints();
		gbc_removeManagerInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_removeManagerInitialMenuButton.gridwidth = 2;
		gbc_removeManagerInitialMenuButton.gridx = 0;
		gbc_removeManagerInitialMenuButton.gridy = 3;
		removeManagerPanel.add(removeManagerInitialMenuButton, gbc_removeManagerInitialMenuButton);

		panelStadiums = new JPanel();
		this.panelPlayers.setVisible(false);
		frame.getContentPane().add(panelStadiums, "name_1316174127823400");
		GridBagLayout gbl_panelStadiums = new GridBagLayout();
		gbl_panelStadiums.columnWidths = new int[] { 313, 394, 0 };
		gbl_panelStadiums.rowHeights = new int[] { 250, 0, 0, 0, 0, 0, 30, 0, 0, 0 };
		gbl_panelStadiums.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelStadiums.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelStadiums.setLayout(gbl_panelStadiums);

		JScrollPane stadiumsScrollPane = new JScrollPane();
		GridBagConstraints gbc_stadiumsScrollPane = new GridBagConstraints();
		gbc_stadiumsScrollPane.gridwidth = 2;
		gbc_stadiumsScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_stadiumsScrollPane.fill = GridBagConstraints.BOTH;
		gbc_stadiumsScrollPane.gridx = 0;
		gbc_stadiumsScrollPane.gridy = 0;
		panelStadiums.add(stadiumsScrollPane, gbc_stadiumsScrollPane);

		stadiumsInfoTextArea = new JTextArea();
		stadiumsInfoTextArea.setEditable(false);
		stadiumsScrollPane.setViewportView(stadiumsInfoTextArea);

		JTextArea txtrToCreateA = new JTextArea();
		txtrToCreateA.setText("To create a new stadium fill the boxes below.");
		txtrToCreateA.setEditable(false);
		GridBagConstraints gbc_txtrToCreateA = new GridBagConstraints();
		gbc_txtrToCreateA.gridwidth = 2;
		gbc_txtrToCreateA.insets = new Insets(0, 0, 5, 0);
		gbc_txtrToCreateA.fill = GridBagConstraints.BOTH;
		gbc_txtrToCreateA.gridx = 0;
		gbc_txtrToCreateA.gridy = 1;
		panelStadiums.add(txtrToCreateA, gbc_txtrToCreateA);

		JTextArea txtrStadiumName = new JTextArea();
		txtrStadiumName.setEditable(false);
		txtrStadiumName.setText("Stadium Name");
		GridBagConstraints gbc_txtrStadiumName = new GridBagConstraints();
		gbc_txtrStadiumName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrStadiumName.fill = GridBagConstraints.BOTH;
		gbc_txtrStadiumName.gridx = 0;
		gbc_txtrStadiumName.gridy = 2;
		panelStadiums.add(txtrStadiumName, gbc_txtrStadiumName);

		addStadiumNameTextField = new JTextField();
		GridBagConstraints gbc_addStadiumNameTextField = new GridBagConstraints();
		gbc_addStadiumNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addStadiumNameTextField.fill = GridBagConstraints.BOTH;
		gbc_addStadiumNameTextField.gridx = 1;
		gbc_addStadiumNameTextField.gridy = 2;
		panelStadiums.add(addStadiumNameTextField, gbc_addStadiumNameTextField);
		addStadiumNameTextField.setColumns(10);

		JTextArea txtrCountry = new JTextArea();
		txtrCountry.setText("Country");
		txtrCountry.setEditable(false);
		GridBagConstraints gbc_txtrCountry = new GridBagConstraints();
		gbc_txtrCountry.insets = new Insets(0, 0, 5, 5);
		gbc_txtrCountry.fill = GridBagConstraints.BOTH;
		gbc_txtrCountry.gridx = 0;
		gbc_txtrCountry.gridy = 3;
		panelStadiums.add(txtrCountry, gbc_txtrCountry);

		addStadiumCountryTextField = new JTextField();
		GridBagConstraints gbc_addStadiumCountryTextField = new GridBagConstraints();
		gbc_addStadiumCountryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addStadiumCountryTextField.fill = GridBagConstraints.BOTH;
		gbc_addStadiumCountryTextField.gridx = 1;
		gbc_addStadiumCountryTextField.gridy = 3;
		panelStadiums.add(addStadiumCountryTextField, gbc_addStadiumCountryTextField);
		addStadiumCountryTextField.setColumns(10);

		JTextArea txtrCapacity = new JTextArea();
		txtrCapacity.setText("Capacity");
		txtrCapacity.setEditable(false);
		GridBagConstraints gbc_txtrCapacity = new GridBagConstraints();
		gbc_txtrCapacity.insets = new Insets(0, 0, 5, 5);
		gbc_txtrCapacity.fill = GridBagConstraints.BOTH;
		gbc_txtrCapacity.gridx = 0;
		gbc_txtrCapacity.gridy = 4;
		panelStadiums.add(txtrCapacity, gbc_txtrCapacity);

		addStadiumCapacityTextField = new JTextField();
		GridBagConstraints gbc_addStadiumCapacityTextField = new GridBagConstraints();
		gbc_addStadiumCapacityTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addStadiumCapacityTextField.fill = GridBagConstraints.BOTH;
		gbc_addStadiumCapacityTextField.gridx = 1;
		gbc_addStadiumCapacityTextField.gridy = 4;
		panelStadiums.add(addStadiumCapacityTextField, gbc_addStadiumCapacityTextField);
		addStadiumCapacityTextField.setColumns(10);

		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("Address");
		txtrAddress.setEditable(false);
		GridBagConstraints gbc_txtrAddress = new GridBagConstraints();
		gbc_txtrAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtrAddress.fill = GridBagConstraints.BOTH;
		gbc_txtrAddress.gridx = 0;
		gbc_txtrAddress.gridy = 5;
		panelStadiums.add(txtrAddress, gbc_txtrAddress);

		addStadiumAddressTextField = new JTextField();
		GridBagConstraints gbc_addStadiumAddressTextField = new GridBagConstraints();
		gbc_addStadiumAddressTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addStadiumAddressTextField.fill = GridBagConstraints.BOTH;
		gbc_addStadiumAddressTextField.gridx = 1;
		gbc_addStadiumAddressTextField.gridy = 5;
		panelStadiums.add(addStadiumAddressTextField, gbc_addStadiumAddressTextField);
		addStadiumAddressTextField.setColumns(10);

		JButton addStadiumButton = new JButton("Add Stadium");
		addStadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStadium();
			}
		});
		GridBagConstraints gbc_addStadiumButton = new GridBagConstraints();
		gbc_addStadiumButton.insets = new Insets(0, 0, 5, 0);
		gbc_addStadiumButton.fill = GridBagConstraints.BOTH;
		gbc_addStadiumButton.gridwidth = 2;
		gbc_addStadiumButton.gridx = 0;
		gbc_addStadiumButton.gridy = 6;
		panelStadiums.add(addStadiumButton, gbc_addStadiumButton);

		addExceptionStadiumTextArea = new JTextArea();
		addExceptionStadiumTextArea.setBackground(Color.CYAN);
		GridBagConstraints gbc_addExceptionStadiumTextArea = new GridBagConstraints();
		gbc_addExceptionStadiumTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_addExceptionStadiumTextArea.gridwidth = 2;
		gbc_addExceptionStadiumTextArea.fill = GridBagConstraints.BOTH;
		gbc_addExceptionStadiumTextArea.gridx = 0;
		gbc_addExceptionStadiumTextArea.gridy = 7;
		panelStadiums.add(addExceptionStadiumTextArea, gbc_addExceptionStadiumTextArea);

		JButton stadiumInitialMenuButton = new JButton("Initial Menu");
		stadiumInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_stadiumInitialMenuButton = new GridBagConstraints();
		gbc_stadiumInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_stadiumInitialMenuButton.gridwidth = 2;
		gbc_stadiumInitialMenuButton.gridx = 0;
		gbc_stadiumInitialMenuButton.gridy = 8;
		panelStadiums.add(stadiumInitialMenuButton, gbc_stadiumInitialMenuButton);

		panelTeams = new JPanel();
		frame.getContentPane().add(panelTeams, "name_9760851099800");
		GridBagLayout gbl_panelTeams = new GridBagLayout();
		gbl_panelTeams.columnWidths = new int[] { 285, 250, 0 };
		gbl_panelTeams.rowHeights = new int[] { 220, 0, 0, 0, 0, 25, 100, 0, 30, 0, 0 };
		gbl_panelTeams.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelTeams.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTeams.setLayout(gbl_panelTeams);

		JButton teamsInitialMenuButton = new JButton("Initial menu");
		teamsInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});

		JScrollPane teamScrollPane = new JScrollPane();
		GridBagConstraints gbc_teamScrollPane = new GridBagConstraints();
		gbc_teamScrollPane.gridwidth = 2;
		gbc_teamScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_teamScrollPane.fill = GridBagConstraints.BOTH;
		gbc_teamScrollPane.gridx = 0;
		gbc_teamScrollPane.gridy = 0;
		panelTeams.add(teamScrollPane, gbc_teamScrollPane);

		teamsInfoTextArea = new JTextArea();
		teamsInfoTextArea.setEditable(false);
		teamScrollPane.setViewportView(teamsInfoTextArea);

		JTextArea txtrChooseWhetherTo = new JTextArea();
		txtrChooseWhetherTo.setText("To create a new team fill the form below.");
		txtrChooseWhetherTo.setEditable(false);
		GridBagConstraints gbc_txtrChooseWhetherTo = new GridBagConstraints();
		gbc_txtrChooseWhetherTo.gridwidth = 2;
		gbc_txtrChooseWhetherTo.insets = new Insets(0, 0, 5, 0);
		gbc_txtrChooseWhetherTo.fill = GridBagConstraints.BOTH;
		gbc_txtrChooseWhetherTo.gridx = 0;
		gbc_txtrChooseWhetherTo.gridy = 1;
		panelTeams.add(txtrChooseWhetherTo, gbc_txtrChooseWhetherTo);

		JTextArea txtrTeamName_1 = new JTextArea();
		txtrTeamName_1.setEditable(false);
		txtrTeamName_1.setText("Team name");
		GridBagConstraints gbc_txtrTeamName_1 = new GridBagConstraints();
		gbc_txtrTeamName_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTeamName_1.fill = GridBagConstraints.BOTH;
		gbc_txtrTeamName_1.gridx = 0;
		gbc_txtrTeamName_1.gridy = 2;
		panelTeams.add(txtrTeamName_1, gbc_txtrTeamName_1);

		teamNameTeamTextField = new JTextField();
		GridBagConstraints gbc_teamNameTeamTextField = new GridBagConstraints();
		gbc_teamNameTeamTextField.insets = new Insets(0, 0, 5, 0);
		gbc_teamNameTeamTextField.fill = GridBagConstraints.BOTH;
		gbc_teamNameTeamTextField.gridx = 1;
		gbc_teamNameTeamTextField.gridy = 2;
		panelTeams.add(teamNameTeamTextField, gbc_teamNameTeamTextField);
		teamNameTeamTextField.setColumns(10);

		JTextArea txtrShortTeamName = new JTextArea();
		txtrShortTeamName.setEditable(false);
		txtrShortTeamName.setText("Short team name (exactly 4 letters)");
		GridBagConstraints gbc_txtrShortTeamName = new GridBagConstraints();
		gbc_txtrShortTeamName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrShortTeamName.fill = GridBagConstraints.BOTH;
		gbc_txtrShortTeamName.gridx = 0;
		gbc_txtrShortTeamName.gridy = 3;
		panelTeams.add(txtrShortTeamName, gbc_txtrShortTeamName);

		shortTeamNameTeamTextField = new JTextField();
		GridBagConstraints gbc_shortTeamNameTeamTextField = new GridBagConstraints();
		gbc_shortTeamNameTeamTextField.insets = new Insets(0, 0, 5, 0);
		gbc_shortTeamNameTeamTextField.fill = GridBagConstraints.BOTH;
		gbc_shortTeamNameTeamTextField.gridx = 1;
		gbc_shortTeamNameTeamTextField.gridy = 3;
		panelTeams.add(shortTeamNameTeamTextField, gbc_shortTeamNameTeamTextField);
		shortTeamNameTeamTextField.setColumns(10);

		JTextArea txtrManagerName_1 = new JTextArea();
		txtrManagerName_1.setEditable(false);
		txtrManagerName_1.setText("Manager name");
		GridBagConstraints gbc_txtrManagerName_1 = new GridBagConstraints();
		gbc_txtrManagerName_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtrManagerName_1.fill = GridBagConstraints.BOTH;
		gbc_txtrManagerName_1.gridx = 0;
		gbc_txtrManagerName_1.gridy = 4;
		panelTeams.add(txtrManagerName_1, gbc_txtrManagerName_1);

		teamManagerComboBox = new JComboBox<String>();
		GridBagConstraints gbc_teamManagerComboBox = new GridBagConstraints();
		gbc_teamManagerComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_teamManagerComboBox.fill = GridBagConstraints.BOTH;
		gbc_teamManagerComboBox.gridx = 1;
		gbc_teamManagerComboBox.gridy = 4;
		panelTeams.add(teamManagerComboBox, gbc_teamManagerComboBox);

		JTextArea txtrStadiumName_1 = new JTextArea();
		txtrStadiumName_1.setEditable(false);
		txtrStadiumName_1.setText("Stadium name");
		GridBagConstraints gbc_txtrStadiumName_1 = new GridBagConstraints();
		gbc_txtrStadiumName_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtrStadiumName_1.fill = GridBagConstraints.BOTH;
		gbc_txtrStadiumName_1.gridx = 0;
		gbc_txtrStadiumName_1.gridy = 5;
		panelTeams.add(txtrStadiumName_1, gbc_txtrStadiumName_1);

		teamStadiumComboBox = new JComboBox<String>();
		GridBagConstraints gbc_teamStadiumComboBox = new GridBagConstraints();
		gbc_teamStadiumComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_teamStadiumComboBox.fill = GridBagConstraints.BOTH;
		gbc_teamStadiumComboBox.gridx = 1;
		gbc_teamStadiumComboBox.gridy = 5;
		panelTeams.add(teamStadiumComboBox, gbc_teamStadiumComboBox);

		JTextArea txtrPlayersindicesSeparated = new JTextArea();
		txtrPlayersindicesSeparated.setLineWrap(true);
		txtrPlayersindicesSeparated.setEditable(false);
		txtrPlayersindicesSeparated.setText("Players (hold Ctrl button for multiple selection)");
		GridBagConstraints gbc_txtrPlayersindicesSeparated = new GridBagConstraints();
		gbc_txtrPlayersindicesSeparated.insets = new Insets(0, 0, 5, 5);
		gbc_txtrPlayersindicesSeparated.fill = GridBagConstraints.BOTH;
		gbc_txtrPlayersindicesSeparated.gridx = 0;
		gbc_txtrPlayersindicesSeparated.gridy = 6;
		panelTeams.add(txtrPlayersindicesSeparated, gbc_txtrPlayersindicesSeparated);

		JButton createteamButton = new JButton("Create Team");
		createteamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeam();
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 6;
		panelTeams.add(scrollPane_1, gbc_scrollPane_1);

		playersOfTeamList = new JList<String>();
		playersOfTeamList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(playersOfTeamList);
		GridBagConstraints gbc_createteamButton = new GridBagConstraints();
		gbc_createteamButton.gridwidth = 2;
		gbc_createteamButton.fill = GridBagConstraints.BOTH;
		gbc_createteamButton.insets = new Insets(0, 0, 5, 0);
		gbc_createteamButton.gridx = 0;
		gbc_createteamButton.gridy = 7;
		panelTeams.add(createteamButton, gbc_createteamButton);

		exceptionTeamsTextField = new JTextField();
		exceptionTeamsTextField.setEditable(false);
		exceptionTeamsTextField.setBackground(Color.CYAN);
		GridBagConstraints gbc_exceptionTeamsTextField = new GridBagConstraints();
		gbc_exceptionTeamsTextField.gridwidth = 2;
		gbc_exceptionTeamsTextField.insets = new Insets(0, 0, 5, 0);
		gbc_exceptionTeamsTextField.fill = GridBagConstraints.BOTH;
		gbc_exceptionTeamsTextField.gridx = 0;
		gbc_exceptionTeamsTextField.gridy = 8;
		panelTeams.add(exceptionTeamsTextField, gbc_exceptionTeamsTextField);
		exceptionTeamsTextField.setColumns(10);
		GridBagConstraints gbc_teamsInitialMenuButton = new GridBagConstraints();
		gbc_teamsInitialMenuButton.gridwidth = 2;
		gbc_teamsInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_teamsInitialMenuButton.gridx = 0;
		gbc_teamsInitialMenuButton.gridy = 9;
		panelTeams.add(teamsInitialMenuButton, gbc_teamsInitialMenuButton);

		panelFootballCompetition = new JPanel();
		frame.getContentPane().add(panelFootballCompetition, "name_33329815421599");
		GridBagLayout gbl_panelFootballCompetition = new GridBagLayout();
		gbl_panelFootballCompetition.columnWidths = new int[] { 300, 100, 100, 0 };
		gbl_panelFootballCompetition.rowHeights = new int[] { 0, 0, 30, 30, 0, 0, 100, 0, 30, 0 };
		gbl_panelFootballCompetition.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelFootballCompetition.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelFootballCompetition.setLayout(gbl_panelFootballCompetition);

		JScrollPane competitionsInfoScrollPane = new JScrollPane();
		GridBagConstraints gbc_competitionsInfoScrollPane = new GridBagConstraints();
		gbc_competitionsInfoScrollPane.gridwidth = 3;
		gbc_competitionsInfoScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_competitionsInfoScrollPane.fill = GridBagConstraints.BOTH;
		gbc_competitionsInfoScrollPane.gridx = 0;
		gbc_competitionsInfoScrollPane.gridy = 0;
		panelFootballCompetition.add(competitionsInfoScrollPane, gbc_competitionsInfoScrollPane);

		competitionsInfoTextArea = new JTextArea();
		competitionsInfoTextArea.setFont(new Font("Arial", Font.PLAIN, 13));
		competitionsInfoTextArea.setEditable(false);
		competitionsInfoScrollPane.setViewportView(competitionsInfoTextArea);

		JTextArea txtrChooseACompetition = new JTextArea();
		txtrChooseACompetition.setText("Choose a competition to operate with");
		txtrChooseACompetition.setEditable(false);
		GridBagConstraints gbc_txtrChooseACompetition = new GridBagConstraints();
		gbc_txtrChooseACompetition.insets = new Insets(0, 0, 5, 5);
		gbc_txtrChooseACompetition.fill = GridBagConstraints.BOTH;
		gbc_txtrChooseACompetition.gridx = 0;
		gbc_txtrChooseACompetition.gridy = 1;
		panelFootballCompetition.add(txtrChooseACompetition, gbc_txtrChooseACompetition);

		chooseSpecificCompetitionComboBox = new JComboBox<String>();
		GridBagConstraints gbc_chooseSpecificCompetitionComboBox = new GridBagConstraints();
		gbc_chooseSpecificCompetitionComboBox.gridwidth = 2;
		gbc_chooseSpecificCompetitionComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_chooseSpecificCompetitionComboBox.fill = GridBagConstraints.BOTH;
		gbc_chooseSpecificCompetitionComboBox.gridx = 1;
		gbc_chooseSpecificCompetitionComboBox.gridy = 1;
		panelFootballCompetition.add(chooseSpecificCompetitionComboBox, gbc_chooseSpecificCompetitionComboBox);

		createNewLeagueRadioButton = new JRadioButton("League");
		createNewLeagueRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewKnockoutRadioButton.setSelected(false);
				createNewLeagueRadioButton.setSelected(true);
			}
		});

		JButton chooseSpecificCompetitionButton = new JButton("Choose Competition");
		chooseSpecificCompetitionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSpecificCompetition();
			}
		});
		GridBagConstraints gbc_chooseSpecificCompetitionButton = new GridBagConstraints();
		gbc_chooseSpecificCompetitionButton.fill = GridBagConstraints.BOTH;
		gbc_chooseSpecificCompetitionButton.gridwidth = 3;
		gbc_chooseSpecificCompetitionButton.insets = new Insets(0, 0, 5, 0);
		gbc_chooseSpecificCompetitionButton.gridx = 0;
		gbc_chooseSpecificCompetitionButton.gridy = 2;
		panelFootballCompetition.add(chooseSpecificCompetitionButton, gbc_chooseSpecificCompetitionButton);

		JTextArea txtrToCreateA_1 = new JTextArea();
		txtrToCreateA_1.setText("To create a competition fill the form");
		txtrToCreateA_1.setEditable(false);
		GridBagConstraints gbc_txtrToCreateA_1 = new GridBagConstraints();
		gbc_txtrToCreateA_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtrToCreateA_1.fill = GridBagConstraints.BOTH;
		gbc_txtrToCreateA_1.gridx = 0;
		gbc_txtrToCreateA_1.gridy = 3;
		panelFootballCompetition.add(txtrToCreateA_1, gbc_txtrToCreateA_1);
		createNewLeagueRadioButton.setSelected(true);
		GridBagConstraints gbc_createNewLeagueRadioButton = new GridBagConstraints();
		gbc_createNewLeagueRadioButton.fill = GridBagConstraints.BOTH;
		gbc_createNewLeagueRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_createNewLeagueRadioButton.gridx = 1;
		gbc_createNewLeagueRadioButton.gridy = 3;
		panelFootballCompetition.add(createNewLeagueRadioButton, gbc_createNewLeagueRadioButton);

		createNewKnockoutRadioButton = new JRadioButton("Knockout");
		createNewKnockoutRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewKnockoutRadioButton.setSelected(true);
				createNewLeagueRadioButton.setSelected(false);
			}
		});
		GridBagConstraints gbc_createNewKnockoutRadioButton = new GridBagConstraints();
		gbc_createNewKnockoutRadioButton.fill = GridBagConstraints.BOTH;
		gbc_createNewKnockoutRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_createNewKnockoutRadioButton.gridx = 2;
		gbc_createNewKnockoutRadioButton.gridy = 3;
		panelFootballCompetition.add(createNewKnockoutRadioButton, gbc_createNewKnockoutRadioButton);

		JTextArea txtrCompetitionName = new JTextArea();
		txtrCompetitionName.setText("Competition name");
		txtrCompetitionName.setEditable(false);
		GridBagConstraints gbc_txtrCompetitionName = new GridBagConstraints();
		gbc_txtrCompetitionName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrCompetitionName.fill = GridBagConstraints.BOTH;
		gbc_txtrCompetitionName.gridx = 0;
		gbc_txtrCompetitionName.gridy = 4;
		panelFootballCompetition.add(txtrCompetitionName, gbc_txtrCompetitionName);

		createCompetitionNameTextField = new JTextField();
		GridBagConstraints gbc_createCompetitionNameTextField = new GridBagConstraints();
		gbc_createCompetitionNameTextField.gridwidth = 2;
		gbc_createCompetitionNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_createCompetitionNameTextField.fill = GridBagConstraints.BOTH;
		gbc_createCompetitionNameTextField.gridx = 1;
		gbc_createCompetitionNameTextField.gridy = 4;
		panelFootballCompetition.add(createCompetitionNameTextField, gbc_createCompetitionNameTextField);
		createCompetitionNameTextField.setColumns(10);

		JTextArea txtrCountry_1 = new JTextArea();
		txtrCountry_1.setEditable(false);
		txtrCountry_1.setText("Country");
		GridBagConstraints gbc_txtrCountry_1 = new GridBagConstraints();
		gbc_txtrCountry_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtrCountry_1.fill = GridBagConstraints.BOTH;
		gbc_txtrCountry_1.gridx = 0;
		gbc_txtrCountry_1.gridy = 5;
		panelFootballCompetition.add(txtrCountry_1, gbc_txtrCountry_1);

		createCompetitionCountryTextField = new JTextField();
		GridBagConstraints gbc_createCompetitionCountryTextField = new GridBagConstraints();
		gbc_createCompetitionCountryTextField.gridwidth = 2;
		gbc_createCompetitionCountryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_createCompetitionCountryTextField.fill = GridBagConstraints.BOTH;
		gbc_createCompetitionCountryTextField.gridx = 1;
		gbc_createCompetitionCountryTextField.gridy = 5;
		panelFootballCompetition.add(createCompetitionCountryTextField, gbc_createCompetitionCountryTextField);
		createCompetitionCountryTextField.setColumns(10);

		JTextArea txtrTeamsuseTheir = new JTextArea();
		txtrTeamsuseTheir.setLineWrap(true);
		txtrTeamsuseTheir.setText("Teams (for multiple selection hold Ctrl button)");
		txtrTeamsuseTheir.setEditable(false);
		GridBagConstraints gbc_txtrTeamsuseTheir = new GridBagConstraints();
		gbc_txtrTeamsuseTheir.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTeamsuseTheir.fill = GridBagConstraints.BOTH;
		gbc_txtrTeamsuseTheir.gridx = 0;
		gbc_txtrTeamsuseTheir.gridy = 6;
		panelFootballCompetition.add(txtrTeamsuseTheir, gbc_txtrTeamsuseTheir);

		JButton createCompetition = new JButton("Create competition");
		createCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCompetition();
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 6;
		panelFootballCompetition.add(scrollPane_2, gbc_scrollPane_2);

		addCompetitionTeamsList = new JList<String>();
		scrollPane_2.setViewportView(addCompetitionTeamsList);
		GridBagConstraints gbc_createCompetition = new GridBagConstraints();
		gbc_createCompetition.insets = new Insets(0, 0, 5, 0);
		gbc_createCompetition.fill = GridBagConstraints.BOTH;
		gbc_createCompetition.gridwidth = 3;
		gbc_createCompetition.gridx = 0;
		gbc_createCompetition.gridy = 7;
		panelFootballCompetition.add(createCompetition, gbc_createCompetition);

		competitionExceptionTextArea = new JTextArea();
		competitionExceptionTextArea.setEditable(false);
		competitionExceptionTextArea.setBackground(Color.CYAN);
		GridBagConstraints gbc_competitionExceptionTextArea = new GridBagConstraints();
		gbc_competitionExceptionTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_competitionExceptionTextArea.fill = GridBagConstraints.BOTH;
		gbc_competitionExceptionTextArea.gridx = 0;
		gbc_competitionExceptionTextArea.gridy = 8;
		panelFootballCompetition.add(competitionExceptionTextArea, gbc_competitionExceptionTextArea);

		JButton goToInitialMenuCompetition = new JButton("Initial Menu");
		goToInitialMenuCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_goToInitialMenuCompetition = new GridBagConstraints();
		gbc_goToInitialMenuCompetition.gridwidth = 2;
		gbc_goToInitialMenuCompetition.fill = GridBagConstraints.BOTH;
		gbc_goToInitialMenuCompetition.gridx = 1;
		gbc_goToInitialMenuCompetition.gridy = 8;
		panelFootballCompetition.add(goToInitialMenuCompetition, gbc_goToInitialMenuCompetition);

		panelSpecificFootballCompetition = new JPanel();
		frame.getContentPane().add(panelSpecificFootballCompetition, "name_47846484049500");
		GridBagLayout gbl_panelSpecificFootballCompetition = new GridBagLayout();
		gbl_panelSpecificFootballCompetition.columnWidths = new int[] { 100, 200, 200, 0 };
		gbl_panelSpecificFootballCompetition.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelSpecificFootballCompetition.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelSpecificFootballCompetition.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelSpecificFootballCompetition.setLayout(gbl_panelSpecificFootballCompetition);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelSpecificFootballCompetition.add(scrollPane, gbc_scrollPane);

		specificCompetitionInfoTextArea = new JTextArea();
		specificCompetitionInfoTextArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		specificCompetitionInfoTextArea.setEditable(false);
		scrollPane.setViewportView(specificCompetitionInfoTextArea);

		JTextArea txtrToAddA = new JTextArea();
		txtrToAddA.setText("To add a match fill the form below.");
		txtrToAddA.setEditable(false);
		GridBagConstraints gbc_txtrToAddA = new GridBagConstraints();
		gbc_txtrToAddA.gridwidth = 3;
		gbc_txtrToAddA.insets = new Insets(0, 0, 5, 0);
		gbc_txtrToAddA.fill = GridBagConstraints.BOTH;
		gbc_txtrToAddA.gridx = 0;
		gbc_txtrToAddA.gridy = 1;
		panelSpecificFootballCompetition.add(txtrToAddA, gbc_txtrToAddA);

		JTextArea txtrHomeTeam = new JTextArea();
		txtrHomeTeam.setEditable(false);
		txtrHomeTeam.setText("Home Team");
		GridBagConstraints gbc_txtrHomeTeam = new GridBagConstraints();
		gbc_txtrHomeTeam.insets = new Insets(0, 0, 5, 5);
		gbc_txtrHomeTeam.fill = GridBagConstraints.BOTH;
		gbc_txtrHomeTeam.gridx = 1;
		gbc_txtrHomeTeam.gridy = 2;
		panelSpecificFootballCompetition.add(txtrHomeTeam, gbc_txtrHomeTeam);

		JTextArea txtrAwayTeam = new JTextArea();
		txtrAwayTeam.setText("Away Team");
		txtrAwayTeam.setEditable(false);
		GridBagConstraints gbc_txtrAwayTeam = new GridBagConstraints();
		gbc_txtrAwayTeam.insets = new Insets(0, 0, 5, 0);
		gbc_txtrAwayTeam.fill = GridBagConstraints.BOTH;
		gbc_txtrAwayTeam.gridx = 2;
		gbc_txtrAwayTeam.gridy = 2;
		panelSpecificFootballCompetition.add(txtrAwayTeam, gbc_txtrAwayTeam);

		JTextArea txtrName = new JTextArea();
		txtrName.setEditable(false);
		txtrName.setText("Name");
		GridBagConstraints gbc_txtrName = new GridBagConstraints();
		gbc_txtrName.insets = new Insets(0, 0, 5, 5);
		gbc_txtrName.fill = GridBagConstraints.BOTH;
		gbc_txtrName.gridx = 0;
		gbc_txtrName.gridy = 3;
		panelSpecificFootballCompetition.add(txtrName, gbc_txtrName);

		addMatchHomeTeamNameComboBox = new JComboBox<String>();
		GridBagConstraints gbc_addMatchHomeTeamNameComboBox = new GridBagConstraints();
		gbc_addMatchHomeTeamNameComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_addMatchHomeTeamNameComboBox.fill = GridBagConstraints.BOTH;
		gbc_addMatchHomeTeamNameComboBox.gridx = 1;
		gbc_addMatchHomeTeamNameComboBox.gridy = 3;
		panelSpecificFootballCompetition.add(addMatchHomeTeamNameComboBox, gbc_addMatchHomeTeamNameComboBox);

		addMatchAwayTeamNameComboBox = new JComboBox<String>();
		GridBagConstraints gbc_addMatchAwayTeamNameComboBox = new GridBagConstraints();
		gbc_addMatchAwayTeamNameComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_addMatchAwayTeamNameComboBox.fill = GridBagConstraints.BOTH;
		gbc_addMatchAwayTeamNameComboBox.gridx = 2;
		gbc_addMatchAwayTeamNameComboBox.gridy = 3;
		panelSpecificFootballCompetition.add(addMatchAwayTeamNameComboBox, gbc_addMatchAwayTeamNameComboBox);

		JTextArea txtrGoalsScored = new JTextArea();
		txtrGoalsScored.setText("Goals Scored");
		txtrGoalsScored.setEditable(false);
		GridBagConstraints gbc_txtrGoalsScored = new GridBagConstraints();
		gbc_txtrGoalsScored.insets = new Insets(0, 0, 5, 5);
		gbc_txtrGoalsScored.fill = GridBagConstraints.BOTH;
		gbc_txtrGoalsScored.gridx = 0;
		gbc_txtrGoalsScored.gridy = 4;
		panelSpecificFootballCompetition.add(txtrGoalsScored, gbc_txtrGoalsScored);

		addMatchInCompetitionButton = new JButton("Add match");
		addMatchInCompetitionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMatchInSpecificCompetition();
			}
		});

		addMatchHomeTeamGoalsComboBox = new JComboBox<Integer>();
		addMatchHomeTeamGoalsComboBox
				.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		GridBagConstraints gbc_addMatchHomeTeamGoalsComboBox = new GridBagConstraints();
		gbc_addMatchHomeTeamGoalsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_addMatchHomeTeamGoalsComboBox.fill = GridBagConstraints.BOTH;
		gbc_addMatchHomeTeamGoalsComboBox.gridx = 1;
		gbc_addMatchHomeTeamGoalsComboBox.gridy = 4;
		panelSpecificFootballCompetition.add(addMatchHomeTeamGoalsComboBox, gbc_addMatchHomeTeamGoalsComboBox);

		addMatchAwayTeamGoalsComboBox = new JComboBox<Integer>();
		addMatchAwayTeamGoalsComboBox
				.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		GridBagConstraints gbc_addMatchAwayTeamGoalsComboBox = new GridBagConstraints();
		gbc_addMatchAwayTeamGoalsComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_addMatchAwayTeamGoalsComboBox.fill = GridBagConstraints.BOTH;
		gbc_addMatchAwayTeamGoalsComboBox.gridx = 2;
		gbc_addMatchAwayTeamGoalsComboBox.gridy = 4;
		panelSpecificFootballCompetition.add(addMatchAwayTeamGoalsComboBox, gbc_addMatchAwayTeamGoalsComboBox);
		GridBagConstraints gbc_addMatchInCompetitionButton = new GridBagConstraints();
		gbc_addMatchInCompetitionButton.fill = GridBagConstraints.BOTH;
		gbc_addMatchInCompetitionButton.gridwidth = 3;
		gbc_addMatchInCompetitionButton.insets = new Insets(0, 0, 5, 0);
		gbc_addMatchInCompetitionButton.gridx = 0;
		gbc_addMatchInCompetitionButton.gridy = 5;
		panelSpecificFootballCompetition.add(addMatchInCompetitionButton, gbc_addMatchInCompetitionButton);

		JTextArea txtrToRemoveA = new JTextArea();
		txtrToRemoveA.setEditable(false);
		txtrToRemoveA.setText("To remove a team fill the form below.");
		GridBagConstraints gbc_txtrToRemoveA = new GridBagConstraints();
		gbc_txtrToRemoveA.insets = new Insets(0, 0, 5, 0);
		gbc_txtrToRemoveA.gridwidth = 3;
		gbc_txtrToRemoveA.fill = GridBagConstraints.BOTH;
		gbc_txtrToRemoveA.gridx = 0;
		gbc_txtrToRemoveA.gridy = 6;
		panelSpecificFootballCompetition.add(txtrToRemoveA, gbc_txtrToRemoveA);

		JTextArea txtrTeamName_2 = new JTextArea();
		txtrTeamName_2.setText("Team Name");
		txtrTeamName_2.setEditable(false);
		GridBagConstraints gbc_txtrTeamName_2 = new GridBagConstraints();
		gbc_txtrTeamName_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTeamName_2.fill = GridBagConstraints.BOTH;
		gbc_txtrTeamName_2.gridx = 0;
		gbc_txtrTeamName_2.gridy = 7;
		panelSpecificFootballCompetition.add(txtrTeamName_2, gbc_txtrTeamName_2);

		removeTeamFromSpecificCompetition = new JButton("Remove Team");
		removeTeamFromSpecificCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTeamFromSpecificCompetition();
			}
		});

		removeTeamFromSpecificCompetitionComboBox = new JComboBox<String>();
		GridBagConstraints gbc_removeTeamFromSpecificCompetitionComboBox = new GridBagConstraints();
		gbc_removeTeamFromSpecificCompetitionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_removeTeamFromSpecificCompetitionComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_removeTeamFromSpecificCompetitionComboBox.gridx = 1;
		gbc_removeTeamFromSpecificCompetitionComboBox.gridy = 7;
		panelSpecificFootballCompetition.add(removeTeamFromSpecificCompetitionComboBox,
				gbc_removeTeamFromSpecificCompetitionComboBox);
		GridBagConstraints gbc_removeTeamFromSpecificCompetition = new GridBagConstraints();
		gbc_removeTeamFromSpecificCompetition.insets = new Insets(0, 0, 5, 0);
		gbc_removeTeamFromSpecificCompetition.fill = GridBagConstraints.BOTH;
		gbc_removeTeamFromSpecificCompetition.gridx = 2;
		gbc_removeTeamFromSpecificCompetition.gridy = 7;
		panelSpecificFootballCompetition.add(removeTeamFromSpecificCompetition, gbc_removeTeamFromSpecificCompetition);

		JButton specificInitialMenuButton = new JButton("Initial Menu");
		specificInitialMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToInitialMenu();
			}
		});
		GridBagConstraints gbc_specificInitialMenuButton = new GridBagConstraints();
		gbc_specificInitialMenuButton.fill = GridBagConstraints.BOTH;
		gbc_specificInitialMenuButton.insets = new Insets(0, 0, 0, 5);
		gbc_specificInitialMenuButton.gridx = 0;
		gbc_specificInitialMenuButton.gridy = 8;
		panelSpecificFootballCompetition.add(specificInitialMenuButton, gbc_specificInitialMenuButton);

		specificCompetitionExceptionTextArea = new JTextArea();
		specificCompetitionExceptionTextArea.setBackground(Color.CYAN);
		specificCompetitionExceptionTextArea.setEditable(false);
		GridBagConstraints gbc_specificCompetitionExceptionTextArea = new GridBagConstraints();
		gbc_specificCompetitionExceptionTextArea.gridwidth = 2;
		gbc_specificCompetitionExceptionTextArea.fill = GridBagConstraints.BOTH;
		gbc_specificCompetitionExceptionTextArea.gridx = 1;
		gbc_specificCompetitionExceptionTextArea.gridy = 8;
		panelSpecificFootballCompetition.add(specificCompetitionExceptionTextArea,
				gbc_specificCompetitionExceptionTextArea);
	}

	/**
	 * Go to the initial menu.
	 */
	private void goToInitialMenu() {
		panelInitialMenu.setVisible(true);
		panelManagers.setVisible(false);
		panelPlayers.setVisible(false);
		panelStadiums.setVisible(false);
		panelTeams.setVisible(false);
		panelFootballCompetition.setVisible(false);
		panelSpecificFootballCompetition.setVisible(false);
	}

	/**
	 * Update the information about the players in players panel.
	 */
	private void updatePlayersInformation() {
		this.playersInfoTextArea.setText("");
		for (int i = 0; i < this.players.size(); i++) {
			this.playersInfoTextArea.append(" " + (i + 1) + ". " + this.players.get(i).toString());
		}
	}

	/**
	 * Find a team from the list of teams by name.
	 * 
	 * @return the needed team or null
	 */
	private Team findTeamByName(String name) throws NullPointerException, IllegalArgumentException {
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}
		if (name.isEmpty()) {
			return null;
		}

		Team neededTeam = null;

		for (Team team : this.teams) {
			if (team.getName().equals(name)) {
				neededTeam = team;
			}
		}

		return neededTeam;
	}

	/**
	 * Add a player to the system.
	 */
	private void addPlayer() {
		try {
			if (this.findPlayerByName(addPlayerNameTextField.getText()) != null) {
				throw new IllegalArgumentException("The player is already created!");
			}

			Player newPlayer = new Player(addPlayerNameTextField.getText(),
					LocalDate.of(Integer.parseInt(yearPlayerTextField.getText()),
							Integer.parseInt(monthPlayerTextField.getText()),
							Integer.parseInt(dayPlayerTextField.getText())),
					nationalityPlayerTextField.getText(), (Position) playerPositionComboBox.getSelectedItem());
			Team playerTeam = findTeamByName((String) addPlayerTeamComboBox.getSelectedItem());
			if (playerTeam != null) {
				playerTeam.addPlayer(newPlayer);
			}
			newPlayer.setTeam(playerTeam);

			this.players.add(newPlayer);
			updatePlayersInformation();
			updateTeamsInformation();
		} catch (Exception addPlayerException) {
			this.addExceptionPlayerTextArea.setText(addPlayerException.getMessage());
		}
	}

	/**
	 * Update the team comboBox of addPlayer panel.
	 */
	private void updateAddPlayerTeamsComboBox() {
		List<String> teamNames = this.teams.stream().map(t -> t.getName()).collect(Collectors.toList());
		// Add the option of no team.
		teamNames.add(0, "No team");
		this.addPlayerTeamComboBox.setModel(new DefaultComboBoxModel<String>(teamNames.toArray(String[]::new)));

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addAll(teamNames);
		this.addCompetitionTeamsList.setModel(listModel);
	}

	/**
	 * Update the team comboBox of add manager panel.
	 */
	private void updateAddManagerTeamsComboBox() {
		List<String> teamNames = this.teams.stream().map(t -> t.getName()).collect(Collectors.toList());
		// Add the option of no team.
		teamNames.add(0, "No team");
		this.addManagerTeamComboBox.setModel(new DefaultComboBoxModel<String>(teamNames.toArray(String[]::new)));
	}

	/**
	 * Update all combo boxes with managers' names.
	 */
	private void updateManagerComboBox() {
		String[] allManagerNames = this.managers.stream().map(t -> t.getName()).toArray(String[]::new);
		this.removeManagerComboBox.setModel(new DefaultComboBoxModel<String>(allManagerNames));
		List<String> managerNames = this.managers.stream().map(t -> t.getName()).collect(Collectors.toList());
		managerNames.add(0, "No manager");
		this.teamManagerComboBox.setModel(new DefaultComboBoxModel<String>(managerNames.toArray(String[]::new)));
	}

	/**
	 * Update the player combo box for remove player panel.
	 */
	private void updateRemovePlayerComboBox() {
		String[] playerNames = this.players.stream().map(t -> t.getName()).toArray(String[]::new);
		this.removePlayerComboBox.setModel(new DefaultComboBoxModel<String>(playerNames));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addAll(List.of(playerNames));
		this.playersOfTeamList.setModel(listModel);
	}

	/**
	 * Remove a player from the system.
	 */
	private void removePlayer() {
		try {
			Player player = this.findPlayerByName((String) removePlayerComboBox.getSelectedItem());

			if (player == null) {
				throw new IllegalArgumentException("The player was not found!");
			}

			this.players.remove(player);
			if (player.getTeam() != null) {
				player.getTeam().removePlayer(player);
			}

			this.updatePlayersInformation();
			this.updateRemovePlayerComboBox();
		} catch (Exception removePlayerException) {
			this.removeExceptionPlayerTextArea.setText(removePlayerException.getMessage());
		}
	}

	/**
	 * Find a player from the list of created players by name
	 * 
	 * @param name
	 * @return the player or null
	 * @throws NullPointerException
	 */
	private Player findPlayerByName(String name) throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}

		Player foundPlayer = null;

		for (Player player : players) {
			if (player.getName().equals(name)) {
				foundPlayer = player;
			}
		}

		return foundPlayer;
	}

	/**
	 * Updates the information text area in managers panel
	 */
	private void updateManagersInformation() {
		this.managersInfoTextArea.setText("");
		for (int i = 0; i < this.managers.size(); i++) {
			this.managersInfoTextArea.append(" " + (i + 1) + ". " + this.managers.get(i).toString());
		}
	}

	/**
	 * Add a manager to the system.
	 */
	private void addManager() {
		try {
			if (this.findManagerByName(addManagerNameTextField.getText()) != null) {
				throw new IllegalArgumentException("The manager is already created!");
			}

			Manager newManager = new Manager(addManagerNameTextField.getText(),
					LocalDate.of(Integer.parseInt(yearManagerTextField.getText()),
							Integer.parseInt(monthManagerTextField.getText()),
							Integer.parseInt(dayManagerTextField.getText())),
					nationalityManagerTextField.getText(), tacticsManagerTextField.getText());
			Team managerTeam = this.findTeamByName((String) this.addManagerTeamComboBox.getSelectedItem());
			if (managerTeam != null) {
				if (managerTeam.getManager() != null) {
					managerTeam.getManager().setTeam(null);
				}

				managerTeam.changeManager(newManager);
			}
			newManager.setTeam(managerTeam);
			managers.add(newManager);
			updateManagersInformation();
			updateTeamsInformation();
		} catch (Exception addManagerException) {
			this.addExceptionManagerTextArea.setText(addManagerException.getMessage());
		}
	}

	/**
	 * Remove a manager from the system.
	 */
	private void removeManager() {
		try {
			Manager manager = this.findManagerByName((String) removeManagerComboBox.getSelectedItem());

			if (manager == null) {
				throw new IllegalArgumentException("The manager was not found!");
			}

			this.managers.remove(manager);
			if (manager.getTeam() != null) {
				manager.getTeam().changeManager(null);
			}

			this.updateManagersInformation();
			this.updateManagerComboBox();
		} catch (Exception removeManagerException) {
			this.removeExceptionManagerTextArea.setText(removeManagerException.getMessage());
		}
	}

	/**
	 * Find a manager by name.
	 * 
	 * @param name
	 * @return the manager or null
	 * @throws NullPointerException
	 */
	private Manager findManagerByName(String name) throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}

		Manager foundManager = null;

		for (Manager manager : this.managers) {
			if (manager.getName().equals(name)) {
				foundManager = manager;
			}
		}

		return foundManager;
	}

	/**
	 * Add a stadium to the system.
	 */
	private void addStadium() {
		try {
			if (this.findStadiumByName(addStadiumNameTextField.getText()) != null) {
				throw new IllegalArgumentException("The stadium is already created!");
			}

			Stadium newStadium = new Stadium(addStadiumNameTextField.getText(), addStadiumCountryTextField.getText(),
					Integer.parseInt(addStadiumCapacityTextField.getText()), addStadiumAddressTextField.getText());
			this.stadiums.add(newStadium);
			updateStadiumsInformation();
		} catch (Exception addStadiumException) {
			this.addExceptionStadiumTextArea.setText(addStadiumException.getMessage());
		}
	}

	/**
	 * Find a stadium from the list of created stadiums by name
	 * 
	 * @param name
	 * @return the needed stadium or null
	 * @throws NullPointerException
	 */
	private Stadium findStadiumByName(String name) throws NullPointerException {
		Stadium foundStadium = null;

		for (Stadium stadium : this.stadiums) {
			if (stadium.getName().equals(name)) {
				foundStadium = stadium;
			}
		}

		return foundStadium;
	}

	/**
	 * Update the info about stadium in stadiums panel.
	 */
	private void updateStadiumsInformation() {
		this.stadiumsInfoTextArea.setText("");
		for (int i = 0; i < this.stadiums.size(); i++) {
			this.stadiumsInfoTextArea.append(" " + (i + 1) + ". " + this.stadiums.get(i).toString());
		}
		String[] stadiumNames = this.stadiums.stream().map(t -> t.getName()).toArray(String[]::new);
		this.teamStadiumComboBox.setModel(new DefaultComboBoxModel<String>(stadiumNames));
	}

	/**
	 * Update the info about teams in the text area in teams panel.
	 */
	private void updateTeamsInformation() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < this.teams.size(); i++) {
			Team currentTeam = this.teams.get(i);
			buffer.append(" " + (i + 1) + ". " + currentTeam.toString());
		}

		this.teamsInfoTextArea.setText(buffer.toString());
	}

	/**
	 * Add a team to the system.
	 */
	private void addTeam() {
		try {
			if (this.findTeamByName(this.teamNameTeamTextField.getText()) != null) {
				throw new IllegalArgumentException("The team is already created!");
			}

			Manager manager = this.findManagerByName((String) this.teamManagerComboBox.getSelectedItem());
			Team newTeam = new Team(shortTeamNameTeamTextField.getText(), teamNameTeamTextField.getText(), manager,
					this.findStadiumByName((String) this.teamStadiumComboBox.getSelectedItem()));

			if (manager != null) {
				if (manager.getTeam() != null) {
					manager.getTeam().changeManager(null);
				}

				manager.setTeam(newTeam);
			}

			List<String> players = this.playersOfTeamList.getSelectedValuesList();

			for (String player : players) {
				Player newPlayer = this.findPlayerByName(player);
				newTeam.addPlayer(newPlayer);
				if (newPlayer.getTeam() != null) {
					newPlayer.getTeam().removePlayer(newPlayer);
				}
				newPlayer.setTeam(newTeam);
			}

			this.teams.add(newTeam);
			updateTeamsInformation();
		} catch (Exception addTeamException) {
			this.exceptionTeamsTextField.setText(addTeamException.getMessage());
		}
	}

	/**
	 * Update the info textarea for competitions.
	 */
	private void updateCompetitionsInformation() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < this.competitions.size(); i++) {
			buffer.append(" " + (i + 1) + ". " + this.competitions.get(i).toString()).append("\n");
		}

		this.competitionsInfoTextArea.setText(buffer.toString());
		this.updateSpecificCompetitionChoiceComboBox();
	}

	/**
	 * Find a football competition in the list of created football competitions by
	 * name.
	 * 
	 * @param name
	 * @return the competition or null
	 * @throws NullPointerException
	 */
	private FootballCompetition findCompetitionByName(String name) throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Name must not be null!");
		}

		FootballCompetition foundCompetition = null;

		for (FootballCompetition competition : this.competitions) {
			if (competition.getName().equals(name)) {
				foundCompetition = competition;
			}
		}

		return foundCompetition;
	}

	/**
	 * Add a competition to the system.
	 */
	private void addCompetition() {
		try {
			if (this.findCompetitionByName(this.createCompetitionNameTextField.getText()) != null) {
				throw new IllegalArgumentException("Competition with such name is already created!");
			}

			List<Team> newLeagueTeams = new ArrayList<Team>();
			for (String teamName : this.addCompetitionTeamsList.getSelectedValuesList()) {
				newLeagueTeams.add(this.findTeamByName(teamName));
			}

			FootballCompetition newCompetition;

			if (this.createNewLeagueRadioButton.isSelected()) {
				newCompetition = new League(createCompetitionNameTextField.getText(),
						createCompetitionCountryTextField.getText(), newLeagueTeams);
			} else {
				newCompetition = new Knockout(createCompetitionNameTextField.getText(),
						createCompetitionCountryTextField.getText(), newLeagueTeams);
			}

			this.competitions.add(newCompetition);
			this.updateCompetitionsInformation();
		} catch (Exception addCompetitionException) {
			this.competitionExceptionTextArea.setText(addCompetitionException.getMessage());
		}
	}

	/**
	 * Add a match in the specific competition.
	 */
	private void addMatchInSpecificCompetition() {
		try {
			Team.playMatch(this.specificCompetition,
					this.findTeamByName((String) this.addMatchHomeTeamNameComboBox.getSelectedItem()),
					this.findTeamByName((String) this.addMatchAwayTeamNameComboBox.getSelectedItem()),
					(int) this.addMatchHomeTeamGoalsComboBox.getSelectedItem(),
					(int) this.addMatchAwayTeamGoalsComboBox.getSelectedItem());
			this.updateSpecificCompetitionInfo();
			this.updateSpecificCompetitionComboBoxes();

		} catch (Exception addMatchToCompetitionException) {
			this.specificCompetitionExceptionTextArea.setText(addMatchToCompetitionException.getMessage());
		}
	}

	/**
	 * Remove a team from the specific competition.
	 */
	private void removeTeamFromSpecificCompetition() {
		try {
			Team removedTeam = this
					.findTeamByName((String) this.removeTeamFromSpecificCompetitionComboBox.getSelectedItem());
			this.specificCompetition.removeTeam(removedTeam);

			this.updateSpecificCompetitionInfo();
			this.updateSpecificCompetitionComboBoxes();
		} catch (Exception removeTeamFromspecificCompetitionException) {
			this.specificCompetitionExceptionTextArea.setText(removeTeamFromspecificCompetitionException.getMessage());
		}
	}

	/**
	 * Go to specific competition.
	 */
	private void goToSpecificCompetition() {
		try {
			this.specificCompetition = this
					.findCompetitionByName((String) this.chooseSpecificCompetitionComboBox.getSelectedItem());
			if (specificCompetition == null) {
				throw new IllegalArgumentException("There is no such competition!");
			}

			this.updateSpecificCompetitionInfo();
			this.updateSpecificCompetitionComboBoxes();
			this.specificCompetitionExceptionTextArea.setText("");

			panelFootballCompetition.setVisible(false);
			panelSpecificFootballCompetition.setVisible(true);

		} catch (Exception goTospecificCompetitionException) {
			competitionExceptionTextArea.setText(goTospecificCompetitionException.getMessage());
		}
	}

	/**
	 * Update the combo boxes in the specific competition panel.
	 */
	private void updateSpecificCompetitionComboBoxes() {
		String[] teamNames = this.specificCompetition.getTeamNames();
		this.addMatchHomeTeamNameComboBox.setModel(new DefaultComboBoxModel<String>(teamNames));
		this.addMatchAwayTeamNameComboBox.setModel(new DefaultComboBoxModel<String>(teamNames));
		this.removeTeamFromSpecificCompetitionComboBox.setModel(new DefaultComboBoxModel<String>(teamNames));
	}

	/**
	 * Update the combo boxes for specific competition in competitions panel.
	 */
	private void updateSpecificCompetitionChoiceComboBox() {
		String[] competitionsNames = this.competitions.stream().map(l -> l.getName()).toArray(String[]::new);
		this.chooseSpecificCompetitionComboBox.setModel(new DefaultComboBoxModel<String>(competitionsNames));
	}

	/**
	 * Update the info in the text area in the specific competition panel.
	 */
	private void updateSpecificCompetitionInfo() {
		this.specificCompetitionInfoTextArea.setText(this.specificCompetition.getCompetitionInformation());

		String hasEnded = this.specificCompetition.endCompetition();
		if (hasEnded != null) {
			this.specificCompetitionInfoTextArea.append("\n" + hasEnded);
			this.addMatchInCompetitionButton.setEnabled(false);
			this.removeTeamFromSpecificCompetition.setEnabled(false);
		} else {
			this.addMatchInCompetitionButton.setEnabled(true);
			this.removeTeamFromSpecificCompetition.setEnabled(true);
		}
	}
}
