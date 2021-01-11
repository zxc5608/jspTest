package kr.or.ddit.user.model;

public class empVo {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	@Override
	public String toString() {
		return "empVo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + "]";
	}
	
	
	
	
}
