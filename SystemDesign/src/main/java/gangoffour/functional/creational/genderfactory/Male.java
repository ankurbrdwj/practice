package gangoffour.functional.creational.genderfactory;

public class Male implements Person{

    private String name;
    private String gender;

    public Male(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String getType() {
        return this.gender;
    }
}
