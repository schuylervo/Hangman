package midTerm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleWordMediumHighScoreTextFile {


	public static final String FILE_PATH = "MultipleWordHighScores/multiplewordmediumhighscores.txt";
		
		private static HighScore convertLineToItem(String line) {
			String[] parts = line.split("\t");
			HighScore highscore = new HighScore();
			highscore.setName(parts[0]);
			highscore.setSpelledWordCount(Integer.parseInt(parts[1]));
			return highscore;
		}
		
		private static String convertItemToLine(HighScore highscore) {
			return String.format("%s\t%d", highscore.getName(), highscore.getSpelledWordCount());
		}
		
		public static ArrayList<HighScore> readFile() {
			ArrayList<HighScore> items = new ArrayList<>();
			
			try (
				// Open/prepare the resources in the try resources block
				FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
				Scanner fileScanner = new Scanner(fileInputStream)
			) {
				// loop until the end of the file
				while (fileScanner.hasNextLine()) {
					// read each line as a string
					String line = fileScanner.nextLine();
					// then convert it to an object
					items.add( convertLineToItem(line) );
				}
				
			} catch (FileNotFoundException ex) {
				// If the file doesn't exist, there just aren't any items.
				return items;
			} catch (IOException e) {
				// If something else crazy goes wrong, print out the error.
				System.err.println("Something unexpected happended.");
				e.printStackTrace();
			}catch(IndexOutOfBoundsException exc) {
				return items;
			}
			
			// Finally return the array of items.
			return items;
		}
		
		public static void appendLine(HighScore item) {
			// convert country object to a string line of text to be written to the file
			String line = convertItemToLine(item);
			
			try (
				// The `true` here tells the FileOutputStream to append to the file rather than overwriting it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH, true);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);
			) {
				// write to the file
				fileWriter.println(line);
				
			} catch (IOException e) {
				// If something else crazy goes wrong, print out the error.
				System.err.println("Something unexpected happended.");
				e.printStackTrace();
			}
		}
		
		public static void writeFile(ArrayList<HighScore> items) {
			try (
//				// The `false` here tells the FileOutputStream to overwrite the file, rather than append to it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH, false);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);
			) {
//				// write to the file
				for (HighScore item : items) {
//					// each item must be converted to a string of text to write to the file
					String line = convertItemToLine(item);
					fileWriter.println(line);
				}
//				
			} catch (IOException e) {
//				// If something else crazy goes wrong, print out the error.
				System.err.println("Something unexpected happended.");
				e.printStackTrace();
			}
		}
		
		public static void createDirectory(String pathName) {
			Path path = Paths.get(pathName);
			if (Files.notExists(path)) {
				try {
					Files.createDirectories(path);
					System.out.println("Directory created at " + path.toAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void createBlankFile(String pathName) {
			Path path = Paths.get(pathName);
			if (Files.notExists(path)) {
				try {
					Files.createFile(path);
					System.out.println("File created at " + path.toAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	
}
