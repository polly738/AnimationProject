import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ShapesBuilder {
    public Shapes getShapes(String path){
        Shapes shapes = new Shapes();
        int framecount = 0;
        int fps = 0;
        int elements = 0;
        int section = 1;
        int lineCount = 1;
        int shape = 0;
        //maybe put Cir here?
        File file = new File (path); //file open
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
                if (line.equals("Circle")){
                    Cir circle = new Cir();
                    int r = 0;
                    int x = 0;
                    int y = 0;
                    int c1 = 0;
                    int c2 = 0;
                    int c3 = 0;
                    char type;
                    int start;
                    int jumpX = 0;
                    int jumpY = 0;
                    int CC1 = 0;
                    int CC2 = 0;
                    int CC3 = 0;
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
                        }
                        if(loopLine.contains("effect")){
                            String effectLine = scan.nextLine();
                            if (effectLine.equals("Show")){
                               type = 's';
                               String[] splitStart = scan.nextLine().split(" ");
                               start = splitStart[1];
                            }
                            else if (effectLine.equals("Hide")){
                                type = 'h';
                                String[] splitStart = scan.nextLine().split(" ");
                                start = splitStart[1];
                             }
                             else if (effectLine.equals("Jump")){
                                type = 'j';
                                String[] splitStart = scan.nextLine().split(" ");
                                start = splitStart[1];
                                String[] splitX = scan.nextLine().split(" ");
                                jumpX = splitX[1];
                                String[] splitY = scan.nextLine().split(" ");
                                jumpX = splitY[1];
                             }
                             else if (effectLine.equals("ChangeColour")){
                                type = 'c';
                                String[] splitStart = scan.nextLine().split(" ");
                                start = splitStart[1];
                                String[] splitCC1 = scan.nextLine().split(" ");
                                CC1 = splitCC1[1];
                                String[] splitCC2 = scan.nextLine().split(" ");
                                CC2 = splitCC2[1];
                                String[] splitCC3 = scan.nextLine().split(" ");
                                CC3 = splitCC3[1];
                            }
                            if(type == 's'|| type == 'h'){
                            circle.addAction(type, start);}
                            else if (type == 'j')
                            circle.addAction(type, start, jumpX, jumpY);
                            else if (type == 'c')
                            circle.addAction(type, start, CC1, CC2, CC3);
                    }
                
                        
                
            }
            shapes.add(circle);
        }
                else if (line.equals("Rect")){

                }
                else if (line.equals("Line")){

                }
                


        return shapes;

       }
    }
}
}
