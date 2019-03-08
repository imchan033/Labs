import javax.swing.JOptionPane;

/*
 
 ����
 main �Լ� ������ Thread 2�� ����
 1. �ð�(time) �����ϴ� Thread
 2. �ܾ� �Է��� ó���ϴ� Thread
 
 main �Լ����� 2�� Thread start
 
 �� �ܾ �ϳ��� �Է��ؼ� Ȯ�� ��ư�� ������ �ð��� ���߰�
 ���α׷��� ����ǰ� �ϼ���...
 
 Hint : static �ڿ� Ȱ��
  
 */
class Word extends Thread{
	
	@Override
	public void run() {
		
		String inputdata = JOptionPane.showInputDialog("�ܾ �Է��ϼ���");
		System.out.println("�Է°� : "+inputdata);
		Time.stop = true;
	}
	
}
class Time extends Thread{
	public static boolean stop = false;
	
	@Override
	public void run() {
		for(int i = 10 ; i>0 ; i--) {
			if(this.stop==true) return;
			System.out.println("�����ð� : "+i);
			try {
				Thread.sleep(1000); //CPU�� �����ϴ� �ʴ� ��� ����
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
