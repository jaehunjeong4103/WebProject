package entity;

public class Tour {
	private int id;
	private int group_id;
	private String name;
	private String address;
	private String phone;
	private String op_cl;
	private String content;
	private String map_path;
	private String image_path;
	
	public Tour() {
	}

	public Tour(int id, int group_id, String name, String address, String phone, String op_cl, String content,
			String map_path, String image_path) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.op_cl = op_cl;
		this.content = content;
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

	public String getOp_cl() {
		return op_cl;
	}

	public void setOp_cl(String op_cl) {
		this.op_cl = op_cl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Tour [id=" + id + ", group_id=" + group_id + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", op_cl=" + op_cl + ", content=" + content + ", map_path=" + map_path + ", image_path="
				+ image_path + "]";
	}
	
	
			
}
