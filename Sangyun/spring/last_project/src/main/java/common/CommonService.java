package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CommonService {
	
	//회원가입축하메시지 -> 이메일 인증으로사용
	
	public void sendWelcomeMail(String email, String name, String attach) {
		HtmlEmail mail =  new HtmlEmail();
		//메일서버지정하기
		mail.setHostName("smtp.naver.com");
		//인코딩
		mail.setCharset("utf-8");
		//콘솔 디버그ㅜ
		mail.setDebug(true);
		
		//로그인 아이디 비번
		mail.setAuthentication("ta2080", ")%)$Tkddbs2did");
		//로그인버튼 누르기
		mail.setSSLOnConnect(true);
		
		//보내는사람 메일
		try {
			mail.setFrom("ta2080@naver.com)","지능형 IoT 관리자");
			//받는사람 설정
			mail.addTo(email, name);
			
			//제목
			mail.setSubject("한울 지능형 IoT 개발자과정 가입축하");
			
			//내용 : html형태로 작성 => StringBuffer
			StringBuffer msg = new StringBuffer();
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<h3><a target='_blank' href='http://hanuledu.co.kr/'>한울 지능형 IoT</a></h3>");
//			msg.append("<hr>");
			msg.append("<p>지능형 ioT 과정 가입을 축하합니다 </p>");
			msg.append("<p>입교시 첨부된 파일을 확인하신 후 등교하시기 바랍니다. </p>");
			msg.append("</body>");
			msg.append("</html>");
			mail.setHtmlMsg(msg.toString());
			
			//첨부파일 객체생성 : EmailAttachment() 
			EmailAttachment file = new EmailAttachment();
			file.setPath(attach);
			
			//첨부파일 메일에 첨부
			mail.attach(file);
			
			//메일전송하기
			mail.send();
			
			
			
			
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String appName(HttpServletRequest req) {
		//req.getRequestURL() : http://localhost/iot/naver_callback
		//req.getServletPath() : /naver_callback
		//replace후 : http://localhost/iot
	return req.getRequestURL().toString().replace(req.getServletPath(), "");		// naver_callback
	}
	
	//첨부파일 다운로드
	public void fileDownload(String filename, String filepath, HttpServletRequest req, HttpServletResponse resp ) {
		//다운로드할때 어떤이름으로 다운로드할것인지 -> 이건 DB의 filename으로 지정
		//실제 파일은 UUID가 붙은 이름으로 저장되어있다. -> filepath가 필요하다.
		//실제 DB에 저장되어있는 정보는 http://192.168.0.33/iot/upload ... -> HttpServletRequest 필요
		//클라이언트에 대한 응답처리가 필요 : response
		
		//1. 저장경로 설정
			// DB의 저장 경로 :  http://192.168.0.33/iot/upload .
			// 실제 저장경로  :  D://app/iot/upload/notice/2022...
			// DB저장경로 http://192.168.0.33/iot ---->> D://app/iot 로 바꿔줘야한다. : iot는 어플리케이션이름 = req.getContextPath()
		
		filepath=filepath.replace( appName(req), "d://app/"+req.getContextPath());
			
		//2. 다운로드할 파일 객체를 생성 ( filepath 에있는 파일 )
			File file = new File(filepath);
			//쓰기작업을하려면 사용자Client 쪽에 쓰기작업해야함. 확장자 타입을 알아야한다.                       쓰기작업을 할 때 버퍼msg만들고 Printwriter 활용하여서 객체하나 out으로 만듦 = response.getWriter(); - > writer에 html 형식으로 작성: response.setContentType("text/html, charset=utf-8")로지정하면
			
		//3. 쓰기 작업을 하기 위해 ContentType을 지정해야한다( Server-> MimeType에 존재, 세션->컨텍스트를 통해서 해당 file의 mimetype 알수있음 , 쓰기는 response의 setcontenttype) 
			String mime = req.getSession().getServletContext().getMimeType(filepath);
			
			resp.setContentType(mime);
		
		//5. File 내보내기 :ServletOutputStream 클래스는 resposne의  OutputStream	
			try {
				//예외처리 
				filename = URLEncoder.encode(filename, "utf-8");
				//4. Header설정 , filename 한글파일깨짐 인코딩
				resp.setHeader("content-disposition", "attachment; filename=" + filename);
			
				ServletOutputStream out =  resp.getOutputStream();
				//파일을 통으로 읽어서 내보내는 처리 : file을 copy시키는 util : FileCopyUtil활용 static메소드  : copy( 먼저 파일읽어들일것, 내보냄(outputStream) ) 우선은 파일을 읽어야함
				FileCopyUtils.copy(new FileInputStream(file), out);
				out.flush();	//다 내보냄
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//"<html>" : 문자데이터 -> Reader / Writer :문자
			// Input  / Output : byte file, 문자
			// InputStream / OutputStream : 쓰고 읽는작업을 하는 친구들
			// 파일을 읽고쓰려면
			// FileInputStream / FileOutputStream 혹은
			// FileReader	   / FileWriter
			// 버퍼활용하려면 BufferReader에 FileReader를 끼워서 쓴다.
			// BufferReader( new FileReader )
			
		//5. 
	}
	
	
	//첨부파일 업로드 : D:\Study_Spring\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\iot\resources 에 업로드폴더생성
	public String fileUpload(String category, MultipartFile file, HttpServletRequest req) {	//어디에 넣을지 category 지정, 파일정보 MultipartFile, 물리경로 ServletRequest필요
		
		//물리적위치 : req.getSession().getServletContext().getRealPath("")여기까지가 iot폴더까지 온거임
//		String path =  req.getSession().getServletContext().getRealPath("resources");
		String path = "d://app"+ req.getContextPath();	//contextpath = iot
		
		//업로드시킬 폴더 upload/profile/2022/08/23 로 만들거야
		String upload = "/upload/" + category + new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		
		path += upload;	//경로의 풀네임 완성시키기
		
		//폴더가 없으면 생성해주라 : 폴더도 OS입장에서는 file이므로 File객체
		File folder = new File( path );
		if( !folder.exists()) {
			folder.mkdirs();	//여러개폴더 한번에 생기니까 mkdir s 로 해야함
		}
		
		//파일업로드 : 서버에 저장해야하므로 -> 파일이름에 고유값 지정 : UUID
		//랜덤한 UUID에다가 실제 파일이름 더해
		//asekglj2-aweloig3_실제파일이름.png 이런식으로 만들기
		String uuid = UUID.randomUUID().toString()+"_" +file.getOriginalFilename();
		
		//파일옮기기 : transferTO()		--> 예외처리해주어야함
		try {
			file.transferTo(new File(path, uuid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//리턴은 업로드위치알려줘야함 : upload는 날짜지정해준 폴더까지임 거기다가 uuid더해주면 됨
		return appName(req) + upload + "/" + uuid;
		
	}
	
	//API요청
	public String requestAPI(StringBuffer apiUrl) {
		String url = apiUrl.toString();
	    try {
	        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
	        con.setRequestMethod("GET");
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        System.out.print("responseCode="+responseCode);
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
			System.out.print("responseCode="+responseCode);
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
