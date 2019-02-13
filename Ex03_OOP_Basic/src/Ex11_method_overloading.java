/* 트랜잭션이란? 시작-끝 작업단위
객체 지향 언어 특징
상속, 캡슐화, 다형성...

캡슐화(은닉화) -> private

[method overloading]
***[하나의 이름]으로 [여러가지 기능]을 하는 함수***
사용 : System.out.println() 대표적인 예
특징 : 오버로딩 성능향상에 도움을 주지 않는다
		why) 편하게 사용하려고 >> 개발자 (함수를 여러개 만들지 않아도 된다)
		설계시 어떤 점을 고려 : 함수의 활용이 많은 경우
		
문법 : 함수의 이름은 같고 parameter 의 개수와 타입을 달리하는 방법
1. 함수의 이름은 같아야 한다
2. [parameter] 개수 또는 [Type]은 달라야 한다
3. return Type overloading 판단기준이 아니다
4. parameter 순서가 다름을 인정 한다
 */
class Human{
	String name;
	int age;
}

class OverTest{
	
	void add(Human h) {
		h.name = "홍길동";
		h.age = 100;
		System.out.println(h);
	}

	int add(int i) {
		return 100 + i;
	}
	
	int add(int i,int j) {
		return i + j;
	}
	
	String add(String s) {
		return "hello" + s;
	}
	
	//void add(int k){} 안되요 (parameter type 충돌)
	
	void add(int i, String s) {
		System.out.println("오버로딩 인정");
	}
	
	void add(String s, int i) {
		System.out.println("오버로딩 인정");//parameter의 순서가 다름을 인정합니다
	}
	
}

public class Ex11_method_overloading {

	public static void main(String[] args) {
		System.out.println(100);
		System.out.println("hello");
		
		OverTest ot = new OverTest();
		System.out.println(ot.add(10));
		System.out.println(ot.add("~!"));
		//ot.add(3.1f) X
		ot.add(1, null);
		
		Human h = new Human();
		ot.add(h);
		System.out.println(h.name);
		System.out.println(h.age);
	
		ot.add(new Human());
	
	
	}

}
