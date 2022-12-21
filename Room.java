import java.util.*;
/**
 * Represent rooms for the Player to explore
 * Holds items for player interaction
 */
public class Room {
    private String name; 
    private String descrip; 
    private ArrayList<Item> roomInventory = new ArrayList<Item>();
    private Map<String, Item> nameToItem = new HashMap<String, Item>(); 
    boolean newToPlayer= true; //If this is true, an introduction prints when the player enters the room
    boolean locked = false; 
    String prompt; 
    String password; 
    enum Direction { //Source [4]
        NORTH, SOUTH, EAST, WEST;
     }
    private Map<Direction, Room> exits = new HashMap<Direction, Room>(); 

    /**
     * Constructor for rooms
     * @param name of the room
     * @param descrip to describe the room
     */
    public Room(String name, String descrip) {
        this.name = name; 
        this.descrip = descrip; 
        Item notInRoom= new Item("notInRoom", ""); //This Item is returned when the player tries to access an Item not in the current Room
        nameToItem.put("notInRoom", notInRoom); 
    }

    /**
     * Overloaded constructor for rooms that can be locked
     * @param name of the name
     * @param descrip to describe the room
     * @param locked indicates if player can interact with items in room
     * @param prompt asks for the password
     * @param password password that unlocks room
     */
    public Room(String name, String descrip, boolean locked, String prompt, String password) {
        this.name = name; 
        this.descrip = descrip; 
        this.locked = locked; 
        this.prompt = prompt; 
        this.password = password; 
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

    /**
     * Accessor for getNameToItem
     * @return getNameToItem map
     */
    public Map<String, Item> getNameToItem(){
        return nameToItem; 
    }

    /**
     * Converts name of item to Item
     * @param itemName name of Item
     * @return Item that name refers to 
     */
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
                System.out.println("There is no exit in that direction");
                return currentRoom; 
            }
        
    }

    /**
     * Returns index of item in inventory
     * @param item to check index for 
     * @return int index of the item in inventory
     */
    public int getItemIndex (Item item) { 
        return this.roomInventory.indexOf(item); 
    }

    
    /**
     * Adds an exit connection
     * @param direction of the exit
     * @param connectedRoom that exit connects to 
     */
    public void addRoomExit(String direction, Room connectedRoom) {
        this.exits.put(Direction.valueOf(direction), connectedRoom); 
    }

    /**
     *  Adds items to inventory
     * @param item to add 
     */
    public void addItem(Item item) { 
        this.roomInventory.add(item);
        nameToItem.put(item.getName(), item); 
    }

    /**
     * Removes item from inventory
     * @param item to remove
     */
    public void removeItem(Item item) { 
        this.roomInventory.remove(item); 
    }

    /**
     * Sets the name of a Room
     * @param name String name of a Room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of a Room
     * @param descrip String description of a Room
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip; 
    }

    /**
     * Manipulator for newToPlayer
     * @param newToPlayer new value for boolean
     */
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
     * Prints the room inventory
     */
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
