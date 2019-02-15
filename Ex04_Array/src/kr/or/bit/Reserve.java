package kr.or.bit;

import java.util.Scanner;

public class Reserve {
	int[][] showseat = new int[6][6];
	int num;
	Scanner sc = new Scanner(System.in);

	public void selectMenu() {
		System.out.println("------좌석 예매 프로그램--------");
		System.out.println("1.좌석을 예매합니다.");
		System.out.println("2.프로그램을 종료합니다.");

		num = Integer.parseInt(sc.nextLine());

		switch (num) {
		case 1:
			reserveMethod();
			selectMenu();
			break;
		case 2:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			selectMenu();
		}
	}

	public void reserveMethod() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < showseat.length; i++) {
			for (int j = 0; j < showseat[i].length; j++) {
				if (showseat[i][j] == -1) {
					System.out.printf(" [%s]\t", "매진");
					sum++;
				} else {
					sum++;
					showseat[i][j] = sum;
					System.out.printf(" [%d] \t", showseat[i][j]);
				}
			      
			}
			System.out.println();
		}
		System.out.println("원하시는 좌석을 선택하세요: ");
		do {

			num = Integer.parseInt(sc.nextLine());
			while (num > sum) {
				System.out.println("잘못 입력하였습니다. 다시입력하세요");
				num = Integer.parseInt(sc.nextLine());
			}
			cnt = 0;
			a: for (int i = 0; i < showseat.length; i++) {
				for (int j = 0; j < showseat[i].length; j++) {
					if (showseat[i][j] == num) {
						System.out.printf("%d 번 좌석이 예매되었습니다.\n", num);
						showseat[i][j] = -1;
						break a;
					}
				}
				cnt++;
				if (cnt == showseat.length) {
					System.out.println("선택하신 좌석은 이미 예매가 완료되었습니다.");
					System.out.println("원하는 좌석을 다시 입력해주세요");
				}
			}
		} while (cnt == showseat.length);
	}
}