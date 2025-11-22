package ua.opnu;

public class GenericThreeTuple<T, V, S> {

    private final GenericTwoTuple<T, V> tuple;
    private final S three;

    public GenericThreeTuple(final T nFirst, final V nSecond, final S nThree) {
        this.tuple = new GenericTwoTuple<>(nFirst, nSecond);
        this.three = nThree;
    }

    public T getFirst() {
        return tuple.first;
    }

    public V getSecond() {
        return tuple.second;
    }

    @Override
    public String toString() {
        return "(" + tuple.first + ", " + tuple.second + ", " + three + ")";
    }
}
