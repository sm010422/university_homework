import java.util.Scanner;

class Country {
    private String countryName;
    private int population;
    private float populationRate;

    public void inputCountryData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("국가 데이터를 입력하세요.");
        System.out.print("국가명: ");
        countryName = scanner.nextLine();

        do {
            System.out.print("인구수: ");
            population = scanner.nextInt();
            if (population < 0)
                System.out.println("인구수가 음수이다.");
        } while (population < 0);

        System.out.print("연간 인구 증감율(%): ");
        populationRate = scanner.nextFloat();
//        scanner.nextLine();
    }

    public String getCountryName() {
        return countryName;
    }

    public int getPopulation() {
        return population;
    }

    public float getPopulationRate() {
        return populationRate;
    }

    public void printCountryData() {
        System.out.println("국가 데이터:");
        System.out.println("  국가명 = " + countryName);
        System.out.println("  인구수 = " + population);
        System.out.println("  연간 인구 증감율 = " + populationRate + "%");
    }

    public void setCountryData(String countryName, int population, float populationRate) {
        if (population < 0) {
            System.out.println("오류: 인구수가 음수이다.");
            System.exit(1);
        }
        this.countryName = countryName;
        this.population = population;
        this.populationRate = populationRate;
    }

    public int calculatePopulationAfterYears(int years) {
        float growthRate = populationRate / 100;
        double futurePopulation = population;
        for (int i = 0; i < years; i++) {
            futurePopulation = futurePopulation + futurePopulation*growthRate;
        }
        return (int)futurePopulation;
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Country country = new Country();

        System.out.print("인구를 예측할 연수를 입력하세요: ");
        int years = scanner.nextInt();
        scanner.nextLine(); 

        country.inputCountryData();

        System.out.println();
        country.printCountryData();

        System.out.println();
        System.out.println(country.getCountryName() + "의 " + years + "년후 인구: " + country.calculatePopulationAfterYears(years));

        country.setCountryData("미국", 330000000, (float)0.35);


        System.out.println();
        country.printCountryData();

        System.out.println();
        System.out.println(country.getCountryName() + "의 " + years + "년후 인구: " + country.calculatePopulationAfterYears(years));
    }
}
