
public class Ex06_Operation {

	public static void main(String[] args) {
		
		// == ������ (��(value)���ϴ� ������)
		//javascript(===)
		if(10==10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! ����������
		if('A' != 65) { //���� �ʴ�?
			System.out.println("�� ���� ���� �ƴϾ�");
		}else {
			System.out.println("���� ���ε�");
		}//char �� �������� ���´�

		// ***�ϱ����� (POINT)***
		// ���ó�� ���� ������(���׿�����)
		int p = 10;
		int k = -10;
		int result = (p==k)? p : k;
		//? �տ��ִ� ���ǽ��� true ��� : �տ� �ִ� ����
		//? �տ��ִ� �������� false��� : �ڿ� �ִ� ����
		System.out.println("result : "+result);
		
		//�� ���� �����ڸ� if �� �ٲپ� ������
		if(p==k) {
			result = p;
		}else {
			result = k;
		}System.out.println("result : "+result);
		//���� ���� ���´ٸ� ª�� �ڵ�
		
		/*
		 ����ǥ
		 0 : false
		 1 : true
		 		 OR		AND
		 0 0	 0		0
		 0 1	 1		0
		 1 0	 1		0
		 1 1	 1		1
		 
		 sql(oracle)
		 select *
		 from emp
		 where job='sales' and sal > 2000;  
		 �� �� ����
		 
		 select *
		 from emp
		 where job='sales' or sal > 2000;
		 �� �� �ϳ��� �����ϸ�
		 */
		
		//������( | (or), & (and) )
		//0 �� 1�� bit ����
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y));
		System.out.println("x&y : " + (x&y));
		//������ 3�� -> 2���� ������ ��ȯ
		//128 64 32 16 8 4 2 1 
		//             0 0 1 1 (2����:3)
		//             0 1 0 1 (2����:5)
		//OR           0 1 1 1 > 1+2+4 > 7
		//AND          0 0 0 1 > 1
		
		//***POINT ������ (||(or),&&(and)) ������ return boolean
		//�� �߿��ұ�?
		//if(10>0 && -1>1 && 100>2 && 1>-1){���๮}
		//if(10>0 || -1>1 || 100>2 || 1>-1){���๮}
		
		
		
		
		
		
		
		
		
	}

}
