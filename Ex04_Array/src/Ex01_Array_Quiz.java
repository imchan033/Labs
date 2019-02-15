
public class Ex01_Array_Quiz {

	public static void main(String[] args) {
		//수학과 학생들의 기말고사 시험점수
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0]; //79
		int min = score[0]; //79
		/*
		 제어문을 사용해서 max변수에 최대값(최고점수) min변수에는 최소값이
		 들어가게 하도록 구문을 작성하세요
		 결과) max > 97 . min > 54
		 */
		/*
		for(int i=0 ; i<score.length ; i++) {
			max = (max>score[i])?max:score[i];
			min = (min<score[i])?min:score[i];
		}System.out.printf("결과) max > %d, min > %d ",max,min);
		*/
		
		for(int i=0 ; i<score.length-1 ; i++) {
			for(int j=i+1 ; j<score.length ; j++) {
				int temp;
				max= score[i];
				min= score[j];
				if(score[i]>score[j]) {
					temp=min;
					min=max;
					max=temp;
				}else {
					break;
				}
			}
		}
		for(int i = 0 ; i<score.length ; i++) {
			System.out.print(score[i]+"\t");
		}
		System.out.printf("결과) max > %d, min > %d \n",max,min);
		
	
		
	
		int[] number = new int[10];
		//10개 방의 값을 1~10까지 초기화 하고 싶어요
		//number[0]
		for(int i = 0 ; i<number.length ; i++) {
			number[i] = i+1;
		}
		for(int i = 0 ; i<number.length ; i++) {
			System.out.print(number[i]+"\n");
		}
		
		
		
		
		//어느 학생의 기말고사 시험 점수 입니다. (5과목)
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100,55,90,60,78};
		/*
		 1. 총 과목수
		 2. 과목의 합(총점)
		 3. 과목의 평균
		 단) 2,3 문제는 하나의 for문에서 해결
		 */
		
		 for(int i=0 ; i<jumsu.length ; i++) {
			 sum += jumsu[i];
			 if(i==jumsu.length-1) {
				 average = sum/(float)jumsu.length; 
			 }
		 }
		 System.out.printf("총과목수 : [%d], 총점 : [%d], 평균 : [%d]",jumsu.length,sum,average);
		
	}
}
