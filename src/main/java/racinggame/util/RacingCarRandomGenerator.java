package racinggame.util;


import nextstep.utils.Randoms;
import racinggame.domain.MovingCondition;

public class RacingCarRandomGenerator implements RandomGenerator<MovingCondition> {

    @Override
    public MovingCondition generate(Integer startInclusive, Integer endInclusive) {
        return MovingCondition.of(Randoms.pickNumberInRange(startInclusive, endInclusive));
    }
}
