package com.example.last_project.news;

import java.io.Serializable;

public class ReqBoardVO implements Serializable {
    String req_bd_id, l_catg, email, req_title, req_content, req_writedate, commit, commit_date;


    public String getReq_bd_id() {
        return req_bd_id;
    }

    public void setReq_bd_id(String req_bd_id) {
        this.req_bd_id = req_bd_id;
    }

    public String getL_catg() {
        return l_catg;
    }

    public void setL_catg(String l_catg) {
        this.l_catg = l_catg;
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

    public String getReq_writedate() {
        return req_writedate;
    }

    public void setReq_writedate(String req_writedate) {
        this.req_writedate = req_writedate;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getCommit_date() {
        return commit_date;
    }

    public void setCommit_date(String commit_date) {
        this.commit_date = commit_date;
    }

}
