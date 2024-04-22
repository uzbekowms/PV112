import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputExample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("test.txt");
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        System.out.println((char) inputStream.read());
//        byte[] arr = new byte[50];
//
//        int readedBytes = inputStream.read(arr, 5, 5);
//
//        if (arr.length != readedBytes) {
//            System.out.println("Not equal");
//        }
//
//        for (byte item : arr) {
//            System.out.println(item);
//        }

//        byte[] arr = new byte[50];
//        inputStream.skip(5);
//        int readedBytes = inputStream.read(arr);
//
//        for (byte item : arr) {
//            System.out.println((char) item);
//        }

        byte[] arr = new byte[inputStream.available()];

        int readedBytes = inputStream.read(arr);
        System.out.println(readedBytes);

        for (byte item : arr) {
            System.out.println(item);
        }

        inputStream.close();
    }
}
