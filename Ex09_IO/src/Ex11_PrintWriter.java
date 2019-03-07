import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

//PrintWriter 클래스를 사용하면 [출력형식 정의]
//친척 : System.out.printf(), String,format()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try {
			/*
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			//파일없다면 생성, 있다면...overwrite
			pw.println("*************************************************");
			pw.println("*************************************************");
			pw.println("*************HOME**********WORK******************");
			pw.println("*************************************************");
			pw.printf("%3s : %5d  %5d  %5d 평균 : %5.1f \n","아무개",10,90,88,(float)((10+90+88)/3));
			pw.println();
			pw.close();
			*/
			//read(Line 단위) >> buffered...
			FileReader fr = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			while((s=br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
