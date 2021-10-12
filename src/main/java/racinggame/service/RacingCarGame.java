package racinggame.service;

import racinggame.domain.Cars;
import racinggame.domain.MovingCondition;
import racinggame.io.GameDisplay;
import racinggame.util.RandomGenerator;

public class RacingCarGame {

    public RandomGenerator<MovingCondition> randomGenerator;

    public RacingCarGame(RandomGenerator<MovingCondition> randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void playRacingCarGame() {
        Cars cars = GameDisplay.inputCars();
    }

}
