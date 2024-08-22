import java.util.Scanner;

class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("0으로 나누려고 시도!");
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}

class UnknownOpException extends Exception {
    public UnknownOpException() {
        super("허용되지 않는 연산자로 인한 예외");
    }

    public UnknownOpException(char op) {
        super(op + "는 허용되지 않는 연산자이다.");
    }

    public UnknownOpException(String message) {
        super(message);
    }
}

public class Calculator {
    private double result;

    public Calculator() {
        result = 0.0;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산기 시작합니다.");
        System.out.println("연산식을 나타내는 각 라인(line)의 포맷: 연산자 숫자");
        System.out.println("예: + 3");
        System.out.println("끝내려면 e(혹은 E)를 입력하세요.");
        System.out.println("\nresult = " + result);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("e")) {
                break;
            }

            try {
                processInput(input);
            } catch (DivideByZeroException e) {
                System.out.println("0 혹은 0에 아주 가까운 값으로 나누려고 시도하여 \n프로그램이 중단되었습니다.");
                return;
            } catch (UnknownOpException e) {
                System.out.println(e.getMessage());
                System.out.println("처음부터 다시 시작하세요.");
                System.out.println("연산식을 나타내는 각 라인(line)의 포맷: 연산자 숫자");
                System.out.println("예: + 3");
                System.out.println("끝내려면 e(혹은 E)를 입력하세요.");
                result = 0.0;  // Reset the result to 0
                System.out.println("\nresult = " + result);
            }
        }

        System.out.println("최종 result = " + result);
        System.out.println("계산기 프로그램이 종료합니다.");
    }

    private void processInput(String input) throws DivideByZeroException, UnknownOpException {
        char op = input.charAt(0);
        double number = Double.parseDouble(input.substring(2));

        switch (op) {
            case '+':
                result += number;
                break;
            case '-':
                result -= number;
                break;
            case '*':
                result *= number;
                break;
            case '/':
                if (number == 0 || Math.abs(number) < 0.0001) {
                    throw new DivideByZeroException();
                }
                result /= number;
                break;
            default:
                throw new UnknownOpException(op);
        }

        System.out.println("result " + op + " " + number + " = " + result);
        System.out.println("갱신된 result = " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
