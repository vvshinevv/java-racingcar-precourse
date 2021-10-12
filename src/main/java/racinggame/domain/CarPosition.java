package racinggame.domain;

import java.util.Objects;

public class CarPosition {

    private Integer carPosition;

    private CarPosition(Integer carPosition) {
        this.carPosition = carPosition;
    }

    public static CarPosition of(Integer carPosition) {
        return new CarPosition(carPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return Objects.equals(carPosition, that.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition);
    }
}
