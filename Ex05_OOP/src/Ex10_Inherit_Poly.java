//������(��Ӱ��迡��)
//������ : �������� ����(����)�� ���� �� �ִ� �ɷ�
//TIP) C# �������ȿ� overloading, override ����

//JAVA : [��Ӱ���]���� �ϳ��� [��������]�� �������� Ÿ���� ���� �� �ִ�
//���⼭ ���ϴ� [��������]�� [�θ�Ÿ��]�� �̾߱� �Ѵ�
//����Ŭ���� Ÿ���� ���������� �������� �ڽ�Ŭ���� ��ü�� �ּҸ� ���� �� �ִ�

//java : �ڽ��� �θ𿡰� ���Ǿ��� �帰��(���Ǽ���� �ݴ�?)

class Tv2{//�θ�(�Ϲ�ȭ, �߻�ȭ) �����ڿ�
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUP() {
		ch++;
	}
	
	void chDown() {
		ch--;
	}
}

class CapTv extends Tv2{ //�ڱ⸸�� ������ ���(��üȭ, Ư��ȭ, ...)
	String text;
	String caption() {
		return this.text = "���� �ڸ� ó�� ���Դϴ�...";
	}
}
public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		CapTv tv = new CapTv();
		tv.power();
		System.out.println("���� ���� : "+ tv.power);
		tv.chUP();
		System.out.println("ä�� ���� : "+ tv.ch);
		System.out.println(tv.caption());
		//��������� ���� ���� �н�
		
		//Tv2 tv2 = new Tv2();
		//heap �޸𸮿� Tv2 Ÿ�� ��ü�� �ε� �Ǿ� �ִ�
		
		//Tv2 tv2 = new Tv2();  �̹� memory�� �ִµ� ���� ������ �ʿ�x
		
		Tv2 tv2 = tv; //�ڽ�Ÿ���� �ּҸ� �θ�Ÿ�Կ���..���Ǿ���
		//�θ�͸� ���� �����մϴ�
		
		System.out.println(tv.toString());
		System.out.println(tv2.toString());
		
		//tv2.ch
		
		
		
		

	}

}