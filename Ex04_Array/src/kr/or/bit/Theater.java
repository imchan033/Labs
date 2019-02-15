package kr.or.bit;

import java.util.Scanner;

public class Theater {
	private Scanner scanner;
	private String[][] seat;
	private int c, r; 	// 좌석 규모
	private int column; // 행
	private int row; 	// 열
	private int number; // 메뉴번호
	private int person; // 명수

	// member field 초기화
	public Theater() {
		scanner = new Scanner(System.in);
		c = 10; // 5행
		r = 10; // 5열
		seat = new String[c][r];
	}

	public void mainMenu() {
		makeSeat(); // 좌석 생성
		escape: while (true) {
			switch (menuNumber()) {
			case 1:
				selectSeat();
				break;
			case 2:
				printSeat();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break escape;
			default:
				System.out.println("오류! 다시 입력해주세요!");
				break;
			}
		}
	}

	// 메뉴 번호 반환
	private int menuNumber() {
		System.out.println("**번호를 입력하세요**");
		System.out.println("1. 영화예매하기");
		System.out.println("2. 좌석예매현황");
		System.out.println("3. 종료하기");
		System.out.println("******************");
		System.out.print(">");
		number = scanner.nextInt();
		return number;
	}

	// 좌석선택
	private void selectSeat() {
		System.out.println("예약하실 인원을 선택하세요.");
		System.out.print(">");
		person = scanner.nextInt();
		printSeat();

		for (int i = 0; i < person; i++) {
			System.out.println("예약할 좌석을 선택하세요.");
			System.out.print("행 : ");
			column = scanner.nextInt();
			System.out.print("열 : ");
			row = scanner.nextInt();

			if (column < 1 || column >= c || row < 1 || row >= r) {
				System.out.println("오류! 다시 입력해주세요!");
			} else {
				switch (seat[column][row]) {
				case "[*]":
					System.out.println("이미 예약된 자석입니다.");
					i--;
					break;
				default:
					seat[column][row] = "[*]";
					printSeat();
					System.out.println((i + 1) + "명 예약완료!" + "(" + (i + 1) + "/" + person + ")");
					break;
				}
			}
		}

	}

	// 좌석모양만들기
	private void makeSeat() {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (i == 0) {
					seat[0][j] = " " + j + " ";
				} else if (j == 0) {
					seat[i][0] = " " + i + " ";
				} else {
					seat[i][j] = "[ ]";
				}
			}
		}
	}

	// 좌석출력
	private void printSeat() {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(seat[i][j]);
			}
			System.out.println();
		}
	}
}
