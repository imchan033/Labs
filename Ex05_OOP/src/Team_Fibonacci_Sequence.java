
public class Team_Fibonacci_Sequence {

	public static void main(String[] args) {
		/*
		 1+1+2+3+5+8+13+ ... �� ������ �����Ǵ� �Ǻ���ġ ������ 10��° �ױ����� �հ�
		 */
		int A = 1;
		int B = 1;
		int C = 0;
		int Y = 2;
		int N = 2;
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
