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
            playerResponse = playerInput.nextLine().toUpperCase();
            
            //conditions that check what verb it was 


        }

    }
}