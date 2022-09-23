package com.example.last_project.category.recyclerview;

import java.io.Serializable;

public class CategoryVO implements Serializable {
    private int l_code, m_code, s_code;
    private String l_name, m_name, s_name;
    public int getL_code() {
        return l_code;
    }
    public void setL_code(int l_code) {
        this.l_code = l_code;
    }
    public int getM_code() {
        return m_code;
    }
    public void setM_code(int m_code) {
        this.m_code = m_code;
    }
    public int getS_code() {
        return s_code;
    }
    public void setS_code(int s_code) {
        this.s_code = s_code;
    }
    public String getL_name() {
        return l_name;
    }
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    public String getM_name() {
        return m_name;
    }
    public void setM_name(String m_name) {
        this.m_name = m_name;
    }
    public String getS_name() {
        return s_name;
    }
    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
}
