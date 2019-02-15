package kr.or.bit;

import java.util.Scanner;

public class Theater {
	private Scanner scanner;
	private String[][] seat;
	private int c,r; //�¼� �Ը�
	private int column; //��
	private int row;    //��
	
	public Theater(){
		scanner = new Scanner(System.in);
		c = 10; //5��
		r = 10; //5��
		seat = new String[c][r]; 
	}
	//�¼�����
	public void selectSeat() {
		makeSeat();
		printSeat();
		
		while(true) {
		System.out.println("������ �¼��� �����ϼ���.");
		System.out.print("�� : ");
		column = scanner.nextInt();
		System.out.print("�� : ");
		row = scanner.nextInt();
		
			if(column<1 || column>c || row<1 || row>r) {
				System.out.println("����! �ٽ� �Է����ּ���!");
			}else {
				switch(seat[column-1][row-1]) {
					case "[*]" : System.out.println("�̹� ����� �ڼ��Դϴ�.");
						break;
					default : seat[column-1][row-1] = "[*]";
							  printSeat();
						break;
				}
			}
		}
		
	}
	//�¼���縸���
	private void makeSeat() {
		for(int i=0 ; i<c ; i++) {
			for(int j=0 ; j<r ; j++) {
				seat[i][j] = "[ ]";
			}
		}
	}
	//�¼����
	private void printSeat() {
		for(int i=0 ; i<c ; i++) {
			for(int j=0 ; j<r ; j++) {
				System.out.print(seat[i][j]);
			}System.out.println();
		}
	}	
}
