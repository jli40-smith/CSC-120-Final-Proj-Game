import java.util.*;
/**
 * Represent rooms for the Player to explore
 */
public class Room {
    private String name; 
    private String descrip; 
    private ArrayList<Item> roomInventory = new ArrayList<Item>();
    boolean newToPlayer= true; //If this is true, an introduction prints when the player enters the room
    
    public static enum Direction { //Source [4]
        NORTH, SOUTH, EAST, WEST;
     }
    private Map<Direction, Room> exits = new HashMap<Direction, Room>(); 

    /*Constructor for Rooms */
    public Room(String name, String descrip) {
        this.name = name; 
        this.descrip = descrip; 
    }

    /**
     * Returns the name of a Room
     * @return String name of a Room
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of a Room
     * @return String description of a Room
     */
    public String getDescrip() {
        return descrip; 
    }

    /**
     * Returns the room which connects to the current room via an exit in the given direction
     * @param String direction through which the exit returned connects to current room  
     * @return Room connected via exit in the given direction 
     */
    public Room getConnectedRoom(String direction, Room currentRoom) {
        Direction exitDirection = Direction.valueOf(direction); //converts String direction to enum Direction 
            if (this.exits.containsKey(exitDirection)) { 
                Room connectedRoom = this.exits.get(Direction.valueOf(direction)); 
                return connectedRoom; 
            } else { 
                System.out.println("There is no exit in this direction");
                return currentRoom; 
            }
        
    }

    /*Rewrite- gets the index of first occurence of given item in the array */
    public int getItemIndex (Item item) { 
        return this.roomInventory.indexOf(item); 
    }

    
    /* Adds exits NEEDS REWRITE*/
    public void addRoomExit(String direction, Room connectedRoom) {
        this.exits.put(Direction.valueOf(direction), connectedRoom); 
    }

    /* Adds items to room inventory NEEDS REWRITE */
    public void addItem(Item item) { 
        this.roomInventory.add(item); 
    }

    /* Removes item REWRITE*/
    public void removeItem(Item item) { 
        this.roomInventory.remove(item); 
    }

    /**
     * Sets the name of a Room
     * @param new String name of a Room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of a Room
     * @param new String description of a Room
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip; 
    }

    public void setNewtoPlayer (boolean newToPlayer){ 
        this.newToPlayer = newToPlayer; 
    }

    /**
     * Prints the location of the player and a description of the room 
     */
    public void printCurrentRoom() { 
        System.out.println("You are  " + this.getName());
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
