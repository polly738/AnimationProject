import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class player {

    //frams: 312 //split here and then use if (array[0] = "frames") frames = array[1]
    public static void main(String[] args) throws FileNotFoundException{
        
        int framecount = 0;
        int fps = 0;
        int section = 1;
        int lineCount = 1;
        int elements = 0;
        File file = new File ("animation1.txt"); //file open
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
    



}
