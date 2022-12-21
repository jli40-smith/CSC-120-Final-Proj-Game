import java.util.*;
/**
 * Represents the player character in the game, who moves between rooms and interacts with objects
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<Item> inventory = new ArrayList<Item>(); 
    private Map<String, Item> nameToItem = new HashMap<String, Item>(); 
    private Item notInInventory= new Item("notInRoom", ""); //This Item is returned when the player tries to access an Item not in their inventory

/**
 * Constructor for player
 */
    public Player() { 
        nameToItem.put("notInInventory", notInInventory); 
    }
    /**
     * Picks up an item from the current Room and adds it to the player's inventory if it is not a duplicate 
     * and if the item is in the current Room. Only works if the player's inventory does not already contain 8 items
     * @param itemName item to grab
     */
    public void grab(String itemName){ 
        Item item = currentRoom.getItemFromName(itemName); 
        if (item != currentRoom.getItemFromName("notInRoom")) { //Checks if item is in the Room
                if (this.inventory.size() < 8) { //Check if the player has space in their inventory, which only fits 8 items
                    int playerItemIndex = this.getItemIndex(item); 
                    if(playerItemIndex == -1) { //Checks that the player doesn't already have the item
                        this.inventory.add(item); 
                        this.nameToItem.put(item.getName(), item);
                        currentRoom.removeItem(item);
                        currentRoom.getNameToItem().remove(itemName, item); 
                    } else { 
                        System.out.println("You already have that item");
                    }
                } else { 
                    System.out.println("You cannot pick up more than 8 items");
                }
        } else {
            System.out.println("That item is not in the room");
        }
    }
    
    /**
     * Drops an item and removes it from the player's inventory if there are items in the inventory and the 
     * item to be dropped is also in the inventory 
     * @param itemName item to drop
     */
    public void drop(String itemName){ 
        Item item = this.getItemFromName(itemName); 
        if (item != this.getItemFromName("notInInventory")) { //checks if item to drop is in the inventory
            if (this.inventory.size() > 0) { //checks if inventory is not empty 
                this.inventory.remove(item); 
                this.nameToItem.remove(itemName, item); 
                this.currentRoom.addItem(item);
            } else {
                System.out.println("Your inventory is empty, you cannot drop any items");
            }
        } else { 
            System.out.println("The item you are trying to drop is not in your inventory");
        }
    } 

    /**
     * Returns description for item if it is in the player inventory or inventory of current room 
     * @param itemName item to look at
     */
    public void look(String itemName) {
        Item item = currentRoom.getItemFromName(itemName); 
        if (item != currentRoom.getItemFromName("notInRoom")) { 
            System.out.println(item.getDescrip());
        } else if (nameToItem.containsKey(itemName)) { 
            System.out.println(nameToItem.get(itemName).getDescrip()); //Could have Room and Player both inherit from a parent so don't need to repeat code for nameToItem
        } else { 
            System.out.println("You can't look at " + itemName + " beacuse its not in the room or in your inventory");
        }
    }
    /**
     * Moves the player in the given direction 
     * @param direction to move in 
     */
    public void go(String direction) {
        Room connectedRoom = currentRoom.getConnectedRoom(direction, currentRoom); 
        boolean connectedRoomIsUnlocked = !currentRoom.getConnectedRoom(direction, currentRoom).locked; 
        if (connectedRoomIsUnlocked) { //if the room is not locked
            currentRoom = connectedRoom; 
                System.out.println("\n You are " + currentRoom.getName()); 
                if(currentRoom.newToPlayer) { 
                    System.out.println(currentRoom.getDescrip());
                    currentRoom.setNewtoPlayer(false);
                }
                System.out.println("You look around and see:");
                currentRoom.printInventory();
        } else { 
            System.out.println("The room you are trying to enter is locked, you must enter a password for access \n Press ENTER and proceed if you do not know the password");
            System.out.println(connectedRoom.prompt);

            Scanner passwordInput = new Scanner(System.in); 
            String passwordAttempt = passwordInput.nextLine().toLowerCase(); 

            if (passwordAttempt.equals(connectedRoom.password)) {
                System.out.println("The room has been unlocked");
                connectedRoom.locked = false; 
            } else { 
                System.out.println("Password attempt failed");
            }
        }
    }

    /**
     * Returns index of an item in the inventory 
     * @param item to check index for 
     * @return int index of item 
     */
    public int getItemIndex(Item item) { 
        return this.inventory.indexOf(item); 
    }

    /**
     * Accesor for inventory
     * @return inventory of the room
     */
    public ArrayList<Item> getInventory() { 
        return this.inventory; 
    }
    
    /**
     * Accessor for current room
     * @return currentRoom player is in 
     */
    public Room getCurrentRoom () { 
        return this.currentRoom; 
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
            return nameToItem.get("notInInventory"); 
        }
    }

    /**
     * Prints the inventory 
     */
    public void printInventory() { 
        System.out.println("\n ***YOUR INVENTORY***");
        for (int i=0; i< this.inventory.size(); i++) { 
            System.out.println(this.inventory.get(i).getName());
        }
    }

    /**
     * Manipulator for player's current Room
     * @param room that player's location will be set to
     */
    public void setCurrentRoom(Room room) { 
        this.currentRoom = room; 
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
    }

}
