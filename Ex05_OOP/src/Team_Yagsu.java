import java.util.*;

public class Team_Yagsu {

	public static void main(String[] args) {
		/*
		���� ������ �Է� �޾� ����� ���� ����ϴ� �������� �ۼ��Ͻÿ�
		ó������
		A(100) : ����� ������ �迭, B : �Է� ������
		C : 1���� B ���� ��, D : ����� ����� �迭�� ��ġ(÷��)
		MOD() �������� ���ϴ� �Լ�
		*/
		int[] A = new int[100];
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ� �Է����ּ���>");
		int B = scanner.nextInt();
		int C = 0;
		int D = 0;
		do{
			C += 1;
			if(B%C==0) {
				A[D]=C;
				D += 1;
			}
		}while(C<=B);
		for(int i=0;i<D;i++) {
			System.out.print(A[i]+"\t");
		}
	}

}
