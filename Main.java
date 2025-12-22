public class Main {
    public static void main(String[] args) {
        Member member = new Member("Ansar", 20, 75.5, true);
        Trainer trainer = new Trainer("Alex", 5, "Fitness", 200000);
        Gym gym = new Gym("Power Gym", "Astana", 120, false);

        gym.openGym();
        member.train();
        trainer.conductTraining(member);


        System.out.println("Member age: " + member.getAge());
        member.setWeight(77.0);
        System.out.println("Member new weight: " + member.getWeight());
    }
}


