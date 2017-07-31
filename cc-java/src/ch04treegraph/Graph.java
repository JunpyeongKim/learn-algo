package ch04treegraph;

// Graph
public class Graph {
    private static int MAX_VERTICES = 6;

    private Node vertices[];    // vertex: (기하) 꼭짓점, (전문 용어) 정점(頂點)
    private int count;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < MAX_VERTICES) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}