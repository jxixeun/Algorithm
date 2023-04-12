package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFSWithList {

    // 정점의 방문 여부를 나타내는 배열 visited
    // false면 방문하지 않은 정점이고, true면 방문한 정점이다.
    static boolean [] visited;

    // 그래프의 인접 리스트 표현
    // adjList[i]에는 정점 i에서 갈 수 있는 다른 정점들이 입력 순서대로 들어있다.
    static List<Integer> [] adjList;

    // 정점의 개수
    static int N;

    // DFS 결과를 출력하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    // 깊이 우선 탐색
    private static void dfs(int current) {
        visited[current] =  true;
        sb.append(current).append(" ");
        for (int i=0; i< adjList[current].size(); i++){
            if (!visited[adjList[current].get(i)]){
                dfs(adjList[current].get(i));
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
        adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }
        dfsAll();
        System.out.print(sb);
    }
}
