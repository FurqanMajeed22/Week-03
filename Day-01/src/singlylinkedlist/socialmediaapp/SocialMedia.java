package singlylinkedlist.socialmediaapp;

class SocialMedia {
    User head;

    SocialMedia() {
        head = null;
    }

    // Add a new user
    void addUser(int userID, String name) {
        User newUser = new User(userID, name);
        newUser.next = head;
        head = newUser;
    }

    // Search for a user by ID or name
    User searchUser(String name, int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection
    void addFriendConnection(int userID1, int userID2) {
        User user1 = searchUser("", userID1);
        User user2 = searchUser("", userID2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userID2);
            user2.addFriend(userID1);
        }
    }

    // Display all users
    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userID + " Name: " + temp.name);
            temp = temp.next;
        }
    }
}
