package ch04treegraph;

import java.util.LinkedList;

/**
 * 4.2 주어진 유향 그래프(directed graph)에서 특정한 두 노드 간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라.
 *
 * (4E)
 * 4.2 Given a directed graph,
 *     design an algorithm to find out whether there is a route between two nodes.
 *
 * (6E)
 * 4.1 Route Between Nodes: Given a directed graph,
 *                          design an algorithm to find out whether there is a route between two nodes.
 *
 *                          Hints #127. Two well-known algorithms can do this. What are the tradeoffs between them?
 */

public class TreeGraph02 {
    /**
     * Graph는 DFS 또는 BFS 2가지 방법으로 Traversal 가능하다.
     * (DFS가 아닌) BFS 사용 이유: DFS는 너무 특정한 방향, 즉 한쪽으로 너무 치우치게 검색을 하므로 특정 노드를 발견하는데 비효율적일수 있기 때문에 BFS 사용
     *                         --> start 노드 주변부터 검색하는 전략 채택
     *                         --> BFS는 Queue 구조(Queue, LinkedList, 또는 FIFO 가 되는 자료구조)를 사용하는 것이 핵심이다.
     * State class 정의: 노드를 재방문하지 않기 위해, 그리고 루프/사이클이 생기지 않도록하기 위해 방문한 노드의 상태 저장
     *
     * Summary(6E)
     *  by just simple graph traversal, such as depth-first search or breadth-first search.
     *
     *  We should mark any node ... to avoid cycles and repetition of the nodes.
     *
     *  worth discussing the tradeoffs between breadth-first search and depth-first search
     *      - depth-first search : a bit simpler to implement because of being done with simple recursion.
     *                             traverse ... very deeply before going onto immediate neighbors.
     *      - breadth-first search : useful to find the shortest path
     */


    //--------------------------------------------------------------------------------
    // Solution
    //--------------------------------------------------------------------------------
    public static boolean search(Graph g, Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> q = new LinkedList<Node>();

        // Initialize a graph
        for (Node vertex : g.getNodes()) {
            vertex.state = State.Unvisited;
        }

        // Visit a root
        start.state = State.Visiting;
        q.add(start);

        // Visit the others
        Node current;
        while(!q.isEmpty()) {
            current = q.removeFirst();   // q.poll() or q.dequeue()

            // Visit adjacent nodes (or immediate neighbors)
            for (Node adjacent : current.getAdjacent()) {
                if (adjacent.state == State.Unvisited) {
                    if (adjacent == end) {
                        return true;
                    } else {
                        adjacent.state = State.Visiting;
                        q.add(adjacent);
                    }
                }
            }

            current.state = State.Visited;
        }

        return false;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }

        return g;
    }

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] nodes = g.getNodes();
        Node start = nodes[3];
        Node end = nodes[5];

        System.out.println(search(g, start, end));
    }
}