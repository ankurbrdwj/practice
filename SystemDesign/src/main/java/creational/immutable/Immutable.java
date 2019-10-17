package creational.immutable;

import java.util.List;

public class Immutable<T> {
    private final T object;
    private final List<T> objectList;

    public Immutable(T object, List<T> objectList) {
        this.object = object;
        this.objectList = objectList;
    }

}
