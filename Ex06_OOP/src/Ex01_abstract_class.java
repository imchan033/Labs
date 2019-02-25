/*
�߻� Ŭ���� (���� ����...)
�̿ϼ� ���赵
�̿ϼ� Ŭ����(�ϼ��� �ڵ� + �̿ϼ� �ڵ�)
--�̿ϼ� �ڵ� : �̿ϼ� �Լ� ( �Լ��� {���� ��}�� ������ ���� �ʴ� )
--EX) public void print();   >>  {}  �����
�̿ϼ� Ŭ���� : new ���ؼ� ��ü ������ �Ұ���(�̿ϼ�) ...

 1. �߻�Ŭ������ ������ ��ü ���� �Ұ�
 2. �߻�Ŭ������ �ᱹ �ϼ��� Ŭ������ ���� ��� -> ����� ���ؼ�...
	�̿ϼ� �ڿ�(�߻� �Լ�)�� �ϼ� �ض�(����) -> ������ -> override

why : �߻�Ŭ������ �� ���������?
	: ������ ������ ����(�߻��Լ�) (�������� ���忡��)
	
*/

abstract class Abclass {
	int pos;

	void run() {
		pos++;
		System.out.println("pos : "+ pos);
	}
	// �� �ڵ�� �ϼ��� �ڵ� �Դϴ�.

	// �߻��Լ�(�߻��ڿ�)
	abstract void stop(); // {}������� �����
}

class Child extends Abclass {

	@Override
	void stop() { // stop �̶�� �Լ��� ������
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}

}

public class Ex01_abstract_class {

	public static void main(String[] args) {
		// Abclass ab = new Abclass(); �Ұ�
		Child ch = new Child();
		ch.run();
		ch.stop();
		
		Abclass ab = ch;
		ab.run();
		ab.run();
		ab.stop(); //�����ǰ� �� �ڽ��ʿ� �մ� stop �Լ� ȣ��
		
	}

}
