package com.example.last_project.notice;

public class NoticeVO {
    private int id;
    private String title,content;
    private String today;

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
