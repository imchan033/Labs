import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Time extends Thread{
	@Override
	public void run() {
		for(int i=10 ; i>0 ; i--) {
			System.out.println("남은시간 : "+i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("시간이 종료 되었습니다.");
		Hw01_Damon_Thread.isstop=true;
		System.out.println();
	}
}

class Quiz extends Thread{
	ArrayList<String> score = new ArrayList<String>();
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		int i=0;
		int j=0;
		int answer=0;
	while(true) {
		if(Hw01_Damon_Thread.isstop) System.exit(0);
		i = (int)(Math.random()*9+1);
		j = (int)(Math.random()*9+1);
		int result = i*j;
		System.out.printf("문제 : %d X %d = ?\n",i,j);
		System.out.print("입력한 값은 : ");
		int word = Integer.parseInt(sc.nextLine());
		if(result==word) {
			System.out.println("정답!");
			score.add("o");
		}else {
			System.out.println("오답!");
			score.add("x");
		}
	}
	
	}
}

public class Hw01_Damon_Thread {
	static boolean isstop = false;
	public static void main(String[] args) {
			
	}
}
