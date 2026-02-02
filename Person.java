package model;

public abstract class   Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
package model;

public class Trainer extends Person {

    private int experienceYears;
    private String specialization;

    public Trainer(String name, int age, int experienceYears, String specialization) {
        super(name, age);

        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience years must be >= 0");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }

        this.experienceYears = experienceYears;
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "model.Trainer";
    }

    public void conductTraining(Member member) {
        System.out.println(name + " trains " + member.getName());
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getSpecialization() {
        return specialization;
    }
}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + ": " + name + ", Age: " + age;
    }
}
