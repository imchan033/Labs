package kr.or.bit;

//protected ���� : ��Ӱ��迡�� ������...
//����� �ʿ��ϴٸ� ��������... �Ƹ� �ʿ��� ��...

//���� : ���� �� �� �ִ�, ���� ������
public class Bird {
	public void fly() {
		System.out.println("i am fly..");
	}
	
	//������ ������...
	protected void movefast() {
		fly();		
	}
}
