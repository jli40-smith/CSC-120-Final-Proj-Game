import java.util.*;
/**
 * Represent rooms for the Player to explore
 */
public class Room {
    private String name; 
    private String descrip; 
    private ArrayList<Item> roomInventory = new ArrayList<Item>();
    private Map<String, Item> nameToItem = new HashMap<String, Item>(); 
    boolean newToPlayer= true; //If this is true, an introduction prints when the player enters the room
    
    public static enum Direction { //Source [4]
        NORTH, SOUTH, EAST, WEST;
     }
    private Map<Direction, Room> exits = new HashMap<Direction, Room>(); 

    /*Constructor for Rooms */
    public Room(String name, String descrip) {
        this.name = name; 
        this.descrip = descrip; 
        Item notInRoom= new Item("notInRoom", ""); //This Item is returned when the player tries to access an Item not in the current Room
        nameToItem.put("notInRoom", notInRoom); 
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


    /* REWRITE */
    public Item getItemFromName(String itemName) { 
        if (nameToItem.containsKey(itemName)) { 
            return nameToItem.get(itemName); 
        } else { 
           return nameToItem.get("notInRoom"); 
        }
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

    /* Adds items to room inventory and adds an entry to nameToItem which maps the String name of the Item to the Item NEEDS REWRITE */
    public void addItem(Item item) { 
        this.roomInventory.add(item);
        nameToItem.put(item.getName(), item); 
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

    /* REWRITE */
    public void setNewtoPlayer (boolean newToPlayer){ 
        this.newToPlayer = newToPlayer; 
    }

    /**
     * Prints the location of the player and a description of the room 
     */
    public void printCurrentRoom() { 
        System.out.println("You are  " + this.getName());
    }

    /* REWRITE Printing inventory */
    public void printInventory() { 
        for(Item item:roomInventory) {
            System.out.println(item.getName());
    }
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {

    }
}
