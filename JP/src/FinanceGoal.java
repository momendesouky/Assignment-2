/**
 * Represents a financial goal in the Finance Management System.
 * The goal has a name, target amount, and a deadline.
 */
public class FinanceGoal {

    /**
     * The name of the financial goal.
     */
    private String name;
    
    /**
     * The target amount for the financial goal.
     */
    private double targetAmount;
    
    /**
     * The deadline for the financial goal.
     */
    private String deadline;

    /**
     * Constructs a FinanceGoal object with the given details.
     * 
     * @param name The name of the financial goal.
     * @param targetAmount The target amount to achieve.
     * @param deadline The deadline for achieving the goal.
     */
    public FinanceGoal(String name, double targetAmount, String deadline) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }

    /**
     * Returns a string representation of the financial goal.
     * 
     * @return A string containing the name, target amount, and deadline of the goal.
     */
    public String toString() {
        return "Goal: " + name + ", Target: $" + targetAmount + ", Deadline: " + deadline;
    }
}
