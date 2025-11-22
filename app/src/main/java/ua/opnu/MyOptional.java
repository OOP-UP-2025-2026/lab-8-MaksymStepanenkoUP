package ua.opnu;

public class MyOptional<T> {

    private final T value;
    private final boolean present;


    public MyOptional() {
        this.present = false;
        this.value = null;
    }

    // Конструктор зі значенням
    public MyOptional(final T nValue) {
        if (nValue == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = nValue;
        this.present = true;
    }

    // Повертає true якщо значення є
    public boolean isPresent() {
        return present;
    }

    // Повертає true якщо значення немає
    public boolean isEmpty() {
        return !present;
    }

    // Повертає значення або кидає IllegalStateException
    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    // Якщо значення є -> повертає його, якщо ні -> defaultValue
    public T orElse(final T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
