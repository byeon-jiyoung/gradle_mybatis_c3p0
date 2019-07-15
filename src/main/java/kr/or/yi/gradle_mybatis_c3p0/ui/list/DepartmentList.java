package kr.or.yi.gradle_mybatis_c3p0.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;

@SuppressWarnings("serial")
public class DepartmentList extends AbstractList<Department> {
	
//	public DepartmentList(String dept) {
//		super(dept);
//	}
	
	public DepartmentList() {
		super("부서");
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// 직책번호, 직책명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 200);
	}
	
	@Override
	protected Object[] toArray(int idx) {
		Department department = itemList.get(idx);
		return department.toArray();
	}
	
	@Override
	protected String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "위치" };
	}
}
