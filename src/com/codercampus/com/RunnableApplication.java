package com.codercampus.com;

import java.io.IOException;
import java.util.List;

public class RunnableApplication {

	public static void main(String[] args) throws IOException {

		FileService fileService = new FileService();

		List<CarSalesRecord> model3Sales = fileService.readFile("model3.csv");
		List<CarSalesRecord> modelSSales = fileService.readFile("modelS.csv");
		List<CarSalesRecord> modelXSales = fileService.readFile("modelX.csv");

		System.out.println("Model 3 Yearly Sales report");
		Stream.yearlySalesCreateReport("Model 3", model3Sales);
		Stream.bestSales("Model 3 ", model3Sales);
		Stream.worstSales("Model 3", model3Sales);
		System.out.println();

		System.out.println("Model S Yearly sales report");
		Stream.yearlySalesCreateReport("Model S", modelSSales);
		Stream.bestSales("Model S", modelSSales);
		Stream.worstSales("Model S", modelSSales);
		System.out.println();

		System.out.println("Model X Yearly Sales report");
		Stream.yearlySalesCreateReport("Model X", modelXSales);
		Stream.bestSales("Model X", modelXSales);
		Stream.worstSales("Model X", modelXSales);

	}

}
