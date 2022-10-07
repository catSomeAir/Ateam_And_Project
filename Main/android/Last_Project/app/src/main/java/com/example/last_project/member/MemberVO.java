package com.example.last_project.member;

public class MemberVO {
    private String email;
    private String pw;
    private String name;
    private String nickname;
    private String phone;
    private String join_date;
    private String amdin;
    private String social_code;
    private String filepath;
    private String my_level;

    public String getMy_level() {
        return my_level;
    }

    public void setMy_level(String my_level) {
        this.my_level = my_level;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    private String point;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public String getAmdin() {
        return amdin;
    }

    public void setAmdin(String amdin) {
        this.amdin = amdin;
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
}
