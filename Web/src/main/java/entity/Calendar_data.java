package entity;

public class Calendar_data {
	private String year;
	private String month;
	private String day;
	
	public Calendar_data() {
	}
	
	public Calendar_data(String year, String month, String day) {
		if((month != null && month !="") && (day != null && day != "")) {
			this.year = year;
			this.month = month;
		}
		this.day = day;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}	

	@Override
	public String toString() {
		return "Calendar [year=" + year + ", month=" + month + ", day=" + day + "]";
	}	
}
