/**
 * Represents Player
 * 
 * @author Abraham Moreno and Google Gemini
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Player
-----------------------------------------
<data, i.e. variables>
+ DEFAULT_NAME : String
+ DEFAULT_WINS : int
+ DEFAULT_LOSSES : int
+ DEFAULT_MONEY : double
- name : String
- wins: int
- losses : int
- money : double
-----------------------------------------
<actions, i.e. methods>
+ Player()
+ Player(name : String, wins : int, losses : int, money : double)
+ Player(original : Player)
+ setName(name : String) : void
+ setWins(wins : int) : boolean
+ setLosses(losses : int) : boolean
+ setMoney(money : double) : boolean
+ setAll(name : String, wins : int, losses : int, money : double) : boolean
+ getName() : String
+ getWins() : int
+ getLosses() : int
+ getMoney() : double
+ toString() : String
+ equals(otherPlayer : Player) : boolean
-----------------------------------------
*/

/**
 * Represents a Player with a name, win/loss record, and money amount.
 * All attributes are encapsulated (private) and accessed/modified via public methods.
 */
 
public class Player 
{

    // --- Public Static Constants (DEFAULT Values) ---
    public static final String DEFAULT_NAME = "New Player";
    public static final int DEFAULT_WINS = 0;
    public static final int DEFAULT_LOSSES = 0;
    public static final double DEFAULT_MONEY = 100.00;

    // --- Private Instance Variables (Data) ---
    private String name;
    private int wins;
    private int losses;
    private double money;

    // ---------------------------------------------
    // --- Constructors ---
    // ---------------------------------------------

    /**
     * Default (No-Argument) Constructor.
     * Initializes the player using the defined default constant values.
     */
    public Player() 
    {
        this(DEFAULT_NAME, DEFAULT_WINS, DEFAULT_LOSSES, DEFAULT_MONEY);
    }

    /**
     * Parameterized Constructor.
     * Initializes the player with specified values, performing validation
     * where necessary to ensure data integrity.
     *
     * @param name The player's name.
     * @param wins The number of games won.
     * @param losses The number of games lost.
     * @param money The player's current money balance.
     */
    public Player(String name, int wins, int losses, double money) 
    {
        // Validation is handled by the setter methods
        setName(name);
        setWins(wins);
        setLosses(losses);
        setMoney(money);
    }
    
    /**
     * Deep Copy Constructor. 🏗️
     * Creates a new Player object that is an exact, independent copy of the
     * Player object passed as an argument.
     *
     * @param original The existing Player object to copy.
     */
    public Player(Player original) {
        // Primitive types (int, double) and String (immutable) are safely copied by value.
        // A "deep copy" is needed only if the class contained mutable reference types (like other objects or arrays).
        // Since 'name' is a String (immutable), we just copy the reference, which is safe.
        // Since 'wins', 'losses', and 'money' are primitives, they are copied by value.
        this.name = original.name; 
        this.wins = original.wins;
        this.losses = original.losses;
        this.money = original.money;
    }
    
    // ---------------------------------------------
    // --- Mutator (Setter) Methods ---
    // ---------------------------------------------

    /**
     * Sets the player's name.
     *
     * @param name The new name for the player.
     */
    public void setName(String name) {
        // Simple null/empty check for name
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            this.name = DEFAULT_NAME; // Fallback to default if invalid
        }
    }

    /**
     * Sets the number of wins. Wins cannot be negative.
     *
     * @param wins The new number of wins.
     * @return true if the wins were set successfully, false otherwise.
     */
    public boolean setWins(int wins) {
        if (wins >= 0) {
            this.wins = wins;
            return true;
        }
        return false;
    }

    /**
     * Sets the number of losses. Losses cannot be negative.
     *
     * @param losses The new number of losses.
     * @return true if the losses were set successfully, false otherwise.
     */
    public boolean setLosses(int losses) {
        if (losses >= 0) {
            this.losses = losses;
            return true;
        }
        return false;
    }

    /**
     * Sets the player's money balance. Money cannot be negative.
     *
     * @param money The new money balance.
     * @return true if the money was set successfully, false otherwise.
     */
    public boolean setMoney(double money) {
        if (money >= 0.0) {
            this.money = money;
            return true;
        }
        return false;
    }
    
    public void addMoney(double moreMoney)
    {
        this.money = money + moreMoney;
    }
    
    public void loseMoney(double lessMoney)
    {
        this.money = money - lessMoney;
    }

    /**
     * Attempts to set all four attributes, ensuring all are valid.
     * Uses the individual setter methods to handle validation.
     *
     * @param name The player's name.
     * @param wins The number of wins.
     * @param losses The number of losses.
     * @param money The player's money balance.
     * @return true if ALL attributes were set successfully, false otherwise.
     */
    public boolean setAll(String name, int wins, int losses, double money) {
        // Name doesn't return a boolean, so we assume its setter handles it.
        // We only return false if a numerical setter fails.
        setName(name);
        return setWins(wins) && setLosses(losses) && setMoney(money);
    }

    // ---------------------------------------------
    // --- Accessor (Getter) Methods ---
    // ---------------------------------------------

    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of wins.
     *
     * @return The number of wins.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Gets the number of losses.
     *
     * @return The number of losses.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Gets the player's money balance.
     *
     * @return The player's money balance.
     */
    public double getMoney() {
        return money;
    }

    // ---------------------------------------------
    // --- Utility Methods ---
    // ---------------------------------------------

    /**
     * Provides a formatted String representation of the Player object.
     *
     * @return A String containing all player attributes.
     */
    @Override
    public String toString() {
        return String.format(
            "Player [Name: %s, Wins: %d, Losses: %d, Money: $%.2f, Record: %d-%d]",
            name, wins, losses, money, wins, losses
        );
    }

    /**
     * Compares this Player object to another object for equality.
     * Two players are considered equal if all their fields are identical.
     *
     * @param otherPlayer The Player object to compare against.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Player otherPlayer) {
        // Check for reference equality first
        if (this == otherPlayer) return true;

        // Check if the otherPlayer is null (although not explicitly needed if parameter is Player)
        if (otherPlayer == null) return false;

        // Compare all fields for value equality
        return this.name.equals(otherPlayer.name) &&
               this.wins == otherPlayer.wins &&
               this.losses == otherPlayer.losses &&
               this.money == otherPlayer.money;
    }
    
    // NOTE: For proper overriding of Object.equals, the signature should be
    // public boolean equals(Object obj). The UML requested public boolean equals(Player otherPlayer).
    // The provided equals(Player) method is functionally correct for comparing two Player objects.

}
