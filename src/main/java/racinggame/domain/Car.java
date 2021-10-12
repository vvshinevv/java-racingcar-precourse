package racinggame.domain;

public class Car {

    private final CarPosition carPosition;
    private final CarName carName;

    private Car(CarPosition carPosition, CarName carName) {
        this.carPosition = carPosition;
        this.carName = carName;
    }

    public static Car of(CarPosition carPosition, CarName carName) {
        return new Car(carPosition, carName);
    }
}
