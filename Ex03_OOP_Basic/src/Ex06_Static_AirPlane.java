/*
 �츮ȸ��� ����⸦ �ֹ� ���� �Ǹ��ϴ� ȸ���Դϴ�
 �츮ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ��Ϸ��� �մϴ�
 
 ������� �䱸����
 1. ����⸦ �����ϸ� ������� �̸��� ��ȣ�� �ο��ؾ� �մϴ�
 2. ����Ⱑ ����Ǹ� ������� �̸��� ��ȣ�� �°� �ο��Ǿ����� Ȯ���ϴ� ���(�������)
 3. ����Ⱑ ��� �� �� ���� ������� ��������� Ȯ�� �� �� �ֽ��ϴ�.
 
 ����⸦ ����� (Airplane air = new Airplane();)
 ���赵�� ���ݱ��� ��� �ڵ�� �ۼ�...(�ּ��� 3��)���弼��
 kr.or.bit.AirPlane �̸����� �ۼ�
 */
import kr.or.bit.Airplane;

public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
		/*
		Airplane air1 = new Airplane();
		air1.name = "�����װ�";
		air1.number = 707;
		air1.AirplaneInfo();
		air1.getCount();
		
		Airplane air2 = new Airplane();
		air2.name = "�ƽþƳ�";
		air2.number = 808;
		air2.AirplaneInfo();
		air2.getCount();
		
		Airplane air3 = new Airplane();
		air3.name = "������";
		air3.number = 909;
		air3.AirplaneInfo();
		air3.getCount();
		
		
		Airplane a = new Airplane();
		a.makeAirPlane(707, "�����װ�");
		a.airPlaneTotalCount();
		
		Airplane a2 = new Airplane();
		a.makeAirPlane(807, "�ƽþƳ�");
		a.airPlaneTotalCount();
		
		Airplane a3 = new Airplane();
		a.makeAirPlane(709, "������");
		a.airPlaneTotalCount();
		*/
		Airplane air = new Airplane(707, "�����װ�");
		air.airplaneInfo();
		air.airPlaneTotalCount();
		
		Airplane air2 = new Airplane(808, "�ƽþƳ�");
		air2.airplaneInfo();
		air2.airPlaneTotalCount();
		
	}

}
