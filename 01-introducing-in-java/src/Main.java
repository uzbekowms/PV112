import java.util.Scanner;

public class Main {

    /**
     *
     */

    final int a;

    public Main() {
        a = 4;
        int a = 1, b = 2, c = 3;
    }

    /*
     *
     *
     *
     *
     * */
    public static void main(String[] args) {
//        if (54 > 4) System.out.println("Hello");
//        else if (4 < 5) System.out.println("2");
//        else {
//            System.out.println("End");
//        }
////Ctrl + Alt + L - format
//        for (int i = 0; i < 10; i++) {
//
//        }
//
//        List<String> students = new ArrayList<>();
//
//        for (String student : students) {
//
//        }
//
//        while (true) {
//
//        }
//        System.out.println(0.2 + 0.1);
        //char - 1 symbol - 2
//        short i = 3;
//        int j = i;
//        long n = 5;
//
//        byte a = 37;
//        short b = 12;
//        char c = 'a';
//        int sum = c + b + a;
//        System.out.println(sum);
//        System.out.println((int) 'A');
//        System.out.println("Hello " + 4);
//      Output Type   | Types that can cast   | loss of accuracy
//      byte          | short, int, long      | no
//      short         | int, long             | no
//      int           | long                  | no
//      int           | float, double         | yes
//      char          | int                   | no
//      long          | float, double         | yes
//      float         | double                | no
//        int bigNumber = 123456789;
//        float f = bigNumber;
//        System.out.println(f);

//        int i = (int) 7L;
//        float m = (float) 2.5;
//        int j = 15;
//        byte b = (byte) j;
//
//        byte b = 55;
//        b = b * 2;
//        byte bMax = 127;
//
//        bMax++;
//
//        System.out.println(bMax);
//
//
//        short maxValue = 150;
//        byte b = (byte) maxValue;
//        System.out.println(b);
//        double d1 = 0.3333333333333;
//        float f1 = (float) d1;
//        System.out.println(f1);
//        float f1 = 3.64f;
//
//        int i1 = (int) f1;
//        System.out.println(i1);
//        Integer sum = Integer.valueOf(5) + Integer.valueOf(7);
//        int sumI = 5 + 7;
//        System.out.println(sum);

//        int i = Integer.parseInt("4");
//        Integer i1 = 5;
//

//        System.out.println("test" == "test");
//
//        String str1 = new String("test");
//        String str2 = new String("test");
//
//        System.out.println(str1.equals(str2));
//        String str3 = "test";
//        String str4 = "test";
//
//        System.out.println(str3.equals(str4));
//        test(4);
//        Integer i1 = null;
//        int i = i1;
//
//
//        Number n = 555;
//        byte b = (Byte) n;


//        System.out.println("""
//                    <html>
//                    head
//                    body
//                        h1
//                """);

//        int a = 5;
//        int b = 5;
//        System.out.println(a++);
//        System.out.println(++b);

        System.out.println(+4);
        System.out.println(4 + 4);

//        int a;
//        int b;
//        int c;
//        a = b = c = 4;
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//
//        int[] arr = new int[4];
//
//        int r = switch (a) {
//            case 1 -> 3;
//            default -> 2;
//        };
//        outer:
//        while (true) {
//            inner:
//            while (true) {
////                continue inner;
////                break outer;
//            }
//        }

//        try (InputStream stream = new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        }) {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("end");
//        }

        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        fifthTask();
    }

    public static void fifthTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите номер месяца:");
        int month = scanner.nextInt();

        switch (month) {
            case 1, 2, 12:
                System.out.println("Winter");
                break;
            case 3, 4, 5:
                System.out.println("Spring");
                break;
            case 6, 7, 8:
                System.out.println("Summer");
                break;
            case 9, 10, 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Вы ввели недопустимое значение! Попробуйте снова.");
        }
    }

    public static void task1(){
        
    }

    public static void f() {
        f();
    }

    public static void test(Integer i) {
        System.out.println(i);
    }

}