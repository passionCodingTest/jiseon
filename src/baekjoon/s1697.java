package baekjoon;

import java.util.*;
public class s1697 {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now-1 >= 0) { //x-1 걷기
                if (check[now-1] == false) {
                    q.add(now-1);
                    check[now-1] = true;
                    dist[now-1] = dist[now] + 1; //이동시간추가
                }
            }
            if (now+1 < MAX) { //x+1걷기
                if (check[now+1] == false) {
                    q.add(now+1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1; //이동시간추가
                }
            }
            if (now*2 < MAX) { //2*x 순간이동
                if (check[now*2] == false) {
                    q.add(now*2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1; //이동시간추가
                }
            }
        }
        System.out.println(dist[m]);
    }
}