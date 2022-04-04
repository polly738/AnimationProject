/**
* JFrame of project 
*
* @author  Jeffrey Betty
* @version 1.0
* @since   2021-04-02 
*/

import javax.swing.JFrame;


public class AnimationPlayer extends JFrame  {

   private AnCom com;

    /**
    * constructor of Animation, also handles the making of a jframe 
    */
    public AnimationPlayer(){
        
        super("Animation");

        com = new AnCom();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(com);
        this.pack();
        this.setVisible(true);

    }

    /**
    * Method close JFrame
    */
    public void close(){

        this.close();
    }

   
}