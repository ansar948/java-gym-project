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


    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSalary() {
        return salary;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void conductTraining(Member member) {
        System.out.println(name + " trains " + member.getName());
    }
}

