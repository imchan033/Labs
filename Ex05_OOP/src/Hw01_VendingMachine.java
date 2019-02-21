import java.util.*;

class VendingMachine {
	Scanner scanner;
	String manufacturer;  // ������
	String model;		  // �𵨸�
	
	int receivedMoney;	  // ���� �ݾ�
	
	//boolean isPayback;	  				// ��ȯ�������� : 0�� ��� �ܵ� �Ǵ� ���� ��ȯ
	
	String[] selectCigarette; 			// ��輱�ù�ư
	int[] inventory;					// ��� �ܰ� ����
	int changeAmount;                  	// �ܵ��ܾ� (�ϴ� �̷���)
	//static int totalCount=0;          	// �� ��� �Ǹ� ����
	
	Cigarettes[] cigar;		// ����� ������ ���������̹Ƿ� �迭 ����
	
	public VendingMachine(){
		scanner = new Scanner(System.in);
		manufacturer = "���Ǳ��ڸ���";
		model = "������Ǳ�";
		changeAmount = 100000;   //�ܵ� 10���� �Է�
		
		cigar = new Cigarettes[]{new Cigarettes("�ʸ��𸮽�", "������", 4500),
				new Cigarettes("BAT", "����", 4500),
				new Cigarettes("�ʸ��𸮽�", "�ȸ��Ƹ�Ʈ", 4500),
				new Cigarettes("KT&G", "����", 4500),
				new Cigarettes("KT&G", "����", 4500)};
		
		selectCigarette = new String[cigar.length];
		inventory = new int[cigar.length];
		
		for(int i=0 ; i<cigar.length ; i++) {//��� ���� 30��, ��輱�ù�ư X �ʱ�ȭ
			inventory[i]=30;
			selectCigarette[i]="X";
		}
		
	}
	public void operation() {
		System.out.println("*****������Ǳ�******");
		
		while(true) {
			if(isAdult()==true) {
				payMenu();
				selectCigarettes();
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	//���޴����
	void displayMenu() {  
		for (int i=0; i<this.cigar.length; i++) {
			// ��� �����鼭 �ܱݺ��� ���� ��� ��ư on
			if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0) {
				selectCigarette[i]="o";
			}else {
				selectCigarette[i]="x";
			}
			//���
			System.out.printf((1+i)+". %s (%d��) [%s]\n",
					cigar[i].cigarName,cigar[i].cigarPrice,selectCigarette[i]);
		}System.out.println("���Ե� �ݾ� : "+receivedMoney+"��");	
	}
	 boolean checkChange() {
		 return false;
	 }
	public boolean isAdult() {	// ����Ȯ��
		System.out.println("���������� �ʿ��մϴ�. �ź����� �Է����ּ���!!");
		int age = scanner.nextInt();
		boolean adult;
		if(age<=2000) {
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
			adult = true;
		}else {
			System.out.println("�̼����ڴ� �Ǹ��� �� �����ϴ�.");
			adult = false;
		}
		return adult;
	}
	public void payRemains() {	// ��ȯ�� �ܵ�
		System.out.println(receivedMoney+"����");//�ܵ�����
		receivedMoney=0; //��0���� �ʱ�ȭ
	}
	
	/*
	public int availableCigarettes() {	// ������Ȯ�� (IoT�� �־�� ����~)
		return 0;
	}
	*/
	
	
	public void selectCigarettes() { // *��° ��踦 ����
		//while (true) {
			System.out.print("��� ��ȣ�� �������ּ���>");
			int number = scanner.nextInt() - 1;
			receivedMoney -= cigar[number].cigarPrice; // ���������� ��谪����
			inventory[number]--; // ��� ���� -1
			System.out.println(cigar[number].cigarName + "����!"); // ������
		//}
	}
	
	public void payMenu() {	// payAmount�� �ݾ�
		System.out.println("���� �־��ּ���!");
		receivedMoney = scanner.nextInt();
//		// �ܵ��� 10000�� �̻��̸� �Ǹ�, �����̸� �Ǹ�����
//		if(changeAmount>10000) {
// //			�ǸŰ����� ����ư�� ���� ���´�
//			for (int i=0; i<this.cigar.length; i++) {
//				// ��� �����鼭 �ܱݺ��� ���� ��� ��ư on
//				if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0)
//					selectCigarette[i]="o";
//			}//��� �޴� ���
//		} else {
//			System.out.println("�ܵ��������� �Ǹ�����. �ܵ��� ��ȯ�մϴ�.");
//			payRemains();
//		}


	}

	/*
	public boolean requestOrder() { // ������ ȣ�� : �������� �� ������ �������� ȣ��??
		return false;
	}
	*/
	
	/*
	public void sellCount() { // �����ǸŰ���
		totalCount++;
	}
	*/
	
	/*
	public boolean requestChange() { // �ܵ��� �������� ������ ȣ��?
		return false;
	}
	*/
	
}

class Cigarettes {

    public String maker;//������
    public String cigarName;//��� �̸�
    public int cigarPrice;// ����
   // public int cigarNum;// ����
    
    

     public Cigarettes(String maker, String cigarName, int cigarPrice) {
         this.maker = maker;
         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         //this.cigarNum = cigarNum;
     }
     /*
     public void dailySelling(int totalCount) {
		 int sellingSum = 0;
		 sellingSum = totalCount*4500;
		 System.out.println("���� ���� �ǸŰ���:  "+ totalCount+"���� ���� �Ǹűݾ�:                 "+ sellingSum);
	 }
	 */

}

public class Hw01_VendingMachine {
	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		
		vm.displayMenu();

	}

}
    	 



