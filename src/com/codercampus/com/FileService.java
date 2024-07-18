package com.codercampus.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM-yy");

	public List<CarSalesRecord> readFile(String filename) throws IOException {

		List<CarSalesRecord> CarSalesRecords = new ArrayList<>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				YearMonth date = YearMonth.parse(parts[0], FORMATTER);
				Integer sales = Integer.parseInt(parts[1]);
				CarSalesRecord CarSalesRecord = new CarSalesRecord(date, sales);
				CarSalesRecords.add(CarSalesRecord);

			}
		} finally {
			reader.close();
		}

		return CarSalesRecords;

	}

}
