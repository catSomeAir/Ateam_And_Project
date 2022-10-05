package com.example.last_project.model.detail.writng;

import java.io.Serializable;

public class ReplyVO implements Serializable {
    String rep_no, board_id, email, content, writedate, help_cnt, filepath, social_code;

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

    public String getRep_no() {
        return rep_no;
    }

    public void setRep_no(String rep_no) {
        this.rep_no = rep_no;
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
}
