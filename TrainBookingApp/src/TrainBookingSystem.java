import java.util.HashMap;
import java.util.Scanner;

public class TrainBookingSystem {
    private HashMap<String, User> users;
    private HashMap<String, Train> trainDetails; // Stores train details by train ID
    private HashMap<Integer, Booking> bookings; // Stores registered users by email
    private User currentUser;           // Tracks the currently logged-in user

    public TrainBookingSystem() {
        users = new HashMap<>();
        trainDetails = new HashMap<>();
        bookings = new HashMap<>();
        currentUser = null;
    }

    // Method to register a new user
    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter your mobile number:");
        String mobile = scanner.nextLine();

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (users.containsKey(email)) {
            System.out.println("Email is already registered. Please log in.");
        } else {
            User newUser = new User(name, age, mobile, email, password);
            users.put(email, newUser);
            System.out.println("Registration successful! Please log in.");
        }
    }

    // Method to log in a user
    public void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            currentUser = users.get(email); // Update currentUser
            System.out.println("Login successful! Welcome, " + currentUser.getName());
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }


    // Method to check if a user is logged in
    public boolean isUserLoggedIn() {
        return currentUser != null;
    }

    // Method to log out the current user
    public void logoutUser() {
        currentUser = null;
        System.out.println("You have been logged out.");
    }

    // Placeholder methods for booking, canceling, and viewing tickets

    public void bookTicket() {
        if (isUserLoggedIn()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Train ID:");
            String trainId = scanner.nextLine().trim();

            if (!trainDetails.containsKey(trainId)) {
                System.out.println("Invalid Train ID. Please try again.");
                return;
            }

            Train train = trainDetails.get(trainId);
            System.out.println("Selected Train: " + train.getTrainName());

            System.out.println("Enter Pickup Location:");
            String pickupLocation = scanner.nextLine();

            System.out.println("Enter Drop Location:");
            String dropLocation = scanner.nextLine();

            System.out.println("Enter Number of Tickets:");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (numberOfTickets > train.getAvailableSeats()) {
                System.out.println("Only " + train.getAvailableSeats() + " seats are available.");
                return;
            }

            double price = numberOfTickets * train.getTicketPrice();
            train.setAvailableSeats(train.getAvailableSeats() - numberOfTickets);

            int bookingId = bookings.size() + 1; // Generate unique booking ID
            Booking booking = new Booking(bookingId, currentUser, train, pickupLocation, dropLocation, numberOfTickets, price);
            bookings.put(bookingId, booking);

            System.out.println("Booking successful! Booking ID: " + bookingId);
        } else {
            System.out.println("Please log in first.");
        }
    }



    public void cancelTicket() {
        if (isUserLoggedIn()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Booking ID to cancel:");
            int bookingId = scanner.nextInt();

            if (bookings.containsKey(bookingId)) {
                Booking booking = bookings.get(bookingId);
                if (!booking.getUser().equals(currentUser)) {
                    System.out.println("You can only cancel your own tickets.");
                    return;
                }

                Train train = booking.getTrain();
                train.setAvailableSeats(train.getAvailableSeats() + booking.getNumberOfTickets());
                bookings.remove(bookingId);

                System.out.println("Booking ID " + bookingId + " canceled successfully.");
            } else {
                System.out.println("Invalid Booking ID. Please try again.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }


    public void viewTicket() {
        if (isUserLoggedIn()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Booking ID to view details:");
            int bookingId = scanner.nextInt();

            if (bookings.containsKey(bookingId)) {
                Booking booking = bookings.get(bookingId);
                if (!booking.getUser().equals(currentUser)) {
                    System.out.println("You can only view your own tickets.");
                    return;
                }

                System.out.println("Ticket Details:");
                System.out.println(booking);
            } else {
                System.out.println("Invalid Booking ID. Please try again.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }
    public void addSampleTrains() {
        Train train1 = new Train("101", "Express Train", 50, 100.0);
        Train train2 = new Train("102", "Superfast Train", 60, 170.0);
        trainDetails.put(train1.getTrainId(), train1);
        trainDetails.put(train2.getTrainId(), train2);
    }

}
