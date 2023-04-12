package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSWithAdjMatrix {

    // 정점의 방문 여부를 나타내는 배열 visited
    // false면 방문하지 않은 정점이고, true면 방문한 정점이다.
    static boolean [] visited;

    // 그래프의 인접 행렬 표현
    // adjMatrix[i][j] = true 라면 정점 i에서 정점 j로 가는 간선이 존재한다는 의미이다.
    static boolean [][] adjMatrix;

    // 정점의 개수
    static int N;

    // DFS 결과를 출력하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    // 깊이 우선 탐색
    private static void dfs(int current) {
        visited[current] =  true;
        sb.append(current).append(" ");
        for (int i=0; i< N; i++){
            if (adjMatrix[current][i] && !visited[i]){
                dfs(i);
            }
        }
    }

    // 모든 정점을 방문
    private static void dfsAll(){
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adjMatrix = new boolean[N][N];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = true;
        }
        dfsAll();
        System.out.print(sb);
    }
}
