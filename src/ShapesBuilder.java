import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShapesBuilder {
    private int framecount = 60;
    private int fps = 60;
    private int elements = 0;
    private int section = 1;
    private int lineCount = 1;
    private int x = 0;
    private int y = 0;

    public int getFramecount() {
        return framecount;
    }

    public int getFPS() {
        return fps;
    }

    public int getElements() {
        return elements;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Shapes getShapes(String path) throws IOException {
        Shapes shapes = new Shapes();
        System.out.println("Test");
        File file = new File(path); // file open
        System.out.println("test2");
        Scanner scan = new Scanner(file); // scan file
        
        while (section == 1) { // this loop runs for general settings, 3 settings so 3 times.
            String line = scan.nextLine(); // string line is the first splitLine

            String[] splitLine = line.split(" "); // split "frames: 312" into array with name "splitLine": ["frames:", "312"]

            try {
                if (splitLine[0].equals("frames:")) {
                    framecount = Integer.parseInt(splitLine[1]);
                }

                else if (splitLine[0].equals("speed:")) {
                    String[] noFPS = splitLine[1].split("f");
                    fps = Integer.parseInt(noFPS[0]);
                } else if (splitLine[0] == "") { // when there is empty line
                    lineCount = 0;
                    section++;
                } else
                    elements = Integer.parseInt(splitLine[0]);
            } catch (NumberFormatException e) {

            }

            lineCount++;
        }

        for (int i = 0; i < elements; i++) {
            String line = scan.nextLine();
            if (section > 1 && lineCount == 1) {
                if (line.equals("Circle")) {
                    Cir circle = new Cir();
                    char type;
                    int start;
                    int jumpX = 0;
                    int jumpY = 0;
                    int CC1 = 0;
                    int CC2 = 0;
                    int CC3 = 0;
                    int currentSection = section;
                    while (section == currentSection) {
                        String loopLine = scan.nextLine(); // string line is the first splitLine

                        if (loopLine.contains(":")) {

                            String[] splitLine = loopLine.split(" "); // split "frames: 312" into array with name
                                                                      // "splitLine": ["frames:", "312"]

                            try {
                                if (splitLine[0].equals("r:"))
                                    circle.setR(Integer.parseInt(splitLine[1]));

                                else if (splitLine[0].equals("x:"))
                                    circle.setX(Integer.parseInt(splitLine[1]));
                                else if (splitLine[0].equals("y:"))
                                    circle.setY(Integer.parseInt(splitLine[1]));
                                else if (splitLine[0].equals("color:")) {
                                    splitLine[1] = splitLine[1].replace(",", "");
                                    splitLine[2] = splitLine[2].replace(",", "");
                                    circle.setC1(Integer.parseInt(splitLine[1]));
                                    circle.setC2(Integer.parseInt(splitLine[2]));
                                    circle.setC3(Integer.parseInt(splitLine[3]));
                                } else
                                    System.out.println("no");
                            } catch (NumberFormatException e) {

                            }
                        }
                        if (loopLine.contains("effect")) {
                            String effectLine = scan.nextLine();
                            try {
                                if (effectLine.equals("Show")) {
                                    type = 's';
                                    String[] splitStart = scan.nextLine().split(" ");
                                    start = Integer.parseInt(splitStart[1]);
                                } else if (effectLine.equals("Hide")) {
                                    type = 'h';
                                    String[] splitStart = scan.nextLine().split(" ");
                                    start = Integer.parseInt(splitStart[1]);
                                } else if (effectLine.equals("Jump")) {
                                    type = 'j';
                                    String[] splitStart = scan.nextLine().split(" ");
                                    start = Integer.parseInt(splitStart[1]);
                                    String[] splitX = scan.nextLine().split(" ");
                                    jumpX = Integer.parseInt(splitX[1]);
                                    String[] splitY = scan.nextLine().split(" ");
                                    jumpX = Integer.parseInt(splitY[1]);
                                } else if (effectLine.equals("ChangeColour")) {
                                    type = 'c';
                                    String[] splitStart = scan.nextLine().split(" ");
                                    start = Integer.parseInt(splitStart[1]);
                                    String[] splitCC1 = scan.nextLine().split(" ");
                                    CC1 = Integer.parseInt(splitCC1[1]);
                                    String[] splitCC2 = scan.nextLine().split(" ");
                                    CC2 = Integer.parseInt(splitCC2[1]);
                                    String[] splitCC3 = scan.nextLine().split(" ");
                                    CC3 = Integer.parseInt(splitCC3[1]);
                                } else { // error if effect is not correct
                                    type = 'x';
                                    start = 0;
                                }
                            } catch (NumberFormatException e) { // error if parseInt can't return an int
                                type = 'x';
                                start = 0;
                            }
                            if (type == 's' || type == 'h') {
                                circle.addAction(type, start);
                            } else if (type == 'j')
                                circle.addAction(type, start, jumpX, jumpY);
                            else if (type == 'c')
                                circle.addAction(type, start, CC1, CC2, CC3);
                        }

                    }
                    shapes.add(circle);
                } else if (line.equals("Rect")) {

                } else if (line.equals("Line")) {

                } else {
                    elements++;
                }

            }
        }
        lineCount = 1;
        return shapes;
    }

    public static void main(String[] args) throws IOException{
        ShapesBuilder b = new ShapesBuilder();

        Shapes s = b.getShapes("animation1.txt");
        s.test();

    }
}
