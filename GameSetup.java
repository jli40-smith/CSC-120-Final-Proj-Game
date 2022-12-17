public class GameSetup { 
    /* Initializing all the rooms in the house */
    private Room outside = new Room("outside Elsie's House" + 
        "\n  /  / / / / /     /  / /" +
        "\n//  / / /  //  // /  // " +
        "\n//    /    /    / / / / /" +
        "\n/   /    // / /  // / // " +
        "\n / ///   /      /// / / /", "It is pouring outside, and you turn down the volume of the rain on your computer");
    private Room foyer = new Room("in the foyer"  +
        "\n     ╔═══   ═══╗"	+          
        "\n     ║         ║" +
        "\n     ║         ║" +
        "\n     ╚═══   ═══╝", "A room for receiving guests, not that Elsie would have had too many in her last days");
    private Room diningRoom = new Room("in the dining room" + 
        "\n   ╔═════   ═════╗" +	          
        "\n   ║             ║" + 
        "\n   ║             ║" +
        "\n                  " +
        "\n   ║             ║" +
        "\n   ║             ║" +
        "\n   ╚═════   ═════╝" , "There are 3 chairs around a table set for one"); 
    private Room bathroom = new Room("in the bathroom" + 
        "\n ╔══════╗" +	          
        "\n ║      ║" +
        "\n        ║" +
        "\n ║      ║" +
        "\n ╚══════╝", "A claustrophobic space with tan tiles, you'd have to duck to wash your hands"); 
    private Room kitchen = new Room("in the kitchen" + 
        "\n ╔═══════════╗" +           
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ║            " +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ╚════   ════╝", "You immediately notice the peeling paisley wallpaper and sooty ceiling corners" ); 
    private Room bedroom = new Room("in the bedroom" + 
        "\n ╔════   ════╗" +	          
        "\n ║           ║" +
        "\n ║           ║" +      
        "\n              " +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ╚═══════════╝", "The bed is made, and you can tell that the room was photographed for the model at midday \n It looks like someone has broken off enough of the blinds to create a hole in the lower left corner of the blinds"); 
    private Room livingRoom = new Room("in the living room" + 
        "\n   ╔═════   ═════════════╗" + 
        "\n   ║                     ║" +
        "\n   ║                     ║" +
        "\n                         ║" +
        "\n   ║                     ║" +
        "\n   ║                     ║" +
        "\n   ╚═════════════════════╝", "The walls are yellow, but you notice white rectangles with holes where pictures used to hang. There is a pile of shrink-wrapped egg cartons in the corner \n Plastic bags and magazine clippings completely obscure the coffee table from view "); 
    private Room sunroom = new Room("in the sunroom" + 
        "\n ╔═══════╗" +	          
        "\n ║       ║" +
        "\n ║       ║" +
        "\n ║       ║" +
        "\n ║       ║" +
        "\n ║       ║" +
        "\n ║        " +
        "\n ║       ║" +
        "\n ║       ║" +
        "\n ╚═══════╝", "A room with large glass windows, stacks of shelves, and bags of potting soil. You turn your screen brightness down, and notice that there are no plants");  
        
        /* Initializing items*/
        Item boots = new Item("boots", "black rubber boots with grass crusted on the heels");
        Item ad = new Item("magazine", "It reads: \n 25 CLASSIC CHRISTMAS RECIPES \n 50 GIFTS under $50 \n 10 SLIMMING CROCKPOT RECIPES"); 

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
        bedroom.addRoomExit("WEST", sunroom);

        livingRoom.addRoomExit("WEST", bedroom);
        livingRoom.addRoomExit("NORTH", diningRoom);

        sunroom.addRoomExit("EAST", bedroom);

        intern.setCurrentRoom(outside); //Sets the initial location of the Player

        /* Adding items to each room of the house */
        foyer.addItem(ad); 
        foyer.addItem(boots); 
    }
    public static void main(String[] args) {

    }

}