package entity;

import java.sql.Time;
import java.util.Date;

public class Review {
	private int id;
	private String member_id;
	private int group_id;
	private int code;
	private String content;
	private Date date_d;
	private Time date_t;
	private int star;
	
	public Review() {
	}

	public Review(int id, String member_id, int group_id, int code, String content, int star, Date date_d, Time date_t) {
		super();
		this.id = id;
		this.member_id = member_id;
		this.group_id = group_id;
		this.code = code;
		this.content = content;
		this.star = star;
		this.date_d = date_d;
		this.date_t = date_t;
		
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

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Date getDate_d() {
		return date_d;
	}

	public void setDate_d(Date date_d) {
		this.date_d = date_d;
	}

	public Time getDate_t() {
		return date_t;
	}

	public void setDate_t(Time date_t) {
		this.date_t = date_t;
	}

	

	@Override
	public String toString() {
		return "Review [id=" + id + ", member_id=" + member_id + ", group_id=" + group_id + ", code=" + code
				+ ", content=" + content + ", date_d=" + date_d + ", date_t=" + date_t + ", star=" + star + "]";
	}

		
}
