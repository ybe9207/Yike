package yk.bean;

public class News {
	private String id;
	private String head;
	private String newsfrom;
	private String time;
	private String guideread;
	private String content;
	private String category;
	private String datetime;
	public News(String id, String head, String newsfrom, String time,
			String guideread, String content,String category,String datetime) {
		super();
		this.id = id;
		this.head = head;
		this.newsfrom = newsfrom;
		this.time = time;
		this.guideread = guideread;
		this.content = content;
		this.category = category;
		this.datetime = datetime;
	}
	
	public News(String id, String head, String newsfrom, String time,
			String guideread, String content, String category) {
		super();
		this.id = id;
		this.head = head;
		this.newsfrom = newsfrom;
		this.time = time;
		this.guideread = guideread;
		this.content = content;
		this.category = category;
	}

	public News(){
		super();
	}
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
	public String getNewsfrom() {
		return newsfrom;
	}
	public void setNewsfrom(String newsfrom) {
		this.newsfrom = newsfrom;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGuideread() {
		return guideread;
	}
	public void setGuideread(String guideread) {
		this.guideread = guideread;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
