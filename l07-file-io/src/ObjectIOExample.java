import java.io.*;

public class ObjectIOExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));
        User user = new User("Petro", 45);

        objectOutputStream.writeObject(user);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.txt"));

        System.out.println(objectInputStream.readObject());
    }
}
