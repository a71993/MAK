package ee.ut.vl.resources;

import java.sql.Timestamp;

public class Paste {
	
	private long id;
	private int user_id;
	private String creator;
	private String name;
	private String text;
	private Timestamp posted_time;
	private String syntax;;
	private String exposure;
	
	
	private long urlId;
	private String urlName;
	
	
	public Paste(){}
	
	public Paste(String urlName, String name, String text, Timestamp posted_time, String syntax,
			String exposure) {
		this.urlName = urlName;
		this.name = name;
		this.text = text;
		this.posted_time = posted_time;
		this.syntax = syntax;
		this.exposure = exposure;
	}
	
		public Paste(long urlId, String name, String text, Timestamp posted_time, String syntax, String exposure,
			long id) {
		this.urlId = urlId;
		this.name = name;
		this.text = text;
		this.posted_time = posted_time;
		this.syntax = syntax;
		this.exposure = exposure;
		this.id = id;
	}

	public Paste(String urlName, String name, String text, Timestamp posted_time,
			String syntax, String exposure, String creator) {
		super();
		this.creator = creator;
		this.name = name;
		this.text = text;
		this.posted_time = posted_time;
		this.syntax = syntax;
		this.exposure = exposure;
		this.urlName = urlName;
	}
	
	public Paste(long urlId, String name, String text, Timestamp posted_time,
			String syntax, String exposure, String creator, long id) {
		super();
		this.creator = creator;
		this.name = name;
		this.text = text;
		this.posted_time = posted_time;
		this.syntax = syntax;
		this.exposure = exposure;
		this.urlId = urlId;
		this.id = id;
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
	
	
	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	
	public long getUrlId() {
		return urlId;
	}

	public void setUrlId(long urlId) {
		this.urlId = urlId;
	}
	
	
}
