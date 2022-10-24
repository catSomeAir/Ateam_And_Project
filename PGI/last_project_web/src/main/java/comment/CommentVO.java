package comment;

import java.io.Serializable;
import java.util.List;

public class CommentVO implements Serializable{
	private String board_id, email, title, content, writedate, help_cnt, model_code, cmt_code, filepath, social_code;

	private List<ReplyVO> replylist;
	
	
	public List<ReplyVO> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<ReplyVO> replylist) {
		this.replylist = replylist;
	}

	public String getSocial_code() {
		return social_code;
	}

	public void setSocial_code(String social_code) {
		this.social_code = social_code;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getHelp_cnt() {
		return help_cnt;
	}

	public void setHelp_cnt(String help_cnt) {
		this.help_cnt = help_cnt;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getCmt_code() {
		return cmt_code;
	}

	public void setCmt_code(String cmt_code) {
		this.cmt_code = cmt_code;
	}
	
	
}
