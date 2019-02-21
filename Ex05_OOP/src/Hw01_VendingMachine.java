import java.util.*;

class VendingMachine {
	Scanner scanner;
	String manufacturer;  // 제조사
	String model;		  // 모델명
	
	int receivedMoney;	  // 넣은 금액
	
	//boolean isPayback;	  				// 반환레버상태 : 0인 경우 잔돈 또는 원금 반환
	
	String[] selectCigarette; 			// 담배선택버튼
	int[] inventory;					// 담배 잔고 관리
	int changeAmount;                  	// 잔돈잔액 (일단 이렇게)
	//static int totalCount=0;          	// 총 담배 판매 갯수
	
	Cigarettes[] cigar;		// 담배의 종류가 여러가지이므로 배열 선언
	
	public VendingMachine(){
		scanner = new Scanner(System.in);
		manufacturer = "자판기코리아";
		model = "담배자판기";
		changeAmount = 100000;   //잔돈 10만원 입력
		
		cigar = new Cigarettes[]{new Cigarettes("필립모리스", "말보로", 4500),
				new Cigarettes("BAT", "던힐", 4500),
				new Cigarettes("필립모리스", "팔리아멘트", 4500),
				new Cigarettes("KT&G", "레종", 4500),
				new Cigarettes("KT&G", "에쎄", 4500)};
		
		selectCigarette = new String[cigar.length];
		inventory = new int[cigar.length];
		
		for(int i=0 ; i<cigar.length ; i++) {//담배 수량 30개, 담배선택버튼 X 초기화
			inventory[i]=30;
			selectCigarette[i]="X";
		}
		
	}
	public void operation() {
		System.out.println("*****담배자판기******");
		
		while(true) {
			if(isAdult()==true) {
				payMenu();
				selectCigarettes();
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	//담배메뉴출력
	void displayMenu() {  
		for (int i=0; i<this.cigar.length; i++) {
			// 재고가 있으면서 잔금보다 작은 담배 버튼 on
			if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0) {
				selectCigarette[i]="o";
			}else {
				selectCigarette[i]="x";
			}
			//출력
			System.out.printf((1+i)+". %s (%d원) [%s]\n",
					cigar[i].cigarName,cigar[i].cigarPrice,selectCigarette[i]);
		}System.out.println("투입된 금액 : "+receivedMoney+"원");	
	}
	 boolean checkChange() {
		 return false;
	 }
	public boolean isAdult() {	// 성인확인
		System.out.println("성인인증이 필요합니다. 신분증을 입력해주세요!!");
		int age = scanner.nextInt();
		boolean adult;
		if(age<=2000) {
			System.out.println("성인 인증이 완료되었습니다.");
			adult = true;
		}else {
			System.out.println("미성년자는 판매할 수 없습니다.");
			adult = false;
		}
		return adult;
	}
	public void payRemains() {	// 반환될 잔돈
		System.out.println(receivedMoney+"배출");//잔돈배출
		receivedMoney=0; //돈0으로 초기화
	}
	
	/*
	public int availableCigarettes() {	// 담배수량확인 (IoT가 있어야 가능~)
		return 0;
	}
	*/
	
	
	public void selectCigarettes() { // *번째 담배를 선택
		//while (true) {
			System.out.print("담배 번호를 선택해주세요>");
			int number = scanner.nextInt() - 1;
			receivedMoney -= cigar[number].cigarPrice; // 받은돈에서 담배값차감
			inventory[number]--; // 담배 개수 -1
			System.out.println(cigar[number].cigarName + "배출!"); // 담배배출
		//}
	}
	
	public void payMenu() {	// payAmount는 금액
		System.out.println("돈을 넣어주세요!");
		receivedMoney = scanner.nextInt();
//		// 잔돈이 10000원 이상이면 판매, 이하이면 판매중지
//		if(changeAmount>10000) {
// //			판매가능한 담배버튼의 불이 들어온다
//			for (int i=0; i<this.cigar.length; i++) {
//				// 재고가 있으면서 잔금보다 작은 담배 버튼 on
//				if(this.receivedMoney>=this.cigar[i].cigarPrice && this.inventory[i]>0)
//					selectCigarette[i]="o";
//			}//담배 메뉴 출력
//		} else {
//			System.out.println("잔돈부족으로 판매중지. 잔돈을 반환합니다.");
//			payRemains();
//		}


	}

	/*
	public boolean requestOrder() { // 관리자 호출 : 담배재고중 한 종류라도 떨어지면 호출??
		return false;
	}
	*/
	
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
	
}

class Cigarettes {

    public String maker;//제조사
    public String cigarName;//담배 이름
    public int cigarPrice;// 가격
   // public int cigarNum;// 수량
    
    

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
		 System.out.println("당일 누적 판매개수:  "+ totalCount+"당일 누적 판매금액:                 "+ sellingSum);
	 }
	 */

}

public class Hw01_VendingMachine {
	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		
		vm.displayMenu();

	}

}
    	 



