/*
 금액을 입력받아 화폐 매수를 계산하는 프로그램
 */
import java.util.*;

public class Hw02_UNIT {

	public static void main(String[] args) {
		
		int unit = 10000; //화폐단위
		int num = 0; //화폐매수
		int sw = 0; //스위칭 변수, 화폐의 다음 단위를 위해
		int money = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하세요 : ");
		money = Integer.parseInt(sc.nextLine());
		
		/*
		do {
			num = (int)money/unit;
			System.out.printf("unit : %d, num : %d\n",unit,num);
			money -= unit*num;
			if(sw==0) {
				unit /= 2;
				sw = 1;
			}else {
				unit /= 5;
				sw = 0;
			}
		}while(unit>=1);
		 */
		while(unit>=1) {
			num = (int)money/unit;
			System.out.printf("unit : %d, num : %d\n",unit,num);
			money -= unit*num;
			
			if(sw==0) {
				unit /= 2;
				sw = 1;
			}else {
				unit /= 5;
				sw = 0;
			}
		}
	}

}
