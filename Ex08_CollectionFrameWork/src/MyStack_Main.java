import kr.or.bit.MyStack;

public class MyStack_Main {

	public static void main(String[] args) {
		MyStack my = new MyStack(5);

		System.out.println(my.isEmpty()); //����ִ�? true
		my.push(50);
		my.push("�ź���");
		my.push(500);
		my.push("�ڵ���");
		my.push(10000);
		my.push("A"); 					  //������ �����ϴ�.
		System.out.println(my.isFull()); 
		my.pop();
		my.pop();
		my.pop();
		my.pop();
		my.pop();
		System.out.println(my.isEmpty());
		
		//�ּ��� stack �ϰ� queue ������ �ڵ�� ������ ����

	}

}
