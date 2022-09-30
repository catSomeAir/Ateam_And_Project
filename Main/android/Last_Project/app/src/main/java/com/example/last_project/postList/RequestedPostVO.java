package com.example.last_project.postList;

import java.sql.Date;

public class RequestedPostVO {
	private String l_catg,req_title,req_content,commit;
	private Date req_writedate;
	
	public String getL_catg() {
		return l_catg;
	}
	public void setL_catg(String l_catg) {
		this.l_catg = l_catg;
	}
	public String getReq_title() {
		return req_title;
	}
	public void setReq_title(String req_title) {
		this.req_title = req_title;
	}
	public String getReq_content() {
		return req_content;
	}
	public void setReq_content(String req_content) {
		this.req_content = req_content;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public Date getReq_writedate() {
		return req_writedate;
	}
	public void setReq_writedate(Date req_writedate) {
		this.req_writedate = req_writedate;
	}
	
	

}
