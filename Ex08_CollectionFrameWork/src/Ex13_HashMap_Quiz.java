import java.util.HashMap;
import java.util.Scanner;

/*
	    HashMap 사용한 로그한 시스템

		//회원 로그인 데이터 HashMap 으로 관리
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		//시스템에 로그인 하는 시나리오
		//ID(0) , PWD(0)  >> 회원  (환영)
		//ID(0) , PWD(x)  >> 실패  (비번다시 입력)
		
		//ID(x) , PWD(x)  >> 실패  (다시 입력해)
		//ID(x) , PWD(0)
		
		//Scanner 사용해서  ID, PWD 입력받으세요
		//loginmap 통해서 검증 로직 처리
		//ID 또는  PWD 틀리면 다시 입력 요청
		//ID , PWD 다 맞으면 회원님 방문 환영합니다 ^^ (출력 프로그램 종료)
	    //ID 는 대소문자 구분없이 처리 합니다.
*/
public class Ex13_HashMap_Quiz {

	public static void main(String[] args) {
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디를 입력해주세요 : ");
			String id = sc.nextLine().trim().toLowerCase(); //trim() 앞뒤 공백 제거 , toLowerCase() 소문자로 변환
			if (loginmap.containsKey(id)) {
				while(true) {
					System.out.print("비밀번호를 입력해주세요 : ");
					String pwd = sc.nextLine().trim();
					if (loginmap.get(id).equals(pwd)) {
						System.out.println("환영합니다.");
						System.exit(0);
					} else {
						System.out.println("비밀번호 오류");
					}
				}
			} else {
				System.out.println("아이디를 다시 입력해 주세요");
			}
		}

	}

}
