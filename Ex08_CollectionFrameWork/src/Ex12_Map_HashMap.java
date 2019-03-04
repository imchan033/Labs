import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 Map �������̽��� �����ϴ� Ŭ����
 Map >> (Ű(key), ��(value)) �ֹ迭
 ex) ������ȣ : (02, ����) ...
 key �� : �ߺ�(x)
 value : �ߺ�(o)
 
 Map >> Generic ����
 
 HashTable(������) : ����ȭ ����
 HashMap(�Ź���) : ����ȭ�� ���� ���� �ʾƿ�(�ʿ��ϸ� ����ȭ ����)
 */
public class Ex12_Map_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		//Ȱ�� : ȸ��ID, ȸ�� PWD ��´�(memory)��
		//�޸�(heap) >> ���� ����(���ϱ��) login.txt ���� ���� >> RDBMS (������DB)
		
		System.out.println(map.containsKey("Tiger")); //"Tiger" �������ִ�? true ex)���̵��ߺ�üũ
		System.out.println(map.containsValue("1004"));//true
		
		//(key, value)
		//POINT : key ���� ������ value ���� ã�� ��
		System.out.println(map.get("Tiger")); //ex)���̵�� ��й�ȣ ã��
		System.out.println(map.get("hong"));  //null >> hong��� key ���� ������ ���� �ʴ�
		
//		put
//		map.put("Tiger", "1004");
//		map.put("scott", "1004");
//		map.put("superman", "1007");
		map.put("Tiger", "1008"); //key�� ���� ��� value : overwrite �����
		System.out.println(map.get("Tiger"));
		System.out.println("before : "+ map.size());
		Object returnvalue = map.remove("superman"); //key ����
		System.out.println(returnvalue); //value �� return ���ٰ� �ʿ��ϴٸ� ��
		System.out.println("after : "+ map.size());
		
		Set set = map.keySet(); //����
		// Set �������̽��� �����ϴ� ��ü(HashSet)�� ���������� new �ϰ� �ű⿡�ٰ� key���� ���
		//�� �ּҰ��� �����Ѵ�...������ ���� >> keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Quiz Map ���� value ������ ��Ƽ� ����ϼ���
		//map.values()...
		Collection vlist = map.values();
		System.out.println(vlist);
		System.out.println(map.values());
		
		
		
	}
}
