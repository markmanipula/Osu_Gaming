package game;
import com.map.Map;

public class Player {

    //can't be changed so there's no setter
    private String name = "Jemad";
    private Direction direction;
    private String location;
    private Map map = new Map();

    //only uses a default constructor

    public String getName() {
        return name;
    }

    public void attack(){
        System.out.println(name + " attacks");

    }

    public void move(Direction direction){
        System.out.println(name + " goes " + direction.toString().toLowerCase());
    }


    //this is a test main
    public static void main(String[] args) {
        Player player = new Player();

        player.move(Direction.NORTH);

    }
}



