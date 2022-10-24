package qna;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired private QnaDAO dao;
	
	@Override
	public int qna_insert(QnaVO vo) {
		return dao.qna_insert(vo);
	}

	@Override
	public QnaPageVO qna_list(QnaPageVO page) {
		return dao.qna_list(page);
	}

	@Override
	public QnaVO qna_detail(int id) {
		return dao.qna_detail(id);
	}

	@Override
	public int qna_read(int id) {
		return dao.qna_read(id);
	}

	@Override
	public int qna_update(QnaVO vo) {
		return dao.qna_update(vo);
	}

	@Override
	public int qna_delete(int id) {
		return dao.qna_delete(id);
	}

	@Override
	public List<FieldVO> qna_filed_list(int large_id) {
		return dao.qna_filed_list(large_id);
	}

	@Override
	public int qna_answer_insert(QnaAnswerVO vo) {
		return dao.qna_answer_insert(vo);
	}

	@Override
	public int qna_answer_update(QnaAnswerVO vo) {
		return dao.qna_answer_update(vo);
	}

	@Override
	public QnaPageVO qna_list(HashMap<String, Object> map) {
		return dao.qna_list(map);
	}

}
