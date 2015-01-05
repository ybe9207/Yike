package yk.bean;

public class Join {
	private int id;
	private String jobname;
	private String jobtext;
	private String jobtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getJobtext() {
		return jobtext;
	}
	public void setJobtext(String jobtext) {
		this.jobtext = jobtext;
	}
	public String getJobtime() {
		return jobtime;
	}
	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}
	public Join(int id, String jobname, String jobtext, String jobtime) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.jobtext = jobtext;
		this.jobtime = jobtime;
	}
	public Join() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
