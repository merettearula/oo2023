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
                                 int orcXCoordinaate, int orcYCoordinaate, char orcSymbol) {
        // algväärtus, kuni 10, samm tsüklis
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            //seda tsüklit tehakse 10 x aga eelmist tehakse ka 10 ehk kokku 100
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight -1) {
                    System.out.print("-");
                } else if (x == 0 || x == worldWidth -1) {
                    System.out.print("|");
                } else {
                    printCharacters(playerXCoordinaate, playerYCoordinaate, playerSymbol, dragonXCoordinaate,
                            dragonYCoordinaate, dragonSymbol, orcXCoordinaate, orcYCoordinaate, orcSymbol, y, x);
                }
            }
        }
    }

//    private static int getRandomCoordinaate(int worldDimension) {
//        return (int) (Math.random() * (worldDimension - 2) + 1);
//    }

    private void printCharacters(int playerXCoordinaate, int playerYCoordinaate, char playerSymbol,
                                        int dragonXCoordinaate, int dragonYCoordinaate, char dragonSymbol,
                                        int orcXCoordinaate, int orcYCoordinaate, char orcSymbol, int y, int mapX) {
        if (playerXCoordinaate == mapX && playerYCoordinaate == y) {
            System.out.print(playerSymbol);
        } else if (dragonXCoordinaate == mapX && dragonYCoordinaate == y) {
            System.out.print(dragonSymbol);
        } else if (orcXCoordinaate == mapX && orcYCoordinaate == y) {
            System.out.print(orcSymbol);
        } else {
            System.out.print(" ");
        }
    }
}
