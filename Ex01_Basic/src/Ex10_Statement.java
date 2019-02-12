import java.util.*;

public class Ex10_Statement {

	public static void main(String[] args) {
		/*
		 * ��� ���ǹ�(�б⹮) : if(����,else,else if - ������ ����), switch() (case break default)
		 * �ݺ��� : for(�ݺ�Ƚ���� ��Ȯ), while(������ ��ġ�ϸ� �ݺ�), do~while() �������� break(��{} Ż��),
		 * continue(�Ʒ� ���� skip)
		 */
		int count = 0; // local variable(�ʱ�ȭ �ʼ�)
		if (count < 1) {// ���� if
			System.out.println("TRUE �Դϴ�");
		}

		if (count < 1)
			System.out.println("TRUE �Դϴ�"); // �߰�ȣ�� ���� ����

		char data = 'A';
		switch (data) {// ���ǰ����� : [����], [char], [String] ����
			case 'A':
				System.out.println("���ں� ����");
			break;
			default:
			System.out.println("default");
		}

		// �ݺ���
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum += i;
		}System.out.println("1~10 ������ �� : " + sum);

		// for ���� ����ؼ� 1~10���� Ȧ���� ���� ���� ������
		// for �� �ܿ� �ٸ� ������� ������� ������
		int sum1 = 0;
		for (int i = 1; i <= 10; i += 2) { // i=i+2
			sum1 += i;
		}System.out.println("1~10���� Ȧ���� �� : " + sum1);

		// 1~100���� ¦������
		int sum2 = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 += i;
			}
		}System.out.println("1~100���� ¦������ : " + sum2);

		//�Ի���� ��ǥ���� ����(������) : ����
		//for�� (��ø) >> �����
		//
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		System.out.println();
		
		for(int i=1 ; i<=9 ; i++) {
			for(int j=2 ; j<=9 ; j++) {
				System.out.printf("[%d]*[%d]=[%d]\t",j,i,i*j );
			}System.out.println();
		}
		System.out.println();
		
		//KEY POINT (break(Ż��), continue(��ŵ))
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				if(i == j)
					continue; //�Ʒ� ������ skip(�׳� �Ѿ��)
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		System.out.println();
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
				if(i == j)
					break; 
				System.out.printf("[%d]*[%d]=[%d]\t",i,j,i*j );
			}System.out.println();
		}
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<i ; j++) { //���� j<i
				System.out.print("*");
			}System.out.println();
		}
		
		for(int i=2 ; i<=9 ; i++) {
			for(int j=1 ; j<i ; j++) { //���� j<i
				System.out.print("*");
			}System.out.println();
		}
		
		for(int i = 100; i>=0; i--) { //���۰��� ū������...
			System.out.println("i : "+i);
		}
		
		//�Ǻ���ġ ����ó�� �Ǳ�
		System.out.println("�Ǻ���ġ");
		int a = 0;
		int b = 1;
		int c = 0;
		for(int i=0 ; i<=10; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.println(c);
		}
		
		//�������� 2�� 
		//�ΰ��� �ֻ����� ������ �� ���� ���� 6�� �Ǵ� ��� ����� ���� ����ϴ� ���α׷��� �ۼ��ϼ���

		int sum3=0;
		for(int i=1 ; i<=6 ; i++) {
			for(int j=1 ; j<=6 ; j++) {
				if(i+j==6) {
					sum3 ++;
				}
			}
		}System.out.println("�ΰ��� �ֻ����� ������ �� ���� ���� 6�� �Ǵ� ��� ����� ����? : "+sum3);
		
		//�������� 1��
		//1���� 20������  ���� �߿��� 2 �Ǵ� 3�� ����� �ƴ� ���� ������ ���ϴ� ���α׷��� �ۼ��ϼ���
		
		System.out.println("1���� 20������  ���� �߿��� 2 �Ǵ� 3�� ����� �ƴ� ���� ������?");
		int sum4 = 0;
		for(int i = 1; i<=20 ; i++) {
			if(i%2 != 0 && i%3 != 0) {
				sum4+=i;
			}
		}System.out.println("���� : "+sum4);
		
		/*�������� 3��
			���� , ���� ,�� ���� �� ����� ���ؼ� �ۼ��ϼ��� (IF)
			��)
			��ǻ�Ͱ� �ڵ����� ���� ���� , ���� , �� �� ���ؼ� ����ڰ� ���� �Է� �ؼ� ó�� �ϼ���
			( ���� ��� : ����=> 1   , ���� => 2  , �� => 3)
			����2 ����1
			��3 ����2
			����1 ��3	 
		*/
		/*
		 * int com; int user;
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("����(1) : ����(2) : ��(3)"); System.out.print("����� �Է� �� : ");
		 * user = sc.nextInt();
		 * 
		 * com = ((((int)(Math.random()*10))%3)+1); System.out.println("com : " + com +
		 * "\n");
		 * 
		 * switch(user) { case 1: System.out.println("user : ����"); break; case 2:
		 * System.out.println("user : ����"); break; case 3:
		 * System.out.println("user : ��"); break; default :
		 * System.out.println("���� �߸� �Է��Ͽ����ϴ�."); }
		 * 
		 * switch(com) { case 1: System.out.println("com : ����"); break; case 2:
		 * System.out.println("com : ����"); break; case 3: System.out.println("com : ��");
		 * break; default : System.out.println("���� �߸� �Է��Ͽ����ϴ�."); }
		 * 
		 * 
		 * if(user==com) System.out.println("���º�"); else if(user>com) {
		 * if(user==3&&com==1) System.out.println("��ǻ�� �¸�"); else
		 * System.out.println("����� �¸�"); } else if(user<com) { if(user==1&&com==3)
		 * System.out.println("����� �¸�"); else System.out.println("��ǻ�� �¸�"); }
		 */
		
			
	    System.out.println("����(1), ����(2), ��(3)");
	    int ply = (int) ((Math.random() * 3) + 1);
	    System.out.println(ply);
	    int com1 = (int) ((Math.random() * 3) + 1);
	    System.out.println(com1);
	    
	    String win = "����� �̰���ϴ�.";
	    String lose = "����� �����ϴ�.";
	    String drow = "����� �����ϴ�";
	    String result = "";
	    
	    if (ply == com1) {
	        result = drow;
	    } else if (ply - com1 == -1 || ply - com1 == 2) {
	        result = lose;
	    } else {
	        result = win;
	    }
	    System.out.println(result);
		
		
	}
		
		
		
}

