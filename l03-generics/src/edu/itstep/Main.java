package edu.itstep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person();
//        // Generic - Параметризований клас\метод, Узагальнення
//        List<Integer> ages = new ArrayList<>();
//
//        ages.add(5);
//        ages.add(6);
//
//        for (Object o : ages) {
//            Integer i = (Integer) o;
//            System.out.println(i);
//        }
//        liskov();
//        parametrizedClass();
        wildcards();
    }

    private static void liskov() {
        // S extends T
        // T -> S
        // Number -> Integer
        //List<E> -> ArrayList<E>
        //Collection<E> -> List<E>
//        //Iterable<E> -> Collection<E>
//        Number n = Integer.valueOf(45);
//
//        List<Number> numberList = new ArrayList<>();
//        Collection<Number> numberCollection = numberList;
//        Iterable<Number> numberIterable = numberCollection;
        // Коваріантність -
        // Кішка extends Тварина
        // Set<Cat> -> Set<Animal>

        // Контраваріантність
        // Кішка extends Тварина
        // Set<Animal> -> Set<Cat>

        // Інваріантність
        // Кішка extends Тварина

//        String[] strings = new String[]{"a", "b", "c"};
//
//        Object[] arr = strings;
//
//        arr[0] = 45;
//        List<Integer> ints = Arrays.asList(1, 2, 3);
//        List<Number> nums = ints;
    }

    private static void parametrizedClass() {
        Cell<String> cell = new Cell<>();
        Cell<Integer> cellInteger = new Cell<>();
        cellInteger.setElement(4);

        System.out.println(cellInteger.getElement());
        System.out.println(cell.getElement());
    }

    private static void wildcards() {
//        List<Integer> ints = new ArrayList<>();
//        List<? extends Number> nums = ints;

//        List<Number> nums = new ArrayList<>();
//        List<? super Integer> ints = nums;

        // ? extends ... ? super ... - wildcard
        // upper bound - extends
        // lower bound - super
//
//        List<Number> nums = new ArrayList<>();
//        nums.add(4);
//        nums.add(5);
//
//        List<? super Integer> ints = nums;
//        nums.add(45);
        List<Number> nums = Arrays.asList(4.1f, 0.2f, 12);
        List<Integer> ints = Arrays.asList(1, 2);
        Collections.copy(nums, ints);
        System.out.println(nums);
    }

    public static <T> Object getFirst(List<? super T> list) {
        return list.get(0);
    }

    public static <T> T get(T t) {
        System.out.println(t.toString());
        return t;
    }

    //PECS - Producer Extends Consumer Super
    // extends -> producer - read / no write
    // super -> consumer - write / no read
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
    }

}

class Cell<T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}