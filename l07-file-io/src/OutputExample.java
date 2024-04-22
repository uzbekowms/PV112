import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExample {

    public static void main(String[] args) throws IOException {
//        OutputStream out = new FileOutputStream("test.txt", true);
//        OutputStream out = new FileOutputStream("test.txt");
//        out.write(67);

        byte[] bytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            bytes[i] = (byte) (65 + i);
        }
        OutputStream out = new FileOutputStream("test.txt");
        out.write(bytes);

    }
}
