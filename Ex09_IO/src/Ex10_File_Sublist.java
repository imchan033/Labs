import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_Sublist {
	static int totalFiles = 0; //객체간 공유 자원
	static int totaldirs = 0;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java [파일명] [경로명]");
			System.out.println("예   시 : java Ex10_File_Sublist C:\\Temp");
			System.exit(0); // 프로세스 종료
		}
		
		File f = new File(args[0]); //args[0] > C:\\Temp
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);
		}
		//이 시점(폴더라고 판단되는 시점)
		printFileList(f);
		System.out.println("총 파일수 : "+totalFiles);
		System.out.println("총 폴더수 : "+totaldirs);
		
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full Path : " + dir.getAbsolutePath() + "]");
		
		List<Integer> subDir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); //C:Temp 입력했다면 하위 자원을 배열로...
		//C:\\Temp  [0] a.txt
		//			[1] NEW
		//			[2] c.jpg 이런 정보를 File[] 담아서 관리
		for(int i = 0 ; i < files.length ; i++) {
			String filename = files[i].getName(); //폴더명, 파일명
			if(files[i].isDirectory()) {
				filename = "<DIR> {"+filename+"]";
				//POINT
				subDir.add(i);
			} else {
				filename = filename + " / "+files[i].length() + "Byte";
			}
			System.out.println("  "+ filename);
			
		}
		//질문
		int dirnum = subDir.size();
		int filenum = files.length - dirnum;
		
		//누적값
		totaldirs += dirnum; //폴더 누적 개수
		totalFiles += filenum; //파일 누적 개수
		
		System.out.println("[Current dirnum] :"+dirnum);
		System.out.println("[Current filenum] :"+filenum);
		System.out.println("*****************************");
		
		for(int j = 0 ; j < subDir.size() ; j++) {
			int index = subDir.get(j);
			printFileList(files[index]);
		}
	}
}
