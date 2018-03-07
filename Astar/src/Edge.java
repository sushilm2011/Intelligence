/**
 * Created by ccuser on 27/2/18.
 */
public class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
        target = targetNode;
        cost = costVal;
    }
}
