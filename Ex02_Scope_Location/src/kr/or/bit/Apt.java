package kr.or.bit;

public class Apt {
	public String aptname;  //
	int door; 				//default  �ٺ� (�Ⱦ�)
	private int window;		//private  ĸ��ȭ, ����ȭ
	
	//�����Ҵ�
	//�����Ҵ��� ���� �����Ҵ��� ���� ������ ��ȣ
	//0�� ���� �� ����!
	public void write_window(int w) { //ĸ��ȭ�� �ڿ��� ���ؼ� ���Ⱑ���� write �Լ�
		if(w==0) {
			window = 100;
		}else {
			window = w;
		}	
	}
	public int read_window() {		  //ĸ��ȭ�� �ڿ��� read �Լ�
		return window;
	}
}
