public class GameSetup { 
    Room outside = new Room("outside Elsie's House", "From the view on your screen, this digital model of Elsie's yellow stucco bungalow looks just like a real photo");
    Room foyer = new Room("in the foyer", "A room for receiving guests, not that Elsie would have had many visitor in her last days");
        public void startGame() { 
            outside.addRoomExit("NORTH", foyer); //does not compile because i cannot put this enum into the Map exits
        }
    public static void main(String[] args) {

    }

}