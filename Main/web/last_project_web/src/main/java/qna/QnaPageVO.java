package qna;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class QnaPageVO extends PageVO {
	List<QnaVO> qnaList;

	public List<QnaVO> getQnaList() {
		return qnaList;
	}

	public void setQnaList(List<QnaVO> qnaList) {
		this.qnaList = qnaList;
	}
}
