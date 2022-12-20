import java.util.ArrayList;

public class GameSetup { 
    /* Initializing all the rooms in the house */
    private Room outside = new Room("outside Elsie's House" + 
        "\n  /  / / / / /     /  / /" +
        "\n//  / / /  //  // /  // " +
        "\n//    /    /    / / / / /" +
        "\n/   /    // / /  // / // " +
        "\n / ///   /      /// / / /", "It is pouring outside, and you turn down the volume of the rain on your computer. There is an open door to the south of you");
    private Room foyer = new Room("in the foyer"  +
        "\n     ╔═══   ═══╗"	+          
        "\n     ║         ║" +
        "\n     ║         ║" +
        "\n     ╚═══   ═══╝", "A room for receiving guests, not that the client would have had too many in their last days");
    private Room diningRoom = new Room("in the dining room" + 
        "\n   ╔═════   ═════╗" +	          
        "\n   ║             ║" + 
        "\n   ║             ║" +
        "\n                  " +
        "\n   ║             ║" +
        "\n   ║             ║" +
        "\n   ╚═════   ═════╝" , "There are 3 chairs around a table set for one", true, "This house is on _ _ _ _ Street", "pike"); 
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
    private Room msgRoomCorridor = new Room("approaching the MESSAGE ROOM. GO SOUTH to return to the virtual home model \n GO NORTH again to SEND JANET the books in your inventory \n You have one chance to get it right", " ");  
    private Room msgRoom = new Room("trying to send JANET what you think are the banned books \n Did you get them right?", "message room"); 
    
    /* Initializing items*/
        Item mail = new Item("mail", "░░█░░░███░░░█░░" + 
            "\n░█░█░░█░█░░█░█░" + 
            "\n░███░░█░█░░███░" +
            "\n░█░█░░███░░█░█░" + 
            "\n M. Lowell \n 193 E Pike St \n Lawrenceville \n Georgia 30046"); 
        Item boots = new Item("boots", "There is grass crusted to the heels of both boots; and a tag inside which reads IF FOUND, CALL with something scrawled underneath");
        Item mag = new Item("magazine", "It reads: \n 25 CLASSIC CHRISTMAS RECIPES \n 50 GIFTS under $50 \n 10 SLIMMING CROCKPOT RECIPES TO COOK FOR THE FAMILY"); 
        Item card = new Item("card", "It probably fell out of the magazine: \n REQUEST RECEIVED We have updated your address in our records, and will begin mailing to your new address 05-08-2047"); 
        Item photo = new Item("album", "It was lying open on the table. \n One person with long black hair seems to appear in all of the photos"); 
        Item razor = new Item("razor", "A blue plastic razor"); 
        Item chisel = new Item("chisel", "A sharp rectangular tool with edges on both sides"); 
        Item alighieri = new Item("lion_statue", "Divine Comedy by Dante Alighieri"); 
        Item cervantes = new Item("cookbook", "SEGVNDA PARTE \n DEL INGENIOSO CAVALLERO DON \n QVIXOTE DE LA MANCHA \n Miguel de Cervantes"); 
        Item machiavelli = new Item("yellow_book", "The Prince by Niccolo Machiavelli"); 
        Item dostoyevsky = new Item("gray_book", "Crime and Punishment by Fyodor Dostoyevsky"); 
        Item achebe = new Item("orange_book", "Things Fall Apart by Chinua Achebe"); 
        Item shikibu = new Item("purple_book", "The Tale of Genji by Murasaki Shikibu"); 
        Item diploma = new Item("diploma", "Bachelor of Arts \n Philosophy \n Awarded to E. Prentice"); 
        Item holidayCard = new Item("holiday_card", "It reads: Wishing you a Merry Christmas! \n Mom, I couldn't make it again this year because of a conference, but we got you that gift off your list! \n Please brew your favorite blends with the new machine and enjoy your retirement :) \n - Love, Janet "); 
        Item jewelryBox = new Item("silver_box", "It contains: \n Earrings, two tangled chain necklaces, a gold ring with E engraved on it"); 
        Item ring = new Item("ring", "A gold ring with M engraved on it"); 
        Item gnome = new Item("wood_block", "A wooden block which has been partially formed into a man with a pointy hat"); 
        Item bookS = new Item("sky_blue_book", "GOING SOLO - \n Living Alone and Liking It"); 
        Item cableNeedle = new Item("bent_hook", "A thick plastic needle with a bend in it and two tapered ends"); 
        Item stitchHolder = new Item("pin", "What seems to be a giant safety pin, but it's not very sharp"); 
        Item brochure = new Item("brochure", "Dear Mark, Extend your membership in the Association of Actuaries Today!\n Platinum Member Benefits: \n Contact a global network of professionals in 56 countries and..."); 
        Item yarnLabel= new Item("label", "It was torn off from something: \n Net Weight 25oz \n Cerulean Blue Lot A267 \n Super Bulky \n 100% Wool "); 
        Item espressoMaker = new Item("espresso_machine", "It's in a cardboard box and you can't see inside\n But it says espresso machine on the packaging"); 
        Item clipping = new Item("news_clipping", "Under a photo of a smiling girl with blonde hair and tortoiseshell glasses, it reads: \n ...Outside of school, Elsie performs in the Heron Street Community Theatre and is studying Spanish on a quest to read all of the world's greatest works \n Our next senior..."); 
        Item coffeePot = new Item("coffee_pot", "A metal pot with a long attached handle"); 
    
        /*Correct list of books to bring to the MESSAGE room  */
        ArrayList<Item> correctBooks = new ArrayList<Item>(); 

        /* Adding all items to a map where their String name can be used to access the object */
    private Player intern; 
    public GameSetup(Player intern) { 
        this.intern = intern; 
    }
    public void setUpGame() { 
        /* Setting up exits to each Room */
        msgRoomCorridor.addRoomExit("NORTH", msgRoom);
        msgRoomCorridor.addRoomExit("SOUTH", outside);
        outside.addRoomExit("NORTH", msgRoomCorridor);
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

        intern.setCurrentRoom(foyer); //Sets the initial location of the Player

        /* Adding decoy items to each room of the house */
        outside.addItem(mail);
        foyer.addItem(mag); 
        foyer.addItem(alighieri);
        foyer.addItem(boots); 
        foyer.addItem(card);
        diningRoom.addItem(photo);
        bathroom.addItem(razor);
        livingRoom.addItem(chisel);
        livingRoom.addItem(diploma);
        bedroom.addItem(holidayCard);
        bedroom.addItem(jewelryBox);
        bathroom.addItem(ring);
        livingRoom.addItem(gnome);
        diningRoom.addItem(stitchHolder);
        diningRoom.addItem(cableNeedle);
        bedroom.addItem(yarnLabel);
        diningRoom.addItem(brochure);
        foyer.addItem(espressoMaker);
        kitchen.addItem(coffeePot);
        bedroom.addItem(clipping);
        /* Adding books to the correct list you have to send to Janet*/
        correctBooks.add(alighieri); 
    }

    /* Checks if books are right */
        public boolean verifyBooks(){ 
            if (intern.getInventory().equals(correctBooks)) { 
                return true; 
            } else { 
                return false; 
            }
        }

    /* Rewrite */
        public ArrayList<Item> getCorrectBooks(){ 
            return this.correctBooks; 
        }
    public static void main(String[] args) {

    }

}