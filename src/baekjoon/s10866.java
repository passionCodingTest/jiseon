package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class s10866 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i=0; i<cnt; i++) {
            String a = sc.next();
            if(a.equals("push_back")) {
                int b = sc.nextInt();
                deque.addLast(b);
            }else if(a.equals("push_front")) {
                int b = sc.nextInt();
                deque.addFirst(b);
            }else if(a.equals("pop_front")) {
                sb.append(deque.isEmpty()?-1+"\n" :deque.pop()+"\n");
            }else if(a.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1+"\n" : deque.removeLast()+"\n");
            }else if(a.equals("size")) {
                sb.append(deque.size()+"\n");
            }else if(a.equals("empty")) {
                sb.append(deque.isEmpty()?1+"\n":0+"\n");
            }else if(a.equals("front")) {
                sb.append(deque.isEmpty()?-1+"\n":deque.peek()+"\n");
            }else if(a.equals("back")) {
                sb.append(deque.isEmpty()?-1+"\n":deque.peekLast()+"\n");
            }
        }
        System.out.println(sb);
    }
}
