package entity;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
	private int id;
	private String member_id;
	private String stay_name;
	private String room_name;
	private java.sql.Date check_in;
	private java.sql.Date check_out;
	private int reservation_person;
	private int price;
	
	public Reservation() {
	}

	public Reservation(int id, String member_id, String stay_name, String room_name, java.sql.Date check_in, java.sql.Date check_out,
			int reservation_person, int price) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.stay_name = stay_name;
		this.room_name = room_name;
		this.check_in = check_in;
		this.check_out = check_out;
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

	public java.sql.Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(java.sql.Date check_in) {
		this.check_in = check_in;
	}

	public java.sql.Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(java.sql.Date check_out) {
		this.check_out = check_out;
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
				+ room_name + ", check_in=" + check_in + ", check_out=" + check_out + ", reservation_person="
				+ reservation_person + ", price=" + price + "]";
	}
	
	
	
}
