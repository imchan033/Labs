/*
 클래스 == 설계도 == 타입 이다
 클래스의 기본 구성요소 : 필드(고유값, 상태값, 참조값) + 함수(기능)
 접근자(한정자) : public, private, default(쓰지 않는것), protected(상속)
 
 1. public class Test{}
 
 2. class Test{} >> default 접근자가 사용되었다(생략)
 (default 접근자 : 같은 폴더 안에 공유가능, 다른 폴더에 있으면 사용불가)
 
 3. default class 는 언제 사용 : 같은 폴더내에서 다른 클래스의 참조 목적
								or  연습목적으로 ( 거의 안씀 )

 4. 하나의 자바 파일은(a.java) 여러개의 클래스를 가질 수 있다
    >>Ex01_main.java
    >>class Test{  } 코딩 연습 ... 실제로는 ... 쓰면 안돼요
 	>>단, public 키워드는 클래스 하나만 (자신)
 **정리**
 default : 같은 폴더 내에서 사용시 
 
 
 
 
 */
import kr.or.bit.Apt;

class Test{ 		//default class Test{}	사실 이렇게 안씀 (연습)  
	int i;  		//default int i;
	
	void print() {  //default void print()
		System.out.println("default");
	}
}

public class Ex01_main {

	public static void main(String[] args) {
		Person p = new Person();
		p.name="연습";
		
		//kr.or.bit 폴더 안에 있는 Car 클래스 사용
		//kr.or.bit.Apt apt = new kr.or.bit.Apt(); ->import 사용
		Apt apt = new Apt();
		apt.aptname = "현대";
		
		apt.write_window(
				0);
		System.out.println(apt.read_window());
		
		Test t = new Test();
		t.i = 100;
		
	}

}
