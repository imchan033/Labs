import java.util.Scanner;

class VendingMachine {
	String manufacturer; // ������
	String model; // �𵨸�

	int receivedMoney; // ���� �ݾ�
	int[] inventory; // ��� �ܰ� ����
	int changeAmount; // �ܵ��ܾ� (�ϴ� �̷���)
	Cigarettes[] cigar; // ����� ������ ���������̹Ƿ� �迭 ����

	public VendingMachine() {
		Scanner scanner = new Scanner(System.in);
		manufacturer = "���Ǳ��ڸ���";
		model = "������Ǳ�";
		changeAmount = 100000; // �ܵ� 10���� �Է�

		cigar = new Cigarettes[] { new Cigarettes("�ʸ��𸮽�", "������", 4700), new Cigarettes("BAT", "��  ��", 4500),
				new Cigarettes("�ʸ��𸮽�", "�ȸ��Ƹ�Ʈ", 4300), new Cigarettes("KT&G", "��  ��", 5000),
				new Cigarettes("KT&G", "��  ��", 4200) };

		inventory = new int[cigar.length];
		for (int i = 0; i < cigar.length; i++) { // ��� ���� 30�� �ʱ�ȭ
			inventory[i] = 30;
		}
	}

	public void operation() {
		while (true) {
			displayMenu();
			while (isAdult() == true) {
				payMenu();
				displayMenu();
				selectCigarettes();
			}
		}
	}

	// ���޴����
	private void displayMenu() {
		System.out.println("======================================");
		System.out.println("===============������Ǳ�===============");
		for (int i = 0; i < this.cigar.length; i++) {
			// ��� �����鼭 �ܱݺ��� ���� ��� ��ư on
			if (this.receivedMoney >= this.cigar[i].cigarPrice && this.inventory[i] > 0) {
				System.out.printf((1 + i) + ". %s (%d��) [o]\n", cigar[i].cigarName, cigar[i].cigarPrice);
			} else {
				System.out.printf((1 + i) + ". %s (%d��) [ ]\n", cigar[i].cigarName, cigar[i].cigarPrice);
			}
		}
		System.out.println("���� �ݾ� : " + receivedMoney + "��");
	}

	// ����Ȯ��
	private boolean isAdult() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� �ʿ��մϴ�. ����⵵�� �Է����ּ���!");
		int year = Integer.parseInt(scanner.nextLine());
		boolean adult;
		if (year <= 2000) {
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
			adult = true;
		} else if (year == 9999) { // 9999�Է½� ������ ���
			adminMenu();
			adult = false;
		} else {
			System.out.println("�̼����ڴ� �Ǹ��� �� �����ϴ�.");
			adult = false;
		}
		return adult;
	}

	// �ܵ� ��ȯ
	private void changeReturn() { // ��ȯ���ܵ�
		System.out.println(receivedMoney + "����");
		changeAmount -= receivedMoney; // �ܵ����
		receivedMoney = 0; // �ݾ� 0���� �ʱ�ȭ
	}

	// ��� ����
	private void selectCigarettes() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("[��ȯ����0��]\n��� ��ȣ�� �������ּ���>");
			int number = Integer.parseInt(scanner.nextLine());
			if (number == 0) { // 0�� ������ �ܵ� ��ȯ
				changeReturn();
				return;
			} else if (number < 0 || number > cigar.length) { // �߸��� ��ȣ �Է½�
				System.out.println("��ȣ�� �ٽ� �Է����ּ���");
			} else {
				if (receivedMoney >= cigar[number - 1].cigarPrice) {
					receivedMoney -= cigar[number - 1].cigarPrice; // ���������� ��谪����
					inventory[number - 1]--; // ��� ���� -1
					displayMenu();
					System.out.println(cigar[number - 1].cigarName + "����!");// ������
				} else {
					displayMenu();
					System.out.println("���� �� �־� �ּ���!");
				}
			}
		}
	}

	// �� ����
	private void payMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �־��ּ���!");
		receivedMoney = Integer.parseInt(scanner.nextLine());
	}

	// �����ڸ޴�
	private void adminMenu() {
		while (true) {
			System.out.println("============================");
			System.out.println("======  ������ ��� �޴� ======");
			System.out.println(" 1. ������ Ȯ��                   ");
			System.out.println(" 2. ���ä���                      ");
			System.out.println(" 3. �ܵ���� Ȯ��                   ");
			System.out.println(" 4. �ܵ�ä���                      ");
			System.out.println(" 5. ����                            ");
			Scanner scanner = new Scanner(System.in);
			int menu = Integer.parseInt(scanner.nextLine());
			switch (menu) {
			case 1:
				checkInventory();
				break;
			case 2:
				fillInventory();
				break;
			case 3:
				checkChange();
				break;
			case 4:
				fillChange();
				break;
			case 5:
				return;
			default:
			}
		}
	}

	// ������Ȯ��
	private void checkInventory() {
		for (int i = 0; i < inventory.length; i++) {
			System.out.printf("%s : %d \n", cigar[i].cigarName, inventory[i]);
		}
	}

	// ���ä���
	private void fillInventory() {
		System.out.println("��谡 ä�������ϴ�.");
		for (int i = 0; i < cigar.length; i++) {
			inventory[i] = 30;
			System.out.printf("%s : %d \n", cigar[i].cigarName, inventory[i]);
		}

	}

	// �ܵ�Ȯ��
	private void checkChange() {
		System.out.printf("�ܵ� : %d \n", this.changeAmount);
	}

	// �ܵ�����
	private void fillChange() {
		this.changeAmount = 100000;
		System.out.printf("�ܵ��� %d������ �����߽��ϴ�.\n", this.changeAmount);
	}

}

class Cigarettes {

	public String cigarMaker; // ���� ȸ��
	public String cigarName; // ��� �̸�
	public int cigarPrice; // ����

	public Cigarettes(String cigarMaker, String cigarName, int cigarPrice) {
		this.cigarMaker = cigarMaker;
		this.cigarName = cigarName;
		this.cigarPrice = cigarPrice;
	}
}

public class Hw01_VendingMachine {
	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();

		vm.operation();

	}

}
