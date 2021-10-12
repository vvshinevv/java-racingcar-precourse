package racinggame.util;

public interface RandomGenerator<T> {

    T generate(Integer startInclusive, Integer endInclusive);
}
