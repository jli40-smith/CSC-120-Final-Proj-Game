import java.util.Scanner;
import java.io.IOException;

public class Game{ //Source [1]
    public static void enterToContinue(String prompt) { //Source [2]
        System.out.println(prompt);
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) { 

        //Indicates when gameplay should end 
        boolean isPlaying = true;

        Scanner playerInput = new Scanner(System.in); 

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

    }
}