package kr.or.bit;
/*
책은 책이름과 가격을 가지고 있다.
책이 출판되면 반드시 책은 책의 이름과 가격을 가지고 있어야 한다.
책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고 출판된 이 후에는 수정할 수 없다
책이름과 가격정보는 각각 정보를 읽을 수 있다 (getter)
 */

public class Book2 {
	private String name;
	private int price;
	
	//public Book2() {} 요구사항x : 책이 출판되면 [반드시] 책은 책의 이름과 가격을 가지고 있어야 한다.
	//					문법적으로 써도 문제는x
	
	public Book2(String name,int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public void bookInfo() {
		System.out.println("책 이름 : "+this.name+"\n책 가격 : "+this.price);
	}

}
