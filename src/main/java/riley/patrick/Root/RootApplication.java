package riley.patrick.Root;

import java.io.File;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RootApplication {

	public static void main(String[] args) {
		// SpringApplication.run(RootApplication.class, args);

		Scanner input = new Scanner(System.in);
		System.out.println(
				"Please Enter the Name of the Files: \nThe file created for this assignment is named DriversReport.txt");
		String fileName = input.nextLine();
		File file = new File(fileName);

		while (!file.exists()) {
			System.out.println("That File Doesn't Exist Within The Directory.\nPlease Enter the Name of the Files: ");
			fileName = input.nextLine();
			file = new File(fileName);
		}

		DriversTracking driverTrack = new DriversTracking();
		driverTrack.readTxtFile(fileName);
	}

}
