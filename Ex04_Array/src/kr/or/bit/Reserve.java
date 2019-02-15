package kr.or.bit;

import java.util.Scanner;

public class Reserve {
	int[][] showseat = new int[6][6];
	int num;
	Scanner sc = new Scanner(System.in);

	public void selectMenu() {
		System.out.println("------�¼� ���� ���α׷�--------");
		System.out.println("1.�¼��� �����մϴ�.");
		System.out.println("2.���α׷��� �����մϴ�.");

		num = Integer.parseInt(sc.nextLine());

		switch (num) {
		case 1:
			reserveMethod();
			selectMenu();
			break;
		case 2:
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			selectMenu();
		}
	}

	public void reserveMethod() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < showseat.length; i++) {
			for (int j = 0; j < showseat[i].length; j++) {
				if (showseat[i][j] == -1) {
					System.out.printf(" [%s]\t", "����");
					sum++;
				} else {
					sum++;
					showseat[i][j] = sum;
					System.out.printf(" [%d] \t", showseat[i][j]);
				}
			      
			}
			System.out.println();
		}
		System.out.println("���Ͻô� �¼��� �����ϼ���: ");
		do {

			num = Integer.parseInt(sc.nextLine());
			while (num > sum) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ��Է��ϼ���");
				num = Integer.parseInt(sc.nextLine());
			}
			cnt = 0;
			a: for (int i = 0; i < showseat.length; i++) {
				for (int j = 0; j < showseat[i].length; j++) {
					if (showseat[i][j] == num) {
						System.out.printf("%d �� �¼��� ���ŵǾ����ϴ�.\n", num);
						showseat[i][j] = -1;
						break a;
					}
				}
				cnt++;
				if (cnt == showseat.length) {
					System.out.println("�����Ͻ� �¼��� �̹� ���Ű� �Ϸ�Ǿ����ϴ�.");
					System.out.println("���ϴ� �¼��� �ٽ� �Է����ּ���");
				}
			}
		} while (cnt == showseat.length);
	}
}