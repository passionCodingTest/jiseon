package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s2667 {
    static int n;
    static int[][] a;
    static int[] dx = {-1,1,0,0}; //상하좌우 확인
    static int[] dy = {0,0,1,-1}; //상하좌우 확인
    static int[][] d; //(i,j)를 방문 안했으면 0, 했으면 단지번호
    static int[] num;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = sc.nextInt();
        a = new int[n][n];
        d = new int[n][n];
        num = new int[n*n];
        for(int i=0;i<n;i++){
            str = sc.next();
            for(int j=0;j<n;j++){
                a[i][j] = str.charAt(j)-'0';
            }
        }
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1 && d[i][j] == 0){ //지도 1 이고, d 방문안했을때
                    bfs(i,j,++cnt);
                    num[cnt]++;
                }
            }
        }
        System.out.println(cnt);
        Arrays.sort(num);
        for(int i=0;i<n*n;i++){
            if(num[i] != 0){
                System.out.println(num[i]);
            }

        }

    }
    public static void bfs(int x,int y,int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        d[x][y] = cnt;
        while(!q.isEmpty()){ //q가 empty 될때까지 bfs
            x = q.peek()[0];
            y = q.peek()[1];
            q.remove();
            for(int i=0;i<4;i++){ //상하좌우 확인
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0<=nx && nx<n && 0<=ny && ny <n){ //지도 내에 위치 확인
                    if(a[nx][ny] == 1 && d[nx][ny] == 0){
                        q.add(new int[] {nx,ny});
                        d[nx][ny] = cnt;
                        num[cnt] += 1;
                    }
                }
            }
        }
    }
}
