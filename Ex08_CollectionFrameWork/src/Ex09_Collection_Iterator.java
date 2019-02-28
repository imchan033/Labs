import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//Collection Framework
//나열된 자원에 대해 [순차적]으로 접근해서 [값]을 리턴하는 표준 정의
//Iteratior 인터페이스 설계

//예를 들어 A클래스 Iterator 구현
//		  B클래스 Iterator 구현
//내가 보장받는 것은 : hasNext() 구현되어 있다, Next() 구현되어 있다

//ArrayList >> Iterator를 구현하고 있다
//for 문을 쓰면 안돼요...? 써도 돼요
//우리가 원하는 것은 표준화된 접근

//Iterator : 순방향 데이터 read 표준
//ListIterator : 양방향 데이터 read 표준

public class Ex09_Collection_Iterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		for(int i = 0; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		//표준화된 인터페이스를 사용해서 출력한다면
		//Iterator
		//Collectrion { Iterator iterator() }//추상자원
		//List extends Collection
		//ArrayList implements List
		//ArrayList >> iterator() 함수의 { 실행블럭구현}
		//Iterator (부모 타입) 접근 ...
		
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//generic
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(44);
		intlist.add(77);
		intlist.add(99);
		
		Iterator<Integer> list2 = intlist.iterator();
		while(list2.hasNext()) {
			System.out.println(list2.next());
		}
		
		//역방향
		for(int i = intlist.size()-1 ; i>=0 ; i--) {
			System.out.println(intlist.get(i));
		}
		
		//ListIterator (순방향, 역방향)
		//역방향 조회시 순방향이 선행 되어야 한다
		ListIterator<Integer> li2 = intlist.listIterator();
		while(li2.hasNext()) {
			System.out.println(li2.next());
		}
		
		//역방향
		while(li2.hasPrevious()) {
			System.out.println(li2.previous());
		}
		
	}
}
