class VendingMachine {
	String manufacturer;  // ������
	String model;		  // �𵨸�
	
	int receivedMoney;	  // ���� �ݾ�
	
	boolean isPayback;	  				// ��ȯ�������� : 0�� ��� �ܵ� �Ǵ� ���� ��ȯ	
	boolean[] selectCigarette; 			//��輱�ù�ư
	int changeAmount;                  	// �ܵ��ܾ� (�ϴ� �̷���)
	static int totalCount=0;          	// �� ��� �Ǹ� ����
	
	Cigarettes[] cigar;		// ����� ������ ���������̹Ƿ� �迭 ����
	
	
	public boolean isAdult() {	// ����Ȯ��
		return false;
	}
	public int payRemains() {	// ��ȯ�� �ܵ�
		return 0;
	}
	
	public int availableCigarettes() {	// ������Ȯ�� (IoT�� �־�� ����~)
		return 0;
	}
	
	public void selectCigarettes(int select) { // *��° ��踦 ����
		System.out.println("����");
		System.out.println("�ܵ����� ���ݾ� ����");
		System.out.println("�ܵ��� ���ݾ׺��� ���� ��� �ش� ��輱�ù�ư�� ���� ����");
		sellCount();
	}
	
	public int payMenu(int payAmount, int payMethod) {	// payhAmount�� �ݾ�, payMethod : ������� 1: ���� 2: ī�� 
		return receivedMoney + payAmount;
	}

	
	public boolean requestOrder() { // ������ ȣ�� : �������� �� ������ �������� ȣ��??
		return false;
	}
	
	public void sellCount() { // �����ǸŰ���
		totalCount++;
	}
	
	public boolean requestChange() { // �ܵ��� �������� ������ ȣ��?
		return false;
	}
	
}

class Cigarettes {

    public String maker;//������
    public String cigarName;//��� �̸�
    public int cigarPrice;// ����
    public int cigarNum;// ����

     public Cigarettes(String maker, String cigarName, int cigarPrice,int cigarNum ) {
         this.maker = maker;
         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         this.cigarNum = cigarNum;
     }
     public void dailySelling(int totalCount) {
		 int sellingSum = 0;
		 sellingSum = totalCount*4500;
		 System.out.println("���� ���� �ǸŰ���:  "+ totalCount+"���� ���� �Ǹűݾ�:                 "+ sellingSum);
	 }

}

public class Hw01_VendingMachine {

	public static void main(String[] args) {
		

	}

}
    	 



