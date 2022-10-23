package qna;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO implements QnaService {
	@Autowired @Qualifier("ateam") private SqlSession sql;
	
	@Override
	public int qna_insert(QnaVO vo) {		
		return sql.insert("qna.insert", vo);
	}

	@Override
	public QnaPageVO qna_list(QnaPageVO page) {
		page.setTotalList(  sql.selectOne("qna.qna_total", page) );
		page.setQnaList(sql.selectList("qna.qna_list", page) );
		return page;
	}

	@Override
	public QnaVO qna_detail(int id) {
		QnaVO vo = sql.selectOne("qna.qna_detail", id);
		QnaAnswerVO answer = sql.selectOne("qna.qna_answer", id);
		vo.setAnswer( answer);
		return vo;
	}

	@Override
	public int qna_read(int id) {
		return sql.update("qna.read", id);
	}

	@Override
	public int qna_update(QnaVO vo) {
		return sql.update("qna.update", vo);
	}

	@Override
	public int qna_delete(int id) {
		return sql.delete("qna.delete", id);
	}

	@Override
	public List<FieldVO> qna_filed_list(int large_id) {
		return sql.selectList("qna.field_list", large_id);
	}

	@Override
	public int qna_answer_insert(QnaAnswerVO vo) {
		return sql.insert("qna.answer_insert", vo);
	}

	@Override
	public int qna_answer_update(QnaAnswerVO vo) {
		return sql.update("qna.answer_update", vo);
	}

	@Override
	public QnaPageVO qna_list(HashMap<String, Object> map) {
		QnaPageVO page = (QnaPageVO)map.get("page");
		page.setTotalList( sql.selectOne("qna.qna_total", map) );
		page.setQnaList(sql.selectList("qna.qna_list", map) );
		return page;
	}

}
