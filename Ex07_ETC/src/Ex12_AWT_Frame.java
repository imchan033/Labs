import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//AWT (CS 프로그램을 만들 수 있는 class 제공)
//JAVA 라는 언어로 메모장, 계산기 등...(현재 JAVA WEB 중심)

//AWT >> SWING (순수 자바 코드로 버전업)

//component(class 모음) : 버튼, 프레임 등 ... 만들어 놓았어요

class MyFrame extends Frame{
	MyFrame(String title){
		super(title);
	}
}

//이벤트 구현 (이벤트 사건 만들어져 있다...click, mouseover)
class BtnClick_Handler implements ActionListener{

	//click 대한 핸들러(함수)
	//버튼을 click 하면
	@Override
	public void actionPerformed(ActionEvent e) { //이벤트 버튼을 클릭하면 발생하는...
		//안쪽 코드는 마음대로
		//112에 신고하기
		//그냥 볼수도 있다
		System.out.println("개발자가 원하는 행위 구현");
		
	}
	
}



public class Ex12_AWT_Frame {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame("LOGIN");
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		Button btn = new Button("나버튼");
		Button btn2 = new Button("나튼버");
		Button btn3 = new Button("버나튼");
		
		frame.add(btn);
		frame.add(btn2);
		frame.add(btn3);
		
		
		/*
		익명타입 (인터페이스를 직접 구현하지 않고 바로 객체를 만들어 쓰는 방법)
		코드량...
		일회성 (재사용성)
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("개발자가 원하는 행위 구현");
				
			}
		});
		*/
		
		//ActionListener 구현하는 클래스의 객체 생성>>재사용 가능
		BtnClick_Handler handler = new BtnClick_Handler();
		btn.addActionListener(handler); //이벤트를 버튼에 부여 >> addActionListener
		btn2.addActionListener(handler);
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("인터페이스 직접 코딩...(익명타입) 실제 클래스가 없어요");
				
			}
		});
	}
}
