import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*String sonalineMuutuja = "Sõnaline muutuja";
        double komakohaga = 4212.231314;
        float komakohaga2 = 313.123132F;
        boolean kahendVaartus = true;
        byte pisikeNumber = 100;
        short luhikeNumber = 312;
        long pikkNumber = 4124121241412412L;*/

        /*saab kasutajalt sisendit küsida*/
        Scanner scanner = new Scanner(System.in);
        /*küsib konsoolist*/

        World world = new World(10,5);

        Player player = new Player(world.width, world.height);
        Dragon dragon = new Dragon(world.width, world.height);
        Orc orc = new Orc(world.width, world.height);

        Item sword = new Item(10, 1, "Mõõk", world.width, world.height);
        Item hammer = new Item(5, 3, "Haamer", world.width, world.height);

        Item boot = new Item(1, 10, "Saabas", world.width, world.height);

        List<Item> items = new ArrayList<>(Arrays.asList(sword, hammer, boot));

        //Item[] items1 = {sword, hammer, boot};
        //array -> ei ole muudetav (read-only)

        /*stringi võrdluseks ei saa kasutada võrdusmärki*/
        world.printMap(world.width, world.height, player.xCoordinaate, player.yCoordinaate, player.symbol,
                dragon.xCoordinaate, dragon.yCoordinaate, dragon.symbol, orc.xCoordinaate, orc.yCoordinaate,
                orc.symbol, items);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            player.move(input, world);
            world.printMap(world.width, world.height, player.xCoordinaate, player.yCoordinaate, player.symbol,
                    dragon.xCoordinaate, dragon.yCoordinaate, dragon.symbol, orc.xCoordinaate, orc.yCoordinaate,
                    orc.symbol, items);
            System.out.println();
            for (Item i : items) {
                if (i.xCoordinate == player.xCoordinaate && i.yCoordinate == player.yCoordinaate) {
                    player.item = i;
                    System.out.println("korjasid eseme:" +player.item.name);
                    break;
                }
            }
            input = scanner.nextLine();
        }

    }

    //uuri mis on static
    //kodutöö loo üks klass ja kaks funktsiooni

}

