/**
* Class keeps track of singular effect (action) given to a poly (rect,line,cir)
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/
public class Action {
    private int startFrame;
    private char type;
    private int colour[];
    private int jumpX;
    private int jumpY;

    public Action(char c, int a){

        type = c;
        startFrame = a;
    }

    public Action(char c, int a, int c1, int c2, int c3){
       
        type = c;
        colour = new int[3];
        startFrame = a;

        colour[0] = c1;
        colour[1] = c2;
        colour[2] = c3;

    }

    public Action(char c, int a,int x, int y){

        type = c;

        jumpX = x;
        jumpY = y;

        startFrame = a;
    }

    public int getStartFrame(){

        return startFrame;
    }

    public int getColour(int a){

        return colour[a];
    }

    public char getType(){

        return type;
    }

    public int getJumpX(){

        return jumpX;
    }

    public int getJumpY(){

        return jumpY;
    }

    public boolean isActionOnFrame(int a){

        if(a == startFrame){

            return true;
        }
        
        else{

            return false;
        }
    }
    

}