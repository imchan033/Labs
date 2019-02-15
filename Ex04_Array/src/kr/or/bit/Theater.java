package kr.or.bit;

import java.util.Scanner;

public class Theater {
	private Scanner scanner;
	private String[][] seat;
	private int c,r; //좌석 규모
	private int column; //행
	private int row;    //열
	
	public Theater(){
		scanner = new Scanner(System.in);
		c = 10; //5행
		r = 10; //5열
		seat = new String[c][r]; 
	}
	//좌석선택
	public void selectSeat() {
		makeSeat();
		printSeat();
		
		while(true) {
		System.out.println("예약할 좌석을 선택하세요.");
		System.out.print("행 : ");
		column = scanner.nextInt();
		System.out.print("열 : ");
		row = scanner.nextInt();
		
			if(column<1 || column>c || row<1 || row>r) {
				System.out.println("오류! 다시 입력해주세요!");
			}else {
				switch(seat[column-1][row-1]) {
					case "[*]" : System.out.println("이미 예약된 자석입니다.");
						break;
					default : seat[column-1][row-1] = "[*]";
							  printSeat();
						break;
				}
			}
		}
		
	}
	//좌석모양만들기
	private void makeSeat() {
		for(int i=0 ; i<c ; i++) {
			for(int j=0 ; j<r ; j++) {
				seat[i][j] = "[ ]";
			}
		}
	}
	//좌석출력
	private void printSeat() {
		for(int i=0 ; i<c ; i++) {
			for(int j=0 ; j<r ; j++) {
				System.out.print(seat[i][j]);
			}System.out.println();
		}
	}	
}
