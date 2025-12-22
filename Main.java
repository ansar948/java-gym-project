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


