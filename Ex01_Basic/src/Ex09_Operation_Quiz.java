import java.util.*;

public class Ex09_Operation_Quiz {

	public static void main(String[] args) {
		/*
		String str = "+";
		if(str.equals("+")) {
			System.out.println(str);
		}
		 문자열의 비교는 == 이 아니고 equals() 를 사용한다
		*/
		int number1,number2=0;
		int result=0;
		String cal = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">입력값:");
		number1 = Integer.parseInt(sc.nextLine());  //sc.nextLine()
		System.out.println(">입력값(기호):");
		cal = sc.nextLine();
		System.out.println(">입력값:");
		number2 = Integer.parseInt(sc.nextLine());
		
		if(cal.equals("+")) {
			result = number1 + number2;
			
		}else if(cal.equals("-")) {
			result = number1 - number2;
			
		}else if(cal.equals("*")) {
			result = number1 * number2;
			
		}else if(cal.equals("/")) {
			result = number1 / number2;
			
		}else {
			System.out.println("기호를 잘못 입력 했습니다.");
			//System.exit(0);
			//key point (여기서는 main 함수)
			//return 키워드 : [함수단위]의 종결자 > main 함수 탈출 > 종료
			return;
		}System.out.printf(">결과값: %d %s %d = %d",number1,cal,number2,result);
	}

}
