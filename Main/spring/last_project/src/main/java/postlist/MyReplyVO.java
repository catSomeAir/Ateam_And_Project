package postlist;

import java.sql.Date;

public class MyReplyVO {
 private String content;
 private Date writedate;
 private int help_cnt;
 
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getHelp_cnt() {
		return help_cnt;
	}
	public void setHelp_cnt(int help_cnt) {
		this.help_cnt = help_cnt;
	}
 
 
}