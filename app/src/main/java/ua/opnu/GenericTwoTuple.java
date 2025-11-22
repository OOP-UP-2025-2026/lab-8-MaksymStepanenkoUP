package ua.opnu;

public class GenericTwoTuple<T, V> {

    public final T first;
    public final V second;

    public GenericTwoTuple(final T nFirst, final V nSecond) {
        this.first = nFirst;
        this.second = nSecond;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
