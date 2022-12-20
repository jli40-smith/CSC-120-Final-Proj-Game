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
        enterToContinue("Once you have filled your inventory with nothing else but the 8 books, go NORTH 3 times from the foyer to reach the MESSAGE room and send them to me with OPEN TRANSMISSION");
        enterToContinue("I will only have one chance to copy the files from your inventory as soon as you type OPEN TRANSMISSION in the MESSAGE room, so please double check before you contact me!");
        enterToContinue("If you need to reread these directions, need a refresher on how to navigate the virtual home system type HELP into the console");
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
                                System.out.println("You reached for " + playerResponseParts[1]); 
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
                                System.out.println("cheatsheet goes here!");
                            } else if (playerResponseParts[1].equals("transmission")) { 
                                if (intern.getCurrentRoom(null).getDescrip().equals("message room")) { 
                                    if (newGame.verifyBooks()) { 
                                        System.out.println("Success! \n NEW MESSAGE \n Thank you!");
                                        isPlaying = false; 
                                    } else {
                                        System.out.println("You did not give Janet the right items... Those books may never be saved for posterity");
                                    }
                                    } else { 
                                    System.out.println("You can only transmit messages in the MESSAGE room");
                                }
                            }
                            break; 
                        case "quit": 
                            System.out.println("You have exited the home model");
                            isPlaying = false; 
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