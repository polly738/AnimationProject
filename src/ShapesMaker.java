import java.util.ArrayList;

public class ShapesMaker {

    Shapes shapes = new Shapes();
   
    public ShapesMaker(){
        Cir c1 = new Cir(5, 0, 0, 255, 0, 255, 0, 0, 0, 0);

        c1.addAction('s', 10);
        c1.addAction('j', 20, 3, 100);
        c1.addAction('c',0,255,0);

        Cir c2 = new Cir(5, 78, 0, 255, 255, 2, 0, 0, 0, 0);
        c2.addAction('s', 50);
        c2.addAction('j', 60, 3, 100);
        c2.addAction('c',0,255,0);

        shapes.add(c2);

        shapes.add(c1);
    }

    public ArrayList<Poly> getAll(){

        return shapes.getAllShapes();
    }
    
}
