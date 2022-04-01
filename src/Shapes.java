import java.util.ArrayList;

public class Shapes {

   private ArrayList<Poly> shapes; 
   private int cursor =0;

    public Shapes(){

       shapes = new ArrayList<Poly>();

       Cir c1 = new Cir(50, 0, 0, 255, 0, 255, 0, 0, 0, 0);

       c1.addAction('s', 10);
       c1.addAction('j', 20, 3, 100);
       c1.addAction('c',90,255,0,0);

       Cir c2 = new Cir(100, 78, 0, 255, 255, 2, 0, 0, 0, 0);

       c2.addAction('s', 10);
       c2.addAction('j', 25, 100, 100);
       c2.addAction('c',100,255,255,0);
       c2.addAction('h',1000);

       



       shapes.add(c2);
       shapes.add(c1);

       Rect r1 = new Rect(100, 100, 500, 500, 125, 123, 100, 10, 255, 0, 0);
       shapes.add(r1);
    }

    public void addAction(char c, int a){

        shapes.get(cursor).addAction(c, a);
    }

    public void add(Poly s){

        shapes.add(s);
        cursor++;
    }

    public ArrayList<Poly> getShapes(){
        this.update();

        ArrayList<Poly> temp = new ArrayList<Poly>();

        for(int i = 0; i < shapes.size();i++){

            if(shapes.get(i).isShown()){

                temp.add(shapes.get(i));
            }
        }

        return temp;
    }  

    public ArrayList<Poly> getAllShapes(){

        return shapes;
    }

    public void update(){
        cursor =0;

        for(int i = 0; i < shapes.size(); i++){

            shapes.get(i).update();
        }
    }

    public int size(){

        return shapes.size();
    }

    public Poly getNext(){

      
        return shapes.get(cursor++);
    }

}
