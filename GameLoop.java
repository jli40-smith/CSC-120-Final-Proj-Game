import java.util.Scanner;
import java.util.ArrayList; 
import java.io.IOException;

public class GameLoop{ //Source [1]
    /* Displays text which will print and requires the user to press enter before the game continues to run*/
    public static void enterToContinue(String prompt) { //Source [2]
        System.out.println(prompt);
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*Runs the game*/
    public static void main(String[] args) { 
        /* Sets up the Player and all of the rooms of the game along with their contents and exit connections */
        Player intern = new Player(); 
        GameSetup newGame = new GameSetup(intern); 
        newGame.setUpGame(); 
        

        //Indicates when gameplay should end 
        boolean isPlaying = true;

        Scanner playerInput = new Scanner(System.in); 
        String playerResponse; 
/* 
        System.out.println(" ::::::::      :::     :::     ::: ::::::::::      ::::::::::: ::::::::       ::::    ::::  :::::::::: ::::    ::::   ::::::::  :::::::::  :::   :::");
        System.out.println(":+:    :+:   :+: :+:   :+:     :+: :+:                 :+:    :+:    :+:      +:+:+: :+:+:+ :+:        +:+:+: :+:+:+ :+:    :+: :+:    :+: :+:   :+:");  
        System.out.println("+:+         +:+   +:+  +:+     +:+ +:+                 +:+    +:+    +:+      +:+ +:+:+ +:+ +:+        +:+ +:+:+ +:+ +:+    +:+ +:+    +:+  +:+ +:+  ");  
        System.out.println("+:+         +:+   +:+  +:+     +:+ +:+                 +:+    +:+    +:+      +:+ +:+:+ +:+ +:+        +:+ +:+:+ +:+ +:+    +:+ +:+    +:+  +:+ +:+ ");  
        System.out.println("+#++:++#++ +#++:++#++: +#+     +:+ +#++:++#            +#+    +#+    +:+      +#+  +:+  +#+ +#++:++#   +#+  +:+  +#+ +#+    +:+ +#++:++#:    +#++:  ");  
        System.out.println("       +#+ +#+     +#+  +#+   +#+  +#+                 +#+    +#+    +#+      +#+       +#+ +#+        +#+       +#+ +#+    +#+ +#+    +#+    +#+   ");  
        System.out.println("#+#    #+# #+#     #+#   #+#+#+#   #+#                 #+#    #+#    #+#      #+#       #+# #+#        #+#       #+# #+#    #+# #+#    #+#    #+#   ");  
        System.out.println(" ########  ###     ###     ###     ##########          ###     ########       ###       ### ########## ###       ###  ########  ###    ###    ###   \n");  
*/

/* 
        // Exposition and Instructions 
        enterToContinue("Press ENTER to continue..."); 

        enterToContinue("I hope this letter reaches you before everything we have left is deleted");
        enterToContinue("You must be the intern working at the mind uploading company which has stored my mother's information");
        enterToContinue("You have access to a virtual model of her home which contains digital records of her possessions, the rooms in her house, and more");
        enterToContinue("My mother lived before the country-wide literature ban, and her home model is one of the last places where you can find copies of now forbidden books");
        enterToContinue("While I cannot directly give you the books' titles, I have given you a list of hints for every one of the 8 SPECIFIC titles you must recover");
        enterToContinue("You might encounter other books in your search, but I only want those on the list");
        enterToContinue("Type LOOK REFERENCE to check that reference list");
        enterToContinue("Please GRAB each of the banned books you find and store them in your inventory");
        enterToContinue("Once you have filled your inventory with nothing else but the 8 books, go NORTH 2 times from the foyer to reach the MESSAGE room and send them to me with OPEN TRANSMISSION");
        enterToContinue("I will only have one chance to copy the files from your inventory as soon as you type OPEN TRANSMISSION in the MESSAGE room, so please double check before you contact me!");
        enterToContinue("If you need to reread these directions, need a refresher on how to navigate the virtual home system type OPEN HELP into the console");
        enterToContinue("GOOD LUCK - Janet");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■0000000");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■■■■■■00");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■■■■■■■■");
*/
        System.out.println("\n You are " + intern.getCurrentRoom(null).getName());
        System.out.println(intern.getCurrentRoom(null).getDescrip());
        intern.getCurrentRoom(null).printInventory(); 
        
        /*Game loop begins */
        do { 
            //Contents of the game/inputs are checked and matched to methods to be called 
            playerResponse = playerInput.nextLine().toLowerCase() + " ";
            String[] playerResponseParts = playerResponse.split(" ");

            
            /*Executes nest switch cases based on the command entered by player, or the first word in playerResponse */
                if (playerResponseParts.length >= 2 ) {
                     switch (playerResponseParts[0]) {
                        case "go": 
                                switch ( playerResponseParts[1]){
                                    case "n": 
                                        System.out.println("\n You went north");
                                        intern.go("NORTH");
                                        break; 
                                    case "s": 
                                        System.out.println("\n You went south");
                                        intern.go("SOUTH");
                                        break; 
                                    case "e": 
                                        System.out.println("\n You went east");
                                        intern.go("EAST");
                                        break; 
                                    case "w": 
                                        System.out.println("\n You went west");
                                        intern.go("WEST");
                                        break; 
                                }
                            break; 
                        case "grab": 
                                if (playerResponseParts[1].length() != 0) { 
                                    System.out.println("You reached for the " + playerResponseParts[1]); 
                                    intern.grab(playerResponseParts[1]); 
                                    intern.printInventory();
                                }
                            break; 
                        case "drop": 
                            if (playerResponseParts[1].length() != 0) { 
                                System.out.println("You tried to drop " + playerResponseParts[1]); 
                                intern.drop(playerResponseParts[1]); 
                                intern.printInventory();
                            }
                        break; 
                        case "look": 
                            if (playerResponseParts[1].equals("inventory")) { 
                                intern.printInventory();
                            } else if (playerResponseParts[1].equals("room")) { 
                                System.out.println("\n You look around and see:");
                                intern.getCurrentRoom(null).printInventory();
                            } else if (playerResponseParts[1].length() != 0) { 
                                intern.look(playerResponseParts[1]); 
                            }
                            break; 
                        case "open":
                            if (playerResponseParts[1].equals("help")) { 
                                System.out.println("***COMMANDS***" +
                                "\n**(General Commands- type them verbatim to use)**" +
                                "\n open help - shows list of available commands and tips on how to use them" + 
                                "\n open list - shows information about the 8 books Janet wants you to find, and how to send them to her" + 
                                "\n open transmission - (ONLY works in MESSAGE ROOM) sends your inventory to Janet for verification" +
                                "\n look inventory - shows your inventory" +
                                "\n look room- shows the inventory of the current room" +
                                "\n exit house - quits the game" + 
                                "\n **(Specific Commands- must be followed by specific direction or item)**" +
                                "\n go n/e/s/w - moves you in a cardinal direction" + 
                                "\n     ex: go s" +
                                "\n grab item - adds item to your  inventory. You can have at most 8 items in your inventory" + 
                                "\n     ex: grab magazine" +
                                "\n drop item - drops item from your  inventory" + 
                                "\n     ex: drop magazine" +
                                "\n look item - shows description of the item in the room or in your inventory" +  
                                "\n     ex: look list" +
                                "\n **Passwords**" +
                                "\n My mother has locked some rooms with a password. Unfortunately, she never told me what they are" +
                                "\n If you look carefully around the virtual home model, you might be able to find the answers");
                            } else if (playerResponseParts[1].equals("list")){
                                System.out.println("**Notes on the 8 books**" +
                                "\n> A Russian novel in which a poor college student commits a murder and succumbs to the guilt" +
                                "\n> Written in the Heian period, this courtier's eponymous story is about the romance and problems in his life" +   
                                "\n> About a man from a province in Spain who reads too many novels, and deludes himself into thinking that he is a knight-errant" +
                                "\n> About a man who changes into a 'monstrous vermin' one morning, and just has to live with that fact" +
                                "\n> The title refers to the fact that, in the end, everything just goes downhill..." +
                                "\n> This girl's eponymous play is a Greek tragedy. Even though the title is short, her family's history of suffering is not" +
                                "\n> A book about how to acquire power and keep it. From the title, you can obviously tell who the book was written for" +
                                "\n> The title completes this famous line: 'They seemed to be staring at the dark, but...'" +
                                "\n**How to Send Books to Janet**" +
                                "\n1. type OPEN LIST" +
                                "\n2. Grab all 8 books and have them in your inventory" +
                                "\n3. Go north from the foyer to go outside of the house, and then go north again to the MESSAGE room" +
                                "\n4. Type OPEN TRANSMISSION");
                            } else if (playerResponseParts[1].equals("transmission")) { 
                                if (intern.getCurrentRoom(null).getDescrip().equals("***")) { 
                                    if (newGame.verifyBooks()) { 
                                        enterToContinue("NEW MESSAGE:");
                                        enterToContinue("I have received your files");
                                        enterToContinue("You have recovered all the correct books");
                                        enterToContinue("We owe you a lot");
                                        enterToContinue("A 4 digit sum will be wired to you for your hard work");
                                        enterToContinue("More importantly, know that posterity will thank you for saving these books...");
                                        isPlaying = false; 
                                    } else {
                                        enterToContinue("NEW MESSAGE:");
                                        enterToContinue("I have received your files");
                                        enterToContinue("You did not recover the correct books");
                                        enterToContinue("Keep going SOUTH if you want to try again, or EXIT HOUSE to give up");
                                    }
                                    } else { 
                                    System.out.println("You can only transmit messages in the MESSAGE room");
                                }
                            }
                            break; 
                        case "exit": 
                            if (playerResponseParts[1].equals("house")){
                                System.out.println("You have exited the home model");
                                enterToContinue("NEW MESSAGE:");
                                enterToContinue("I had faith in you");
                                enterToContinue("But maybe we were wrong to put you under so much pressure...");
                                enterToContinue("Goodbye");
                                isPlaying = false; 
                            }
                            break; 
                        default: 
                            System.out.println("No command selected");
                     }
                } else { 
                    System.out.println("Please enter 2 words: a command followed by one or more arguments. Type \"open help\" for assistance"); 
                }
            }
        while (isPlaying);
            //conditions that check what verb it was 
            if (playerResponse.equals("STOP")) {
                playerInput.close(); 
                System.out.println("This is the end");
        } 
    }

}