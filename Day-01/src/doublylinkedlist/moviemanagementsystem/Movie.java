package doublylinkedlist.moviemanagementsystem;

class Movie {
    String movieTitle;
    String director;
    int yearOfRelease;
    String rating;
    Movie next;
    Movie prev;

    Movie(String movieTitle, String director, int yearOfRelease, String rating) {
        this.director = director;
        this.movieTitle = movieTitle;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
