package com.codercampus.com;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamClass {

	public static void yearlySalesCreateReport(String models, List<CarSalesRecord> amount) {
		Map<Integer, Integer> yearlySalesReport = amount.stream()
				.collect(Collectors.groupingBy(CarSalesRecord -> CarSalesRecord.getDate().getYear(),
						Collectors.summingInt(CarSalesRecord -> CarSalesRecord.getSales())));

		for (Map.Entry<Integer, Integer> entry : yearlySalesReport.entrySet()) {
			Integer a = entry.getKey();
			Integer z = entry.getValue();
			System.out.println(a + " -> " + z);

		}
	}

	public static void bestSales(List<CarSalesRecord> amount, String models) {
		Optional<CarSalesRecord> maxSales = amount.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(CarSalesRecord -> CarSalesRecord.getSales())));
		if (maxSales.isPresent()) {
			CarSalesRecord maxSalesRecord = maxSales.get();
			YearMonth maxSalesDate = maxSalesRecord.getDate();
			System.out.println("Best Month for " + models + "was: " + maxSalesDate);
		} else {
			System.out.println("No sales records found for " + models);
		}

	}

	public static void worstSales(List<CarSalesRecord> amount, String models) {
		Optional<CarSalesRecord> minSales = amount.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(CarSalesRecord -> CarSalesRecord.getSales())));
		if (minSales.isPresent()) {
			CarSalesRecord minSalesRecord = minSales.get();
			YearMonth minSalesDate = minSalesRecord.getDate();
			System.out.println("Worst Month for " + models + "was " + minSalesDate);
		} else {
			System.out.println("No sales records found for " + models);
		}
	}

}
//
//	yearlySalesReport.forEach(a , z) -> System.out.println(a+ " -> "+z));
