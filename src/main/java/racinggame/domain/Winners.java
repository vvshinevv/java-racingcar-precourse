package racinggame.domain;

import racinggame.constance.RacingCarGameExceptionMessage;
import racinggame.exception.RacingCarGameException;

import java.util.List;

public class Winners {

    private final List<Winner> winners;

    private Winners(List<Winner> winners) {
        this.winners = winners;
    }

    private void validateCarName(String carName) {
        if (carName == null || !isValidLength(carName)) {
            throw new RacingCarGameException(RacingCarGameExceptionMessage.INVALID_CAR_NAME);
        }
    }

    private Boolean isValidLength(String carName) {
        return carName.length() > 0 && carName.length() <= 5;
    }

    public static Winners of(List<Winner> winners) {
        return new Winners(winners);
    }
}
