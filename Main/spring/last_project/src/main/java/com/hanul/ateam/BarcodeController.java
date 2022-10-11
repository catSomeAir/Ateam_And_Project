package com.hanul.ateam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import barcode.BarcodeServiceImpl;
import barcode.BarcodeVO;


@RestController
public class BarcodeController {
	@Autowired private BarcodeServiceImpl service;
	
	@ResponseBody @RequestMapping(value = "/barcode", produces = "text/html;charset=utf-8")
	public String search_name(String barcode_number) {
		String result = "";
		String URL = "http://www.gs1kr.org//service/service/appl/12_findBarcode.asp?searchGtin="+barcode_number;
			Document doc;
			try {
			//connect해주는거라 화면상에서 띄웠을때 오류가 발생할수 있으니 필수로 작성해주자! 
				doc = Jsoup.connect(URL)
						.header("content-type", "application/json;charset=UTF-8")
						.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
						 .header("accept-encoding", "gzip, deflate, br")
						 .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
						  .ignoreContentType(true).get();
						
					JSONParser jpr = new JSONParser();
					org.json.simple.JSONArray jarr = (org.json.simple.JSONArray)jpr.parse(doc.text());
						System.out.println(jarr);
						org.json.simple.JSONObject json = (org.json.simple.JSONObject) jarr.get(0);
						System.out.println(json);
						jarr = (org.json.simple.JSONArray) json.get("productDescription");
						System.out.println(jarr);
					
						String data = jarr.toJSONString();
						data = data.replace("[", "");
						data = data.replace("]", "");
						
					
						System.out.println(data);
						
						JSONObject jsonObject = new JSONObject(data);
						
						result= (String) jsonObject.getString("value");
	
						
						System.out.println(result);


			} catch (Exception e) {
			         e.printStackTrace();
			}	

			return  result;
	   
	}
	
	
//	@ResponseBody @RequestMapping(value = "/barcode1", produces = "text/html;charset=utf-8")
//	public String search_name1(String barcode_number) {
//		String URL = "http://www.gs1kr.org//service/service/appl/12_findBarcode.asp?searchGtin=8801234560016";
////	//+barcode_number; //원하는 url 
////		System.out.println(URL);
////		
////		JSONArray jarr = new JSONArray(URL);
////		JSONObject json = jarr.getJSONObject(0);
////		System.out.println(json.toString());
////		
////		
//		Document doc;
//
//		try {
//		//connect해주는거라 화면상에서 띄웠을때 오류가 발생할수 있으니 필수로 작성해주자! 
//		        doc = Jsoup.connect(URL).get(); //원하는 url에서 전체 구조를 받아온다
//		        Elements elem = doc.select("body"); //doc.select를 통해 안에서 원하는 elements만 쏙 뽑아와서
//		        String[] str = elem.text().split(" ");
//
//				Elements todaylist =doc.select("productDescription");
//				
//		        //이제 내가 원하는 값들을 정리해준다!
//
//		} catch (Exception e) {
//		         e.printStackTrace();
//		}
//
//		return  null;
////	    @PostMapping(path = "/map")
////	    public String mapRequest(@RequestBody HashMap<String, Object> param){
////	        System.out.println("param : " + param);
////	        return param.toString();
////	    }
//	}
//	@RequestMapping(value = "/llist.ct", produces = "text/html;charset=utf-8")
//	public String l_list() {
//		
//		List<CategoryVO> l_list = service.l_name_list();
//		
//		return  new Gson().toJson(l_list);
//		
//	}
//	@RequestMapping(value = "/mlist.ct", produces = "text/html;charset=utf-8")
//	public String m_list(String l_code) {
//		
//		int lcode = Integer.parseInt(l_code);
//		List<CategoryVO> m_list = service.m_name_list(lcode);
//		return  new Gson().toJson(m_list);
//		
//	}
//	@RequestMapping(value = "/count.ct", produces = "text/html;charset=utf-8")
//	public String count(String email) {
//		
//		HashMap<String, String> map = service.count(email);
//		
//		return  new Gson().toJson(map);
//		
//	}
	
	
	

}

