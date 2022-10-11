package search;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO {
	@Autowired private SqlSession sql;
	
	//모델코드에 대한 제품정보
	public CategorySearchVO model_code_list(String model_code) {
		return sql.selectOne("search.model_code_list", model_code);
	}
	
	//검색어로 검색 - 전체
	public List<CategorySearchVO> search_text(String search_div_text){
		
		return sql.selectList("search.serach_text", search_div_text);
	}
	
	//검색어로 검색 - 모델명
	public List<CategorySearchVO> search_text_name(String search_div_text){
		
		return sql.selectList("search.search_text_name", search_div_text);
	}
	//검색어로 검색 - 모델코드
	public List<CategorySearchVO> search_text_code(String search_div_text){
		
		return sql.selectList("search.search_text_code", search_div_text);
	}
	
	//카테고리로 검색
	public List<CategorySearchVO> m_list(String m_name){
		
		return sql.selectList("search.m_list", m_name);
	}
	
	
	
	//현재 입력한 텍스트와 연관된 연관검색어 뜨게하기
	public List<String> relate_text(String search_text){
			
			return sql.selectList("search.relate_text", search_text);
		}
	}
