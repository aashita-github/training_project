package com.service.reader;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author aashita 
 * Thread class to watch for the changes in the folder and populate map after 1 min
 */
public class FlightThread {
	static List<String> files;

	public static void useThread() {
		FileSearch fs = new FileSearch();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			try {
				files = (fs.fileUtility());

				for (String strFile : files) {
					if (!FlightService.files.contains(strFile)) {
						
						FlightService.populateMapFromFiles(strFile);

					}
				}

			} catch (IOException | InterruptedException e) {

				e.printStackTrace();
			}
		};

		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.MINUTES);

	}
}