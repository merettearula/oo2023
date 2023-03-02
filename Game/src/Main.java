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

        /*stringi võrdluseks ei saa kasutada võrdusmärki*/
        world.printMap(world.width, world.height, player.xCoordinaate, player.yCoordinaate, player.symbol,
                dragon.xCoordinaate, dragon.yCoordinaate, dragon.symbol, orc.xCoordinaate, orc.yCoordinaate,
                orc.symbol);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            player.move(input);
            world.printMap(world.width, world.height, player.xCoordinaate, player.yCoordinaate, player.symbol,
                    dragon.xCoordinaate, dragon.yCoordinaate, dragon.symbol, orc.xCoordinaate, orc.yCoordinaate,
                    orc.symbol);
            System.out.println();
            input = scanner.nextLine();
        }

    }

    //uuri mis on static

}

