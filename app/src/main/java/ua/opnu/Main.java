package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(final String[] args) {

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: "
                    + ex.getMessage());
        }

        // Завдання 3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // Завдання 6
        // Приклад 1: два елементи різних типів
        GenericTwoTuple<String, Integer> bookData =
                new GenericTwoTuple<>("Clean Code", 2008);
        System.out.println("Двійка: " + bookData);

        // Приклад 2: кортеж з трьома елементами
        GenericThreeTuple<String, Integer, Boolean> productInfo =
                new GenericThreeTuple<>("Laptop", 1200, true);
        System.out.println("Трійка: " + productInfo);
        // Приклад 3: складні типи
        Student student = new Student("Петренко Іван");
        GenericThreeTuple<Student, Double, String> studentInfo =
                new GenericThreeTuple<>(student, 95.5, "Excellent");
        System.out.println("Студент: " + studentInfo);
    }

    // Завдання 4
    public <T> T[] filter(final T[] input, final Predicate<T> predicate) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T element : input) {
            if (predicate.test(element)) {
                result[counter++] = element;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }

    // Завдання 5
    public static <T extends Comparable<T>,
            V extends T> boolean contains(final T[] array, final V element) {

        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }

        return false;
    }
}

