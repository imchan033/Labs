
public class Team_Fibonacci_Sequence {

	public static void main(String[] args) {
		/*
		 1+1+2+3+5+8+13+ ... �� ������ �����Ǵ� �Ǻ���ġ ������ 10��° �ױ����� �հ�
		 */
		int A = 1; //�� ���� �� �ջ� �� ù ��° �� ����
		int B = 1; //�� ���� �� �ջ� �� �� ��° �� ����
		int C = 0; //�� ���� �� �ջ� �� ��� ����
		int Y = 2; //���� �����ϴ� ����
		int N = 2; //����Ϸ��� ���� �� ����
		do {
			C = A + B;
			Y += C;
			N += 1;
			A = B;
			B = C;
		}while(N<10);
		System.out.println(Y);
	}

}
