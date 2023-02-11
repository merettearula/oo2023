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

        int playerXCoordinaate = 3;
        int playerYCoordinaate = 3;
        int dragonXCoordinaate = 6;
        int dragonYCoordinaate = 2;
        int orcXCoordinaate = 5;
        int orcYCoordinaate = 1;

        // algväärtus, kuni 10, samm tsüklis
        for (int y = 0; y < 5; y++) {
            System.out.println();
            //seda tsüklit tehakse 10 x aga eelmist tehakse ka 10 ehk kokku 100
            for (int x = 0; x < 10; x++) {
                if (y == 0 || y == 4) {
                    System.out.print("-");
                } else if (x == 0 || x == 9) {
                    System.out.print("|");
                } else {
                    if (playerXCoordinaate == x && playerYCoordinaate == y) {
                        System.out.print("X");
                    } else if (dragonXCoordinaate == x && dragonYCoordinaate == y) {
                        System.out.print("D");
                    } else if (orcXCoordinaate == x && orcYCoordinaate == y) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}

