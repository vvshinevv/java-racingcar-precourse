package racinggame;

import racinggame.domain.MovingCondition;
import racinggame.service.RacingCarGame;
import racinggame.util.RacingCarRandomGenerator;
import racinggame.util.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        RandomGenerator<MovingCondition> randomGenerator = new RacingCarRandomGenerator();
        RacingCarGame racingCarGame = new RacingCarGame(randomGenerator);

        racingCarGame.playRacingCarGame();
    }
}
