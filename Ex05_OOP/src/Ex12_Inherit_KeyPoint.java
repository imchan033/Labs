/*
�ó�����(�䱸����)
 
 */
class Product{ //������ǰ
	int price;
	int bonuspoint;
	
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	
	KtTv(){
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
		
}

class Audio extends Product{
	
	Audio(){
		super(1000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
}

class Notebook extends Product{
	
	Notebook(){
		super(7000);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
	
}

class Buyer{
	int money = 20000;
	int bonuspoint = 0;
	
	/*
	 �������� 
	 ��������(�ܾ� ��ǰ�� ����, ����Ʈ ���� ����)
	 �����ڴ� ���忡 �ִ� ��� ��ǰ�� ������ �� �ִ�
	 ���������� �ϴ� �Լ��� �����ϼ���
	 KtTv, Audio, NoteBook ���� ����
	 
	 ���忡 ��ǰ�� 1000�� �ٸ� ��ǰ�� �߰�(pos ��� �ڵ�ȭ)
	 ������ ���� ���忡 �ڵ� ��ġ
	 ���� >> �� >> �ڵ��� ����
	 kttv, audio, notebook ������ 997���� ��ǰ�� �������� �Ұ�
	 **��ǰ�� �߰� �� ������ �����Լ� �����ؾ߸�...
	 
	 */
	
	//1�� �ڵ�
	
//	void kttvbuy(KtTv n ) { //����(��ǰ����) //KtTv parameter ��...
//		if(this.money < n.price) {
//			System.out.println("���� �ܾ��� �����մϴ�.^^");
//			return; // ���� ������ ���� ����
//		}
//		
//		//�� ��������
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("������ ������ : " + n.toString());
//		
//	}
//	void audiobuy(Audio n ) { //����(��ǰ����) //KtTv parameter ��...
//		if(this.money < n.price) {
//			System.out.println("���� �ܾ��� �����մϴ�.^^");
//			return; // ���� ������ ���� ����
//		}
//		
//		//�� ��������
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("������ ������ : " + n.toString());
//		
//	}
//	void notebookbuy(Notebook n ) { //����(��ǰ����) //KtTv parameter ��...
//		if(this.money < n.price) {
//			System.out.println("���� �ܾ��� �����մϴ�.^^");
//			return; // ���� ������ ���� ����
//		}
//		
//		//�� ��������
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("������ ������ : " + n.toString());
//		
//	}
	
	//2�� ���� : �Լ��� ����
	//method overloading ���

	//������ �ڵ� (������)
	void buyProduct(Product product) {
		if(this.money<product.price) {
			System.out.println("�ܾ׺���!");
		}
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.println("������ ������ : " + product.toString());
	}
	
	
}
public class Ex12_Inherit_KeyPoint {

	public static void main(String[] args) {
//		KtTv tv = new KtTv();
//		System.out.println(tv.toString());
//		System.out.println(tv.price);
//		System.out.println(tv.bonuspoint);
//		
		KtTv tv = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();
		
		Buyer buyer = new Buyer();
//		buyer.kttvbuy(tv);
//		buyer.kttvbuy(tv);
//		buyer.notebookbuy(notebook);
		
		buyer.buyProduct(notebook);
		buyer.buyProduct(tv);
		buyer.buyProduct(audio);
		
	}

}
