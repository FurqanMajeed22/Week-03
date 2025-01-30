package circularlinkedlist.ticketreservationapp;

class TicketReservationSystem {
    Ticket head;

    TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular list
    void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber);

        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular link
        } else {
            Ticket temp = head;
            // Traverse to the last ticket in the circular list
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // Circular link
        }
        System.out.println("Ticket booked successfully.");
    }

    // Remove a ticket by Ticket ID
    void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Check if the ticket to remove is the head (first node)
        if (temp.ticketID == ticketID) {
            if (temp.next == head) {
                head = null; // Only one ticket in the list
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next; // Update the last node's next pointer
                head = head.next; // Remove the first node
            }
            System.out.println("Ticket with ID " + ticketID + " removed.");
            return;
        }

        // Traverse the list to find the ticket
        while (temp.next != head && temp.ticketID != ticketID) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.ticketID == ticketID) {
            prev.next = temp.next;
            System.out.println("Ticket with ID " + ticketID + " removed.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display the current tickets in the list
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.contains(searchTerm) || temp.movieName.contains(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found matching '" + searchTerm + "'.");
        }
    }

    // Calculate and display the total number of booked tickets
    void totalBookedTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total tickets booked: " + count);
    }
}
