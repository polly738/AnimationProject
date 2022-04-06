import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class player {

    //frams: 312 //split here and then use if (array[0] = "frames") frames = array[1]
    public static void main(String[] args) throws FileNotFoundException{
        
        int framecount = 0;
        int fps = 0;
        int elements = 0;
        int section = 1;
        int lineCount = 1;
        int shape = 0;
        //maybe put Cir here?
        File file = new File ("animation1.txt"); //file open
        Scanner scan = new Scanner(file); //scan file
        while (section==1){ //this loop runs for general settings, 3 settings so 3 times.
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
            else if(line == ""){
                lineCount = 0;
                section++;
            }
            else {
            elements = Integer.parseInt(line);}
            
            lineCount++;
        }
        System.out.println("amount of frames: " + framecount);
        System.out.println("fps is: " + fps);
        System.out.println("amounts of elements: " + elements);

        for(int i = 0; i<elements; i++){
            String line = scan.nextLine();
            if(section > 1 && lineCount ==1){
                if (line.equals("Circle"))
                shape = 1;
                else if (line.equals("Rect"))
                shape = 2;
                else if (line.equals("Line"))
                shape = 3;
                switch(shape){
                    case 1: //CIRCLE
                    Cir circle = new Cir();
                    int r = 0;
                    int x = 0;
                    int y = 0;
                    int c1 = 0;
                    int c2 = 0;
                    int c3 = 0;
                    int currentSection = section;
                    while(section == currentSection){
                        String loopLine = scan.nextLine(); //string line is the first splitLine
                        
                        if(loopLine.contains(":")){
            
                        String[] splitLine = loopLine.split(" "); //split "frames: 312" into array with name "splitLine": ["frames:", "312"]
                        
                        if(splitLine[0].equals("r:"))  
                            {
                            circle.setR(Integer.parseInt(splitLine[1]));
                            }
            
                        else if(splitLine[0].equals("x:"))
                            {
                                circle.setX(Integer.parseInt(splitLine[1]));
                            }
                        else if(splitLine[0].equals("y:"))
                            {
                                circle.setY(Integer.parseInt(splitLine[1]));
                            }
                        else if(splitLine[0].equals("color:"))
                        {
                            splitLine[1] = splitLine[1].replace(",", "");
                            splitLine[2] = splitLine[2].replace(",", "");
                            circle.setC1(Integer.parseInt(splitLine[1]));
                            circle.setC2(Integer.parseInt(splitLine[2]));
                            circle.setC3(Integer.parseInt(splitLine[3]));
                        }
                        else
                        System.out.println("no");
                        //Cir c1 = new Cir(r, x, y,);
                        }
                        
                        
                    }
                    default:
                    
                }
            }
            System.out.println(circle.getX());
        }
    }
}

        
        
        
    


