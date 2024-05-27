// David Shifraw ID:205713274
public class Main {
    public static void main(String[] args) {
        // LinkedList section
        try {
            LinkedList<String> ll = new LinkedList<>();

            ll.add("Avraham");
            ll.add("Itzhak");
            ll.add("Yaakov");
            ll.add("Moshe");
            ll.add("Aharon");
            ll.add("David");

            System.out.println("Original list:");
            System.out.println(ll);

            // Create a new reversed list
            LinkedList<String> reversedList = ll.reverse();

            System.out.println("Reversed list:");
            System.out.println(reversedList);

            // Find and print the maximum element in the list
            String maxElement = ll.max();
            System.out.println("Maximum element in the list: \n" + maxElement);
        } catch (EmptyListException e) {
            e.printStackTrace();
        }

        // Person section
        try {
            LinkedList<Person> people = new LinkedList<>();

            // Adding people to the list
            people.add(new Person("Avraham", 1, 1948));
            people.add(new Person("Itzhak", 2, 2048));
            people.add(new Person("Yaakov", 3, 2108));
            people.add(new Person("Moshe", 4, 2368));

            System.out.println("List of people:");
            System.out.println(people);

            // Find and print the oldest person in the list
            Person oldestPerson = Person.max(people);
            System.out.println("The oldest person in the list is: \n" + oldestPerson);
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
}

