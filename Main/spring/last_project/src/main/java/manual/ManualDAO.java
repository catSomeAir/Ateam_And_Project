package manual;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.CategorySearchVO;

@Repository
public class ManualDAO {
	@Autowired private SqlSession sql;
	//찜하기 상태 조회
	public String my_manual_select(HashMap<String, String> map){
		return sql.selectOne("manual.my_manual_select",map)+"";
	}
	
	//찜하기 추가
		public int my_manual_insert(HashMap<String, String> map){
			return sql.insert("manual.my_manual_insert",map);
		}
	//찜하기 삭제
	public int my_manual_delete(HashMap<String, String> map){
		return sql.delete("manual.my_manual_delete",map);
	}
	
	
	//찜한 설명서 리스트
	public List<CategorySearchVO> my_manual_list(String email){
		return sql.selectList("manual.my_manual_list",email);
	}
	//설명서 요청 정보저장
	public int request(ManualRequestVO vo) {
		int result = sql.insert("manual.request",vo);
		if(vo.getFileList().size() !=0) {
			//설명서 요청 정보 첨부파일 저장
			 sql.insert("manual.request_file",vo);
		}
		return result;
	}
	
	
	//메인탭 최근 조회한 설명서 정보
	public List<CategorySearchVO> recent_list(String data) {
		 data = data.replace("[", "");
		 data = data.replace("]", "");
		 data = data.replace("\"","\'");
		 System.out.println(data);
		return sql.selectList("manual.recent_list", data);
	}
//	
//	public int request_file(HashMap<String, String> pathmap) {
//		
//		return result;
//	}

	public int download_manual_check(HashMap<String, String> map) {
		//다운로드 한적 있는지 파악
		
//		int result = 0;
//		
//		if(check == 1) {//다운로드한적있는경우 
//			result = 1;
//		}else {// 다운로드한적 없는경우
//			sql.insert("manual.download_manual_insert", map);
//			result = 0;
//		}
		return sql.selectOne("manual.download_manual_check", map);
	}
	
	
	
	public ManualVO manual_info(String model_code) {
	
		return sql.selectOne("manual.manual_info", model_code);
	}
	
	public String brand_logo(String brand_name) {
		
		return sql.selectOne("manual.brand_logo", brand_name);
	}
}
