import java.util.Scanner;

public class Hw01_bubble_sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[5]; //������ ���ڰ� ����� �迭
		//i ȸ������ ����ϴ� ����
		//j �迭�� ÷�� ���� ���� ����
		int temp; //�ڷ� ��ȯ�� �ʿ��� �ӽ� ����
		
		//���� �Է� �ޱ�
		System.out.println("5�� �л� ���� �Է�");
		for(int i=0 ; i<A.length ; i++) {
			A[i] = sc.nextInt();
		}
		
		//��������
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4-i ; j++) {
				if(A[j]>A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		//���
		for(int i=0 ; i<A.length ; i++) {
			System.out.print(A[i]+"\t");
		}
		
		
	}

}
