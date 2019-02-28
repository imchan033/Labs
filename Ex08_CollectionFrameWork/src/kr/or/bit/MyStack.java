package kr.or.bit;
//stack 이라는 자료구조를 설계
//MyStack my = new MyStack(5);

public class MyStack {
	private int top; 			// 값이 변해요(이동: 커서)
	private Object[] stackarr;  // 데이터를 담을 공간
	private int maxsize;
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;
	}

	//스택 empty 됐니?
	public boolean isEmpty() {
		return (top==-1);
	}
	
	//스택 full 됐니?
	public boolean isFull() {
		return (top==maxsize-1);
	}
	
	//스택 push
	public void push(Object object) {
		if(top<stackarr.length-1) {
		top++;
		stackarr[top]=object;
		}else {
			System.out.println("공간이 없습니다");
		}
	}

	//스택 pop
	public void pop() {
		if(top>=0) {
			System.out.println("pop : "+stackarr[top]);
			stackarr[top]=null;
			top--;
		}else {
			System.out.println("비어있음");
		}
	}

}
