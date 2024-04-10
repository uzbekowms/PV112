public class Person {
    private Heart heart;

    public Person(Heart heart) {
        this.heart = heart;
        heart.bipbip();
    }

    public void bipbip() {
        heart.bipbip();
    }
}


class Heart {


    public void bipbip() {
        System.out.println("Bip");
    }
}