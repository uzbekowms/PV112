import java.util.Objects;

public class Aspirant extends Student {
    private String workName;


    public Aspirant(String name, int age) {
        super(name, age);
        this.workName = "Test";
    }

    public static void greetings() {
        System.out.println("Greetings");
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public void relax(String relaxType) {
        System.out.println("Relaxing... " + relaxType);
    }

    public void relax(){
        relax("Youtube");
    }

    @Override
    public void test() {
        System.out.println("Aspirant");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aspirant aspirant = (Aspirant) o;
        return Objects.equals(workName, aspirant.workName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workName);
    }
}
