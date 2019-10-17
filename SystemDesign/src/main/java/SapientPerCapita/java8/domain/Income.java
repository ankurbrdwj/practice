package SapientPerCapita.java8.domain;

public class Income {
    private String city;
    private String country;
    private String currency;
    private Gender gender;
    private double averageIncome;

    public Income(String city, String country, String currency, Gender gender, double averageIncome) {
        this.city = city;
        this.country = country;
        this.currency = currency;
        this.gender = gender;
        this.averageIncome = averageIncome;
    }

    public Income() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    @Override
    public String toString() {
        return "Income{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", gender=" + gender +
                ", averageIncome=" + averageIncome +
                '}';
    }


}
