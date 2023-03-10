import java.util.List;

public class World {
    int width;
    int height;

    //konstruktor läheb käima kui kutsutakse main koodis new World välja
    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printMap(int worldWidth, int worldHeight, int playerXCoordinaate, int playerYCoordinaate,
                         char playerSymbol, int dragonXCoordinaate, int dragonYCoordinaate, char dragonSymbol,
                         int orcXCoordinaate, int orcYCoordinaate, char orcSymbol, List<Item> items) {
        // algväärtus, kuni 10, samm tsüklis
        char symbol = ' ';
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            symbol = ' ';
            //seda tsüklit tehakse 10 x aga eelmist tehakse ka 10 ehk kokku 100
            for (int x = 0; x < worldWidth; x++) {
                symbol = ' ';
                if (y == 0 || y == worldHeight - 1) {
                    symbol = '-';
                } else if (x == 0 || x == worldWidth - 1) {
                    symbol = '|';
                } else {

                    for (Item i : items) {
                        if (i.yCoordinate == y && i.xCoordinate == x) {
                            symbol = 'I';
                            break;
                        }
                    }
                    if (playerXCoordinaate == x && playerYCoordinaate == y) {
                        symbol = playerSymbol;
                    } else if (dragonXCoordinaate == x && dragonYCoordinaate == y) {
                        symbol = dragonSymbol;
                    } else if (orcXCoordinaate == x && orcYCoordinaate == y) {
                        symbol = orcSymbol;
                    }
                }
                System.out.print(symbol);
                symbol = ' ';
            }
        }
    }

//    private static int getRandomCoordinaate(int worldDimension) {
//        return (int) (Math.random() * (worldDimension - 2) + 1);
//    }

}



