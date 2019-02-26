import java.util.StringTokenizer;

//String Ŭ���� (�پ��� �Լ�)
//���߿��� ���� ��� (�츮�� ����� �����ʹ� ��κ� ���ڿ� ������)



public class Ex06_String_Function {

	public static void main(String[] args) {
		String str = ""; //���ڿ� �ʱ�ȭ
		
		String[] strarr = {"aaa" , "bbb", "ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
		//String Ŭ���� (�Լ�)
		String ss = "hello";
		String concatstr = ss.concat(" world!");
		System.out.println(concatstr);
		
		boolean bo = ss.contains("el");
		System.out.println(bo);
		
		String ss2 = "a b c d";//[a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());
		
		String filename = "hello java, world";
		System.out.println(filename.indexOf(","));
		System.out.println(filename.indexOf("java")); //���� ��ġ index
		
		//Ȱ�� : ���峻���� ���� ���ϴ� �ܾ ���� �Ǿ��ִ�����  ����
		//0���� ū��...�ּ��� �ϳ��� �ܾ� ����
		System.out.println(filename.lastIndexOf("a"));
		System.out.println(filename.lastIndexOf("kglim"));
		//�迭�� ���� ���� >> -1
		//return -1;
		
		//�ַ� ���� ���� �Լ�
		//length(), indexof(), substring(), replace(), ...split()
		String result = "superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(4));
		System.out.println(result.substring(1, 3)); //index endIndex - 1
		
		//Quiz
		String filename2 = "ȫ�浿.jpg"; //���ϸ��� �ٲپ� �� �� �ִ�
		//aaaa.mpeg or ab.hwp
		//���ϸ� >> ȫ�浿
		//Ȯ���� >> Ȯ����
		//�и��ؼ� ȭ�鿡 ����غ�����
		System.out.println(filename2.substring(0,filename2.lastIndexOf(".")));
		System.out.println(filename2.substring(filename2.lastIndexOf(".")+1));
		
		//replace
		String s2 = "ABCD";
		String result4 = s2.replace("A","�ȳ�");
		System.out.println(result4);
		
		System.out.println(s2.charAt(1));
		System.out.println(s2.endsWith("BCD"));
		System.out.println(s2.equalsIgnoreCase("aBcD"));
		
		//POINT
		//split
		String s6 = "���۸�,��Ƽ,�����,������,������";
		String[] namearray = s6.split(",");
		for(String s : namearray) {
			System.out.println(s);
		}
		
		String filename3 = "bit.hwp";
		String[] array = filename3.split("\\."); //���� ǥ�� ���ڿ��� \\ ���̱�
		System.out.println(array.length);
		for(String s : array) {
			System.out.println(s);
		}
		//java, javascript, DB >> ���� ǥ����
		//000-{\d4}-0000
		//000-1111-0000 ���� : true
		//000-11-0000 ���� : false
		
		//����(����ǥ���� 5�� ����� ����) ������
		//�ַ� ���̾��̴� ��
		//�ֹι�ȣ, �����ȣ, ��ȭ��ȣ, �̸���, ...
		//���� ���� ������ ��..
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7, "/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//�ͼ��� quiz
		String s8 ="ȫ             ��          ��";
		//����"ȫ�浿" �������� ����
		System.out.println(s8.replace(" ", "")); // " "������ "" ��
		
		String s9 = "         ȫ�浿        ";
		System.out.println(s9);
		System.out.println(s9.trim()); //���� ���� ����
		
		String s10 = "  ȫ  ��  ��  ";
		//ȫ�浿
		
		//�ٺ�..
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2);
		
		//�������� �Լ��� ������ ���(method chain)
		//*****************************************
		System.out.println(s10.trim().replace(" ",""));
		
		//Quiz-1
		int sum=0;
		String[] numarr = {"1","2","3","4","5"};
		//���� : �迭�� �ִ� ���ڰ����� ���� sum ������ ��Ƽ� ����ϼ���
		
		for(String s : numarr) {
			sum += Integer.parseInt(s) ;
		}
		System.out.println(sum);
		
		//Quiz-2
		String jumin = "123456-1234567";
		sum=0;
		//�� �ֹι�ȣ�� ���� ���ϼ���
		String juminnum = jumin.replace("-", "");
		for(int i=0; i<13 ; i++) {
			sum += Integer.parseInt(juminnum.substring(i,i+1));
		}
		System.out.println(sum);
		
		
		
	}

}





