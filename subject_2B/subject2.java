import java.util.Scanner;

public class subject2 {
    public static void main(String [] args){
        Scanner scan =  new Scanner(System.in);

        System.out.print("과일 이름들을 입력하세요: ");
        String fruit = scan.nextLine();
        String apple = fruit.substring(0,2);
        String grape = fruit.substring(3,5);
        String orange_apple = fruit.substring(6,7);
        String banana = fruit.substring(8,11);

        System.out.print( banana +" "+ orange_apple +" "+ grape +" "+ apple);


    }
}
