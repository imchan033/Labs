package kr.or.bit;

public class Airplane {
	public String name,airname;
	public int number,airnum;
	public static int count,airtotalcount;
	
	
	
	public void AirplaneInfo() {
		System.out.printf("�̸� : %s, ��ȣ : %d\n",name,number);
	}
	public void getCount() {
		count++;
		System.out.println("������� : "+count);
	}
	
	
	
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		airtotalcount++;
		System.out.printf("��ȣ[%d], �̸�[%s] \n",airnum,airname);
	}
	public void airPlaneTotalCount() {
		System.out.println("�� ���� ����� �� : "+airtotalcount);
	}
		
}
	
