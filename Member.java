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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public boolean hasMembership() {
        return hasMembership;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }

    public void train() {
        if (hasMembership) {
            System.out.println(name + " is training.");
        } else {
            System.out.println(name + " has no membership.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
