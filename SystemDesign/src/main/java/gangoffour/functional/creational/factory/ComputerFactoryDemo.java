package gangoffour.functional.creational.factory;

import static gangoffour.functional.creational.factory.ComputerFactory.ComputerModel.HOME;
import static gangoffour.functional.creational.factory.ComputerFactory.ComputerModel.SERVER;

public class ComputerFactoryDemo {
    private static ComputerFactory ComputerFactory;

    public ComputerFactoryDemo(ComputerFactory ComputerFactory) {
        this.ComputerFactory = ComputerFactory;
    }

    public static void main(String[] args) {
        // first: static factory method example
        ComputerSpecs specs =new ComputerSpecs();
        gangoffour.functional.creational.factory.ComputerFactory.createFactory(HOME).createComputer(specs);

        // second: inject factory into application and use later on
        ComputerFactory factory = gangoffour.functional.creational.factory.ComputerFactory.createFactory(SERVER);

        ComputerFactoryDemo demoApp = new ComputerFactoryDemo(factory);
        demoApp.createComputer(specs);
    }

    private void createComputer(ComputerSpecs specs) {
        ComputerFactory.createComputer(specs);
    }

}

