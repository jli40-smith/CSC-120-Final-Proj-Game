import java.util.Scanner;
import java.util.ArrayList; 
import java.io.IOException;

public class GameRunner{ //Source [1]
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

        //Indicates when gameplay should end 
        boolean isPlaying = true;

        Scanner playerInput = new Scanner(System.in); 
        String playerResponse; 

        System.out.println(" ::::::::      :::     :::     ::: ::::::::::      ::::::::::: ::::::::       ::::    ::::  :::::::::: ::::    ::::   ::::::::  :::::::::  :::   :::");
        System.out.println(":+:    :+:   :+: :+:   :+:     :+: :+:                 :+:    :+:    :+:      +:+:+: :+:+:+ :+:        +:+:+: :+:+:+ :+:    :+: :+:    :+: :+:   :+:");  
        System.out.println("+:+         +:+   +:+  +:+     +:+ +:+                 +:+    +:+    +:+      +:+ +:+:+ +:+ +:+        +:+ +:+:+ +:+ +:+    +:+ +:+    +:+  +:+ +:+  ");  
        System.out.println("+:+         +:+   +:+  +:+     +:+ +:+                 +:+    +:+    +:+      +:+ +:+:+ +:+ +:+        +:+ +:+:+ +:+ +:+    +:+ +:+    +:+  +:+ +:+ ");  
        System.out.println("+#++:++#++ +#++:++#++: +#+     +:+ +#++:++#            +#+    +#+    +:+      +#+  +:+  +#+ +#++:++#   +#+  +:+  +#+ +#+    +:+ +#++:++#:    +#++:  ");  
        System.out.println("       +#+ +#+     +#+  +#+   +#+  +#+                 +#+    +#+    +#+      +#+       +#+ +#+        +#+       +#+ +#+    +#+ +#+    +#+    +#+   ");  
        System.out.println("#+#    #+# #+#     #+#   #+#+#+#   #+#                 #+#    #+#    #+#      #+#       #+# #+#        #+#       #+# #+#    #+# #+#    #+#    #+#   ");  
        System.out.println(" ########  ###     ###     ###     ##########          ###     ########       ###       ### ########## ###       ###  ########  ###    ###    ###   \n");  

        enterToContinue("Press ENTER to continue..."); 

        System.out.println("Congrats! \n");
        enterToContinue("NEXT...");
        //Rest of the exposition text goes here 
        //Some instructions on what to do next 

        do { 
            //Contents of the game/inputs are checked and matched to methods to be called 
            playerResponse = playerInput.nextLine().toLowerCase();
            String[] playerResponseParts = playerResponse.split(" ", 2);

            String verb = playerResponseParts[0];
                if (playerResponseParts.length == 2) {
                     switch (verb) {
                        case "go": 
                            System.out.println("Go command selected");
                            break; 
                        case "quit": 
                            System.out.println("You have ended the simulation");
                            isPlaying = false; 
                            break; 
                        default: 
                            System.out.println("No command selected");

                     }
                } else { 
                    System.out.println("I do not understand, please enter 2 words: a command followed by an object or direction"); 
                }
            }
        while (isPlaying);

            //conditions that check what verb it was 
            if (playerResponse.equals("STOP")) {
                System.out.println("This is the end");
        } 
    }

}