/*
this
1. 객체 자신을 가르키는 this
설계도에게 이야기) 너 앞으로 객체로 생성될거지?... 생성될거라 가정하고
너의 자원을 좀 명시할게

2. this 객체 자신(생성자 호출) :
원칙 : 객체 생성시 생성자 함수는 하나만 호출
예외적으로 this 사용하면 여러개의 생성자 호출이 가능
 */

class Test6{
	int i;
	int j;
	Test6(){
		
	}
	Test6(int i,int j){
		this.i = i;
		this.j = j;
	}
	public void print() {
		System.out.println(i+" , "+j);
	}
	public void thisPrint() {
		System.out.println(this);
	}
}
class SoCar{
	String color;
	String geartype;
	int door;
	
	SoCar(){
		this.color = "red";
		this.geartype = "auto";
		this.door = 2;
	}
	SoCar(String color,String geartype,int door){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + " / "+this.geartype + " / "+this.door);
	}
}
public class Ex15_this {

	public static void main(String[] args) {
		Test6 t6 = new Test6(100,200);
		t6.print();
		System.out.println("t6 : "+t6);
		t6.thisPrint();
		
		Test6 t7 = new Test6(200, 300);
		
		SoCar so = new SoCar();
		so.print();
		
		SoCar so2 = new SoCar("blue", "auto", 4);
		so2.print();
		
	}

}
