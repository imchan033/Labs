import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
 ��ǻ�� ���� ���� �۾�(I/O ���� read, write : Disk)
 1. File �۾�(DISK) >> read, write >> byte ����
 ���� �ذ�
 Buffer �޸� (�׾Ƶΰ� �ѹ���) ...
 
 2. ��������� �׳� buffer �� ...
 
 3. File I/O ���ɰ���
 4. Line ���� ó�� (���� ���...)
 
 5. JAVA API
 //������Ʈ�� : ���������� new �� �� �� ����(Parameter ����)
 BufferedInputStream buffer = new BufferedInputStream();
 default �����ڸ� �������� �ʾҴ�...overloading �� ����
 BufferedOutputStream
 
 BufferedInputStream(InputStream in) > InputStream �� ��� ������ ��ü�� �ּ�
 
 */
public class Ex04_Stream_File_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("data.txt"); //���ϻ���
			bos = new BufferedOutputStream(fos);
			
			for(int i = 0; i < 10 ; i++) {
				bos.write('A');
			}
			/*
			 �ñ�����
			 buffer ����ü ���� ���Ͽ� write �մϱ�
			 java buffer : 8kbyte -> 8192byte
			 1. buffer�� �ȿ� ������ ä������ �ڵ����� ����(������)
			 2. buffer ������ ���� ��� : flush() ����...
			 3. bos.close() : ���������� flush() ȣ��
			 */
			//bos.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bos.close(); //flush()ȣ���� ���� �ڿ�����
				fos.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
