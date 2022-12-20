import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<Item> inventory = new ArrayList<Item>(); 
    private Map<String, Item> nameToItem = new HashMap<String, Item>(); 

    public void grab(String itemName){ 
        Item item = currentRoom.getItemFromName(itemName); 
        if (item != currentRoom.getItemFromName("notInRoom")) { 
                if (this.inventory.size() < 8) { 
                    int playerItemIndex = this.getItemIndex(item); 
                    if(playerItemIndex == -1) { //Checks that the player doesn't already have the item
                        this.inventory.add(item); 
                        this.nameToItem.put(item.getName(), item);
                        currentRoom.removeItem(item);
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

//drop 
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
//use 
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
