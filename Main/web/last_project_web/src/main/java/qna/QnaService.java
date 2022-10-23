package qna;

import java.util.HashMap;
import java.util.List;

public interface QnaService {
	int qna_insert(QnaVO vo);					//질문신규저장
	QnaPageVO qna_list(QnaPageVO page);			//질문목록
	QnaPageVO qna_list(HashMap<String, Object> map);		//질문목록
	List<FieldVO> qna_filed_list(int large_id);	//질문분야목록
	QnaVO qna_detail(int id);					//질문내용
	int qna_read(int id);						//조회수처리
	int qna_update(QnaVO vo);					//질문변경저장
	int qna_delete(int id);						//질문삭제

	int qna_answer_insert(QnaAnswerVO vo);	//질문에 대한 답글 등록-관리자
	int qna_answer_update(QnaAnswerVO vo);	//질문에 대한 답글 변경저장-관리자
}
