
public class Program {

	public static void main(String[] args) {
		// ������, ������
		// ���α׷��� ����Ǹ� ���� ���� ����Ǵ� ����
		System.out.println("Hello");
		
		
		Person kim = new Person(100, "������");
		kim.personInfo();
		
		Person park = new Person(10,"�ھ�");
		park.personInfo();
		//new�� �ϴ� ���� Person Ŭ������ Ȯ���� ����Ʈ ���� ����(�޸� ��)
	}
	/*
	 *  hello.java (�ҽ��ڵ� : �ΰ��� �ν� ����) 
	 *  javac hello.java(class������ ������) >> �������� //
	 *  java hello >> hello ��� ����
	 * 
	 *  stack >> �Լ��� �ø��� �������� Ȱ�� //heap ��������
	 *  ��Ƽ������ >> stack�� �������� �ѹ��� ��� �Լ��� �ѹ��� �����ų �� �ִ�.
	 */ }
