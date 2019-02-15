package kr.or.bit;
 
import java.util.Random;
import java.util.Scanner;
 
//���赵
//Lotto lotto = new Lotto();
//lotto.SelectLottoNumber(); >> �޴� ����
//1 ���� �Է� >> selectBasicNumber() �Լ� ȣ�� (�ǹ�ȣ ����) >> ���
//2 ���� �Է� >> ȭ�鿡 ���.....
//3 ���� �Է� >> ����
public class Lotto_Teacher {
    private Scanner scanner;
    private Random r; //r.nextInt(45)+1 (1~45)
    private int[] numbers;
                     //static{}  , {}  �ʱ���
    public Lotto_Teacher() { //Ư���� ����:member field �ʱ�ȭ :(������ �Լ�) , constructor
        scanner = new Scanner(System.in); //�ʱ�ȭ (���� ���� �ּҰ��� ���°�)
        r = new Random();
        numbers = new int[6];
    }
    
    //����� �����غ����� (�Լ�)
    //�Լ��ϳ��� ��� �ϳ�
   
   private String showMenu(Scanner scanner) {
       System.out.println("*********************");
       System.out.println("1. ��÷ ���� ��ȣ ����:");
       System.out.println("2. ����.^^!");
       System.out.println("3. �߰����)����3��,�ڵ�3��");
       System.out.println("*********************");
       System.out.print("�Է� : ");
       String selectionnum = scanner.nextLine();
       return selectionnum;
   } 
    
   public void selectLottoNumber() {
       //�޴� ����....
escape: while(true) {
           String selectionnum = showMenu(scanner);
			switch (selectionnum) {
			case "1":
				selectBasicLottoNumber(r, numbers); // ����
				showLottoNumbers(numbers); // ȭ�� ���
				break;

			case "2":
				System.out.println("Good Lucky");
				break escape; // escape �������� Ż��.
			case "3":
				manualLottoNumber(r, numbers);
				showLottoNumbers(numbers);
				break;
			default:
				System.out.println("Not Operation");
				break;

			}
		}
       
   }
   
   private void  selectBasicLottoNumber(Random r , int[] numbers) {
       //�Ƿζ� ��ȣ �����ϰ� �ߺ��� ���� ó�� �ϴ� �Լ�
       for (int i = 0; i < 6; i++) {
           numbers[i] = r.nextInt(45)+1; //���� ����
          for (int j = 0; j < i; j++) {
              if (numbers[i] == numbers[j]) {
                  i--; //point
                  break;
              }
           }
        }
   }
   
   private void showLottoNumbers(int[] numbers) {
       for (int i = 0; i < numbers.length; i++) {
           for (int j = i + 1; j < numbers.length; j++) {
               if (numbers[i] > numbers[j]) {
                   int temp = numbers[i];
                   numbers[i] = numbers[j];
                   numbers[j] = temp;
               }
           }
       }
       for(int i = 0 ; i < numbers.length ; i++) {
           System.out.printf("[%2d]",numbers[i]);
       }
       System.out.println();
       
       
   }

   private void  manualLottoNumber(Random r , int[] numbers) {
	   System.out.println("��ȣ ������ �Է��ϼ���");
       for (int i = 0; i < 6; i++) {
    	   if(i<3) {
    		   System.out.printf("%d��° ���� : ",i+1);
    		   numbers[i] = scanner.nextInt();
    		   for (int j = 0; j < i; j++) {
    	              if (numbers[i] == numbers[j]) {
    	            	  System.out.println("���� ��ȣ�Դϴ�!");
    	                  i--; //point
    	                  break;
    	              }
    	           }
    	   }else {
           numbers[i] = r.nextInt(45)+1; //���� ����
          for (int j = 0; j < i; j++) {
              if (numbers[i] == numbers[j]) {
                  i--; //point
                  break;
              }
           }
    	   }
        }
   }
   
}
 