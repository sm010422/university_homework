import java.util.Scanner;
public class subject3 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("온도를 입력하세요: ");
        int temp = scan.nextInt();
        System.out.println("화씨 온도이면 'F'(혹은 'f')를 입력하고 섭씨 온도이면 'C' (혹은 'c')를 입력하세요:");
        String str = scan.next();
        System.out.println();

        if(str.equals("f") || str.equals("F")){
            double temp2 = temp;
            double temp3 = (temp2-32)/1.8;

            System.out.print("화씨 " + temp2 + " 도 = 섭씨 " + temp3 + " 도");

        }else if (str.equals("c") || str.equals("C")) {
            double temp2 = temp;
            double temp3 = (temp2*1.8)+32;

            System.out.print("섭씨 " + temp2 + " 도 = 화씨 " + temp3 + " 도");

        }else{
            System.out.println("섭씨도 화씨도 아니다 -");
            System.out.println(" 온도 변환을 할 수 없다 -");
            System.out.println(" 다음 번에는  화씨 온도이면 'F'(혹은 'f')를 입력하고 섭씨 온도이면 'C' (혹은 'c')를 입력하세요:");


        }


    }
}
