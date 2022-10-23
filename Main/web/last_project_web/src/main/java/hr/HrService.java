package hr;

import java.util.List;

public interface HrService {
	int employee_insert(EmployeeVO vo);//신규사원등록-신규저장
	List<EmployeeVO> employee_list(); //사원목록조회
	List<EmployeeVO> employee_list(int department_id); //특정부서에 속한 사원목록조회
	List<EmployeeVO> employee_name_list();//매니저로 지정할 사원목록조회
	List<DepartmentVO> employee_department_list(); //부서목록조회(사원들이 있는 부서목록)
	List<DepartmentVO> department_list(); //부서목록조회(회사의 전체 부서목록)
	List<JobVO> job_list(); //업무목록조회(회사의 전체 업무목록)
	EmployeeVO employee_detail(int employee_id); //사원상세조회
	int employee_update(EmployeeVO vo); //사원정보변경저장
	int employee_delete(int employee_id);//사원정보삭제
}
