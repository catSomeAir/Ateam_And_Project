package cs;

public interface CsService {

	
	int cs_insert(CsVO vo); 	//고객센터 글 신규저장
	CsPageVO cs_list(CsPageVO page); //방명록 목록(페이징처리된)조회
	CsVO cs_detail(int id); 	//방명록 상세조회
	int cs_read(int id); 		//방명록 조회수 증가처리
	int cs_update(CsVO vo); 	//방명록 변경저장
	
}
