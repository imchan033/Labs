import kr.or.bit.MyStack;

public class MyStack_Main {

	public static void main(String[] args) {
		MyStack my = new MyStack(5);

		System.out.println(my.isEmpty()); //비어있니? true
		my.push(50);
		my.push("신분증");
		my.push(500);
		my.push("핸드폰");
		my.push(10000);
		my.push("A"); 					  //공간이 없습니다.
		System.out.println(my.isFull()); 
		my.pop();
		my.pop();
		my.pop();
		my.pop();
		my.pop();
		System.out.println(my.isEmpty());
		
		//최소한 stack 하고 queue 정도의 코드는 구현해 보자

	}

}
