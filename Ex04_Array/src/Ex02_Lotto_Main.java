/*
		 1. 1~45������ ������ �߻����� 6���� �迭�� ��������
		 2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�
		 3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����
		 4. �� ����� ��� �ִ� �迭�� ����ϼ���
		 
		 ��������
		 */
public class Ex02_Lotto_Main {

	public static void main(String[] args) {
		
		//1~45 ������ ���� ��������
		int[] lotto = new int[6];
		int ran = (int)(Math.random()*45+1);
		
		for(int i=0 ; i<lotto.length ; i++) {
			lotto[i]=ran;
		  for(int j=0 ; j<i ; j++) {
				  while(lotto[i]==lotto[j]) {
					ran = (int)(Math.random()*45+1);
					lotto[i]=ran;					
				  }
			  
		  }
		}
		
		int temp = 0;
		for(int i=1; i<lotto.length; i++) {
			for(int j=0; j<lotto.length-i ; j++) {
			if(lotto[j]>lotto[j+1]) {
				temp = lotto[j];
				lotto[j] = lotto[j+1];
				lotto[j+1] = temp;
			}
				
			}
		}
		
		System.out.println("���");
		for(int i = 0 ; i<lotto.length ; i++) {
			System.out.print(lotto[i]+"\t");
		}
		
	}

}