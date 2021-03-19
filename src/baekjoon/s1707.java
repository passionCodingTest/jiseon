package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class s1707 {
    static int k,v,e;
    static ArrayList<Integer>[] a;
    static int[] color; //0 : 방문x, 1 : a, 2 : b
    public static boolean dfs(int node,int c) {
        color[node] = c;
        for(int i=0;i<a[node].size();i++){
            int next = a[node].get(i);
            if(color[next] == 0){
                if(dfs(next,3-c) == false){
                    return false;
                }
            }
            else if(color[node] == color[next]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        k = sc.nextInt();
        for(int j=0;j<k;j++) {
            v = sc.nextInt();
            e = sc.nextInt();
            a = (ArrayList<Integer>[]) new ArrayList[v + 1];
            for (int i = 1; i < v + 1; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < e; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            color = new int[v + 1];
            boolean ok = true;
            for (int i = 1; i < v + 1; i++) {
                if (color[i] == 0) {
                    if (dfs(i, 1) == false) {
                        ok = false;
                    }
                }
            }
            sb.append(ok ? "YES" : "NO");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
