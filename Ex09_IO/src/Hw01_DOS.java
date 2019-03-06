import java.io.File;

// ��Ŭ�������� �׳� ���� �غ� �� �ִ� ������ DOS Ŀ�ǵ�
  // ����� �� �ִ� ��ɾ�
 
  // CD ���� ���͸� �̸��� �����ְų� �ٲߴϴ�.
  // DIR ���͸��� �ִ� ���ϰ� ���� ���͸� ����� �����ݴϴ�.
  // MD ���͸��� ����ϴ�.
  // MKDIR ���͸��� ����ϴ�.
  // RD ���͸��� ����ϴ�.
  // RMDIR ���͸��� ����ϴ�.
  // REN ���� �̸��� �ٲߴϴ�.
  // RENAME���� �̸��� �ٲߴϴ�.
  // TYPE �ؽ�Ʈ ������ ������ �����ݴϴ�.
  // EXIT ���α׷��� �����մϴ�.

public class Hw01_DOS {
	//static String defaultPath = "C:" + File.separator;
	//static String path = defaultPath;
	
	 public static void main(String[] args) throws Exception {
	        //java ExDos C:\Temp mkdir newDir
	        //java ExDos C:\Temp rename file.txt file2.txt
	        //java ExDos C:\Temp delete new.txt
	        
	        if(args.length != 3 && args.length != 4) {
	        	System.out.println("���� : [java���ϸ�] [���丮���] mkdir [�������丮��]");
	        	System.out.println("���� : [java���ϸ�] [���丮���] delete [���ϸ�]");
	            System.out.println("���� : [java���ϸ�] [���丮���] rename [���ϸ�] [���ο� ���ϸ�]");
	            System.exit(0);
	        }
	        
	        File f = new File(args[0]);
	        if(!f.exists() || !f.isDirectory()) { //�������� �ʰų� ���丮 �ƴ϶��
	            System.out.println("��ȿ���� ���� ���丮�Դϴ�");
	            System.exit(0);
	        }
	        
	        
	        if(args[1].equals("mkdir")) 
	        {
	            String path = "";
	            path = f + "\\" + args[2];
	            File newfile = new File(path);
	            if(newfile.exists()) {
	                System.out.println("�̹� �����ϴ� ���丮�Դϴ�");
	            }
	            else {
	                newfile.mkdir();
	            }
	        }
	        
	        if(args[1].equals("delete")) 
	        {
	        	String path = "";
	        	path = f + "\\"+args[2];
	        	File deletefile = new File(path);
	        	
	        	if(!deletefile.exists()) {
	        		System.out.println("���� ���� �ʴ� �����Դϴ�");
	        	}else {
	        		deletefile.delete();
	        	}
	        	
	        }
	        if(args[1].equals("rename"))
	        {
	        	String path,renamepath = "";
	        	path = f + "\\"+args[2];
	        	File file = new File(path);
	        	renamepath = f+"\\"+args[3];
	        	File renamefile = new File(renamepath);
	        	
	        	if(!renamefile.exists()) {
	        		System.out.println("���� ���� �ʽ��ϴ�");
	        	}else {
	        		file.renameTo(renamefile);
	        	}
	        }
	        
	 }
}
