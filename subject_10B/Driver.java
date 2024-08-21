
abstract class SavingMoney{ //예적금
    public String name; // 예금주 이름
    public int bankCount; // 계좌번호
    public int contractPeriod; // 게약기간
    public double annualRate; // 연이율
    public int returnMoney;
    public SavingMoney(String name, int bankCount, int contractPeriod, double annualRate){
        this.name = name;
        this.bankCount = bankCount;
        this.contractPeriod = contractPeriod;
        this.annualRate = annualRate;
        System.out.println("예금주 이름: " + name);
        System.out.println("계좌번호: " + bankCount);
        System.out.println("계약기간: " + contractPeriod);
        System.out.println("연이율: " + annualRate);
    }

    abstract String calculateMoney();

}
class RegularSavingMoney extends SavingMoney{ // 정기적금
    public int monthMoney; // 월불입액
    public RegularSavingMoney(String name, int bankCount, int contractPeriod, double annualRate, int monthMoney){
        super(name, bankCount, contractPeriod, annualRate);
        this.monthMoney = monthMoney;
        System.out.println("월불입액: " + monthMoney);
    }
    public String calculateMoney(){
        returnMoney = (int)((monthMoney * contractPeriod) + (monthMoney * (annualRate/12) * ((contractPeriod * (contractPeriod + 1))/2) ));
        return "원리금: " + returnMoney;
    }
}
abstract class TimeDeposit extends SavingMoney{ // 정기예금
    public int principal; // 원금
    public TimeDeposit(String name, int bankCount, int contractPeriod, double annualRate, int principal){
        super(name, bankCount, contractPeriod, annualRate);
        this.principal= principal;
        System.out.println("원금: " + principal);
    }

}
class SimpleTimeDeposit extends TimeDeposit{ // 단리 정기예금

    public SimpleTimeDeposit(String name, int bankCount, int contractPeriod, double annualRate, int principal){
        super(name, bankCount, contractPeriod, annualRate, principal);
    }
    public String calculateMoney(){
        returnMoney = (int)(principal * (1 + (annualRate/12)*contractPeriod));
        return "원리금: " + returnMoney;
    }
}
class CompoundTimeDeposit extends TimeDeposit{ // 복리 정기예금
    public CompoundTimeDeposit(String name, int bankCount, int contractPeriod, double annualRate, int principal){
        super(name, bankCount, contractPeriod, annualRate, principal);

    }
    public String calculateMoney(){
        returnMoney = (int)(principal * Math.pow((1 + (annualRate/12)), contractPeriod));
        return "원리금: " + returnMoney;
    }
}

public class Driver{
    public static void main(String[] args){
        System.out.println("정기예금(단리)");
        SimpleTimeDeposit simpleTimeDeposit = new SimpleTimeDeposit("선남",100,12,0.05,10000000);
        System.out.println(simpleTimeDeposit.calculateMoney());

        System.out.println("\n정기예금(복리)");
        CompoundTimeDeposit compoundTimeDeposit = new CompoundTimeDeposit("선녀",200,12,0.05,10000000);
        System.out.println(compoundTimeDeposit.calculateMoney());

        System.out.println("\n정기적금");
        RegularSavingMoney regularSavingMoney = new RegularSavingMoney("길동",300,12,0.05,100000);
        System.out.println(regularSavingMoney.calculateMoney());

    }
}