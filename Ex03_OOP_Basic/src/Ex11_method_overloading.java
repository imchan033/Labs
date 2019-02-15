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
	//�迭(Array) �������
	//�����߱� ...
	//int[] source = {10,20,30,40,50};
	//�߿�*********************���ֳ���
	int[] add(int[] param) { //parameter �� int �迭�� �ּҰ��� �ްڴ�
		int[] target = new int[param.length];
		for(int i=0; i<param.length ; i++) {
			target[i] = param[i]+1;
		}
		return target; //int Ÿ���� �迭�� �ּҰ��� return
	}
	
	
		//������� �ڵ� �ۼ� (error�� ������ �˴ϴ�.)
	int[] add(int[] so, int[] so2) {
		int[] array=null;
		if (so.length == so2.length) {
			array = new int[so.length];
			for (int i = 0; i < so.length; i++) {
				array[i] = so[i] + so2[i];
			}
		}
		return array;
	}
	
	
	Human[] add(Human[] human) {
		//...
		Human[] h = new Human[human.length];
		//...
		return h;
	}
	
	
	
	
}

public class Ex11_method_overloading {

	public static void main(String[] args) {
		/*
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
		*/
		OverTest ot = new OverTest();
		//int Ÿ���� �迭�� �ּҸ� �־��...
		int[] source = {10,20,30,40,50};
		System.out.println(source);  //source �� �迭�� �ּҰ�
		int[] target = ot.add(source); //[I@15db9742 �ּҰ�
		for(int i=0 ; i<target.length ; i++) {
			System.out.printf("target[%d] : %d\n",i,target[i]);
		}
		
		//int[] add(int[] so, int[] so2) ����� error ������ �ǿ�
		int[] so = {1,2,3,4,5};
		int[] so2 = {10,20,30,40,50};
		int[] result = ot.add(so, so2);
		System.out.println("�� �迭 ���� �ೢ���� ��");
		for(int i=0 ; i<result.length ; i++) {
			System.out.printf("%d\t",result[i]);
		}
		
	
	}

}
