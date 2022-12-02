/**
 * Represents items which a player can interact with and use 
 */
public class Item {
    private String name;
    private String descrip;

    /** 
     * Constructs an Item
     */
    public Item(String name, String description) { 
        this.name = name; 
        this.descrip = description;
    }


    /**
     * Returns the name of an Item
     * @return String name of an Item
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the description of an Item
     * @return String description of an Item
     */
    public String getDescrip() {
        return descrip; 
    }



    /** 
     * Returns the description of an item
     */
    public String check() {
        return getDescrip(); 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
        
    }
}
