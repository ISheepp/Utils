package annotation;

/**
 * @author linzy
 * @create 2021-01-20 11:51:21
 */
@Report(type = 1)
public class Person implements Comparable<Person> {

    private String name;
    private int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
