package kr.or.bit;
/*
 ����� ���, �̸�, ����(job)�� ������ �ִ� =>
 ��� ������ default �� ��� =9999, �̸� = �ƹ��� , ���� = ����
 Employee e = new Employee()
  ������ �Լ��� ���(�� ���������) ���,�̸�,������ �Է��Ͽ� ��� ���� �����ϸ�
 ����� ������ �� ����� ������ ���, �̸�, ���� ���� �� ���� ������ �� �ִ�.
 ��������� ���, �̸�, ������ �ѹ��� Ȯ�� �� �� �ְ� (������ ������ Ȯ�� �Ұ� �ϴ�)
 ���������� ����� �̸������� ��ȸ�����ϴ�. ��µǴ� ������ �ݵ�� ���̶�� ���ڰ� ���;� �Ѵ�
 */

public class Employee {
	private int empno;
	private String name;
	private String job;
	
	public Employee() { //default constructor
		empno = 9999;
		name = "�ƹ���";
		job = "����";
	}
	public Employee(int empno,String name,String job) {
		this.empno = empno;
		this.name = name;
		this.job = job;		
	}
	
	public String getName() {
		return name+"��"; //����..(����) �����ٿ���
	}
	public void setEmpno(int empno) { //write : setter
		this.empno = empno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	//�Ϲ��Լ�
	public void employeeInfoPrint() {
		System.out.printf("���:[%d],�̸�:[%s],����:[%s]\n",empno,name,job);
	}
	
	
	
}
