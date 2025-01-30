package singlylinkedlist.socialmediaapp;

class User {
    int userID;
    String name;
    Friend friendsHead;
    User next;

    User(int userID, String name) {
        this.userID = userID;
        this.name = name;
        this.friendsHead = null;
        this.next = null;
    }

    // Add a friend
    void addFriend(int friendID) {
        Friend newFriend = new Friend(friendID);
        newFriend.next = friendsHead;
        friendsHead = newFriend;
    }

    // Display all friends of this user
    void displayFriends() {
        Friend temp = friendsHead;
        System.out.print(name + "'s friends: ");
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
