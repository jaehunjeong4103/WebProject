package entity;

import java.util.Date;

public class Room {
	private int id;
	private String stay_name;
	private String name;
	private int max_person;
	private String weekend_price;
	private String weekday_price;
	private String option;
	private String image_path;
	private Date start_day;
	private Date end_day;
	
	public Room() {
	}

	public Room(int id, String stay_name, String name, int max_person, String weekend_price, String weekday_price,
			String option, String image_path, Date start_day, Date end_day) {
		super();
		this.id = id;
		this.stay_name = stay_name;
		this.name = name;
		this.max_person = max_person;
		this.weekend_price = weekend_price;
		this.weekday_price = weekday_price;
		this.option = option;
		this.image_path = image_path;
		this.start_day = start_day;
		this.end_day = end_day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStay_name() {
		return stay_name;
	}

	public void setStay_name(String stay_name) {
		this.stay_name = stay_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMax_person() {
		return max_person;
	}

	public void setMax_person(int max_person) {
		this.max_person = max_person;
	}

	public String getWeekend_price() {
		return weekend_price;
	}

	public void setWeekend_price(String weekend_price) {
		this.weekend_price = weekend_price;
	}

	public String getWeekday_price() {
		return weekday_price;
	}

	public void setWeekday_price(String weekday_price) {
		this.weekday_price = weekday_price;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Date getStart_day() {
		return start_day;
	}

	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}

	public Date getEnd_day() {
		return end_day;
	}

	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", stay_name=" + stay_name + ", name=" + name + ", max_person=" + max_person
				+ ", weekend_price=" + weekend_price + ", weekday_price=" + weekday_price + ", option=" + option
				+ ", image_path=" + image_path + ", start_day=" + start_day + ", end_day=" + end_day + "]";
	}

	

	
}
