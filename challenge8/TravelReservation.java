import java.util.Scanner;

public class TravelReservation {
    private static final String[] PACKAGE = {"제주도", "경주", "설악산"};
    private static final boolean[][] reservations = new boolean[3][10];

    public static void printPackageList() {
        System.out.println("==== 여행 상품 목록 ====");
        for (int i = 0; i < PACKAGE.length; i++) {
            System.out.println((i + 1) + ". " + PACKAGE[i]);
        }
    }

    public static int getPackageNumber(Scanner scanner) {
        while (true) {
            System.out.print("예약을 원하는 여행 상품의 번호를 입력하세요: ");
            int number = scanner.nextInt();
            if (number < 1 || number > PACKAGE.length) {
                System.out.println("유효하지 않은 여행 상품 번호! 다시 입력하세요.");
            } else {
                return number;
            }
        }
    }

    public static int getReservedSeatCount(int packageNumber) {
        int count = 0;
        for (int i = 0; i < reservations[packageNumber - 1].length; i++) {
            if (reservations[packageNumber - 1][i]) {
                count++;
            }
        }
        return count;
    }

    public static int assignSeat(int packageNumber, int seatCount) {
        for (int i = 0; i < reservations[packageNumber - 1].length; i++) {
            int availableSeats = 0;
            int startIndex = -1;
            for (int j = i; j < i + seatCount; j++) {
                if (!reservations[packageNumber - 1][j]) {
                    availableSeats++;
                    if (startIndex == -1) {
                        startIndex = j;
                    }
                } else {
                    availableSeats = 0;
                    startIndex = -1;
                    break;
                }
            }
            if (availableSeats == seatCount) {
                for (int j = startIndex; j < startIndex + seatCount; j++) {
                    reservations[packageNumber - 1][j] = true;
                }
                return startIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int travelerCount;
        String name;

        while (true) {
            printPackageList();


            int packageNumber = getPackageNumber(scanner);

            System.out.print("이름을 입력하세요: ");
            name = scanner.next();

            while(true){
                System.out.print("여행자 수를 입력하세요: ");
                travelerCount = scanner.nextInt();


                int availableSeats = 10 - getReservedSeatCount(packageNumber);
                if(travelerCount > 10){
                    System.out.println("유효하지 않은 여행자 수! 다시 입력하세요.");
                }else if (availableSeats < travelerCount) {
                    System.out.println("좌석이 충분하지 않음! 다시 입력하세요.");
                    packageNumber = getPackageNumber(scanner);
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.next();
                    continue;
                }else{
                    break;
                }

            }

            int seatIndex = assignSeat(packageNumber, travelerCount);
            if (seatIndex != -1) {
                System.out.println(name + "으로 "+ travelerCount +"명 예약 확정됨");
                System.out.print("여행 상품: " + PACKAGE[packageNumber - 1] + ". ");
                System.out.println("좌석 번호: " + seatIndex + "-" + (seatIndex + travelerCount - 1));
            } else {
                System.out.println("좌석 배정에 실패했습니다.");
            }


            System.out.print("예약을 계속하나요(Yes 혹은 No)? ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("Yes")) {
                break;
            }
        }

        scanner.close();
    }
}
