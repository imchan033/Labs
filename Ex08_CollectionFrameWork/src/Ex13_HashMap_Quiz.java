import java.util.HashMap;
import java.util.Scanner;

/*
	    HashMap ����� �α��� �ý���

		//ȸ�� �α��� ������ HashMap ���� ����
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		//�ý��ۿ� �α��� �ϴ� �ó�����
		//ID(0) , PWD(0)  >> ȸ��  (ȯ��)
		//ID(0) , PWD(x)  >> ����  (����ٽ� �Է�)
		
		//ID(x) , PWD(x)  >> ����  (�ٽ� �Է���)
		//ID(x) , PWD(0)
		
		//Scanner ����ؼ�  ID, PWD �Է¹�������
		//loginmap ���ؼ� ���� ���� ó��
		//ID �Ǵ�  PWD Ʋ���� �ٽ� �Է� ��û
		//ID , PWD �� ������ ȸ���� �湮 ȯ���մϴ� ^^ (��� ���α׷� ����)
	    //ID �� ��ҹ��� ���о��� ó�� �մϴ�.
*/
public class Ex13_HashMap_Quiz {

	public static void main(String[] args) {
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���̵� �Է����ּ��� : ");
			String id = sc.nextLine().trim().toLowerCase(); //trim() �յ� ���� ���� , toLowerCase() �ҹ��ڷ� ��ȯ
			if (loginmap.containsKey(id)) {
				while(true) {
					System.out.print("��й�ȣ�� �Է����ּ��� : ");
					String pwd = sc.nextLine().trim();
					if (loginmap.get(id).equals(pwd)) {
						System.out.println("ȯ���մϴ�.");
						System.exit(0);
					} else {
						System.out.println("��й�ȣ ����");
					}
				}
			} else {
				System.out.println("���̵� �ٽ� �Է��� �ּ���");
			}
		}

	}

}
