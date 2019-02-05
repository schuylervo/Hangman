package midTerm;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;
import java.nio.file.Paths;
import javafx.util.Duration;
import javafx.scene.media.*; //  need to allow access to both of these - right click on project, go 
import javafx.embed.swing.JFXPanel;
//     to Build Path -> Configure build path -> Libraries -> open JRE library
//     then you change the access rules 

public class HangmanApp {
	public static final String FILE_PATH = "airhorn2.mp3";
	public static final String FILE_PATH2 = "sadtrombone.mp3";
	public static final String FILE_PATH3 = "gamesong.mp3";

	public static void main(String[] args) {
//		playSound1();  //Sound 1 is for win
//		playSound2(); // Sound 2 is for loss
//		playSound3(); // sound 3 is for during game
		
		// creating files if they don't already exist
		EasyWordsTextFile.createDirectory("WordLists");
		EasyWordsTextFile.createBlankFile("WordLists/easywords.txt");
		EasyWordsTextFile.createBlankFile("WordLists/mediumwords.txt");
		EasyWordsTextFile.createBlankFile("WordLists/hardwords.txt");
		EasyHighScoreTextFile.createDirectory("HighScores");
		EasyHighScoreTextFile.createBlankFile("HighScores/easyhighscores.txt");
		EasyHighScoreTextFile.createBlankFile("HighScores/mediumhighscores.txt");
		EasyHighScoreTextFile.createBlankFile("HighScores/hardhighscores.txt");

		printWelcome();
		String name = askName();
		int diff = getDiff();
		int sessionWins = 0;
		int sessionLosses = 0;
		String keepPlaying = "y";
		while (keepPlaying.equalsIgnoreCase("y")) {
			String word = getWord(diff);
			if (runGame(name, word, diff)) {
				sessionWins++;
			} else {
				sessionLosses++;
			}
			keepPlaying = keepPlaying();
		}
		updateHighScores(diff, name, sessionWins, sessionLosses);
		System.out.println(name + ", your record this session was " + sessionWins + "-" + sessionLosses);

		printGoodbye();

	}

	public static boolean runGame(String userName, String word, int diff) {
		String wordStatus = wordStart(word);
		int misses = 0;
		int hits = 0;
		int missMax = 6;
		String guessList = "";
		playSound3(); //starts game music on repeat, stops on win or loss, starts again if they want to continue
		while (misses < missMax && hits != word.length()) { // loops while they havent hit the max misses or won

			
			for (int j = 0; j < word.length(); j++) {
				System.out.print(wordStatus.charAt(j) + " "); // adds separation to the underscores
			}
			System.out.println();

			Graphic.printGraphic(misses);
			System.out.println("Misses: " + misses); // tracks misses
			char guess = getGuess().toLowerCase().charAt(0); // gets the guess
//			guessList += guess + " "; // updates the guess list

			if (!(word.indexOf(guess) == -1) && (guessList.indexOf(guess) == -1)) { // if the word contains the letter,
																					// this replaces the underscores
																					// with
				// that letter in the appropriate position(s) and ticks up the hit count
				// for each instance
				for (int i = 0; i < word.length(); i++) {
					char currChar = word.charAt(i);
					if (currChar == guess) {
						wordStatus = wordStatus.substring(0, i) + guess + wordStatus.substring(i + 1);
						hits++;
					}
				}

			} else { // ticks up misses and alerts the user
				System.out.println("Miss!");
				misses++;
			}
			guessList += guess + " "; // updates the guess list
			if (misses < missMax && hits != word.length()) { // added this so the guess list didn't print out again if
																// they had already lost
				System.out.println("Guesses so far: " + guessList);
			}
		}
		if (hits == word.length()) { // ends the current game and prints out a message, returns the result of the game
							
			player3.stop();
			playSound1();
			System.out.println(word);
			Graphic.printCelebrationGraphic();
			System.out.println("You Win!!!");
			return true;
		} else {
			Graphic.printGraphic(6);
			player3.stop();
			playSound2();
			System.out.println("You Lose :(");
			System.out.println("The word was: " + word);
			return false;
		}
	}

	public static String getGuess() { // gets a letter guess from the user
		Scanner scnr = new Scanner(System.in);
		String guess = "0";
		String regex = ("[a-zA-z]{1}");
		while (!guess.matches(regex)) {
			System.out.println("Please enter a guess - remember, use a single a-z character");
			guess = scnr.nextLine();
		}
		return guess;

	}

	public static void updateHighScores(int diff, String name, int sessionWins, int sessionLosses) {
		ArrayList<HighScore> highscores = new ArrayList<>();
		if (diff == 1) {
			highscores = EasyHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i = 0; i < highscores.size(); i++) {
				if (highscores.get(i).getName().equals(name)) {
					highscores.get(i).setWins(highscores.get(i).getWins() + sessionWins);
					highscores.get(i).setLosses(highscores.get(i).getLosses() + sessionLosses);
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name, sessionWins, sessionLosses);
				highscores.add(highscore);
			}
			EasyHighScoreTextFile.writeFile(highscores);

		} else if (diff == 2) {
			highscores = MediumHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i = 0; i < highscores.size(); i++) {
				if (highscores.get(i).getName().equals(name)) {
					highscores.get(i).setWins(highscores.get(i).getWins() + sessionWins);
					highscores.get(i).setLosses(highscores.get(i).getLosses() + sessionLosses);
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name, sessionWins, sessionLosses);
				highscores.add(highscore);
			}
			MediumHighScoreTextFile.writeFile(highscores);

		} else if (diff == 3) {
			highscores = HardHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i = 0; i < highscores.size(); i++) {
				if (highscores.get(i).getName().equals(name)) {
					highscores.get(i).setWins(highscores.get(i).getWins() + sessionWins);
					highscores.get(i).setLosses(highscores.get(i).getLosses() + sessionLosses);
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name, sessionWins, sessionLosses);
				highscores.add(highscore);
			}
			HardHighScoreTextFile.writeFile(highscores);

		}
		Collections.sort(highscores, (HighScore1, HighScore2) -> HighScore2.getWins() - HighScore1.getWins());
		System.out.println("******* HIGH SCORES *******");
		System.out.printf("%-10s%-10s%-10s%-10s", "WINS", "LOSSES","WIN%", "USER");
		System.out.println();

		for (HighScore highscore : highscores) {
			double winPct = 0.0;
			winPct = (double)highscore.getWins()/((double)highscore.getWins()+(double)highscore.getLosses());
			System.out.printf("%-10d%-10d%-10.2f%-10s", highscore.getWins(), highscore.getLosses(),winPct, highscore.getName());
			System.out.println();
		}
	}

	public static String wordStart(String word) { // returns a string with a number of underscores equal to the letters
													// in the word
		String blankWord = "";
		for (int i = 0; i < word.length(); i++) {
			blankWord += "_";
		}
		blankWord += " ";
		return blankWord;
	}

	public static void printWelcome() { // prints out a welcome message
		System.out.println("Welcome to the Hangman Game!");
	}

	public static String askName() { // gets the user's name
		Scanner scnr = new Scanner(System.in);
		String name;
		name = Validator.getString(scnr, "Please enter your name:");
		return name;

	}

	public static String keepPlaying() { // asks if the user wants to continue
		Scanner scnr = new Scanner(System.in);
		String keepPlaying = Validator.getString(scnr, "Press \"y\" to keep playing, any other key to exit");
		return keepPlaying;
	}

	public static void printGoodbye() { // prints out a goodbye message
		System.out.println("Thank you for playing!");
	}

	public static int getDiff() { // allows the user to choose a difficulty
		Scanner scnr = new Scanner(System.in);
		int diff = Validator.getInt(scnr, "Please choose a difficulty:\n1: Easy\n2: Medium\n3: Hard", 1, 3);
		return diff;
	}

	public static String getWord(int diff) { // gets a random word from the selected list
		int wordIndex = 0;
		Random rand = new Random();
		String word = "";
		ArrayList<String> wordList = new ArrayList<>();
		if (diff == 1) {
			wordList = EasyWordsTextFile.readFile();
			wordIndex = rand.nextInt(wordList.size());
			word = wordList.get(wordIndex);

		}
		if (diff == 2) {

			wordList = MediumWordsTextFile.readFile();
			wordIndex = rand.nextInt(wordList.size());
			word = wordList.get(wordIndex);
		}
		if (diff == 3) {

			wordList = HardWordsTextFile.readFile();
			wordIndex = rand.nextInt(wordList.size());
			word = wordList.get(wordIndex);
		}

		return word;
	}

	public static MediaPlayer player;

	public static void playSound1() {
		try {
			URL urL = ((Paths.get(FILE_PATH)).toUri().toURL());
			JFXPanel blarg = new JFXPanel();
			Media sound = new Media(urL.toString());
			player = new MediaPlayer(sound);
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MediaPlayer player2;

	public static void playSound2() {
		try {
			URL urL2 = ((Paths.get(FILE_PATH2)).toUri().toURL());
			JFXPanel blarg2 = new JFXPanel();
			Media sound2 = new Media(urL2.toString());
			player2 = new MediaPlayer(sound2);
			player2.play();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static MediaPlayer player3;

	public static void playSound3() {
		try {
			URL urL3 = ((Paths.get(FILE_PATH3)).toUri().toURL());
			JFXPanel blarg3 = new JFXPanel();
			Media sound3 = new Media(urL3.toString());
			player3 = new MediaPlayer(sound3);
//			player3.setOnRepeat(null);
			Duration start = Duration.seconds(0.0);
			Duration end = sound3.getDuration();
			player3.setStartTime(start);
			player3.setStopTime(end);
			player3.setCycleCount(MediaPlayer.INDEFINITE);
			player3.play();
			

		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}

}
