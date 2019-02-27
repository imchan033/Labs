import java.util.Vector;

/*
 Collection FrameWork
 [�ټ��� �����͸� �ٷ�� [ǥ��ȭ]�� [�������̽�]�� [����]�ϰ� �ִ� Ŭ���� ����]
 
        Collection
 	        |
 List(���)   Set(���)				Map(�������̽�)
     |           |                        |
  Vector       HashSet			      [HashMap]
[ArrayList]    TreeSet

List interface [���� ���ÿ�]
:����(0), �ߺ�(0) -> ���������� ������ ���� -> Array[0][1][2]...

 1. vector(������) -> ����ȭ(��Ƽ ������) -> Lock ���� (default) -> ������ ��ȣ
 2. ArrayList(�Ź���) -> ����ȭ(��Ƽ ������) -> Lock ���� (x) -> �ʿ信 ���� lock -> ����
 ex)����ȭ
 �Ѱ� ������� ȭ��� �ϳ� (100 ���� ���ÿ�) >> Lock �����ϰ�...
 �Ѱ� ������� ����� ���� (100�κ�)(100���� ���ÿ�) >> Lock(x) >> ����
 
 Array (�迭) : �����迭(ũ�Ⱑ �����Ǿ� �ִ�)
 ���� 10�� �����ϸ� ���� ����Ұ�
 int[] arr = new int[10];
 int[] arr = {10,20,30};
 
 Array(����, ����)
 1. �迭�� ũ�Ⱑ �����Ǿ��ִ� : Car[] cars = {new Car(),new Car()};//�� 2�� ...
 2. �迭�� ���� : index(÷��) : cars[0], cars[0].color
 3. �ʱ� ������ ũ�� ���� �Ұ�
 
 List �������̽� ������ Ŭ����(Vector, ArrayList) : ����
 1. �迭�� ũ�⸦ ���� Ȯ��, ��� ���� -> �迭�� ���Ҵ�(���ο�迭) -> ���� ���� �ڵ� ���� �ʾƿ�
 2. ������ ����(Array), ����(index), �ߺ��� ���
 3. ������ ���� ���� (Array ���)
 4. List �������̽��� ������ Ŭ���� (new �� ���ؼ� ��ü�� ���� ���)
 5. ���� Ŭ����(ArrayList)�� ������ ������ Ÿ�� : ���� Ÿ�� : Object
 	Object[] arr = new Object[10]
 	���� : ��� Ÿ���� �θ� Ÿ�� (int, Car, String ...) ��� �ڷ� ���� ����
 	���� : Object�� downCasting ���
 5���� ������ �غ��ϱ� ���� ��� ���ʸ�(Ÿ�� ����) ���� ���� �ذ�
 
 
 
 

 */
public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("�ʱ� default �뷮 : "+v.capacity()); //10 default
		v.add("AA"); //[0]
		v.add("BB"); //[1]
		v.add("AA"); //[2]
		v.add(100);  //[3]
		System.out.println(v);			  //[AA, BB, AA, 100] ������ ��� ���
		System.out.println(v.toString()); //toString() �����Ǿ� �ִ�
		
		//Array >> length() >> Car[index]
		for(int i=0 ; i<v.size(); i++) {  //size() �Լ� Ȱ��
			System.out.println(v.get(i)); //get �Լ��� return type : object
		}
		for(Object obj : v) {  			  //������ for��
			System.out.println(obj);      //���� : Object��� ���� ū Ÿ���� ���... add(), get()
		}
		
		Vector<String> v2 = new Vector<String>(); //String Ÿ���� ���� ���������
		v2.add("Hello");
		v2.add("World");
		
		for(String str : v2) {
			System.out.println(str);
		}
		
		System.out.println(v2);
		System.out.println(v2.toString());
		System.out.println(v2.get(1));
		System.out.println("size : "+ v2.size());
		System.out.println("Capacity : "+ v2.capacity());
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity()); //10
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println(v3.capacity()); //20
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A"); //10->20->40
		System.out.println("size : "+ v3.size());
		System.out.println("capacity : "+v3.capacity());
		System.out.println(v3);
		
	}

}





















