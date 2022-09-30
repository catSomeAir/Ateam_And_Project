package com.example.last_project.request;

import java.io.Serializable;

public class RequestManualVO implements Serializable {
    private String  email, req_title, req_content, l_catg;

    public RequestManualVO( String email, String req_title, String req_content, String  l_catg) {

        this.email = email;
        this.req_title = req_title;
        this.req_content = req_content;
        this. l_catg =  l_catg;

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
