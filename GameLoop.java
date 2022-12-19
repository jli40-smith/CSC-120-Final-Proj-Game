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

        enterToContinue("Congratulations on advancing to the PERFORMANCE TASK STAGE of your application for the position of MIND UPLOADING DATA CLEANUP SPECIALIST."); 
        enterToContinue("This task tests your ability to extract vital client data from a virtual model of their last occupied residence");
        enterToContinue("As a part of our Strategy for Data Efficiency, you will be tasked with filling an abridged version of Form 4B, or the Life Essential Data Form, using details from the client's home");
        enterToContinue("With the completion of a Form 4B, all other superfluous details about a client, including the virtual home model, may be deleted, opening up space in our servers for our ever expanding customer base");
        enterToContinue("Our records show that this is not your first time attempting this exam");
        enterToContinue("If you need a refresher on instructions for navigate the virtual home system, type HELP into the console");
        enterToContinue("GOOD LUCK");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■xxxxxxx");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■■xxxxxx");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■■■■■■xx");
        enterToContinue("LOADING VIRTUAL HOME MODEL ■■■■■■■■");
*/
        System.out.println("You are " + intern.getCurrentRoom(null).getName());
        System.out.println(intern.getCurrentRoom(null).getDescrip());
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
                                    System.out.println("You tried to grab " + playerResponseParts[1]); 
                                    intern.grab(playerResponseParts[1]); 
                                    intern.printInventory();
                                }
                            break; 
                        case "look": 
                            if (playerResponseParts[1].length() != 0) { 
                                intern.look(playerResponseParts[1]); 
                            }
                            break; 
                        case "quit": 
                            System.out.println("You have ended the simulation");
                            isPlaying = false; 
                            break; 
                        default: 
                            System.out.println("No command selected");
                     }
                } else { 
                    System.out.println("Please enter 2 words: a command followed by one or more arguments. Type \"help\" for assistance"); 
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