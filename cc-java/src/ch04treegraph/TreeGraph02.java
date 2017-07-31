package ch04treegraph;

import java.util.LinkedList;

/**
 * 4.2 주어진 유향 그래프(directed graph)에서 특정한 두 노드 간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라.
 *
 * (4E)
 * 4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * (6E)
 * 4.1 Route Between Nodes: Given a directed graph,
 *                          design an algorithm to find out whether there is a route between two nodes.
 *
 *                          Hints: #127
 */

// Summary (6E)
/**
 * by just simple graph traversal, such as depth-first search or breadth-first search.
 *
 * We should mark any node ... to avoid cycles and repetition of the nodes.
 *
 * worth discussing the tradeoffs between breadth-first search and depth-first search
 *  - depth-first search : a bit simpler to implement because of being done with simple recursion.
 *                         traverse ... very deeply before going onto immediate neighbors.
 *  - breadth-first search : useful to find the shortest path
 */

// TODO:
/**
 * DFS 와 BFS 장단점 정리 필요 (TBD)
 * - DFS 는 Recursive 로 간단히 구현 가능하므로 BFS 보다 조금 더 간단하다.
 * - BFS는 DFS에 비해 "최소 거리 경로"를 찾는데 유용하다. <-- 왜냐하면 DFS 는 인접 노드 방문전에 특정한 인접 노드를 전부 탐색해보기 때문에
 */
public class TreeGraph02 {
    // Graph 는 DFS, BFS 2가지 방법으로 Traversal 가능하다.
    // BFS 사용 이유: DFS 는 너무 특정한 방향, 즉 한쪽으로 너무 치우치게 검색을 하므로 특정 노드를 발견하는데 비효율적일수 있어서 BFS 사용
    //              --> start 노드 주변부터 검색하는 전략 채택
    //              --> BFS 는 Queue 라는 구조를(Queue, LinkedList, 또는 FIFO 가 되는 자료구조를 의미한다) 사용하는 것이 핵심이다.
    // 그리고, 방문했던 노드를 재방문하지 않기 위해, 그리고 루프/사이클이 생기지 않도록하기 위해 방문한 노드의 상태 저장 --> State class 정의
    public static boolean search(Graph g, Node start, Node end) {
        LinkedList<Node> q = new LinkedList<Node>();

        // Initialize a graph
        for (Node vertex : g.getNodes()) {
            vertex.state = State.Unvisited;
        }

        // Visit a root
        if (start == end) {
            return true;
        }

        start.state = State.Visiting;
        q.add(start);

        // Visit the others
        while(!q.isEmpty()) {
            Node current = q.removeFirst();   // q.poll() or q.dequeue()

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
        return null;
    }

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] nodes = g.getNodes();

        Node start = nodes[3];
        Node end = nodes[5];

        search(g, start, end);
    }
}
