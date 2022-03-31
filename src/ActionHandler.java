import java.util.ArrayList;

public class ActionHandler {

    private ArrayList<Action> actions = new ArrayList<Action>();

    Action nextAction;
    
    public ActionHandler(){

       
    }

    public void addAction(char c, int a){

        actions.add(new Action(c,a));
    }

    public void addAction(char c, int a, int c1, int c2, int c3){

        actions.add(new Action(c, a, c1, c2, c3));
    }

    public void addAction(char c, int a, int x, int y){

        actions.add(new Action(c, a, x, y));
    }

    public boolean isAction(int a){

        for(int i = 0; i < actions.size(); i++){

            if(actions.get(i).isActionOnFrame(a)){

                nextAction = actions.get(i);

                actions.remove(i);

                return true;
            }
        }

        return false;
    }

    public char getType(){

        return nextAction.getType();
    }

    public int getJumpX(){

        return nextAction.getJumpX();
    }

    public int getJumpY(){

        return nextAction.getJumpY();
    }

    public int getColour(int a){

        return nextAction.getColour(a);
    }
}
