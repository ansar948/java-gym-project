public class Trainer {
    private String name;
    private int experienceYears;
    private String specialization;
    private double salary;

    public Trainer(String name, int experienceYears, String specialization, double salary) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.specialization = specialization;
        this.salary = salary;
    }

    public void conductTraining(Member member) {
        System.out.println(name + " trains " + member);
    }
}
