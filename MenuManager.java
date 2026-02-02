package menu;

import db.MemberDAO;
import model.Member;
import model.Trainer;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final MemberDAO memberDAO = new MemberDAO();

    @Override
    public void showMenu() {
        System.out.println("\n===== GYM MENU =====");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Update Member");
        System.out.println("4. Delete Member");
        System.out.println("5. Search Member by Name");
        System.out.println("6. Search Member by Weight Range");
        System.out.println("7. Search Member by Min Weight");
        System.out.println("8. Conduct Training");
        System.out.println("9. Add Trainer");
        System.out.println("10. View All Trainers");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1 -> addMember();
            case 2 -> viewAllMembers();
            case 3 -> updateMember();
            case 4 -> deleteMember();
            case 5 -> searchMemberByName();
            case 6 -> searchMemberByWeightRange();
            case 7 -> searchMemberByMinWeight();
            case 8 -> conductTraining();
            case 9 -> addTrainer();
            case 10 -> viewAllTrainers();
            case 0 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid option!");
        }
    }

    @Override
    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);
        }
    }



    private void addMember() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            if (age < 0 || age > 100) System.out.println("Invalid age!");
        } while (age < 0 || age > 100);

        double weight;
        do {
            System.out.print("Weight: ");
            weight = scanner.nextDouble();
            scanner.nextLine();
            if (weight <= 0) System.out.println("Weight must be positive!");
        } while (weight <= 0);

        scanner.nextLine(); // clear buffer

        boolean membership;
        while (true) {
            System.out.print("Membership (yes/no): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                membership = true;
                break;
            } else if (input.equalsIgnoreCase("no")) {
                membership = false;
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }

        Member member = new Member(name, age, weight, membership);
        memberDAO.insert(member);
        System.out.println("Member added to database!");
    }

    private void viewAllMembers() {
        List<Member> members = memberDAO.findAll();
        if (members.isEmpty()) System.out.println("No members found.");
        else members.forEach(System.out::println);
    }

    private void updateMember() {
        viewAllMembers();
        System.out.print("Enter member ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Age: ");
        int age = scanner.nextInt();

        System.out.print("New Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Membership (yes/no): ");
        boolean membership = scanner.nextLine().equalsIgnoreCase("yes");

        boolean success = memberDAO.updateMember(id, name, age, weight, membership);
        System.out.println(success ? "Member updated!" : "Update failed!");
    }

    private void deleteMember() {
        viewAllMembers();
        System.out.print("Enter member ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            boolean success = memberDAO.deleteMember(id);
            System.out.println(success ? "Member deleted!" : "Delete failed!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void searchMemberByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Member> results = memberDAO.searchByName(name);
        if (results.isEmpty()) System.out.println("No members found.");
        else results.forEach(System.out::println);
    }

    private void searchMemberByWeightRange() {
        System.out.print("Enter min weight: ");
        double min = scanner.nextDouble();
        System.out.print("Enter max weight: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Member> results = memberDAO.searchByWeightRange(min, max);
        if (results.isEmpty()) System.out.println("No members found.");
        else results.forEach(System.out::println);
    }

    private void searchMemberByMinWeight() {
        System.out.print("Enter min weight: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        List<Member> results = memberDAO.searchByMinWeight(min);
        if (results.isEmpty()) System.out.println("No members found.");
        else results.forEach(System.out::println);
    }



    private void addTrainer() {
        System.out.print("Trainer Name: ");
        String name = scanner.nextLine();
        System.out.print("Trainer Age: ");
        int age = scanner.nextInt();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        Trainer trainer = new Trainer(name, age, exp, spec);

        System.out.println("Trainer added!");
    }

    private void viewAllTrainers() {

        System.out.println("Viewing all trainers...");
    }

    private void conductTraining() {

        System.out.println("Conducting training...");
    }
}
