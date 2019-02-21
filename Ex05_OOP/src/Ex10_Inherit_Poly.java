//다형성(상속관계에서)
//다형성 : 여러가지 성질(형태)를 가질 수 있는 능력
//TIP) C# 다형성안에 overloading, override 포함

//JAVA : [상속관계]에서 하나의 [참조변수]가 여러개의 타입을 가질 수 있다
//여기서 말하는 [참조변수]는 [부모타입]을 이야기 한다
//조상클래스 타입의 참조변수로 여러개의 자식클래스 객체의 주소를 가질 수 있다

//java : 자식은 부모에게 조건없이 드린다(현실세계와 반대?)

class Tv2{//부모(일반화, 추상화) 공통자원
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUP() {
		ch++;
	}
	
	void chDown() {
		ch--;
	}
}

class CapTv extends Tv2{ //자기만의 고유한 기능(구체화, 특수화, ...)
	String text;
	String caption() {
		return this.text = "현재 자막 처리 중입니다...";
	}
}
public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		CapTv tv = new CapTv();
		tv.power();
		System.out.println("전원 정보 : "+ tv.power);
		tv.chUP();
		System.out.println("채널 정보 : "+ tv.ch);
		System.out.println(tv.caption());
		//여기까지가 현재 까지 학습
		
		//Tv2 tv2 = new Tv2();
		//heap 메모리에 Tv2 타입 객체가 로드 되어 있다
		
		//Tv2 tv2 = new Tv2();  이미 memory에 있는데 굳이 생성할 필요x
		
		Tv2 tv2 = tv; //자식타입의 주소를 부모타입에게..조건없이
		//부모것만 접근 가능합니다
		
		System.out.println(tv.toString());
		System.out.println(tv2.toString());
		
		//tv2.ch
		
		
		
		

	}

}
