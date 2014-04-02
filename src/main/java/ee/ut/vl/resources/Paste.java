package ee.ut.vl.resources;

import java.sql.Timestamp;

public class Paste {
	
	private long id;
	private int user_id;
	private String name;
	private String text;
	private Timestamp posted_time;
	private String syntax;;
	private String exposure;
	
	
	public Paste(){}
	
	public Paste(String name, String text, Timestamp posted_time, String syntax,
			String exposure) {
		this.name = name;
		this.text = text;
		this.posted_time = posted_time;
		this.syntax = syntax;
		this.exposure = exposure;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
		
	public Timestamp getPosted_time() {
		return posted_time;
	}

	public void setPosted_time(Timestamp posted_time) {
		this.posted_time = posted_time;
	}

	public String getSyntax() {
		return syntax;
	}
	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	
	
}
