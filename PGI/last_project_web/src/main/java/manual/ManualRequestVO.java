package manual;

import java.util.ArrayList;
import java.util.List;

public class ManualRequestVO {
	private int req_bd_id;
    private String   email, req_title, req_content, l_catg;

    private ArrayList<ManualRequestFileVO> fileList;  
	
	public ArrayList<ManualRequestFileVO> getFileList() {
		return fileList;
	}


	public void setFileList(ArrayList<ManualRequestFileVO> fileList) {
		this.fileList = fileList;
	}



	public int getReq_bd_id() {
		return req_bd_id;
	}


	public void setReq_bd_id(int req_bd_id) {
		this.req_bd_id = req_bd_id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getL_catg() {
		return l_catg;
	}

	public void setL_catg(String l_catg) {
		this.l_catg = l_catg;
	}


	
}
