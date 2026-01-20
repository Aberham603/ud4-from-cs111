/**
 * Represents a Roulette slot on the wheel.
 * 
 * Each slot has a color, a number, and a payout factor.
 * Used to model different spaces on a roulette wheel.
 * 
 * @author Rei Cooper and ChatGPT
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
RouletteSlot
-----------------------------------------
- color  : String
- number : int
- factor : double
-----------------------------------------
+ RouletteSlot()
+ RouletteSlot(String, int, double)
+ RouletteSlot(RouletteSlot)
+ getColor() : String
+ getNumber() : int
+ getFactor() : double
+ setColor(String) : void
+ setNumber(int) : void
+ setFactor(double) : void
+ isEven() : boolean
+ toString() : String
+ equals(RouletteSlot) : boolean
-----------------------------------------
*/

public class RouletteSlot {

    // ========= INSTANCE VARIABLES =========
    // Stores the color of the slot (red, black, or green)
    private String color;

    // Stores the number of the slot (0–36)
    private int number;

    // Stores the payout multiplier for betting on this slot
    //private double factor;

    // ========= DEFAULT CONSTRUCTOR =========
    // Creates a default roulette slot with basic values
    public RouletteSlot() {
        this.color = "red";
        this.number = 1;
        //this.factor = 2.0;
    }

    // ========= FULL CONSTRUCTOR =========
    // Allows setting color, number, and payout factor manually
    public RouletteSlot(String color, int number) {
        this.color = color;
        this.number = number;
        //this.factor = factor;
    }

    // ========= COPY CONSTRUCTOR =========
    // Makes a duplicate of an existing RouletteSlot object
    public RouletteSlot(RouletteSlot other) {
        this.color = other.color;
        this.number = other.number;
        //this.factor = other.factor;
    }

    // ========= GETTERS =========
    // Returns the color
    public String getColor() { return color; }

    // Returns the number
    public int getNumber() { return number; }

    // Returns the payout factor
    //public double getFactor() { return factor; }

    // ========= SETTERS =========
    // Updates the color
    public void setColor(String color) { this.color = color; }

    // Updates the number
    public void setNumber(int number) { this.number = number; }

    // Updates the payout factor
    //public void setFactor(double factor) { this.factor = factor; }

    // ========= CHECK EVEN =========
    // Returns true if the number is even, false if odd
    public boolean isEven() {
        return number % 2 == 0;
    }

    // ========= TOSTRING =========
    // Returns a readable description of the roulette slot
    public String toString() {
        return "Roulette Slot -> Color: " + color +
               ", Number: " + number; 
               //", Payout x" + factor;
    }

    // ========= EQUALS =========
    // Checks if two RouletteSlot objects store the same data
    public boolean equals(RouletteSlot other) {
        return this.color.equals(other.color) &&
               this.number == other.number;
               //this.factor == other.factor;
    }
}

