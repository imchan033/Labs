import kr.or.bit.Pclass;

//������(������) : default, private, public, ��Ӱ��迡�� Pretected
//��Ӱ��迡���� ����
//��鼺 : default, public(��Ӱ��迡��)

//��Ӱ��迡�� Protected (�ڽ�Ŭ���� ���� �Լ���...)

//why?		class Car{ Protected void turn(){} }
//���� ����ϴ� ����� �ڿ��� ������ ������ ���ڴµ�...(�ǵ�)

class child2 extends Pclass{
	void method() {
		this.p = 1000; //��Ӱ��迡�� Protected �� public
		System.out.println(this.p);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		Pclass pc = new Pclass();
		System.out.println("�ٸ� ���������� public �ۿ� ������ �ȵȴ� : "+pc.j);
		
		child2 ch = new child2();
		ch.method();
		
		
	}

}
