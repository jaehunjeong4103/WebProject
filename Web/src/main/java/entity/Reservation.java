package entity;

import java.util.Date;

public class Reservation {
	private int id;
	private String member_id;
	private String stay_name;
	private String room_name;
	private String reservation_date;
	private int reservation_person;
	private int price;
	
	public Reservation() {
	}

	public Reservation(int id, String member_id, String stay_name, String room_name, String reservation_date,
			int reservation_person, int price) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.stay_name = stay_name;
		this.room_name = room_name;
		this.reservation_date = reservation_date;
		this.reservation_person = reservation_person;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getStay_name() {
		return stay_name;
	}

	public void setStay_name(String stay_name) {
		this.stay_name = stay_name;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	public int getReservation_person() {
		return reservation_person;
	}

	public void setReservation_person(int reservation_person) {
		this.reservation_person = reservation_person;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", member_id=" + member_id + ", stay_name=" + stay_name + ", room_name="
				+ room_name + ", reservation_date=" + reservation_date + ", reservation_person=" + reservation_person
				+ ", price=" + price + "]";
	}
	
}
