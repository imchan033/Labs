import java.util.Arrays;

import kr.or.bit.Emp;

class Test extends Object{
	void print() {
		System.out.println("�θ��Լ�_TEST");
	}
}

class Test2 extends Test{

	@Override
	void print() {
		System.out.println("�ڽ��Լ�_Test2_������ ����");
	}
	
	void print(String s) { //�����ε�
		System.out.println("���� �����ε� �Լ���");
	}
	
}
public class Ex05_Inherit_override {
	
	public static void main(String[] args) {
		Test2 test = new Test2();
		test.print(); //������
		test.print("�����ε�");
		
		System.out.println(test); //default toString()
		System.out.println(test.toString());
		
		//Emp Ŭ�������� object ������ toString() ������
		Emp e = new Emp(9999,"�ƹ���");
		System.out.println(e.toString());
		
		//Arrays �̳༮�� object�� ������ toString() ������...
		int[] arr = { 11,23,24,24,34};
		System.out.println(Arrays.toString(arr));
	}

}
