import java.util.StringTokenizer;

//String 클래스 (다양한 함수)
//개발에서 많이 사용 (우리가 사용한 데이터는 대부분 문자열 데이터)



public class Ex06_String_Function {

	public static void main(String[] args) {
		String str = ""; //문자열 초기화
		
		String[] strarr = {"aaa" , "bbb", "ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
		//String 클래스 (함수)
		String ss = "hello";
		String concatstr = ss.concat(" world!");
		System.out.println(concatstr);
		
		boolean bo = ss.contains("el");
		System.out.println(bo);
		
		String ss2 = "a b c d";//[a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());
		
		String filename = "hello java, world";
		System.out.println(filename.indexOf(","));
		System.out.println(filename.indexOf("java")); //시작 위치 index
		
		//활용 : 문장내에서 내가 원하는 단어가 포함 되어있는지를  검증
		//0보다 큰값...최소한 하나의 단어 포함
		System.out.println(filename.lastIndexOf("a"));
		System.out.println(filename.lastIndexOf("kglim"));
		//배열에 값이 없다 >> -1
		//return -1;
		
		//주로 많이 쓰는 함수
		//length(), indexof(), substring(), replace(), ...split()
		String result = "superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(4));
		System.out.println(result.substring(1, 3)); //index endIndex - 1
		
		//Quiz
		String filename2 = "홍길동.jpg"; //파일명은 바꾸어 질 수 있다
		//aaaa.mpeg or ab.hwp
		//파일명 >> 홍길동
		//확장자 >> 확장자
		//분리해서 화면에 출력해보세요
		System.out.println(filename2.substring(0,filename2.lastIndexOf(".")));
		System.out.println(filename2.substring(filename2.lastIndexOf(".")+1));
		
		//replace
		String s2 = "ABCD";
		String result4 = s2.replace("A","안녕");
		System.out.println(result4);
		
		System.out.println(s2.charAt(1));
		System.out.println(s2.endsWith("BCD"));
		System.out.println(s2.equalsIgnoreCase("aBcD"));
		
		//POINT
		//split
		String s6 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = s6.split(",");
		for(String s : namearray) {
			System.out.println(s);
		}
		
		String filename3 = "bit.hwp";
		String[] array = filename3.split("\\."); //정규 표현 문자열은 \\ 붙이기
		System.out.println(array.length);
		for(String s : array) {
			System.out.println(s);
		}
		//java, javascript, DB >> 정규 표현식
		//000-{\d4}-0000
		//000-1111-0000 제공 : true
		//000-11-0000 제공 : false
		
		//과제(정규표현식 5개 만들어 오기) 조별당
		//주로 많이쓰이는 것
		//주민번호, 우편번호, 전화번호, 이메일, ...
		//추후 과제 다음주 월..
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7, "/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스 quiz
		String s8 ="홍             길          동";
		//저장"홍길동" 공백제거 저장
		System.out.println(s8.replace(" ", "")); // " "공백을 "" 로
		
		String s9 = "         홍길동        ";
		System.out.println(s9);
		System.out.println(s9.trim()); //양쪽 공백 제거
		
		String s10 = "  홍  길  동  ";
		//홍길동
		
		//바보..
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2);
		
		//여러개의 함수를 적용할 경우(method chain)
		//*****************************************
		System.out.println(s10.trim().replace(" ",""));
		
		//Quiz-1
		int sum=0;
		String[] numarr = {"1","2","3","4","5"};
		//문제 : 배열에 있는 문자값들의 합을 sum 변수에 담아서 출력하세요
		
		for(String s : numarr) {
			sum += Integer.parseInt(s) ;
		}
		System.out.println(sum);
		
		//Quiz-2
		String jumin = "123456-1234567";
		sum=0;
		//위 주민번호의 합을 구하세요
		String juminnum = jumin.replace("-", "");
		for(int i=0; i<13 ; i++) {
			sum += Integer.parseInt(juminnum.substring(i,i+1));
		}
		System.out.println(sum);
		
		
		
	}

}





