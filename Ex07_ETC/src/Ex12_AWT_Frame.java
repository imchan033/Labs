import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//AWT (CS ���α׷��� ���� �� �ִ� class ����)
//JAVA ��� ���� �޸���, ���� ��...(���� JAVA WEB �߽�)

//AWT >> SWING (���� �ڹ� �ڵ�� ������)

//component(class ����) : ��ư, ������ �� ... ����� ���Ҿ��

class MyFrame extends Frame{
	MyFrame(String title){
		super(title);
	}
}

//�̺�Ʈ ���� (�̺�Ʈ ��� ������� �ִ�...click, mouseover)
class BtnClick_Handler implements ActionListener{

	//click ���� �ڵ鷯(�Լ�)
	//��ư�� click �ϸ�
	@Override
	public void actionPerformed(ActionEvent e) { //�̺�Ʈ ��ư�� Ŭ���ϸ� �߻��ϴ�...
		//���� �ڵ�� �������
		//112�� �Ű��ϱ�
		//�׳� ������ �ִ�
		System.out.println("�����ڰ� ���ϴ� ���� ����");
		
	}
	
}



public class Ex12_AWT_Frame {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame("LOGIN");
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		Button btn = new Button("����ư");
		Button btn2 = new Button("��ư��");
		Button btn3 = new Button("����ư");
		
		frame.add(btn);
		frame.add(btn2);
		frame.add(btn3);
		
		
		/*
		�͸�Ÿ�� (�������̽��� ���� �������� �ʰ� �ٷ� ��ü�� ����� ���� ���)
		�ڵ差...
		��ȸ�� (���뼺)
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����ڰ� ���ϴ� ���� ����");
				
			}
		});
		*/
		
		//ActionListener �����ϴ� Ŭ������ ��ü ����>>���� ����
		BtnClick_Handler handler = new BtnClick_Handler();
		btn.addActionListener(handler); //�̺�Ʈ�� ��ư�� �ο� >> addActionListener
		btn2.addActionListener(handler);
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�������̽� ���� �ڵ�...(�͸�Ÿ��) ���� Ŭ������ �����");
				
			}
		});
	}
}
