package kr.or.bit;
import java.util.*;

class VendingMachine {
	Scanner scanner;
	String manufacturer;  // 제조사
	String model;		  // 모델명
	
	int receivedMoney;	  				// 넣은 금액
	String[] selectCigarette; 			// 담배선택버튼
	int[] inventory;					// 담배 잔고 관리
	static int changeAmount;            // 잔돈잔액 (일단 이렇게)
	//static int totalCount=0;          // 총 담배 판매 갯수
	
	Cigarettes[] cigar;		// 담배의 종류가 여러가지이므로 배열 선언
	
	public VendingMachine(){
		Scanner scanner = new Scanner(System.in);
		manufacturer = "자판기코리아";
		model = "담배자판기";
		changeAmount = 100000;   //잔돈 10만원 입력
		
		cigar = new Cigarettes[]{new Cigarettes("필립모리스", "말보로", 4700),
				new Cigarettes("BAT", "던힐", 4500),
				new Cigarettes("필립모리스", "팔리아멘트", 4300),
				new Cigarettes("KT&G", "레종", 5000),
				new Cigarettes("KT&G", "에쎄", 4200)};
		
		selectCigarette = new String[cigar.length];
		inventory = new int[cigar.length];
		
		for(int i=0 ; i<cigar.length ; i++) {//담배 수량 30개, 담배선택버튼 X 초기화
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
	
	//담배메뉴출력
	void displayMenu() {  
		for (int i=0; i<this.cigar.length; i++) {
			// 재고가 있으면서 잔금보다 작은 담배 버튼 on
			if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0) {
				//selectCigarette[i]="o";
				System.out.printf((1+i)+". %s (%d원) [o]\n",
						cigar[i].cigarName,cigar[i].cigarPrice);
			}else {
				System.out.printf((1+i)+". %s (%d원) [x]\n",
						cigar[i].cigarName,cigar[i].cigarPrice);
			}
		}System.out.println("투입된 금액 : "+receivedMoney+"원");	
	}
	
	
	void adminMenu() {
		while(true) {
			System.out.println("=========================");
			System.out.println("======  관리자 모드 메뉴 ======");
			System.out.println(" 1. 담배재고 확인                   ");
			System.out.println(" 2. 담배채우기                      ");
			System.out.println(" 3. 잔돈재고 확인                   ");
			System.out.println(" 4. 잔돈채우기                      ");
			System.out.println(" 5. 종료                            ");
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
	
	public boolean isAdult() {	// 성인확인
		Scanner scanner = new Scanner(System.in);
		System.out.println("성인인증이 필요합니다. 신분증을 입력해주세요!!");
		int age = Integer.parseInt(scanner.nextLine());
		boolean adult;
		if(age<=2000) {
			System.out.println("성인 인증이 완료되었습니다.");
			adult = true;
		} else if (age==9999) {
			adminMenu();
			adult =false;
		} else {
			System.out.println("미성년자는 판매할 수 없습니다.");
			adult = false;
		}
		return adult;
	}
	
	
	public void changeReturn() {	// 반환될 잔돈
		System.out.println(receivedMoney+"배출");//잔돈배출
		changeAmount-=receivedMoney;
		receivedMoney=0; //돈0으로 초기화
	}
	
	/*
	public int availableCigarettes() {	// 담배수량확인 (IoT가 있어야 가능~)
		return 0;
	}
	*/
	
	
	public void selectCigarettes() { // 담배 선택
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("(반환레버[0번])담배 번호를 선택해주세요>");
			int number = Integer.parseInt(scanner.nextLine());
			System.out.println();
			//int number = scanner.nextInt();
			if (number == 0) { // 0을 누르면 잔돈 반환
				changeReturn();
				return;
				
			} else if (number < 0 || number > cigar.length) { // 잘못된 번호 입력시
				System.out.println("번호를 다시 입력해주세요");
			} else {
				if (receivedMoney >= cigar[number].cigarPrice) {
					receivedMoney -= cigar[number].cigarPrice; // 받은돈에서 담배값차감
					inventory[number]--; // 담배 개수 -1
					displayMenu();
					System.out.println(cigar[number].cigarName + "배출!");// 담배배출
				} else {
					displayMenu();
					System.out.println("돈을 더 넣어 주세요!");
				}
			}
		}
	}

	public void payMenu() {	// payAmount는 금액
		Scanner scanner = new Scanner(System.in);
		System.out.println("돈을 넣어주세요!");
		receivedMoney = Integer.parseInt(scanner.nextLine());
	}

//	public void requestOrder() {
//		System.out.println("전품목 매진 판매중지");
//		System.exit(0);
//	}
	
	/*
	public void sellCount() { // 누적판매개수
		totalCount++;
	}
	*/
	
	/*
	public boolean requestChange() { // 잔돈이 떨어지면 관리자 호출?
		return false;
	}
	*/
	public void checkInventory() {
		for (int i=0; i<inventory.length; i++) {
			System.out.printf("%s : %d \n",cigar[i].cigarName, inventory[i]);
		}
	}
	
	public void fillInventory() {
		System.out.println("담배가 채워졌습니다.");
		for(int i=0 ; i<cigar.length ; i++) {
			inventory[i]=30;
			System.out.printf("%s : %d \n",cigar[i].cigarName, inventory[i]);
		}
		
	}
	
	public void checkChange() {
		System.out.printf("잔돈 : %d \n", this.changeAmount);		
	}

	public void fillChange() {
		this.changeAmount = 100000;		
		System.out.printf("잔돈을 %d원으로 충전했습니다.\n", this.changeAmount);
	}

}

class Cigarettes {


    public String cigarName;//담배 이름
    public int cigarPrice;// 가격
   // public int cigarNum;// 수량
    
    

     public Cigarettes(String maker, String cigarName, int cigarPrice) {

         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         //this.cigarNum = cigarNum;
     }
     /*
     public void dailySelling(int totalCount) {
		 int sellingSum = 0;
		 sellingSum = totalCount*4500;
		 System.out.println("당일 누적 판매개수:  "+ totalCount+"당일 누적 판매금액:                 "+ sellingSum);
	 }
	 */

}

public class Hw04_VendingMachine {
	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		
		vm.operation();

	}

}
    	 




