import java.util.Stack;
import kr.or.bit.Coin;

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		//LIFO (last in first out)
		//Stack : collection Framework �����ϴ� Ŭ����
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		System.out.println(stack.pop()); //B
		System.out.println(stack.pop()); //A
		//System.out.println(stack.pop()); 
		//java.util.EmptyStackException ���ܹ߻�!
		System.out.println(stack.isEmpty()); //true (����ִ�?����)
		
		
		//���� ���̽�
		//stack �ڷᱸ�� ���ϴ� ����...
		Stack<Coin> coinBox = new Stack<Coin>();
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		
		//System.out.println(coinBox.pop().getValue());
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("���� ���� : "+coin.getValue()+"��");
		}
		
		
		
	}
}
