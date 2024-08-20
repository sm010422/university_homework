
class BasicPayCalculator{
    public double pay;
    public int basicPay; //평일 시간당 임금
    public int weekdayWorkTIme; //평일 근무시간

    public BasicPayCalculator(int basicPay){
        this.basicPay = basicPay;
        this.weekdayWorkTIme = 0;
    }
    public void setBasicPay(int basicPay){
        this.basicPay = basicPay;
    }
    public void setWeekdayWorkTIme(int weekdayWorkTIme){
        this.weekdayWorkTIme = weekdayWorkTIme;
    }

    public void addExtraWorkTime(int extraTime){
        this.weekdayWorkTIme += extraTime;
    }

    public double calculatePay(){
        this.pay = 0;
        return this.pay;
    }
}

class OverPayCalculator extends BasicPayCalculator{
    public int satWorkTime;
    public int sunWorkTime;
    public OverPayCalculator(int basicPay){
        super(basicPay);
        this.weekdayWorkTIme = 0;
        this.satWorkTime = 0;
        this.sunWorkTime = 0;
    }
    public void setSatWorkTime(int satWorkTime){
        this.satWorkTime = satWorkTime;
    }
    public void setSunWorkTime(int sunWorkTime){
        this.sunWorkTime = sunWorkTime;
    }

    @Override
    public double calculatePay(){
        if(weekdayWorkTIme > 40){
            this.pay = (40 * basicPay) + ((weekdayWorkTIme - 40) * basicPay * 1.5);
        }else {
            this.pay = basicPay * weekdayWorkTIme;
        }
        this.pay += satWorkTime * basicPay * 2;
        this.pay += sunWorkTime * basicPay * 3;

        return this.pay;

    }

}

class DangerPayCalculator extends BasicPayCalculator{
    public int dangerWorkTime;
    public DangerPayCalculator(int basicPay){
        super(basicPay);
        this.weekdayWorkTIme = 0;
        this.dangerWorkTime = 0;

    }
    public void setDangerWorkTime(int dangerWorkTime){
        this.dangerWorkTime = dangerWorkTime;
    }

    @Override
    public double calculatePay(){
        if(weekdayWorkTIme > 40){
            this.pay = (40 * basicPay) + ((weekdayWorkTIme - 40) * basicPay * 1.5);
        }else {
            this.pay = basicPay * weekdayWorkTIme;
        }
        this.pay += dangerWorkTime * basicPay * 5;

        return this.pay;

    }

}
public class Driver{
    public static void main(String[] args){
        OverPayCalculator over = new OverPayCalculator(8000);
        over.setWeekdayWorkTIme(50);
        over.setSatWorkTime(6);
        over.setSunWorkTime(2);
        System.out.println("주말 근무 직원의 주급: " + over.calculatePay());

        DangerPayCalculator danger = new DangerPayCalculator(10000);
        danger.setWeekdayWorkTIme(36);
        danger.setDangerWorkTime(6);
        System.out.println("위험 근무 직원의 주급: " + danger.calculatePay());

    }

}