package kr.or.bit;

//Emp e = new Emp(); ����Ѹ�
public class Emp {
	private int empno;
	private String ename;
	
	public Emp() { //������ �Լ�
		System.out.println("default...");
	}
	public Emp(int empno, String ename) {
		//overloading constructor
		this.empno = empno;
		this.ename = ename;
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
	public void empInfo() {
		System.out.println("empno : "+empno+"  ename : "+ename);
	}

}
