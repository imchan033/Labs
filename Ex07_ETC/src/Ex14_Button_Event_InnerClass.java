import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class LoginForm2 extends Frame{
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm2(String title) {
		super(title);
		lbl_id = new Label("ID:", Label.RIGHT);
		lbl_pwd = new Label("PWD:",Label.RIGHT);
		
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('*');
		btn_ok = new Button("login");
		
		this.setLayout(new FlowLayout()); //add한 순서대로
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		
		this.add(lbl_pwd);
		this.add(txt_pwd);
		
		this.add(btn_ok);
		
		//버튼에 클릭 이벤트 처리하기
		//조건 : parameter 로 처리되는 객체는 반드시 ActionListener 구현하는 객체
		
		//Inner class 전한 (inner class >> Outer class 의 자원을 사용 가능)
		class Btn_Handler2 implements ActionListener{
			//기존 id,pwd를 받는 생성자가 필요없다
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(txt_id.getText()+"/"+txt_pwd.getText());
				String id = txt_id.getText().trim();
				String pwd = txt_pwd.getText().trim();
				
				if(id.equals("hong")) {
					System.out.println("방가 방가 ! / "+pwd);
				}else {
					System.out.println("나는 졸고 있는 것이 아니다...");
				}
				
			}
			
		}
		btn_ok.addActionListener(new Btn_Handler2());
	
	}
	
	
}

public class Ex14_Button_Event_InnerClass {
	public static void main(String[] args) {
		LoginForm2 login = new LoginForm2("로그인");
	}
}
