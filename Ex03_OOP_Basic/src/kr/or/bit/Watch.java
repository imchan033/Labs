package kr.or.bit;
/*
* �ð�� ���� �귣��� ������ ������ �ִ�
* �귣��� ���ٱ�, ������ 15000���̴�
* ��ħ, ��ħ, ��ħ, �귣��, ������ �ܵ����� �����ϰų� �ٲܼ� ����
* �ð�� ������� ������ ������������ 1�뾿 �þ��.
* (��:��:��)�� �ѹ��� ����ϴ� ����� ������ �ִ�.
* �ð��� ���� ������ �� �ְ� (��, ��)�� �����ϴ� ���, (��,��,��)�� �����ϴ� ����� ���� �̸����� �����ؾ� �Ѵ�
* �ô� (0~12)��, ���� (0~59)��, �ʴ� (0~59)�� �����ϸ� �ٸ� ���� �Է��ϸ� 0���� �����ȴ�.
 */


public class Watch {
	private String brand;
	private int price;
	private int hour;
	private int minite;
	private int second;
	private static int count=0;
	

	
	public Watch(int hour, int minite, int second) {
		//brand = "���ٱ�";
		//price = 15000;
		//count ++;
		this("���ٱ�", 15000, hour, minite, second);
//		this.hour = sethour(hour);
//		this.minite = setminite(minite);
//		this.second = setsecond(second);
	}
	
	public Watch(String brand, int price, int hour, int minite, int second) {
		this.brand = brand;
		this.price = price;
		this.hour = hour;
		this.minite = minite;
		this.second = second;
		count ++;
	}

	public void setWatch(int hour, int minite) {
		this.hour = sethour(hour);
		this.minite = setminite(minite);
		
	}
	public void setWatch(int hour, int minite, int second) {
		this.hour = sethour(hour);
		this.minite = setminite(minite);
		this.second = setsecond(second);
	}

	public void printTime() {
		System.out.printf("%d : %d : %d, �������� : %d",hour,minite,second,count);
	}
	public int sethour(int hour) {
		return (hour>12 || hour<1)? 0: hour;
	}
	public int setminite(int minite) {
		return (minite>59 || minite<1)? 0: minite;
	}
	public int setsecond(int second) {
		return (second>59 || second<1)? 0: second;
	}
}
