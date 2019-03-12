package kr.or.bit.team1;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


// ����, ȸ���� ��ȣ��


//Order ���
//cancel
//discount
//refund
enum OrderStatus {ORDER, DISCOUNT, CANCEL, REFUND, PAYED};

//����
//ī��
enum PayType {CASH, CARD};

class Menu {
	String name;
	int price;
	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}
	
}

class Table {
	int tableNo;
	OrderList orderList;
	//HashMap<Integer, OrderList> tables= new HashMap<Integer, OrderList>();
	Date date;
	boolean isPayed;
	
	//���̺��̵�
	public void moveTable(int fromTable, int toTable) {// ������ 
		
	}
	//���̺��ֹ���ġ��
	public void mergeTable(int fromTable, int toTable) {//�ǿ��� 
		
	}
}

// �߰��� ��� �׸��� �ʿ�
class OrderList {
	List<Orders> orderlist = new ArrayList<Orders>();
	Customers customer;
	
	//�ֹ������� ������
	public void listOrders() {// �Ǽ��� 
		// �޴���-�ܰ�-����-�ݾ�
	}
	
	//�ֹ�
	public void addOrder(Orders order) { // Menu menu ������ 
	
	}

	//�������
	public void deleteOrder(Orders order) { // ������ 
		
	}
	
	//��ü���
	public void deleteOrderAll() { // ������ 
		
	}
	
	// ������~ ��������
	public void changeQty(Menu menu, int qty) { // ������ 
		
	}
	
	//���� ���ݰ��� // ������ ��������Ʈ�� ������ �ָ���
	public void payCashAll(int amount) {// �Ǽ��� 
		//�����ݾ�, �����ݾ�, �Ž�����
		//����װ� ������ ����
		//���̺� �ʱ�ȭ
		//���������
	}
	
	/*
     * @method name : payCardAll
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ���� ī�����
     *
     * @parameters : 
     *
     * @return : void
     */
	public void payCardAll() { // ������ 
		//�����ݾ�
		//���̺��ʱ�ȭ
		//���������
		int amount=0; //�ݾ�
		for(int i=0; i<orderlist.size();i++) {
			//orderlist.
		}
	}
	
	public void payCash(int no, int amount) {//�Ǽ��� 
		
	}
	
	public void payCard(int no, int amount) {//�ǿ��� 
		
	}
	
	public void payDivideAmount(int amount) {//������ 
		
	}
	
	
	
//	print receipt
	public void printReceipt() {// �ǿ��� 
		
	}
	
	//ȸ�����
	public void addMembers(Customers customers) {// ������ 
	}
	
	//����Ʈ ����
	public void addPoints(Customers customers, String phoneNumber) {// ������ 
		
	}
	
	/*
     * @method name : usePoints
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ����Ʈ���
     *
     * @parameters : Customers customers, String phoneNumber
     *
     * @return : void
     */
	public void usePoints(Customers customers, String phoneNumber) {// ������ 
		
	}
	
	
	
	//����Ʈ ���

}

class Orders {
	static Long orderId;
	Date orderDate;
	Menu	menuItem;
	Payments payment;
	
	public Orders(Date orderDate, Menu menuItem, Payments payment) {
		super();
		this.orderDate = orderDate;
		this.menuItem = menuItem;
		this.payment = payment;
	}
	
}

interface Payments {
//	����
//	ī��
//	���Ұ��
	public void pay();
		
}

class CashPayments implements Payments {

	@Override
	public void pay() { //������ 
		System.out.println(PayType.CASH);
	}
	/*
     * @method name : addPoints
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ����Ʈ����
     *
     * @parameters : Customers customers, String phoneNumber
     *
     * @return : void
     */
	public void addPoints(Customers customers, String phoneNumber) { //������ 
		int userPoint = customers.customer.get(phoneNumber);
	}
	//����Ʈ ���
	public void usePoints(Customers customers, String phoneNumber) {// �Ǽ��� 
		
	}
	
	
}

class CardPayments implements Payments {

	@Override
	public void pay() {// ������ 
		System.out.println(PayType.CARD);
	}
	
	//����Ʈ ����
	public void addPoints(Customers customers, String phoneNumber) {// �ǿ��� 
		
	}
	//����Ʈ ���
	public void usePoints(Customers customers, String phoneNumber) {// ������ 
		
	}

}




class Customers {
	HashMap<String,Integer> customer = new HashMap<String,Integer>();// Ű��: ��ȭ��ȣ,
	// �����: ����Ʈ 
	
	// �� �߰�
	public void addCustomers(String phoneNumber) {// �Ǽ��� 
		
	}
	// �� ����
	public void modifyCustomers(String oldPhoneNumber, String phoneNumber) {// ������ 
		
	}
	
	// �� ��ȸ
	public void findCustomers(String phoneNumber) { // ������ 
		
	}
	/*
     * @method name : deleCustomers
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : �� Ż��
     *
     * @parameters : String phoneNumber
     *
     * @return : void
     */
	public void deleCustomers(String phoneNumber) { // ������ 
		customer.remove(phoneNumber);
		System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
	}
	
	// ����Ȳ
	public void listCustomers() {// ������ 
		
	}
}


class Pos {
	
	Scanner sc = new Scanner(System.in);
	
	//log ������丮
	String logPath = "C:\\temp\\log";
	
	// ����ݾ�
	Integer amount;
	List<Orders> orders = new ArrayList<Orders>();
	OrderList orderList;
	
	// �ǸŰ���, �������, ȸ������, �޴�����, ���̺����, �ý��� ����
	
	// �ֹ�(���̺�)
	public void orderTable(Integer tableNo, Menu menu) { //������ 
		// ���̺� order add
	}
	/*
     * @method name : addPoints
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ����Ʈ����
     *
     * @parameters : Customers customers, String phoneNumber
     *
     * @return : void
     */
	// ���� (���̺�)
	public void payTableCash(Integer tableNo, Integer amount) { 
		// ���̺��� order�� �ϳ��� �����ͼ� ������
	}

	public void payTableCard(Integer tableNo) {// �Ǽ��� 
		// ���̺��� order�� �ϳ��� �����ͼ� ������
	}

	// ���� (���̺�)
	public void payTableCardAll(Integer tableNo) { // ������ 
		// ���̺��� order�� �Ѱ��� ������������ 
	}
	
	/*
     * @method name : payTableCashAll
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ��ü ���� ����
     *
     * @parameters : Integer tableNo, Integer amount
     *
     * @return : void
     */
	public void payTableCashAll(Integer tableNo, Integer amount) {
//		Scanner sc = new Scanner(System.in);
//		
//		//log ������丮
//		String logPath = "C:\\temp\\log";
//		
//		// ����ݾ�
//		Integer amount;
//		List<Orders> orders = new ArrayList<Orders>();
//		OrderList orderList;
		
//		class Orders {
//			static Long orderId;
//			Date orderDate;
//			Menu	menuItem;
//			Payments payment;	
//		}
		
	}
	
	
	
	List<Menu> menuItem = new ArrayList<Menu>();
	// �޴�����
	/*
     * @method name : addMenu
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : �޴��߰�
     *
     * @parameters : String name, Integer price
     *
     * @return : void
     */
	public void addMenu(String name, Integer price) { 
		menuItem.add(new Menu(name, price));	
	}
	// �޴� ����
	public void modifyMenu(String oldname, String name, Integer price) {// ������ 
		
	}
	// �޴� ����
	public void deleteMenu(String name) {// �ǿ��� 
		
	}
	
	// ���̺����
	List<Table> tables = new ArrayList<Table>();
	// ���̺� �߰�
	public void addTables() {// �Ǽ��� 
		
	}
	// ���̺� ����
	public void deleteTables() {//������ 
		
	}
	
	// ������
	Customers customers = new Customers(); 
	
	//������
	
	//����ȸ
	//��Ż��
	//����Ȳ
	
	// overloading
//	public void deleCustomers(String name) {
//		
//	}
	
	
	/*
     * @method name : cashAdjustment
     *
     * @date : 2019.03.12
     *
     * @author : ������
     *
     * @description : ���ݽ������ �����ش�
     *
     * @parameters : 
     *
     * @return : void
     */	
	public void cashAdjustment() { 
		int cashonhand = 100000;
		 System.out.println("���ݽ���� : "+cashonhand);
	}
	// ����
	// �޴��� ���� (�Ϻ�)
	public void printSalesMenu(String date) { //������ 
		// �޴�-����-�ݾ�
	}

	// ������ ���� (�Ϻ�)
	public void printSalesPayment(String date) { // ������ 
		// �޴�-ī��(����)-����-�ݾ�
	}

	// ���� export (�޴���,������ ����)
	public void exportToExcel(String salesType) {// ������ 
		
	}

	// ������ ���� (�ý��� ����� ������ ����)
	public void save(String date) { //�ǿ��� 
		
	}
	// ������ �ε� (�ý��� ���۽� ������ �ε�)
	public void load(String date) {// �ǿ��� 
		
	}
	// �Ϻ� log // method���� util���� ���ǵ� ���� ���
}

public class Pro1_Frame {
	public static void main(String[] args) {

	}
}