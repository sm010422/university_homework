import java.util.Scanner;

public class subject1 {
    public static void main(String [] args) {
        Scanner scan  = new Scanner(System.in);

        System.out.print("실습전 과제 점수를 입력하세요: ");

        double bef_act = scan.nextInt();

        System.out.print("실습 과제 점수를 입력하세요: ");

        double act = scan.nextInt();

        System.out.print("실습후 과제 점수를 입력하세요: ");

        double aft_act = scan.nextInt();

        double fin_score = 0;

        System.out.println("실습전 과제 점수 = " + (int)bef_act);
        System.out.println("실습 과제 점수 = " + (int)act);
        System.out.println("실습후 과제 점수 = " + (int)aft_act);
        System.out.println();

        fin_score =(double)((bef_act/20)*0.2 + (aft_act/30)*0.2 +(act/25)*0.6);
        fin_score = fin_score*100;
        System.out.println("최종 실습 점수 = " + fin_score);

    }

}
