import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    String name ;
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<String> inventory = new ArrayList<String>(); 


//grab 
//drop 
//examine 
//use 
    public void go(String direction) {
        currentRoom = currentRoom.getConnectedRoom(direction); 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
    }

}
