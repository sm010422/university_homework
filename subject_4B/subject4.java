import java.util.Scanner;

public class subject4 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String correct_id ="hong18";
        String correct_password = "myongji70";

        boolean all_correct = false;
        boolean access_denied = false;
        String id = "";
        String pw = "";
        int count = 0;

        while(!all_correct){
            System.out.print("ID를 입력하세요: ");
            id = scan.next();

            System.out.print("암호를 입력하세요: ");
            pw = scan.next();
            if(!correct_id.equals(id)){
                System.out.println("ID가 틀립니다");
            }
            if(!correct_password.equals(pw)){
                System.out.println("암호가 틀립니다");
            }
            if(pw.equals(correct_password) && id.equals(correct_id)){
                all_correct = true;
            }else{
                count++;
            }
            if(count == 5){
                access_denied = true;
                break;
            }
        }
        if(access_denied) {
            System.out.print("접속을 거부합니다");
        }else{
            System.out.print("환영합니다");
        }
    }
}
