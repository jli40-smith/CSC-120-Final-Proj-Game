import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    private Room currentRoom; //to point to room or a room ID assoc w a room?
    private ArrayList<Item> inventory = new ArrayList<Item>(); 

public void grab(Item item){ 
    int roomItemIndex = currentRoom.getItemIndex(item); 
    int playerItemIndex = this.getItemIndex(item); 
    if(roomItemIndex != -1 && playerItemIndex != 1) { //AND item index in the player invetory is not 1 
        this.inventory.add(item); 
        currentRoom.removeItem(item);
    }
}

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

    /* REWRITE */
    public int getItemIndex(Item item) { 
        return this.inventory.indexOf(item); 
    }

    /* REWRITE */
    public void printInventory() { 
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
