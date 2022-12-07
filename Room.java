import java.util.*;
/**
 * Represent rooms for the Player to explore
 */
public class Room {
    private int roomID; 
    private String name; 
    private String descrip; 
    private ArrayList<Item> roomInventory = new ArrayList<Item>();
    
    enum Direction { //Source [4]
        NORTH, SOUTH, EAST, WEST;
     }
    private Map<Direction, Room> exits; 

    /*Constructor for Rooms */
    public Room(int roomID, String name) {
        this.roomID = roomID; 
        this.name = name; 
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
     * Returns the ID of a Room
     * @return int ID of a Room
     */
    public int getRoomID() {
        return roomID; 
    }

    /**
     * Returns the exits map of a Room
     * @return Map of exits for  a Room
     */
    public Map<Direction, Room> getExits() {
        return exits; 
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
     * Sets the room ID of a Room
     * @param new int room ID of a Room
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID; 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
