
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
* 날짜와 시간 보조 클래스. <br>
* 내부적으로 Calendar, Date 객체를 사용한다.
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
	 * 주어진 연도가 윤년이면 true, 아니면 false를 리턴한다.
	 * <pre>
	 * 내부적으로 GregorianCalendar의 isLeapYear(int) 메소드를 호출한다.
	 * 다만 static으로 사용하기 위해 이 메소드를 제공한다.
	 * </pre>
	 * @param pYear 윤녕인지를 판단할 연도.
	 * @return 윤년이면 true, 아니면 false.
	 */
	public static boolean isLeapYear(int pYear) {
		GregorianCalendar gCal = new GregorianCalendar();
		boolean b = gCal.isLeapYear(pYear);
		gCal = null;
		return b;
	}
	
	/**
	 * 간단한 설명 : yyyymmdd 형의 스트링을 Calendar로 바꾸어 리턴한다.
	 * @param yyyymmdd 날짜 스탬프.
	 * @return 생성된 Calendar instance.
	 * @throws Exception 에러 발생.
	 */
	public static Calendar stampToCalendar(String yyyymmdd) throws Exception {
		DateTime dtTemp = new DateTime(yyyymmdd);
		Calendar cal = dtTemp.getCalendar();
		return cal;
		
	}
	
	/**
	 * 간단한 설명 : 주어진 Calendar를 yyyymmdd 형으로 바꿔 리턴한다.
	 * @param pCalendar 대상 Calendar
	 * @return 구해진 yyyymmdd 형 스트링.
	 * @throws Exception 에러 발생.
	 */
	public static String calendarToStamp(Calendar pCalendar) throws Exception {
		DateTime dtTemp = new DateTime(pCalendar);
		return dtTemp.getDateStamp();
	}
	
	/**
	 * 주어진 DateTime이 월말일인지를 체크한다.
	 * <pre>
	 * 월말일이면 true, 아니면 false.
	 * </pre>
	 * @param pDate 체크할 DateTime 객체.
	 * @return 월말일이면 true, 아니면 false.
	 * @throws Exception 에러 발생.
	 */
	public static boolean isLastDayOfMonth(DateTime pDate) throws Exception {
		DateTime dtEnd = pDate.getLastDayOfMonth();
		String strEnd = dtEnd.getDateStamp();
		boolean b = (pDate.getDateStamp().equals(strEnd)) ? true : false;
		return b;
	}
	
	/**
	 * 주어진 Calendar가 월말일인지를 체크한다.
	 * <pre>
	 * 월말일이면 true, 아니면 false.
	 * </pre>
	 * @param pCalendar 체크할 Calendar 객체.
	 * @return 월말일이면 true, 아니면 false.
	 * @throws Exception 에러 발생.
	 */
	public static boolean isLastDayOfMonth(Calendar pCalendar) throws Exception {
		DateTime dt = new DateTime(pCalendar);
		return isLastDayOfMonth(dt);
	}
	
	/**
	 * 주어진 Date가 월말일인지를 체크한다.
	 * <pre>
	 * 월말일이면 true, 아니면 false.
	 * </pre>
	 * @param pDate 체크할 Date 객체.
	 * @return 월말일이면 true, 아니면 false.
	 * @throws Exception 에러 발생.
	 */
	public static boolean isLastDayOfMonth(Date pDate) throws Exception {
		DateTime dt = new DateTime(pDate);
		return isLastDayOfMonth(dt);
	}
	
	/**
	 * 하루 동안의 시각을 milliseconds 단위로 나타낸 것이다. 86400000L 이다.
	 */
	public static final long DAY_MILLISECONDS = 86400000L;

	/**
	* 생성자. 현재 날짜 시간을 setting 한다.
	*
	*/
	public DateTime() {
		this.dt = new Date();
		setCalendar(dt);
	}

	/**
	* 생성자. 주어진 날짜 시간을 setting 한다.
	*
	* @param dt 세팅할 날짜, 시간
	*/
	public DateTime(Date dt) {
		this.dt = dt;
		setCalendar(dt);
	}

	/**
	* 생성자. 현재 날짜 시간을 setting 한다.
	*
	* @param cal 세팅할 Calendar 객체
	*/
	public DateTime(Calendar cal) {
		this.cal = cal;
		setDate(cal);
	}

	/**
	 * 주어진 날짜를 주어진 패턴으로 간주하여 날짜 시간을 setting 한다.
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
	 * Constructor. yyyyMMdd형을 지원. <br>
	 * 정확한 데이터 형이 아닌 경우 UtilException 발생.
	 * @param strDate yyyyMMdd 형의 스트링
	 * @throws UtilException 정확한 데이터 형이 아닌 경우에 발생.
	 */
	public DateTime(String strDate) throws Exception {
		this(strDate, "yyyyMMdd");
	}
	
	/**
	 * 주어진 timeMillis 값으로 DateTime 객체를 생성한다.
	 * @param timeMillis 설정할 시간의 long 값. (epoch)
	 * @throws UtilException 에러 발생.
	 */
	public DateTime(long timeMillis) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeMillis);
		this.cal = cal;
		setDate(cal);
	}
	
	/**
	 * 주어진 날짜형 데이터(pFrom, pFromFormat 형태로 포맷되어 있다)를 pToFormat 형태로 바꿔 리턴한다.
	 * <pre>
	 * 예를 들어 DateTime.convert("20040305", "yyyyMMdd", "yyyy/MM/dd") 는 "2004/03/05"를 반환한다.
	 * </pre>
	 * @param pFrom 변환할 날짜
	 * @param pFromFormat pFrom의 포맷.
	 * @param pToFormat 변환시에 적용될 포맷.
	 * @return pToFormat 이 적용된 스트링.
	 * @throws UtilException 에러 발생.
	 */
	public static String convert(String pFrom, String pFromFormat, String pToFormat) throws Exception {
		DateTime dt = new DateTime(pFrom, pFromFormat);
		return dt.getFormatString(pToFormat);
	}
	
	/**
	 * 주어진 날짜형 데이터(pFrom, yyyyMMdd 형태로 포맷되어 있음)를 pToFormat 형태로 바꿔 리턴한다.
	 * @param pFrom 변환할 날짜
	 * @param pToFormat 변환시에 적용될 포맷
	 * @return pToFormat이 적용된 스트링
	 * @throws UtilException 에러발생.
	 */
	public static String convert(String pFrom, String pToFormat) throws Exception {
		return DateTime.convert(pFrom, "yyyyMMdd", pToFormat);
	}

	/**
	설정된 날짜에서 iAmount 만큼 일수를 늘인 DateTime 값을 리턴함.
	@param iAmount 늘일 일수
	@return resolved DateTime
	*/
	public DateTime addDay(int iAmount) {
		return this.pAdd(Calendar.DATE, iAmount);
	}
	
	/**
	 * 설정된 날짜에서 iAmount 만큼 달수를 늘인 DateTime 값을 리턴함.
	 * @param iAmount 늘일 달수
	 * @return resolved DateTime
	 */
	public DateTime addMonth(int iAmount) {
		return this.pAdd(Calendar.MONTH, iAmount);
	}
	
	/**
	 * 현재 설정된 월의 마지막 날짜를 구함.
	 * <pre>
	 * 예를 들어 2005년 8월 12일의 DateTime 객체에서 이 메소드를 호출하면 2005년 8월 31일 객체가 온다.
	 * </pre>
	 * 
	 * <xmp>
	 * [Code Sample]
	 * DateTime dt = new DateTime("20050812");
	 * DateTime dtLast = dt.getLastDayOfMonth();
	 * System.out.println(dtLast.getDateStamp()); // 20050831
	 * </xmp>
	 * 
	 * @return 현재 설정 날짜가 포함된 월의 마지막 날짜.
	 * @throws Exception 에러 발생
	 */
	public DateTime getLastDayOfMonth() throws Exception {
		DateTime dtTemp = this.addMonth(1);
		dtTemp = dtTemp.getFirstDayOfMonth();
		dtTemp = dtTemp.addDay(-1);
		return dtTemp;
	}
	
	/**
	 * 현재 설정된 월의 처음 날짜를 구함.
	 * <pre>
	 * 예를 들어 2005년 8월 12일의 DateTime 객체에서 이 메소드를 호출하면 2005년 8월 1일 객체가 온다.
	 * </pre>
	 * 
	 * <xmp>
	 * [Code Sample]
	 * DateTime dt = new DateTime("20050812");
	 * DateTime dtFirst = dt.getFirstDayOfMonth();
	 * System.out.println(dtFirst.getDateStamp); // 20050801
	 * </xmp>
	 * 
	 * @return 현재 설정 날짜가 포함된 월의 처음 날짜.
	 * @throws Exception 에러발생.
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
	* 설정된 Date를 리턴하는 메소드.
	*
	* @return 설정된 Date 값
	*/
	public Date getDate() {
		return this.dt;
	}

	/**
	* 설정된 Calendar를 리턴하는 메소드.
	*
	* @return 설정된 Calendar 값
	*/
	public Calendar getCalendar() {
		return this.cal;
	}

	/**
	* 설정된 날짜 시간을 주어진 format 형태로 리턴하는 메소드. <p>
	*
	* @param pattern 포매팅할 문자열.
	* @return 포매팅 된 문자열.
	*/
	public String getFormatString(String pattern) {
		SimpleDateFormat formatter =
			new SimpleDateFormat(pattern, Locale.KOREA);
		return formatter.format(dt);
	}

	/**
	* 설정된 날짜를 "yyyy-MM-dd" 형태로 리턴하는 메소드.
	*
	* @return "yyyy-MM-dd" 형으로 포매팅 된 문자열
	*/
	public String getDateString() {
		return this.getFormatString("yyyy-MM-dd");
	}

	/**
	* 설정된 시간을 "HH:mm:ss" 형태로 리턴하는 메소드.
	*
	* @return "HH:mm:ss" 형으로 포매팅 된 문자열.
	*/
	public String getTimeString() {
		return this.getFormatString("HH:mm:ss");
	}

	/**
	* 설정된 날짜의 DateStamp(yyyyMMdd)를 리턴하는 메소드.
	*
	* @return 설정된 날짜의 DateStamp
	*/
	public String getDateStamp() {
		return this.getFormatString("yyyyMMdd");
	}

	/**
	* 설정된 날짜의 TimeStamp(HHmmss)를 리턴하는 메소드.
	*
	* @return 설정된 날짜의 TimeStamp
	*/
	public String getTimeStamp() {
		return this.getFormatString("HHmmss");
	}

	/**
	* 설정된 날짜의 DateTimeStamp(yyyyMMddHHmmss)를 리턴하는 메소드.
	*
	* @return 설정된 날짜의 DateTimeStamp
	*/
	public String getDateTimeStamp() {
		return this.getFormatString("yyyyMMddHHmmss");
	}

	/**
	* 설정된 날짜를 리턴하는 메소드.
	* 
	* @return 설정된 날짜.
	*/
	public int getDay() {
		return getNumberByPattern("dd");
	}

	/**
	* 설정된 달(Month)를 리턴하는 메소드.
	* 
	* @return 설정된 달(Month).
	*/
	public int getMonth() {
		return getNumberByPattern("MM");
	}

	/**
	* 설정된 연도(year)를 리턴하는 메소드.
	* 
	* @return 설정된 연도(year).
	*/
	public int getYear() {
		return getNumberByPattern("yyyy");
	}
	
	/**
	 * 간략한 설명 : 주어진 time과 현재 설정된 시간과의 차이를 Millisecond 단위로 나타낸다.
	 * @param time 비교할 시간(FROM).
	 * @return 차이.
	 */
	public long getGapInMillis(DateTime time) {
		long dCurrent = this.cal.getTimeInMillis();
		long dTarget = time.getCalendar().getTimeInMillis();
		return dCurrent - dTarget;
	}
	
	/**
	 * 간략한 설명 : 주어진 time과 현재 설정된 시간과의 차이를 Day 단위로 나타낸다.
	 * @param time 비교할 시간(FROM).
	 * @return 차이.
	 */
	public int getGapInDay(DateTime time) {
		long dGap = this.getGapInMillis(time);
		return (int)(dGap / DateTime.DAY_MILLISECONDS);
	}

	/**
	 * time 부터 현재 설정일까지의 Gap을 360일 베이스로 구한다.
	 * @param time FROM 날짜.
	 * @return 사이의 날짜를 360일 베이스로 구한 값.
	 */
	public int getGapInDay_360Base(DateTime time) {
		long lGap = this.getGapInDay(time);
		double dTemp = (lGap * 360.0) / 365.0;
		return (int)dTemp;
	}

	/**
	* 설정된 날짜, 시간을 number 형태로 리턴하는 메소드.
	*
	* @param pattern format
	* @return 변환된 int 값
	*/
	public int getNumberByPattern(String pattern) {
		SimpleDateFormat formatter =
			new SimpleDateFormat(pattern, Locale.KOREA);
		String dateString = formatter.format(dt);
		return Integer.parseInt(dateString);
	}

	/**
	 * 간략한 설명 : Calendar 의 get과 동일한 메소드.
	 * <pre>
	 * 들어가는 field에 대한 설명은 Calendar 클래스를 참조하라.
	 * </pre>
	 * @param field 가져올 필드.
	 * @return 해당 필드의 값.
	 */
	public int get(int field) {
		return cal.get(field);
	}
	
	/**
	 * 간략한 설명 : 요일을 String으로 리턴한다.
	 * <pre>
	 * 숫자로 나오길 원한다면 get(Calendar.DAY_OF_WEEK)를 사용하라.
	 * 월 : Mon
	 * 화 : Tue
	 * 수 : Wed
	 * 목 : Thu
	 * 금 : Fri
	 * 토 : Sat
	 * 일 : Sun
	 * </pre>
	 * @return 요일.
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
	 * 간략한 설명 : 현재 날짜가 포함된 주의 첫번째 월요일을 리턴한다.
	 * <pre>
	 * 내부적으로 this.getFirstDayOfThisWeek(null)을 호출한다.
	 * </pre>
	 * @return 현재 날짜가 포함된 주의 첫번째 월요일.
	 */
	public DateTime getFirstDayOfThisWeek() {
		return this.getFirstDayOfThisWeek(null);
	}
	
	/**
	 * 간략한 설명 : 현재 날짜가 포함된 주의 첫번째 월요일 혹은 일요일을 리턴한다.
	 * <pre>
	 * pType이 "Sun" 이 아닌 모든 경우에 첫번째 월요일을 리턴한다. 
	 * </pre>
	 * @param pType Sun 이면 일요일, 아닌 경우에는 모두 월요일. (null 일때도 월요일).
	 * @return 현재 날짜가 포함된 주의 첫번째 월요일 혹은 일요일.
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
	 * 간략한 설명 : 현재 날짜가 포함된 월의 1일을 리턴한다.
	 * @return 해당 월의 1일.
	 * @throws UtilException 에러 발생.
	 */
	public DateTime getFirstDayOfThisMonth() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 6);
		strSub += "01";
		DateTime dt = new DateTime(strSub);
		return dt;
	}
	
	/**
	 * 간략한 설명 : 현재 날짜가 포함된 연도의 1월 1일을 리턴한다.
	 * @return 해당 연도의 1월 1일.
	 * @throws UtilException 에러 발생.
	 */
	public DateTime getFirstDayOfThisYear() throws Exception {
		String str = this.getDateStamp();
		String strSub = str.substring(0, 4);
		strSub += "0101";
		DateTime dt = new DateTime(strSub);
		return dt;
	}
	
	/**
	 * 간략한 설명 : 해당 날짜가 포함된 반기의 첫번째 날짜를 리턴한다.
	 * @return 1월 1일 혹은 7월 1일.
	 * @throws UtilException 에러 발생.
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
	 * 간략한 설명 : 해당 날짜가 포함된 분기의 첫번째 날짜를 리턴한다.
	 * @return 01/01, 04/01, 07/01, 10/01 중의 하나.
	 * @throws UtilException 에러 발생.
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
	 * 현재 설정된 날짜의 YYYY-MM-DD hh:mm:ss 형태를 리턴한다.
	 */
	public String toString() {
		String s = this.getDateString() + " " + this.getTimeString();
		return s;
	}
}


