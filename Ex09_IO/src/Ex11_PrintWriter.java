import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

//PrintWriter Ŭ������ ����ϸ� [������� ����]
//ģô : System.out.printf(), String,format()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try {
			/*
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			//���Ͼ��ٸ� ����, �ִٸ�...overwrite
			pw.println("*************************************************");
			pw.println("*************************************************");
			pw.println("*************HOME**********WORK******************");
			pw.println("*************************************************");
			pw.printf("%3s : %5d  %5d  %5d ��� : %5.1f \n","�ƹ���",10,90,88,(float)((10+90+88)/3));
			pw.println();
			pw.close();
			*/
			//read(Line ����) >> buffered...
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
