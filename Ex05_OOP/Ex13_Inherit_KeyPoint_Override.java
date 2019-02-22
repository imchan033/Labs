/*
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� ��� ������ǰ�� ���� �� �ִ� 
īƮ�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... īƮ�� ��´�

���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ���
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���
ȣ��
hint) īƮ ������ ��� ���� (Buy())
hint) Buyer ..>> summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�
*/

class Product2{  //������ǰ
	int price;
	int bonuspoint;
	
	//Product() {	}
	Product2(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price /10.0);
	}
}
class KtTv2 extends Product2 {
	KtTv2(){
		super(5000);
	}
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2 {
	Audio2(){
		super(100);
	}
	@Override
	public String toString() {
		return "Audio2";
	}
}

class Notebook2 extends Product {
	Notebook2(){
		super(100);
	}
	@Override
	public String toString() {
		return "Notebook2";
	}
}

class Buyer2{
	int money=10000;
	int bonuspoint=0;
	
	void Buy(Product2 n) { //���� (��ǰ����) //KtTv parameter �� ...
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ� ^^");
			return; //���� ������ ���� ����
		}
		//�� ��������
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("������ ������ : " + n.toString());
	}
}


public class Ex13_Inherit_KeyPoint_Override {
	public static void main(String[] args) {
		/*
		Buyer2 buyer = new Buyer2(2000,0);
		KtTv2 tv = new KtTv2();
		Audio2 audio = new Audio2();
		NoteBook2 notebook = new NoteBook2();
		
		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		
		buyer.Summary();
		*/
	}

}
