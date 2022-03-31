public class Shape {
    
    private int borderThickness;
    private int[] bColour= new int[3];
    private int[] colour = new int[3];
    private int x;
    private int y;
    private int frame =0;
    private boolean isShown =false;
    private ActionHandler actions = new ActionHandler();

    public Shape(int xi, int yi,int c1, int c2, int c3, int bt, int b1, int b2, int b3){

        x= xi;
        y = yi;
        borderThickness = bt;

        bColour[0] = b1;
        bColour[1] = b2;
        bColour[2] = b3;
        colour[0] = c1;
        colour[1] = c2;
        colour[2] = c3;
      
    }

    public int getBC(int a){

        return bColour[a];
    }

    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }

    public int getBorderThickness(){

        return borderThickness;
    }
   
    public boolean isShown(){
        return isShown;
    }

    public int getColour(int a){

        return colour[a];
    }

    public void next(){

    frame++;



        while(actions.isAction(frame)){

            char type = actions.getType();

            switch(type){

                case 'j': //jump
                x = actions.getJumpX();
                y = actions.getJumpY();
                break;

                case 'h'://hide
                isShown = false;
                break;

                case 's'://show
                isShown = true;
                break;

                case 'c'://change colour
                colour[0] = actions.getColour(0);
                colour[1] = actions.getColour(1);
                colour[2] = actions.getColour(2);

                break;

                



            }
        
        }
    
    }

    public void addAction(char c, int a){//add effect for show/hide

        actions.addAction(c, a);
    }

    public void addAction(char c, int a, int c1, int c2, int c3){//add effect for change colour

        actions.addAction(c, a, c1, c2, c3);
    }

    public void addAction(char c, int a, int x, int y){//add effect for jump

        actions.addAction(c, a, x, y);;
    }
}

