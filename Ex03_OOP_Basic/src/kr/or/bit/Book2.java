package kr.or.bit;
/*
å�� å�̸��� ������ ������ �ִ�.
å�� ���ǵǸ� �ݵ�� å�� å�� �̸��� ������ ������ �־�� �Ѵ�.
å�� �̸��� ���� ������ Ư�� ����� ���ؼ��� �� �� �ְ� ���ǵ� �� �Ŀ��� ������ �� ����
å�̸��� ���������� ���� ������ ���� �� �ִ� (getter)
 */

public class Book2 {
	private String name;
	private int price;
	
	//public Book2() {} �䱸����x : å�� ���ǵǸ� [�ݵ��] å�� å�� �̸��� ������ ������ �־�� �Ѵ�.
	//					���������� �ᵵ ������x
	
	public Book2(String name,int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public void bookInfo() {
		System.out.println("å �̸� : "+this.name+"\nå ���� : "+this.price);
	}

}
