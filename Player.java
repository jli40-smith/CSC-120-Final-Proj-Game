import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<String> inventory = new ArrayList<String>(); 

//grab 
//drop 
//examine 
//use 
    public void go(String direction) {
        currentRoom = currentRoom.getConnectedRoom(direction, currentRoom); 
        System.out.println("You are " + currentRoom.getName());
        if(currentRoom.newToPlayer) { 
            System.out.println(currentRoom.getDescrip());
            currentRoom.setNewtoPlayer(false);
        }
    }

    public void setCurrentRoom(Room r) { 
        this.currentRoom = r; 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
    }

}
