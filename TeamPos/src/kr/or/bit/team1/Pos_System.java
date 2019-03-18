package kr.or.bit.team1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kr.or.bit.team1.util.TeamFormat;
import kr.or.bit.team1.util.TeamLogger;

enum OrderStatus {
	ORDER, DISCOUNT, CANCEL, REFUND, PAYED
};

enum PayType {
	CASH, CARD
};

class Table implements Serializable {

	HashMap<Integer, Bucket> tablelist;
	Date date;1
	
	boolean isPayed; // @ deprecated

	// �젙�씪李� : �깮�꽦�옄蹂�寃�
	public Table() {
		TeamLogger.info("Table()");
		tablelist = new HashMap<Integer, Bucket>();
		this.date = new Date();
		this.isPayed = false;

	}

	

	// �젙�씪李� :
	// addOrdetList 異붽�
	public void addOrderList(Integer tableNo, Bucket orderList) {
		TeamLogger.info("addOrderList(Integer tableNo, OrderList orderList)");
		tablelist.put(tableNo, orderList);
	}

	// �뀒�씠釉� �씠�룞
	// FIX
	public void moveTable(int fromTable, int toTable) {// 媛뺢린�썕
		TeamLogger.info("moveTable(int fromTable, int toTable)");
		Bucket temp = new Bucket();
		temp = tablelist.get(fromTable);
		tablelist.put(toTable, temp);
		tablelist.remove(fromTable);
	}

	// �뀒�씠釉� 二쇰Ц �빀移섍린
	public void mergeTable(int fromTable, int toTable) {// 沅뚯삁吏�
		Bucket temp = new Bucket();
		temp = tablelist.get(fromTable);
		Bucket temp2 = new Bucket();
		temp2 = tablelist.get(toTable);

		for (int i = 0; i < temp2.orderlist.size(); i++)
			temp.orderlist.add(temp2.orderlist.get(i));

	}

	// �뀒�씠釉� 異붽�
	// �젙�씪李� OrderList orderList parameter �궘�젣
	public void addTable(int tableNo) {// 沅뚯닚議�
		TeamLogger.info("addTable(int tableNo)");
		this.tablelist.put(tableNo, null);

	}

	// �뀒�씠釉� �궘�젣
	// �젙�씪李� int tableNo parameter 異붽�
	// FIX
	public void deleteTable(int tableNo) {// 媛뺢린�썕
		for (Map.Entry<Integer, Bucket> obj : tablelist.entrySet()) {
			if (obj.getValue().isPayed) {
				tablelist.put(obj.getKey(), new Bucket());
			}
		}
	}

}

class Bucket implements Serializable {
	ArrayList<Orders> orderlist;
	Customers customer;
	Payments payment;
	boolean isPayed;

	public Bucket() {
		this.orderlist = new ArrayList<Orders>();
		this.customer = null;
		this.payment = null;
		this.isPayed = false;
	}

	/*
	 * @method name : listOrders
	 *
	 * @date : 2019.03.14
	 *
	 * @author : 沅뚯닚議�
	 *
	 * @description : 二쇰Ц�궡�뿭�쓣 蹂댁뿬以��떎
	 *
	 * @parameters :
	 *
	 * @return : void
	 */
	public void listOrders() {
		TeamLogger.info("listOrders");
		Set<String> menuSet = new HashSet<String>();

		for (int i = 0; i < orderlist.size(); i++) {
			if (menuSet.add(orderlist.get(i).menuItem.name)) {
				String name = orderlist.get(i).menuItem.name;
				int price = orderlist.get(i).menuItem.price;
				int quty = menuQty(orderlist.get(i).menuItem);
				int bill = price * quty;
				System.out.printf("硫붾돱: %s\t        �떒媛�: %d   �닔�웾: %d   湲덉븸: %d\n", name, price, quty, bill);
			}
		}
	}

	/*
	 * @method name : addOrder
	 *
	 * @date : 2019.03.12
	 *
	 * @author : �떊吏��쁺
	 *
	 * @description : order瑜� 異붽��븳�떎.
	 *
	 * @parameters : Orders order
	 *
	 * @return : void
	 */
	public void addOrder(Orders order) {
		TeamLogger.info("addOrder");
		orderlist.add(order);
	}

	/*
	 * @method name : deleteOrder
	 *
	 * @date : 2019.03.14
	 *
	 * @author : 媛뺢린�썕
	 *
	 * @description : order瑜� �젣嫄고븳�떎.
	 *
	 * @parameters : Orders order
	 *
	 * @return : void
	 */
	public void deleteOrder(Orders order) { // 媛뺢린�썕
		TeamLogger.info("deleteOrder(Orders order)");
		if (order != null) {
			changeQty(order.menuItem, -1);
		}
	}

	/*
	 * @method name : deleteOrderAll
	 *
	 * @date : 2019.03.13
	 *
	 * @author : �떊吏��쁺
	 *
	 * @description : �쟾泥� order瑜� �젣嫄고븳�떎.
	 *
	 * @parameters :
	 *
	 * @return : void
	 */
	public void deleteOrderAll() {
		TeamLogger.info("deleteOrderAll");
		int num = orderlist.size();
		orderlist.removeAll(orderlist);
	}

	/*
	 * @method name : changeQty
	 *
	 * @date : 2019.03.13
	 *
	 * @author : �떊吏��쁺
	 *
	 * @description : �쟾泥� order瑜� �젣嫄고븳�떎.
	 *
	 * @parameters : Menu menu, int qty
	 *
	 * @return : void
	 * 
	 * @example �빐�떦 硫붾돱瑜� 2媛� 異붽��븯硫� qty=2, 2媛� �젣�쇅�븯硫� qty=-2
	 */
	public void changeQty(Menu menu, int qty) {
		TeamLogger.info("changeQty(Menu menu, int qty)");
		if (qty < 0) { // 二쇰Ц痍⑥냼

			int orderedQty = menuQty(menu);
			int canceledQty = Math.abs(qty);
			if (canceledQty <= orderedQty) {
				while (canceledQty > 0) {
					if (orderlist.indexOf(getOrder(menu)) != -1) {
						orderlist.remove(orderlist.indexOf(getOrder(menu)));
					}
					canceledQty--;
				}
			} else {
				System.out.println("二쇰Ц�닔蹂대떎 留롮� 媛��닔瑜�  痍⑥냼�뻽�뒿�땲�떎.");
			}
		} else if (qty > 0) { // 二쇰Ц異붽�
			for (int i = 1; i <= qty; i++) {
				orderlist.add(new Orders(menu));
			}
		}

	}

	/*
	 * @method name : payCashAll
	 *
	 * @date : 2019.03.14
	 *
	 * @author : 沅뚯닚議�
	 *
	 * @description : �쁽湲덉쑝濡� 寃곗젣 湲덉븸 �쟾�븸 泥섎━�븳�떎.
	 *
	 * @parameters : int amount, Customers customer
	 *
	 * @return : void
	 */
	public void payCashAll(int amount, Customers customer) {
		TeamLogger.info("payCashAll");

		if (amount > orderSum()) {
			int change = 0; // 嫄곗뒪由꾨룉�쓣 ���옣�븷 怨듦컙 �꽑�뼵

			Scanner sc = new Scanner(System.in);

			System.out.println("�룷�씤�듃 �궗�슜 : 1, �룷�씤�듃 誘몄궗�슜 :2");
			int i = Integer.parseInt(sc.nextLine());
			if (i == 1) {
				System.out.println("怨좉컼 �빖�뱶�룿踰덊샇瑜� �엯�젰�븯�꽭�슂");
				String s = sc.nextLine();
				if (customer.customer.containsKey(s)) {
					int point = customer.customer.get(s);
					change = amount + point - orderSum();// 諛쏆쓣湲덉븸, 諛쏆�湲덉븸, 嫄곗뒪由꾨룉

					Pos.amount = Pos.amount + amount - point - change;
					this.customer = customer.findCustomers(s);
					customer.setPoint(s, 0);                     // point 0
					System.out.println("諛쏆쓣 湲덉븸 : " + orderSum());
					System.out.println("�룷�씤�듃     : " + point);
					System.out.println("諛쏆� 湲덉븸 : " + amount);
					System.out.println("諛쏆� 湲덉븸 : " + change);
				} else {
					System.out.println("�빐�떦 怨좉컼�씠 �뾾�뒿�땲�떎.");
					return;
				}
			} else if (i == 2) {
				change = amount - orderSum();

				Pos.amount = Pos.amount + amount - change;

				System.out.println("諛쏆쓣 湲덉븸 : " + orderSum());
				System.out.println("諛쏆� 湲덉븸 : " + amount);
				System.out.println("諛쏆� 湲덉븸 : " + change);
			}

			this.isPayed = true;
			this.payment = new CashPayments();

			printReceipt();// �쁺�닔利� 異쒕젰
		} else {
			System.out.println("湲덉븸�씠 遺�議깊빀�땲�떎.");
		}
	}

	/*
	 * @method name : payCardAll
	 *
	 * @date : 2019.03.14
	 *
	 * @author : �씠�옒李�
	 *
	 * @description : 移대뱶濡� 寃곗젣 湲덉븸 �쟾�븸 泥섎━�븳�떎.
	 *
	 * @parameters : Customers customer
	 *
	 * @return : void
	 */
	public void payCardAll(Customers customer) { // �씠�옒李�

			Scanner sc = new Scanner(System.in);

			System.out.println("�룷�씤�듃 �궗�슜 : 1, �룷�씤�듃 誘몄궗�슜 :2");
			int i = Integer.parseInt(sc.nextLine());
			if (i == 1) {
				System.out.println("怨좉컼 �빖�뱶�룿踰덊샇瑜� �엯�젰�븯�꽭�슂");
				String s = sc.nextLine();
				if (customer.customer.containsKey(s)) {
					int point = customer.customer.get(s);

					this.customer = customer.findCustomers(s);
					customer.setPoint(s, 0);                     // point 0
					System.out.println("諛쏆쓣 湲덉븸 : " + orderSum());
					System.out.println("�룷�씤�듃     : " + point);
					System.out.println("寃곗젣 湲덉븸  : " + (orderSum()-point));
				} else {
					System.out.println("�빐�떦 怨좉컼�씠 �뾾�뒿�땲�떎.");
					return;
				}
			} else if (i == 2) {
				System.out.println("諛쏆쓣 湲덉븸 : " + orderSum());
				System.out.println("寃곗젣 湲덉븸  : " + orderSum());
			}

			this.isPayed = true;
			this.payment = new CardPayments();

			printReceipt();// �쁺�닔利� 異쒕젰
	}

	/*
	 * @method name : payCash
	 *
	 * @date : 2019.03.12
	 *
	 * @author : 沅뚯닚議�
	 *
	 * @description : �쁽湲덉쑝濡� 寃곗젣 湲덉븸�쓣 泥섎━�븳�떎.
	 *
	 * @parameters : int no, int amount > int amount
	 *
	 * @return : int
	 */
	// ?
	public int payCash(int amount) {// 沅뚯닚議�

		int result = 0;// �쁽湲덉쓣 �븳踰� 怨꾩궛�븯怨� �궓�� 湲덉븸�쓣 ���옣�븷 怨듦컙
		int sum = 0; // 援щℓ�븳 臾쇳뭹�쓽 珥앺빀�쓣 援ы븯�뒗 怨듦컙 �꽑�뼵
		result = orderSum() - amount;// 臾쇨굔�쓽 珥앺빀�뿉�꽌 諛쏆� �쁽湲덉쓣 혮腰� �궓�� 寃껋쓣 寃곌낵濡� ���옣
		return result; // 由ы꽩�썑 payDividieAmount�뿉�꽌 �궗�슜
	}

	// ?
	public int payCard(int amount) {// 沅뚯삁吏�

		int result = 0;// �쁽湲덉쓣 �븳踰� 怨꾩궛�븯怨� �궓�� 湲덉븸�쓣 ���옣�븷 怨듦컙
		result = orderSum() - amount;// 臾쇨굔�쓽 珥앺빀�뿉�꽌 諛쏆� �쁽湲덉쓣 혮腰� �궓�� 寃껋쓣 寃곌낵濡� ���옣
		return result; // 由ы꽩�썑 payDividieAmount�뿉�꽌 �궗�슜
	}

	// FIX
	public void payDivideAmount(int no, int amount) {// �씪李щ떂
		if (no == 3) {
			do {
				System.out.println("寃곗옱 諛⑹떇�쓣 �꽑�깮�븯�꽭�슂");
				Scanner sc = new Scanner(System.in);
				int select = Integer.parseInt(sc.nextLine());
				if (select == 1) {// 1�쓣
					System.out.println("�쁽湲� 寃곗옱瑜� �꽑�깮�븯�뀲�뒿�땲�떎.");
					payCash(amount);

				} else if (select == 2) {
					System.out.println("移대뱶 寃곗옱瑜� �꽑�깮�븯�뀲�뒿�땲�떎.");
					payCard(amount);
				}
			} while (payCard(amount) == 0 || payCash(amount) == 0);
		}
	}

//	print receipt
	// ADJUST tf
	public void printReceipt() {// 沅뚯삁吏�, �뙆�씪硫뷀꽣�뿉table�쓽二쇱넖媛믪쓣諛쏄쾶諛붽퓭�빞�븷寃껉컳�뒿�땲�떎..
		TeamFormat tf = new TeamFormat();
		Pos pos = new Pos();
		Table t = new Table();
		CardPayments cp = new CardPayments();
		int pay = 0;

		PayType paytype = null;
		System.out.println("�뀒�씠釉붾쾲�샇: " + t.tablelist.get(0) + "\n");
		System.out.println("嫄곕옒�씪�떆: " + tf.dateTimeFormat(t.date));
		System.out.println("嫄곕옒�쑀�삎: " + paytype);
		System.out.println("�븷遺�湲곌컙: �씪�떆遺�");
		System.out.println("=====================================");
		System.out.println("硫붾돱�씠由�\t\t�떒媛�\t�닔�웾\t湲덉븸\t");
		System.out.println("=====================================");
		listOrders();
		System.out.println("=====================================");
		System.out.println("珥앺빀怨�: " + orderSum());
		System.out.println("諛쏆��룉: " + pay);
		System.out.println("\t\t\t\t�쟻由쏀룷�씤�듃: ");

	}

	// �쉶�썝�벑濡� @deprecated
	public void addMembers(Customers customers) {// �떊吏��쁺 @deprecated
	}

	// �룷�씤�듃 �쟻由�
	public void addPoints(Customers customers, String phoneNumber, int amount) { // 沅뚯삁吏�^^
		Bucket orderlist = new Bucket();
		int paypoint = customers.customer.get(phoneNumber);
		customers.customer.put(phoneNumber, (int) (paypoint + (orderlist.orderSum() * 0.05)));
	}

	// �룷�씤�듃 �궗�슜
	// FIX customer瑜� 諛쏆븘�빞 �븿
	public int usePoints(String phoneNumber) {// 沅뚯삁吏�^^
		int usePointsResult = 0;
		int result = 0;
		Customers cus = new Customers();
		Scanner sc = new Scanner(System.in);
		if (!cus.customer.containsKey(phoneNumber)) {
			System.out.println("�벑濡앸맂 �쉶�썝 踰덊샇媛� �뾾�뒿�땲�떎.");
			System.out.println("媛��엯�븯�떆寃좎뒿�땲源�?");
			System.out.println("媛��엯 : 1, 痍⑥냼 : 2");
			String st = sc.nextLine();
			if (st == "1") {
				System.out.println("媛��엯�쓣 吏꾪뻾�빀�땲�떎. 踰덊샇瑜� �엯�젰�빐二쇱꽭�슂");
				st = sc.nextLine();
				cus.addCustomers(st);
			} else if (st == "2") {
				System.out.println("�룷�씤�듃 �궗�슜�쓣 痍⑥냼�빀�땲�떎.");
			}
		} else {
			usePointsResult = cus.customer.get(phoneNumber);
			cus.customer.put(phoneNumber, 0);
		}
		return usePointsResult;
	}

	// FIX : 湲곗〈 customer媛앹껜瑜� 媛��졇���빞 �븿
	public void isUsePoint() { // 沅뚯삁吏�
		Scanner sc = new Scanner(System.in);
		System.out.println("�룷�씤�듃瑜� �궗�슜�븯�떆寃좎뒿�땲源�?");
		String choice = sc.nextLine();// �룷�씤�듃瑜� �궗�슜�븷吏� �솗�씤�븯�뒗 濡쒖쭅 �떆�옉
		if (choice.equals("Y")) {
			System.out.println("�룷�씤�듃�궗�슜 濡쒖쭅 �떆�옉�빀�땲�떎.");
			String phNum = sc.nextLine();
			usePoints(phNum);
		} else if (choice.equals("N")) {
			System.out.println("媛��엯�븯�떆寃좎뒿�땲源�? Y/N");
			String choice2 = sc.nextLine();
			if (choice.equals("Y")) {
				choice2 = sc.nextLine();
				Customers customers = new Customers();
				customers.addCustomers(choice2);
			} else if (choice.equals("N")) {
				System.out.println("寃곗젣 濡쒖쭅 �떆�옉�빀�땲�떎.");
			}
		}
	}

	/*
	 * @method name : orderSum
	 *
	 * @date : 2019.03.12
	 *
	 * @author : 沅뚯닚議�
	 *
	 * @description : 援щℓ�븳 臾쇳뭹 湲덉븸�쓽 �빀怨꾨�� 援ы븳�떎.
	 *
	 * @parameters :
	 *
	 * @return : int
	 */
	public int orderSum() {
		TeamLogger.info("orderSum");
		int sum = 0;
		for (int i = 0; i < orderlist.size(); i++) {
			Orders order = orderlist.get(i);
			sum += order.menuItem.price;
		}
		return sum;// �빀怨꾨�� 諛섑솚
	}

	/*
	 * @method name : menuQty
	 *
	 * @date : 2019.03.13
	 *
	 * @author : �젙�씪李�
	 *
	 * @description : �빐�떦 硫붾돱蹂� �닔�웾�쓣 諛섑솚
	 *
	 * @parameters : Menu menu
	 *
	 * @return : int
	 */

	public int menuQty(Menu menu) {
		TeamLogger.info("menuQty(Menu menu)");
		int qty = 0;
		for (int i = 0; i < this.orderlist.size(); i++) {
			if (orderlist.get(i).menuItem.name.trim().equalsIgnoreCase(menu.name.trim())) {
				qty++;
			}
		}
		return qty;
	}

	/*
	 * @method name : getOrder
	 *
	 * @date : 2019.03.13
	 *
	 * @author : �젙�씪李�
	 *
	 * @description : �빐�떦 硫붾돱�뿉 �빐�떦�븯�뒗 order瑜� 諛섑솚
	 *
	 * @parameters : Menu menu
	 *
	 * @return : Orders
	 */
	public Orders getOrder(Menu menu) {
		TeamLogger.info("getOrder");
		Orders order = null;
		for (int i = 0; i < this.orderlist.size(); i++) {
			if (orderlist.get(i).menuItem.equals(menu)) {
				order = orderlist.get(i);
			}
		}
		return order;
	}

	@Override
	public String toString() {
		return "Bucket [orderlist=" + orderlist + ", customer=" + customer + ", payment=" + payment + ", isPayed="
				+ isPayed + "]";
	}
	
}

class Pos implements Serializable {

	transient Scanner sc = new Scanner(System.in);

	// log ���옣�뵒�젆�넗由�
	String logPath = "C:\\temp\\log";

	// �떆�옱湲덉븸
	static int amount = 200000;
	static int tableCount=0;
	List<Orders> orders = new ArrayList<Orders>();
	Bucket orderList;
	Table tables = new Table();
	List<Menu> menuList = new ArrayList<Menu>();
	Customers customers = new Customers();

	// log寃쎈줈 �꽕�젙
	Pos() {
		TeamLogger.getLogger(logPath);
		TeamLogger.info("POS System v0.1");
		TeamLogger.info("@copyleft TeamSoft 2019");

		// load(date);
	}

	public void viewTable(int seatCount) {
		
		
		for (int i = 1; i <= seatCount; i++) {
		 if(tables.tablelist.get(i)!=null) {	
			 System.out.printf("[%d �뼚]", i);
		 }else {
			 System.out.printf("[%d �뼞]", i);
			 
		 }
			 
			if (i % 3 == 0) {
				System.out.println();
			}

		}
	     
	     System.out.println("�뼚: �넀�떂�씠 �엳�뒗 �뀒�씠釉� , �뼞: 鍮� �뀒�씠釉�");

	}

	

	void menuManage() {

		while (true) {
			System.out.println(menuList.toString());

			int menuNum = 0;
			String menuName = null;
			String oldName = null;

			int menuPrice = 0;
			System.out.println("硫붾돱瑜� 異붽��븯嫄곕굹 �닔�젙�븷 �닔 �엳�뒿�땲�떎.");
			System.out.println("1.硫붾돱異붽�");
			System.out.println("2.硫붾돱�닔�젙");
			System.out.println("3.硫붾돱�궘�젣");
			System.out.println("4.醫낅즺");;;;
			System.out.println("�썝�븯�뒗 踰덊샇瑜� �엯�젰�븯�꽭�슂");

			menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {

			case 1:
				System.out.println("硫붾돱�씠由�: ");
				menuName = sc.nextLine();

				System.out.println("媛�寃�:");
				menuPrice = Integer.parseInt(sc.nextLine());

				addMenu(menuName, menuPrice);
				break;
			case 2:
				System.out.println("�닔�젙�븷 硫붾돱瑜� �엯�젰�븯�꽭�슂 ");
				oldName = sc.nextLine();

				System.out.println("�깉濡쒖슫 硫붾돱瑜� �엯�젰�븯�꽭�슂 ");
				menuName = sc.nextLine();

				System.out.println("�깉濡쒖슫 媛�寃⑹쓣 �엯�젰�븯�꽭�슂 ");
				menuPrice = Integer.parseInt(sc.nextLine());

				modifyMenu(oldName, menuName, menuPrice);
				break;

			case 3:
				System.out.println("�궘�젣�븷 硫붾돱瑜� �엯�젰�븯�꽭�슂: ");

				menuName = sc.nextLine();

				deleteMenu(menuName);
				break;

			case 4:
				posStart();

			default:
				System.out.println("�떎�떆 �엯�젰�븯�꽭�슂");

			}

		}

	}
	  
	void selectTable() {
		  viewTable(9);
		  int tableNum = 0;
		  System.out.println();
		  System.out.println("�뀒�씠釉붿쓣 �꽑�깮�븯�꽭�슂!  0踰�: �뮘濡쒓�湲�");
		  tableNum = Integer.parseInt(sc.nextLine());
		  if(tableNum == 0) {
			  posStart();
		  }
		 if(tables.tablelist.get(tableNum)==null) {
		  createTable( tableNum );
		 }
		  showMenu(tableNum);
		
		 //System.out.println(orderlist.listOrders()); listOrders(): 諛섑솚媛믪쓣 �뒪�듃留곸쑝濡� 由ы꽩�빐以� 寃� ! 
		 
		 
		 }
	
	public int displayMenu() {
		 int menuNum = 0;
			System.out.println("=====POS SYSTEM=====");
			System.out.println();
			System.out.println("1.�뙋留ㅺ�由�");
			System.out.println("2.留ㅼ텧愿�由�");
			System.out.println("3.�쉶�썝愿�由�");
		    System.out.println("4.硫붾돱愿�由�");
		    System.out.println("5.�뀒�씠釉붽�由�");
		    System.out.println("6.�떆�뒪�뀥醫낅즺");
		    
		    System.out.print("踰덊샇瑜� �엯�젰�븯�꽭�슂:");
		    menuNum = Integer.parseInt(sc.nextLine());
		return menuNum;
	}

	 public void posStart() {
		
	  
	    switch(displayMenu()) {
	    
	    case 1:
	    	 selectTable();
	    	 
	    	  break;
	    case 4:
	    	  menuManage();
	    
	          break;
	          
	    case 5:
            tableManage();
            break;      
	          
	    
	    
	    }
	    	
	    	
	    
		
	}
	 void createTable(int tableNum) {
		 
			 
		 orderList = new Bucket();
		  tables.tablelist.put(tableNum,orderList);
	 }
	
	 void showMenu(int tableNum) {
		  int menuNum = 0; 
		  
		  
		 
		   
		 while(true) {
			 System.out.println("硫붾돱瑜� �꽑�깮�븯�꽭�슂");
			 System.out.println("1.二쇰Ц�븯湲�");
			 System.out.println("2.二쇰Ц�궘�젣");
			 System.out.println("3.二쇰Ц�쟾泥댁궘�젣");
			 System.out.println("4.�닔�웾蹂�寃�");
			 System.out.println("5.寃곗젣�븯湲�");
			 System.out.println("0.�뮘濡쒓�湲�");
			 
			 menuNum = Integer.parseInt(sc.nextLine());
			 
			 while(menuNum<0 || menuNum>5) {
				 System.out.println("�옒紐살엯�젰�븯�뀲�뒿�땲�떎. �떎�떆 �엯�젰�븯�꽭�슂");
				 menuNum = Integer.parseInt(sc.nextLine());
			 }
			 
			 
			 switch(menuNum) {
			 case 0 :
				  selectTable();
			 
			 case 1 :
				
			        System.out.println("======== MENU ========");
			        for(int i =0; i< menuList.size();i++) {
			        	System.out.printf("%d. %s : %d �썝\n",i+1,menuList.get(i).name,menuList.get(i).price);
			        	
			        }
		       
		       while(true) { 
		    	   System.out.println("硫붾돱瑜� �꽑�깮�븯�꽭�슂. �뮘濡쒓�湲곕뒗 0踰�");	   
		        
		       String menuName=sc.nextLine();
		        if(menuName.equals("0")) {
		           break;
		        }
		          
		         
		          //tables.tablelist.get(tableNum).orderlist.add(new Orders(getMenu(menuName)));
		          tables.tablelist.get(tableNum).addOrder(new Orders(getMenu(menuName)));
		          System.out.println(menuName+"�씠(媛�) 二쇰Ц�릺�뿀�뒿�땲�떎.");
		           }
		        
		        
		        
		    	     break;
		            
			case 2 :
		    	   System.out.println("痍⑥냼�븷 二쇰Ц�쓣 �꽑�깮�븯�꽭�슂");
		    	   
		    	   
		    	    tables.tablelist.get(tableNum).listOrders();
		    	   
		         
		           String menuName2=sc.nextLine();
		           if(menuName2.equals("0")) {
		           	 return;
		           }
	           
		           tables.tablelist.get(tableNum).deleteOrder(tables.tablelist.get(tableNum).getOrder(getMenu(menuName2)));
		           System.out.println(menuName2+"�씠(媛�) 痍⑥냼�릺�뿀�뒿�땲�떎.");
		          
		    	   break;
		    	 
		     case 3 :
		    	 
		    	 tables.tablelist.get(tableNum).deleteOrderAll();
		    	 System.out.println("紐⑤뱺 二쇰Ц�씠 �궘�젣�릺�뿀�뒿�땲�떎.");
		    	 break;
		    	 
		     case 4 :
		    	 System.out.println("�닔�웾�쓣 蹂�寃쏀븷 硫붾돱瑜� �꽑�깮�븯�꽭�슂");
		    	 String menuName3 = sc.nextLine();
		    	 System.out.println("異붽��븯怨� �떢�� �닔�웾�쓣 �엯�젰�븯�꽭�슂");
		    	 int qty = Integer.parseInt(sc.nextLine());
		        
		    	 for(int i =0; i<menuList.size(); i++){
		    		 if(menuName3.equals(menuList.get(i).name)) {
		           	   tables.tablelist.get(tableNum).changeQty(menuList.get(i),qty);
		              
		                 System.out.println(menuList.get(i).name+"�쓽 �닔�웾�씠 蹂�寃쎈릺�뿀�뒿�땲�떎.");
		             }
		    	 }
		          break;
		    	 
		     case 5 :
		    	 
		    	 
		    	 
		     }
			 
		 }
			 }
	 void tableManage() {
			while (true) {
				int num = 0;
				System.out.println("�뀒�씠釉� 愿�由� �엯�땲�떎");
				System.out.println("1. �뀒�씠釉붿텛媛�");
				System.out.println("2. �뀒�씠釉붿궘�젣");
				System.out.println("0. 醫낅즺");
				System.out.println("踰덊샇瑜� �엯�젰�븯�꽭�슂");
				num = Integer.parseInt(sc.nextLine());

				switch (num) {
				case 0:
					posStart();
				case 1:
					System.out.println("�뀒�씠釉� 1媛쒕�� 異붽��빀�땲�떎");
					num = tables.tablelist.size() + 1;
					tables.addTable(num);
					break;
				case 2:
					System.out.println("�뀒�씠釉� 1媛쒕�� �궘�젣�빀�땲�떎");
					num = tables.tablelist.size() - 1;
					tables.deleteTable(num);
					break;

				default:
					break;
				}

			}
		}

	// �뙋留ㅺ�由�, 留ㅼ텧愿�由�, �쉶�썝愿�由�, 硫붾돱愿�由�, �뀒�씠釉붽�由�, �떆�뒪�뀥 醫낅즺

	// 二쇰Ц(�뀒�씠釉�)
	public void orderTable(Integer tableNo, Menu menu) { // �씪李щ떂
		// �뀒�씠釉붿뿉 order add
	}

	public void payTableCash(Integer tableNo) {// �씠�옒李�
		// �뀒�씠釉붿뿉�꽌 order瑜� �븯�굹�뵫 媛��졇���꽌 寃곗젣�븿
		for (int i = 0; i < tables.tablelist.get(tableNo).orderlist.size(); i++) {
			String menu = tables.tablelist.get(tableNo).orderlist.get(i).menuItem.name; // 硫붾돱�씠由�
			int price = tables.tablelist.get(tableNo).orderlist.get(i).menuItem.price; // 媛�寃�
			System.out.print(menu + ", " + price + "�썝 �엯�땲�떎~ �룉�쓣 �엯�젰�븯�꽭�슂 : ");
			int amount = sc.nextInt();
			if (amount < price) {
				System.out.println("湲덉븸�씠 遺�議깊빀�땲�떎");
				i--;
				break;
			} else {
				System.out.println("諛쏆��룉 : " + amount);
				System.out.println("�옍�룉 : " + (amount - price));
			}
		}
	}

	public void payTableCard(Integer tableNo) {// 沅뚯닚議�
		// �뀒�씠釉붿뿉�꽌 order瑜� �븯�굹�뵫 媛��졇���꽌 寃곗젣�븿
	}

	// 寃곗젣 (�뀒�씠釉�)
	public void payTableCardAll(Integer tableNo) { // �씪李щ떂
		// �뀒�씠釉붿쓽 order瑜� �븳媛�吏� 寃곗젣�삎�떇�쑝濡�
	}

	public void payTableCashAll(Integer tableNo, Integer amount) {// �씠�옒李�
		int price = tables.tablelist.get(tableNo).orderSum(); // 媛�寃�
		int change = amount - price; // �옍�룉
		System.out.println("諛쏆��룉 : amount");
		System.out.println("�옍   �룉 : change");
	}

	// 硫붾돱愿�由�
	// 硫붾돱 異붽�
	public void addMenu(String name, Integer price) {// �씠�옒李�
		menuList.add(new Menu(name, price));
	}

	// 硫붾돱 �닔�젙
	public void modifyMenu(String oldname, String name, Integer price) {// �떊吏��쁺
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).name.equals(oldname)) {
				menuList.remove(i);
				menuList.add(new Menu(name, price));
				break;
			}
		}
	}

	// 硫붾돱 �궘�젣
	public void deleteMenu(String name) {// 沅뚯삁吏�
		menuList.remove(name);
	}

	public Menu getMenu(String name) {
		Menu menu = null;
		for (Menu m : menuList) {
			if (m.name.trim().equalsIgnoreCase(name)) {
				menu = m;
			}
		}
		return menu;

	}

	// 怨좉컼愿�由�

	// 怨좉컼媛��엯
	public void addMembers(String phoneNumber) {// �떊吏��쁺
		customers.addCustomers(phoneNumber);
	}
	// 怨좉컼議고쉶
	// 怨좉컼�깉�눜
	// 怨좉컼�쁽�솴

	// overloading
//	public void deleCustomers(String name) {
//		
//	}

	// �쁽湲덇�由�
	public void cashAdjustment() { // �씠�옒李�
		// �쁽湲덉떆�옱�븸�쓣 蹂댁뿬以��떎
		System.out.println("�쁽湲덉떆�옱�븸 : " + amount);
	}

	// 留ㅼ텧
	// 硫붾돱蹂� 留ㅼ텧 (�씪蹂�)
	public void printSalesMenu(String date) { // 媛뺢린�썕
		// 硫붾돱-�닔�웾-湲덉븸
	}

	// 寃곗젣蹂� 留ㅼ텧 (�씪蹂�)
	public void printSalesPayment(String date) { // �떊吏��쁺
		// 硫붾돱-移대뱶(�쁽湲�)-�닔�웾-湲덉븸
	}

	// �뿊�� export (硫붾돱蹂�,寃곗젣蹂� 留ㅼ텧)
	public void exportToExcel(String salesType) {// �씪李щ떂

	}

	// �뜲�씠�꽣 ���옣
	public void save(Object object, String pathFile) { // 沅뚯삁吏�
	}

	// �뜲�씠�꽣 濡쒕뱶 (�떆�뒪�뀥 �떆�옉�떆 �뜲�씠�꽣 濡쒕뱶)
	public void load(Object object, String pathFile) {// 沅뚯삁吏�

	}
}

public class Pos_System {
	public static void main(String[] args) {
		Pos pos = new Pos();
		pos.tables = new Table();

//		// �뜲�씠�꽣 濡쒕뱶 (�떆�뒪�뀥 �떆�옉�떆 �뜲�씠�꽣 濡쒕뱶)
//		String pathFile = "C:\\Temp\\pos.obj";
//		pos=(Pos)TeamFiles.loadObject(pathFile);
//		
//		
//		pos.posStart();
//
//		// �뜲�씠�꽣 ���옣 (�떆�뒪�뀥 醫낅즺�떆 �뜲�씠�꽣 ���옣)
//		TeamFiles.saveObject(pos, "pathFile");

		// ========================
		// �씠�븯 �뀒�뒪�듃�슜�룄

//		Customers client = new Customers();
//		client.addCustomers("010-1111-1111");
//		client.addCustomers("010-2222-2222");
//		client.addCustomers("010-3333-3333");
//		client.deleCustomers("010-1111-2222");
//		client.findCustomers("010-2222-1111");

//		System.out.println(client.toString());

		pos.addMenu("吏쒖옣", 5000);
		pos.addMenu("吏щ퐬", 6000);
		pos.addMenu("�슦�룞", 5500);

//		Menu pickMenu = pos.getMenu("吏쒖옣");

//		System.out.println(pickMenu.toString());

//		// Order �깮�꽦
//		Orders order1 = new Orders(pos.getMenu("吏쒖옣"));
//		Orders order2 = new Orders(pos.getMenu("吏щ퐬"));
//		Orders order3 = new Orders(pos.getMenu("吏щ퐬"));
//
//		System.out.println(order1.toString());
//
//		// OrderList �깮�꽦
//		Bucket orderList = new Bucket();
//		orderList.addOrder(order1);
//		orderList.addOrder(order2);
//		orderList.addOrder(order3);
//
//		System.out.println("吏쒖옣 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏쒖옣")));
//		System.out.println("吏щ퐬 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏щ퐬")));
//
//		System.out.println("吏쒖옣 5媛� 異붽�");
//		orderList.changeQty(pos.getMenu("吏쒖옣"), 5);
//
//		System.out.println("吏쒖옣 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏쒖옣")));
//		System.out.println("吏щ퐬 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏щ퐬")));
//
//		System.out.println("吏쒖옣 6媛� 痍⑥냼");
//		orderList.changeQty(pos.getMenu("吏쒖옣"), -6);
//
//		System.out.println("吏쒖옣 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏쒖옣")));
//		System.out.println("吏щ퐬 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏щ퐬")));
//
//		System.out.println("�슦�룞 3媛� 異붽�");
//		orderList.changeQty(pos.getMenu("�슦�룞"), 3);
//
//		System.out.println("吏쒖옣 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏쒖옣")));
//		System.out.println("吏щ퐬 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("吏щ퐬")));
//		System.out.println("�슦�룞 二쇰Ц�닔 : " + orderList.menuQty(pos.getMenu("�슦�룞")));
//
//		System.out.println(orderList.toString());

//		// Table
//		Table tables = new Table();
//
//		// add table
//		tables.addTable(1);
//		tables.addTable(2);
//		tables.addTable(3);
//		tables.addTable(4);
//		System.out.println(tables.tablelist.toString());
//		// add OrderList to Table
//		tables.addOrderList(1, orderList);
//		System.out.println(tables.tablelist.toString());
//
//		// 寃곗젣
//		Customers sonnom = new Customers();
//		sonnom.addCustomers("010-2222-3333");
//		System.out.println("�넀�떂 : " + sonnom.customer.toString());
//
//		int yourbill = 20000;
//		// cash
//		Bucket afterLunch = tables.tablelist.get(1);
//		for (int i = 0; i < afterLunch.orderlist.size(); i++) {
//			yourbill -= afterLunch.orderlist.get(i).menuItem.price;
//			// point �쟻由�
//			int new_point = sonnom.customer.get("010-2222-3333")
//					+ (int) (afterLunch.orderlist.get(i).menuItem.price * 0.05);
//			sonnom.customer.put("010-2222-3333", new_point);
//
//		}
//		// 寃곗젣�셿猷�
//		afterLunch.isPayed = true;
//		System.out.println(yourbill);
//		System.out.println("�넀�떂�쓽 �룷�씤�듃 : " + sonnom.customer.toString());
        pos.posStart();
	}
}