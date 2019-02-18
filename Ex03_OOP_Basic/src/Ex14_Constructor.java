import kr.or.bit.Employee;

public class Ex14_Constructor {

	public static void main(String[] args) {
		Employee emp = new Employee();//default
		emp.employeeInfoPrint();
		System.out.println(emp.getName());
		
		Employee emp2 = new Employee(1901, "ȫ�浿", "������");
		emp2.employeeInfoPrint();
		System.out.println(emp2.getName());
		emp2.setJob("������");
		emp2.employeeInfoPrint();
		System.out.println();
		
		//Array �� ����ؼ� ��� 3���� ����� ������
		//��ü �迭 (8���� + String + Array + ����� ���� Ŭ����)
		
		Employee[] emplist = {new Employee(9999,"�ƹ���","IT"),
							new Employee(8888, "ȫ�浿", "������"),
							new Employee(7777, "�ƹ���", "����")};
		
		for(Employee e : emplist) {
			e.employeeInfoPrint();
		}
		
	}

}
