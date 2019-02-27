import java.util.Vector;

/*
 Collection FrameWork
 [다수의 데이터를 다루는 [표준화]된 [인터페이스]를 [구현]하고 있는 클래스 집합]
 
        Collection
 	        |
 List(상속)   Set(상속)				Map(인터페이스)
     |           |                        |
  Vector       HashSet			      [HashMap]
[ArrayList]    TreeSet

List interface [줄을 서시오]
:순서(0), 중복(0) -> 내부적으로 데이터 관리 -> Array[0][1][2]...

 1. vector(구버전) -> 동기화(멀티 쓰레드) -> Lock 보장 (default) -> 데이터 보호
 2. ArrayList(신버전) -> 동기화(멀티 쓰레드) -> Lock 보장 (x) -> 필요에 따라 lock -> 성능
 ex)동기화
 한강 고수부지 화장실 하나 (100 명이 동시에) >> Lock 안전하게...
 한강 고수부지 비빔밥 축제 (100인분)(100명이 동시에) >> Lock(x) >> 성능
 
 Array (배열) : 정적배열(크기가 고정되어 있다)
 방을 10개 생성하면 고정 변경불가
 int[] arr = new int[10];
 int[] arr = {10,20,30};
 
 Array(고정, 정적)
 1. 배열의 크기가 고정되어있다 : Car[] cars = {new Car(),new Car()};//방 2개 ...
 2. 배열의 접근 : index(첨자) : cars[0], cars[0].color
 3. 초기 설정한 크기 변경 불가
 
 List 인터페이스 구현한 클래스(Vector, ArrayList) : 동적
 1. 배열의 크기를 동적 확장, 축소 가능 -> 배열의 재할당(새로운배열) -> 내가 직접 코딩 하지 않아요
 2. 순서를 유지(Array), 순서(index), 중복값 허용
 3. 데이터 저장 공간 (Array 사용)
 4. List 인터페이스를 구현한 클래스 (new 를 통해서 객체를 생성 사용)
 5. 구현 클래스(ArrayList)가 가지는 데이터 타입 : 방의 타입 : Object
 	Object[] arr = new Object[10]
 	장점 : 모든 타입의 부모 타입 (int, Car, String ...) 모든 자료 삽입 가능
 	단점 : Object를 downCasting 사용
 5번의 단점을 극복하기 위한 방법 제너릭(타입 강제) 통해 문제 해결
 
 
 
 

 */
public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기 default 용량 : "+v.capacity()); //10 default
		v.add("AA"); //[0]
		v.add("BB"); //[1]
		v.add("AA"); //[2]
		v.add(100);  //[3]
		System.out.println(v);			  //[AA, BB, AA, 100] 재정의 결과 출력
		System.out.println(v.toString()); //toString() 생략되어 있다
		
		//Array >> length() >> Car[index]
		for(int i=0 ; i<v.size(); i++) {  //size() 함수 활용
			System.out.println(v.get(i)); //get 함수의 return type : object
		}
		for(Object obj : v) {  			  //개선된 for문
			System.out.println(obj);      //문제 : Object라는 가장 큰 타입을 사용... add(), get()
		}
		
		Vector<String> v2 = new Vector<String>(); //String 타입의 방이 만들어진다
		v2.add("Hello");
		v2.add("World");
		
		for(String str : v2) {
			System.out.println(str);
		}
		
		System.out.println(v2);
		System.out.println(v2.toString());
		System.out.println(v2.get(1));
		System.out.println("size : "+ v2.size());
		System.out.println("Capacity : "+ v2.capacity());
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity()); //10
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println(v3.capacity()); //20
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A"); //10->20->40
		System.out.println("size : "+ v3.size());
		System.out.println("capacity : "+v3.capacity());
		System.out.println(v3);
		
	}

}





















