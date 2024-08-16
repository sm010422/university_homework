class Television{

    private String brandName;
    private boolean Power = false; // false = off , true = on
    private int channelNumber = 1;
    private int volume = 0;

    public String getBrandName() {
        return brandName;
    }
    public boolean getPower() {
        return Power;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public int getVolume() {
        return volume;
    }
    public void printTelevision(){
        System.out.println("텔레비전 Data");
        System.out.println("  브랜드 이름: " + brandName);
        if(Power){
            System.out.println("  전원: ON");
        }else {
            System.out.println("  전원: OFF");
        }
        System.out.println("  채널 번호: " + channelNumber);
        System.out.println("  볼륨: " +  volume);
        System.out.println();
    }
    public void setBrandName(String b){
        brandName = b;
    }
    public void setPowerON(){
        Power = true;
    }
    public void setPowerOFF(){
        Power = false;
    }
    public void setChannelNumber(int c){
        if(c < 1 || c > 99){
            System.out.println("오류: 새 채널 번호는 유호한 범위 안에 있어야 한다");
        }else if(Power){
            this.channelNumber = c;
        }
    }
    public void setVolume(int v){
        if(v < 0 || v > 12){
            System.out.println("오류: 새 볼륨은 유호한 범위 안에 있어야 한다");
        }else if(Power){
            this.volume = v;
        }
    }

    public void increaseChannelNumber(){
        if(channelNumber > 0 && channelNumber < 100){
            if(channelNumber == 99) {
                channelNumber = 1;
            }else {
                channelNumber++;
            }
        }else{
            System.out.println("오류: 채널 번호는 유호한 범위 안에 있어야 한다");
        }
    }
    public void decreaseChannelNumber(){
        if(channelNumber > 0 && channelNumber < 100){
            if(channelNumber == 1) {
                channelNumber = 99;
            }else {
                channelNumber--;
            }
        }else{
            System.out.println("오류: 채널 번호는 유호한 범위 안에 있어야 한다");
        }
    }

    public void increaseVolume(){
        if(volume > -1 && volume < 12){
            volume++;
        }
    }
    public void decreaseVolume(){
        if(volume > 0 && volume < 13){
            volume--;
        }
    }
}
public class Driver {
    public static void main(String[] args){

        Television television1 = new Television();

        television1.setBrandName("삼성");
        television1.setPowerON();
        television1.setChannelNumber(1);
        television1.setVolume(6);

        television1.printTelevision();
        television1.decreaseChannelNumber();
        television1.increaseVolume();
        television1.printTelevision();

        Television television2 = new Television();

        television2.setBrandName("엘지");
        television2.setPowerON();
        television2.setChannelNumber(98);
        television2.setVolume(12);

        television2.printTelevision();
        television2.increaseChannelNumber();
        television2.increaseVolume();
        television2.printTelevision();


    }

}














