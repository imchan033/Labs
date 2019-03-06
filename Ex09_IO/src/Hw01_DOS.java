import java.io.File;

// 이클립스에서 그냥 실행 해볼 수 있는 간단한 DOS 커맨드
  // 사용할 수 있는 명령어
 
  // CD 현재 디렉터리 이름을 보여주거나 바꿉니다.
  // DIR 디렉터리에 있는 파일과 하위 디렉터리 목록을 보여줍니다.
  // MD 디렉터리를 만듭니다.
  // MKDIR 디렉터리를 만듭니다.
  // RD 디렉터리를 지웁니다.
  // RMDIR 디렉터리를 지웁니다.
  // REN 파일 이름을 바꿉니다.
  // RENAME파일 이름을 바꿉니다.
  // TYPE 텍스트 파일의 내용을 보여줍니다.
  // EXIT 프로그램을 종료합니다.

public class Hw01_DOS {
	//static String defaultPath = "C:" + File.separator;
	//static String path = defaultPath;
	
	 public static void main(String[] args) throws Exception {
	        //java ExDos C:\Temp mkdir newDir
	        //java ExDos C:\Temp rename file.txt file2.txt
	        //java ExDos C:\Temp delete new.txt
	        
	        if(args.length != 3 && args.length != 4) {
	        	System.out.println("사용법 : [java파일명] [디렉토리경로] mkdir [생성디렉토리명]");
	        	System.out.println("사용법 : [java파일명] [디렉토리경로] delete [파일명]");
	            System.out.println("사용법 : [java파일명] [디렉토리경로] rename [파일명] [새로운 파일명]");
	            System.exit(0);
	        }
	        
	        File f = new File(args[0]);
	        if(!f.exists() || !f.isDirectory()) { //존재하지 않거나 디렉토리 아니라면
	            System.out.println("유효하지 않은 디렉토리입니다");
	            System.exit(0);
	        }
	        
	        
	        if(args[1].equals("mkdir")) 
	        {
	            String path = "";
	            path = f + "\\" + args[2];
	            File newfile = new File(path);
	            if(newfile.exists()) {
	                System.out.println("이미 존재하는 디렉토리입니다");
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
	        		System.out.println("존재 하지 않는 파일입니다");
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
	        		System.out.println("존재 하지 않습니다");
	        	}else {
	        		file.renameTo(renamefile);
	        	}
	        }
	        
	 }
}
