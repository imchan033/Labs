/*
영화관 예매 관리 (간단하게 만들어 오세요)

2차원 배열을 활용하여 영화관 좌석을 만드시고 좌석을 선택하고 선택한 좌석 표시되고 등등
*/
import java.util.*;

public class Hw_Theater_Re {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[][] seat = new String[5][5];
		int column = 0;
		int row = 0;
		
		System.out.println("영화관 예매 관리");
		//좌석모양만들기
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				seat[i][j] = "[ ]";
			}
		}
		
		//좌석출력
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				System.out.print(seat[i][j]);
			}System.out.println();
		}
		
		
		while(true) {
			System.out.println("좌석을 선택하세요!");
			System.out.print("행 : ");
			column = scanner.nextInt();
			System.out.print("열 : ");
			row = scanner.nextInt();
			
			
			switch(seat[column][row]) {
			case "[*]" : System.out.println("이미 예약된 자석입니다.");
				break;
			default : seat[column][row] = "[*]";
				break;
			}
			//좌석 출력
			for(int i=0 ; i<5 ; i++) {
				for(int j=0 ; j<5 ; j++) {
					System.out.print(seat[i][j]);
				}System.out.println();
			
		}
		
	}

	}
}
