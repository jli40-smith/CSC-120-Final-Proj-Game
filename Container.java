import java.util.ArrayList;

public class Container extends Item {
    private ArrayList<Item> contents = new ArrayList<Item>(); 
    public Container(String name, String descrip, ArrayList contents) { 
        super(name, descrip); 
        this.contents = contents; 
    }
}
