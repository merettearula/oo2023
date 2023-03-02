public class Orc {
    int xCoordinaate; //castimine ehk teisendamine ühest tüübist teise (int)
    int yCoordinaate;
    char symbol = 'X';

    //contructor - funktsioon mis käivitatakse koheselt, peab olema public
    public Orc(int worldWidth, int worldHeight) {
        this.xCoordinaate = getRandomCoordinaate(worldWidth);
        this.yCoordinaate = getRandomCoordinaate(worldHeight);
        this.symbol = 'O';
    }
    private static int getRandomCoordinaate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }
}
