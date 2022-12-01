import java.util.*;
/**
 * Represents the player character
 */
public class Player {
    String name ;
    private int currentRoom = 1; 
    private ArrayList<String> inventory = new ArrayList<String>(); 
//RN it doesnt compile because I want to make the parts that used game before use the current ROOM
//instead...so yea it will not compile for now lmao

    /** 
     * Grabs and adds an item's name to the Player's inventory if it is in the allItems Hashtable
     * @param item String name of the item being grabbed 
     */
    public void grab(String item) { 
        if (game.allItems.containsKey(item)) {
            inventory.add(item); 
            System.out.println("You grabbed " + item);
        } else { 
            System.out.println("That item is not available");
        }
    }

    /** 
     * Drops an item and removes its name from the Player's inventory if it is in the inventory
     * @param item name of the item being dropped 
     * @return String name of the dropped item 
     */
    public String drop(String item) { 
        if (inventory.contains(item)) { 
            inventory.remove(item);
            System.out.println("You dropped " + item);
            return item;
        } else {
            System.out.println("You cannot drop an item you do not own");
            return item; 
        }
    }

    /**
     * Allows player to examine an Item by printing out an item's description 
     * @param item which is to be examined 
     */
    public void examine(String item) { 
        if (game.allItems.containsKey(item)) {
            System.out.println((game.allItems.get(item)));
        } else { 
            System.out.println("That item is not available");
        }
    }
    
    /**
     * Uses an Item and removes it from the Player's inventory if it is in the Player's inventory, 
     * @param item to be used 
     */
    public void use(String item) { 
        if (inventory.contains(item)) { 
            this.drop(item);
            //game.allItems.remove(item); //causes problems because items picked up again won't be able to be examined
            System.out.println("You have used " + item);
        } else {
            System.out.println("You cannot use an item you don't possess");
        }
    }

    /**
     * Allows a Player to walk left and right through 
     * @param direction String representing the direction the Player wants to walk 
     * @return boolean showing whether or not the Player was able to walk to another room in the specified direction
     */
    public boolean walk(String direction) { 
        direction = direction.toLowerCase(); 
        if (direction.equals("left"))  { 
            currentRoom -= 1; 
        } else if (direction.equals("right")) {
            currentRoom += 1;
        }

        if (currentRoom > game.minRoom && currentRoom < game.maxRoom) {
            System.out.println("You have walked " + direction + " to Room " + currentRoom);
            return true; 
        } else {
            System.out.println("There is no other room to the " + direction + " of this one");
            return false; 
        }
    }

    /**
     * Main method for testing 
     * @param args Array for command line arguments which is not currently being used  
     */
    public static void main(String[] args) {
        Game myGame = new Game(); 

        //Testing the allItems hashtable
        Item apple = new Item("apple", "A nutritious red fruit", true, false); 
        myGame.allItems.put("apple", apple);

        //Testing item grab, drop, undo, and examine methods 
        Player playerOne = new Player(myGame); 
        playerOne.grab("apple"); 
        //playerOne.use("apple"); //This works 
        playerOne.examine("apple");
        playerOne.drop("apple"); 
        playerOne.examine("apple");
        playerOne.use("apple");

        //Testing walk 
        playerOne.walk("left"); 
        playerOne.walk("left"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
        playerOne.walk("right"); 
    }

}
