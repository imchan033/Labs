/*
		 1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
		 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요
		 3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요
		 4. 위 결과를 담고 있는 배열을 출력하세요
		 
		 조별과제
		 */
public class Ex02_Lotto_Main {

	public static void main(String[] args) {
		
		//1~45 까지의 난수 넣으세요
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
		
		System.out.println("출력");
		for(int i = 0 ; i<lotto.length ; i++) {
			System.out.print(lotto[i]+"\t");
		}
		
	}

}