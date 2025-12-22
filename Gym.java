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


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public boolean isOpen() {
        return isOpen;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }


    public void openGym() {
        isOpen = true;
        System.out.println(name + " is open.");
    }
}

