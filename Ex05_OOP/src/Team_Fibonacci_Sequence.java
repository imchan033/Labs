
public class Team_Fibonacci_Sequence {

	public static void main(String[] args) {
		/*
		 1+1+2+3+5+8+13+ ... 의 순서로 나열되는 피보나치 수열의 10번째 항까지의 합계
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
