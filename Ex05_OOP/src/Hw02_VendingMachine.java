import java.util.Arrays;
import java.util.Scanner;

class VendingMachine2 {

	Scanner scanner = new Scanner(System.in);
	String manufacturer;  // ������
	String model;		  // �𵨸�
	
	int receivedMoney;	  // ���� �ݾ�

	boolean isPayback;	  				// ��ȯ�������� : 0�� ��� �ܵ� �Ǵ� ���� ��ȯ	
	//String [] selectCigarette; 			
	//��輱�ù�ư
	boolean isAdult;
	int changeAmount;                  	// �ܵ��ܾ� (�ϴ� �̷���)
	static int totalCount=0;          	// �� ��� �Ǹ� ����
	
	Cigarrettes3[] cigar;		// ����� ������ ���������̹Ƿ� �迭 ����
	
	// ������ �ʿ�

	
	public VendingMachine2(int changeAmount, Cigarrettes3[] cigar) {
		this("LG", "������Ǳ�011", 0, false, false, changeAmount, cigar );
	}
	
	
	public VendingMachine2(String manufacturer, String model, int receivedMoney, boolean isPayback, boolean isAdult,
			int changeAmount, Cigarrettes3[] cigar) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.receivedMoney = receivedMoney;
		this.isPayback = isPayback;
		this.isAdult = isAdult;
		this.changeAmount = changeAmount;
		this.cigar = cigar;
	}


	public boolean isAdult(boolean isAdult) {	// ����Ȯ��
		return this.isAdult=isAdult;
	}
	
	public void payRemains() {	// ��ȯ�� �ܵ�
		System.out.printf("�ܵ� %d�� ��ȯ�Ǿ����ϴ�. \n", this.receivedMoney);
		this.changeAmount -= this.receivedMoney;
		this.receivedMoney=0;
	}
	
	public void availableCigarrettes3() {	// ������Ȯ�� (IoT�� �־�� ����~)
		System.out.println("������>>");
		for (int i=0; i<this.cigar.length; i++) {
			System.out.printf("%s [%d] \n",cigar[i].cigarName, cigar[i].cigarNum);
		}

	}
	
	public void selectCigarrettes3(int select) { // *��° ��踦 ����
		System.out.printf("%s�� ���Խ��ϴ�. \n", this.cigar[select-1].cigarName);
		// �ܵ����� ���ݾ� ����
		this.receivedMoney -= this.cigar[select-1].cigarPrice;
		System.out.printf("�ܾ� >> %d \n", this.receivedMoney);
		// ������ ����
		this.cigar[select-1].cigarNum--;
		
		System.out.println("�ܵ��� ���ݾ׺��� ���� ��� �ش� ��輱�ù�ư�� ���� ���� : �̱��� while�� �ʿ�");
		sellCount();
	}
	
	public void payMenu() {	// payAmount�� �ݾ�
		System.out.println("���� �־��ּ���!");
		receivedMoney = scanner.nextInt();
		// �ܵ��� 10000�� �̻��̸� �Ǹ�, �����̸� �Ǹ�����
		if(checkChange(10000)==true) {
//			�ǸŰ����� ����ư�� ���� ���´�
			for (int i=0; i<this.cigar.length; i++) {
				// ��� �����鼭 �ܱݺ��� ���� ��谡 ���
				if(this.receivedMoney>=this.cigar[i].cigarPrice && this.cigar[i].cigarNum>0)
				System.out.printf("%d %s [%d] \n",i+1, cigar[i].cigarName, cigar[i].cigarPrice);
			}
		} else {
			System.out.println("�ܵ��������� �Ǹ�����. �ܵ��� ��ȯ�մϴ�.");
			payRemains();
		}


	}
	
	public boolean requestOrder() { // ������ ȣ�� : �������� �� ������ �������� ȣ��??
		return false;
	}
	
	public void sellCount() { // �ǸŰ��� ����
		totalCount++;
	}
	
	public boolean checkChange(int minimum) { // �ܵ��� �������� �Ǹ�����
		boolean result = false;
		if (this.changeAmount>=minimum) {
			result=true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "VendingMachine2 [manufacturer=" + manufacturer + ", model=" + model + ", receivedMoney=" + receivedMoney
				+ ", isPayback=" + isPayback + ", isAdult=" + isAdult + ", changeAmount=" + changeAmount + ", totalCount=" + totalCount + ", cigar="
				+ Arrays.toString(cigar) + "]";
	}
	
}

class Cigarrettes3 {

    public String maker;//������
    public String cigarName;//��� �̸�
    public int cigarPrice;// ����
    public int cigarNum;// ����

     public Cigarrettes3(String maker, String cigarName, int cigarPrice,int cigarNum ) {
         this.maker = maker;
         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         this.cigarNum = cigarNum;
     }
}

public class Hw02_VendingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cigarrettes3[] cigar = new Cigarrettes3[] { new Cigarrettes3("�ʸ��𸮽�", "������", 4500, 30)
											, new Cigarrettes3("BAT", "��������Ʈ", 4500, 30) 
											, new Cigarrettes3("JPT", "���ϵ���", 6000, 30)};

		
		VendingMachine2 machine = new VendingMachine2(100000, cigar);
		
		
		//==== ���ϴ� ���� method�� �����ʿ� 
		
//		���������� �Ѵ�
		machine.isAdult(true);
		
		
		System.out.println(machine.toString());
		
//		������ �ְų� ī�带 �����Ѵ�
		//machine.payMenu(6000, 1); // 5000��, ����
		System.out.println(machine.toString());
		
//		��ư�� ������ ��谡 �������� �ܱ��� ǥ�õȴ�
		machine.selectCigarrettes3(1);
		System.out.println(machine.toString());
//		�� �̻� ������ ���Ѵٸ� �ܱݹ�ȯ������ ������ �ܱ��� �޴´�. 
		machine.payRemains();
		System.out.println(machine.toString());
		
//      ������ Ȯ��		
		machine.availableCigarrettes3();

	}

}


