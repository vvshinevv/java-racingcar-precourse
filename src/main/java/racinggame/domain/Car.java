package racinggame.domain;

public class Car {

    public static final Integer MOVE_POSITION_VALUE = 1;

    private final CarPosition carPosition;
    private final CarName carName;

    private Car(CarPosition carPosition, CarName carName) {
        this.carPosition = carPosition;
        this.carName = carName;
    }

    public void moveCar() {
        carPosition.addCarPosition(MOVE_POSITION_VALUE);
    }

    public static Car of(CarPosition carPosition, CarName carName) {
        return new Car(carPosition, carName);
    }
}
