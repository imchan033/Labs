import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		//1. Emp Ŭ������ ����ؼ� ��� 3���� �����ϼ���
		//�� ArrayList ���ʸ��� ����ϼ���
		List<Emp> empInfo = new ArrayList<Emp>();
		empInfo.add(new Emp(111,"��","IT"));
		empInfo.add(new Emp(222,"��","IT"));
		empInfo.add(new Emp(333,"��","IT"));
		
		//2. 3���� ��� ����(���,�̸�,����)�� ������for ���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		for(Emp emp : empInfo) {
			System.out.println(emp.getEmpno()+","+emp.getEname()+","+emp.getJob());
		}
		
		//3. 3���� ��� ����(���,�̸�,����)�� �Ϲ�for ���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		for(int i=0 ; i<empInfo.size() ; i++) {
			System.out.println(empInfo.get(i).getEmpno()+","+empInfo.get(i).getEname()+","+empInfo.get(i).getJob());
		}
		
		//4. CopyEmp ��� Ŭ������ ���弼�� (������ Emp �� ������)
		//job member field ��ſ� (����)
		//private int sal �߰��ϰ� (getter, setter ����)
		//ArrayList ���ʸ� ����ؼ� ��� 3�� ���弼��
		//�Ʒ� ������
		//100 , "��" , 1000
		//200 , "��" , 2000
		//300 , "��" , 3000
		List<CopyEmp> empInfo2 = new ArrayList<CopyEmp>();
		empInfo2.add(new CopyEmp(100,"��",1000));
		empInfo2.add(new CopyEmp(200,"��",2000));
		empInfo2.add(new CopyEmp(300,"��",3000));
		
		//5. 200�� ����� �޿��� 5000���� �����ؼ� ����ϼ��� (�Ϲ� for�� ����ϼ���)
		for(int i=0; i<empInfo2.size() ; i++) {
			if(empInfo2.get(i).getEmpno()==200) {
				empInfo2.get(i).setSal(5000);
			}
			System.out.println(empInfo2.get(i).getEmpno()+","+empInfo2.get(i).getEname()+","+empInfo2.get(i).getSal());
		}
		
		//6. 300�� ����� �̸��� "�ñ���" �� �����ؼ� ����ϼ���(������ for�� �ȿ���...)
		for(CopyEmp emp : empInfo2) {
			if(emp.getEmpno()==300) {
				emp.setEname("�ñ���");
			}
			System.out.println(emp.getEmpno()+","+emp.getEname()+","+emp.getSal());
		}
		
		//7.��������� Iterator �������̽��� ����ؼ� ����ϼ��� 
		 System.out.println("**********************************");
		 Iterator<CopyEmp> it = empInfo2.iterator();
		 while(it.hasNext()) {
			CopyEmp e = it.next();
			System.out.println(e.getEmpno() +","+e.getEname()+","+e.getSal());
		 }
		
	}
}
