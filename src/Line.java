/**
* Class implements Poly interface to make a Line that AnCom can animate
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/
public class Line implements Poly{


    private int borderThickness;
    private int[] bColour= new int[3];
    private int[] colour = new int[3];
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int frame =0;
    private boolean shown;
   
    private ActionHandler actions = new ActionHandler();
    public Line(int xi, int yi,int xi2,int yi2, int bt){

        x= xi;
        y = yi;
        y2 = yi2;
        x2= xi2;
        borderThickness = bt;
       
        shown = false;
    }

    public int getX2(){

        return x2;
    }

    public int getY2(){
        return y2;
    }

    /**
    * Implemented for Poly interface, gets Border Colour value
    * @param a (int) what border colour value is returnerd (0,1,2) -> (R,G,B)
    * @return border colour value (int) at value speficied 
    */
    @Override
    public int getBC(int a){

        return -1;
    }

    /**
    * Implemented for Poly interface, returns x value of class
    *@return x value of class (int)
    */
    @Override
    public int getX(){
        
        return x;        
    }

    /**
    * Implemented for Poly interface, returns y value of class
    *@return y value of class (int)
    */
    @Override
    public int getY(){

        return y;
    }

   /**
    * Implemented for Poly interface returns border thickness of class
    *@return border thickness of class (int)
    */ 
    @Override
    public int getBorderThickness(){

        return borderThickness;
    }
    /**
    * Implemented for Poly interface return if the poly is suposed to be shown
    *@return boolean value true if the object is shown false if not
    */ 
    @Override
    public boolean isShown(){

        return shown;
    }
   
     /**
    * Implemented for Poly interface, gets Colour value
    * @param a (int) what colour value is returnerd (0,1,2) -> (R,G,B)
    * @return colour value (int) at value speficied 
    */
    @Override
    public int getColour(int a){

        return -1;
    }
  
  /**
    * Implemented for Poly interface
    *Updates the cir on all its attributes if effect is to change them on the frame
    */  
    @Override
    public void update(){

        frame++;

        while(actions.isAction(frame)){

            char type = actions.getType();

            switch(type){

                case 'j': //jump
                x = actions.getJumpX();
                y = actions.getJumpY();
                break;

                case 'h'://hide
                shown= false;
                break;

                case 's'://show
                shown = true;
                break;

                case 'c'://change colour
                colour[0] = actions.getColour(0);
                colour[1] = actions.getColour(1);
                colour[2] = actions.getColour(2);

                break;
            }
        }    
    }

   /**
   * Method implement for Poly interface Adds actions to actions (arraylist of actions) for hide/show effect 
   * @param c (char) type of effect being added
   * @param a (int) when the effect will be activated
   */
    @Override
    public void addAction(char c, int a){

        actions.addAction(c, a);
    }

    @Override
    public void addAction(char c, int a, int c1, int c2, int c3){

        actions.addAction(c, a, c1, c2, c3);
    }

    @Override
    public void addAction(char c, int a, int x, int y){

        actions.addAction(c, a, x, y);
    
    }
 
}
