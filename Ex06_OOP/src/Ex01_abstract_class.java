/*
추상 클래스 (설계 입장...)
미완성 설계도
미완성 클래스(완성된 코드 + 미완성 코드)
--미완성 코드 : 미완성 함수 ( 함수가 {실행 블럭}을 가지고 있지 않다 )
--EX) public void print();   >>  {}  없어요
미완성 클래스 : new 통해서 객체 생성이 불가능(미완성) ...

 1. 추상클래스는 스스로 객체 생성 불가
 2. 추상클래스는 결국 완성된 클래스로 만들어서 사용 -> 상속을 통해서...
	미완성 자원(추상 함수)을 완성 해라(구현) -> 재정의 -> override

why : 추상클래스를 왜 만들었을까?
	: 강제적 구현을 목적(추상함수) (설계자의 입장에서)
	
*/

abstract class Abclass {
	int pos;

	void run() {
		pos++;
		System.out.println("pos : "+ pos);
	}
	// 위 코드는 완성된 코드 입니다.

	// 추상함수(추상자원)
	abstract void stop(); // {}실행블럭이 없어요
}

class Child extends Abclass {

	@Override
	void stop() { // stop 이라는 함수를 재정의
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}

}

public class Ex01_abstract_class {

	public static void main(String[] args) {
		// Abclass ab = new Abclass(); 불가
		Child ch = new Child();
		ch.run();
		ch.stop();
		
		Abclass ab = ch;
		ab.run();
		ab.run();
		ab.stop(); //재정의가 된 자식쪽에 잇는 stop 함수 호출
		
	}

}
