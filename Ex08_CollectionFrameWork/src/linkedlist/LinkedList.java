package linkedlist;

public class LinkedList {
	// ù��° ��带 ����Ű�� �ʵ�
    private Node head;
    // ������ ��带 ����Ű�� �ʵ�
    private Node tail;
    //����Ʈ�� ����
    private int size = 0;
    
    //��� ���� Ŭ����
   private class Node{
	   private Object data;
	   private Node next;
	   
	   //������
	   public Node(Object input) {
		   //����� data�� input���� ����
		   this.data = input;
		   //���� ��带 ����Ű�� �ʵ��� ���� null ����
		   this.next = null;
	   }
	   
	   public String toString() {
		   return String.valueOf(this.data);
	   }
   }
 
   //Ư�� ��ġ�� ��带 ã�� �޼ҵ�
   Node node(int index) {
	    Node x = head;
    	for (int i = 0; i < index; i++)
	        x = x.next;
	    return x;
	}
   
   //�ʵ��� ù ��° �ε����� ���ο� ��� ����
   public void addFirst(Object input) {
	   //���ο� ��� ����
	   Node newNode = new Node(input);
	   //newNode.next�� ���� head��尡 ����Ű�� �ִ� ��带 ����ų �� �ְ� ���� 
	   newNode.next = head;
	 //����Ʈ�� ù��° ��带 ����Ű�� head�� newNode�� ����Ű�� ��
	   head = newNode;
	   //����Ʈ�� ���̰� �þ�ٴ� ���� ǥ��
	   size++;
	   //
	   if(head.next == null);{
		   tail = head;
	   }
   }
   
   //�ʵ��� �������� ���ο� ��� ����
   public void addLast(Object input) {
	   Node newNode = new Node(input);
	   if(size==0) {
		   addFirst(input);
	   }
	   else{
		   tail.next = newNode;
		   tail = newNode;
	   }
	   size++;
   }

   
   public void add(int index, Object input) {
	   if(index==0) {
		   addFirst(input);
	   }
	   else if(index>=size) {
		   addLast(input);
	   }
	   else {
		   Node temp1 = node(index-1);
		   Node temp2 = node(index);
		   
		   Node newNode = new Node(input);
		   temp1.next = newNode;
		   newNode.next = temp2;
		   size++;
		   if(newNode.next==null)
		   {
			   tail = newNode;
		   }
	   }
   }
   
   //��� ��ü ������ ���
   public String toString() {
	   if(size==0) return "[]";
	   else {
		   Node temp1 = head;
		   String str = "[ ";
		   //������ ��� ������ ������ ���
		   while(temp1.next!=null) {
			   str+=temp1.data+", ";
			   temp1 = temp1.next;
		   }
		   str += temp1.data + "]";
		   return str;
	   }
   }
   
   //Ư�� ��ġ ����� ������ Ž��
   public Object indexToString(int index) {
	   if(size<=index) {
		   return false;
	   }
	   else {
	   Node temp1 = node(index);
	   return temp1.data;
	   }
   }
   
   //ó�� ��� ����
   public Object firstDelete() {
	   Node temp1 = head;
	   head = temp1.next;
	   
	   Object tempData = temp1.data;
	   temp1=null;
	   size--;
	   
	   return tempData;
   }
   
   //Ư�� ��ġ ��� ����(�߰� ��)
   public void indexDelete(int index) {
	   Node temp1 = node(index-1);	   
	   temp1.next = node(index+1);
	   temp1 = null;
   }
 }

