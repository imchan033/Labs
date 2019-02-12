//������ (Ex04_Variable_Scope.java ���� �ȿ��� class ����)

class Variable{ //default ���� ������
	int iv;
	/*
	 1. member field, instance variable
	 2. ���� : ������ �������� �����(����,����,����(��ǰ))
	 3. Ư¡ : �ʱⰪ�� (default) ������ �ִ�.
	 		   �ʱ�ȭ�� ���� �ʴ´�.(�����Ǵ� ��ü���� �ٸ� ���� ���´�)
	 4. ��������(memory�� �ε��Ǵ� ����) : new ��� �����ڸ� ���ؼ� heap ��ü ��������� ����
	 */
	static int cv;
	/*
	 1. class variable, static variable (����ƽ�� [�����ڿ�] �̴�)
	 2. ���� : ������ �������� ����� >> [�����Ǵ� ��� ��ü�� �����ϴ� �ڿ�] >> ��ü�� �����ڿ�
	 3. Ư¡ : ���ٹ�� >> Ŭ�����̸�.static�ڿ�(Variable.cv)>>��ü�� ��������� �ʾƵ� ���� ����(Math.random())
	 4. �������� : ���α׷��� ����(java hello) class loader system�� ���ؼ� [Ŭ���� ����]�� �а� (class area = method area)�� �ø��� ����
	 			 �÷��� Ŭ�����ȿ� static �ڿ��� ������ �ִٸ� static �ڿ��� ���� memory road �մϴ�
	 			 >> static �� ��ü ���� ������ memory�� �ö󰡴� �ڿ�
	 */
	void method() {
		int lv=0;
		//local variable(��������)
		//Ư¡ : ���������� ����ϱ� �� �ݵ�� �ʱ�ȭ
		//�������� : �Լ��� ȣ��Ǹ� ��������� �Լ��� ������ �Ҹ� (stack) ����
	}
}

public class Ex04_Variable_Scope {

	public static void main(String[] args) {
		/*
		Variable.cv = 100; // static ����(����)
		System.out.println("Variable.cv : "+Variable.cv);
		
		Variable v = new Variable();
		v.iv = 200;
		v.cv = 500;
		System.out.println("Varable.cv : "+ Variable.cv);
		*/
		System.out.println("Varable.cv : "+ Variable.cv);
		//��ü�� �����ڿ�
		Variable v = new Variable();
		System.out.println(v.cv);
		
		Variable v2 = new Variable();
		System.out.println(v2.cv);
	}

}
