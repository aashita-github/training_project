package com.service.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.opencsv.CSVReader;

/**
 * @author aashita To execute watcher for first time and read csv files.Also
 *         call thread method.
 */
public class FlightService {

	public static HashMap<String, Set<Flight>> map = new HashMap<>();
	public static boolean readFiles = true;
	public static List<String> files = new ArrayList<>();

	public Date convertStringToDate(String strDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void flightUtility() {
		FlightThread.useThread();
		if (readFiles) {
			try {
				FileSearch f = new FileSearch();
				files = f.fileUtility();
				readFiles = false;
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {

			for (String strFile : files) {
				populateMapFromFiles(strFile);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param strFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void populateMapFromFiles(String strFile) throws FileNotFoundException, IOException {
		CSVReader reader;
		reader = new CSVReader(new FileReader(strFile), ',', '\'', 1);
		String[] record = null;

		while ((record = reader.readNext()) != null) {

			for (int i = 0; i < record.length; i++) {

				Flight flightObject = new Flight();
				String[] records = record[i].split("\\|");
				flightObject.setFlightNo(records[0]);

				flightObject.setDepLoc(records[1]);
				flightObject.setArrLoc(records[2]);
				flightObject.setValidTill(records[3]);
				flightObject.setFlightTime(records[4]);
				flightObject.setFlightDur(Float.parseFloat(records[5]));
				flightObject.setFare(Integer.parseInt(records[6]));
				flightObject.setSeatAvailability(records[7]);
				flightObject.setClassType(records[8]);

				String key = flightObject.getDepLoc() + flightObject.getArrLoc();
				Set<Flight> flightList = map.get(key);
				if (flightList != null) {
					flightList.add(flightObject);
				} else {
					Set<Flight> newflightList = new HashSet<>();
					newflightList.add(flightObject);
					map.put(key, newflightList);
				}
			}

		}

		reader.close();
	}
}
