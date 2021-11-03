import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Bill Gates", 66, true));
        people.add(new Person("Mark Zuckerberg", 37, false));
        people.add(new Person("Sundar Pichai", 49, true));

        System.out.println(people);
    }
}
