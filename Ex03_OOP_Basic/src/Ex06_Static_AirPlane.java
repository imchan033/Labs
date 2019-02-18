/*
 우리회사는 비행기를 주문 제작 판매하는 회사입니다
 우리회사는 비행기를 생산하는 설계도를 작성하려고 합니다
 
 사장님의 요구사항
 1. 비행기를 생산하면 비행기의 이름과 번호를 부여해야 합니다
 2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인하는 기능(정보출력)
 3. 비행기가 출고 될 때 마다 비행기의 누적대수를 확인 할 수 있습니다.
 
 비행기를 만든다 (Airplane air = new Airplane();)
 설계도는 지금까지 배운 코드로 작성...(최소한 3대)만드세요
 kr.or.bit.AirPlane 이름으로 작성
 */
import kr.or.bit.Airplane;

public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
		/*
		Airplane air1 = new Airplane();
		air1.name = "대한항공";
		air1.number = 707;
		air1.AirplaneInfo();
		air1.getCount();
		
		Airplane air2 = new Airplane();
		air2.name = "아시아나";
		air2.number = 808;
		air2.AirplaneInfo();
		air2.getCount();
		
		Airplane air3 = new Airplane();
		air3.name = "진에어";
		air3.number = 909;
		air3.AirplaneInfo();
		air3.getCount();
		
		
		Airplane a = new Airplane();
		a.makeAirPlane(707, "대한항공");
		a.airPlaneTotalCount();
		
		Airplane a2 = new Airplane();
		a.makeAirPlane(807, "아시아나");
		a.airPlaneTotalCount();
		
		Airplane a3 = new Airplane();
		a.makeAirPlane(709, "진에어");
		a.airPlaneTotalCount();
		*/
		Airplane air = new Airplane(707, "대한항공");
		air.airplaneInfo();
		air.airPlaneTotalCount();
		
		Airplane air2 = new Airplane(808, "아시아나");
		air2.airplaneInfo();
		air2.airPlaneTotalCount();
		
	}

}
