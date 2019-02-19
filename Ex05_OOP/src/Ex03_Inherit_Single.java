class Tv{
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

class Vcr{ //비디오 플레이어
	boolean power;
	
	void power(){
		this.power = !this.power;
	}
	void play() {
		System.out.println("재생하기");
	}
	void stop() {
		System.out.println("정지");
	}
	void rew() {}
	void ff() {}
	
}
//설계도 : tv, vcr를 가지고 있다
//vcr기능과 tv기능을 다 갖춘 설계도를 작성해 주세요
//TvVcr 설계도 제품을 만들고 싶어요

//설계도 재사용...
//class TvVcr extends Tv,Vcr{} (x : 다중상속)

//Tv extends Vcr
//TvVcr extends Tv (계층적 상속)

//TvVcr 클래스 Tv포함, Vcr포함 (둘다 포함 할 수도 있음)

//전제조건 : 상속은 한번만 하세요
//상속, 포함
//고민 : TvVcr을 만들때 어떤 놈을 상속하고 어떤 놈을 포함하는지...

//주기능(Tv), 보조기능(Vcr)
//비중이 높은 클래스를 상속..!

class TvVcr extends Tv{
	Vcr vcr;
	TvVcr(){
		vcr = new Vcr();
	}
}






public class Ex03_Inherit_Single {

	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv 전원상태 : "+t.power);
		
		t.chUp();
		t.chUp();
		t.chDown();
		System.out.println("Tv 채널정보 : "+t.ch);

		//비디오 전원...
		t.vcr.power();
		System.out.println("Vcr 전원상태 : "+t.vcr.power);
		
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power();
		
		t.power();
		System.out.println("Tv 전원상태 : "+t.power);
		System.out.println("Vcr 전원상태 : "+t.vcr.power);
	}

}
