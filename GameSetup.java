public class GameSetup { 
    private Room outside = new Room("outside Elsie's House", "From the view on your screen, this digital model of Elsie's yellow stucco bungalow looks just like a real photo");
    private Room foyer = new Room("in the foyer", "A room for receiving guests, not that Elsie would have had too many in her last days");
    private Player intern; 

    public GameSetup(Player intern) { 
        this.intern = intern; 
    }
    public void setUpGame() { 
        outside.addRoomExit("SOUTH", foyer);
        foyer.addRoomExit("NORTH", outside );

        intern.setCurrentRoom(outside); //Sets the initial location of the Player
    }
    public static void main(String[] args) {

    }

}