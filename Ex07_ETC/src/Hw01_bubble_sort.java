import java.util.Scanner;

public class Hw01_bubble_sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[5]; //정렬할 숫자가 저장될 배열
		//i 회전수를 계산하는 변수
		//j 배열의 첨자 등을 위한 변수
		int temp; //자료 교환에 필요한 임시 변수
		
		//성적 입력 받기
		System.out.println("5명 학생 성적 입력");
		for(int i=0 ; i<A.length ; i++) {
			A[i] = sc.nextInt();
		}
		
		//버블정렬
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4-i ; j++) {
				if(A[j]>A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		
		//출력
		for(int i=0 ; i<A.length ; i++) {
			System.out.print(A[i]+"\t");
		}
		
		
	}

}
