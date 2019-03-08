import javax.swing.JOptionPane;

/*
 
 문제
 main 함수 제외한 Thread 2개 생성
 1. 시간(time) 제외하는 Thread
 2. 단어 입력을 처리하는 Thread
 
 main 함수에서 2개 Thread start
 
 단 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추고
 프로그램이 종료되게 하세요...
 
 Hint : static 자원 활용
  
 */
class Word extends Thread{
	
	@Override
	public void run() {
		
		String inputdata = JOptionPane.showInputDialog("단어를 입력하세요");
		System.out.println("입력값 : "+inputdata);
		Time.stop = true;
	}
	
}
class Time extends Thread{
	public static boolean stop = false;
	
	@Override
	public void run() {
		for(int i = 10 ; i>0 ; i--) {
			if(this.stop==true) return;
			System.out.println("남은시간 : "+i);
			try {
				Thread.sleep(1000); //CPU를 점유하는 너는 잠깐 쉬어
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
public class Ex05_WordGame {

	public static void main(String[] args) {
		Time t = new Time();
		Word w = new Word();
		t.start();
		w.start();

	}

}
