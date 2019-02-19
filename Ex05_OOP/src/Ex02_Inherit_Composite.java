/*
 ���Ǽ��� ... ���赵�� ������ ... (������)
 
 �������� ���赵 �ۼ���...(���ü�)
 
 ������
 ��Ӱ��� (is ~ a : ���) �� ~�̴� (�θ����� �ڷ�)
 >>���� �����̴� (o)
 >>�簢���� �����̴� (o)
 
 ���԰��� (has ~ a : ����) �� ~�� ������ �ִ�
 >>���� ������ ������ �ִ�(x)
 >>�簢���� ������ ������ �ִ� (x)
-----------------------------------------------
 ��Ŭ����

 ����Ŭ����

 >>��� (�� extends ����)
 
 ���� ���̴�(x)
 ���� ���� (x,y)
 ���� ���� ������ �ִ�(o) (has ~ a) ���԰���
 >>class �� { �� ������; }
 
 ���� , ��
 ������ ���̴� is~a (x)
 ������ ���� ������ �ִ� has~a (o)
 class ����{}
 class ��{} 

 class ���� { �� gun; }
----------------------------------------------
 ���� ���
 ��, �簢��, �ﰢ���� ����� ���踦 �ۼ��ϰ� �;��
 �� : ������ ������, �׸���, ����
 �ﰢ�� : ������ ��, �׸���, ����
 �簢�� : �װ��� ��, �׸���, ����
 �� : x,y
 
 ����
 ���� �����̴�
 �ﰢ���� �����̴�
 �簢���� �����̴�
 
 ���� : (�Ϲ�ȭ, �߻�ȭ) �и� : ����, �׸���
 �� (��üȭ, Ư��ȭ) -> ��, ������
 
 �� ����(x,y)
 ���� ���̴�(x)
 �ﰢ���� ���̴�(x)
 
 ���� ���� ������ �ִ�(o)
 �ﰢ���� ���� ������ �ִ�(o)
 �簢���� ���� ������ �ִ�(o)
 (has~a)
 
 �Ϲ�ȭ,�߻�ȭ(����и�) : shape(����, �׸���)
 					   point(x, y)
 class Shape{}
 class Point{}
 
 ��üȭ, Ư��ȭ(circle, triangle)
 
 */

//�߻�ȭ, �Ϲ�ȭ
class Shape{
	String color = "gold";
	void draw() {
		System.out.println("������ �׸���");
	}
}

class Point{
	int x;
	int y;
	Point(){
		//this.x = 1;
		//this.y = 2;
		this(1,2);
	}
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}

//���� ���弼��(���� : ������ �������� �������ִ�
//���� �����̴� (is~a) extends
//���� ���� ������ �ִ� (has~a) ��������

//���� Ư����,��ü�� : ������
class Circle extends Shape{
	Point center; //member field(��ǰ) has~a
	int r;		  //member field(Ư����, ��üȭ)
	
	public Circle() {
		this.center = new Point(5,8);
		this.r = 10;
	}
	public Circle(Point center,int r) {
		this.center = center;
		this.r = r;
	}
}
//���� 1)
//�ﰢ�� Ŭ���� ���弼��
//���� : �ﰢ���� 3���� ���� ���� �׸��� �׸��ٶ�� ����� ������ �ִ�
//Shape, Point Ȱ���ؼ� �۾� �ϼ���
//3���� (x,y), (x,y), (x,y) �ǹ�
//default �ﰢ���� �׸� �� �ְ� 3���� ��ǥ���� �޾Ƽ� �׸��� �׸� �� �� �ִ�
class Triangle extends Shape{
	Point x,y,z;
	
	public Triangle(){
		this(new Point(1,2),new Point(2,3),new Point(3,4));
	}
	public Triangle(Point x,Point y,Point z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void trianglePoint() {
		System.out.printf("x : (%d,%d)\n",x.x,x.y);
		System.out.printf("y : (%d,%d)\n",y.x,y.y);
		System.out.printf("z : (%d,%d)\n",z.x,z.y);
	}
}
class Triangle2 extends Shape{
	Point[] pointarray; //����Ÿ�� (�ʱ�ȭ : �ּҰ�...)
	public Triangle2() {
		this(new Point[] {new Point(1,2),new Point(3,4),new Point(5,6)});
	}
	public Triangle2(Point[] pointarray) {
		this.pointarray =pointarray;
	}
}
class Ractangle extends Shape{
	Point[] pointarray;
	
	public Ractangle() {
		this(new Point[] {new Point(1,2),new Point(2,3),new Point(3,4),new Point(4,5)});
	}
	public Ractangle(Point[] pointarray) {
		this.pointarray = pointarray;
	}
	public void ractanglePoint() {
		
	}
}
public class Ex02_Inherit_Composite {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		System.out.println(c.color);
		System.out.println(c.r);
		System.out.println(c.center.x);
		System.out.println(c.center.y);
		
//		Point point = new Point(10, 15);
//		Circle c2 = new Circle(point,20);
		Circle c2 = new Circle(new Point(4,8),5);
		System.out.println(c2.color);
		System.out.println(c2.r);
		System.out.println(c2.center.x);
		System.out.println(c2.center.y);
		c2.draw();
		
		Triangle t = new Triangle();
		t.trianglePoint();
		t.draw();
	}
}
