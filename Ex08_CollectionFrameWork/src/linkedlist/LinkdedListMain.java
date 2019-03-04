package linkedlist;

import java.util.Scanner;

public class LinkdedListMain {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();

		list.addLast(100);
		list.addLast(200);
		list.addLast(400);
		list.addLast(500);
		System.out.println(list);

		list.addAtmiddle(2, 300);
		list.addFirst(50);
		System.out.println(list);

		// �ε����� �˻�
		System.out.println(list.getNodeData(4));

		list.removeAtmiddle(2);
		list.removeByData(new Integer(400));
		System.out.println(list);

		list.removeFirst();
		list.removeLast();
		System.out.println(list);

		System.out.println("ũ��" + list.getListsize());
		/*
		 * long starttime=0; long endtime=0; for(int i=0; i<1000000;i++){ list.add(i); }
		 * 
		 * //remove System.out.print("���� �� index�� ���� :"); Scanner scan = new
		 * Scanner(System.in); int index = scan.nextInt();
		 * 
		 * starttime=System.currentTimeMillis();
		 * 
		 * list.remove(index);
		 * 
		 * endtime = System.currentTimeMillis(); long zz=endtime-starttime;
		 * 
		 * System.out.println(starttime); System.out.println(endtime);
		 * System.out.println("�����ϴµ� �ɸ��� �ð� : " +zz
		 * 
		 */
	}

}
