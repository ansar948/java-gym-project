import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Person> people = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Test data
        people.add(new Member("Ansar", 20, 75.5, true));
        people.add(new Trainer("Alex", 30, 5, "Fitness"));

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addMember();
                case 2 -> addTrainer();
                case 3 -> viewPeople();
                case 4 -> trainMember();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== GYM MENU =====");
        System.out.println("1. Add Member");
        System.out.println("2. Add Trainer");
        System.out.println("3. View All People");
        System.out.println("4. Conduct Training");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    static void addMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Age: ");
            age = scanner.nextInt();
            if (age <= 0) System.out.println("Age must be positive!");
        } while (age <= 0);

        double weight;
        do {
            System.out.print("Weight: ");
            weight = scanner.nextDouble();
            if (weight <= 0) System.out.println("Weight must be positive!");
        } while (weight <= 0);

        boolean membership;
        while (true) {
            System.out.print("Has membership (true/false): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("true")) {
                membership = true;
                break;
            } else if (input.equalsIgnoreCase("false")) {
                membership = false;
                break;
            } else {
                System.out.println("Please enter true or false!");
            }
        }
        scanner.nextLine(); // consume newline

        people.add(new Member(name, age, weight, membership));
        System.out.println("Member added successfully!");
    }

    static void addTrainer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Age: ");
            age = scanner.nextInt();
            if (age <= 0) System.out.println("Age must be positive!");
        } while (age <= 0);

        int exp;
        do {
            System.out.print("Experience years: ");
            exp = scanner.nextInt();
            if (exp < 0) System.out.println("Experience must be >= 0!");
        } while (exp < 0);
        scanner.nextLine(); // consume newline

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        people.add(new Trainer(name, age, exp, spec));
        System.out.println("Trainer added successfully!");
    }

    static void viewPeople() {
        System.out.println("\n--- PEOPLE LIST ---");
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }
        for (Person p : people) {
            System.out.println(p);
        }
    }

    static void trainMember() {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Trainer> trainers = new ArrayList<>();

        for (Person p : people) {
            if (p instanceof Member m) members.add(m);
            if (p instanceof Trainer t) trainers.add(t);
        }

        if (members.isEmpty()) {
            System.out.println("No members to train!");
            return;
        }
        if (trainers.isEmpty()) {
            System.out.println("No trainers available!");
            return;
        }

        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i).getName());
        }
        System.out.print("Choose member: ");
        int mChoice = scanner.nextInt() - 1;

        System.out.println("Trainers:");
        for (int i = 0; i < trainers.size(); i++) {
            System.out.println((i + 1) + ". " + trainers.get(i).getName());
        }
        System.out.print("Choose trainer: ");
        int tChoice = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        trainers.get(tChoice).conductTraining(members.get(mChoice));
        members.get(mChoice).train();
    }
}
