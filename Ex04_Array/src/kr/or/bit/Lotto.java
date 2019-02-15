package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

//���赵
//Lotto lotto = new Lotto();
//lotto.selectLottoNumber(); >> �޴� ����
//1 ���� �Է� >> selectBasicNumber() �Լ� ȣ�� (�ζǹ�ȣ ����) >> ���
//2 ���� �Է� >> ȭ�鿡 ���...
//3 ���� �Է� >> ���α׷� ����

public class Lotto {
	private Scanner scanner;
	private Random r; //r.nextInt(45)+1 (1~45)
	private int[] numbers;
					//static{}, {}�ʱ���
	public Lotto() {//Ư���� ����:member field �ʱ�ȭ(������ �Լ�), constructor
		scanner = new Scanner(System.in); //�ʱ�ȭ(���� ���� �ּҰ��� ���°�)
		r = new Random();
		numbers = new int[6];
	}
	//�Լ��ϳ��� ��� �ϳ�
	 
	public void selectLottoNumber() {
		System.out.println("****�ζǹ�ȣ****");
		System.out.println("1. �ζǹ�ȣ ����");
		System.out.println("2. ���α׷� ����");
		System.out.println("**************");
		
		do {
			int menu = Integer.parseInt(scanner.nextLine());
			switch(menu) {
				case 1 : selectBasicLottoNumber(r, numbers);
					break;
				case 2 : System.out.println("�����׷��� �����մϴ�.");
					System.exit(0);
				default: System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					break;
			}selectLottoNumber();
		} while(true);
				
	}
	private void selectBasicLottoNumber(Random r, int[] numbers) {
		//�Ƿζ� ��ȣ �����ϰ� �ߺ��� ���� ó�� �ϴ� �Լ�
		
		//���� ����
		for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(45)+1; 
           for (int j = 0; j < i; j++)
               if (numbers[i] == numbers[j]) {
                   i--; //point
                   break;
               }
			}
		//��ȣ ����
		int temp = 0;
		for(int i=1; i<numbers.length; i++) {
			for(int j=0; j<numbers.length-i ; j++) {
				if(numbers[j]>numbers[j+1]) {
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}	
			}
		}
		//���
		for(int i=0 ; i<numbers.length ; i++) {
			System.out.print(numbers[i]+"\t");			
		}
		System.out.println();
	}
	
	//����(��� �Լ�) (6���� ���� ���ؼ� 6���� ���� ����� ������ 5���� ũ�ų� ����
	//				10���� �۰ų� ������ ��ȣ ����)
	//(avg>=5 && avg<=10) ... �� ������ �ƴϸ� �������ϰڴ�
	/*
	private boolean checkAverage(int[] numbers) {
		int sum = 0;
		int average = 0;
		for(int i=0 ; i<numbers.length ; i++) {
			sum += numbers[i];
		}
		average = sum/numbers.length;
		return (average >= 5 && average <= 10); //5,6,7,8,9,10 >> true
	}
	*/
	
}
