package racinggame.domain;

import java.util.Objects;

public class MovingCondition {

    public static final Integer MIN_CONDITION_VALUE = 0;
    public static final Integer MAX_CONDITION_VALUE = 9;

    private final Integer condition;

    private MovingCondition(Integer condition) {
        this.condition = condition;
    }

    public static MovingCondition of(Integer condition) {
        return new MovingCondition(condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingCondition that = (MovingCondition) o;
        return Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition);
    }
}
