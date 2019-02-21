/*
시나리오(요구사항)
 
 */
class Product{ //전자제품
	int price;
	int bonuspoint;
	
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	
	KtTv(){
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
		
}

class Audio extends Product{
	
	Audio(){
		super(1000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
}

class Notebook extends Product{
	
	Notebook(){
		super(7000);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
	
}

class Buyer{
	int money = 20000;
	int bonuspoint = 0;
	
	/*
	 구매행위 
	 구매행위(잔액 제품의 가격, 포인트 정보 갱신)
	 구매자는 매장에 있는 모든 제품을 구매할 수 있다
	 구매행위를 하는 함수를 구현하세요
	 KtTv, Audio, NoteBook 구매 가능
	 
	 매장에 제품이 1000개 다른 제품이 추가(pos 등록 자동화)
	 물건이 오면 매장에 자동 배치
	 세일 >> 고객 >> 핸드폰 구매
	 kttv, audio, notebook 제외한 997개의 제품이 구매행위 불가
	 **제품이 추가 될 때마다 구매함수 구현해야만...
	 
	 */
	
	//1차 코드
	
//	void kttvbuy(KtTv n ) { //구매(상품정보) //KtTv parameter 로...
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다.^^");
//			return; // 구매 행위에 대한 종료
//		}
//		
//		//실 구매행위
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}
//	void audiobuy(Audio n ) { //구매(상품정보) //KtTv parameter 로...
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다.^^");
//			return; // 구매 행위에 대한 종료
//		}
//		
//		//실 구매행위
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}
//	void notebookbuy(Notebook n ) { //구매(상품정보) //KtTv parameter 로...
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다.^^");
//			return; // 구매 행위에 대한 종료
//		}
//		
//		//실 구매행위
//		this.money -= n.price;
//		this.bonuspoint += n.bonuspoint;
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}
	
	//2차 개선 : 함수명 통일
	//method overloading 사용

	//개선된 코드 (다형성)
	void buyProduct(Product product) {
		if(this.money<product.price) {
			System.out.println("잔액부족!");
		}
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.println("구매한 물건은 : " + product.toString());
	}
	
	
}
public class Ex12_Inherit_KeyPoint {

	public static void main(String[] args) {
//		KtTv tv = new KtTv();
//		System.out.println(tv.toString());
//		System.out.println(tv.price);
//		System.out.println(tv.bonuspoint);
//		
		KtTv tv = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();
		
		Buyer buyer = new Buyer();
//		buyer.kttvbuy(tv);
//		buyer.kttvbuy(tv);
//		buyer.notebookbuy(notebook);
		
		buyer.buyProduct(notebook);
		buyer.buyProduct(tv);
		buyer.buyProduct(audio);
		
	}

}
