package midTerm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class HardWordsTextFile {
public static final String FILE_PATH = "WordLists/hardwords.txt";
	
	
	public static ArrayList<String> readFile() {
		ArrayList<String> items = new ArrayList<>();
		
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
				items.add(line);
			}
			
		} catch (FileNotFoundException ex) {
			// If the file doesn't exist, there just aren't any items.
			return items;
		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}
		
		// Finally return the array of items.
		return items;
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

