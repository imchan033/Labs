
 
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
                //static{}, {} �ʱ��� 
    public Hw02_Lotto_IO() { // Ư���� ����: member field �ʱ�ȭ(������ �Լ�), constructor
          scanner = new Scanner(System.in);//�ʱ�ȭ( ���� ���� �ּҰ��� ���°�)
          r = new Random();
          numbers = new int[6];
    }
    
    void LottoNumberIO(int[] numbers) {    	
    	try {
    		//FileInputStream number = new FileInputStream();
			FileOutputStream fos = new FileOutputStream("lotto.txt");
			//helper
			DataOutputStream dos = new DataOutputStream(fos);
			//DataOutputStream ���ؼ� score.txt write �ϰڴ�
			for(int i = 0 ; i< numbers.length ; i++) {
				dos.writeInt(numbers[i]); //������ write ... �ݵ�� read DataInputStream
				//dos.writeUTF(str); //��, ä�� �� �� �ַ� ���...
			}
			dos.close();
			fos.close();
		}catch (Exception e) {
			
		}
    }
    
        
    public void SelectLottoNumber() {
        
        int menu;
        
        System.out.println("�ζ� ���α׷�");
        System.out.println("1.����� �ζ� ��ȣ�� ���� �մϴ�.");
        System.out.println("2.���α׷��� ����.");
        System.out.println("�޴��� �����ϼ���: ");
        
        menu = Integer.parseInt(scanner.nextLine());
                
            switch(menu) {
              case 1:
                  selectBasicLottoNumber(r, numbers);
                  LottoNumberIO(numbers);
                  SelectLottoNumber();
                  break;
              case 2:
                  System.out.println("���α׷��� �����մϴ�!  ");
                  break;
              
              default:
                  System.out.println("�߸� �Է��ϼ̽��ϴ�.");    
                  SelectLottoNumber();
    }
        }
    
    private void selectBasicLottoNumber(Random r, int[] numbers) {
        //�Ƿζ� ��ȣ �����ϰ� �ߺ��� ���� ó���ϴ� �Լ�
        
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
        
        System.out.print("����� �ζ� ��÷ �����ȣ: ");
        for(int i =0; i<6;i++) {
            System.out.printf(" [%d] ",numbers[i]);
            }
        
        System.out.println();
    }    
}
