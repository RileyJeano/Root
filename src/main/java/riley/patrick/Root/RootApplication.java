package riley.patrick.Root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class RootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RootApplication.class, args);
		DriversTracking driverTrack = new DriversTracking();
		try {
			File file = new File("DriversReport.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
				driverTrack.parseFirstWord(line);

			}
			fileReader.close();
			String inputFile = stringBuffer.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server is Running! Better catch it!");
	}

}
