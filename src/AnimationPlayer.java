/**
* JFrame of project 
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;


public class AnimationPlayer extends JFrame  {

   private AnCom com;
   private Shapes shapes;

    /**
    * constructor of Animation, also handles the making of a jframe 
    */
    public AnimationPlayer(){
        
        super("Animation");

        shapes = new Shapes();

      
    }



    /**
    * Method close JFrame
    */
    public void close(){

        this.close();
    }

    public void loadAnimationFromFile(String path)throws FileNotFoundException{

        int framecount = 0;
        int fps = 0;
        int section = 1;
        int lineCount = 1;
        int elements = 0;
        File file = new File (path); //file open
        Scanner scan = new Scanner(file); //scan file
        for (int i = 0; i<3;i++){ //this loop runs for general settings, 3 settings so 3 times.
            String line = scan.nextLine(); //string line is the first splitLine
            
            if(line.contains(":")){

            String[] splitLine = line.split(" "); //split "frames: 312" into array with name "splitLine": ["frames:", "312"]
            
            if(splitLine[0].equals("frames:"))  
                {
                framecount = Integer.parseInt(splitLine[1]);
                }

            else if(splitLine[0].equals("speed:"))
                {
                String[] noFPS = splitLine[1].split("f");
                fps = Integer.parseInt(noFPS[0]);
                }
            }
            else if(section == 1)
            elements = Integer.parseInt(line);
            else if(line.equals("")){
                section++;
                lineCount = 1;
            }
            lineCount++;
        }
        System.out.println("amount of frames: " + framecount);
        System.out.println("fps is: " + fps);
        System.out.println("amounts of elements: " + elements);

        for(int i = 0; i<elements; i++){
            String line = scan.nextLine();
            if(line.equals("Circle")){
            
            }



        }



    }
    public void run(){
        
        
        com = new AnCom(shapes);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(com);
        this.pack();
        this.setVisible(true);


    }
}