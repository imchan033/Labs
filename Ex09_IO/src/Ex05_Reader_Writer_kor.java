import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//������
//1. �ѱ� 1�� >> 2byte >> stream(1Byte) ��� >> �ѱ��� ��� �Ұ�
//2. ��� �ϳ� �� ����� �ٰ� >> 2byte ��� >> reader, writer

public class Ex05_Reader_Writer_kor {
	public static void main(String[] args) {
		//File reader, writer �۾�
		FileReader fr = null;
		
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileWriter("copy_Ex02.txt");//���纻�� ����ڴ�
			
			int data = 0;
			while((data = fr.read()) != -1) {
				//System.out.println(data + " : " + (char)data);
				//fw.write(data);
				if(data != '\n' && data != '\r' && data != '\t' && data != ' ') {
					fw.write(data);
				}
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
