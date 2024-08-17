import java.util.Random;
import java.util.Scanner;
class PairOfDice{
    private int firstDice;
    private int secondDice;

    public PairOfDice(){
        this.firstDice = 1;
        this.secondDice = 1;
    }
    public void throwDice(){
        Random random = new Random();
        this.firstDice = random.nextInt(6) + 1;
        this.secondDice = random.nextInt(6) + 1;
    }
    public int getFirstDice(){return this.firstDice;};
    public int getSecondDice(){return this.secondDice;}

}

class Player{
    public int totalPoint;
    public int sessionPoint;
    public int goalPoint;
    public Player(int goalPoint){
        this.totalPoint = 0;
        this.sessionPoint = 0;
        this.goalPoint = goalPoint;
    }
    public boolean doingGame(PairOfDice dice, int limitPoint){

        dice.throwDice();
        if(dice.getFirstDice() ==1 || dice.getSecondDice() ==1){
            if(dice.getFirstDice() == 1 && dice.getSecondDice() == 1) {
                System.out.println("Dice: " + dice.getFirstDice() +" + " + dice.getSecondDice() + " = " + (dice.getFirstDice() + dice.getSecondDice()));
                System.out.println("꽝입니다!!!");
                totalPoint = sessionPoint = 0;
                return false;
            }
            System.out.println("Dice: " + dice.getFirstDice() +" + " + dice.getSecondDice() + " = " + (dice.getFirstDice() + dice.getSecondDice()));
            System.out.println("꽝입니다!!!");
            if(totalPoint == sessionPoint){
                totalPoint = sessionPoint = 0;
            }else{
//                totalPoint -= sessionPoint;
                sessionPoint = 0;

            }
            return false;
        }else{
            System.out.println("Dice: " + dice.getFirstDice() +" + " + dice.getSecondDice() + " = " + (dice.getFirstDice() + dice.getSecondDice()));
            sessionPoint += (dice.getFirstDice() + dice.getSecondDice());
            System.out.println("현 회차 점수: " + sessionPoint);
            //totalPoint += (dice.getFirstDice() + dice.getSecondDice());
            if(sessionPoint >= limitPoint) {
//                System.out.println("컴퓨터 반환");
                totalPoint += sessionPoint;
                sessionPoint = 0;
                return false;
            }
            return true;
        }
    }
    public int getTotalPoint() {return totalPoint;}
}

class Game{
    public int gameGoalPoint;
    public PairOfDice dice;
    public Player computerPlayer;
    public Player userPlayer;
    public Player currentPlayer;
    public Game(int gameGoalPoint){
        this.gameGoalPoint = gameGoalPoint;
        dice = new PairOfDice();
        computerPlayer = new Player(20);
        userPlayer = new Player(-1);
    }

    public void processGame(){
        Scanner scan = new Scanner(System.in);

        while(true){
            currentPlayer = computerPlayer;
            System.out.println("****************************************");
            System.out.println("컴퓨터 차례...");
            this.throwDice();
            while(currentPlayer == computerPlayer && currentPlayer.doingGame(dice ,20)){
                System.out.println("총점: " + (currentPlayer.totalPoint + currentPlayer.sessionPoint));
                if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }
//                break;
            }
            if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }

            currentPlayer = userPlayer;
            System.out.println("****************************************");
            System.out.println("사용자 차례...");
            this.throwDice();
            while(currentPlayer == userPlayer && currentPlayer.doingGame(dice,20)){
                System.out.println("총점: " + (currentPlayer.totalPoint + currentPlayer.sessionPoint));
                if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }
                System.out.print("게속 던지시겠습니까 (y/n)?");
                String y_or_n = scan.next();
                if(y_or_n.equals("y")){
                    if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }
                    continue;
                }else if(y_or_n.equals("n")){
                    currentPlayer.totalPoint += currentPlayer.sessionPoint;
                    currentPlayer.sessionPoint = 0;
                    if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }
                    currentPlayer = computerPlayer;
//                    break;
                }

            }
            if(currentPlayer.totalPoint >= gameGoalPoint){ printGameResult(); }
        }

    }
    public void throwDice(){
        System.out.println("현 점수:");
        System.out.println("   컴퓨터: " + computerPlayer.totalPoint);
        System.out.println("   사용자: " + userPlayer.totalPoint);


    }

    public void printGameResult(){
        if(currentPlayer == computerPlayer){
            System.out.println("\n축하합니다 컴퓨터가 이겼습니다!");
            System.out.println("최종결과: ");
            System.out.println("   컴퓨터 점수: " + computerPlayer.totalPoint);
            System.out.println("   사용자 점수: " + userPlayer.totalPoint);
        }else{
            System.out.println("\n축하합니다 사용자가 이겼습니다!");
            System.out.println("최종결결과: ");
            System.out.println("   컴퓨터 점수: " + computerPlayer.totalPoint);
            System.out.println("   사용자 점수: " + userPlayer.totalPoint);
        }
        System.exit(0);

    }


}
public class Driver {
    public static void main(String[] args){
        Game game = new Game(50);
        game.processGame();

    }
}
