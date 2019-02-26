import java.util.Scanner;

//main 함수 Scanner  사용 주민번호 입력받고
//앞:6자리 뒷:7자리
//입력값 : 123456-1234567 
//1. 자리수 체크 (기능)함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수
//3개의 함수 static 으로 설계 하세요
public class Ex07_String_Total_Quiz {
	static boolean juminCheck(String str) {
		boolean check;
		if(str.length()==14) {
			check=true;
		}else {
			check=false;
		}
		return check;
	}
	static boolean juminNumberCheck(String str) {
		boolean check;
		int number = Integer.parseInt(str.substring(7, 8));
		if(number>=1 && number<=4) {
			check = true;
		}else {
			check = false;
		}
		return check;
		
	}
	static String juminGender(String str) {
		String gender;
		int number = Integer.parseInt(str.substring(7, 8));
		if(number==1 || number==3) {
			gender = "남자";
		}else {
			gender = "여자";
		}
		return gender;
	}
	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호입력:");
			ssn = sc.nextLine();			
		}while(!juminCheck(ssn)||!juminNumberCheck(ssn));
		
		//출력
		System.out.println(juminGender(ssn));

	}

}
