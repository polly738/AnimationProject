/**
* interface that when implemented allows for AnCom to animate instance of interface,
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/

public interface Poly {

    public int getBC(int a);
    public int getX();
    public int getY();
    public int getBorderThickness();
    public boolean isShown();
    public int getColour(int a);
    public void update();//update shape based off of actions
    public void addAction(char c, int a);
    public void addAction(char c, int a, int c1, int c2, int c3);
    public void addAction(char c, int a, int x, int y);
}
