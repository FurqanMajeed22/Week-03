package doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList dll = new MovieLinkedList("Avengers","Deepansh",2020,"5");
        dll.displayInForward();

        dll.atTheBeginning("Ant Man","ABC",2018,"4");
        dll.displayInForward();

        dll.atTheEnding("No Way Home","DEF",2022,"4.5");
        dll.displayInForward();

        dll.atSpecificPosition("Iron Man","GHI",2002,"5",2);
        dll.displayInForward();

        dll.removeMovie("Ant Man");

        dll.displayInForward();

        dll.searchByDirector("Deepansh");
        dll.searchByRating("4.5");

        dll.updateRating("No Way Home","4.75");

        dll.displayInForward();
        dll.displayInBackward();
    }
}
