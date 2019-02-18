/*
 2. this(객체 >> 생성자를 호출하는 this)

 원칙 : 생성자는 객체 생성시 한개만 호출
 예외적으로 this 사용하면 여러개의 생성자 함수를 호출 가능
 
 생성자안에 있는 코드가 반복적으로 사용
 
 */
class Zcar{
	String color;
	String geartype;
	int door;
	
	Zcar(){
		//this.color = "red";
		//this.geartype = "auto";
		//this.door = 4;
		
		//new Zcar()
		//    this()
		this("red", "auto", 4); //자기자신을 호출(생성자 함수 호출 가능)
		System.out.println("default constructor");
	}
	
	Zcar(String color, String geartype, int door){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor");
	}
	void print() {
		System.out.println(this.color + ","+this.geartype+","+this.door);
	}
}

/*
자동차 영업 사원 (자동차 판매시 기본 옵션)
 */
class Zcar2{
	String color;
	String geartype;
	int door;
	
	Zcar2(){
		this("red", 2);
		System.out.println("default constructor");
	}
	Zcar2(String color, int door){ //차량의 색상과 문의 개수 선택가능
		this(color,"auto",door);
		System.out.println("overloading constructor parameter2개");
	}
	Zcar2(String color, String geartype, int door){//차량의 색상, 기어,문 개수 선택가능
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor parameter3개");
	}
	void print() {
		System.out.println(this.color + ","+this.geartype+","+this.door);
	}
}


public class Ex16_this_Constructor_Call {

	public static void main(String[] args) {
		Zcar z = new Zcar(); //default
		z.print();
		
		Zcar2 car = new Zcar2();
		car.print();
		
		Zcar2 car2 = new Zcar2("gold", 4);
		car2.print();
		
		Zcar2 car3 = new Zcar2("black",	"manual",5);
		car3.print();
		
		//Zcar z2 = new Zcar("black", "stick",2); //overloading
		//z2.print();

	}

}
