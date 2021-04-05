package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s10845 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int last = 0;
        for(int i=0;i<n;i++){
            String str = sc.next();
            if(str.equals("push")){
                last = sc.nextInt();
                q.add(last);
            }
            else if(str.equals("pop")){
                if(q.size()<1){
                    sb.append("-1"+"\n");
                }
                else{
                    sb.append(q.remove()+"\n");
                }
            }
            else if(str.equals("size")){
                sb.append(q.size()+"\n");
            }else if(str.equals("empty")){
                if (q.isEmpty()){
                    sb.append("1"+"\n");
                }else{
                    sb.append("0"+"\n");
                }
            }else if(str.equals("front")){
                if(q.size()<1){
                    sb.append("-1"+"\n");
                }else {
                    sb.append(q.peek()+"\n");
                }
            }else if(str.equals("back")){
                if(q.size()<1){
                    sb.append("-1"+"\n");
                }else {
                    sb.append(last+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
