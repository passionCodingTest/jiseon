package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class dot {
    int x;
    int y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class s7562 {
    static int[] dx = {-2,-1,2,1,2,1,-2,-1}; //나이트 이동 경우의 수
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};
    static int[][] map; //체스판
    static boolean[][] visited; //방문 체크
    static int n;
    static int start_x, start_y, end_x, end_y;
    static int count = 0;
    static Queue<dot> q = new LinkedList<dot>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine()); //한변의 길이
            map = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken()); //현재있는 칸
            start_y = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken()); //이동하려는 칸
            end_y = Integer.parseInt(st.nextToken());

            bfs(new dot(start_x, start_y));
            System.out.println(map[end_x][end_y]);
        }

    }

    static void bfs(dot d) {

        if(d.x == end_x && d.y == end_y) { //도착하면 return
            return;
        }
        visited[d.x][d.y] = true; //방문

        q.add(d); //큐 추기

        while(!q.isEmpty()) {
            dot t = q.remove();
            int x1 = t.x;
            int y1 = t.y;

            for(int i=0; i<dx.length; i++) {
                int x2 = x1 + dx[i]; //이동
                int y2 = y1 + dy[i];

                if(x2>=0 && x2<n && y2>=0 && y2<n && !visited[x2][y2]) {
                    q.add(new dot(x2,y2));
                    visited[x2][y2] = true;

                    map[x2][y2] = map[x1][y1] + 1;//이동횟수 추가
                }
            }
        }

    }

}

