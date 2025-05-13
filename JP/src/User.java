import java.util.ArrayList;
import java.util.List;
/**
 * Represents a user in the Finance Management System.
 * The user can have personal details like name, email, password, role, and a list of financial goals.
 */
public class User {
    
    /**
     * The name of the user.
     */
    String name;
    
    /**
     * The email of the user.
     */
    String email;
    
    /**
     * The password of the user.
     */
    String password;
    
    /**
     * The role of the user (e.g., "user" or "admin").
     */
    String role;
    
    /**
     * The list of financial goals associated with the user.
     */
    List<FinanceGoal> goals = new ArrayList<>();

    /**
     * Constructs a User object with the given details.
     * 
     * @param name The name of the user.
     * @param email The email of the user.
     * @param password The password of the user.
     * @param role The role of the user (e.g., "user" or "admin").
     */
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
