package baekjoon;

import java.util.*;
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class s2178 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;
        while (!q.isEmpty()) { //bfs
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k]; //다음노드 확인
                int ny = y+dy[k]; //다음노드 확인
                if (0 <= nx && nx < n && 0 <= ny && ny < m) { //좌표 안넘어가면
                    if (check[nx][ny] == false && a[nx][ny] == 1) { //방문x, 1일때
                        q.add(new Pair(nx, ny)); //방문
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}