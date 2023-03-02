public class Dragon {
    int xCoordinaate;
    int yCoordinaate;
    char symbol = 'X';

    //contructor - funktsioon mis käivitatakse koheselt, peab olema public
    public Dragon(int worldWidth, int worldHeight) {
        this.xCoordinaate = getRandomCoordinaate(worldWidth);
        this.yCoordinaate = getRandomCoordinaate(worldHeight);
        this.symbol = 'D';
    }
    private static int getRandomCoordinaate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }
}