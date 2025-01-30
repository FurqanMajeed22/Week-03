package circularlinkedlist.ticketreservationapp;

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(101, "ABC", "MIB", "A1");
        system.addTicket(102, "DEF", "IronMan", "B2");
        system.addTicket(103, "GHI", "Mission Impossible", "C3");
        system.addTicket(104, "JKL", "The Matrix", "D4");

        // Display all tickets
        system.displayTickets();

        // Search for tickets by Customer Name
        system.searchTicket("Alice");

        // Search for tickets by Movie Name
        system.searchTicket("Titanic");

        // Total booked tickets
        system.totalBookedTickets();

        // Remove a ticket by Ticket ID
        system.removeTicket(102);

        // Display all tickets after removal
        system.displayTickets();

        // Total booked tickets after removal
        system.totalBookedTickets();
    }
}
