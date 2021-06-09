package com.service.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author aashita
 *  Stream to walk over folder and load all files 
 */
public class FileSearch {

	public List<String> fileUtility() throws IOException, InterruptedException {

		Path path = Paths.get("C:\\Users\\aashita\\eclipse-workspace\\Assignment\\FlightData");

		try (Stream<Path> subPaths = Files.walk(path)) {
			List<String> list = subPaths.filter(Files::isRegularFile).map(Objects::toString)
					.collect(Collectors.toList());
			
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}