package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s13549 {
    public static final int MAX = 1000000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now * 2 == next) { //순간이동
                            q.add(next);
                            d[next] = d[now]; //0초
                        } else {
                            next_queue.add(next);
                            d[next] = d[now] + 1; //1초
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Integer>();
            }
        }
        System.out.println(d[m]);
    }
}