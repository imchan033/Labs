import java.util.*;

public class Ex10_Statement {

	public static void main(String[] args) {
		/*
		 * 제어문 조건문(분기문) : if(단일,else,else if - 세가지 종류), switch() (case break default)
		 * 반복문 : for(반복횟수가 명확), while(조건이 일치하면 반복), do~while() 강제실행 break(블럭{} 탈출),
		 * continue(아래 구문 skip)
		 */
		int count = 0; // local variable(초기화 필수)
		if (count < 1) {// 단일 if
			System.out.println("TRUE 입니다");
		}

		if (count < 1)
			System.out.println("TRUE 입니다"); // 중괄호블럭 없이 가능

		char data = 'A';
		switch (data) {// 조건값으로 : [숫자], [char], [String] 가능
			case 'A':
				System.out.println("문자비교 가능");
			break;
			default:
			System.out.println("default");
		}

		// 반복문
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum += i;
		}System.out.println("1~10 까지의 합 : " + sum);

		// for 문을 사용해서 1~10까지 홀수의 합을 구해 보세요
		// for 문 외에 다른 제어구문은 사용하지 마세요
		int sum1 = 0;
		for (int i = 1; i <= 10; i += 2) { // i=i+2
			sum1 += i;
		}System.out.println("1~10까지 홀수의 합 : " + sum1);

		// 1~100까지 짝수의합
		int sum2 = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 += i;
			}
		}System.out.println("1~100까지 짝수의합 : " + sum2);

		//입사시험 대표적인 문제(구구단) : 변형
		//for문 (중첩) >> 행과열
		//
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		System.out.println();
		
		for(int i=1 ; i<=9 ; i++) {
			for(int j=2 ; j<=9 ; j++) {
				System.out.printf("[%d]*[%d]=[%d]\t",j,i,i*j );
			}System.out.println();
		}
		System.out.println();
		
		//KEY POINT (break(탈출), continue(스킵))
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				if(i == j)
					continue; //아래 구문을 skip(그냥 넘어가라)
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		System.out.println();
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				if(i == j)
					break; 
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<i ; j++) { //조건 j<i
				System.out.print("*");
			}System.out.println();
		}
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<i ; j++) { //조건 j<i
				System.out.print("*");
			}System.out.println();
		}
		
		for(int i = 100; i>=0; i--) { //시작값을 큰값으로...
			System.out.println("i : "+i);
		}
		
		//피보나치 정보처리 실기
		System.out.println("피보나치");
		int a = 0;
		int b = 1;
		int c = 0;
		for(int i=0 ; i<=10; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.println(c);
		}
		
		//조별과제 2번 
		//두개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하세요

		int sum3=0;
		for(int i=1 ; i<=6 ; i++) {
			for(int j=1 ; j<=6 ; j++) {
				if(i+j==6) {
					sum3 ++;
				}
			}
		}System.out.println("두개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수는? : "+sum3);
		
		//조별과제 1번
		//1부터 20까지의  정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하는 프로그램을 작성하세요
		
		System.out.println("1부터 20까지의  정수 중에서 2 또는 3의 배수가 아닌 수의 총합은?");
		int sum4 = 0;
		for(int i = 1; i<=20 ; i++) {
			if(i%2 != 0 && i%3 != 0) {
				sum4+=i;
			}
		}System.out.println("정답 : "+sum4);
		
		/*조별과제 3번
			가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)
			예)
			컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요
			( 예를 들면 : 가위=> 1   , 바위 => 2  , 보 => 3)
			바위2 가위1
			보3 바위2
			가위1 보3	 
		*/
		/*
		 * int com; int user;
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("가위(1) : 바위(2) : 보(3)"); System.out.print("사용자 입력 값 : ");
		 * user = sc.nextInt();
		 * 
		 * com = ((((int)(Math.random()*10))%3)+1); System.out.println("com : " + com +
		 * "\n");
		 * 
		 * switch(user) { case 1: System.out.println("user : 가위"); break; case 2:
		 * System.out.println("user : 바위"); break; case 3:
		 * System.out.println("user : 보"); break; default :
		 * System.out.println("값을 잘못 입력하였습니다."); }
		 * 
		 * switch(com) { case 1: System.out.println("com : 가위"); break; case 2:
		 * System.out.println("com : 바위"); break; case 3: System.out.println("com : 보");
		 * break; default : System.out.println("값을 잘못 입력하였습니다."); }
		 * 
		 * 
		 * if(user==com) System.out.println("무승부"); else if(user>com) {
		 * if(user==3&&com==1) System.out.println("컴퓨터 승리"); else
		 * System.out.println("사용자 승리"); } else if(user<com) { if(user==1&&com==3)
		 * System.out.println("사용자 승리"); else System.out.println("컴퓨터 승리"); }
		 */
		
			
	    System.out.println("가위(1), 바위(2), 보(3)");
	    int ply = (int) ((Math.random() * 3) + 1);
	    System.out.println(ply);
	    int com1 = (int) ((Math.random() * 3) + 1);
	    System.out.println(com1);
	    
	    String win = "당신은 이겼습니다.";
	    String lose = "당신은 졌습니다.";
	    String drow = "당신은 비겼습니다";
	    String result = "";
	    
	    if (ply == com1) {
	        result = drow;
	    } else if (ply - com1 == -1 || ply - com1 == 2) {
	        result = lose;
	    } else {
	        result = win;
	    }
	    System.out.println(result);
		
		
	}
		
		
		
}

