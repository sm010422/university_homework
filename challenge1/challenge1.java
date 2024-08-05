import java.util.Scanner;

public class challenge1 {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("물건의 가격<1,000원 이하>을 입력하세요: ");
        int price = scan.nextInt();

        System.out.println(price + "원 짜리 물건을 샀고 1,000원을 내셨습니다.");
        int change = 1000 - price;

        System.out.println("거스름돈은 " + change + "원입니다.");
        System.out.println("거스름돈의 내역은 다음과 같습니다:");
        System.out.println();

        int i500=0,i100=0,i50=0,i10=0,i5,i1=0;

        i500 = change/500;
        change = change%500;

        i100 = change/100;
        change = change%100;

        i50 = change/50;
        change = change%50;

        i10 = change/10;
        change = change%10;

        i5 = change/5;
        change = change%5;

        i1 = change;

        System.out.println("500원 짜리 동전 갯수 = " + i500);
        System.out.println("100원 짜리 동전 갯수 = " + i100);
        System.out.println("50원 짜리 동전 갯수 = " + i50);
        System.out.println("10월 짜리 동전 갯수 = " + i10);
        System.out.println("5원 짜리 동전 갯수 = " + i5);
        System.out.print("1원 짜리 동전 갯수 = " + i1);


    }
}
