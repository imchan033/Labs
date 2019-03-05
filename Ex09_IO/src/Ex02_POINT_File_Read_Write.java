import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Stream 대상이 : File (read, write) : 디스크에 존재하는 물리적 파일
//FileInputStream, FileOutputStream
//text 기반 작업 : C:\\Temp\\a.txt ...
public class Ex02_POINT_File_Read_Write {
	public static void main(String[] args) {
		
		//1 단계
		//POINT : I/O 작업은 가비지 컬렉터의 대상이 아니다
		//파일작업에 있어서는 작업이 끝나면 자원을 해제한다
		//(함수 : close() -> 내부적으로 소멸자 함수 호출)
		/*
		FileInputStream fs=null;
		try {
			fs = new FileInputStream("C:\\Temp\\a.txt");
			int data = 0;
			while((data = fs.read()) != -1) {
				System.out.println("정수(숫자)"+data);
				//아스키 코드표 기준으로 한 정수값
				System.out.println((char)data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //정상,비정상 종료 파일 닫기
		}
		*/
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		String path = "C:\\Temp\\a.txt";
		
		try {
			fs = new FileInputStream(path); //read
			fos = new FileOutputStream("C:\\Temp\\new.txt"); //파일 생성기능
			//write
			//FileOutputStream 클래스는 Temp폴더 안에 new.txt가 존재하지 않으면
			//자동으로 파일을 생성합니다 >> 생성된 파일에 쓰기(write)
			
			// new FileOutputStream("C:\\Temp\\new.txt",true);
			// 생성자의 두번째 인자가(true)
			// 기존 데이터 : append
			
			
			// new FileOutputStream("C:\\Temp\\new.txt");
			// default (false)
			// 기존 데이터 : overwrite
			int data=0;
			while((data = fs.read()) != -1) {
				fos.write(data); //new.txt (encoding)
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				fos.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
