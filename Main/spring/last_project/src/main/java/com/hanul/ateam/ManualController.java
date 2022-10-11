package com.hanul.ateam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import common.CommonService;
import manual.ManualDAO;
import manual.ManualRequestFileVO;
import manual.ManualRequestVO;
import manual.ManualVO;
import manysearch.ManySearchVO;
import search.CategorySearchVO;

@RestController
public class ManualController {
	@Autowired private CommonService common;
	@Autowired private ManualDAO dao;
	
	//제품 브랜드이미지
	
	@RequestMapping(value = "/brand_logo", produces = "text/html;charset=utf-8")
	public String brand_logo(String brand_name) {
		
		
		return dao.brand_logo(brand_name);
	}
	
	
	//설명서 요청
	@RequestMapping(value = "/request_manual", produces = "text/html;charset=utf-8")
	public int request(String vo,  HttpServletRequest req) {
		ManualRequestVO manualvo = new Gson().fromJson(vo, ManualRequestVO.class);
			
		String imgpath = "";
		// 정보 빼오고나서 캐스팅.
		MultipartRequest mReq = (MultipartRequest) req;
		System.out.println(mReq);
		
		//file 은 여기서 지정할 file , getFile의 file은 안드로이드에 fileList 에서 지정해준 처음 "file"+i
		/*	 
		 
		 ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
		 
            
         List<MultipartBody.Part> fileList = new ArrayList<>();
         
         for (int i = 0; i < paths.size(); i++) {
         	RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg") , new File(paths.get(i)) );
         	fileList.add(MultipartBody.Part.createFormData("file"+i , "test" + i +".jpg" , fileBody) );		//fileBody가 실제 파일에 해당한다.
          }
            */
		
		//이 부분에서 
		//getFiles는 안드로이드에서 ApiInterface에 
		//@POST("request_manual")
	   // @Multipart
	   // Call<String> sendFile_VO(@Part("vo") RequestBody data , @Part List<MultipartBody.Part> files); 여기부분임
		
		Map<String, MultipartFile> filelist = mReq.getFileMap();	
		System.out.println(filelist.size());
		
		
		
		//System.out.println(Arrays.toString(filelist.toArray()));
//		HashMap<String, String> pathmap = new HashMap<String, String>();
		ArrayList<ManualRequestFileVO> list = new ArrayList<ManualRequestFileVO>(); 
		for(int i = 0; i < filelist.size(); i++) { 
			ManualRequestFileVO filevo = new ManualRequestFileVO();
			if(filelist.get("file"+i) != null) {
		//		imgpath = common.appName(req) + common.fileUpload("pj", filelist.get("file"+i),	req);
				imgpath = common.fileUpload("pj", filelist.get("file"+i),	req);
				
				filevo.setReq_filepath(imgpath);
				filevo.setReq_filename("file"+i);
				System.out.println(imgpath);
				//http://192.168.0.62/bteam/upload/andboard/2022/09/26/76d99bc0-7772-496d-
				//9a27-2e1bb6f6c2fe_test.jpg
				list.add(filevo);
			} 
		}
		manualvo.setFileList(list);
		
		//파일path DB에 저장
		
		int result = dao.request(manualvo);
		
		
		
		
//				//파일패스에 따로 셋해줌
//				boardvo.setFile_path(imgpath);
//				
//				//화면에서 입력한 정보를 DB에 신규저장한 후
//				dao.board_insert(boardvo);
//				
//				
//
//				return gson.toJson(boardvo);
		
		
		
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/recent_list", produces = "text/html;charset=utf-8")
	public String recent_list(String data,  HttpServletRequest req) {
		List<CategorySearchVO> list = dao.recent_list(data);
		String result = new Gson().toJson(list);
		System.out.print(result);
		return result;
	}
	
	//찜한 설명서 리스트
	@RequestMapping(value = "/my_manual_list", produces = "text/html;charset=utf-8")
	public String my_manual_list(String email) {
		
		return new Gson().toJson(dao.my_manual_list(email));
	}
	
	//찜하기 상태 
	@RequestMapping(value = "/my_manual_select", produces = "text/html;charset=utf-8")
	public String my_manual_select(String email, String model_code) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("model_code", model_code);
		
		return dao.my_manual_select(map);
	}
	//찜하기 추가
	@RequestMapping(value = "/my_manual_insert", produces = "text/html;charset=utf-8")
	public String my_manual_insert(String email, String model_code) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("model_code", model_code);
		
		return dao.my_manual_insert(map)+"";
	}
	
	//찜하기 삭제
	@RequestMapping(value = "/my_manual_delete", produces = "text/html;charset=utf-8")
	public String my_manual_delete(String email, String model_code) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("model_code", model_code);
	
		return new Gson().toJson(dao.my_manual_delete(map))+"";
	}
	
	//설명서 다운로드하기 download_manual
	//다운로드 여부파악
	@RequestMapping(value = "/download_manual_check", produces = "text/html;charset=utf-8")
	public String download_manual(String email, String model_code) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("model_code", model_code);
		
		//우선 다운로드 한적이 있는지 파악
		
		return dao.download_manual_check(map)+"";
	}
	
	//해당 제품의 설명서 정보
	@ResponseBody @RequestMapping(value = "/manual_info", produces = "text/html;charset=utf-8")
	public String manual_info(String model_code) {
		ManualVO vo = dao.manual_info(model_code);
		return new Gson().toJson(vo);
	}
	
	//다운로드
	@RequestMapping("/download_manual")
	public void download(String filename, String filepath, HttpServletRequest req, HttpServletResponse resp) {
		//해당 첨부파일 정보를 DB에서 조회해와 클라이언트에 저장하는 다운로드처리
		
		common.fileDownload(filename, filepath, req, resp );
	}
}
