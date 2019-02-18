import kr.or.bit.Employee;

public class Ex14_Constructor {

	public static void main(String[] args) {
		Employee emp = new Employee();//default
		emp.employeeInfoPrint();
		System.out.println(emp.getName());
		
		Employee emp2 = new Employee(1901, "홍길동", "영업팀");
		emp2.employeeInfoPrint();
		System.out.println(emp2.getName());
		emp2.setJob("개발팀");
		emp2.employeeInfoPrint();
		System.out.println();
		
		//Array 를 사용해서 사원 3명을 만들어 보세요
		//객체 배열 (8가지 + String + Array + 사용자 정의 클래스)
		
		Employee[] emplist = {new Employee(9999,"아무개","IT"),
							new Employee(8888, "홍길동", "영업팀"),
							new Employee(7777, "아무개", "인턴")};
		
		for(Employee e : emplist) {
			e.employeeInfoPrint();
		}
		
	}

}
