package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSWithNode {

    // 정점의 방문 여부를 나타내는 배열 visited
    // false면 방문하지 않은 정점이고, true면 방문한 정점이다.
    static boolean [] visited;

    // 그래프의 인접 리스트 표현
    // adjList[i]에는 정점 i에서 갈 수 있는 다른 정점들이 입력 순서의 역순대로 연결되어있다.
    static Node [] adjList;

    // 정점의 개수
    static int N;

    // DFS 결과를 출력하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    // 그래프의 정점
    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    // 깊이 우선 탐색
    private static void dfs(int current) {
        visited[current] =  true;
        sb.append(current).append(" ");
        for (Node temp = adjList[current]; temp!=null; temp=temp.link){
            if (!visited[temp.vertex]){
                dfs(temp.vertex);
            }
        }
    }

    // 모든 정점을 방문
    private static void dfsAll(){
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adjList = new Node[N];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
        }
        dfsAll();
        System.out.print(sb);
    }
}
