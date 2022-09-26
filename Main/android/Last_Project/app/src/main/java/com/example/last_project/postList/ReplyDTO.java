package com.example.last_project.postList;

public class ReplyDTO {
    private String date,title;

    public ReplyDTO(String title, String date) {
        this.title = title;
        this.date = date;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
