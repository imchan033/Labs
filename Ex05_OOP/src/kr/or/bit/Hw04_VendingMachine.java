package kr.or.bit;
import java.util.*;

class VendingMachine {
	Scanner scanner;
	String manufacturer;  // ������
	String model;		  // �𵨸�
	
	int receivedMoney;	  				// ���� �ݾ�
	String[] selectCigarette; 			// ��輱�ù�ư
	int[] inventory;					// ��� �ܰ� ����
	static int changeAmount;            // �ܵ��ܾ� (�ϴ� �̷���)
	//static int totalCount=0;          // �� ��� �Ǹ� ����
	
	Cigarettes[] cigar;		// ����� ������ ���������̹Ƿ� �迭 ����
	
	public VendingMachine(){
		Scanner scanner = new Scanner(System.in);
		manufacturer = "���Ǳ��ڸ���";
		model = "������Ǳ�";
		changeAmount = 100000;   //�ܵ� 10���� �Է�
		
		cigar = new Cigarettes[]{new Cigarettes("�ʸ��𸮽�", "������", 4700),
				new Cigarettes("BAT", "����", 4500),
				new Cigarettes("�ʸ��𸮽�", "�ȸ��Ƹ�Ʈ", 4300),
				new Cigarettes("KT&G", "����", 5000),
				new Cigarettes("KT&G", "����", 4200)};
		
		selectCigarette = new String[cigar.length];
		inventory = new int[cigar.length];
		
		for(int i=0 ; i<cigar.length ; i++) {//��� ���� 30��, ��輱�ù�ư X �ʱ�ȭ
			inventory[i]=30;
			selectCigarette[i]="X";
		}
		
	}
	
	public void operation() {		
		while(true) {
			displayMenu();
			while(isAdult()==true) {
			
				payMenu();
				displayMenu();
				selectCigarettes();
			}
		}
	}
	
	//���޴����
	void displayMenu() {  
		for (int i=0; i<this.cigar.length; i++) {
			// ��� �����鼭 �ܱݺ��� ���� ��� ��ư on
			if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0) {
				//selectCigarette[i]="o";
				System.out.printf((1+i)+". %s (%d��) [o]\n",
						cigar[i].cigarName,cigar[i].cigarPrice);
			}else {
				System.out.printf((1+i)+". %s (%d��) [x]\n",
						cigar[i].cigarName,cigar[i].cigarPrice);
			}
		}System.out.println("���Ե� �ݾ� : "+receivedMoney+"��");	
	}
	
	
	void adminMenu() {
		while(true) {
			System.out.println("=========================");
			System.out.println("======  ������ ��� �޴� ======");
			System.out.println(" 1. ������ Ȯ��                   ");
			System.out.println(" 2. ���ä���                      ");
			System.out.println(" 3. �ܵ���� Ȯ��                   ");
			System.out.println(" 4. �ܵ�ä���                      ");
			System.out.println(" 5. ����                            ");
			Scanner scanner = new Scanner(System.in);
			int menu = Integer.parseInt(scanner.nextLine());
			switch(menu) {
			case 1: checkInventory();break;
			case 2: fillInventory(); break;
			case 3: checkChange();   break;
			case 4: fillChange();    break;
			case 5: operation(); break;
			default: 
			}
		}
	}
	
	public boolean isAdult() {	// ����Ȯ��
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� �ʿ��մϴ�. �ź����� �Է����ּ���!!");
		int age = Integer.parseInt(scanner.nextLine());
		boolean adult;
		if(age<=2000) {
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
			adult = true;
		} else if (age==9999) {
			adminMenu();
			adult =false;
		} else {
			System.out.println("�̼����ڴ� �Ǹ��� �� �����ϴ�.");
			adult = false;
		}
		return adult;
	}
	
	
	public void changeReturn() {	// ��ȯ�� �ܵ�
		System.out.println(receivedMoney+"����");//�ܵ�����
		changeAmount-=receivedMoney;
		receivedMoney=0; //��0���� �ʱ�ȭ
	}
	
	/*
	public int availableCigarettes() {	// ������Ȯ�� (IoT�� �־�� ����~)
		return 0;
	}
	*/
	
	
	public void selectCigarettes() { // ��� ����
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("(��ȯ����[0��])��� ��ȣ�� �������ּ���>");
			int number = Integer.parseInt(scanner.nextLine());
			System.out.println();
			//int number = scanner.nextInt();
			if (number == 0) { // 0�� ������ �ܵ� ��ȯ
				changeReturn();
				return;
				
			} else if (number < 0 || number > cigar.length) { // �߸��� ��ȣ �Է½�
				System.out.println("��ȣ�� �ٽ� �Է����ּ���");
			} else {
				if (receivedMoney >= cigar[number].cigarPrice) {
					receivedMoney -= cigar[number].cigarPrice; // ���������� ��谪����
					inventory[number]--; // ��� ���� -1
					displayMenu();
					System.out.println(cigar[number].cigarName + "����!");// ������
				} else {
					displayMenu();
					System.out.println("���� �� �־� �ּ���!");
				}
			}
		}
	}

	public void payMenu() {	// payAmount�� �ݾ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �־��ּ���!");
		receivedMoney = Integer.parseInt(scanner.nextLine());
	}

//	public void requestOrder() {
//		System.out.println("��ǰ�� ���� �Ǹ�����");
//		System.exit(0);
//	}
	
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
	public void checkInventory() {
		for (int i=0; i<inventory.length; i++) {
			System.out.printf("%s : %d \n",cigar[i].cigarName, inventory[i]);
		}
	}
	
	public void fillInventory() {
		System.out.println("��谡 ä�������ϴ�.");
		for(int i=0 ; i<cigar.length ; i++) {
			inventory[i]=30;
			System.out.printf("%s : %d \n",cigar[i].cigarName, inventory[i]);
		}
		
	}
	
	public void checkChange() {
		System.out.printf("�ܵ� : %d \n", this.changeAmount);		
	}

	public void fillChange() {
		this.changeAmount = 100000;		
		System.out.printf("�ܵ��� %d������ �����߽��ϴ�.\n", this.changeAmount);
	}

}

class Cigarettes {


    public String cigarName;//��� �̸�
    public int cigarPrice;// ����
   // public int cigarNum;// ����
    
    

     public Cigarettes(String maker, String cigarName, int cigarPrice) {

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

public class Hw04_VendingMachine {
	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		
		vm.operation();

	}

}
    	 




