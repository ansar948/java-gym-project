package model;

public class Member extends Person implements Trainable {

    private final double weight;
    private final boolean hasMembership;

    public Member(String name, int age, double weight, boolean hasMembership) {
        super(name, age);

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }

        this.weight = weight;
        this.hasMembership = hasMembership;
    }




    @Override
    public String getRole() {
        return "Member";
    }

    @Override
    public void train() {
        if (hasMembership) {
            System.out.println(name + " is training!");
        } else {
            System.out.println(name + " cannot train without membership.");
        }
    }

    public boolean hasMembership() {
        return hasMembership;
    }

    public double getWeight() {
        return weight;
    }
}
