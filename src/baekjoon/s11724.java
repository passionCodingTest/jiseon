package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s11724 {

    static int n;
    static int m;
    static boolean[] c;
    static ArrayList<Integer>[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = new boolean[n+1];
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<Integer>();
        }
        int u,v;
        for(int i=0;i<m;i++){ //인접리스트 생성
            u = sc.nextInt();
            v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        int cnt =0;
        for(int i=1;i<c.length;i++){
            if(c[i] == false){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            for(int y : a[x]){
                if(c[y] == false){
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

}
