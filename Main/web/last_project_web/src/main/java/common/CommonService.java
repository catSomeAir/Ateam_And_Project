package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CommonService {
	
	//공공데이터 요청결과 문자를 json 으로 변환하여 필요한 데이터를 수집한다
	public Map<String, Object> requestAPItoMap( StringBuffer url ) {
		JSONObject json = new JSONObject( requestAPI( url ) );
		json = json.getJSONObject( "response" );
		int code = Integer.parseInt( 
						json.getJSONObject("header")
							.getString("resultCode") );
		int count = 0;
		if( code==0 ) {
			json = json.getJSONObject( "body" );
			if( json.has("totalCount") ) count = json.getInt("totalCount");
			if( json.get("items") instanceof JSONObject ) {
				//items : "", items : { item:{}, item:{},... }
				json = json.getJSONObject( "items" ); 
			}
			
		}else {
			json.put("item", new JSONObject());
		}
		json.put("count", count);
		return json.toMap();
	}
	
	
	//회원가입축하 메일 보내기
	public void sendWelcomeMail(String email, String name, String attach) {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.naver.com");//메일서버지정
		mail.setCharset("utf-8");
		mail.setDebug(true); //메일전송과정 로그로 확인
		
		//로그인아이디, 비번 입력하기
		mail.setAuthentication("보내는사람 메일아이디", "비번");
		mail.setSSLOnConnect(true); //로그인버튼 누르기
		
		try {
			mail.setFrom("보내는사람 메일아이디@naver.com", "지능형 IoT 관리자");
			mail.addTo(email, name); //받는사람 이메일 지정
			
			mail.setSubject("한울 지능형 IoT 개발자과정 가입축하"); //제목
			StringBuffer msg = new StringBuffer();
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<h3><a target='_blank' href='http://hanuledu.co.kr/'>한울 지능형 IoT</a></h3>");
			msg.append("<hr>");
			msg.append("<p>지능형 IoT 과정 가입을 축하합니다</p>");
			msg.append("<p>입교시 첨부된 파일을 확인하신후 등교하시기 바랍니다</p>");
			msg.append("</body>");
			msg.append("</html>");
			mail.setHtmlMsg(msg.toString()); //내용
			
			EmailAttachment file = new EmailAttachment();
			file.setPath(attach);
			mail.attach(file); //파일첨부하기
			
			mail.send(); //메일 보내기버튼 누르기 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//첨부파일 다운로드
	public void fileDownload(String filename, String filepath
							, HttpServletResponse response
							, HttpServletRequest request) {
		//다운로드할 파일객체를 생성
		//DB저장  http://192.168.0.2/iot/upload/notice/2022/08/25/21d94db7-f9c5-4b1b-9229-f4799fe01716_kakao_login.zip
		//실제파일 d://app/iot/upload/notice/2022/08/25/21d94db7-f9c5-4b1b-9229-f4799fe01716_kakao_login.zip
		//http://192.168.0.2/iot  --> d://app/iot
		filepath = filepath.replace( appName(request), "d://app" + request.getContextPath() );
		File file = new File( filepath );
		
		//클라이언트에 쓰기작업할 ContentType 을 지정한다: MimeType
		String mime = request.getSession().getServletContext().getMimeType(filepath);
		response.setContentType(mime);
		
		try {
			filename = URLEncoder.encode(filename, "utf-8");
			response.setHeader("content-disposition"
									, "attachment; filename=" + filename);
			
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
		}catch(Exception e) {}
		
		//Input / Output - byte, 문자
		//FileInputStream / FileOutputStream
		//FileReader/ FileWriter
		//BufferedReader ( new FileReader )
	}
	
	
	//첨부파일 업로드
	public String fileUpload(String category, MultipartFile file, HttpServletRequest request) {
		//업로드할 물리적 위치
		// D:\Study_Spring\Workspace\.metadata\.plugins\org...er.core\tmp1\wtpwebapps\iot\resources
		//String path = request.getSession().getServletContext().getRealPath("resources");
		// d://app/iot
		String path = "d://app" + request.getContextPath(); 
		
		// upload/profile/2022/08/23
		String upload = "/upload/" + category 
					+  new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		//D:\Study_Spring\Wo....\iot\resources/upload/profile/2022/08/23
		path += upload;
		
		//해당 경로 폴더가 없으면 만든다
		File folder = new File( path );
		if( ! folder.exists() )	folder.mkdirs();
		
		//파일 업로드
		//파일명에 고유id를 붙인다
		//dafqer32-g38fgfa_abc.png
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		try {
			file.transferTo( new File(path, uuid) );
		}catch(Exception e) {}
		
		// /upload/profile/2022/08/23/dafqer32-g38fgfa_abc.png
		// --> http://localhost:8080/iot/upload/profile/2022/08/23/dafqer32-g38fgfa_abc.png
		return appName(request) + upload + "/" + uuid;
	}
	
	public String appName(HttpServletRequest r) {
		// RequestURL: http://localhost:8080/iot/naver_callback
		// ServletPath: /naver_callback
		// replace 후: http://localhost:8080/iot
		return r.getRequestURL().toString().replace(r.getServletPath(), "");
	}
	
	//API요청
	public String requestAPI(StringBuffer apiUrl) {
		String url = apiUrl.toString();
	    try {
	        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
	        con.setRequestMethod("GET");
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) { // 정상 호출
	          br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
	        } else {  // 에러 발생
	          br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
	        }
	        String inputLine;
	        StringBuffer res = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	          res.append(inputLine);
	        }
	        br.close();
	        con.disconnect();
	        url = res.toString();
	      } catch (Exception e) {
	        System.out.println(e.getMessage());
	      }
	    
		return url;
	}
	
	
	public String requestAPI(StringBuffer apiUrl, String property) {
		String url = apiUrl.toString();
		try {
			HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", property);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			con.disconnect();
			url = res.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return url;
	}
	
	//임시 비밀번호를 이메일로 전송
	public boolean sendPassword(String email, String userid, String name, String pw) {
		HtmlEmail mail = new HtmlEmail();
		//메일서버지정
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true); //Console을 통해 메일전송과정 확인
		
		//로그인하기
		mail.setAuthentication("이메일아이디", "이메일아이디에 대한 비번");
		//로그인버튼 클릭하기
		mail.setSSLOnConnect(true);
		boolean send = true;
		
		try {
		
			//메일 보내는이 지정
			//보내는 이메일주소: 이메일아이디@naver.com
			mail.setFrom("보내는 이메일주소", "IoT관리자"); 
			//메일 받는이 지정
			mail.addTo(email, name);
			
			//메일제목
			mail.setSubject("지능형 IoT 로그인 임시비밀번호 발급");
			
			//메일내용
			StringBuffer msg = new StringBuffer();
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<h3>[").append(name).append("]님 임시비밀번호 발급</h3>");
			msg.append("<p>아이디: ").append(userid).append("</p>");
			msg.append("<p>발급된 임시 비밀번호로 로그인 후 비밀번호를 변경하세요</p>");
			msg.append("<p>임시 비밀번호: <strong>").append(pw).append("</strong></p>");
			msg.append("</body>");
			msg.append("</html>");
			
			mail.setHtmlMsg(msg.toString());
			
			//메일보내기버튼 클릭
			mail.send();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			send = false;
		}
		return send;
	}
	
	
	
	//비밀번호를 암호화하는데 사용할 솔트생성
	public String generateSalt() {
		SecureRandom r = new SecureRandom();
		byte[] bytes = new byte[24];
		r.nextBytes(bytes);
		
		StringBuffer data = new StringBuffer();
		for( byte b : bytes ) {
			data.append( String.format("%02x", b) );
		}
		return data.toString(); 
	}
	
	//salt 문자열을 사용해 비밀번호를 암호화하는 처리
	public String getEncrypt(String salt, String pw) {
		pw += salt;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(pw.getBytes());
			
			byte[] bytes = digest.digest();
			StringBuffer data = new StringBuffer();
			for(byte b : bytes ) {
				data.append( String.format("%02x", b) ); //16진수로 변환 00~09
			}
			pw = data.toString();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return pw;
	}
	
}
