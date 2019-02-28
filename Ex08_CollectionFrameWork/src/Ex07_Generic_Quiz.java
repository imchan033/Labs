import java.util.ArrayList;
import java.util.List;

class Product{}

class Tv extends Product{
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product{
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product{
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex07_Generic_Quiz {
	public static void main(String[] args) {
		//1. Array(�迭) ����ؼ� cart ����� ��ǰ 3���� ��������
		Product[] cart = new Product[3]; //������
		cart[0] = new Tv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		//2. ArrayList �� ����ؼ� cart ����� ��ǰ 3���� ��������
		List<Product> cart2 = new ArrayList<Product>(); //************100��¥��!
		cart2.add(new Tv());
		cart2.add(new Tv());
		cart2.add(new Tv());
		cart2.add(new Audio());
		cart2.add(new Audio());
		cart2.add(new Audio());
		cart2.add(new NoteBook());
		cart2.add(new NoteBook());
		cart2.add(new NoteBook());
		cart2.add(new NoteBook());
		
		for(Product pro : cart2) {
			System.out.println(pro.toString());
		}
		
		
	}
}
