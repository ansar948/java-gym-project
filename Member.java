public class Member {
    private String name;
    private int age;
    private double weight;
    private boolean hasMembership;

    public Member(String name, int age, double weight, boolean hasMembership) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.hasMembership = hasMembership;
    }

    public void train() {
        if (hasMembership) {
            System.out.println(name + " is training.");
        } else {
            System.out.println(name + " has no membership.");
        }
    }
}
