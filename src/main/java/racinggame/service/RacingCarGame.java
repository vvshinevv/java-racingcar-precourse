package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.MovingCondition;
import racinggame.domain.TryCount;
import racinggame.domain.Winners;
import racinggame.exception.RacingCarGameException;
import racinggame.io.GameDisplay;
import racinggame.util.RandomGenerator;

import java.util.Collections;

import static racinggame.constance.RacingCarGameExceptionMessage.INVALID_NUMBER;
import static racinggame.domain.MovingCondition.MAX_CONDITION_VALUE;
import static racinggame.domain.MovingCondition.MIN_CONDITION_VALUE;

public class RacingCarGame {

    public RandomGenerator<MovingCondition> randomGenerator;

    public RacingCarGame(RandomGenerator<MovingCondition> randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void playRacingCarGame() {
        Cars cars = inputCars();
        TryCount tryCount = inputTryCount();
        GameDisplay.printResultMessage();

        while (!tryCount.isFinish()) {
            tryCount = tryCount.consumeTryCount();
            movingCars(cars);
            GameDisplay.printCarResult(cars);
        }

        Winners winners = cars.electWinners();
        GameDisplay.printWinners(winners);
    }

    private Cars inputCars() {
        Cars result = Cars.of(Collections.emptyList());
        while (result.isCarsEmpty()) {
            result = inputCarsProcessException();
        }
        return result;
    }

    private Cars inputCarsProcessException() {
        try {
            return GameDisplay.inputCars();
        } catch (RacingCarGameException e) {
            GameDisplay.displayError(e.getMessage());
            return Cars.of(Collections.emptyList());
        }
    }

    private TryCount inputTryCount() {
        TryCount result = TryCount.of(null);
        while (result.isEmpty()) {
            result = inputTryCountProcessException();
        }
        return result;
    }

    private TryCount inputTryCountProcessException() {
        try {
            return GameDisplay.inputTryCount();
        } catch (NumberFormatException e) {
            GameDisplay.displayError(INVALID_NUMBER);
            return TryCount.of(null);
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
