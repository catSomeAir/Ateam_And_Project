package visual;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class VisualDAO implements VisualService {
	@Autowired @Qualifier("hr") private SqlSession sql;
	
	@Override
	public List<HashMap<String, Object>> department() {
		return sql.selectList("visual.department");
	}

	@Override
	public List<HashMap<String, Object>> hirement_year() {
		return sql.selectList("visual.hirement_year");
	}

	@Override
	public List<HashMap<String, Object>> hirement_month() {
		return sql.selectList("visual.hirement_month");
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_year() {
		return sql.selectList("visual.hirement_top3_year");
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_month() {
		return sql.selectList("visual.hirement_top3_month");
	}

	@Override
	public List<HashMap<String, Object>> hirement_year(HashMap<String, Object> map) {
		return sql.selectList("visual.hirement_year", map);
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_year(HashMap<String, Object> map) {
//		sum(decode(unit, 2001, count, 0)) y2001
//	    , sum(decode(unit, 2002, count, 0)) y2002
//		, sum(decode(unit, 2003, count, 0)) y2003
//	    , sum(decode(unit, 2004, count, 0)) y2004
//		, sum(decode(unit, 2005, count, 0)) y2005
//		'2005' as y2005, '2006' as y2006, '2007' as y2007, '2008' as y2008
		String range = "";
		int begin = Integer.parseInt( map.get("begin").toString() );
		int end = Integer.parseInt( map.get("end").toString() );
		for(int year=begin; year<=end; year++) {
			//range += (range.isEmpty()?"":", ") + "sum(decode(unit, "+ year +", count, 0)) y"+year;
			range += (range.isEmpty()?"":", ") + "'"+ year +"' as y" +year;
		}
		map.put("range", range);
		return sql.selectList("visual.hirement_top3_year", map);
	}

}
