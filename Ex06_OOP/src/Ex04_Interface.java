/*
�������̽�(interface)
������ �ǹ�
1. ���, ǥ��, ��Ģ, �Ծ� ���� ����� ����
ex) ���� (����), �Ź� (������)
ex) iso ǥ��...

����Ʈ���� ����
>>�������̽��� ������ �ֻ��� �ܰ� (������ ���� â��)
>>���� ǥ��, ����� ���� �ϴ� ����

1. �������̽��� [������] ���忡�� ���� (�������̽��� �θ� Ÿ���̴�)
2. ���� �������� ���� Ŭ������ ���ؼ� �ϳ��� ���� ��� (�θ� ����)

interface
1. ���� �����ΰ� ���� : ������� ���� : �߻��Լ�(�ڿ�) >> void move (int x, int y);
2. ǥ��ȭ�� ���踦 ����(�Ϻ��� ������ ����)
3. ���뼳��

JAVA API
(�����ڰ� �ʿ��� �������̽��� ������ �ִ�) : ��� Ŭ������ �������̽� ����� ����
>> collection (Vector, ArrayList, HashSet, HashMap, Stack, Queue... ���)

1. �������
��� (final) : public static final int num = 0 >> [public static final] ����
�Լ� (method) : public abstract void run(); >> [public abstract] ����
�Լ� (method) : public abstract String move(int x, int y); >> [public abstract] ����
�������̽��� ������ ���� �߻�޼��常 ������...

1. �������̽��� ��ü ���� �Ұ�(��� ������ ������ �߻��Լ�)
2. ������ ���ؼ��� ��밡��(class Test implements Ia ...)
3. Ŭ������ �������̽� ���� ���� ����(class Test implements Ia,Ib,Ic ...)
4. �������̽������� ����� ����(Ia extends Ib : ū ��Ģ�� ����� �ִ�)
5. �������̽��� �ϳ��� Ÿ���̴� (**POINT**) 

 */

interface Ia{
	//���(�ý��� �ڿ� ��)
	public static final int VERSION = 1;
	//int VERSION = 1;
	//[public static final] default
	String GENDER = "��";
	//public static final String GENDER = "��";
	
	public abstract String print();
	//String print();
	//[public abstract] default ��
	String message(String str);
	
}

interface Ib{
	int AGE = 0;
	void info();
	String value(String s);
}

class Test extends Object implements Ia, Ib{

	@Override
	public void info() {		
		
	}

	@Override
	public String value(String s) {
		
		return null;
	}

	@Override
	public String print() {
		
		return null;
	}

	@Override
	public String message(String str) {
		
		return null;
	}
	
}

public class Ex04_Interface {

	public static void main(String[] args) {
		Test t = new Test();
		Ia ia = t; //������ (�θ�Ÿ��)
		

	}

}


















