package kr.or.yi.gradle_mybatis_c3p0.dto;

public class State {
	private String deptname;
	private int total;
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return String.format("State [deptname=%s, total=%s]", deptname, total);
	}
}
