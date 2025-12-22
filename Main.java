class Member {
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

class Trainer {
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

class Gym {
    private String name;
    private String location;
    private int membersCount;
    private boolean isOpen;

    public Gym(String name, String location, int membersCount, boolean isOpen) {
        this.name = name;
        this.location = location;
        this.membersCount = membersCount;
        this.isOpen = isOpen;
    }

    public void openGym() {
        isOpen = true;
        System.out.println(name + " is open.");
    }
}

public class Main {
    public static void main(String[] args) {
        Member member = new Member("Ansar", 20, 75.5, true);
        Trainer trainer = new Trainer("Alex", 5, "Fitness", 200000);
        Gym gym = new Gym("Power Gym", "Astana", 120, false);

        gym.openGym();
        member.train();
        trainer.conductTraining(member);
    }
}

