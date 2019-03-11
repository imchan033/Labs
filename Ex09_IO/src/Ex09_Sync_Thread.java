//����ȭ
//�Ѱ� ȭ��� (�����ڿ�) : �ټ��� ����ڰ� ȭ����� ��� 10��(10���� Thread)
//LOCK �����ġ

//�����ġ ��� : ��ü
//POINT : ����� ���(method)

//�达�� ȭ��ǿ��� ���� ���ٰ� ���� �İ� �; ������ ������ ���� �İ� ���Ծ��
//�ٸ� �༮�� ȭ��ǿ� �� ���� ���ƿ�
class Wroom {
	public synchronized void openDoor(String name) {
		System.out.println(name + "�� ȭ��� ����~");
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "���:" + i);
			if (i == 10) {
				System.out.println(name + "��..��!");
			}
		}
		System.out.println("�ÿ��ϴ�~");
	}
}

class User extends Thread {
	private Wroom wr;
	private String who;

	public User(String name, Wroom w) {
		this.who = name;
		this.wr = w;// ȭ��� �ּҰ�
	}

	@Override
	public void run() {
		wr.openDoor(this.who);
	}
}

public class Ex09_Sync_Thread {
	public static void main(String[] args) {
		//�Ѱ���ġ
		Wroom w = new Wroom(); //ȭ���1��
		
		//�����
		User kim = new User("�达",w);
		User lee = new User("�̾�",w);
		User park = new User("�ھ�",w);
		
		//��� ������� ��Ż
		kim.start();
		lee.start();
		park.start();
	}
}
