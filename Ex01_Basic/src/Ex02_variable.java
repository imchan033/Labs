class Vtest{
	int iv;
	void print() {
		System.out.println("instance variable : " +iv);
	}
}

class Apt{
	String color; //String Ŭ���������� .....��а� [���ڿ�] Ÿ������ ����
	Apt(String color){ 
			//�Լ� (Ư���� �Լ�) : �Լ��� �̸��� Ŭ���� �̸��� ����
			//������ �Լ�(constructor) >> instance variable�� �ʱ�ȭ
		this.color = color; //this.color = Apt�� color
	}
	void aptPrint() {
		System.out.println("���� : " +this.color);
	}
}


public class Ex02_variable {

	public static void main(String[] args) {
		Vtest t= new Vtest();
		t.print();
		
		Vtest t2 = new Vtest();
		t2.iv = 300;
		t2.print();
		
		Apt sk = new Apt("gold");
		sk.aptPrint();
		
		Apt never = new Apt("red");
		never.aptPrint();
	}

}
