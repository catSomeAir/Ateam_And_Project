package com.example.last_project.common;


import com.example.last_project.member.MemberVO;
import com.example.last_project.model.detail.manual.ManualVO;
import com.example.last_project.news.NewsVO;

import java.util.ArrayList;

public class CommonVal {

        public static MemberVO userInfo = null;
        public static ManualVO manualInfo = null;
        public static String search_text = null;
        public static ArrayList<String> recent_list = new ArrayList<>();
        public static ArrayList<NewsVO> alarm_list = new ArrayList<>();
}
