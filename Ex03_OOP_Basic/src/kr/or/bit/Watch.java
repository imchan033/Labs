package kr.or.bit;
/*
* 시계는 같은 브랜드와 가격을 가지고 있다
* 브랜드는 뻐꾸기, 가격은 15000원이다
* 시침, 분침, 초침, 브랜드, 가격은 단독으로 설정하거나 바꿀수 없다
* 시계는 만들어질 때마다 누적생산대수가 1대씩 늘어난다.
* (시:분:초)를 한번에 출력하는 기능을 가지고 있다.
* 시간은 새로 설정할 수 있고 (시, 분)을 설정하는 기능, (시,분,초)를 설정하는 기능이 같은 이름으로 동작해야 한다
* 시는 (0~12)만, 분은 (0~59)만, 초는 (0~59)만 가능하며 다른 값을 입력하면 0으로 설정된다.
 */


public class Watch {
	private String brand;
	private int price;
	private int hour;
	private int minite;
	private int second;
	private static int count=0;
	

	
	public Watch(int hour, int minite, int second) {
		//brand = "뻐꾸기";
		//price = 15000;
		//count ++;
		this("뻐꾸기", 15000, hour, minite, second);
//		this.hour = sethour(hour);
//		this.minite = setminite(minite);
//		this.second = setsecond(second);
	}
	
	public Watch(String brand, int price, int hour, int minite, int second) {
		this.brand = brand;
		this.price = price;
		this.hour = hour;
		this.minite = minite;
		this.second = second;
		count ++;
	}

	public void setWatch(int hour, int minite) {
		this.hour = sethour(hour);
		this.minite = setminite(minite);
		
	}
	public void setWatch(int hour, int minite, int second) {
		this.hour = sethour(hour);
		this.minite = setminite(minite);
		this.second = setsecond(second);
	}

	public void printTime() {
		System.out.printf("%d : %d : %d, 누적개수 : %d",hour,minite,second,count);
	}
	public int sethour(int hour) {
		return (hour>12 || hour<1)? 0: hour;
	}
	public int setminite(int minite) {
		return (minite>59 || minite<1)? 0: minite;
	}
	public int setsecond(int second) {
		return (second>59 || second<1)? 0: second;
	}
}
