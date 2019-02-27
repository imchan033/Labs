import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoint {
	public static void main(String[] args) {
		
		//1. ��� 1���� ������ ��������
		Emp e = new Emp(100,"������","����");
		System.out.println(e.toString());
		
		//2. ��� 2���� ���弼��
		Emp[] emplist = {new Emp(10,"�达","IT"),new Emp(20,"�ھ�","sales")};
		for(Emp emp : emplist) {
			System.out.println(emp.toString());
		}
		
		//�Ǽ� �߾�� �Ѹ��� �Ի縦 �� �߾��...
		//�� �����迭�� �߰� �Ұ�(x) ->���� new (x)
		
		//����(ArrayList)
		ArrayList alist = new ArrayList();
		alist.add(new Emp(1,"�达","IT"));
		alist.add(new Emp(2,"�̾�","IT"));
		alist.add(new Emp(3,"�ھ�","IT"));
		
		System.out.println(alist.toString());
		
		//�Ϲ� for ���� ����ؼ� ��� ������ ����ϼ���
		//down casting*************
		for(int i =0; i<alist.size();i++) {
			//System.out.println(alist.get(i).toString());
			Emp emp = (Emp)alist.get(i); //return Object �ڽ�Ÿ�� = (�ڽ�Ÿ��)�θ�Ÿ��
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		}
		//������ for��
		for(Object obj : alist) {
			Emp emp = (Emp)obj;
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		}
		//����� ... �� �ڵ尡 �����ؿ� (Object)
		//generic (�������� ... 99%)
		
		ArrayList<Emp> alist2 = new ArrayList<Emp>();
		alist2.add(new Emp(1,"A","IT"));
		alist2.add(new Emp(2,"B","IT"));
		for(Emp obj : alist2) {
			System.out.println(obj.getEmpno()+","+obj.getEname()+","+obj.getJob());
		}
		ArrayList<Emp> alist3 = new ArrayList<Emp>();
		alist3.add(new Emp(1,"A","IT"));
		alist3.add(new Emp(1,"B","IT"));
		for(Emp emp : alist3) {
			System.out.println(emp.getEname()+emp.getEmpno()+emp.getJob());
		}
	}
}
