package ua.opnu;

public class Student {
    private final String name;

    public Student(final String nName) {
        this.name = nName;
    }

    @Override
    public String toString() {
        return name;
    }
}
