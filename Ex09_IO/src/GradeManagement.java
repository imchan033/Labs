import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*  
성적관리 프로그램
<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 :
수학점수 입력하세요 :
자바점수 입력하세요 :
파이썬점수 입력하세요 :
성적정보를 추가하였습니다.
성적관리 프로그램
<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 :
번호  수학   자바  파이썬  평균 등급
*/  
public class GradeManagement {
	static HashMap<Integer,Grade> map = new HashMap<Integer,Grade>();
	static int count =1;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		GradeManagement gm = new GradeManagement();
		while(true) {
			System.out.println("성적관리 프로그램");
			System.out.print("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");
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
		System.out.print("삭제 할 번호 입력 : ");
		int num = scan.nextInt();
		if(map.containsKey(num)) {
			map.remove(num);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("잘못입력하셨습니다. 해당 정보가 없습니다.");
		}
	}
	
	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("번호\t수학\t자바\t파이썬\t평균\t등급");
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
			System.out.println("에러발생~");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}
	private void load() {
		File file = new File("bmi.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			
		}
	}
}
