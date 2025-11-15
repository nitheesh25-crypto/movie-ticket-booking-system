package com.nitheesh.movieticket;

import java.util.*;

public class MovieTicketBookingSystem {

    static class Movie {
        String title;
        int seats;
        double price;

        Movie(String title, int seats, double price) {
            this.title = title;
            this.seats = seats;
            this.price = price;
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static List<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {

        movies.add(new Movie("The Adventure", 50, 120.0));
        movies.add(new Movie("Space Journey", 30, 150.0));
        movies.add(new Movie("Romantic Tale", 40, 100.0));

        while (true) {
            System.out.println("\n===== Movie Ticket Booking System =====");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listMovies();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void listMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.printf("%d) %s  | Seats: %d | Price: ₹%.2f%n",
                    i + 1, m.title, m.seats, m.price);
        }
    }

    private static void bookTickets() {
        listMovies();
        System.out.print("\nSelect movie number: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= movies.size()) {
            System.out.println("Invalid movie selection.");
            return;
        }

        Movie selectedMovie = movies.get(index);

        System.out.print("Enter number of tickets: ");
        int count = scanner.nextInt();

        if (count <= 0 || count > selectedMovie.seats) {
            System.out.println("Not enough seats available.");
            return;
        }

        double amount = count * selectedMovie.price;

        System.out.printf("Total Cost: ₹%.2f%n", amount);
        System.out.print("Confirm booking (y/n): ");
        scanner.nextLine();
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            selectedMovie.seats -= count;
            System.out.println("Booking successful! Enjoy the show.");
        } else {
            System.out.println("Booking cancelled.");
        }
    }
}
