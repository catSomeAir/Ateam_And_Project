package manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manysearch.ManySearchVO;
import search.CategorySearchVO;

@Repository
public class ManualDAO {
	@Autowired private SqlSession sql;
	
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
	
}
