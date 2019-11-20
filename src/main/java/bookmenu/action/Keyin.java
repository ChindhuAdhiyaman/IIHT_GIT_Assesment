package bookmenu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Keyin {
    

	// *******************************
	// support methods
	// *******************************
	// Method to display the user's prompt string
	public static void printPrompt(String prompt) {
		System.out.print(prompt + " ");
		System.out.flush();
	}

	// Method to make sure no data is available in the
	// input stream
	public  void inputFlush() {
		int dummy;
		int bAvail;

		try {
			while ((System.in.available()) != 0)
				dummy = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input error");
		}
	}

	/**
	 * @return
	 */
	public String inString() {
		int aChar;
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	/**
	 * @param prompt
	 * @return
	 */
	public String inString(String prompt) {
		int aChar;
		printPrompt(prompt);
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	/**
	 * @param prompt
	 * @return
	 */
	public  int inInt(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Integer.valueOf(inString().trim()).intValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid input. Not an integer");
			}
		}
	}

	/**
	 * @param searchQuery
	 * @return
	 */
	public String searchBook(String searchQuery) {

		String line = null;
		searchQuery = searchQuery.trim();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File("C:\\Users\\Admin\\file.ser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.contains(searchQuery)) {
				return line;
			}else{
				line = null;
			}
		}
		scanner.close();
		return line;
	}

	/**
	 * @param searchQuery
	 * @return
	 */
	public boolean deleteString(String searchQuery) {

		boolean isSearchQueryFound = false;
		File file = new File("C:\\Users\\Admin\\file.ser");

		
		File file2 = new File("C:\\Users\\Admin\\tempfile.ser");
		PrintWriter pw = null;
		Scanner read = null;

		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel src = null;
		FileChannel dest = null;

		try {

			pw = new PrintWriter(file2);
			read = new Scanner(file);

			while (read.hasNextLine()) {

				String currline = read.nextLine();

				if (currline.contains(searchQuery)) {
					isSearchQueryFound = true;
					continue;
				} else {
					pw.println(currline);
				}
			}

			pw.flush();

			fis = new FileInputStream(file2);
			src = fis.getChannel();
			fos = new FileOutputStream(file);
			dest = fos.getChannel();

			dest.transferFrom(src, 0, src.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
			read.close();

			try {
				fis.close();
				fos.close();
				src.close();
				dest.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			file2.delete();
		}
		return isSearchQueryFound;
	}
}
