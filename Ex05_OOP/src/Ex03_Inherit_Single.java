class Tv{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

class Vcr{ //���� �÷��̾�
	boolean power;
	
	void power(){
		this.power = !this.power;
	}
	void play() {
		System.out.println("����ϱ�");
	}
	void stop() {
		System.out.println("����");
	}
	void rew() {}
	void ff() {}
	
}
//���赵 : tv, vcr�� ������ �ִ�
//vcr��ɰ� tv����� �� ���� ���赵�� �ۼ��� �ּ���
//TvVcr ���赵 ��ǰ�� ����� �;��

//���赵 ����...
//class TvVcr extends Tv,Vcr{} (x : ���߻��)

//Tv extends Vcr
//TvVcr extends Tv (������ ���)

//TvVcr Ŭ���� Tv����, Vcr���� (�Ѵ� ���� �� ���� ����)

//�������� : ����� �ѹ��� �ϼ���
//���, ����
//��� : TvVcr�� ���鶧 � ���� ����ϰ� � ���� �����ϴ���...

//�ֱ��(Tv), �������(Vcr)
//������ ���� Ŭ������ ���..!

class TvVcr extends Tv{
	Vcr vcr;
	TvVcr(){
		vcr = new Vcr();
	}
}






public class Ex03_Inherit_Single {

	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv �������� : "+t.power);
		
		t.chUp();
		t.chUp();
		t.chDown();
		System.out.println("Tv ä������ : "+t.ch);

		//���� ����...
		t.vcr.power();
		System.out.println("Vcr �������� : "+t.vcr.power);
		
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power();
		
		t.power();
		System.out.println("Tv �������� : "+t.power);
		System.out.println("Vcr �������� : "+t.vcr.power);
	}

}
