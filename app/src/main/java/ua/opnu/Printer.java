package ua.opnu;

public class Printer {

    public <T> void printArray(final T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
