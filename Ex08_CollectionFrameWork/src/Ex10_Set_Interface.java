import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Set �������̽��� �����ϰ� �ִ� Ŭ����
//Set ����(x), �ߺ�(x) ������ ������ �ٷ궧...
//�����ϴ� Ŭ���� : HashSet, TreeSet
//���� �������� �ʾƿ� (���� ������ �������� �ʾƿ�)
public class Ex10_Set_Interface {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(100);
		hs.add(55);
		System.out.println(hs.toString());
		//1. �ߺ� ������ ó��(POINT)
		boolean bo = hs.add(1);
		//������ ���� ������ ������ �߰�(x)
		System.out.println(bo); //false
		hs.add(2);
		System.out.println(hs.toString());
		
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		System.out.println(hs2.toString());
		//������ �������� �ʴ´�(����������)
		
		//1.�ߺ� ������ ������� �ʾƿ� (�ϻ� ��Ȱ���� �ߺ������� �ȵǿ�)
		String[] obj = {"A","B","A","C","D","B","A"};
		HashSet<String> hs3 = new HashSet<String>();
		for(int i=0 ; i<obj.length; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());
		
		//Quiz
		//HashSet ����ؼ� 1~45���� ���� 6���� ��������(add)
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		while(lotto.size()<6) {
			int number = (int)(Math.random()*45)+1;
			lotto.add(number);
		}
		System.out.println(lotto.toString());
		
		Set set = new HashSet(); //������ �θ�Ÿ��
		for(int i =0; set.size()<6; i++) {
			int number = (int)(Math.random()*45)+1;
			set.add(number);
		}
		System.out.println(set.toString());
		
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFFF");
		set3.add("1");
		set3.add("2");
		set3.add("��");
		set3.add("��");
		System.out.println(set3.toString());
		
		Iterator<String> s = set3.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		}//add �� ������ �������� �ʾƿ�(�迭�� �ƴϿ���)
		
		//Collections.sort(List<T> list); List �������̽��� �����ϴ� ��� ��ü�� parameter��
		
		//Set �������̽��� �����ϴ� HashSet ������ ��ٰ�...������ ����.. �ȵǳ�
		//HashSet >> sort ����(x)
		
		List list = new ArrayList(set3);
		System.out.println("before : ������ >> "+list.toString());
		Collections.sort(list);
		System.out.println("after : ���� >> " +list.toString());
		
	}
}
