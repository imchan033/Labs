//연습용 (Ex04_Variable_Scope.java 파일 안에다 class 만듬)

class Variable{ //default 같은 폴더안
	int iv;
	/*
	 1. member field, instance variable
	 2. 목적 : 정보를 담으려고 만든다(상태,고유,참조(부품))
	 3. 특징 : 초기값을 (default) 가지고 있다.
	 		   초기화를 하지 않는다.(생성되는 객체마다 다른 값을 갖는다)
	 4. 생성시점(memory에 로딩되는 시점) : new 라는 연산자를 통해서 heap 객체 만들어지고 나서
	 */
	static int cv;
	/*
	 1. class variable, static variable (스태틱은 [공유자원] 이다)
	 2. 목적 : 정보를 담으려고 만든다 >> [생성되는 모든 객체가 공유하는 자원] >> 객체간 공유자원
	 3. 특징 : 접근방법 >> 클래스이름.static자원(Variable.cv)>>객체가 만들어지지 않아도 접근 가능(Math.random())
	 4. 생성시점 : 프로그램이 실행(java hello) class loader system에 의해서 [클래스 정보]를 읽고 (class area = method area)에 올리고 나서
	 			 올려진 클래스안에 static 자원을 가지고 있다면 static 자원도 같이 memory road 합니다
	 			 >> static 은 객체 생성 이전에 memory에 올라가는 자원
	 */
	void method() {
		int lv=0;
		//local variable(지역변수)
		//특징 : 지역변수는 사용하기 전 반드시 초기화
		//생성시점 : 함수가 호출되면 만들어지고 함수가 끝나면 소멸 (stack) 영역
	}
}

public class Ex04_Variable_Scope {

	public static void main(String[] args) {
		/*
		Variable.cv = 100; // static 변수(공유)
		System.out.println("Variable.cv : "+Variable.cv);
		
		Variable v = new Variable();
		v.iv = 200;
		v.cv = 500;
		System.out.println("Varable.cv : "+ Variable.cv);
		*/
		System.out.println("Varable.cv : "+ Variable.cv);
		//객체간 공유자원
		Variable v = new Variable();
		System.out.println(v.cv);
		
		Variable v2 = new Variable();
		System.out.println(v2.cv);
	}

}
