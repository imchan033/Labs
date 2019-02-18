package kr.or.bit;

public class Airplane {
	private int airnum;
	private String airname;
	private static int airtotalcount;
	
	public Airplane(int airnum,String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++;
	}
	
	public void airplaneInfo() {
		System.out.printf("번호[%d], 이름[%s] \n",airnum,airname);
	}

	public void airPlaneTotalCount() {
		System.out.println("총 제작 비행기 수 : "+airtotalcount);
	}
		
}
/*
public class Airplane {
	public String name,airname;
	public int number,airnum;
	public static int count,airtotalcount;
	
	
	
	public void AirplaneInfo() {
		System.out.printf("이름 : %s, 번호 : %d\n",name,number);
	}
	public void getCount() {
		count++;
		System.out.println("누적대수 : "+count);
	}
	
	
	
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		airtotalcount++;
		System.out.printf("번호[%d], 이름[%s] \n",airnum,airname);
	}
	public void airPlaneTotalCount() {
		System.out.println("총 제작 비행기 수 : "+airtotalcount);
	}
		
}
 */
	
