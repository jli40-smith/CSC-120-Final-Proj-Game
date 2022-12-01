/**
 * Represents items which a player can interact with and use 
 */
public class Item {
    private String name;
    private String description;

    /** 
     * Constructs an Item
     */
    public Item(String name, String description) { 
        this.name = name; 
        this.description = description;
    }

    /**
     * Returns the description of an Item
     * @return String description of an Item
     */
    public String getDescription() {
        return description; 
    }

    /** 
     * Overrides toString method for Items so that it returns the description of an Item 
     */
    public String toString() {
        return description; 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
        
    }
}
