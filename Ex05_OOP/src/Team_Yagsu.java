import java.util.*;

public class Team_Yagsu {

	public static void main(String[] args) {
		/*
		양의 정수를 입력 받아 약수를 구해 출력하는 순서도를 작성하시오
		처리조건
		A(100) : 약수를 저장할 배열, B : 입력 받은수
		C : 1부터 B 까지 수, D : 약수가 저장될 배열의 위치(첨자)
		MOD() 나머지를 구하는 함수
		*/
		int[] A = new int[100];
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요>");
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
