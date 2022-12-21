# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 -                  Design justification (including a brief discussion of at least one alternative you considered)
 -                  A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
    My overall approach was to focus on the type of game I wanted to make, and go from there to find out which Java tools or object oriented programming techniques would apply to my goals. I figured that I had to build a Game Loop or some kind of engine to run the game in a loop and take in player commands, a setup class which stores the relationships between Rooms and Rooms, and Items and Rooms. After that, player, item, and room classes with their specific attributes and methods would run the game. I used these ideas to design my classes. 

 - What **new thing(s)** did you learn / figure out in completing this project?
    I learned how to write more complicated pseudocode and how to make myself understand interactions across a lot of classes. I also gained a better understanding of static vs nonstatic methods and how to circumvent those errors the right way by changing the way I called a method or the class where I call it (and not making more things static, which I did not usually do, but was tempted to do). Third, I learned about planning a longer term project and how to break down a huge task into smaller bits, and motivate myself through ruts and errors. 

 - Is there anything that you wish you had **implemented differently**?
    I wished that I could implement a method which allowed players to directly guess which books fit each given requirement or hint, but that class was simply too hard for me to write in the time that I had. I also wish that I wrote a parent class for Room and Player, as they share many methods and attributes, and that could make my code more parsimonious and readable. I also wish that I could have made a separate class which stored all the long/multi-line text which prints out to the console. Currently, this text is all stored in the same classes that contain code for the game, and it makes the code files less readable/much longer.

 - If you had **unlimited time**, what additional features would you implement?
    I would add container items which can hold other items which can also be locked and unlocked by other items. I would also add rooms which require a key/item to be unlocked, (all locked rooms currently ask for passwords). I would add more ASCII art to the game to improve visuals. I would print blocks of text line by line from a file instead of writing those lines into the code itself. 

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
    Professor Crouser said each Player should only operate on the room they are currently located in. This was very helpful, as it eliminated the need for additional error checking in case players tried to interact with items located in rooms they did not yet unlock or rooms they are not currently located in. 

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
    I would give myself the advice to write the Javadoc for a method every time I wrote and finalized them. Second, I would hint at trying to work on the project a little bit every time I opened it, and to not give myself pressure to make major progress every time I started working. I would also recommend implementing each new change in a new branch so that it's easier to revert changes which cause errors that are very hard to fix. 

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
    I worked alone.
 
REFERENCES
Source [1] https://smith.enterprise.slack.com/files/U3ZF37THD/F04DEF7T3L0/gameloop.java
    Slack code for GameLoop by Prof. Jordan Crouser 
Source [2] https://stackoverflow.com/questions/26184409/java-console-prompt-for-enter-input-before-moving-on 
    Code for press enter to continue was taken from Stack Overflow thread 
Source [3] https://manytools.org/hacker-tools/ascii-banner/
    ASCII Banner generator used for title screen text 
Source [4] https://stackoverflow.com/questions/23324903/going-through-rooms-in-a-text-based-game-in-java
    Got ideas about how to implement Rooms that a player can move through using the cardinal directions 
Source [5] https://www.codersarts.com/post/java-sample-project-1-text-adventure-game
    Got ideas about design and the idea to make a GameSetup class, but didn't use their code 
Source [6] https://stackoverflow.com/questions/13501142/java-arraylist-how-can-i-tell-if-two-lists-are-equal-order-not-mattering
    Got idea for how to check 2 arraylists have the same elements, ignoring the order of the elements. I loved how simple the solution was

IMAGE CREDITS
[1] https://thispersondoesnotexist.com/ was used to generate portraits of Elsie and her family members; the creator of the site 
    allows the reuse of their AI-generated images, as AI-generated works cannot be copyrighted  
[2] https://asciiart.club/ was used to convert images to ASCII art 