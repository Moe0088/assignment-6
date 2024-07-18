package com.codercampus.com;

import java.time.YearMonth;

public class CarSalesRecord {
	private YearMonth date;
	private Integer sales;

	public CarSalesRecord(YearMonth date, Integer sales) {
		super();
		this.date = date;
		this.sales = sales;
	}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return date + "->" + sales;
	}
}
