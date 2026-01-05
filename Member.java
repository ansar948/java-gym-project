public class Member extends Person {
    private double weight;
    private boolean hasMembership;

    public Member(String name, int age, double weight, boolean hasMembership) {
        super(name, age);
        this.weight = weight;
        this.hasMembership = hasMembership;
    }

    @Override
    public String getRole() {
        return "Gym Member";
    }

    public void train() {
        if (hasMembership) {
            System.out.println(name + " is training!");
        } else {
            System.out.println(name + " cannot train without membership.");
        }
    }
}
