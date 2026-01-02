import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Trainer> trainers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initial test data
        members.add(new Member("Ansar", 20, 75.5, true));
        members.add(new Member("Angsar", 22, 80, false));

        trainers.add(new Trainer("Alex", 5, "Fitness"));
        trainers.add(new Trainer("John", 8, "CrossFit"));

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addMember();
                case 2 -> viewMembers();
                case 3 -> addTrainer();
                case 4 -> viewTrainers();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== GYM MENU =====");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    static void addMember() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Weight: ");
            double weight = scanner.nextDouble();

            System.out.print("Has membership (true/false): ");
            boolean membership = scanner.nextBoolean();

            members.add(new Member(name, age, weight, membership));
            System.out.println("Member added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    static void viewMembers() {
        System.out.println("\n--- MEMBERS LIST ---");
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        members.forEach(System.out::println);
    }

    static void addTrainer() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Experience years: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            trainers.add(new Trainer(name, exp, spec));
            System.out.println("Trainer added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    static void viewTrainers() {
        System.out.println("\n--- TRAINERS LIST ---");
        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        trainers.forEach(System.out::println);
    }
}





