public class GameSetup { 
    Room outside = new Room("outside Elsie's House", "From the view on your screen, this digital model of Elsie's yellow stucco bungalow looks just like a real photo");
    Room foyer = new Room("in the foyer", "A room for receiving guests, not that Elsie would have had too many in her last days");
       
        public void setUpExits() { 
            outside.addRoomExit("SOUTH", foyer);
            foyer.addRoomExit("NORTH", outside );
        }
    public static void main(String[] args) {

    }

}