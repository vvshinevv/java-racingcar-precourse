package racinggame.domain;

import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
