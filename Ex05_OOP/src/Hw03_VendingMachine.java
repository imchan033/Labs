import java.util.Scanner;

public class VendingMachine01 {
    String manufacturer; // ������
    String model; // �𵨸�
    final static int cigarPrice = 4500;
    static int startMoney = 100000;
    static int receivedMoney;// ���� �ݾ�
    boolean[] isStop; // ��輱�ù�ư���� ��� ��� �Ǹű������� ���� ���

    boolean isPayback;// ��ȯ�������� : 0�� ��� �ܵ� �Ǵ� ���� ��ȯ
    boolean[] selectCigarette;// ��輱�ù�ư
    int changeAmount;// �ܵ��ܾ� (�ϴ� �̷���)
    static int totalCount = 0;// �� ���

    public static Cigarettes01[] cigar = new Cigarettes01[6];// ����� ������ ���������̹Ƿ� �迭 ����
    public static int cigarNum[] = new int[cigar.length];// ��� ��������
    static Scanner sc = new Scanner(System.in);

    public static void cigarInfo() {

        cigar[0] = new Cigarettes01("�ʸ��𸮽�", "������");
        cigar[1] = new Cigarettes01("�ʸ��𸮽�", "���ϵ弼��");
        cigar[2] = new Cigarettes01("�ʸ��𸮽�", "����");
        cigar[3] = new Cigarettes01("KT&G", "�ȸ��Ƹ�Ʈ");
        cigar[4] = new Cigarettes01("KT&G", "���÷���");
        cigar[5] = new Cigarettes01("KT&G", "���� ü����");

        for (int i = 0; i < cigar.length; i++) {
            cigarNum[i] = 30;
        }

    }

    public static boolean isAdult(int age) { // ����Ȯ��
        boolean result;
        if (age < 1900 && age > 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public int payRemains() { // ��ȯ�� �ܵ�
        return 0;
    }

    public int availableCigarettes01() { // ������Ȯ�� (IoT�� �־�� ����~)
        return 0;
    }

    public void selectCigarettes01(int select) { // *��° ��踦 ����
        System.out.println("����");
        System.out.println("�ܵ����� ���ݾ� ����");
        System.out.println("�ܵ��� ���ݾ׺��� ���� ��� �ش� ��輱�ù�ư�� ���� ����");
        sellCount();
    }

    public static String payMenu(int receivedMoney) { //
        int menuNum;
        int returnMoney;
        System.out.println("���ϴ� ����� ��ȣ�� �Է����ּ���! ");
        menuNum = Integer.parseInt(sc.nextLine());

        cigarNum[menuNum - 1]--;

        returnMoney = receivedMoney - cigarPrice;

        System.out.printf("������ %d���Դϴ�..\n", cigarPrice);
        System.out.printf("�ܵ��� %d �Դϴ�.\n", returnMoney);

        startMoney -= returnMoney;

        return cigar[menuNum - 1].cigarName;
    }

    public boolean requestOrder() { // ������ ȣ�� : �������� �� ������ �������� ȣ��??
        return false;
    }

    public static void sellCount() { // �����ǸŰ���
        totalCount++;
    }

    public boolean requestChange() { // �ܵ��� �������� ������ ȣ��?
        return false;
    }

    public void dailySelling(int totalCount) {
        int sellingSum = 0;
        sellingSum = totalCount * 4500;
        System.out.println("���� ���� �ǸŰ���:  " + totalCount + "���� ���� �Ǹűݾ�: " + sellingSum);
    }

    public static void displayCigarettes01() {

        int cnt = 0;

        System.out.println("���Ͻô� ��踦 �����ϼ���! ");
        System.out.println();
        for (int i = 0; i < cigar.length; i++) {
            System.out.printf("[%d. %s ", i + 1, cigar[i].cigarName);
            if (cigarNum[i] > 0)
                System.out.printf("%c]  \t", '��');
            else
                System.out.printf(" %c]  \t", '��');
            cnt++;
            if (cnt == 3) {
                System.out.println();

            }
        }
        System.out.println();
    }

    class Cigarettes01 {

        public String maker;//������
        public String cigarName;//��� �̸�
        //public int cigarPrice;// ����
       // public int cigarNum;// ����
        
        

         public Cigarettes01(String maker, String cigarName) {
             this.maker = maker;
             this.cigarName = cigarName;
             //this.cigarPrice= cigarPrice;
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
    public static void main(String[] args) {
        int age;

        System.out.println("--------��� ���Ǳ�-----------");
        System.out.println("���������� �����մϴ�. ");
        System.out.println("���� ������ �Է��ϼ���! ex) 92�� 07�� -> 9207 ");

        while (true) {
            age = Integer.parseInt(sc.nextLine());
            if (isAdult(age) == false) {
                System.out.println("�̼����ڴ� ��踦 ������ �� �����ϴ�.");
                System.out.println("�ٽ� �Է����ּ��� !");
            } else
                break;

        }

        cigarInfo();

        System.out.println("���� �������ּ���!");
        receivedMoney = Integer.parseInt(sc.nextLine());

        displayCigarettes01();

        System.out.printf("%s �� ���Խ��ϴ�!  \n", payMenu(receivedMoney));

        sellCount();

    }

}