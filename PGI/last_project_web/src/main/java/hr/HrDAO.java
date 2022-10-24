package hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HrDAO implements HrService {
	@Autowired @Qualifier("hr") private SqlSession sql;

	@Override
	public int employee_insert(EmployeeVO vo) {
		return sql.insert("hr.insert", vo);
	}

	@Override
	public List<EmployeeVO> employee_list() {
		return sql.selectList("hr.list");
	}

	@Override
	public EmployeeVO employee_detail(int employee_id) {
		return sql.selectOne("hr.detail", employee_id);
	}

	@Override
	public int employee_update(EmployeeVO vo) {
		return sql.update("hr.update", vo);
	}

	@Override
	public int employee_delete(int employee_id) {
		return sql.delete("hr.delete", employee_id);
	}

	@Override
	public List<DepartmentVO> employee_department_list() {
		//사원이 속한 부서목록
		return sql.selectList("hr.employee_department_list");
	}

	@Override
	public List<EmployeeVO> employee_list(int department_id) {
		//부서에 속한 사원목록
		return sql.selectList("hr.department_employee_list", department_id);
	}

	@Override
	public List<DepartmentVO> department_list() {
		return sql.selectList("hr.department_list");
	}

	@Override
	public List<JobVO> job_list() {
		return sql.selectList("hr.job_list");
	}

	@Override
	public List<EmployeeVO> employee_name_list() {
		return sql.selectList("hr.employee_name_list");
	}

}
