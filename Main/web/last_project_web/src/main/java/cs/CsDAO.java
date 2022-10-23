package cs;

import javax.mail.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CsDAO implements CsService {
	@Autowired @Qualifier("ateam") SqlSession sql;
	
	@Override
	public int cs_insert(CsVO vo) {
//		System.out.println("dao에도 왔도!!");
		return sql.insert("cs.insert", vo);
	}

	@Override
	public CsPageVO cs_list(CsPageVO page) {
		//총글건수 조회
		page.setTotalList( sql.selectOne("cs.totalList", page) );
		page.setList( sql.selectList("cs.list", page) );
		//해당 페이지의 글목록 조회 
		
		return page;
	}

	@Override
	public CsVO cs_detail(int id) {
		CsVO vo = sql.selectOne("cs.cs_detail", id);
		
		return vo;
	}

	@Override
	public int cs_read(int id) {
		return sql.update("cs.cs_read", id);
	}

	@Override
	public int cs_update(CsVO vo) {
		return sql.update("cs.update", vo);
	}



}
