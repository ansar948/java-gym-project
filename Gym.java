public class Gym {
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
