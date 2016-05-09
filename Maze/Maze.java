import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Write a description of class Maze here.
 * 
 * @author @crli 
 * @version May 10, 2016
 */
public class Maze
{
    // instance variables - replace the example below with your own
    private ActorWorld world;
    
    private final int ROWS = 20;
    private final int COLS = 20;

    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
        // initialise instance variables
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS,COLS);
        world = new ActorWorld(grid);
        addWalls();
        world.show();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addWalls(){
        // put your code here
        int[] rows = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,
                      3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,
                      6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,9,
                      9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,
                      11,11,11,11,11,11,11,12,12,12,12,12,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,
                      14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,15,15,15,15,15,15,15,15,16,16,16,16,
                      16,16,16,16,16,16,16,16,16,16,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,18,18,
                      18,18,18,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19};
        int[] cols = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,0,1,2,3,4,5,6,7,11,12,19,0,7,9,10,
                      11,12,14,16,17,19,0,2,4,5,7,9,10,11,12,14,15,16,17,19,0,2,4,5,7,14,15,17,19,0,2,4,
                      5,7,8,9,10,12,13,15,17,18,19,0,2,4,5,12,13,15,18,19,0,1,2,4,5,6,7,8,9,10,11,12,13,
                      15,16,18,19,0,2,4,5,6,7,8,9,10,11,12,13,15,16,18,19,0,2,16,18,19,0,2,3,4,5,6,7,8,9,
                      10,11,12,13,14,16,18,19,0,2,3,4,5,6,7,8,9,10,14,16,18,19,0,10,12,14,19,0,2,4,5,6,7,
                      8,9,10,12,14,15,17,18,19,0,2,3,4,6,8,9,10,12,13,14,15,17,18,19,0,3,4,6,15,17,18,19,
                      0,1,3,4,6,8,9,10,11,12,13,17,18,19,0,1,3,4,8,9,10,12,13,14,15,16,17,18,19,0,6,17,18,
                      19,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        
        Grid<Actor> grid = world.getGrid();
        
        for(int i = 0; i < rows.length; i++){ grid.put(new Location(rows[i], cols[i]), new Rock());}
    }
    
    public static void main(String[] args){Maze maze = new Maze();}
}
