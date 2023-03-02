public class Player {
    int xCoordinaate; //castimine ehk teisendamine ühest tüübist teise (int)
    int yCoordinaate;
    char symbol = 'X';
    Direction direction;

    //contructor - funktsioon mis käivitatakse koheselt, peab olema public
    public Player(int worldWidth, int worldHeight) {
        this.xCoordinaate = getRandomCoordinaate(worldWidth);
        this.yCoordinaate = getRandomCoordinaate(worldHeight);
        this.symbol = 'X';
        this.direction = Direction.UP; 
    }
    private static int getRandomCoordinaate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    //public - mõni teine klass saab ka seda funktsiooni välja kutsuda
    //private - tähendab, et seda funktsiooni saab ainult selles klassis kasutada
    public void move(String input) {
        if (input.equals("w")) {
            this.yCoordinaate = this.yCoordinaate - 1;
        } else if (input.equals("s")) {
            this.yCoordinaate = this.yCoordinaate + 1;
        } else if (input.equals("a")) {
            this.xCoordinaate = this.xCoordinaate - 1;
        } else if (input.equals("d")) {
            this.xCoordinaate = this.xCoordinaate + 1;
        }
    }


}
