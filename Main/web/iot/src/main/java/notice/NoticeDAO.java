package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements NoticeService {
	@Qualifier("hanul") @Autowired private SqlSession sql;
	
	@Override
	public int notice_insert(NoticeVO vo) {
		return sql.insert("notice.insert", vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		return sql.selectList("notice.list");
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return sql.selectOne("notice.detail", id);
	}

	@Override
	public int notice_update(NoticeVO vo) {
		return sql.update("notice.update", vo);
	}

	@Override
	public int notice_read(int id) {
		return sql.update("notice.read", id);
	}

	@Override
	public int notice_delete(int id) {
		return sql.delete("notice.delete", id);
	}

	@Override
	public NoticePageVO notice_list(NoticePageVO vo) {
		//총 글 건수를 조회하면 나머지 페이지관련 데이터들이 결정됨
		vo.setTotalList( sql.selectOne("notice.totalList", vo) );
		vo.setList( sql.selectList("notice.list", vo) );
		return vo;
	}

	@Override
	public int notice_reply_insert(NoticeVO vo) {
		return sql.insert("notice.reply_insert", vo);
	}

}
