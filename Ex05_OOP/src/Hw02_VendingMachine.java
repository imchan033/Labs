import java.util.Arrays;
import java.util.Scanner;

class VendingMachine2 {

	Scanner scanner = new Scanner(System.in);
	String manufacturer;  // 제조사
	String model;		  // 모델명
	
	int receivedMoney;	  // 넣은 금액

	boolean isPayback;	  				// 반환레버상태 : 0인 경우 잔돈 또는 원금 반환	
	//String [] selectCigarette; 			
	//담배선택버튼
	boolean isAdult;
	int changeAmount;                  	// 잔돈잔액 (일단 이렇게)
	static int totalCount=0;          	// 총 담배 판매 갯수
	
	Cigarrettes3[] cigar;		// 담배의 종류가 여러가지이므로 배열 선언
	
	// 생성자 필요

	
	public VendingMachine2(int changeAmount, Cigarrettes3[] cigar) {
		this("LG", "담배자판기011", 0, false, false, changeAmount, cigar );
	}
	
	
	public VendingMachine2(String manufacturer, String model, int receivedMoney, boolean isPayback, boolean isAdult,
			int changeAmount, Cigarrettes3[] cigar) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.receivedMoney = receivedMoney;
		this.isPayback = isPayback;
		this.isAdult = isAdult;
		this.changeAmount = changeAmount;
		this.cigar = cigar;
	}


	public boolean isAdult(boolean isAdult) {	// 성인확인
		return this.isAdult=isAdult;
	}
	
	public void payRemains() {	// 반환될 잔돈
		System.out.printf("잔돈 %d가 반환되었습니다. \n", this.receivedMoney);
		this.changeAmount -= this.receivedMoney;
		this.receivedMoney=0;
	}
	
	public void availableCigarrettes3() {	// 담배수량확인 (IoT가 있어야 가능~)
		System.out.println("담배재고량>>");
		for (int i=0; i<this.cigar.length; i++) {
			System.out.printf("%s [%d] \n",cigar[i].cigarName, cigar[i].cigarNum);
		}

	}
	
	public void selectCigarrettes3(int select) { // *번째 담배를 선택
		System.out.printf("%s가 나왔습니다. \n", this.cigar[select-1].cigarName);
		// 잔돈에서 담배금액 차감
		this.receivedMoney -= this.cigar[select-1].cigarPrice;
		System.out.printf("잔액 >> %d \n", this.receivedMoney);
		// 담배재고 차감
		this.cigar[select-1].cigarNum--;
		
		System.out.println("잔돈이 담배금액보다 많을 경우 해당 담배선택버튼에 불이 켜짐 : 미구현 while문 필요");
		sellCount();
	}
	
	public void payMenu() {	// payAmount는 금액
		System.out.println("돈을 넣어주세요!");
		receivedMoney = scanner.nextInt();
		// 잔돈이 10000원 이상이면 판매, 이하이면 판매중지
		if(checkChange(10000)==true) {
//			판매가능한 담배버튼의 불이 들어온다
			for (int i=0; i<this.cigar.length; i++) {
				// 재고가 있으면서 잔금보다 작은 담배가 출력
				if(this.receivedMoney>=this.cigar[i].cigarPrice && this.cigar[i].cigarNum>0)
				System.out.printf("%d %s [%d] \n",i+1, cigar[i].cigarName, cigar[i].cigarPrice);
			}
		} else {
			System.out.println("잔돈부족으로 판매중지. 잔돈을 반환합니다.");
			payRemains();
		}


	}
	
	public boolean requestOrder() { // 관리자 호출 : 담배재고중 한 종류라도 떨어지면 호출??
		return false;
	}
	
	public void sellCount() { // 판매개수 누적
		totalCount++;
	}
	
	public boolean checkChange(int minimum) { // 잔돈이 떨어지면 판매중지
		boolean result = false;
		if (this.changeAmount>=minimum) {
			result=true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "VendingMachine2 [manufacturer=" + manufacturer + ", model=" + model + ", receivedMoney=" + receivedMoney
				+ ", isPayback=" + isPayback + ", isAdult=" + isAdult + ", changeAmount=" + changeAmount + ", totalCount=" + totalCount + ", cigar="
				+ Arrays.toString(cigar) + "]";
	}
	
}

class Cigarrettes3 {

    public String maker;//제조사
    public String cigarName;//담배 이름
    public int cigarPrice;// 가격
    public int cigarNum;// 수량

     public Cigarrettes3(String maker, String cigarName, int cigarPrice,int cigarNum ) {
         this.maker = maker;
         this.cigarName = cigarName;
         this.cigarPrice= cigarPrice;
         this.cigarNum = cigarNum;
     }
}

public class Hw02_VendingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cigarrettes3[] cigar = new Cigarrettes3[] { new Cigarrettes3("필립모리스", "말보로", 4500, 30)
											, new Cigarrettes3("BAT", "던힐라이트", 4500, 30) 
											, new Cigarrettes3("JPT", "마일드쎄븐", 6000, 30)};

		
		VendingMachine2 machine = new VendingMachine2(100000, cigar);
		
		
		//==== 이하는 추후 method로 변경필요 
		
//		성인인증을 한다
		machine.isAdult(true);
		
		
		System.out.println(machine.toString());
		
//		현금을 넣거나 카드를 결제한다
		//machine.payMenu(6000, 1); // 5000원, 현금
		System.out.println(machine.toString());
		
//		버튼을 누르면 담배가 떨어지고 잔금이 표시된다
		machine.selectCigarrettes3(1);
		System.out.println(machine.toString());
//		더 이상 선택을 안한다면 잔금반환레버를 돌려서 잔금을 받는다. 
		machine.payRemains();
		System.out.println(machine.toString());
		
//      담배수량 확인		
		machine.availableCigarrettes3();

	}

}


