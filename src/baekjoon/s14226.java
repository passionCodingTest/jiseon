package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node1{
    int len;
    int buf;
    int cnt;
    public Node1(int l, int b, int c) {
        this.len=l;
        this.buf=b;
        this.cnt=c;
    }
}

public class s14226 {
    static int s;
    static boolean[][] visit;

    public static int bfs() {
        Queue<Node1> q=new LinkedList<>();
        visit[1][0]=true;
        q.offer(new Node1(1, 0, 0));

        while(!q.isEmpty()) {
            Node1 node=q.poll();
            if(node.len==s) return node.cnt;

            if(!visit[node.len][node.len]) {//복사
                visit[node.len][node.len]=true;
                q.offer(new Node1(node.len, node.len, node.cnt+1));
            }
            if(node.buf!=0 && !visit[node.len+node.buf][node.buf] && node.len+node.buf<=1000) {//붙여넣기
                visit[node.len+node.buf][node.buf]=true;
                q.offer(new Node1(node.len+node.buf, node.buf, node.cnt+1));
            }
            if(node.len>0 && !visit[node.len-1][node.buf]) {
                visit[node.len-1][node.buf]=true;
                q.offer(new Node1(node.len-1, node.buf, node.cnt+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        s=scan.nextInt();
        visit=new boolean[2002][2002];

        System.out.println(bfs());
    }
}
