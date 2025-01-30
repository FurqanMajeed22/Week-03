package doublylinkedlist.moviemanagementsystem;

class MovieLinkedList {
    Movie head;
    Movie tail;

    MovieLinkedList(String movieTitle, String director, int yearOfRelease, String rating) {
        this.head = new Movie(movieTitle, director, yearOfRelease, rating);
        tail = head;
    }

    void atTheBeginning(String movieTitle, String director, int yearOfRelease, String rating) {
        Movie newmovie = new Movie(movieTitle, director, yearOfRelease, rating);
        newmovie.next = head;
        head.prev = newmovie;

        head = newmovie;
    }

    void atTheEnding(String movieTitle, String director, int yearOfRelease, String rating) {
        Movie newmovie = new Movie(movieTitle, director, yearOfRelease, rating);

        tail.next = newmovie;
        newmovie.prev = tail;

        tail = newmovie;
    }

    void atSpecificPosition(String movieTitle, String director, int yearOfRelease, String rating, int position) {
        Movie newMovie = new Movie(movieTitle, director, yearOfRelease, rating);

        if (position == 1) {
            atTheBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        Movie temp = head;

        while (position - 2 > 0 && temp != null) {
            temp = temp.next;
            position--;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        } else {
            newMovie.next = temp.next;
            temp.next.prev = newMovie;
            newMovie.prev = temp;
            temp.next = newMovie;
        }

        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    void removeMovie(String movieTitle) {
        Movie temp = head;

        while (temp.movieTitle != movieTitle && temp != null) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("No Movie found with title " + movieTitle);
        } else {
            if (temp.next != null) temp.next.prev = temp.prev;
            else tail = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
            else head = temp.next;
        }
    }

    void searchByDirector(String director) {
        Movie temp = head;

        while (temp != null) {
            if (temp.director == director) {
                displayDetails(temp);
                return;
            }
            temp = temp.next;
        }
    }

    void searchByRating(String rating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.rating == rating) {
                displayDetails(temp);
                return;
            }
            temp = temp.next;
        }
    }

    void updateRating(String rating, String movieTitle) {
        Movie temp = head;

        while (temp != null) {
            if (temp.movieTitle == movieTitle) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayInForward() {
        Movie temp = head;

        while (temp != null) {
            System.out.println("Movie " + temp.movieTitle);
            temp = temp.next;
        }
        System.out.println("");
    }

    void displayInBackward() {
        Movie temp = tail;

        while (temp != null) {
            System.out.println("Movie " + temp.movieTitle);
            temp = temp.prev;
        }
        System.out.println("");
    }

    void displayDetails(Movie movie) {
        System.out.println("");
        System.out.println("Movie Title " + movie.movieTitle);
        System.out.println("Director " + movie.director);
        System.out.println("Year of Release " + movie.yearOfRelease);
        System.out.println("Rating " + movie.rating);
        System.out.println("");
    }

}
