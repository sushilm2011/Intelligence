import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ccuser on 27/2/18.
 */
public class Main {

    LinkedList<Node> nodes;
    Astar astar;
    int src, dest;

    private void checkNext(Scanner sc){
        if(!sc.hasNext()){
            System.out.println("Invalid Input!!");
            System.exit(0);
        }
    }

    public void parseFile(String file){
        nodes = new LinkedList<>();
        try {
            File f = new File(file);
            Scanner sc = new Scanner(f);
            //Number of lines of input
            int n = sc.nextInt();
            System.out.println("Number of Nodes: "+n);
            System.out.println("Node Num\tNode Name\t Heuristics:");
            for(int i=0;i<n;i++){
                checkNext(sc);
                String node = sc.next();
                int heuristics = sc.nextInt();
                if(node.length() >= 9)
                    System.out.println(i+"\t\t"+node+"\t\t"+heuristics);
                else
                    System.out.println(i+"\t\t"+node+"\t\t\t"+heuristics);
                nodes.add(new Node(node, heuristics));
            }
            checkNext(sc);
            src = sc.nextInt();
            checkNext(sc);
            dest = sc.nextInt();
            System.out.println("\n\nEdges: ");
            System.out.println("Node->Node\tCost");
            while(sc.hasNext()){
                int node1 = sc.nextInt();
                checkNext(sc);
                int node2 = sc.nextInt();
                checkNext(sc);
                double cost = sc.nextDouble();
                nodes.get(node1).adjacencies.add(new Edge(nodes.get(node2), cost));
                if(node1>=10 && node2>=10)
                    System.out.println(node1+" -> "+node2+"\t"+cost);
                else
                    System.out.println(node1+" -> "+node2+"\t\t"+cost);
            }
            System.out.println("\n\nSrc: "+src+"\tDest: "+dest);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Main(){
        nodes = new LinkedList<>();
        parseFile("input");
    }

    private void printResult() {
        List<Node> path = astar.printPath(nodes.get(dest));
        System.out.println("Path: " + path);
    }

    private void search() {
        astar = new Astar();
        astar.AstarSearch(nodes.get(src), nodes.get(dest));
    }

    public static void main(String[] args){
        Main main = new Main();
        System.out.println("Graph Created:");
        System.out.println("\nSearching...");
        System.out.println("\n");
        main.search();
        main.printResult();
    }
}