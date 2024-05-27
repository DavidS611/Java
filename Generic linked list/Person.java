// David Shifraw ID:205713274
public class Person implements Comparable<Person> {
    private String name;
    private int ID;
    private int yearBirth;

    public Person(String name, int ID, int yearBirth) {
        this.name = name;
        this.ID = ID;
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public int getYearBirth() {
        return this.yearBirth;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Invert the comparison to make older people "larger"
        return Integer.compare(otherPerson.getYearBirth(), this.getYearBirth());
    }

    @Override
    public String toString() {
        return "(Person:" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", yearBirth=" + yearBirth +
                ')';
    }

    // Static method to find the oldest person in a LinkedList of people
    public static Person max(LinkedList<Person> people) throws EmptyListException {
        if (people == null || people.isEmpty()) {
            throw new EmptyListException("The list is empty");
        }

        Node<Person> current = people.getFirst();
        Person oldestPerson = current.getData();

        while (current != null) {
            if (current.getData().compareTo(oldestPerson) > 0) {
                oldestPerson = current.getData();
            }
            current = current.getNext();
        }
        return oldestPerson;
    }
}

