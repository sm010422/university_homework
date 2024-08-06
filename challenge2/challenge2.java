import java.util.Scanner;

public class challenge2 {
    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);

        System.out.print("12 비트(bit)의 이진수를 입력하세요: ");
        String str = scan.next();

        int sector1  = 4*Integer.parseInt(str.substring(0,1));
        sector1 += 2*Integer.parseInt(str.substring(1,2));
        sector1 += 1*Integer.parseInt(str.substring(2,3));

        int sector2  = 4*Integer.parseInt(str.substring(3,4));
        sector2 += 2*Integer.parseInt(str.substring(4,5));
        sector2 += 1*Integer.parseInt(str.substring(5,6));

        int sector3  = 4*Integer.parseInt(str.substring(6,7));
        sector3 += 2*Integer.parseInt(str.substring(7,8));
        sector3 += 1*Integer.parseInt(str.substring(8,9));

        int sector4  = 4*Integer.parseInt(str.substring(9,10));
        sector4 += 2*Integer.parseInt(str.substring(10,11));
        sector4 += 1*Integer.parseInt(str.substring(11,12));


        System.out.print("이진수 " + str + "에 대응하는 8진수는 "+sector1 + sector2 + sector3 + sector4 + " 이다.");

    }
}
