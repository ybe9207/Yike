package yk.bean;

public class Project {
	private String id;
	private String head;
	private String imageurl;
	private String text;
	private String category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Project(String id, String head, String imageurl, String text,
			String category) {
		super();
		this.id = id;
		this.head = head;
		this.imageurl = imageurl;
		this.text = text;
		this.category = category;
	}
	
	public Project(){
		super();
	}
}
