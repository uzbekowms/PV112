import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

interface Moveable {
    int right = 4;

    default void right() {
        System.out.println("Right");
    }
}

class SuperBall extends Ball implements Serializable {

}

class Ball implements Moveable {
}

// 47000

public class Main {
    // Ctrl + P - Show arguments
    public static void main(String[] args) {
//        Calculator.add(4, 4);
//        Calculator.add(4.5f, 4.5f);
//        Calculator.add(5, 4.5f);
//        Calculator.add(5.5, 4.5f);

//        Aspirant aspirant = new Aspirant("", 0);

//        sum(4, 5, 6, 47, 8, 6);
//
//        int[] arr = {1, 2, 34};
        final Student student = new Student("name", 45);
        System.out.println(student);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
//        nums.add(3.14); // compile-time error
        Test<String> test = new Test<>();

        System.out.println(test);
    }

    static List<String> t() {
        List l = new ArrayList<Number>();
        l.add(1);
        List<String> ls = l; // (1)
        ls.add("");
        return ls;
    }
    private void task1(){

    }

//    public final int sum(int a, int... numbers) {
//        int sum = 0;
//        for (int number : numbers) {
//            sum += number;
//        }
//        return sum;
//    }
}
//
//class Person{
//
//    private String fullName;
//
//    private String phone;
//
//    public Person() {
//    }
//
//    public Person(String fullName, String phone) {
//        this.fullName = fullName;
//        this.phone = phone;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//}

class Test<T>{
    private T test;

    public T getTest() {
        return test;
    }
}