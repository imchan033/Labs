class Parent{
	int x = 100;
	void pmethod() {
		System.out.println("parent method");
	}
}

class Child3 extends Parent{
	int y = 200;
	
	int x = 2000; //c# 재정의 : 변수 무시하기
	
	void parent_x() {
		System.out.println(super.x);
	}
	
	@Override
	void pmethod() {
		System.out.println("부모 함수 재정의");
	}
	
	void parent_method() {
		super.pmethod();
	}
}
public class Ex14_Inherit_Override {

	public static void main(String[] args) {
		Child3 ch = new Child3();
		Parent pa = ch; //다형성
		//pa.y 접근 x ...자식꺼니까
		System.out.println("ch.x : "+ch.x);
		ch.parent_x();
		ch.pmethod();
		pa.pmethod(); //Override 재정의된 자원
		ch.parent_method();
	}

}
