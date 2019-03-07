import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*  
�������� ���α׷�
<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� :
�������� �Է��ϼ��� :
�ڹ����� �Է��ϼ��� :
���̽����� �Է��ϼ��� :
���������� �߰��Ͽ����ϴ�.
�������� ���α׷�
<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� :
��ȣ  ����   �ڹ�  ���̽�  ��� ���
*/  
public class GradeManagement {
	static HashMap<Integer,Grade> map = new HashMap<Integer,Grade>();
	static int count =1;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		GradeManagement gm = new GradeManagement();
		while(true) {
			System.out.println("�������� ���α׷�");
			System.out.print("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� : ");
			switch (scan.nextInt()) {
			case 1:
				gm.add();
				break;
			case 2:
				gm.delete();
				break;
			case 3:
				gm.print();
				break;
			case 4 :
				gm.save();
				break;
			case 5:
				gm.load();
				break;
			case 6:
				//gm.exit();
				break;

			}
		}
	}
	
	private void add() {
		Grade grade = new Grade();
		map.put(count, grade.input(grade));
		count++;
	}
	
	private void delete() {
		System.out.print("���� �� ��ȣ �Է� : ");
		int num = scan.nextInt();
		if(map.containsKey(num)) {
			map.remove(num);
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ش� ������ �����ϴ�.");
		}
	}
	
	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("��ȣ\t����\t�ڹ�\t���̽�\t���\t���");
		for (Integer number : set) {
			double math = map.get(number).getMath();
			double java = map.get(number).getJava();
			double python = map.get(number).getPython();
			double avg = map.get(number).getAvg();
			String you = map.get(number).getYou();
			
			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n",number,math,java,python,avg,you);
		}
	}
	private void save() {
		File file = new File("grade.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			
			oos.close();
			fos.close();
		}catch (Exception e) {
			System.out.println("�����߻�~");
			e.printStackTrace();
		}
		System.out.println("����Ǿ����ϴ�.");
	}
	private void load() {
		File file = new File("bmi.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			
		}
	}
}
