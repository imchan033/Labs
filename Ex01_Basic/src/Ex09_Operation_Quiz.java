import java.util.*;

public class Ex09_Operation_Quiz {

	public static void main(String[] args) {
		/*
		String str = "+";
		if(str.equals("+")) {
			System.out.println(str);
		}
		 ���ڿ��� �񱳴� == �� �ƴϰ� equals() �� ����Ѵ�
		*/
		int number1,number2=0;
		int result=0;
		String cal = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">�Է°�:");
		number1 = Integer.parseInt(sc.nextLine());  //sc.nextLine()
		System.out.println(">�Է°�(��ȣ):");
		cal = sc.nextLine();
		System.out.println(">�Է°�:");
		number2 = Integer.parseInt(sc.nextLine());
		
		if(cal.equals("+")) {
			result = number1 + number2;
			
		}else if(cal.equals("-")) {
			result = number1 - number2;
			
		}else if(cal.equals("*")) {
			result = number1 * number2;
			
		}else if(cal.equals("/")) {
			result = number1 / number2;
			
		}else {
			System.out.println("��ȣ�� �߸� �Է� �߽��ϴ�.");
			//System.exit(0);
			//key point (���⼭�� main �Լ�)
			//return Ű���� : [�Լ�����]�� ������ > main �Լ� Ż�� > ����
			return;
		}System.out.printf(">�����: %d %s %d = %d",number1,cal,number2,result);
	}

}
