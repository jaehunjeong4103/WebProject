package entity;

public class Stay {
	private int id;
	private int group_id;
	private String name;
	private String address;
	private String phone;
	private String check_in;
	private String map_path;
	private String image_path;
	
	public Stay() {
	}

	public Stay(int id, int group_id, String name, String address, String phone, String check_in,
			String map_path, String image_path) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.check_in = check_in;
		this.map_path = map_path;
		this.image_path = image_path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getMap_path() {
		return map_path;
	}

	public void setMap_path(String map_path) {
		this.map_path = map_path;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "Stay [id=" + id + ", group_id=" + group_id + ", name=" + name
				+ ", address=" + address + ", phone=" + phone + ", check_in=" + check_in + ", map_path=" + map_path
				+ ", image_path=" + image_path + "]";
	}
	
}
