
public class Ex01_Array_Quiz {

	public static void main(String[] args) {
		//���а� �л����� �⸻��� ��������
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0]; //79
		int min = score[0]; //79
		/*
		 ����� ����ؼ� max������ �ִ밪(�ְ�����) min�������� �ּҰ���
		 ���� �ϵ��� ������ �ۼ��ϼ���
		 ���) max > 97 . min > 54
		 */
		/*
		for(int i=0 ; i<score.length ; i++) {
			max = (max>score[i])?max:score[i];
			min = (min<score[i])?min:score[i];
		}System.out.printf("���) max > %d, min > %d ",max,min);
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
		System.out.printf("���) max > %d, min > %d \n",max,min);
		
	
		
	
		int[] number = new int[10];
		//10�� ���� ���� 1~10���� �ʱ�ȭ �ϰ� �;��
		//number[0]
		for(int i = 0 ; i<number.length ; i++) {
			number[i] = i+1;
		}
		for(int i = 0 ; i<number.length ; i++) {
			System.out.print(number[i]+"\n");
		}
		
		
		
		
		//��� �л��� �⸻��� ���� ���� �Դϴ�. (5����)
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100,55,90,60,78};
		/*
		 1. �� �����
		 2. ������ ��(����)
		 3. ������ ���
		 ��) 2,3 ������ �ϳ��� for������ �ذ�
		 */
		
		 for(int i=0 ; i<jumsu.length ; i++) {
			 sum += jumsu[i];
			 if(i==jumsu.length-1) {
				 average = sum/(float)jumsu.length; 
			 }
		 }
		 System.out.printf("�Ѱ���� : [%d], ���� : [%d], ��� : [%d]",jumsu.length,sum,average);
		
	}
}
