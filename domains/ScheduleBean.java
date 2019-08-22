package com.bitcamp.domains;

public class ScheduleBean {
	private int year, month;

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return this.month;
	}

	@Override
	public String toString() {
		return String.format("%d년 %d월", year, month);
	}
}
