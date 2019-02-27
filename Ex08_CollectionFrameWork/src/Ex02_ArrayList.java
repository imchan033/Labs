import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		System.out.println(arraylist.toString()); //ArrayList�� object�� ������ �ִ� toString()�� ��������
		for(int i=0 ; i<arraylist.size() ; i++) {
			System.out.println(arraylist.get(i));
		}
		
		System.out.println("����:[0]"+arraylist.get(0));
		//add ������ �߰� �ϴ� �Լ�(�⺻���� �߰� ����������)
		//�����������  ������ �߰�, ����
		
		arraylist.add(0,111); 		   // ����°� �ƴ϶� �о�� (������ �ִ� �ڿ� �ڸ��̵�)
		System.out.println(arraylist); //[111, 100, 200, 300]
		
		//������ ���� add default (�ǵ� ����������...)
		//������ ���� add �߰��� �߰�, ����...
		//ArrayList �߰��� �����͸� �߰� �ϰų�, �����ϴ� �۾��� ���ɿ�...���� �ʴ�
		//�������� ������ �߰� ������ ���ƿ�!
		arraylist.remove(0);
		System.out.println("size : " + arraylist.size());
		System.out.println("remove : "+ arraylist.toString());
		
		//ArrayList �Լ�
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(333));
		
		System.out.println(arraylist.isEmpty()); //�� ��� �ִ�?... �ִµ� false
		arraylist.clear(); 						 //������ ����
		System.out.println(arraylist.isEmpty()); //clear >> size == 0 >> true

		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		
		System.out.println(arraylist.toString());
		
		Object value = arraylist.remove(0);//�ʿ��ϴٸ� �������� ���� ���� �� �ִ�
		System.out.println("value : "+value);
		System.out.println(arraylist.toString());
		
		ArrayList list = new ArrayList();
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		
		System.out.println("ArrayList : �������� "+list.toString());
		list.remove("��"); //���������� ã�Ƽ� �ɸ��� ����
		System.out.println("ArrayList : remove "+list.toString());
		
		//�� �ڵ��... �ſ� �߿��մϴ�
		List li = new ArrayList(); //�ڵ� ���� ������ (�θ�Ÿ��)
		//li = new Vector();
		//List �������̽��� �θ� Ÿ������
		
		li.add("��");
		li.add("��");
		li.add("��");
		li.add("��");
		
		//System.out.println(li.toString());
		List li4 = li.subList(0, 2); //[��, ��]
		System.out.println(li4.toString());
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(7);
		alist.add(15);
		System.out.println("before : "+alist.toString());
		//Arrays.sort()
		Collections.sort(alist);
		System.out.println("after : "+alist.toString());
		
		
		
		
		
		
		
	}

}
