public class Main {
    public static void main(String[] args) {

        Person p1 = new Member("Ansar", 20, 75.5, true);
        Person p2 = new Trainer("Alex", 30, 5, "Fitness");

        System.out.println(p1.getRole());
        System.out.println(p2.getRole());
    }
}
