public class Trainer {
    private String name;
    private int experienceYears;
    private String specialization;

    public Trainer(String name, int experienceYears, String specialization) {
        setName(name);
        setExperienceYears(experienceYears);
        this.specialization = specialization;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Trainer name cannot be empty");
        }
        this.name = name;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("%-10s | Experience: %-2d years | Specialization: %s",
                name, experienceYears, specialization);
    }
}
