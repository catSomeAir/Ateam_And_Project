package qna;

import java.sql.Date;

public class QnaVO {
	private int id, no, readcnt, field, open;
	private String title, content,  writer, name, filepath, filename, field_title, status;
	private Date writedate;
	private QnaAnswerVO answer;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getField_title() {
		return field_title;
	}
	public void setField_title(String field_title) {
		this.field_title = field_title;
	}
	public QnaAnswerVO getAnswer() {
		return answer;
	}
	public void setAnswer(QnaAnswerVO answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getField() {
		return field;
	}
	public void setField(int field) {
		this.field = field;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
		if( filepath!=null && !filepath.isEmpty() ) {
			filename = filepath.substring(filepath.indexOf("_")+1);
		}
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
}
