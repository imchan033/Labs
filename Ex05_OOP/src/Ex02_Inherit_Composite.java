/*
 현실세계 ... 설계도가 여러장 ... (연관성)
 
 여러개의 설계도 작성시...(관련성)
 
 기준점
 상속관계 (is ~ a : 상속) 은 ~이다 (부모쪽을 뒤로)
 >>원은 도형이다 (o)
 >>사각형은 도형이다 (o)
 
 포함관계 (has ~ a : 포함) 은 ~을 가지고 있다
 >>원은 도형을 가지고 있다(x)
 >>사각형은 도형을 가지고 있다 (x)
-----------------------------------------------
 원클래스

 도형클래스

 >>상속 (원 extends 도형)
 
 원은 점이다(x)
 점의 정의 (x,y)
 원은 점을 가지고 있다(o) (has ~ a) 포함관계
 >>class 원 { 점 변수명; }
 
 경찰 , 총
 경찰은 총이다 is~a (x)
 경찰은 총을 가지고 있다 has~a (o)
 class 경찰{}
 class 총{} 

 class 경찰 { 총 gun; }
----------------------------------------------
 예를 들면
 원, 사각형, 삼각형을 만드는 설계를 작성하고 싶어요
 원 : 한점과 반지름, 그리다, 색상
 삼각형 : 세개의 점, 그리다, 색상
 사각형 : 네개의 점, 그리다, 색상
 점 : x,y
 
 정의
 원은 도형이다
 삼각형은 도형이다
 사각형은 도형이다
 
 도형 : (일반화, 추상화) 분모 : 색상, 그리다
 원 (구체화, 특수화) -> 점, 반지름
 
 점 정의(x,y)
 원은 점이다(x)
 삼각형은 점이다(x)
 
 원은 점을 가지고 있다(o)
 삼각형은 점을 가지고 있다(o)
 사각형은 점을 가지고 있다(o)
 (has~a)
 
 일반화,추상화(공통분모) : shape(색상, 그리다)
 					   point(x, y)
 class Shape{}
 class Point{}
 
 구체화, 특수화(circle, triangle)
 
 */

//추상화, 일반화
class Shape{
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다");
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

//원을 만드세요(정의 : 한점과 반지름을 가지고있다
//원은 도형이다 (is~a) extends
//원은 점을 가지고 있다 (has~a) 참조변수

//원의 특수성,구체성 : 반지름
class Circle extends Shape{
	Point center; //member field(부품) has~a
	int r;		  //member field(특수성, 구체화)
	
	public Circle() {
		this.center = new Point(5,8);
		this.r = 10;
	}
	public Circle(Point center,int r) {
		this.center = center;
		this.r = r;
	}
}
//문제 1)
//삼각형 클래스 만드세요
//정의 : 삼각형은 3개의 점과 색상 그리고 그리다라는 기능을 가지고 있다
//Shape, Point 활용해서 작업 하세요
//3개의 (x,y), (x,y), (x,y) 의미
//default 삼각형을 그릴 수 있고 3개의 좌표값을 받아서 그림을 그릴 수 도 있다
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
	Point[] pointarray; //참조타입 (초기화 : 주소값...)
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
