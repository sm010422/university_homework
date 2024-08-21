import java.util.Scanner;

abstract class TestQuestion{
    public String testQuestion;
    Scanner scan = new Scanner(System.in);
    abstract void readQuestion();
    abstract void showTest();

}
class Essay extends TestQuestion{
    public int emptyLine; //빈줄의 수
    @Override
    public void readQuestion(){

        emptyLine = scan.nextInt();
        String Nothing = scan.nextLine();
        this.testQuestion = scan.nextLine();

    }
    public void showTest(){
        System.out.println(this.testQuestion);
    }
}
class MultipleChoice extends TestQuestion{

    public String[] choiceQuestion;
    @Override
    public void readQuestion(){

        choiceQuestion = new String[scan.nextInt()];

        String Nothing = scan.nextLine();
        this.testQuestion = scan.nextLine();
        for(int i  = 0; i < choiceQuestion.length; i++){
            choiceQuestion[i] = scan.nextLine();
        }

    }

    public void showTest(){
        System.out.println(this.testQuestion);
        for(int i = 0; i < this.choiceQuestion.length; i++){
            System.out.println("   " + (i+1) + ". " + choiceQuestion[i]);
        }

    }

}


public class Driver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        TestQuestion[] testQuestions;

        int how_many_test = scan.nextInt();
        testQuestions = new TestQuestion[how_many_test];

        for(int i = 0; i < how_many_test; i++){

            String whatType = scan.next();
            if(whatType.equals("e")){
                
                testQuestions[i] = new Essay();
                testQuestions[i].readQuestion();
            }else if(whatType.equals("m")){

                testQuestions[i] = new MultipleChoice();
                testQuestions[i].readQuestion();
            }
        }

        for(int i = 0; i < how_many_test; i++){
            System.out.print(i+1 + ". ");
            testQuestions[i].showTest();
        }



    }
}