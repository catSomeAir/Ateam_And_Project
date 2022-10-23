package cs;

import java.sql.Date;


public class CsVO {
	private int id, readcnt, root, step, indent;
	private String cs_title, cs_content, cs_writer,name; 
	private String cs_writedate;
	
	public CsVO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCs_content() {
		return cs_content;
	}
	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}
	public String getCs_writer() {
		return cs_writer;
	}
	public void setCs_writer(String cs_writer) {
		this.cs_writer = cs_writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCs_writedate() {
		return cs_writedate;
	}
	public void setCs_writedate(String cs_writedate) {
		this.cs_writedate = cs_writedate;
	}

	
		
}
