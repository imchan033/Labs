/* Ʈ������̶�? ����-�� �۾�����
��ü ���� ��� Ư¡
���, ĸ��ȭ, ������...

ĸ��ȭ(����ȭ) -> private

[method overloading]
***[�ϳ��� �̸�]���� [�������� ���]�� �ϴ� �Լ�***
��� : System.out.println() ��ǥ���� ��
Ư¡ : �����ε� ������� ������ ���� �ʴ´�
		why) ���ϰ� ����Ϸ��� >> ������ (�Լ��� ������ ������ �ʾƵ� �ȴ�)
		����� � ���� ��� : �Լ��� Ȱ���� ���� ���
		
���� : �Լ��� �̸��� ���� parameter �� ������ Ÿ���� �޸��ϴ� ���
1. �Լ��� �̸��� ���ƾ� �Ѵ�
2. [parameter] ���� �Ǵ� [Type]�� �޶�� �Ѵ�
3. return Type overloading �Ǵܱ����� �ƴϴ�
4. parameter ������ �ٸ��� ���� �Ѵ�
 */
class Human{
	String name;
	int age;
}

class OverTest{
	
	void add(Human h) {
		h.name = "ȫ�浿";
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
	
	//void add(int k){} �ȵǿ� (parameter type �浹)
	
	void add(int i, String s) {
		System.out.println("�����ε� ����");
	}
	
	void add(String s, int i) {
		System.out.println("�����ε� ����");//parameter�� ������ �ٸ��� �����մϴ�
	}
	
}

public class Ex11_method_overloading {

	public static void main(String[] args) {
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
	
	
	}

}
