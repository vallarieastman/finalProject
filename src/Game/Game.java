package Game;

//represents the snake; the snake has a body and a head
//we use a Linked List to define the elements of our "collecion" (thanks again Prof. Huang)
import java.util.Scanner;
import java.util.LinkedList;

public class Snake {
    
    private LinkedList<Coordinate> snakeBodyList = new LinkedList<>();
    private Coordinate head;
 
    //where the snake starts
    public Snake(Coordinate initCoor)
    {
        head = initCoor;
        snakeBodyList.add(head);
        head.setCoordinateType(CoordinateType.SNAKE);
    }
    
    //adds the next move if valid to the snake body list
    public void grow() {
        snakeBodyList.add(head);
    }
    
    //"moves" the snake editing the body list and the head coordinate
    public void move(Coordinate nextCoordinate) {
        Coordinate tail = snakeBodyList.removeLast();
        tail.setCoordinateType(CoordinateType.EMPTY);
 
        head = nextCoordinate;
        head.setCoordinateType(CoordinateType.SNAKE);
        snakeBodyList.addFirst(head);
    }
    
    //checks to see if the next coordinate is apart of the snake itself
    public boolean crash(Coordinate nextCoordinate) {
        for (Coordinate coordinate : snakeBodyList){
            if (coordinate == nextCoordinate) {
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
    public void setSnakeBodyList(LinkedList<Coordinate> snakeBodyList)
    {
        this.snakeBodyList = snakeBodyList;
    }
 
    //gets snake head
    public Coordinate getHead() {
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
//has a method Food which randomly generates the position of the food
public class Grid {
 
    final int Y_COUNT, X_COUNT;
    private Coordinate[][] coordinates;
 
    public Game.Coordinate[][] Grid(int yCount, int xCount)
    {
        Y_COUNT = yCount;
        X_COUNT = xCount;
 
        coordinates = new Coordinate[Y_COUNT][X_COUNT];
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
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
    DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    
    private Snake snake;
    private Grid grid;
    private int direction;
    private boolean gameOver; 
    
    public Game(Snake snake, Grid grid)
    {
        this.snake = snake;
        this.grid = grid;
    }
    
    //gets Snake
    public Snake getSnake()
    {
        return snake;
    }
    
    //sets Snake
    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }
    
    //gets Grid
    public Grid getGrid()
    {
        return grid;
    }
    
    //sets Grid
    public void setGrid(Grid grid)
    {
        this.grid = grid;
    }
    
    //gets Direction
    public int getDirection()
    {
        return direction;
    }
    
    //sets Direction
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    //gets game over
    public boolean isGameOver()
    {
        return gameOver;
    }
 
    //sets game over
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    //the grid will need updates regularly
    public void update(){
        if (!gameOver){
            if (direction != DIRECTION_NONE) {
                Coordinate nextCoordinate = getNextCoordinate(snake.getHead());
                if (snake.crash(nextCoordinate)) {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                }
                else {
                    snake.move(nextCoordinate);
                    if (nextCoordinate.getCoordinateType() == CoordinateType.FOOD) {
                        snake.grow();
                        grid.food();
                    }
                }
            }
        }
    }
    
    //gets next Coordinate
    private Coordinate getNextCoordinate(Coordinate currentPosition)
    {
        System.out.println("Going to find next cell");
        int y = currentPosition.getY();
        int x = currentPosition.getX();
 
        if (direction == DIRECTION_RIGHT) {
            x++;
        }
        else if (direction == DIRECTION_LEFT) {
            x--;
        }
        else if (direction == DIRECTION_UP) {
            y--;
        }
        else if (direction == DIRECTION_DOWN) {
            y++;
        }
 
        Coordinate nextCoordinate = grid.getCoordinates()[y][x];
 
        return nextCoordinate;
    }

    public static class MainMenu {
        System.out.println("Start Game");
        
        Coordinate initCoor = new Coordinate(0, 0);
        Snake initSnake = new Snake(initCoor);
        Grid grid = new grid(20, 20);
        Game newGame = new Game(initSnake, grid);
        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;
        
       /* public static class Settings {
            private String difficulty;
            private boolean returnToMenu;
            private boolean snakeSkin;

            public void returnToMenu() {
            }

            public void chooseSkin() {
            }

            public void changeDifficulty() {
            }
            */
        }
    }
}
