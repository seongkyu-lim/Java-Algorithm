package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int v,e;


    public static void main(String[] args) throws NumberFormatException, IOException{
        input();
        dfs(1);
        bfs(1);

    }

    private static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();

        visited[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int x = que.poll();
            for(int y : adj[x]){
                if (visited[y]) continue;
                que.add(y);
                visited[y] = true;
            }
        }
    }

    private static void dfs(int x) {
        visited[x] = true;
        for(int y : adj[x]){
            if(visited[y]) continue;
            dfs(y);
        }
    }

    

    private static void input() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adj = new ArrayList[v+1];

        for (int i=0; i<v+1; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st2.nextToken());
            int v2 = Integer.parseInt(st2.nextToken());

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        visited = new boolean[v+1];
    }
}