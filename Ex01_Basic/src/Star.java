import java.util.*;

public class Star {

	public static void main(String[] args) {
		
		  
		/*
		 * for(int i=1 ; i<=7 ; i++) { for(int j=0 ; j<i ; j++) { //���� j<i
		 * System.out.print("*"); }System.out.println(); }
		 * 
		 * int floor=0; Scanner sc = new Scanner(System.in);
		 * System.out.print("�Ƕ�̵� ���� �Է��ϼ��� : "); floor=Integer.parseInt(sc.nextLine());
		 * 
		 * for(int i=0;i<floor;i++){ for(int j=1;j<floor-i;j++){ System.out.print(" ");
		 * } for(int j=0;j<2*i+1;j++){ System.out.print("*"); } System.out.println("");
		 * }
		 * 
		 * for(int i=1 ; i<=7 ; i++) { for(int j=1 ; j<7 ; j++) { //���� j<i
		 * System.out.print(" "); } for(int j=0 ; j<i ; j++) { System.out.print("*"); }
		 * System.out.println(); }
		 */
		
		int floor=0; 
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : "); 
		floor=Integer.parseInt(sc.nextLine());
		 
		for(int i=1;i<=floor;i++){
			for(int j=floor;j>0;j--){
				if(i<j){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println("");
		}

}

}
