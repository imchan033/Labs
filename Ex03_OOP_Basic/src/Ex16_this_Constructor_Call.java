/*
 2. this(��ü >> �����ڸ� ȣ���ϴ� this)

 ��Ģ : �����ڴ� ��ü ������ �Ѱ��� ȣ��
 ���������� this ����ϸ� �������� ������ �Լ��� ȣ�� ����
 
 �����ھȿ� �ִ� �ڵ尡 �ݺ������� ���
 
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
		this("red", "auto", 4); //�ڱ��ڽ��� ȣ��(������ �Լ� ȣ�� ����)
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
�ڵ��� ���� ��� (�ڵ��� �ǸŽ� �⺻ �ɼ�)
 */
class Zcar2{
	String color;
	String geartype;
	int door;
	
	Zcar2(){
		this("red", 2);
		System.out.println("default constructor");
	}
	Zcar2(String color, int door){ //������ ����� ���� ���� ���ð���
		this(color,"auto",door);
		System.out.println("overloading constructor parameter2��");
	}
	Zcar2(String color, String geartype, int door){//������ ����, ���,�� ���� ���ð���
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading constructor parameter3��");
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
