import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AnCom extends JComponent implements ActionListener{
    private Timer t;
    Shapes shapes = new Shapes();

    private int frame =0;
   
    public AnCom(){
        super();
        

        this.setPreferredSize(new Dimension(1000,1000));
        
        t = new Timer(100, this);
       t.start();
    }
    public void paint(Graphics g){

        String insert = "Frame: " + Integer.toString(frame);
        g.drawString(insert, 5, 15);


       

       for(int i = 0; i < shapes.size();i++){         

        Poly poly =shapes.getNext();
        if(poly.isShown()){

            try{

                if(poly instanceof Cir){

                    Cir c1 = (Cir) poly;

                   // int bx =(int) c1.getX() + ( c1.getRadius()/2);
                  // int by=(int) c1.getY() + ( c1.getRadius()/2); 


                   // g.setColor(new Color(c1.getBC(0),c1.getBC(1),c1.getBC(2)));               
                  //  g.fillOval(bx, by, c1.getRadius()+c1.getBorderThickness(), c1.getRadius()+c1.getBorderThickness());

                
             
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
            }
            
            catch(Exception e){

            }
        }
       }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        frame++;
        shapes.update();
        repaint();
       
    }
    
}
