//���� <-> ���
//��� : �ѹ� ���� �������� ���� �Ұ�...
//�ý��ۿ��� �ѹ� ���� �������� ���� ���� ���ƾ� �� �� : �ý��� ���� ��ȣ
//�Ϲ� ��ļ����� ���� �������� ���� ���� ���ƾ� �� �� : ������ : �ֹι�ȣ, PI

//��� ���������� �빮��
//Java : final int NUM = 100;
//C# : const int NUM = 200;

//final Ű����
//Ŭ���� �տ� : final class Car{} >> ��ӺҰ� (extends �Ұ�)
//�Լ� �տ� : public final void print(){} >> ��Ӱ��迡�� ������ ������ (���� �����)

class Vcard{
	final String KIND = "heart";
	final int NUM = 10;
	void method() {
		//�ý��� ��� (static final double PI = 3.141592...
		System.out.println(Math.PI);
	}
}

//���� : Vcard Ÿ������ ����� ��� ��ü�� �ᱹ���� ���� ������� ������
//��ü���� �ٸ� ������� ���� �;��???

//��� ���� �ѹ� �����Ǹ� ���� ���� �ʾƿ�...
class Vcard2{
	final String KIND; //��ü ����� �ʱ�ȭ ���ϸ� �����...
	final int NUM;
	
//	Vcard2(){
//		this.KIND = "heart";
//		this.NUM = 10;
//	}
//	���������� �ʱ�ȭ�� �Ҽ��ִ� �ڵ带 ����(������)
	
	Vcard2(String kind, int num){
		this.KIND = kind;
		this.NUM = num;
	}
}
public class Ex07_Final {

	public static void main(String[] args) {
		Vcard v = new Vcard();
		v.method();
		//v.KIND="aaa"; �ȵſ�
		System.out.println(v.KIND+" / "+v.NUM);
		
		
		//POINT : ��ü���� �ٸ� ������� �ο��� �� �ֽ��ϴ�^^
		Vcard2 v2 = new Vcard2("heart2", 20);
		System.out.println(v2.KIND+" / "+v2.NUM);

		Vcard2 v3 = new Vcard2("heart3", 30);
		System.out.println(v3.KIND+" / "+v3.NUM);

	}

}
