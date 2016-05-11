import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Write a description of class Maze here.
 * 
 * @author @crli 
 * @version May 10, 2016
 */
public class Maze extends ActorWorld{
    private User user; //user icon
    
    private final int ROWS = 20; //initializes number of rows
    private final int COLS = 20; //initializes number of cols

    /**
     * Constructor for objects of class Maze
     */
    public Maze(){
        super(new BoundedGrid<Actor>(20,20)); //passes grid to superclass
        add();
        this.show();}

    /**
     * Creates the walls and puts user in initial position
     * 
     */
    public void add(){
        user = new User();
        
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
        
        Grid<Actor> grid = this.getGrid();
        user.putSelfInGrid(grid,new Location(19,1));
        for(int i = 0; i < rows.length; i++){ grid.put(new Location(rows[i], cols[i]), new Wall());}}
    
    public boolean keyPressed(String description, Location loc){
        /**
         * If possible, moves user into desired location
         * 
         * @param description which direction the user wants to move in
         * @param loc the location
         * 
         */
        Grid<Actor> grid = this.getGrid();
        
        if(description.equals("LEFT")){
            if(user.getLocation().getCol()!=0&&grid.get(new Location(user.getLocation().getRow(),user.getLocation().getCol()-1))==null){
                user.moveTo(new Location(user.getLocation().getRow(),user.getLocation().getCol()-1));}}
        else if(description.equals("UP")){
            if(user.getLocation().getRow()!=0&&grid.get(new Location(user.getLocation().getRow()-1,user.getLocation().getCol()))==null){
                user.moveTo(new Location(user.getLocation().getRow()-1,user.getLocation().getCol()));}}
        else if(description.equals("RIGHT")){
            if(user.getLocation().getCol()!=19&&grid.get(new Location(user.getLocation().getRow(),user.getLocation().getCol()+1))==null){
                user.moveTo(new Location(user.getLocation().getRow(),user.getLocation().getCol()+1));}}
        else if(description.equals("DOWN")){
            if(user.getLocation().getRow()!=19&&grid.get(new Location(user.getLocation().getRow()+1,user.getLocation().getCol()))==null){
                user.moveTo(new Location(user.getLocation().getRow()+1,user.getLocation().getCol()));}}
        
        if(user.getLocation().getRow()==0&&user.getLocation().getCol()==18){
            System.out.println("Congratulations! You've reached the end");}
                
        return true;}
    
    public static void main(String[] args){
        Maze maze = new Maze();}}