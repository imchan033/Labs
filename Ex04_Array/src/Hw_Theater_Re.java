/*
��ȭ�� ���� ���� (�����ϰ� ����� ������)

2���� �迭�� Ȱ���Ͽ� ��ȭ�� �¼��� ����ð� �¼��� �����ϰ� ������ �¼� ǥ�õǰ� ���
*/
import java.util.*;

public class Hw_Theater_Re {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[][] seat = new String[5][5];
		int column = 0;
		int row = 0;
		
		System.out.println("��ȭ�� ���� ����");
		//�¼���縸���
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				seat[i][j] = "[ ]";
			}
		}
		
		//�¼����
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				System.out.print(seat[i][j]);
			}System.out.println();
		}
		
		
		while(true) {
			System.out.println("�¼��� �����ϼ���!");
			System.out.print("�� : ");
			column = scanner.nextInt();
			System.out.print("�� : ");
			row = scanner.nextInt();
			
			
			switch(seat[column][row]) {
			case "[*]" : System.out.println("�̹� ����� �ڼ��Դϴ�.");
				break;
			default : seat[column][row] = "[*]";
				break;
			}
			//�¼� ���
			for(int i=0 ; i<5 ; i++) {
				for(int j=0 ; j<5 ; j++) {
					System.out.print(seat[i][j]);
				}System.out.println();
			
		}
		
	}

	}
}
