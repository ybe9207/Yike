package yk.bean;

public class Product {
	private String id;
	private String name;
	private String message;
	private String imgurl;
	
	public Product(){
		super();
	}
	public Product(String id, String name, String message, String imgurl) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.imgurl = imgurl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
