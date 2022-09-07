package com.example.last_project;

public class NoticeDTO {
    private String title,content,date;

    public NoticeDTO(String title, String content, String date) {
        this.title =title;
        this.content =content;
        this.date= date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
