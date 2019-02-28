package kr.or.bit;
//stack �̶�� �ڷᱸ���� ����
//MyStack my = new MyStack(5);

public class MyStack {
	private int top; 			// ���� ���ؿ�(�̵�: Ŀ��)
	private Object[] stackarr;  // �����͸� ���� ����
	private int maxsize;
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;
	}

	//���� empty �ƴ�?
	public boolean isEmpty() {
		return (top==-1);
	}
	
	//���� full �ƴ�?
	public boolean isFull() {
		return (top==maxsize-1);
	}
	
	//���� push
	public void push(Object object) {
		if(top<stackarr.length-1) {
		top++;
		stackarr[top]=object;
		}else {
			System.out.println("������ �����ϴ�");
		}
	}

	//���� pop
	public void pop() {
		if(top>=0) {
			System.out.println("pop : "+stackarr[top]);
			stackarr[top]=null;
			top--;
		}else {
			System.out.println("�������");
		}
	}

}
