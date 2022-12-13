public class GameSetup { 
    private Room outside = new Room("outside Elsie's House", "From the view on your screen, this digital model of Elsie's yellow stucco bungalow looks just like a real photo");
    private Room foyer = new Room("in the foyer", "A room for receiving guests, not that Elsie would have had too many in her last days");
    private Room diningRoom = new Room("in the dining room", "There are 3 chairs around a table set for one"); 
    private Room bathroom = new Room("in the bathroom", "A claustrophobic space with tan tiles, you'd have to duck to wash your hands"); 
    private Room kitchen = new Room("in the kitchen", "You immediately notice the peeling paisley wallpaper and sooty ceiling corners" ); 
    private Room bedroom = new Room("in the bedroom", "The bed is made, and you can tell that the room was photographed for the model at midday \n It looks like someone has broken off enough of the blinds to create a hole in the lower left corner of the blinds"); 
    private Room livingRoom = new Room("in the living room", "The walls are yellow, but you notice white rectangles with holes where pictures used to hang. There is a pile of shrink-wrapped egg cartons in the corner \n Plastic bags and magazine clippings completely obscure the coffee table from view "); 
    private Room study = new Room("in the study", ""); 
    //private Room (); 

    private Player intern; 

    public GameSetup(Player intern) { 
        this.intern = intern; 
    }
    public void setUpGame() { 
        outside.addRoomExit("SOUTH", foyer);

        foyer.addRoomExit("NORTH", outside );
        foyer.addRoomExit("SOUTH", diningRoom); 

        diningRoom.addRoomExit("NORTH", foyer);
        diningRoom.addRoomExit("EAST", bathroom);
        diningRoom.addRoomExit("WEST", kitchen);
        diningRoom.addRoomExit("SOUTH", livingRoom);

        bathroom.addRoomExit("WEST", diningRoom);

        kitchen.addRoomExit("EAST", diningRoom);
        kitchen.addRoomExit("SOUTH", bedroom);

        bedroom.addRoomExit("NORTH", kitchen);
        bedroom.addRoomExit("EAST", livingRoom);

        livingRoom.addRoomExit("WEST", bedroom);
        livingRoom.addRoomExit("NORTH", diningRoom);

        intern.setCurrentRoom(outside); //Sets the initial location of the Player
    }
    public static void main(String[] args) {

    }

}