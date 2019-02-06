package midTerm;

import java.util.ArrayList;
import java.util.Collections;

public class SecondGameMode {

	public static boolean runSecondGame(String userName, String word, int diff) {

		int misses = 0;
		int hits = 0;
		int missMax = 100;
		int cumulativeMisses = 0;
		int spelledWordCount = 0;
		String guessList = "";

		String wordStatus = HangmanApp.wordStart(word);

		System.out.println(
				"\n Welcome to Multiple Word Challenge. You have 100 guesses. Try to spell as many words as possible! \n");

		while (cumulativeMisses < 100) { // loops while they havent hit the max misses or won

			for (int j = 0; j < word.length(); j++) {
				System.out.print(wordStatus.charAt(j) + " "); // adds separation to the underscores
			}
			System.out.println();

			Graphic.printGraphic2(cumulativeMisses);
			System.out.println("Misses: " + misses); // tracks misses
			System.out.println("Cumulative Misses: " + cumulativeMisses); // tracks cumulative misses
			System.out.println("Number of Words Spelled: " + spelledWordCount); // tracks cumulative misses
			char guess = HangmanApp.getGuess().toLowerCase().charAt(0); // gets the guess
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
				cumulativeMisses++;
			}
			guessList += guess + " "; // updates the guess list
			if (misses < missMax && hits != word.length()) { // added this so the guess list didn't print out again if
																// they had already lost
				System.out.println("Guesses so far: " + guessList);
			}

			if (hits == word.length()) { // ends the current game and prints out a message, returns the result of the
				// game
				System.out.println(word);
				misses = 0;
				hits = 0;
				guessList = "";
				spelledWordCount++;
				// diff = HangmanApp.getDiff();
				word = HangmanApp.getWord(diff);
				wordStatus = HangmanApp.wordStart(word);
				// Graphic.printCelebrationGraphic();
				// System.out.println("You Win!!!");
				// return true;
			} 

		}

		Graphic.printCelebrationGraphic();
		System.out.println("You spelled " + spelledWordCount + " words correctly.");
		updateMultipleWordHighScores(diff,userName,spelledWordCount);
		return true;
	}
	public static void updateMultipleWordHighScores(int diff, String name, int spelledWordCount) {
		ArrayList <HighScore> highscores = new ArrayList<>();
		if (diff==1) {
			highscores = MultipleWordEasyHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i=0;i<highscores.size();i++) {
				if(highscores.get(i).getName().equals(name) ) {
					highscores.get(i).setSpelledWordCount(highscores.get(i).getSpelledWordCount() + spelledWordCount);
					
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name,spelledWordCount);
				highscores.add(highscore);
			}
			MultipleWordEasyHighScoreTextFile.writeFile(highscores);
			
			
		}else if(diff==2) {
			highscores = MultipleWordMediumHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i=0;i<highscores.size();i++) {
				if(highscores.get(i).getName().equals(name) ) {
					highscores.get(i).setSpelledWordCount(highscores.get(i).getSpelledWordCount() + spelledWordCount);	
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name,spelledWordCount);
				highscores.add(highscore);
			}
			MultipleWordMediumHighScoreTextFile.writeFile(highscores);
			
			
		}else if(diff==3) {
			highscores = MultipleWordHardHighScoreTextFile.readFile();
			boolean hasName = false;
			for (int i=0;i<highscores.size();i++) {
				if(highscores.get(i).getName().equals(name) ) {
					highscores.get(i).setSpelledWordCount(highscores.get(i).getSpelledWordCount() + spelledWordCount);	
					hasName = true;
				}
			}
			if (!hasName) {
				HighScore highscore = new HighScore(name,spelledWordCount);
				highscores.add(highscore);
			}
			MultipleWordHardHighScoreTextFile.writeFile(highscores);
		
		}
		Collections.sort(highscores,(HighScore1,HighScore2) -> HighScore2.getSpelledWordCount() - HighScore1.getSpelledWordCount());
		System.out.println("******* HIGH SCORES *******");
		System.out.printf("%-10s%-10s", "WORDS", "USER");
		System.out.println();
		
		for(HighScore highscore : highscores) {
			System.out.printf("%-10d%-10s", highscore.getSpelledWordCount(), highscore.getName());
			System.out.println();
		}
	}	
	
		
}
