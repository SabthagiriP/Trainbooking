import java.util.Scanner;

public class TrainBookingApp {
    private static UserService userService = new UserService();
    private static TrainBookingSystem trainBookingSystem = new TrainBookingSystem();


    public static void main(String[] args) {
        TrainBookingSystem trainBookingSystem = new TrainBookingSystem();
        trainBookingSystem.addSampleTrains();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- Train Booking System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View Particular Ticket");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    trainBookingSystem.registerUser();
                    break;
                case 2:
                    trainBookingSystem.loginUser();
                    break;
                case 3:
                    if (trainBookingSystem.isUserLoggedIn()) {
                        trainBookingSystem.bookTicket();
                    } else {
                        System.out.println("Please login or register first to proceed.");
                    }
                    break;
                case 4:
                    if (trainBookingSystem.isUserLoggedIn()) {
                        trainBookingSystem.cancelTicket();
                    } else {
                        System.out.println("Please login or register first to proceed.");
                    }
                    break;
                case 5:
                    if (trainBookingSystem.isUserLoggedIn()) {
                        trainBookingSystem.viewTicket();
                    } else {
                        System.out.println("Please login or register first to proceed.");
                    }
                    break;
                case 6:
                    trainBookingSystem.logoutUser();
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
//import java.util.*;
//
//public class TrainBookingApp {
//    private static final int MAX_TICKETS_PER_PERSON = 5;
//
//    public static void main(String[] args) {
//        TrainBookingSystem bookingSystem = new TrainBookingSystem();
//
//
//        bookingSystem.addTrain(new Train(101, "Express Train", 50, 100.0));
//        bookingSystem.addTrain(new Train(102, "Intercity Train", 30, 150.0));
//
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n--- Train Booking System ---");
//            System.out.println("1. Book Ticket");
//            System.out.println("2. Cancel Ticket");
//            System.out.println("3. View Particular Ticket");
//            System.out.println("4. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter Passenger Name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter Passenger Age: ");
//                    int age = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter Number of Tickets: ");
//                    int numTickets = scanner.nextInt();
//                    scanner.nextLine();
//
//                    System.out.print("Enter Train ID: ");
//                    int trainId = scanner.nextInt();
//                    scanner.nextLine();
//
//                    System.out.print("Enter Pickup Location: ");
//                    String pickup = scanner.nextLine();
//                    System.out.print("Enter Drop Location: ");
//                    String drop = scanner.nextLine();
//
//                    Passenger passenger = new Passenger(name, age, "");
//                    bookingSystem.bookTicket(trainId, passenger,numTickets, pickup, drop);
//                    break;
//
//                case 2:
//                    System.out.print("Enter Booking ID to cancel: ");
//                    int cancelId = scanner.nextInt();
//                    scanner.nextLine();
//                    bookingSystem.cancelTicket(cancelId);
//                    break;
//
//
//
//                case 3:
//                    System.out.print("Enter Booking ID to view ticket details: ");
//                    int bookingId = scanner.nextInt();
//                    scanner.nextLine();
//                    Booking booking = bookingSystem.findBookingById(bookingId);
//                    if (booking != null) {
//                        System.out.println("Ticket Details:\n" + booking);
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Exiting...");
//                    scanner.close();
//                    return;
//
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//}