import java.util.Scanner;

public class challenge4{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int year;

        // 로마 숫자 상수 정의
        String[] romanNumerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        while (true) {
            System.out.print("연도를 입력하세요: ");
            year = scan.nextInt();

            if (year < 1 || year > 5000) {
                System.out.println("잘못된 연도 입력");
            } else {
                System.out.println("입력된 연도: " + year);

                StringBuilder result = new StringBuilder();

                // 연도를 로마 숫자로 변환
                int i = romanNumerals.length - 1; // 가장 큰 로마 숫자부터 시작
                while (year > 0) {
                    if (year >= decimalValues[i]) {
                        result.append(romanNumerals[i]);
                        year -= decimalValues[i];
                    } else {
                        i--;
                    }
                }

                System.out.println("로마 숫자로 변환한 연도: " + result);
                break;
            }
        }
    }
}
