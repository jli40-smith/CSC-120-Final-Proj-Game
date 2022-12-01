import java.util.*;
/**
 * Aggregrates Items and represent rooms for the Player to explore
 */
public class Room {
    //Hashtable rooms = new Hashtable<Integer, String[]>();
    ArrayList<Item> roomInventory = new ArrayList<Item>();

    public Room( ArrayList<Item> roomInventory) {
        this.roomInventory = roomInventory; 
    }
    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
