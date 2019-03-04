import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 Map 인터페이스를 구현하는 클래스
 Map >> (키(key), 값(value)) 쌍배열
 ex) 지역번호 : (02, 서울) ...
 key 값 : 중복(x)
 value : 중복(o)
 
 Map >> Generic 지원
 
 HashTable(구버전) : 동기화 보장
 HashMap(신버전) : 동기화를 강제 하지 않아요(필요하면 동기화 가능)
 */
public class Ex12_Map_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		//활용 : 회원ID, 회원 PWD 담는다(memory)에
		//메모리(heap) >> 종료 보존(파일기반) login.txt 관리 문제 >> RDBMS (관계형DB)
		
		System.out.println(map.containsKey("Tiger")); //"Tiger" 가지고있니? true ex)아이디중복체크
		System.out.println(map.containsValue("1004"));//true
		
		//(key, value)
		//POINT : key 값을 가지고 value 값을 찾는 것
		System.out.println(map.get("Tiger")); //ex)아이디로 비밀번호 찾기
		System.out.println(map.get("hong"));  //null >> hong라는 key 값을 가지고 있지 않다
		
//		put
//		map.put("Tiger", "1004");
//		map.put("scott", "1004");
//		map.put("superman", "1007");
		map.put("Tiger", "1008"); //key가 같은 경우 value : overwrite 덮어쓴다
		System.out.println(map.get("Tiger"));
		System.out.println("before : "+ map.size());
		Object returnvalue = map.remove("superman"); //key 삭제
		System.out.println(returnvalue); //value 값 return 해줄게 필요하다면 써
		System.out.println("after : "+ map.size());
		
		Set set = map.keySet(); //이해
		// Set 인터페이스를 구현하는 객체(HashSet)를 내부적으로 new 하고 거기에다가 key값을 담고
		//그 주소값을 리턴한다...다형성 적용 >> keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Quiz Map 에서 value 값들을 모아서 출력하세요
		//map.values()...
		Collection vlist = map.values();
		System.out.println(vlist);
		System.out.println(map.values());
		
		
		
	}
}
