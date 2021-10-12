package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.MovingCondition;
import racinggame.domain.TryCount;
import racinggame.io.GameDisplay;
import racinggame.util.RandomGenerator;

import static racinggame.domain.MovingCondition.MAX_CONDITION_VALUE;
import static racinggame.domain.MovingCondition.MIN_CONDITION_VALUE;

public class RacingCarGame {

    public RandomGenerator<MovingCondition> randomGenerator;

    public RacingCarGame(RandomGenerator<MovingCondition> randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void playRacingCarGame() {
        Cars cars = GameDisplay.inputCars();
        TryCount tryCount = GameDisplay.inputTryCount();
        GameDisplay.printResultMessage();

        while (!tryCount.isFinish()) {
            tryCount = tryCount.consumeTryCount();
            movingCars(cars);
            GameDisplay.printCarResult(cars);
        }
    }

    private void movingCars(Cars cars) {
        for (Car car : cars) {
            MovingCondition movingCondition = randomGenerator.generate(MIN_CONDITION_VALUE, MAX_CONDITION_VALUE);
            checkMovingCar(car, movingCondition);
        }
    }

    private void checkMovingCar(Car car, MovingCondition condition) {
        if (car.isCarMoving(condition)) {
            car.moveCar();
        }
    }
}
