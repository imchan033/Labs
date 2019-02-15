package kr.or.bit;
 
 
import java.util.Random;
import java.util.Scanner;
 
// 2���� �迭(5�� 5��)
// �¼� ����, ������ �¼��� �ٲٱ�, �޴�ǥ
// ������ �¼� ���ý� ���� 
// ���� ������ ���ø����̼� ����
 
 
public class Movie_Theater {
    private Scanner sc;
    private static String[][] seats;
    private static int inputRowsInt;
    private static int inputNum2;
    private static String inputRows;
    private static int reservationSeats;
    
    static {
        inputRows ="";
        inputRowsInt = 0;
        inputNum2 = 0;
        seats = new String[][] {
            {"1","2","3","4","5","6"},
            {"1","2","3","4","5","6"},
            {"1","2","3","4","5","6"},
            {"1","2","3","4","5","6"},
            {"1","2","3","4","5","6"}};
        reservationSeats =0;
    }
    
    public Movie_Theater() {
        sc = new Scanner(System.in);
    } //������ ����
 
    private void seatsStatus(String[][] array) {
        int sum=0;
        for(int i=0; i<array.length; i++) {
            sum += array[i].length;
        }
        System.out.print("(��ü�¼�: " + sum+" / ���డ�� �¼�: "+ (sum-reservationSeats) +")\n" );
    }
    
    private void resetSeats() {
        if(reservationSeats==0) {
            System.out.println("\n\n ����� �¼��� �����ϴ�.");
            return;
        }else {
            for(int i=0; i<seats.length; i++) {
                for(int j=0; j<seats[i].length; j++) {
                    seats[i][j] = String.valueOf(j+1);
                }
            }
            reservationSeats = 0;
            System.out.println("\n\n ���Ÿ� ��� ����Ͽ����ϴ�.");
        }
    }
    
    public void show_menu() {
        do {
            try {
                String texth1 = "\n\n--------- ��ȭ�� ���� ���α׷� ---------\n\n";
                System.out.println(texth1);
                System.out.println("1. �¼� Ȯ��");
                System.out.print("2. �¼� ����");
                seatsStatus(seats);
                System.out.println("3. ���� ����ϱ�");
                System.out.println("4. ���� �ϰ� ����ϱ�");
                System.out.println("5. ���α׷� ����");
                System.out.print("\n����� ���� : ");
                int menu = Integer.parseInt(sc.nextLine());
                System.out.println();
                for(int i=0; i<texth1.length(); i++) {
                    System.out.print("-");
                } System.out.println();
                
                switch(menu) {
                case 1 :
                    show_seats();
                    break;
                case 2 :
                    inputSeat(menu);
                    break;
                case 3 : 
                    inputSeat(menu);
                    break;
                case 4 :
                    resetSeats();
                    break;
                case 5 :
                    return;
                default :
                    System.out.println("\n\n @@@ �ùٸ� �޴��� �����ϼ���. @@@\n\n");
                }
            }catch(Exception e) {
                System.out.println("\n\n @@@ �ùٸ� �޴��� �����ϼ���. @@@\n\n");
            }
            
        }while(true);
    }
    
    private void show_seats() {
        System.out.println("\n      SCREEN");
        System.out.println();
        for(int i=0; i<seats.length; i++) {
            for (int j=65+i;j<66+i;j++) {
                System.out.print((char)j);
            }
            System.out.print("|");
            System.out.print(" ");
            for(int j=0; j < seats[i].length; j++) {
                System.out.print(" ");
                System.out.print(seats[i][j]);
            } 
            System.out.println();
            for(int k=0; k< seats[i].length+8; k++) {
                System.out.print("-");
            }
            System.out.println();    
        }
        
    }
 
    private void changeSeats() {
        if(seats[inputRowsInt][inputNum2-1]!="X") {
            seats[inputRowsInt][inputNum2-1] = "X";
            System.out.println("\n@@@@@@@@ �¼��� �����߽��ϴ� @@@@@@@@\n");
            reservationSeats++;
        } else {
            System.out.println("\n [�ٽ� Ȯ���ϼ���!] �̹� ����� �¼� �Դϴ�.");
        }
    }
    
    private void cancelSeats() {
        if(seats[inputRowsInt][inputNum2-1]=="X") {
            seats[inputRowsInt][inputNum2-1] = String.valueOf(inputNum2);
            System.out.println("\n@@@@@@@@ �¼������� ����߽��ϴ� @@@@@@@@\n");
            reservationSeats--;
        } else {
            System.out.println("\n [�ٽ� Ȯ���ϼ���!] ����� �¼��� �ƴմϴ�.");
        }
    }
    
    private void displayMenu() throws InterruptedException {
        System.out.println("\n    SCREEN");
        System.out.println();
        for(int i=0; i<seats.length; i++) {
            for (int j=65+i;j<66+i;j++) {
                System.out.print((char)j);
            }
            System.out.print("|");
            System.out.print(" ");
            for(int j=0; j < seats[i].length; j++) {
                System.out.print(" ");
                System.out.print(seats[i][j]);
            } 
            System.out.println();
            for(int k=0; k< seats[i].length+8; k++) {
                System.out.print("-");
            }
            System.out.println();    
        }
        System.out.println();
//        System.out.println("--------- SweetBox �¼� ��ġ�� ---------\n");
        System.out.println("(\"X\"�� �̹� ����� �¼��Դϴ�.)");
        System.out.print("\n���� �����ϼ���.(ABCDE)\n==> ");
        inputRows = sc.nextLine();
        System.out.print("���� �����ϼ���.(12345)\n==> ");
        inputNum2 = Integer.parseInt(sc.nextLine());
    }
    
    private void inputSeat(int menu) {
            try {
                if(reservationSeats==0 && menu==3) {
                    System.out.println("\n\n @@@ ����� �¼��� �����ϴ�.@@@");
                    return;
                }
                displayMenu();
                switch(inputRows) {
                case "A":
                case "a":
                    inputRowsInt = 0;
                    if(menu==2) {
                        changeSeats();
                        break;
                    } else if(menu==3) {
                        cancelSeats();
                        break;
                    }
                case "B": 
                case "b":
                    inputRowsInt = 1; 
                    if(menu==2) {
                        changeSeats();
                        break;
                    } else if(menu==3) {
                        cancelSeats();
                        break;
                    }
                case "C":
                case "c":
                    inputRowsInt = 2; 
                    if(menu==2) {
                        changeSeats();
                        break;
                    } else if(menu==3) {
                        cancelSeats();
                        break;
                    }
                case "D":
                case "d":
                    inputRowsInt = 3; 
                    if(menu==2) {
                        changeSeats();
                        break;
                    } else if(menu==3) {
                        cancelSeats();
                        break;
                    }
                case "E":
                case "e":
                    inputRowsInt = 4; 
                    if(menu==2) {
                        changeSeats();
                        break;
                    } else if(menu==3) {
                        cancelSeats();
                        break;
                    }
                default: System.out.println("\n@@@@@ �Է°��� Ȯ���ϼ���. @@@@@\n");
                }
            } catch(Exception e) {
                System.out.println("\n@@@@@ ���� @@@@@\n");
            }
    }
}
