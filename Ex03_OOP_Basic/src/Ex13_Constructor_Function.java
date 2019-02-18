import kr.or.bit.*;

/*
 int[] arr = new int[5] -> default��
 arr[0] = 100; -> �ʱ�ȭ
 ������ �Լ� (constructor) : �ʱ�ȭ (member field) �Լ�
 1. Ư���� ������ ������ �Լ�(�ʱ�ȭ)
 2. �ʱ�ȭ(instance variable : member field)
 
 �Ϲ��Լ��� �ٸ���
 1. �Լ��� �̸��� ����(class �̸��� (�ݵ��)����)
 2. ������ �Լ��� : return type(x), void(x) : default void
 	why : �������� ... �Լ��� ��ü ������ ���ÿ� ȣ�� ... ���� �ѱ� ���� ����
 
 ���� : �����Ǵ� ��ü���� �ٸ� �ʱⰪ�� ������ ������

 ������ �Լ� : overloading �� �����ϴ� (param �� ������ Ÿ���� �޸��ؼ�)
 
 class Car{ int door; Car(){door = 10;} }
 ���� : Car c = new Car();
 	   1. Stack c ���� > default > null
 	   2. Heap Car ��ü�� ���� > ���� > �����ȿ� memberfield �ε� >
 	      > ������ �Լ� ȣ�� (�ε��� member field �ʱ�ȭ)
 	   3. class ������ default �����ڴ� ��������
 	   	  (���� ���� �������� �ʾƵ� �����Ϸ��� �˾Ƽ� �����մϴ�)
 	TIP) ������ �Լ��� overloading ���� ������ ���� ���x
 */
class Car{
	String name;
	//����� ���� �������� �ʾƵ�
	//�����Ϸ��� �����ڰ� �ִٰ� ����
	//Car(){} ����(default)
}

class Car2{ 
	String name;
	Car2(){ //default constructor(������ �Լ�)
		System.out.println("���� ������ �Լ�");
		System.out.println("before : "+ name); //null
		name = "pony";
		System.out.println("after : "+ name);  //pony
	}
}

class Car3{
	int number;
	//������� : �ڵ�󿡼� default �����ڴ� �Ϲ������� ����
	Car3(){}
}

class Car4{
	int door;
	int wheel;
	
	Car4(){
		//default
		System.out.println("default");
	}
	Car4(int num){//overloading
		door = num;
		System.out.println("overloading door : "+door);
	}
	Car4(int num, int num2){
		door = num;
		wheel = num2;
		System.out.println("overloading door : "+door);
		System.out.println("overloading wheel : "+wheel);
	}
}
class Apt{
	String color;
	//default ����ϰ� �ʹٸ� �ݵ�� ����
	//Apt2(){ System.out.println("default");}
	
	Apt(String color){
		this.color = color;
	}
}
//1. class ������ overloading �����ڰ� �ϳ��� �����Ѵٸ� default �����ڴ� 
//   �ڵ� �������� �ʴ´�(�����Ϸ��� �ڵ����� ������ �ʴ´�)
//why) ������ (���赵)�� ������ �ο� (���� overloading �� ���� ����ϰ�...)
//     




public class Ex13_Constructor_Function {

	public static void main(String[] args) {
		//Car c = new Car();
		//Car2 c2 = new Car2();
		//Car3 c3 = new Car3();
		Car4 c4 = new Car4(); //default ȣ���ؼ� ��ü ����
		System.out.println();
		Car4 c5 = new Car4(4); //param 1�� ȣ���ؼ� ��ü ����
		System.out.println();
		Car4 c6 = new Car4(2, 4); //param 2�� ȣ���ؼ� ��ü ����
		System.out.println();
		
		Book2 book = new Book2("ȫ�浿��",15000);
		book.bookInfo();
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		
		Book2 book2 = new Book2("����ġ��",20000);
		book2.bookInfo();
		
		Watch a = new Watch(2,3,3);
		a.printTime();
		Watch a2 = new Watch(2,3,33);
		a2.printTime();
	}
}


/*
1. class ������ ������ �Լ� �������� ������ ...(default ������ �ڵ�����)
ex) class Tv{ String name; }

2. class ������ overloading ������ �Լ��� �ϳ��� ����...
****default ������ ��� �� �� ����****(������ ���� ����)
ex) class Tv{ String name; Tv(String n){ name = n } }

3. class ������ default, overloading �� �� ����...(����)
�ʿ信 ���� default�� overloading ��� ���� �ȴ�
ex) class Tv{ String name; Tv(){} Tv(String n){ name = n } }



 */
















