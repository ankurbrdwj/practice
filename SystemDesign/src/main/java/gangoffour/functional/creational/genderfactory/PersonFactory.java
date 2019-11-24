package gangoffour.functional.creational.genderfactory;

@FunctionalInterface
public interface PersonFactory {
    enum PersonType {
        MALE(Male::new), FEMALE(Female::new);

        private final PersonFactory constructor;

        PersonType(PersonFactory factory) {
            this.constructor = factory;
        }

        public PersonFactory getConstructor() {
            return this.constructor;
        }
    }

    Person create(String name, String gender);

    static PersonFactory createFactory(PersonType type) {
        return type.getConstructor();
    }
    static PersonFactory createFactory( String type) {
        if( type == null) {
            return (c, t) -> {
                return null;
            };
            // or throw IllegalArgumentException
        }
        return PersonType.valueOf( type.trim().toUpperCase()).getConstructor();
    }
}
