import java.util.Scanner;

public class VendingMachine01 {
    String manufacturer; // 제조사
    String model; // 모델명
    final static int cigarPrice = 4500;
    static int startMoney = 100000;
    static int receivedMoney;// 넣은 금액
    boolean[] isStop; // 담배선택버튼에서 재고가 없어서 판매금지등이 켜진 경우

    boolean isPayback;// 반환레버상태 : 0인 경우 잔돈 또는 원금 반환
    boolean[] selectCigarette;// 담배선택버튼
    int changeAmount;// 잔돈잔액 (일단 이렇게)
    static int totalCount = 0;// 총 담배

    public static Cigarettes01[] cigar = new Cigarettes01[6];// 담배의 종류가 여러가지이므로 배열 선언
    public static int cigarNum[] = new int[cigar.length];// 담배 수량관리
    static Scanner sc = new Scanner(System.in);

    public static void cigarInfo() {

        cigar[0] = new Cigarettes01("필립모리스", "말보로");
        cigar[1] = new Cigarettes01("필립모리스", "마일드세븐");
        cigar[2] = new Cigarettes01("필립모리스", "던힐");
        cigar[3] = new Cigarettes01("KT&G", "팔리아멘트");
        cigar[4] = new Cigarettes01("KT&G", "디스플러스");
        cigar[5] = new Cigarettes01("KT&G", "에쎄 체인지");

        for (int i = 0; i < cigar.length; i++) {
            cigarNum[i] = 30;
        }

    }

    public static boolean isAdult(int age) { // 성인확인
        boolean result;
        if (age < 1900 && age > 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public int payRemains() { // 반환될 잔돈
        return 0;
    }

    public int availableCigarettes01() { // 담배수량확인 (IoT가 있어야 가능~)
        return 0;
    }

    public void selectCigarettes01(int select) { // *번째 담배를 선택
        System.out.println("선택");
        System.out.println("잔돈에서 담배금액 차감");
        System.out.println("잔돈이 담배금액보다 많을 경우 해당 담배선택버튼에 불이 켜짐");
        sellCount();
    }

    public static String payMenu(int receivedMoney) { //
        int menuNum;
        int returnMoney;
        System.out.println("원하는 담배의 번호를 입력해주세요! ");
        menuNum = Integer.parseInt(sc.nextLine());

        cigarNum[menuNum - 1]--;

        returnMoney = receivedMoney - cigarPrice;

        System.out.printf("가격은 %d원입니다..\n", cigarPrice);
        System.out.printf("잔돈은 %d 입니다.\n", returnMoney);

        startMoney -= returnMoney;

        return cigar[menuNum - 1].cigarName;
    }

    public boolean requestOrder() { // 관리자 호출 : 담배재고중 한 종류라도 떨어지면 호출??
        return false;
    }

    public static void sellCount() { // 누적판매개수
        totalCount++;
    }

    public boolean requestChange() { // 잔돈이 떨어지면 관리자 호출?
        return false;
    }

    public void dailySelling(int totalCount) {
        int sellingSum = 0;
        sellingSum = totalCount * 4500;
        System.out.println("당일 누적 판매개수:  " + totalCount + "당일 누적 판매금액: " + sellingSum);
    }

    public static void displayCigarettes01() {

        int cnt = 0;

        System.out.println("원하시는 담배를 선택하세요! ");
        System.out.println();
        for (int i = 0; i < cigar.length; i++) {
            System.out.printf("[%d. %s ", i + 1, cigar[i].cigarName);
            if (cigarNum[i] > 0)
                System.out.printf("%c]  \t", '■');
            else
                System.out.printf(" %c]  \t", '□');
            cnt++;
            if (cnt == 3) {
                System.out.println();

            }
        }
        System.out.println();
    }

    class Cigarettes01 {

        public String maker;//제조사
        public String cigarName;//담배 이름
        //public int cigarPrice;// 가격
       // public int cigarNum;// 수량
        
        

         public Cigarettes01(String maker, String cigarName) {
             this.maker = maker;
             this.cigarName = cigarName;
             //this.cigarPrice= cigarPrice;
             //this.cigarNum = cigarNum;
         }
         /*
         public void dailySelling(int totalCount) {
    		 int sellingSum = 0;
    		 sellingSum = totalCount*4500;
    		 System.out.println("당일 누적 판매개수:  "+ totalCount+"당일 누적 판매금액:                 "+ sellingSum);
    	 }
    	 */

    }
    public static void main(String[] args) {
        int age;

        System.out.println("--------담배 자판기-----------");
        System.out.println("성인인증을 시작합니다. ");
        System.out.println("생년 월일을 입력하세요! ex) 92년 07월 -> 9207 ");

        while (true) {
            age = Integer.parseInt(sc.nextLine());
            if (isAdult(age) == false) {
                System.out.println("미성년자는 담배를 구입할 수 없습니다.");
                System.out.println("다시 입력해주세요 !");
            } else
                break;

        }

        cigarInfo();

        System.out.println("돈을 투입해주세요!");
        receivedMoney = Integer.parseInt(sc.nextLine());

        displayCigarettes01();

        System.out.printf("%s 가 나왔습니다!  \n", payMenu(receivedMoney));

        sellCount();

    }

}