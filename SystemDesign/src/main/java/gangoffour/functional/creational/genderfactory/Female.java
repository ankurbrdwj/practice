package gangoffour.functional.creational.genderfactory;

public class Female implements Person{

    private String name;
    private String gender;

    public Female(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String getType() {
        return this.gender;
    }
}
