import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main application that allows users to interact with the Finance Management System.
 * It provides functionality for registering users, logging in, tracking investments, setting goals, 
 * creating budgets, adding bill reminders, and calculating net worth.
 */
public class FinanceApp {

    /**
     * The list of users in the system.
     */
    private final List<User> users = new ArrayList<>();
    
    /**
     * The currently logged-in user.
     */
    private User loggedInUser = null;
    
    /**
     * The scanner object used for user input.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Main method that starts the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new FinanceApp().run();
    }

    /**
     * Runs the main loop of the application, displaying the menu and processing user choices.
     */
    public void run() {
        int choice;
        while (true) {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }
            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> {
                    if (loggedInUser != null) trackInvestment();
                    else System.out.println("Please login first.");
                }
                case 4 -> {
                    if (loggedInUser != null) setGoal();
                    else System.out.println("Please login first.");
                }
                case 5 -> {
                    if (loggedInUser != null) createBudget();
                    else System.out.println("Please login first.");
                }
                case 6 -> {
                    if (loggedInUser != null) addBill();
                    else System.out.println("Please login first.");
                }
                case 7 -> {
                    if (loggedInUser != null) calculateNetWorth();
                    else System.out.println("Please login first.");
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Displays the main menu of the application.
     */
    private void showMenu() {
        System.out.println("\n=== Finance Management System ===");
        System.out.println("1. Register\n2. Login");
        System.out.println("3. Track Investment\n4. Set Financial Goal");
        System.out.println("5. Create Budget\n6. Add Bill Reminder\n7. Calculate Net Worth");
        System.out.print("0. Exit\nChoose an option: ");
    }

    /**
     * Registers a new user by prompting for name, email, password, and role.
     */
    private void registerUser() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role (user/admin): ");
        String role = scanner.nextLine();

        users.add(new User(name, email, password, role));
        System.out.println("Registration successful. You can now login.");
    }

    /**
     * Logs in an existing user by checking the email and password against registered users.
     */
    private void loginUser() {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful. Welcome " + user.name + "!");
                return;
            }
        }
        System.out.println("Invalid email or password.");
    }

    /**
     * Tracks an investment by prompting the user for investment type, amount, and date.
     */
    private void trackInvestment() {
        System.out.print("Enter Investment Type (e.g., Stock, Real Estate): ");
        String type = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Investment added: " + type + ", $" + amount + ", Date: " + date);
    }

    /**
     * Sets a financial goal by prompting the user for the goal's name, target amount, and deadline.
     */
    private void setGoal() {
        System.out.print("Enter Goal Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Target Amount: ");
        double target = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        FinanceGoal goal = new FinanceGoal(name, target, deadline);
        loggedInUser.goals.add(goal);

        System.out.println("Goal added: " + goal);
    }

    /**
     * Creates a monthly budget by prompting the user for the budget amount.
     */
    private void createBudget() {
        System.out.print("Enter Monthly Budget Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (amount <= 0) {
            System.out.println("Budget amount exceeds income or is invalid.");
            return;
        }
        System.out.println("Budget created: $" + amount);
    }

    /**
     * Adds a bill reminder by prompting the user for the bill name, amount, and due date.
     */
    private void addBill() {
        System.out.print("Enter Bill Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Due Date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        System.out.println("Bill added. Reminder set for: " + dueDate);
    }

    /**
     * Calculates and displays the user's net worth based on total assets and liabilities.
     */
    private void calculateNetWorth() {
        System.out.print("Enter Total Assets: ");
        double assets = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Total Liabilities: ");
        double liabilities = Double.parseDouble(scanner.nextLine());
        System.out.println("Your net worth is: $" + (assets - liabilities));
    }
}
