package 격자형그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        input();
        dfs(0,0);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k=0; k<4; k++){
            int nx = i+dir[k][0];
            int ny = j+dir[k][1];

            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(visited[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    private static void input() throws IOException {

        //n*n 이차원 배열 받기.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
    }
    
}
