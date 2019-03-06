import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	static String currentPath = "C:\\";

	static void makeDirectory(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("사용법 : [java파일명] mkdir [생성디렉토리명]");
            
        }
        File f = new File(currentPath);

        if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리 아니라면
            System.out.println("유효하지 않은 디렉토리입니다");
           
        }

        if (args[0].equals("MKDIR")) {

            String path = "";
            path = f + "\\" + args[1];
            File newfile = new File(path);
            if (newfile.exists()) {
                System.out.println("이미 존재하는 디렉토리입니다");
            } else {
                newfile.mkdir();
            }
        }
    }
	static void deleteDirectory(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("사용법 : [java파일명] delete [파일명]");
            
        }

        File f = new File(currentPath);
        
        if (args[0].equalsIgnoreCase("RMDIR")) {
            String path = "";
            path = f + "\\" + args[1];
            File deletefile = new File(path);

            if (!deletefile.exists()) {
                System.out.println("존재 하지 않는 파일입니다");
            } else {
                deletefile.delete();
            }

        }

    }

	static void chnageDirectory(String[] arg) {
		File cd = new File(arg[1]);
		// cd temp는 안되고 cd \temp를 해야 되는 문제
		if (cd.isDirectory()) {

			if (arg[1].startsWith("..")) {
				int num = 0;
				String[] ss = null;
				ss = arg[1].split("/");
				for (String s : ss) {
					if (s.equals(".."))
						num++;
				}
				String[] str = currentPath.split("\\\\");
				currentPath = currentPath.substring(0, currentPath.lastIndexOf(str[str.length - num]));
				if (currentPath.equals(""))
					currentPath = "C:\\";
			} else {
				currentPath = cd.getAbsolutePath();
			}
		} else {
			System.out.println("지정된 경로를 찾을 수 없습니다.");
		}
	}

	static void viewDirectory(String[] arg) {
		File dir = new File(currentPath);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String name = file.getName(); // 파일명(a.txt), 폴더명

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			DecimalFormat nf = new DecimalFormat("#,###");
			String attribute = "";
			long size = 0;

			if (files[i].isDirectory()) {
				attribute = "<DIR>";
			} else { // 나머지는 파일 (a.txt, copy.jpg.. )
				attribute = "     ";
				size = file.length();
			}
			System.out.printf("%s     %6s     %10s  %s \n", df.format(file.lastModified()), attribute, nf.format(size),
					name);

		}
		System.out.println();
	}

	static void RenameSJ(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		boolean result = false;
		String ExE = "";
		do {
			System.out.println("변경을 희망하는 파일명을 입력해주세요");
			String name = sc.nextLine();
			String fileName = currentPath + "\\" + name;
			System.out.println(fileName);
			File f = new File(fileName);
			if (f.exists()) {// 변경하고자하는 파일명이 폴더에 존재 할경우 실행
				System.out.println("변경하시고 싶은 이름을 입력해주세요");
				if(name.lastIndexOf(".") > 0) {
					ExE = name.substring(name.lastIndexOf("."));
			}
				String wantChangeName = currentPath + "\\" + sc.nextLine() + ExE;
				File f2 = new File(wantChangeName);
				if (!f2.exists()) {// 변경하고자 하는 파일이 폴더에 없을 경우 인자값을 보여주고 renameto실행 while문 종료
					System.out.println(wantChangeName);
					System.out.println("성공");
					f.renameTo(f2);
					result = false;
				} else {
					System.out.println("이름이 중복되었습니다 다시 입력하세요.");
					result = true;
				}
			} else { // 이름을 잘못입력한경우 프로그램 종료
				System.out.println("잘못입력하셨습니다.");
				result = true;
			}
		} while (result);
	}

	static void Copy(String[] arg) {
		    
		    Scanner sc = new Scanner(System.in);
		    
		    System.out.println("복사하고 싶은 파일을 선택하세요");
	        File F = new File(currentPath + "\\"+ sc.nextLine());
	        System.out.println(F);
	        String name = F.getName();

	        System.out.println("복사하고 싶은 파일의 경로 : ");
	        String adr = sc.nextLine();
	        System.out.println(adr);

	        FileReader fr = null;
	        BufferedReader br = null;
	        FileWriter fw = null;
	        BufferedWriter bw = null;

	        try {
	            fr = new FileReader(F);
	            br = new BufferedReader(fr);
	            fw = new FileWriter(adr + "\\" + name);
	            bw = new BufferedWriter(fw);
	            int data = 0;
	            while ((data = br.read()) != -1) {
	                bw.write(data);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                bw.close();
	                fw.close();
	                br.close();
	                fr.close();

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	               System.out.println("복사 완료");
	    }
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String userInput = "";
		currentPath = System.getProperty("user.dir");
		
		while (!userInput.equalsIgnoreCase("EXIT")) {
			System.out.println(currentPath + ">");
			userInput = sc.nextLine();
			// System.out.println(userInput);

			String[] arg = userInput.split(" ");
			for (String a : arg) {
				System.out.println(a);
			}

			if (arg[0].equalsIgnoreCase("RENAMESJ")) {
				RenameSJ(arg);
			} else if (arg[0].equalsIgnoreCase("CD")) {
				chnageDirectory(arg);
			} else if (arg[0].equalsIgnoreCase("DIR")) {
				viewDirectory(arg);
			} else if (arg[0].equalsIgnoreCase("COPY")) {
				Copy(arg);
			} else if(arg[0].equalsIgnoreCase("RMDIR")) {
				deleteDirectory(arg);
			} else if(arg[0].equalsIgnoreCase("MKDIR")) {
				makeDirectory(arg);
			}
		}
	}
}


