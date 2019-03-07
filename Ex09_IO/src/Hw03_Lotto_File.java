import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// ������
// ��÷��
// A B C D E
// �ݾ�
public class Hw03_Lotto_File {
    public static String randomNumber() {
        HashSet<Integer> lotto = new HashSet<Integer>();
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45 + 1));
        }
        List<Integer> list = new ArrayList<Integer>(lotto);
        Collections.sort(list);
        // return list.toString().replace("[", "").replace("]","");
        return list.toString();
    }
    
    public static String manualNumber() {
        HashSet<Integer> lotto = new HashSet<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("������ȣ�� �Է��ϼ���. ex) 2 34 12 ");
        System.out.println("������ȣ�� ������ ������ ��ȣ�� �ڵ������˴ϴ�. ");
        String numbers = sc.nextLine();
        
        if(!numbers.equals("")) {
            String[] lot = numbers.split(" ");
            if(lot.length > 6) {
                System.out.println("6�� ���ϸ� �Է��ϼ���");
                System.exit(0);
            }
            for (String s : lot) {
                if(Integer.parseInt(s)>45 ||Integer.parseInt(s)< 1) {
                    System.out.println("1���� 45������ ���ڸ� �Է��ϼ���");
                    System.exit(0);
                }
            }
            
            
            for (String s : lot) {
                lotto.add(Integer.parseInt(s));
            }
        }
        
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45 + 1));
        }
        List<Integer> list = new ArrayList<Integer>(lotto);
        Collections.sort(list);
        return list.toString();
    }
    public static void lottoSet(int num) {
        List<String> set = new ArrayList<String>();
        char ch = 'A';
        for (int i = 0; i < num; i++) {
            set.add(randomNumber());
        }
        Iterator<String> itr = set.iterator();
        PrintWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        DecimalFormat nf = new DecimalFormat("\u00A4#,###");
        Date today = new Date();
        Date pickday = getPickingDay(today);
        try {
            fw = new PrintWriter("lotto.txt");
            fw.println("\t �� 599 ȸ");
            
            fw.println("������ : " + df.format(today) + "   (" + getWeek(today) + ")");
            fw.println("��÷�� : " + df.format(pickday) + "   (" + getWeek(pickday) + ")");
            fw.println("---------------------------------");
            while (itr.hasNext()) {
                fw.println(ch + "  " + itr.next());
                ch++;
            }
            fw.println("---------------------------------");
            fw.println();
            fw.println("�ݾ�                        " + nf.format(num * 1000));
            fw.println();
            fw.println();
            fw.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
    public static void showLotto() {
        FileReader fw = null;
        BufferedReader bw = null;
        try {
            fw = new FileReader("lotto.txt");
            bw = new BufferedReader(fw);
            String line = "";
            while ((line = bw.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getWeek(Date date) {
        String day = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayWeek) {
        case 1:
            day = "��";
            break;
        case 2:
            day = "��";
            break;
        case 3:
            day = "ȭ";
            break;
        case 4:
            day = "��";
            break;
        case 5:
            day = "��";
            break;
        case 6:
            day = "��";
            break;
        case 7:
            day = "��";
            break;
        }
        return day;
    }
    public static Date getPickingDay(Date date) {
        Date pickday = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 7-dayWeek);
        return cal.getTime();
    }
    
    public static void main(String[] args) {
        // �ڵ�
        lottoSet(5);
        showLotto();
        
        // ���� (�λ��� �̿ϼ�)
        String numbers=manualNumber();
        System.out.println(numbers);
        
    }
}