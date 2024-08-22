import java.util.Scanner;

class Employee {
    public String employeeNumber;
    public String employeeName;

    public Employee(String employeeName, String employeeNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
    }
}

class NumberLengthException extends Exception {
    public NumberLengthException(String number) {
        super("길이가 " + number.length() + "인 " + number + "은 유효하지 않다: 길이는 6이어야 한다.");
    }
}

class NumberCharacterException extends Exception {
    public NumberCharacterException(String number, char invalidChar) {
        super(number + "은 틀린 번호이다: 숫자가 아닌 문자(" + invalidChar + ")를 포함한다.");
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee[] employees = new Employee[10];
        int count = 0;

        while (count < 10) {
            System.out.print("직원 " + (count + 1) + "의 이름을 입력하세요: ");
            String name = scan.next();
            System.out.print("직원 " + (count + 1) + "의 번호를 입력하세요(6 개의 숫자들): ");
            String number = scan.next();

            try {
                if (number.length() != 6) {
                    throw new NumberLengthException(number);
                }
                for (int j = 0; j < number.length(); j++) {
                    if (!Character.isDigit(number.charAt(j))) {
                        throw new NumberCharacterException(number, number.charAt(j));
                    }
                }

                employees[count] = new Employee(name, number);
                count++;

            } catch (NumberLengthException | NumberCharacterException e) {
                System.out.println(e.getMessage());
                System.out.println("직원 " + (count + 1) + "의 데이터를 다시 입력하세요");
            }

            System.out.print("계속하기를 원하는가(예 혹은 아니오)? ");
            String choice = scan.next();
            if (choice.equalsIgnoreCase("아니오")) {
                break;
            } else if (!choice.equalsIgnoreCase("예")) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }

        System.out.println();
        System.out.println("직원 목록:");
        for (int i = 0; i < count; i++) {
            System.out.println("직원 " + (i + 1));
            System.out.println("이름: " + employees[i].employeeName);
            System.out.println("번호: " + employees[i].employeeNumber);
        }
    }
}
