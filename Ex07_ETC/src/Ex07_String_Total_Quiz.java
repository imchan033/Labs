import java.util.Scanner;

//main �Լ� Scanner  ��� �ֹι�ȣ �Է¹ް�
//��:6�ڸ� ��:7�ڸ�
//�Է°� : 123456-1234567 
//1. �ڸ��� üũ (���)�Լ� (14 ok)
//2. �޹�ȣ ù��° �ڸ��� 1~4������ ���� ��� ����Լ�
//3. �޹�ȣ ù��° �ڸ����� ������ 1,3 ���� , 2,4 ���� ��� ����Լ�
//3���� �Լ� static ���� ���� �ϼ���
public class Ex07_String_Total_Quiz {
	static boolean juminCheck(String str) {
		boolean check;
		if(str.length()==14) {
			check=true;
		}else {
			check=false;
		}
		return check;
	}
	static boolean juminNumberCheck(String str) {
		boolean check;
		int number = Integer.parseInt(str.substring(7, 8));
		if(number>=1 && number<=4) {
			check = true;
		}else {
			check = false;
		}
		return check;
		
	}
	static String juminGender(String str) {
		String gender;
		int number = Integer.parseInt(str.substring(7, 8));
		if(number==1 || number==3) {
			gender = "����";
		}else {
			gender = "����";
		}
		return gender;
	}
	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("�ֹι�ȣ�Է�:");
			ssn = sc.nextLine();			
		}while(!juminCheck(ssn)||!juminNumberCheck(ssn));
		
		//���
		System.out.println(juminGender(ssn));

	}

}
