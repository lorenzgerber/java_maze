/**
 * Created by loge on 13/04/16.
 */
public class Position {
    private int x;
    private int y;


    public Position(int x, int y){
        //TODO construcor method
    }

    public int getX(){
        // TODO accessor for X position
        return 10;
    }

    public int getY(){
        // TODO accessor for Y position
        return 10;
    }

    public Position getPosToSouth(){
        // TODO method to get pos south
        return new Position(1,1);
    }

    public Position getPosToNorth(){
        //TODO method to get pos north
        return new Position(1,1);
    }

    public Position getPosWest(){
        //TODO method to get pos west
        return new Position(1,1);
    }

    public Position getPosEast(){
        //TODO method to get pos east
        return new Position(1,1);
    }

    public boolean equals(Object o){
        //TODO method to compare two Positions Objects
        return false;
    }

    public int hashCode(){
        //TODO hashcode method???
        return 10;
    }


}
