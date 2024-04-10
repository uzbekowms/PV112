package edu.itstep;

import java.io.Serializable;
import java.util.*;

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
//        wildcards();
//        System.out.println(heapPollution());
//        System.out.println(List.of("1", ""));
//        heapPollution2(List.of("1", "2", "3"), List.of("4", "5"));
        //Type Inference
//        java.util.List<Integer> list = new ArrayList<>();


        List<String> ls = List.nil();
        List<Integer> cons = List.cons(42, List.nil());

//        String s = List.nil().head();

        String s = List.<String>nil().head();

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
        java.util.List<Number> nums = Arrays.asList(4.1f, 0.2f, 12);
        java.util.List<Integer> ints = Arrays.asList(1, 2);
        Collections.copy(nums, ints);
        System.out.println(nums);

        printCollection(nums);
    }

    public static <T extends Number & Serializable & Comparable<T> & Cloneable> Object getFirst(java.util.List<? super T> list) {
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

    private static void printCollection(Collection<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    private static void rawParameters() {
        ArrayList<String> strings = new ArrayList<>();

        ArrayList arrayList = new ArrayList();
        arrayList = strings;
        strings = arrayList;
        arrayList.add(1);
    }

    public static <T> void rev(java.util.List<T> list) {
        java.util.List<T> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    public static void reverse(java.util.List<?> list) {
        rev(list);
    }

    public static <T extends Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T element : coll) {
            if (candidate.compareTo(element) < 0) candidate = element;
        }
        return candidate;
    }
    //Type Erasure
    // T -> |T|
    // List<Integer>, List<String>, List<List<String>> -> List
    // List -> List
    // List<Integer>[] -> List[]
    // int -> int
    // Integer -> Integer
    // <T extends Comparable<T>> -> Comparable
    // <T extends Number & Serializable & Comparable<T> & Cloneable> -> Number


    // refiable types
    // int long boolean
    // String Integer
    // List<?> Collection<?>
    // List ArrayList
    // int[] Number[] List<?>[]

    // non refiable types
    // T
    // List<Number> ArrayList<String> List<List<String>>
    // List<? extends Number> List<? super Integer>
    // List<? extends Object> - not refiable List<?> - refiable

    //Heap Pollution


    private static java.util.List<String> heapPollution() {
        java.util.List l = new ArrayList<Number>();

        l.add(1);
        java.util.List<String> ls = l;
        ls.add("");
        return ls;
    }

    private static void heapPollution2(java.util.List<String>... stringList) {
        Object[] array = stringList;
        java.util.List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList;
        String s = stringList[0].get(0);
    }
}

class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return 0;
        // -1 - o > this
        // 1 - o < this
        // 0 - o == this
        // o - 170
        // this - 180
        // 180 - 170 = 10
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

class List<E> {
    static <Z> List<Z> nil() { return null; };
    static <Z> List<Z> cons(Z head, List<Z> tail) { return null; };
    E head() { return null; }
}