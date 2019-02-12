package kr.or.bit;
/*
요구사항정의
Tv는 채널정보를 가지고 있다(예를 들면 1~250채널)
Tv는 브랜드 이름을 가지고 있다(예를 들면 삼성, 엘지)
Tv는 채널 전환 기능을 가지고 있다(채널을 변경할수 있다 한단계씩만)
	기능 2개 (++,--)
Tv는 전원 정보를 가지고 있다
	전원은 On 할수 도 있고 Off 할수도 있다
 */
public class Tv {
	public int ch; //기본채널 0; public int ch=1; 가능
	public String brandname;
	public boolean power; //true(on) , false(off)
	
	public void ch_up() {
		//member field 상태 값
		ch++;
	}
	public void ch_down() {
		ch--;
	}
	public void power_on() {
		power = true; // Tv 전원 On
	}
	public void power_off() {
		power = false; // Tv 전원 Off
	}
	
	
	
	

}
