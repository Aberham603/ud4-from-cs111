/**
 * Represents a Slot Machine.
 * 
 * @author Zack Preciado and Copilot
 * @version 2.0
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Slots
-----------------------------------------
+ DEFAULT_NAME : String
+ DEFAULT_ICON : char
+ DEFAULT_VALUE : int
- name : String
- icon : char
- value : int
-----------------------------------------
+ Slots()
+ Slots(name : String, icon : char, value : int)
+ Slots(original : Slots)
+ getName() : String
+ getIcon() : char
+ getValue() : int
+ setName(name : String) : void
+ setIcon(icon : char) : boolean
+ setValue(value : int) : boolean
+ setAll(name : String, icon : char, value : int) : boolean
+ toString() : String
+ equals(otherSlots : Slots) : boolean
-----------------------------------------
*/

/**
 * Slots Class
 * Represents a slot machine symbol with a name, icon, and value.
 * Based on UML diagram provided.
 */
public class Slots {

    // -------------------------
    // Constants (Defaults)
    // -------------------------
    public static final String DEFAULT_NAME = "Default";
    public static final char DEFAULT_ICON = '?';
    public static final int DEFAULT_VALUE = 0;

    // -------------------------
    // Instance Variables
    // -------------------------
    private String name;
    private char icon;
    private int value;

    // -------------------------
    // Constructors
    // -------------------------

    // Default constructor
    public Slots() {
        this.name = DEFAULT_NAME;
        this.icon = DEFAULT_ICON;
        this.value = DEFAULT_VALUE;
    }

    // Parameterized constructor
    public Slots(String name, char icon, int value) {
        this.name = name;
        this.icon = icon;
        this.value = value;
    }

    // Copy constructor
    public Slots(Slots original) {
        this.name = original.name;
        this.icon = original.icon;
        this.value = original.value;
    }

    // -------------------------
    // Accessors (Getters)
    // -------------------------
    public String getName() {
        return name;
    }

    public char getIcon() {
        return icon;
    }

    public int getValue() {
        return value;
    }

    // -------------------------
    // Mutators (Setters)
    // -------------------------

    public void setName(String name) {
        this.name = name;
    }

    public boolean setIcon(char icon) {
        // Example validation: only allow letters or digits
        if (Character.isLetterOrDigit(icon)) {
            this.icon = icon;
            return true;
        }
        return false;
    }

    public boolean setValue(int value) {
        // Example validation: value must be non-negative
        if (value >= 0) {
            this.value = value;
            return true;
        }
        return false;
    }

    public boolean setAll(String name, char icon, int value) {
        boolean iconSet = setIcon(icon);
        boolean valueSet = setValue(value);
        this.name = name;
        return iconSet && valueSet;
    }

    // -------------------------
    // Utility Methods
    // -------------------------

    @Override
    public String toString() {
        return "Slots[name=" + name + ", icon=" + icon + ", value=" + value + "]";
    }

    public boolean equals(Slots otherSlots) {
        if (otherSlots == null) return false;
        return this.name.equals(otherSlots.name) &&
               this.icon == otherSlots.icon &&
               this.value == otherSlots.value;
    }
    
}
