package model;

public class NoMembershipException extends RuntimeException {


    public NoMembershipException(String memberName) {
        super(memberName + " cannot train without membership!");
    }


    public NoMembershipException(String memberName, String message) {
        super(memberName + ": " + message);
    }
}
