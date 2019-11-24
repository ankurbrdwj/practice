package gangoffour.functional.creational.genderfactory;

import static gangoffour.functional.creational.genderfactory.PersonFactory.PersonType.MALE;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println(PersonFactory.createFactory(MALE).create("Robinhood","Male").getType());
    }
}
