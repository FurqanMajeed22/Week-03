package singlylinkedlist.socialmediaapp;

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Add users
        sm.addUser(1, "ABC");
        sm.addUser(2, "DEF");
        sm.addUser(3, "GHI");

        // Add friends
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);

        // Display all users
        sm.displayAllUsers();

        // Display Alice's friends
        User alice = sm.searchUser("", 1);
        if (alice != null) alice.displayFriends();

        // Display Bob's friends
        User bob = sm.searchUser("", 2);
        if (bob != null) bob.displayFriends();
    }
}
