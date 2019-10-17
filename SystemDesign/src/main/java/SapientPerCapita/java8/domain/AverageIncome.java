package SapientPerCapita.java8.domain;

public class AverageIncome {
    private String region;
    private Gender gender;
    private double averageIncome;

    public AverageIncome(String region, Gender gender, double averageIncome) {
        this.region = region;
        this.gender = gender;
        this.averageIncome = averageIncome;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(double averageIncome) {
        this.averageIncome = averageIncome;
    }
}
