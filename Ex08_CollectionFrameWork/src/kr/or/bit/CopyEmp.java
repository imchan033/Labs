package kr.or.bit;

//4. CopyEmp 라는 클래스를 만드세요 (구조는 Emp 와 같은데)
//job member field 대신에 (삭제)
//private int sal 추가하고 (getter, setter 구현)

public class CopyEmp {
	private int empno;
	private String ename;
	private int sal;
	
	public CopyEmp(int empno, String ename, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

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

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "CopyEmp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + "]";
	}

	
	
	
}

