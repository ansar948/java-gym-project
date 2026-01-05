public class Trainer extends Person {

    private int experienceYears;
    private String specialization;

    public Trainer(String name, int age, int experienceYears, String specialization) {
        super(name, age);
        this.experienceYears = experienceYears;
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "Trainer";
    }

    public void conductTraining(Member member) {
        System.out.println(name + " trains " + member.getName());
    }
}
