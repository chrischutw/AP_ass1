package M1;
/**
 * @author Hsienting Chu
 *
 */
import java.util.*;
import M2.*;

public class Driver {
	// Define all the Game type
	public static final String TYPE_SWIM = "swim";
	public static final String TYPE_RUN = "run";
	public static final String TYPE_CYCLE = "cycle";
	static Scanner sc = new Scanner(System.in);

	// Define all option's range
	final int startup_menu_min = 0;
	final int startup_menu_max = 6;
	final int optionOne_menu_min = 0;
	final int optionOne_menu_max = 4;
	final int athletesNum_start = 0;
	final int athletesNum_range = 8;
	boolean end = false;

	ArrayList<Athlete> athleteslist;
	ArrayList<Official> officialList;
	ArrayList<Game> historyGames = new ArrayList<>();

	/*
	 * 1. Create 10 athletes in each type respectively, and put them all in a
	 * the same ArryaList. 2. Create 10 official
	 */
	public void initialisation() {

		athleteslist = new ArrayList<>();
		athleteslist.add(new Cyclist("AC01", 20, "Connor", "VIC"));
		athleteslist.add(new Cyclist("AC02", 25, "Noah", "TAS"));
		athleteslist.add(new Cyclist("AC03", 23, "Ebony", "QLD"));
		athleteslist.add(new Cyclist("AC04", 22, "Caitlyn", "VIC"));
		athleteslist.add(new Cyclist("AC05", 26, "Taylor", "WA"));
		athleteslist.add(new Cyclist("AC06", 29, "Alice", "NSW"));
		athleteslist.add(new Cyclist("AC07", 31, "Mark", "NSW"));
		athleteslist.add(new Cyclist("AC08", 18, "Hugo", "VIC"));
		athleteslist.add(new Cyclist("AC09", 27, "Ava", "WA"));
		athleteslist.add(new Cyclist("AC10", 29, "Steph", "SA"));

		athleteslist.add(new Swimmer("AS01", 22, "Ann", "NSW"));
		athleteslist.add(new Swimmer("AS02", 19, "Emma", "VIC"));
		athleteslist.add(new Swimmer("AS03", 21, "Derek", "SA"));
		athleteslist.add(new Swimmer("AS04", 26, "Eric", "QLD"));
		athleteslist.add(new Swimmer("AS05", 21, "Jack", "SA"));
		athleteslist.add(new Swimmer("AS06", 35, "Liam", "WA"));
		athleteslist.add(new Swimmer("AS07", 33, "Matt", "VIC"));
		athleteslist.add(new Swimmer("AS08", 18, "Kaite", "WA"));
		athleteslist.add(new Swimmer("AS09", 25, "Patrick", "SA"));
		athleteslist.add(new Swimmer("AS10", 24, "Ethan", "QLD"));

		athleteslist.add(new Sprinter("AR01", 30, "Josh", "TAS"));
		athleteslist.add(new Sprinter("AR02", 23, "Harry", "VIC"));
		athleteslist.add(new Sprinter("AR03", 26, "Chloe", "QLD"));
		athleteslist.add(new Sprinter("AR04", 32, "Julia", "NSW"));
		athleteslist.add(new Sprinter("AR05", 29, "Isabella", "SA"));
		athleteslist.add(new Sprinter("AR06", 31, "Claire", "WA"));
		athleteslist.add(new Sprinter("AR07", 25, "Tom", "WA"));
		athleteslist.add(new Sprinter("AR08", 19, "Kyle", "QLD"));
		athleteslist.add(new Sprinter("AR09", 18, "Sean", "VIC"));
		athleteslist.add(new Sprinter("AR10", 19, "Nick", "VIC"));

		athleteslist.add(new SuperAthlete("AA01", 32, "Alexis", "QLD"));
		athleteslist.add(new SuperAthlete("AA02", 26, "Flynn", "NWS"));
		athleteslist.add(new SuperAthlete("AA03", 28, "Archie", "VIC"));
		athleteslist.add(new SuperAthlete("AA04", 18, "Oscar", "TAS"));
		athleteslist.add(new SuperAthlete("AA05", 24, "Sebastian", "SA"));
		athleteslist.add(new SuperAthlete("AA06", 30, "Braxton", "SA"));
		athleteslist.add(new SuperAthlete("AA07", 22, "Jaxon", "TAS"));
		athleteslist.add(new SuperAthlete("AA08", 21, "Eli", "NSW"));
		athleteslist.add(new SuperAthlete("AA09", 25, "Logan", "WA"));
		athleteslist.add(new SuperAthlete("AA10", 24, "Husdon", "TAS"));

		officialList = new ArrayList<>();
		officialList.add(new Official("OF01", 30, "Jordan", "NSW"));
		officialList.add(new Official("OF02", 35, "Andrew", "QLD"));
		officialList.add(new Official("OF03", 41, "Jacob", "VIC"));
		officialList.add(new Official("OF04", 36, "Hayley", "WA"));
		officialList.add(new Official("OF05", 29, "Olivia", "NSW"));
		officialList.add(new Official("OF06", 34, "Chris", "QLD"));
		officialList.add(new Official("OF07", 48, "Max", "SA"));
		officialList.add(new Official("OF08", 51, "Dan", "WA"));
		officialList.add(new Official("OF09", 53, "Jasper", "VIC"));
		officialList.add(new Official("OF10", 43, "Amber", "NSW"));
	}

	// printout a main menu
	private void Startup_menu() {
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		System.out.print("Enter an option: ");

	}

	// printout a option 1 menu
	private void optionOne_menu() {
		System.out.println("Please choose a game");
		System.out.println("1. Swimming");
		System.out.println("2. Cycling");
		System.out.println("3. Running");
		System.out.print("Enter an option: ");
	}

	private int selection() {
		boolean validInput = false;
		int selection = 0; // initial selection
		while (!validInput) {
			Startup_menu();
			if (sc.hasNextInt()) {
				selection = sc.nextInt();
				if (startup_menu_min > selection || selection > startup_menu_max) {
					System.out.print("\n========Your input: " + selection + " is invalid========\n\n");
					selection = 0; // initial selection
				} else {
					validInput = true;
				}
			} else
				System.out.print("\n========Your input: " + sc.next() + " is invalid========\n\n");
		}
		return selection;
	}

	private int chooseGame() {
		boolean validInput = false;
		int chooeseGame = 0; // initial gameType
		while (!validInput) {
			Startup_menu();
			if (sc.hasNextInt()) {
				chooeseGame = sc.nextInt();
				if (optionOne_menu_min > chooeseGame || chooeseGame > optionOne_menu_max) {
					System.out.print("\n========Your input: " + chooeseGame + " is invalid========\n\n");
					chooeseGame = 0; // initial gameType
				} else {
					validInput = true;
				}
			} else
				System.out.print("\n========Your input: " + sc.next() + " is invalid========\n\n");
		}
		return chooeseGame;
	}

	private List<Athlete> generatePlayer(String gameType, int athleteNum) {
		List<Athlete> returnList = new ArrayList<>();
		while (returnList.size() < athleteNum) {
			Athlete randomAthlete = athleteslist.get((int) (athletesNum_range * Math.random()));
			switch (gameType) {
			case TYPE_CYCLE:
				if (randomAthlete instanceof Cyclist || randomAthlete instanceof SuperAthlete) {
					if (!returnList.contains(randomAthlete)) {
						returnList.add(randomAthlete);
					}
				}
				break;
			case TYPE_RUN:
				if (randomAthlete instanceof Sprinter || randomAthlete instanceof SuperAthlete) {
					if (!returnList.contains(randomAthlete)) {
						returnList.add(randomAthlete);
					}
				}
				break;
			case TYPE_SWIM:
				if (randomAthlete instanceof Swimmer || randomAthlete instanceof SuperAthlete) {
					if (!returnList.contains(randomAthlete)) {
						returnList.add(randomAthlete);
					}
				}
				break;
			}
		}
		return returnList;
	}

	private void printHistoryGames() {
		System.out.println("============= total games ==============");
		for (int i = 0; i < historyGames.size(); i++) {
			printGameResult(historyGames.get(i));
		}
	}

	private void printAthelets() {
		System.out.println("============= total athletes ==============");
		for (int i = 0; i < athleteslist.size(); i++) {
			printAthelet(athleteslist.get(i));
		}
	}

	private void printSortAthelets() {
		System.out.println("============= total rank ==============");
		List<Athlete> sortList = sortAthelets(athleteslist);
		for (int i = 0; i < sortList.size(); i++) {
			printAthelet(sortList.get(i));
		}
	}

	private List<Athlete> sortAthelets(List<Athlete> athelets) {
		List<Athlete> sortList = new ArrayList<Athlete>(athelets);
		Collections.sort(sortList, new Comparator<Athlete>() {
			@Override
			public int compare(Athlete a1, Athlete a2) {
				return a2.getPoints() - a1.getPoints();
			}
		});
		return sortList;
	}

	private void printAthelet(Athlete athlete) {
		System.out.println(athlete.toString() + " || point:" + athlete.getPoints());
	}

	private void printGameResult(Game game) {
		System.out.println("Game:" + game.getID() + " Type:" + game.getType());
		if (game.isCancelled()) {
			System.out.println("Game Canceled");
		} else {
			List<Participant> pList = game.getPrintResult();
			for (int i = 0; i < pList.size(); i++) {
				if (i == 0) {
					printParticipant("referee", pList.get(i));
				} else {
					printParticipant("Rank " + i, pList.get(i));
				}
			}
		}
	}

	private void printParticipant(String title, Participant participant) {
		System.out.println(title + " " + participant.toString());
	}

	private void prediction() {

	}

	private void startGame() {

		Random r = new Random();
		int athletesNum = r.nextInt(athletesNum_range) + athletesNum_start;
		if (athletesNum < 4) {

		} else if (athletesNum > 4) {

		}

		int chooseGame = chooseGame();
		// String gameID;
		// int gameNum = 0;
		switch (chooseGame) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		}
	}

	private void displayReuslt() {

	}

	private void displayPoints() {

	}

	public void runGame() {
		initialisation();
		while (!end) {
			int selection = selection();
			switch (selection) {
			case 1:
				optionOne_menu();
				chooseGame();
				break;
			case 2:
				prediction();
				break;
			case 3:
				startGame();
				break;
			case 4:
				displayReuslt();
				break;
			case 5:
				displayPoints();
				break;
			case 6:
				end = true;
				break;
			}
		}

	}

}
