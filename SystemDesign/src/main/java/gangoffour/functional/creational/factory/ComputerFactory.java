package gangoffour.functional.creational.factory;

@FunctionalInterface
public interface ComputerFactory {

    public enum ComputerModel {
        HOME(HomeComputer::new),
        SERVER(ServerComputer::new);
        private final ComputerFactory constructor;

        ComputerModel(ComputerFactory constructor) {
            this.constructor = constructor;
        }

        public ComputerFactory getConstructor() {
            return constructor;
        }
    }

    Computer createComputer(ComputerSpecs specs);

    static ComputerFactory createFactory(ComputerModel type) {
        return type.getConstructor();
    }

    static ComputerFactory createFactory(String type) {
        if (type == null) {
            return (c) -> null;
            // or throw IllegalArgumentException
        }
        return ComputerModel.valueOf(type.trim().toUpperCase()).getConstructor();
    }
}
