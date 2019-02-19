class VendingMachine {
	String manufacturer;  // 제조사
	String model;		  // 모델명
	
	int receivedMoney;	  // 넣은 금액
	
	boolean isPayback;	  				// 반환레버상태 : 0인 경우 잔돈 또는 원금 반환	
	boolean[] selectCigarette; 			//담배선택버튼
	int changeAmount;                  	// 잔돈잔액 (일단 이렇게)
	static int totalCount=0;          	// 총 담배 판매 갯수
	
	Cigarettes[] cigar;		// 담배의 종류가 여러가지이므로 배열 선언
	
	
	public boolean isAdult() {	// 성인확인
		return false;
	}
	public int payRemains() {	// 반환될 잔돈
		return 0;
	}
	
	public int availableCigarettes() {	// 담배수량확인 (IoT가 있어야 가능~)
		return 0;
	}
	
	public void selectCigarettes(int select) { // *번째 담배를 선택
		System.out.println("선택");
		System.out.println("잔돈에서 담배금액 차감");
		System.out.println("잔돈이 담배금액보다 많을 경우 해당 담배선택버튼에 불이 켜짐");
		sellCount();
	}
	
	public int payMenu(int payAmount, int payMethod) {	// payhAmount는 금액, payMethod : 예를들면 1: 현금 2: 카드 
		return receivedMoney + payAmount;
	}

	
	public boolean requestOrder() { // 관리자 호출 : 담배재고중 한 종류라도 떨어지면 호출??
		return false;
	}
	
	public void sellCount() { // 누적판매개수
		totalCount++;
	}
	
	public boolean requestChange() { // 잔돈이 떨어지면 관리자 호출?
		return false;
	}
	
}

class Cigarettes {

    public String maker;//제조사
    public String cigarName;//담배 이름
    public int cigarPrice;// 가격
    public int cigarNum;// 수량

     public Cigarettes(String maker, String cigarName, int cigarPrice,int cigarNum ) {
         this.maker = maker;
         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         this.cigarNum = cigarNum;
     }
     public void dailySelling(int totalCount) {
		 int sellingSum = 0;
		 sellingSum = totalCount*4500;
		 System.out.println("당일 누적 판매개수:  "+ totalCount+"당일 누적 판매금액:                 "+ sellingSum);
	 }

}

public class Hw01_VendingMachine {

	public static void main(String[] args) {
		

	}

}
    	 



