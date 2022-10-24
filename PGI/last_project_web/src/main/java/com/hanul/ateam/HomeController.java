package com.hanul.ateam;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		session.removeAttribute("category");
		//session.setAttribute("category", "");
		return "home";
	}
	@RequestMapping(value = "/search_text", method = RequestMethod.GET)
	public String search(String search_text, HttpSession session) {
		session.removeAttribute("category");
		//session.setAttribute("category", "");
		return "search_list";
	}
}
