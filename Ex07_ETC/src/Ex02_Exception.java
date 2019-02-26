
public class Ex02_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		//예외 처리 ..
		try {
			for(int i=0 ; i<10 ; i++) {
				result =num/(int)(Math.random()*10); // 0~9 까지 값
				System.out.println("result : " + result + "i : " + i);
			}			
		}catch(ArithmeticException e) { //가독성 ...
			System.out.println("연산 예외 : "+ e.getMessage());
		}catch(Exception e) {
			System.out.println("나머지 예외는 내가 처리...");
		}
		//여러개의 catch block 생성 가능
		//하위 예외가 항상 위에 있어야 된다(부모)
		System.out.println("MainEnd");

	}

}
