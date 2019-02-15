package kr.or.bit;

import java.util.Scanner;

public class Theater {
	private Scanner scanner;
	private String[][] seat;
	private int c, r; 	// �¼� �Ը�
	private int column; // ��
	private int row; 	// ��
	private int number; // �޴���ȣ
	private int person; // ���

	// member field �ʱ�ȭ
	public Theater() {
		scanner = new Scanner(System.in);
		c = 10; // 5��
		r = 10; // 5��
		seat = new String[c][r];
	}

	public void mainMenu() {
		makeSeat(); // �¼� ����
		escape: while (true) {
			switch (menuNumber()) {
			case 1:
				selectSeat();
				break;
			case 2:
				printSeat();
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				break escape;
			default:
				System.out.println("����! �ٽ� �Է����ּ���!");
				break;
			}
		}
	}

	// �޴� ��ȣ ��ȯ
	private int menuNumber() {
		System.out.println("**��ȣ�� �Է��ϼ���**");
		System.out.println("1. ��ȭ�����ϱ�");
		System.out.println("2. �¼�������Ȳ");
		System.out.println("3. �����ϱ�");
		System.out.println("******************");
		System.out.print(">");
		number = scanner.nextInt();
		return number;
	}

	// �¼�����
	private void selectSeat() {
		System.out.println("�����Ͻ� �ο��� �����ϼ���.");
		System.out.print(">");
		person = scanner.nextInt();
		printSeat();

		for (int i = 0; i < person; i++) {
			System.out.println("������ �¼��� �����ϼ���.");
			System.out.print("�� : ");
			column = scanner.nextInt();
			System.out.print("�� : ");
			row = scanner.nextInt();

			if (column < 1 || column >= c || row < 1 || row >= r) {
				System.out.println("����! �ٽ� �Է����ּ���!");
			} else {
				switch (seat[column][row]) {
				case "[*]":
					System.out.println("�̹� ����� �ڼ��Դϴ�.");
					i--;
					break;
				default:
					seat[column][row] = "[*]";
					printSeat();
					System.out.println((i + 1) + "�� ����Ϸ�!" + "(" + (i + 1) + "/" + person + ")");
					break;
				}
			}
		}

	}

	// �¼���縸���
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

	// �¼����
	private void printSeat() {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(seat[i][j]);
			}
			System.out.println();
		}
	}
}
