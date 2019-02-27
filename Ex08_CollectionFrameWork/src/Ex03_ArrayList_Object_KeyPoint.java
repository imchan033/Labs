import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoint {
	public static void main(String[] args) {
		
		//1. 사원 1명의 정보를 담으세요
		Emp e = new Emp(100,"김유신","군인");
		System.out.println(e.toString());
		
		//2. 사원 2명을 만드세요
		Emp[] emplist = {new Emp(10,"김씨","IT"),new Emp(20,"박씨","sales")};
		for(Emp emp : emplist) {
			System.out.println(emp.toString());
		}
		
		//실수 했어요 한명이 입사를 더 했어요...
		//위 정적배열에 추가 불가(x) ->새로 new (x)
		
		//동적(ArrayList)
		ArrayList alist = new ArrayList();
		alist.add(new Emp(1,"김씨","IT"));
		alist.add(new Emp(2,"이씨","IT"));
		alist.add(new Emp(3,"박씨","IT"));
		
		System.out.println(alist.toString());
		
		//일반 for 문을 사용해서 사원 정보를 출력하세요
		//down casting*************
		for(int i =0; i<alist.size();i++) {
			//System.out.println(alist.get(i).toString());
			Emp emp = (Emp)alist.get(i); //return Object 자식타입 = (자식타입)부모타입
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		}
		//개선된 for문
		for(Object obj : alist) {
			Emp emp = (Emp)obj;
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		}
		//사실은 ... 위 코드가 불편해요 (Object)
		//generic (현대적인 ... 99%)
		
		ArrayList<Emp> alist2 = new ArrayList<Emp>();
		alist2.add(new Emp(1,"A","IT"));
		alist2.add(new Emp(2,"B","IT"));
		for(Emp obj : alist2) {
			System.out.println(obj.getEmpno()+","+obj.getEname()+","+obj.getJob());
		}
		ArrayList<Emp> alist3 = new ArrayList<Emp>();
		alist3.add(new Emp(1,"A","IT"));
		alist3.add(new Emp(1,"B","IT"));
		for(Emp emp : alist3) {
			System.out.println(emp.getEname()+emp.getEmpno()+emp.getJob());
		}
	}
}
