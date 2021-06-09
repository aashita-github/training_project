package Model;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class FlightModel {
	public static void main(String[] args) {
		CSVReader reader = null;
		try {
//parsing a CSV file into CSVReader class constructor  
			reader = new CSVReader(new FileReader("C:\\Users\\FlightData"));
			String[] nextLine;
//reads one line at a time  
			while ((nextLine = reader.readNext()) != null) {
				for (String token : nextLine) {
					System.out.print(token);
				}
				System.out.print("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}