package Game;

//represents the snake; the snake has a body and a head
//we use a Linked List to define the elements of our "collecion" (thanks again Prof. Huang)
import java.util.LinkedList;

public class Snake {
    
    private LinkedList<Coordinate> snakeBodyList = new LinkedList<>();
    private Coordinate head;
 
    //where the snake starts
    public Snake(Coordinate initCoor)
    {
        head = initCoor;
        snakePartList.add(head);
        head.setCoordinateType(CoordinateType.SNAKE);
    }
    
    //adds the next move if valid to the snake body list
    public void grow() {
        snakeBodyList.add(head);
    }
    
    //"moves" the snake editing the body list and the head coordiante 
    public void move(Coordinate nextCoordinate) {
        Coordinte tail = snakeBodyList.removeLast();
        tail.setCoordinateType(CoordinateType.EMPTY);
 
        head = nextCoordinate;
        head.setCoordinateType(CellType.SNAKE);
        snakeBodyList.addFirst(head);
    }
    
    //checks to see if the next coordinate is apart of the snake itself
    public void crash(Coordinate nextCoordinate) {
        for (Coordinate coordinate : snakeBodyList){
            if (coordinate == nextCoordiante) {
                return true;
            }
        }
        return false;
    }

    //gets the snake body
    public LinkedList<Coordinate> getSnakeBodyList()
    {
        return snakeBodyList;
    }
 
    //sets the snake body
    public void setSnakeBodyList(LinkedList<Coordiante> snakeBodyList)
    {
        this.snakeBodyList = snakeBodyList;
    }
 
    //gets snake head
    public Coordiante getHead() { 
        return head; 
    }
 
    //sets snake head
    public void setHead(Coordinate head) { 
        this.head = head; 
    }
}

//We added a class for coordinate to represent each position on the grid
public class Coordinate {
    
    private final int y, x;
    private CoordinateType coordinateType;
    
    //defines coordinate by the row and column
    public Coordinate(int y, int x)
    {
        this.y = y;
        this.x = x;
    }
    
    //gets coordinate type
    public CoordinateType getCoordinateType()
    {
        return coordinateType;
    }
 
    //sets coordinate type
    public void setCoordinateType(CoordinateType coordinateType)
    {
        this.coordinateType = coordinateType;
    }
 
    //gets row or y coordinate
    public int getY()
    {
        return y;
    }
    
    //gets column or x coordinate
    public int getX()
    {
        return x;
    }
}
   
    //per Professor Huang's advice on our UML, we created an enum for what is in each coordinate
    //stores information about what is in each coordinate. 
    public enum CoordinateType { 
        EMPTY,
        FOOD,
        SNAKE;
    }
//the Grid class represents the game board, it is made of coordinates. 
//has a method Food which randomly generates the postion of the food
public class Grid {
 
    final int Y_COUNT, X_COUNT;
    private Coordinate[][] coordinates;
 
    public Grid(int yCount, int xCount)
    {
        Y_COUNT = yCount;
        X_COUNT = xCount;
 
        coordinates = new Coordin[Y_COUNT][X_COUNT];
        for (int y = 0; y < Y_COUNT; y++) {
            for (int x = 0; x < X_COUNT; x++) {
                coordinates[y][x] = new Coordinate(y, x);
            }
            
        public Coordinate[][] getCoordinates()
        {
            return coordinates;
        }

        public void setCoordinates(Coordinate[][] coordinates)
        {
            this.coordinates = coordinates;
        }
        
        //method that generates food
        public void food()
        {
            while(true){
                int y = (int)(Math.random() * Y_COUNT);
                int x = (int)(Math.random() * X_COUNT);
                if(coordinates[y][x].getCoordinateType()!=CoordinateType.SNAKE)
                     break;
            }
            coordinates[y][x].setCoordinateType(CoordinateType.FOOD);
            }
        }
    }
     

//class game represents the game; stores info about the snake and the grid. 
public class Game {
    private Snake snake;
    private Grid grid;
    private int direction;
    private boolean gameOVer; 
    
    public Game(Snake snake, Grid grid)
    {
        this.snake = snake;
        this.grid = grid;
    }
    
    //gets Snake
    
    //sets Snake
    
    //gets Board
    
    //sets Board
    
    //gets Direction
    
    //sets Direction
    
    public void update(); //the grid will need updates regularly
    {
        if (!gameOver){
        }
        else {
        }
    }
    
    //gets next Coordinate
    

    public static class MainMenu {
        private String startGame;
        private String setting;
        private String quitGame;
        private boolean input;

        public void startGame() {
        }

        public void quitGame() {
        }

        public void toSettings() {
        }

        public void input() {
        }

        public static class Settings {
            private String difficulty;
            private boolean returnToMenu;
            private boolean snakeSkin;

            public void returnToMenu() {
            }

            public void chooseSkin() {
            }

            public void changeDifficulty() {
            }
        }
    }
}
