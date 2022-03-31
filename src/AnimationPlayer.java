import javax.swing.JFrame;

public class AnimationPlayer extends JFrame{

    AnCom com;

    public AnimationPlayer(){
        
        super("Animation");

        com = new AnCom();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(com);
        this.pack();
        this.setVisible(true);

    }
}