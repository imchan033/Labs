import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
 
class Lotto implements Serializable {
 
    HashSet<Integer> lottoNumbers = new HashSet<Integer>();
    boolean isAuto = true;
    Date issueDate;
    Date pickingDate;
 
    // �����Է� + �������� �ڵ�
    public void generateNumber() { 
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("������ȣ�� �Է��ϼ���. ex) 2 34 12 ");
            System.out.println("������ȣ�� ������ ������ ��ȣ�� �ڵ������˴ϴ�. ");
 
            String numbers = sc.nextLine();
            if (!numbers.equals("")) {
                String[] lot = numbers.split(" ");
                if (lot.length > 6) {
                    System.out.println("6�� ���ϸ� �Է��ϼ���");
                    return;
                }
 
                if (lot.length >= 1) {
                    this.isAuto = false;
                }
                for (String s : lot) {
                    if (Integer.parseInt(s) > 45 || Integer.parseInt(s) < 1) {
                        System.out.println("1���� 45������ ���ڸ� �Է��ϼ���");
                        return;
                    }
                }
                for (String s : lot) {
                    lottoNumbers.add(Integer.parseInt(s));
                }
            }
 
            while (lottoNumbers.size() < 6) {
                lottoNumbers.add((int) (Math.random() * 45 + 1));
            }
 
            this.issueDate = new Date();
            this.pickingDate = getPickingDay(this.issueDate);
            return;
 
        }
    }
 
    // �ش����� ���� ���� ������� ��¥
    public Date getPickingDay(Date date) {
        Date pickday = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 7 - dayWeek);
        return cal.getTime();
    }
 
    @Override
    public String toString() {
        return "Lotto [lottoNumbers=" + lottoNumbers + ", isAuto=" + isAuto + ", issueDate=" + issueDate
                + ", pickingDate=" + pickingDate + "]";
    }
 
}
 
public class Hw03_Lotto_File{
 
    static HashMap<Integer, Lotto> lottoMap = new HashMap<Integer, Lotto>();
    static Scanner scan = new Scanner(System.in);
    static int num = 1;
 
    // ���� ���ϱ�
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
 
    public static void addLotto() {
        Lotto lotto = new Lotto();
        lotto.generateNumber();
        lottoMap.put(num, lotto);
        num++;
        printLotto();
    }
 
    public static void deleteLotto() {
        System.out.println("������ ���ڸ� �Է��ϼ���");
        int number = Integer.parseInt(scan.nextLine());
        if (lottoMap.containsKey(number)) {
            lottoMap.remove(number);
        }
        printLotto();
    }
 
    public static void printLotto() {
        if (lottoMap.size() > 0) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            DecimalFormat nf = new DecimalFormat("\u00A4#,###");
            // lottoMap.
            Set set = lottoMap.keySet();
            List<Integer> alist = new ArrayList<Integer>(set);
            Iterator<Integer> itr = set.iterator();
            Date today = lottoMap.get(alist.get(0)).issueDate;
            Date pickday = lottoMap.get(alist.get(0)).pickingDate;
            String auto = "����";
            int num = 0;
 
            System.out.println("\t �� 599 ȸ");
 
            System.out.println("������ : " + df.format(today) + "   (" + getWeek(today) + ")");
            System.out.println("��÷�� : " + df.format(pickday) + "   (" + getWeek(pickday) + ")");
            System.out.println("---------------------------------");
 
            while (itr.hasNext()) {
                num = itr.next();
                List<Integer> list = new ArrayList<Integer>(lottoMap.get(num).lottoNumbers);
                Collections.sort(list);
                // if(lottoMap.get(num).isAuto==true) {auto="�ڵ�";}
 
                System.out.println(num + (lottoMap.get(num).isAuto == true ? " �ڵ� " : " ���� ") + " " + list.toString());
            }
 
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println("�ݾ�                        " + nf.format(set.size() * 1000));
            System.out.println();
            System.out.println();
 
        }
 
    }
 
    public static void saveLotto() {
        File file = new File("lotto.obj");
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
 
            oos.writeObject(lottoMap);
 
        } catch (Exception e) {
            System.out.println("�����߻�!!!");
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("����Ǿ����ϴ�.");
 
    }
 
    public static void loadLotto() {
        File file = new File("lotto.obj");
        FileInputStream fis = null;
        ObjectInputStream oos = null;
        
        try{
            fis = new FileInputStream(file);
            oos = new ObjectInputStream(fis);
            
            lottoMap = (HashMap)oos.readObject();
            Set keys = lottoMap.keySet();
            Iterator<Integer> itr = keys.iterator();
            while(itr.hasNext()) {
                num = itr.next()+1;        // ������ ���� ������
            }
            
        }catch(Exception e){
            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
 
        }
        
        printLotto();
 
    }
 
    public static void main(String[] args) {
 
        System.out.println("���� �ζ� 6/45");
        while (true) {
            System.out.print("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� : ");
            String choice = scan.nextLine();
            switch (choice) {
            case "1":
                addLotto();
                break;
            case "2":
                deleteLotto();
                break;
            case "3":
                printLotto();
                break;
            case "4":
                saveLotto();
                break;
            case "5":
                loadLotto();
                break;
            case "6":
                System.out.println("���� �ζ� 6/45�� �����մϴ�.");
                System.exit(0);
                break;
            default:
                printLotto();
                break;
            }
 
        }
    }
}