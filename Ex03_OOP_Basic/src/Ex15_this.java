/*
this
1. ��ü �ڽ��� ����Ű�� this
���赵���� �̾߱�) �� ������ ��ü�� �����ɰ���?... �����ɰŶ� �����ϰ�
���� �ڿ��� �� ����Ұ�

2. this ��ü �ڽ�(������ ȣ��) :
��Ģ : ��ü ������ ������ �Լ��� �ϳ��� ȣ��
���������� this ����ϸ� �������� ������ ȣ���� ����
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
