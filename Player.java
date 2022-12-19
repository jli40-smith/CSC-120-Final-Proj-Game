import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<Item> inventory = new ArrayList<Item>(); 

    public void grab(String itemName){ 
        Item itemToAdd = currentRoom.getItemFromName(itemName); 
        if (itemToAdd != currentRoom.getItemFromName("notInRoom")) { 
            int playerItemIndex = this.getItemIndex(itemToAdd); 
            if(playerItemIndex == -1) { //Checks that the player doesn't already have the item
                this.inventory.add(itemToAdd); 
                currentRoom.removeItem(itemToAdd);
            } else { 
                System.out.println("You already have that item");
            }
        } else {
            System.out.println("That item is not in the room");
        }
    }

//drop 
//examine 
//use 
    public void go(String direction) {
        currentRoom = currentRoom.getConnectedRoom(direction, currentRoom); 
        System.out.println("You are " + currentRoom.getName() + "\n You look around and see:");
        currentRoom.printInventory();
        if(currentRoom.newToPlayer) { 
            System.out.println(currentRoom.getDescrip());
            currentRoom.setNewtoPlayer(false);
        }
    }

    /* REWRITE */
    public int getItemIndex(Item item) { 
        return this.inventory.indexOf(item); 
    }

    public Room getCurrentRoom (Room currentRoom) { 
        return this.currentRoom; 
    }
    /* REWRITE */
    public void printInventory() { 
        System.out.println("\n ***PLAYER INVENTORY***");
        for (int i=0; i< this.inventory.size(); i++) { 
            System.out.println(this.inventory.get(i));
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
