package notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired private NoticeDAO dao;
	
	@Override
	public int notice_insert(NoticeVO vo) {
		return dao.notice_insert(vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		return dao.notice_list();
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return dao.notice_detail(id);
	}

	@Override
	public int notice_update(NoticeVO vo) {
		return dao.notice_update(vo);
	}

	@Override
	public int notice_read(int id) {
		return dao.notice_read(id);
	}

	@Override
	public int notice_delete(int id) {
		return dao.notice_delete(id);
	}

	@Override
	public NoticePageVO notice_list(NoticePageVO vo) {
		return dao.notice_list(vo);
	}

	@Override
	public int notice_reply_insert(NoticeVO vo) {
		return dao.notice_reply_insert(vo);
	}

}
