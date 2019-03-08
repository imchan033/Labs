
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
* ��¥�� �ð� ���� Ŭ����. <br>
* ���������� Calendar, Date ��ü�� ����Ѵ�.
* <pre>
* 
* </pre> 
* 
* @version 1.12
* @author Yong min kim (goat@naver.com) 
*/
public class DateTime implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -34076649185963586L;
	protected Date dt = null;
	protected Calendar cal = null;
	
	/**
	 * �־��� ������ �����̸� true, �ƴϸ� false�� �����Ѵ�.
	 * <pre>
	 * ���������� GregorianCalendar�� isLeapYear(int) �޼ҵ带 ȣ���Ѵ�.
	 * �ٸ� static���� ����ϱ� ���� �� �޼ҵ带 �����Ѵ�.
	 * </pre>
	 * @param pYear ���������� �Ǵ��� ����.
	 * @return �����̸� true, �ƴϸ� false.
	 */
	public static boolean isLeapYear(int pYear) {
		GregorianCalendar gCal = new GregorianCalendar();
		boolean b = gCal.isLeapYear(pYear);
		gCal = null;
		return b;
	}
	
	/**
	 * ������ ���� : yyyymmdd ���� ��Ʈ���� Calendar�� �ٲپ� �����Ѵ�.
	 * @param yyyymmdd ��¥ ������.
	 * @return ������ Calendar instance.
	 * @throws Exception ���� �߻�.
	 */
	public static Calendar stampToCalendar(String yyyymmdd) throws Exception {
		DateTime dtTemp = new DateTime(yyyymmdd);
		Calendar cal = dtTemp.getCalendar();
		return cal;
		
	}
	
	/**
	 * ������ ���� : �־��� Calendar�� yyyymmdd ������ �ٲ� �����Ѵ�.
	 * @param pCalendar ��� Calendar
	 * @return ������ yyyymmdd �� ��Ʈ��.
	 * @throws Exception ���� �߻�.
	 */
	public static String calendarToStamp(Calendar pCalendar) throws Exception {
		DateTime dtTemp = new DateTime(pCalendar);
		return dtTemp.getDateStamp();
	}
	
	/**
	 * �־��� DateTime�� ������������ üũ�Ѵ�.
	 * <pre>
	 * �������̸� true, �ƴϸ� false.
	 * </pre>
	 * @param pDate üũ�� DateTime ��ü.
	 * @return �������̸� true, �ƴϸ� false.
	 * @throws Exception ���� �߻�.
	 */
	public static boolean isLastDayOfMonth(DateTime pDate) throws Exception {
		DateTime dtEnd = pDate.getLastDayOfMonth();
		String strEnd = dtEnd.getDateStamp();
		boolean b = (pDate.getDateStamp().equals(strEnd)) ? true : false;
		return b;
	}
	
	/**
	 * �־��� Calendar�� ������������ üũ�Ѵ�.
	 * <pre>
	 * �������̸� true, �ƴϸ� false.
	 * </pre>
	 * @param pCalendar üũ�� Calendar ��ü.
	 * @return �������̸� true, �ƴϸ� false.
	 * @throws Exception ���� �߻�.
	 */
	public static boolean isLastDayOfMonth(Calendar pCalendar) throws Exception {
		DateTime dt = new DateTime(pCalendar);
		return isLastDayOfMonth(dt);
	}
	
	/**
	 * �־��� Date�� ������������ üũ�Ѵ�.
	 * <pre>
	 * �������̸� true, �ƴϸ� false.
	 * </pre>
	 * @param pDate üũ�� Date ��ü.
	 * @return �������̸� true, �ƴϸ� false.
	 * @throws Exception ���� �߻�.
	 */
	public static boolean isLastDayOfMonth(Date pDate) throws Exception {
		DateTime dt = new DateTime(pDate);
		return isLastDayOfMonth(dt);
	}
	
	/**
	 * �Ϸ� ������ �ð��� milliseconds ������ ��Ÿ�� ���̴�. 86400000L �̴�.
	 */
	public static final long DAY_MILLISECONDS = 86400000L;

	/**
	* ������. ���� ��¥ �ð��� setting �Ѵ�.
	*
	*/
	public DateTime() {
		this.dt = new Date();
		setCalendar(dt);
	}

	/**
	* ������. �־��� ��¥ �ð��� setting �Ѵ�.
	*
	* @param dt ������ ��¥, �ð�
	*/
	public DateTime(Date dt) {
		this.dt = dt;
		setCalendar(dt);
	}

	/**
	* ������. ���� ��¥ �ð��� setting �Ѵ�.
	*
	* @param cal ������ Calendar ��ü
	*/
	public DateTime(Calendar cal) {
		this.cal = cal;
		setDate(cal);
	}

	/**
	 * �־��� ��¥�� �־��� �������� �����Ͽ� ��¥ �ð��� setting �Ѵ�.
	 * 
	 * @param pattern
	 */
	public DateTime(String date, String pattern) throws Exception {
		SimpleDateFormat formatter =
			new SimpleDateFormat(pattern, Locale.KOREA);
		try {
			this.dt = formatter.parse(date);
		} catch (ParseException pe) {
			System.out.println("Parse Error : " + pe.getMessage());
		}
		setCalendar(dt);
	}
	
		/**
	 * Constructor. yyyyMMdd���� ����. <br>
	 * ��Ȯ�� ������ ���� �ƴ� ��� UtilException �߻�.
	 * @param strDate yyyyMMdd ���� ��Ʈ��
	 * @throws UtilException ��Ȯ�� ������ ���� �ƴ� ��쿡 �߻�.
	 */
	public DateTime(String strDate) throws Exception {
		this(strDate, "yyyyMMdd");
	}
	
	/**
	 * �־��� timeMillis ������ DateTime ��ü�� �����Ѵ�.
	 * @param timeMillis ������ �ð��� long ��. (epoch)
	 * @throws UtilException ���� �߻�.
	 */
	public DateTime(long timeMillis) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeMillis);
		this.cal = cal;
		setDate(cal);
	}
	
	/**
	 * �־��� ��¥�� ������(pFrom, pFromFormat ���·� ���˵Ǿ� �ִ�)�� pToFormat ���·� �ٲ� �����Ѵ�.
	 * <pre>
	 * ���� ��� DateTime.convert("20040305", "yyyyMMdd", "yyyy/MM/dd") �� "2004/03/05"�� ��ȯ�Ѵ�.
	 * </pre>
	 * @param pFrom ��ȯ�� ��¥
	 * @param pFromFormat pFrom�� ����.
	 * @param pToFormat ��ȯ�ÿ� ����� ����.
	 * @return pToFormat �� ����� ��Ʈ��.
	 * @throws UtilException ���� �߻�.
	 */
	public static String convert(String pFrom, String pFromFormat, String pToFormat) throws Exception {
		DateTime dt = new DateTime(pFrom, pFromFormat);
		return dt.getFormatString(pToFormat);
	}
	
	/**
	 * �־��� ��¥�� ������(pFrom, yyyyMMdd ���·� ���˵Ǿ� ����)�� pToFormat ���·� �ٲ� �����Ѵ�.
	 * @param pFrom ��ȯ�� ��¥
	 * @param pToFormat ��ȯ�ÿ� ����� ����
	 * @return pToFormat�� ����� ��Ʈ��
	 * @throws UtilException �����߻�.
	 */
	public static String convert(String pFrom, String pToFormat) throws Exception {
		return DateTime.convert(pFrom, "yyyyMMdd", pToFormat);
	}

	/**
	������ ��¥���� iAmount ��ŭ �ϼ��� ���� DateTime ���� ������.
	@param iAmount ���� �ϼ�
	@return resolved DateTime
	*/
	public DateTime addDay(int iAmount) {
		return this.pAdd(Calendar.DATE, iAmount);
	}
	
	/**
	 * ������ ��¥���� iAmount ��ŭ �޼��� ���� DateTime ���� ������.
	 * @param iAmount ���� �޼�
	 * @return resolved DateTime
	 */
	public DateTime addMonth(int iAmount) {
		return this.pAdd(Calendar.MONTH, iAmount);
	}
	
	/**
	 * ���� ������ ���� ������ ��¥�� ����.
	 * <pre>
	 * ���� ��� 2005�� 8�� 12���� DateTime ��ü���� �� �޼ҵ带 ȣ���ϸ� 2005�� 8�� 31�� ��ü�� �´�.
	 * </pre>
	 * 
	 * <xmp>
	 * [Code Sample]
	 * DateTime dt = new DateTime("20050812");
	 * DateTime dtLast = dt.getLastDayOfMonth();
	 * System.out.println(dtLast.getDateStamp()); // 20050831
	 * </xmp>
	 * 
	 * @return ���� ���� ��¥�� ���Ե� ���� ������ ��¥.
	 * @throws Exception ���� �߻�
	 */
	public DateTime getLastDayOfMonth() throws Exception {
		DateTime dtTemp = this.addMonth(1);
		dtTemp = dtTemp.getFirstDayOfMonth();
		dtTemp = dtTemp.addDay(-1);
		return dtTemp;
	}
	
	/**
	 * ���� ������ ���� ó�� ��¥�� ����.
	 * <pre>
	 * ���� ��� 2005�� 8�� 12���� DateTime ��ü���� �� �޼ҵ带 ȣ���ϸ� 2005�� 8�� 1�� ��ü�� �´�.
	 * </pre>
	 * 
	 * <xmp>
	 * [Code Sample]
	 * DateTime dt = new DateTime("20050812");
	 * DateTime dtFirst = dt.getFirstDayOfMonth();
	 * System.out.println(dtFirst.getDateStamp); // 20050801
	 * </xmp>
	 * 
	 * @return ���� ���� ��¥�� ���Ե� ���� ó�� ��¥.
	 * @throws Exception �����߻�.
	 */
	public DateTime getFirstDayOfMonth() throws Exception {
		String strTemp = this.getDateStamp();
		String strDate = strTemp.substring(0, 6) + "01";
		return new DateTime(strDate);
	}
	
	private DateTime pAdd(int pType, int pAmount) {
		Calendar calTemp = Calendar.getInstance();
		calTemp.setTime(dt);
		calTemp.add(pType, pAmount);
		return new DateTime(calTemp);
	}

	private void setCalendar(Date dt) {
		this.cal = Calendar.getInstance();
		cal.setTime(dt);
	}

	private void setDate(Calendar cal) {
		this.dt = cal.getTime();
	}

	/**
	* ������ Date�� �����ϴ� �޼ҵ�.
	*
	* @return ������ Date ��
	*/
	public Date getDate() {
		return this.dt;
	}

	/**
	* ������ Calendar�� �����ϴ� �޼ҵ�.
	*
	* @return ������ Calendar ��
	*/
	public Calendar getCalendar() {
		return this.cal;
	}

	/**
	* ������ ��¥ �ð��� �־��� format ���·� �����ϴ� �޼ҵ�. <p>
	*
	* @param pattern �������� ���ڿ�.
	* @return ������ �� ���ڿ�.
	*/
	public String getFormatString(String pattern) {
		SimpleDateFormat formatter =
			new SimpleDateFormat(pattern, Locale.KOREA);
		return formatter.format(dt);
	}

	/**
	* ������ ��¥�� "yyyy-MM-dd" ���·� �����ϴ� �޼ҵ�.
	*
	* @return "yyyy-MM-dd" ������ ������ �� ���ڿ�
	*/
	public String getDateString() {
		return this.getFormatString("yyyy-MM-dd");
	}

	/**
	* ������ �ð��� "HH:mm:ss" ���·� �����ϴ� �޼ҵ�.
	*
	* @return "HH:mm:ss" ������ ������ �� ���ڿ�.
	*/
	public String getTimeString() {
		return this.getFormatString("HH:mm:ss");
	}

	/**
	* ������ ��¥�� DateStamp(yyyyMMdd)�� �����ϴ� �޼ҵ�.
	*
	* @return ������ ��¥�� DateStamp
	*/
	public String getDateStamp() {
		return this.getFormatString("yyyyMMdd");
	}

	/**
	* ������ ��¥�� TimeStamp(HHmmss)�� �����ϴ� �޼ҵ�.
	*
	* @return ������ ��¥�� TimeStamp
	*/
	public String getTimeStamp() {
		return this.getFormatString("HHmmss");
	}

	/**
	* ������ ��¥�� DateTimeStamp(yyyyMMddHHmmss)�� �����ϴ� �޼ҵ�.
	*
	* @return ������ ��¥�� DateTimeStamp
	*/
	public String getDateTimeStamp() {
		return this.getFormatString("yyyyMMddHHmmss");
	}

	/**
	* ������ ��¥�� �����ϴ� �޼ҵ�.
	* 
	* @return ������ ��¥.
	*/
	public int getDay() {
		return getNumberByPattern("dd");
	}

	/**
	* ������ ��(Month)�� �����ϴ� �޼ҵ�.
	* 
	* @return ������ ��(Month).
	*/
	public int getMonth() {
		return getNumberByPattern("MM");
	}

	/**
	* ������ ����(year)�� �����ϴ� �޼ҵ�.
	* 
	* @return ������ ����(year).
	*/
	public int getYear() {
		return getNumberByPattern("yyyy");
	}
	
	/**
	 * ������ ���� : �־��� time�� ���� ������ �ð����� ���̸� Millisecond ������ ��Ÿ����.
	 * @param time ���� �ð�(FROM).
	 * @return ����.
	 */
	public long getGapInMillis(DateTime time) {
		long dCurrent = this.cal.getTimeInMillis();
		long dTarget = time.getCalendar().getTimeInMillis();
		return dCurrent - dTarget;
	}
	
	/**
	 * ������ ���� : �־��� time�� ���� ������ �ð����� ���̸� Day ������ ��Ÿ����.
	 * @param time ���� �ð�(FROM).
	 * @return ����.
	 */
	public int getGapInDay(DateTime time) {
		long dGap = this.getGapInMillis(time);
		return (int)(dGap / DateTime.DAY_MILLISECONDS);
	}

	/**
	 * time ���� ���� �����ϱ����� Gap�� 360�� ���̽��� ���Ѵ�.
	 * @param time FROM ��¥.
	 * @return ������ ��¥�� 360�� ���̽��� ���� ��.
	 */
	public int getGapInDay_360Base(DateTime time) {
		long lGap = this.getGapInDay(time);
		double dTemp = (lGap * 360.0) / 365.0;
		return (int)dTemp;
	}

	/**
	* ������ ��¥, �ð��� number ���·� �����ϴ� �޼ҵ�.
	*
	* @param pattern format
	* @return ��ȯ�� int ��
	*/
	public int getNumberByPattern(String pattern) {
		SimpleDateFormat formatter =
			new SimpleDateFormat(pattern, Locale.KOREA);
		String dateString = formatter.format(dt);
		return Integer.parseInt(dateString);
	}

	/**
	 * ������ ���� : Calendar �� get�� ������ �޼ҵ�.
	 * <pre>
	 * ���� field�� ���� ������ Calendar Ŭ������ �����϶�.
	 * </pre>
	 * @param field ������ �ʵ�.
	 * @return �ش� �ʵ��� ��.
	 */
	public int get(int field) {
		return cal.get(field);
	}
	
	/**
	 * ������ ���� : ������ String���� �����Ѵ�.
	 * <pre>
	 * ���ڷ� ������ ���Ѵٸ� get(Calendar.DAY_OF_WEEK)�� ����϶�.
	 * �� : Mon
	 * ȭ : Tue
	 * �� : Wed
	 * �� : Thu
	 * �� : Fri
	 * �� : Sat
	 * �� : Sun
	 * </pre>
	 * @return ����.
	 */
	public String getDayOfWeekString() {
		int iValue = cal.get(Calendar.DAY_OF_WEEK);
		switch(iValue) {
			case 2: return "Mon";
			case 3: return "Tue";
			case 4: return "Wed";
			case 5: return "Thu";
			case 6: return "Fri";
			case 7: return "Sat";
			default: return "Sun";
		}
	}
	
	/**
	 * ������ ���� : ���� ��¥�� ���Ե� ���� ù��° �������� �����Ѵ�.
	 * <pre>
	 * ���������� this.getFirstDayOfThisWeek(null)�� ȣ���Ѵ�.
	 * </pre>
	 * @return ���� ��¥�� ���Ե� ���� ù��° ������.
	 */
	public DateTime getFirstDayOfThisWeek() {
		return this.getFirstDayOfThisWeek(null);
	}
	
	/**
	 * ������ ���� : ���� ��¥�� ���Ե� ���� ù��° ������ Ȥ�� �Ͽ����� �����Ѵ�.
	 * <pre>
	 * pType�� "Sun" �� �ƴ� ��� ��쿡 ù��° �������� �����Ѵ�. 
	 * </pre>
	 * @param pType Sun �̸� �Ͽ���, �ƴ� ��쿡�� ��� ������. (null �϶��� ������).
	 * @return ���� ��¥�� ���Ե� ���� ù��° ������ Ȥ�� �Ͽ���.
	 */
	public DateTime getFirstDayOfThisWeek(String pType) {
		int iValue = cal.get(Calendar.DAY_OF_WEEK);
		int iGap = 0;
		if(pType != null && pType.equals("Sun")) {
			iGap = iValue - 1;
		} else {
			iGap = iValue - 2;
		}
		DateTime dt = this.addDay(-iGap);
		return dt;
	}
	
	/**
	 * ������ ���� : ���� ��¥�� ���Ե� ���� 1���� �����Ѵ�.
	 * @return �ش� ���� 1��.
	 * @throws UtilException ���� �߻�.
	 */
	public DateTime getFirstDayOfThisMonth() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 6);
		strSub += "01";
		DateTime dt = new DateTime(strSub);
		return dt;
	}
	
	/**
	 * ������ ���� : ���� ��¥�� ���Ե� ������ 1�� 1���� �����Ѵ�.
	 * @return �ش� ������ 1�� 1��.
	 * @throws UtilException ���� �߻�.
	 */
	public DateTime getFirstDayOfThisYear() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 4);
		strSub += "0101";
		DateTime dt = new DateTime(strSub);
		return dt;
	}
	
	/**
	 * ������ ���� : �ش� ��¥�� ���Ե� �ݱ��� ù��° ��¥�� �����Ѵ�.
	 * @return 1�� 1�� Ȥ�� 7�� 1��.
	 * @throws UtilException ���� �߻�.
	 */
	public DateTime getFirstDayOfHalf() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 4);
		int iMonth = this.getMonth();
		if(iMonth >= 7) {
			strSub += "0701";
		} else {
			strSub += "0101";
		}
		return new DateTime(strSub);
	}
	
	/**
	 * ������ ���� : �ش� ��¥�� ���Ե� �б��� ù��° ��¥�� �����Ѵ�.
	 * @return 01/01, 04/01, 07/01, 10/01 ���� �ϳ�.
	 * @throws UtilException ���� �߻�.
	 */
	public DateTime getFirstDayOfQuarter() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 4);
		int iMonth = this.getMonth();
		switch(iMonth) {
			case 1:
			case 2:
			case 3:
				strSub += "0101";
				return new DateTime(strSub);
			case 4:
			case 5:
			case 6:
				strSub += "0401";
				return new DateTime(strSub);
			case 7:
			case 8:
			case 9:
				strSub += "0701";
				return new DateTime(strSub);
			default:
				strSub += "1001";
				return new DateTime(strSub);
		}
	}
	
	/**
	 * ���� ������ ��¥�� YYYY-MM-DD hh:mm:ss ���¸� �����Ѵ�.
	 */
	public String toString() {
		String s = this.getDateString() + " " + this.getTimeString();
		return s;
	}
}


