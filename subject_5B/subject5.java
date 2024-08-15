import java.util.Scanner;

public class subject5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int integer = scan.nextInt();

        System.out.println("반복 메소드 결과");
        System.out.print(" 정수내의 숫자들: ");
        using_repeat(integer);
        System.out.println();

        System.out.println("재귀 메소드 결과");
        System.out.print(" 정수내의 숫자들: ");
        myFunction(integer);

    }

    public static int return_10n(int a){
        int number = 10;
        //boolean stop =  true;
        while(true){
            if(a/number < 10){
                if(a < 10){
                    return 1;
                }
                return number;
            }else{
                number = number*10;
            }
        }
        //return a;
    }

    public static String return_integer(int a){

        int[] number = {0,1,2,3,4,5,6,7,8,9};
        String[] korean = {"영","하나","둘","셋","넷","다섯","여섯","일곱","여덟","아홉"};
        for(int i=0; i < korean.length; i++) {
            if (a == number[i]) {
                return korean[i];
            }
        }
        return "";
    }

    //반복문 사용
    public static void using_repeat(int num){
        int scale_count = 0;
        int scale = return_10n(num);
        while(scale != 0){
            scale = scale/10;
            scale_count++;
        }
        String[] output = new String[scale_count];

        int count = scale_count-1;
        while(num != 0){

            output[count] = return_integer(num%10);

            num /= 10;
            count--;
        }
        for(String str : output){
            System.out.print(str + " ");
        }
        System.out.println();
    }


    //재귀함수
    public static void myFunction(int num){


        int save_num =  num;
        num /= 10;
        if(num == 0){
            System.out.print(return_integer(save_num%10) + " ");
            return;
        }
        myFunction(num);
        System.out.print(return_integer(save_num%10) + " ");


    }


}
