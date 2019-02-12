

import kr.or.bit.Book;
import kr.or.bit.Car;

public class Ex03_Modifier {

	public static void main(String[] args) {
		Car car = new Car();

		car.setWindow(5);
		System.out.println(car.getWindow());
		
		car.setSpeed(-1);
		System.out.println(car.getSpeed());
		
		car.speedUp();
		System.out.println("현재 속도 : "+car.getSpeed());
		
		car.speedDown();
		System.out.println("현재 속도 : "+car.getSpeed());
		
		Book book = new Book();
		book.bookName="Java";
		
		
	}
}
