/**
* Class does the actually animation for project. Uses javax and overwrite paint method in jcomponenet 
to animate shapes
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.*;
import java.awt.geom.Line2D;

public class AnCom extends JComponent implements ActionListener{
    private Timer t;
    private Shapes shapes;

    private int frame =0;

   /**
    * Constructor of class
    */
    public AnCom(){
        
        super();
        this.setPreferredSize(new Dimension(1000,1000));//sets pixel size 
        shapes = new Shapes();
        t = new Timer(100, this);//makes timer for animation loop
        t.start();
    }

    public AnCom(Shapes s){
        super();
        this.setPreferredSize(new Dimension(1000,1000));//sets pixel size 
        shapes =s;

        t = new Timer(100, this);//makes timer for animation loop
        t.start();
    }
   /**
    * Animates the JComponent
    * @param Grapics g Allow the code to animate the JComponent
    */
    public  void paint(Graphics g){

        Graphics2D g2 = (Graphics2D) g;


        String insert = "Frame: " + Integer.toString(frame);
        g.drawString(insert, 5, 15);

       

       for(int i = 0; i < shapes.size();i++){         

        Poly poly =shapes.getNext();
        if(poly.isShown()){

            try{

                if(poly instanceof Cir){

                    Cir c1 = (Cir) poly;
                    g.setColor(new Color(c1.getBC(0),c1.getBC(1),c1.getBC(2)));
                    g.fillOval(c1.getX() -c1.getBorderThickness(), c1.getY() -c1.getBorderThickness(), c1.getRadius() + (2* c1.getBorderThickness()), c1.getRadius() + (2* c1.getBorderThickness()));


             
                    g.setColor(new Color(c1.getColour(0),c1.getColour(1),c1.getColour(2)));
                    g.fillOval(c1.getX(), c1.getY(), c1.getRadius(), c1.getRadius());

                }

                else if(poly instanceof Rect){
                    Rect r1 = (Rect)poly;


                    g.setColor(new Color(r1.getBC(0),r1.getBC(1),r1.getBC(2)));
                    g.fillRect(r1.getX() -r1.getBorderThickness(), r1.getY() -r1.getBorderThickness(), r1.getWidth() + (2* r1.getBorderThickness()), r1.getLength() + (2* r1.getBorderThickness()));

                    g.setColor(new Color(r1.getColour(0),r1.getColour(1),r1.getColour(2)));
                    g.fillRect(r1.getX(), r1.getY(), r1.getWidth(), r1.getWidth());
                }

                else if(poly instanceof Line){
                    Line l1 = (Line) poly;

                    g.setColor(new Color(0,0,0));

                    g2.setStroke(new BasicStroke(l1.getBorderThickness()));
                    g2.draw(new Line2D.Float(l1.getX(), l1.getY(), l1.getX2(), l1.getY2()));                    


                }
            }
            
            catch(Exception e){

            }
        }
       }
    }


   /**
    * repaint the frame, updates the polys and adds to the frame
    * @param ActionEvent e Action event that triggers this method
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame++;
        shapes.update();
        repaint();
       
    }
    
}
