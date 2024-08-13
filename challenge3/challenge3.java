import java.util.Scanner;
public class challenge3 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("이름은? ");
        String name = scan.next();

        System.out.print("입학연도는? ");
        String year = scan.next();
        year = year.substring(2,4);

        System.out.print("입학 유형은(신입생 혹은 편입생)? ");
        String type = scan.next();

        String st_type = "0";
        if(type.equals("신입생")){
            st_type = "2";
        }else if(type.equals("편입생")){
            st_type = "5";
        }

        int count = 0;
        String order = "0";
        if(count < 10){
            count++;
            order = "00" + count;
        }else if( count > 9 && count < 100){
            order = "0" + count;
            count++;
        }else if( count > 99 && count < 1000){
            order = "" + count;
            count++;
        }

        System.out.println("이름: " + name);
        System.out.println("학번: " + "60" + year + st_type + order);

    }
}
