package hh_partition;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		String path;
		String selection = new String();
		Scanner in = new Scanner(System.in);
		try {
			System.out.println(
					"Type \n\'c\'-for console input or \n\'f\'-for input from file \nor anything else for exit.");
			System.out.print("> ");

			selection = in.nextLine();

			switch (selection) {
			case "c":
				Methods.readFromConsole();
				break;
			case "f":
				System.out.println("Enter path to file or press \'enter\' to read default file.");
				System.out.print("> ");
				path = in.nextLine();
				Methods.readFromFile(path);
				break;
			default:
				System.out.println("Exit");
				System.exit(0);
				break;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the specified file.");
		}
	}

}
