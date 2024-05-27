import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> terms;

    public Dictionary() {
        terms = new TreeMap<>();
    }

    // Adding a term with a definition to the dictionary
    public void addTerm(String term, String definition) {
    	if (term.length() == 0 || definition.length() == 0) {
            System.out.println("ERROR:Term/Definition cannot be empty.");
            return;
        }
        if (terms.containsKey(term)) {
            System.out.println("ERROR:Term already exists.");
        } else {
            terms.put(term, definition);
            System.out.println("Term added successfully.");
        }
    }

    // Updating a definition to an existing term
    public void updateTerm(String term, String definition) {
    	if (definition.length() == 0) {
            System.out.println("ERROR:Definition cannot be empty.");
            return;
        }
        if (terms.containsKey(term)) {
            terms.put(term, definition);
            System.out.println("Term updated successfully.");
        } else {
            System.out.println("ERROR:Term not found.");
        }
    }

    // Deleting a term from the dictionary 
    public void deleteTerm(String term) {
        if (terms.containsKey(term)) {
            terms.remove(term);
            System.out.println("Term deleted successfully.");
        } else {
            System.out.println("ERROR:Term not found.");
        }
    }

    // Searching for an existing term in the dictionary
    public String searchTerm(String term) {
        return terms.getOrDefault(term, "Term not found.");
    }

    // Display all terms in the dictionary in an alphabetic order
    public void displayAllTerms() {
        if (terms.isEmpty()) {
            System.out.println("No terms in the dictionary.");
        } else {
            for (Map.Entry<String, String> entry : terms.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nEnter a command (add, update, delete, search, display, exit, help):");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.println("Enter term:");
                    String addTerm = scanner.nextLine();
                    System.out.println("Enter definition:");
                    String addDefinition = scanner.nextLine();
                    dictionary.addTerm(addTerm, addDefinition);
                    break;
                case "update":
                    System.out.println("Enter term to update:");
                    String updateTerm = scanner.nextLine();
                    System.out.println("Enter new definition:");
                    String updateDefinition = scanner.nextLine();
                    dictionary.updateTerm(updateTerm, updateDefinition);
                    break;
                case "delete":
                    System.out.println("Enter term to delete:");
                    String deleteTerm = scanner.nextLine();
                    dictionary.deleteTerm(deleteTerm);
                    break;
                case "search":
                    System.out.println("Enter term to search:");
                    String searchTerm = scanner.nextLine();
                    System.out.println(dictionary.searchTerm(searchTerm));
                    break;
                case "display":
                    dictionary.displayAllTerms();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                case "help":
                	System.out.println("add - adds a term to the dictionary.");
                	System.out.println("update - updates an existing term in the dictionary.");
                	System.out.println("delete - deletes a term from the dictionary.");
                	System.out.println("search - searchs for a term in the dictionary.");
                	System.out.println("display - displays all the dictionary's terms.");
                	System.out.println("exit - exits the dictionary.");
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}

