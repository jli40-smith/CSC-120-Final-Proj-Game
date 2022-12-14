import java.util.ArrayList;
/**
 * Sets up the game's items, player, and rooms
 */
public class GameSetup { 
    /* Initializing Rooms*/
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
        "\n     ╚═══   ═══╝", "A room for receiving guests");
    private Room diningRoom = new Room("in the dining room" + 
        "\n   ╔═════   ═════╗" +	          
        "\n   ║             ║" + 
        "\n   ║             ║" +
        "\n                  " +
        "\n   ║             ║" +
        "\n   ║             ║" +
        "\n   ╚═════   ═════╝" , "There are 3 chairs around a table set for one. \n There's a lot on the table", true, "This house is located on _ _ _ _ Street", "pike"); 
    private Room bathroom = new Room("in the bathroom" + 
        "\n ╔══════╗" +	          
        "\n ║      ║" +
        "\n        ║" +
        "\n ║      ║" +
        "\n ╚══════╝", "A claustrophobic but clean space with blue floral tiles", true, "How many books were there in all the OTHER rooms of the house?", "16"); 
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
        "\n ╚════   ════╝", "You immediately notice the peeling paisley wallpaper, and notice food on the counter", true, "What was my maiden name?", "prentice" ); 
    private Room bedroom = new Room("in the bedroom" + 
        "\n ╔════   ════╗" +	          
        "\n ║           ║" +
        "\n ║           ║" +      
        "\n              " +
        "\n ║           ║" +
        "\n ║           ║" +
        "\n ╚═══════════╝", "The bed is made, and you look at the shelf next to the window", true, "I became an editor, but my husband Mark worked as an:", "actuary"); 
    private Room livingRoom = new Room("in the living room" + 
        "\n   ╔═════   ═════════════╗" + 
        "\n   ║                     ║" +
        "\n   ║                     ║" +
        "\n                         ║" +
        "\n   ║                     ║" +
        "\n   ║                     ║" +
        "\n   ╚═════════════════════╝", "There is a sofa and a little coffee table"); 
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
        "\n ╚═══════╝", "A room with large glass windows, stacks of shelves, and bags of potting soil", true, "I moved into this house the same year I got my Masters degree. I was 29. \n When my husband finally moved out and we changed our address, how old was I?", "56");  
    private Room msgRoom = new Room("in the MESSAGE room. Type OPEN TRANSMISSON to send JANET what you think are the banned books whenever you are ready", "***"); 
    
    /* Initializing non-book items */
        Item mail = new Item("mail", "░░█░░░███░░░█░░" + 
            "\n░█░█░░█░█░░█░█░" + 
            "\n░███░░█░█░░███░" +
            "\n░█░█░░███░░█░█░" + 
            "\n M. Lowell \n 193 E Pike St \n Lawrenceville \n Georgia 30046"); 
        Item boots = new Item("boots", "There is grass crusted to the heels of both boots");
        Item mag = new Item("magazine", "It reads: \n 25 CLASSIC CHRISTMAS RECIPES \n 50 GIFTS under $50 \n 10 SLIMMING CROCKPOT RECIPES TO COOK FOR THE FAMILY"); 
        Item card = new Item("card", "It probably fell out of the magazine: \n REQUEST RECEIVED: Congrats on the move! We have updated your address in our records, and will begin mailing to your new address 05-08-2047"); 
        Item photo = new Item("album", "It was lying open on the table. \n One person with long brown hair seems to appear in all of the photos"); 
        Item razor = new Item("razor", "A blue plastic razor"); 
        Item chisel = new Item("chisel", "A sharp rectangular tool with edges on both sides"); 
        Item diploma = new Item("diploma", "Master of the Arts \n in Philosophy \n Awarded to E. Lowell \n June 5th, 2018"); 
        Item holidayCard = new Item("holiday_card", "It reads: Wishing you a Merry Christmas! \n Mom, I couldn't make it again this year because of a conference, but we got you that gift off your list! \n Please brew your favorite blends with the new machine and enjoy your retirement :) \n - Love, Janet L"); 
        Item jewelryBox = new Item("silver_box", "It contains: \n Earrings, two tangled chain necklaces, a gold ring with E engraved on it"); 
        Item ring = new Item("ring", "A gold ring with M engraved on it"); 
        Item gnome = new Item("wood_block", "A wooden block which has been partially formed into a man with a pointy hat"); 
        Item cableNeedle = new Item("bent_hook", "A thick plastic needle with a bend in it and two tapered ends"); 
        Item stitchHolder = new Item("pin", "What seems to be a giant safety pin, but it's not very sharp"); 
        Item yarnLabel= new Item("label", "It was torn off from something: \n Net Weight 25oz \n Cerulean Blue Lot A267 \n Super Bulky \n 100% Wool "); 
        Item brochure = new Item("brochure", "Dear Mark, Extend your membership in the Association of Actuaries Today!\n Platinum Member Benefits: \n Contact a global network of professionals in 56 countries and..."); 
        Item espressoMaker = new Item("espresso_machine", "It's in a cardboard box and you can't see inside\n But it says espresso machine on the packaging"); 
        Item clipping = new Item("news_clipping", "Nathaniel Hawthorne High School Post : Under a photo of a smiling girl with blonde hair and tortoiseshell glasses, it reads: \n ...Outside of school, Miss. E Prentice performs in the Heron Street Community Theatre and is studying Spanish on a quest to read all of the world's greatest works \n Our next senior..."); 
        Item coffeePot = new Item("coffee_pot", "A metal pot with a long attached handle"); 
        
        /* Initalizing the 8 requested books*/
        Item achebe = new Item("yam", "Things Fall Apart by Chinua Achebe"); 
        Item cervantes = new Item("bag_of_oats", "SEGVNDA PARTE \n DEL INGENIOSO CAVALLERO DON \n QVIXOTE DE LA MANCHA \n Miguel de Cervantes"); 
        Item dostoyevsky = new Item("socks", "Crime and Punishment by Fyodor Dostoyevsky"); 
        Item hurston = new Item("collar", "Their Eyes Were Watching God by Zora Neal Hurston"); 
        Item kafka = new Item("cockroach", "The Metamorphosis by Franz Kafka"); 
        Item machiavelli = new Item("lamp", "The Prince by Niccolo Machiavelli"); 
        Item shikibu = new Item("flower_vase", "The Tale of Genji by Murasaki Shikibu"); 
        Item sophocles = new Item("doll", "Antigone by Sophocles"); 
        
        /* Decoy books */
        Item bk0 = new Item("bird_statue", "GOING SOLO - \n Living Alone and Liking It"); 
        Item bk1 = new Item("shoe_rack", "They Both Die at the End by Adam Silvera"); 
        Item bk2 = new Item("potting_soil", "The Brothers Karamazov by Fyodor Dostoyevsky"); 
        Item bk3 = new Item("decanter", "The Oedipus Cycle by Sophocles"); 
        Item bk4 = new Item("fertilizer", "Kokoro by Natsume Sōseki"); 
        Item bk5 = new Item("whisk", "Metamorphoses by Ovid"); 
        Item bk6 = new Item("microwave", "Cien años de soledad \n Gabriel García Márquez"); 
        Item bk7 = new Item("wallet", "The Wealth of Nations by Adam Smith"); 
        Item bk8 = new Item("potpourri", "The Trial by Franz Kafka"); 
        Item bk9 = new Item("trophy", "How to Win Friends & Influence People by Dale Carnegie"); 
        Item bk10 = new Item("ottoman", "Masterpieces of Irish Crochet Lace edited by Thérèse de Dillmont"); 
        Item bk11 = new Item("houseplant", "Financial Mathematics, 5th Edition"); 

    /*Initalizing list of 8 correct books*/
    ArrayList<Item> correctBooks = new ArrayList<Item>(); 
    
    /* Initialzing player */
    private Player intern; 
    
    /**
     * Constructor for GameSetup
     * @param Player the player character 
     */
    public GameSetup(Player intern) { 
        this.intern = intern; 
    }

/**
 * Adds items to rooms, adds exit connections to Rooms 
 */
    public void setUpGame() { 
        /* Placing the required books into the rooms*/
         diningRoom.addItem(achebe);
         kitchen.addItem(cervantes);
         bathroom.addItem(dostoyevsky);
         livingRoom.addItem(hurston);
         sunroom.addItem(kafka);
         bedroom.addItem(machiavelli);
         sunroom.addItem(shikibu);
         sunroom.addItem(sophocles);

        /* ITEM PLACEMENT */
        /*  This means that the correct list to submit to Janet contains: 
            yam, bag_of_oats, socks, collar, cockroach, lamp, flower_vase, doll */
        correctBooks.add(achebe);
        correctBooks.add(cervantes);
        correctBooks.add(dostoyevsky);
        correctBooks.add(hurston);
        correctBooks.add(kafka);
        correctBooks.add(machiavelli);
        correctBooks.add(shikibu);
        correctBooks.add(sophocles);

        /* Adding items to each room of the house */
        outside.addItem(mail);

        foyer.addItem(mag); 
        foyer.addItem(boots); 
        foyer.addItem(card);
        foyer.addItem(espressoMaker);
        foyer.addItem(bk1);
        
        bathroom.addItem(razor);
        bathroom.addItem(ring);
        bathroom.addItem(bk8);
        bathroom.addItem(bk0);
        
        livingRoom.addItem(chisel);
        livingRoom.addItem(diploma);
        livingRoom.addItem(gnome);
        livingRoom.addItem(clipping);
        livingRoom.addItem(bk7);
        livingRoom.addItem(bk10);
        
        bedroom.addItem(holidayCard);
        bedroom.addItem(jewelryBox);
        bedroom.addItem(yarnLabel);
        
        kitchen.addItem(coffeePot);
        kitchen.addItem(bk3);
        kitchen.addItem(bk5);
        kitchen.addItem(bk6);
        
        diningRoom.addItem(photo);
        diningRoom.addItem(stitchHolder);
        diningRoom.addItem(cableNeedle);
        diningRoom.addItem(brochure);
        diningRoom.addItem(bk9);

        sunroom.addItem(bk2);
        sunroom.addItem(bk4);
        sunroom.addItem(bk11);

        /* ROOM/LOCATION SETUP */
        intern.setCurrentRoom(foyer); //Sets the initial location of the Player
        
        /* Setting up exits to each Room */
        msgRoom.addRoomExit("SOUTH", outside);
        outside.addRoomExit("NORTH", msgRoom);
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
    }

    /* Checks if books submitted to Janet are right */ // Source [6]
        public boolean verifyBooks(){ 
            if (intern.getInventory().containsAll(correctBooks) && correctBooks.containsAll(intern.getInventory())) { 
                return true; 
            } else { 
                return false; 
            }
        }

    /** 
     * Unused main method
     * @param String[] args - unused 
     */
    public static void main(String[] args) {
    }

}