import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    private HashMap<String, User> users = new HashMap<>();
    private User loggedInUser = null;

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Mobile Number: ");
        String mobileNo = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(email)) {
            System.out.println("User already registered with this email.");
            return;
        }

        User user = new User(name, age, mobileNo, email, password);
        users.put(email, user);
        System.out.println("Registration successful!");
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful! Welcome, " + user.getName() + "!");
            return true;
        } else {
            System.out.println("Invalid email or password.");
            return false;
        }
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("You have been logged out.");
    }
}

