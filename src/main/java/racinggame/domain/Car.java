package racinggame.domain;

public class Car {

    public static final Integer MOVE_POSITION_VALUE = 1;
    public static final Integer MIN_CONDITION_OF_CAR_MOVING = 0;
    public static final Integer MAX_CONDITION_OF_CAR_MOVING = 3;

    private final CarPosition carPosition;
    private final CarName carName;

    private Car(CarPosition carPosition, CarName carName) {
        this.carPosition = carPosition;
        this.carName = carName;
    }

    public void moveCar() {
        carPosition.addCarPosition(MOVE_POSITION_VALUE);
    }

    public Boolean isCarMoving(MovingCondition condition) {
        return !(condition.biggerThan(MovingCondition.of(MIN_CONDITION_OF_CAR_MOVING)) &&
                condition.smallerThan(MovingCondition.of(MAX_CONDITION_OF_CAR_MOVING)));
    }

    public static Car of(CarPosition carPosition, CarName carName) {
        return new Car(carPosition, carName);
    }
}
