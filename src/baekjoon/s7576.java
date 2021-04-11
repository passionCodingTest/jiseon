package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int row, col;
    public Point(int row, int col){this.row = row; this.col = col;}
}

public class s7576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][], m, n;
    static Queue<Point> queue = new LinkedList<>();
    static int xArr[] = {-1, 0, 1, 0}, yArr[] = {0, 1, 0, -1}; //상하좌우

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) queue.add(new Point(i, j));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 4; i++){
                if(checkLocation(row + xArr[i], col + yArr[i])){ //토마토 익을 수 있느지 확인
                    queue.add(new Point(row + xArr[i],col + yArr[i])); //토마토 추가
                    arr[row + xArr[i]][col + yArr[i]] = arr[row][col] + 1; //토마토 추가 +1
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(arr[i][j] == 0) return -1; // 익지 않은 토마토가 있다면 -1
                result = Math.max(result, arr[i][j]); // 걸리는 시간
            }
        }
        if(result == 1) return 0; //모두 익은것
        return (result - 1); //최대
    }

    private static boolean checkLocation(int row, int col) {
        if(row < 1 || row > n || col < 1 || col > m) return false; //범위 확인
        if(arr[row][col] == 0) return true; //익지않은
        return false; //익은 or 비어있음
    }
}