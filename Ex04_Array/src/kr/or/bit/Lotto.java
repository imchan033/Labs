package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

//설계도
//Lotto lotto = new Lotto();
//lotto.selectLottoNumber(); >> 메뉴 제공
//1 값을 입력 >> selectBasicNumber() 함수 호출 (로또번호 추출) >> 출력
//2 값을 입력 >> 화면에 출력...
//3 값을 입력 >> 프로그램 종료

public class Lotto {
	private Scanner scanner;
	private Random r; //r.nextInt(45)+1 (1~45)
	private int[] numbers;
					//static{}, {}초기자
	public Lotto() {//특수한 목적:member field 초기화(생성자 함수), constructor
		scanner = new Scanner(System.in); //초기화(참조 변수 주소값을 갖는것)
		r = new Random();
		numbers = new int[6];
	}
	//함수하나당 기능 하나
	 
	public void selectLottoNumber() {
		System.out.println("****로또번호****");
		System.out.println("1. 로또번호 추출");
		System.out.println("2. 프로그램 종료");
		System.out.println("**************");
		
		do {
			int menu = Integer.parseInt(scanner.nextLine());
			switch(menu) {
				case 1 : selectBasicLottoNumber(r, numbers);
					break;
				case 2 : System.out.println("프래그램을 종료합니다.");
					System.exit(0);
				default: System.out.println("번호를 잘못 입력하셨습니다.");
					break;
			}selectLottoNumber();
		} while(true);
				
	}
	private void selectBasicLottoNumber(Random r, int[] numbers) {
		//실로또 번호 추출하고 중복값 배제 처리 하는 함수
		
		//난수 저장
		for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(45)+1; 
           for (int j = 0; j < i; j++)
               if (numbers[i] == numbers[j]) {
                   i--; //point
                   break;
               }
			}
		//번호 정렬
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
		//출력
		for(int i=0 ; i<numbers.length ; i++) {
			System.out.print(numbers[i]+"\t");			
		}
		System.out.println();
	}
	
	//검증(기능 함수) (6개의 합을 구해서 6으로 나눈 평균의 범위가 5보다 크거나 같고
	//				10보다 작거나 같으면 번호 추출)
	//(avg>=5 && avg<=10) ... 이 범위가 아니면 재추출하겠다
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
