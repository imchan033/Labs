import java.io.File;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {

	public static void main(String[] args) {
		//Format Ŭ���� (����)
		/*
		
		//ȭ�����ó��
		DecimalFormat df = new DecimalFormat("#,###.0");
		String result = df.format(1234567.89);
		System.out.println(result);
		
		//��¥ ���� ó��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		//���ڿ����� ó��
		String message = "ȸ��ID:{0} \nȸ���̸�:{1} \nȸ����ȭ:{2}";
		String result2 = MessageFormat.format(message,"Imchan","����","01072410000");
		System.out.println(result2);
		
		 */
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles(); //files �迭���� ������ ���� ���...
		
		for(int i = 0 ; i<files.length ; i++) {
			File file = files[i];
			
			String name = file.getName(); // name >> a.txt, NEW (����,����...)
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				attribute = "<DIR>";
			} else { //�������� ����(a.txt, copy.jpg ...)
				size = file.length() + "byte";
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}//%3s 3ĭ�� Ȯ���ϰڴ�
			System.out.printf("%s   %3s   %10s   %s\n",df.format(new Date(file.lastModified()))
					,attribute
					,size
					,name);
		}
		
		
	}

}
