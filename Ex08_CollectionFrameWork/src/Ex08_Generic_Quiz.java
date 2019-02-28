import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		//1. Emp 클래스를 사용해서 사원 3명을 생성하세요
		//단 ArrayList 제너릭을 사용하세요
		List<Emp> empInfo = new ArrayList<Emp>();
		empInfo.add(new Emp(111,"김","IT"));
		empInfo.add(new Emp(222,"이","IT"));
		empInfo.add(new Emp(333,"박","IT"));
		
		//2. 3명의 사원 정보(사번,이름,직종)를 개선된for 문을 사용해서 출력하세요
		//단 toString() 사용 금지
		for(Emp emp : empInfo) {
			System.out.println(emp.getEmpno()+","+emp.getEname()+","+emp.getJob());
		}
		
		//3. 3명의 사원 정보(사번,이름,직종)를 일반for 문을 사용해서 출력하세요
		//단 toString() 사용 금지
		for(int i=0 ; i<empInfo.size() ; i++) {
			System.out.println(empInfo.get(i).getEmpno()+","+empInfo.get(i).getEname()+","+empInfo.get(i).getJob());
		}
		
		//4. CopyEmp 라는 클래스를 만드세요 (구조는 Emp 와 같은데)
		//job member field 대신에 (삭제)
		//private int sal 추가하고 (getter, setter 구현)
		//ArrayList 제너릭 사용해서 사원 3명 만드세요
		//아래 데이터
		//100 , "김" , 1000
		//200 , "이" , 2000
		//300 , "박" , 3000
		List<CopyEmp> empInfo2 = new ArrayList<CopyEmp>();
		empInfo2.add(new CopyEmp(100,"김",1000));
		empInfo2.add(new CopyEmp(200,"이",2000));
		empInfo2.add(new CopyEmp(300,"박",3000));
		
		//5. 200번 사원의 급여를 5000으로 수정해서 출력하세요 (일반 for문 사용하세요)
		for(int i=0; i<empInfo2.size() ; i++) {
			if(empInfo2.get(i).getEmpno()==200) {
				empInfo2.get(i).setSal(5000);
			}
			System.out.println(empInfo2.get(i).getEmpno()+","+empInfo2.get(i).getEname()+","+empInfo2.get(i).getSal());
		}
		
		//6. 300번 사원의 이름을 "궁금해" 로 수정해서 출력하세요(개선된 for문 안에서...)
		for(CopyEmp emp : empInfo2) {
			if(emp.getEmpno()==300) {
				emp.setEname("궁금해");
			}
			System.out.println(emp.getEmpno()+","+emp.getEname()+","+emp.getSal());
		}
		
		//7.사원정보를 Iterator 인터페이스를 사용해서 출력하세요 
		 System.out.println("**********************************");
		 Iterator<CopyEmp> it = empInfo2.iterator();
		 while(it.hasNext()) {
			CopyEmp e = it.next();
			System.out.println(e.getEmpno() +","+e.getEname()+","+e.getSal());
		 }
		
	}
}
