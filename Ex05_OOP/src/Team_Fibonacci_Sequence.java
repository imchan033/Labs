
public class Team_Fibonacci_Sequence {

	public static void main(String[] args) {
		/*
		 1+1+2+3+5+8+13+ ... 의 순서로 나열되는 피보나치 수열의 10번째 항까지의 합계
		 */
		int A = 1; //두 개의 항 합산 시 첫 번째 항 변수
		int B = 1; //두 개의 항 합산 시 두 번째 항 변수
		int C = 0; //두 개의 항 합산 시 기억 변수
		int Y = 2; //합을 저장하는 변수
		int N = 2; //계산하려는 항의 수 변수
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
