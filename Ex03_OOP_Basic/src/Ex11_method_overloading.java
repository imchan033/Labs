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
	//배열(Array) 배웠으니
	//초초중급 ...
	//int[] source = {10,20,30,40,50};
	//중요*********************자주나옴
	int[] add(int[] param) { //parameter 로 int 배열의 주소값을 받겠다
		int[] target = new int[param.length];
		for(int i=0; i<param.length ; i++) {
			target[i] = param[i]+1;
		}
		return target; //int 타입의 배열의 주소값을 return
	}
	
	
		//마음대로 코드 작성 (error만 없으면 됩니다.)
	int[] add(int[] so, int[] so2) {
		int[] array=null;
		if (so.length == so2.length) {
			array = new int[so.length];
			for (int i = 0; i < so.length; i++) {
				array[i] = so[i] + so2[i];
			}
		}
		return array;
	}
	
	
	Human[] add(Human[] human) {
		//...
		Human[] h = new Human[human.length];
		//...
		return h;
	}
	
	
	
	
}

public class Ex11_method_overloading {

	public static void main(String[] args) {
		/*
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
		*/
		OverTest ot = new OverTest();
		//int 타입의 배열의 주소를 주어야...
		int[] source = {10,20,30,40,50};
		System.out.println(source);  //source 는 배열의 주소값
		int[] target = ot.add(source); //[I@15db9742 주소값
		for(int i=0 ; i<target.length ; i++) {
			System.out.printf("target[%d] : %d\n",i,target[i]);
		}
		
		//int[] add(int[] so, int[] so2) 실행시 error 없으면 되요
		int[] so = {1,2,3,4,5};
		int[] so2 = {10,20,30,40,50};
		int[] result = ot.add(so, so2);
		System.out.println("두 배열 같은 행끼리의 합");
		for(int i=0 ; i<result.length ; i++) {
			System.out.printf("%d\t",result[i]);
		}
		
	
	}

}
