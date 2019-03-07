
 
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;
 
public class Hw02_Lotto_IO {
 
	public static void main(String[] args) {
		Hw02_Lotto_IO lotto = new Hw02_Lotto_IO();
		lotto.SelectLottoNumber();
	}
    private Scanner scanner;
    private Random r;//r.nextInt(45) +1 (1~45)
    private int[] numbers;
                //static{}, {} 초기자 
    public Hw02_Lotto_IO() { // 특수한 목적: member field 초기화(생성자 함수), constructor
          scanner = new Scanner(System.in);//초기화( 참조 변수 주소값을 갖는것)
          r = new Random();
          numbers = new int[6];
    }
    
    void LottoNumberIO(int[] numbers) {    	
    	try {
    		//FileInputStream number = new FileInputStream();
			FileOutputStream fos = new FileOutputStream("lotto.txt");
			//helper
			DataOutputStream dos = new DataOutputStream(fos);
			//DataOutputStream 통해서 score.txt write 하겠다
			for(int i = 0 ; i< numbers.length ; i++) {
				dos.writeInt(numbers[i]); //정수값 write ... 반드시 read DataInputStream
				//dos.writeUTF(str); //웹, 채팅 할 때 주로 사용...
			}
			dos.close();
			fos.close();
		}catch (Exception e) {
			
		}
    }
    
        
    public void SelectLottoNumber() {
        
        int menu;
        
        System.out.println("로또 프로그램");
        System.out.println("1.당신의 로또 번호를 추출 합니다.");
        System.out.println("2.프로그램을 종료.");
        System.out.println("메뉴를 선택하세요: ");
        
        menu = Integer.parseInt(scanner.nextLine());
                
            switch(menu) {
              case 1:
                  selectBasicLottoNumber(r, numbers);
                  LottoNumberIO(numbers);
                  SelectLottoNumber();
                  break;
              case 2:
                  System.out.println("프로그램을 종료합니다!  ");
                  break;
              
              default:
                  System.out.println("잘못 입력하셨습니다.");    
                  SelectLottoNumber();
    }
        }
    
    private void selectBasicLottoNumber(Random r, int[] numbers) {
        //실로또 번호 추출하고 중복값 배제 처리하는 함수
        
        for(int i =0; i<numbers.length;i++) { 
             numbers[i] = r.nextInt(45) +1;
           for(int j=0;j<i;j++) {
               if(numbers[i] == numbers[j]) {
                  i--;
                 break; 
               }           
           }
        }
        int temp = 0;
        for(int i=0;i<5;i++) {
            for(int j=i+1; j<6;j++)
            if(numbers[i]>numbers[j]) {
                temp = numbers[j];    
                numbers[j] = numbers[i];    
                numbers[i] = temp;
        }
        }
        
        System.out.print("당신의 로또 당첨 예상번호: ");
        for(int i =0; i<6;i++) {
            System.out.printf(" [%d] ",numbers[i]);
            }
        
        System.out.println();
    }    
}
