package visual;

import java.util.HashMap;
import java.util.List;

public interface VisualService {
	List<HashMap<String, Object>> department(); 	//부서별 사원수조회
	List<HashMap<String, Object>> hirement_year(); 	//년도별 채용인원수조회
	List<HashMap<String, Object>> hirement_year(HashMap<String, Object> map); 	//년도별 채용인원수조회
	List<HashMap<String, Object>> hirement_month(); //월별 채용인원수조회
	List<HashMap<String, Object>> hirement_top3_year();  //상위3위 부서의 년도별 채용인원수조회
	List<HashMap<String, Object>> hirement_top3_year(HashMap<String, Object> map);  //상위3위 부서의 년도별 채용인원수조회
	List<HashMap<String, Object>> hirement_top3_month(); //상위3위 부서의월별 채용인원수조회
}
