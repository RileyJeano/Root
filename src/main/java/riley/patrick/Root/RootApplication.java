package riley.patrick.Root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class RootApplication {

	public static void main(String[] args) {
		// SpringApplication.run(RootApplication.class, args);
		String fileName = "DriversReport.txt";

		DriversTracking driverTrack = new DriversTracking();
		driverTrack.readTxtFile(fileName);

	}

}
