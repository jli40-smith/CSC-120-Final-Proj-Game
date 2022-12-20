import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<Item> inventory = new ArrayList<Item>(); 
    private Map<String, Item> nameToItem = new HashMap<String, Item>(); 
    private Item notInInventory= new Item("notInRoom", ""); //This Item is returned when the player tries to access an Item not in their inventory

    public Player() { 
        nameToItem.put("notInInventory", notInInventory); 
    }
    /*  */
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
    
    /*  */
    public void drop(String itemName){ 
        Item item = this.getItemFromName(itemName); 
        if (item != this.getItemFromName("notInInventory")) { 
            if (this.inventory.size() > 0) { 
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
            System.out.println("The room you are trying to enter is locked, you must enter a password for access");
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

    /* REWRITE */
    public int getItemIndex(Item item) { 
        return this.inventory.indexOf(item); 
    }

    /* REWRITE */
    public ArrayList<Item> getInventory() { 
        return this.inventory; 
    }

    public Room getCurrentRoom (Room currentRoom) { 
        return this.currentRoom; 
    }

    /* REWRITE */
    public Item getItemFromName(String itemName) { 
        if (nameToItem.containsKey(itemName)) { 
            return nameToItem.get(itemName); 
        } else { 
            return nameToItem.get("notInInventory"); 
        }
    }

    /* REWRITE */
    public void printInventory() { 
        System.out.println("\n ***YOUR INVENTORY***");
        for (int i=0; i< this.inventory.size(); i++) { 
            System.out.println(this.inventory.get(i).getName());
        }
    }

    /*REWRITE this changes the current location of the player */
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
