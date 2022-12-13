import java.util.*;
/**
 * Represent rooms for the Player to explore
 */
public class Room {
    private String name; 
    private String descrip; 
    private ArrayList<Item> roomInventory = new ArrayList<Item>();
    
    public static enum Direction { //Source [4]
        NORTH, SOUTH, EAST, WEST;
     }
    private Map<Direction, Room> exits; 

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
    public Room getConnectedRoom(String direction) {
        Room connectedRoom = this.exits.get(Direction.valueOf(direction)); 
        return connectedRoom; 
    }

    
    /* Adds exits NEEDS REWRITE*/
    public void addRoomExit (String direction, Room connectedRoom) {
        this.exits.put(Direction.valueOf(direction), connectedRoom); 
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

    /**
     * Prints the location of the player and a description of the room 
     */
    public void introduceRoom() { 
        System.out.println("Current Location:" + "\n" + this.getDescrip());
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
