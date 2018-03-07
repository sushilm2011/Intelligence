import java.util.LinkedList;

/**
 * Created by ccuser on 27/2/18.
 */
public class Node{

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public LinkedList<Edge> adjacencies;
    public Node parent;

    public Node(String val, double hVal){
        value = val;
        h_scores = hVal;
        adjacencies = new LinkedList<>();
    }

    public String toString(){
        return value+"("+f_scores+")";
    }

    public boolean checkEquality(Node goal) {
        return this.value.equals(goal);
    }
}
