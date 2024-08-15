import java.util.Scanner;
public class challenge5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.print("로마 숫자를 입력하세요: ");
            String roma = scan.next().toUpperCase();

            if (return_decimal(roma) < 5000 && return_decimal(roma) > 0) {

                System.out.print("10진수로 변환한 숫자: ");
                System.out.println(return_decimal(roma));

                System.out.print("8진수로 변환한 숫자: ");
                System.out.print(return_octal((return_decimal(roma))));


                break;
            } else {
                System.out.println("잘못 입력된 로마 숫자");
            }
        }

    }

    public static int return_num(String str) {

        String[] roma = {"I", "V", "X", "L", "C", "D", "M"};
        int[] num = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < roma.length; i++) {
            if (str.equals(roma[i])) {
                return num[i];
            }
        }

        return -1;
    }

    public static int return_decimal(String str) {
        char[] roma = str.toCharArray();
        int decimalValue = 0;
        int prevValue = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            int currentValue = return_num(String.valueOf(roma[i]));
            if (currentValue < prevValue) {
                decimalValue -= currentValue;
            } else {
                decimalValue += currentValue;
            }
            prevValue = currentValue;
        }
        return decimalValue;
    }

    public static String return_octal(int dec) {

        if(dec <= 0){
            return "";
        }
        int share = dec/8;
        int rest = dec%8;

        String octalValue = return_octal(share);
        return octalValue + rest ;
    }
}
