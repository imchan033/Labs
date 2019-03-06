import java.io.File;

public class ExDos {

    public static String currentPath="C:\\";
    
    public static void main(String[] args) throws Exception {

    	
        if (args.length != 2 && args.length != 3) {
            System.out.println("���� : [java���ϸ�] cd [�����θ�]");
            System.exit(0);
        }

        File f = new File(args[0]);
        
        currentPath = f.getAbsolutePath().replace("\\"+args[0], "");
        
        System.out.println("������ : " + currentPath);

        if(args[0].toUpperCase().equals("CD")) {
            File cd = new File(args[1]);
            if(cd.isDirectory()) {
                //������
                currentPath=cd.getAbsolutePath();
                if(args[1].startsWith("..")) {
                    int num=0;
                    String[] ss = args[1].split("/");
                    for(String s : ss) {
                        if(s.equals("..")) num++;
                    }
//                    System.out.println("num : " + num);
//                    System.out.println(currentPath.indexOf("\\"));
//                    System.out.println(currentPath.lastIndexOf("\\"));
                    String[] str=currentPath.split("\\\\");
                    currentPath=currentPath.substring(0, currentPath.lastIndexOf(str[str.length-num*2]));
                }
                System.out.println(currentPath + ">");
            } else {
                System.out.println("������ ��θ� ã�� �� �����ϴ�.");
            }
        }
        
    }
}