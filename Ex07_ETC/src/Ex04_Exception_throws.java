import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import kr.or.bit.ExClass;

/*
 Ŭ���� ����� ���� ����� �ڿ��� ���ؼ� �����ڰ� ������ ����ó���� �ϰ��ϴ� ���
 ������, �Լ� ���� ���ܸ� �����ϵ��� ����...
 throws
 
 JAVA API �����ϴ� Ŭ���� ...
 try {
			FileInputStream fi = new FileInputStream("C:\\Temp\\a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
}
		
 */
public class Ex04_Exception_throws {

	public static void main(String[] args) {
		
		try {
			ExClass ex = new ExClass("C:\\Temp");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
