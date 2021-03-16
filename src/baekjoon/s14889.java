package baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class s14889 {
    static int n;
    static int[][] s;
    static ArrayList<Integer> team_start,team_link;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        team_start = new ArrayList<>();
        team_link = new ArrayList<>();
        n = sc.nextInt();
        s = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                s[i][j] = sc.nextInt();
            }
        }
        int result = go(1,team_start,team_link);
        System.out.print(result);
  }

    public static int go(int index, ArrayList<Integer> team_start, ArrayList<Integer> team_link){
        if(index == n+1) { //n을 넘어가면
            if (team_start.size() != n/2) {
                return -1;
            }
            if (team_link.size() != n/2) {
                return -1;
            }
            int t1 = 0; //능력치
            int t2 = 0; //능력치
            for(int i=0;i<n/2;i++){
                for(int j=0;j<n/2;j++){
                    if(i == j) continue;
                    t1 += s[team_start.get(i)][team_start.get(j)];
                    t2 += s[team_link.get(i)][team_link.get(j)];
                }
            }
            int diff = Math.abs(t1-t2);
            return diff;
        }

        int result = -1;

        //start팀 추가
        team_start.add(index);
        int t1 = go(index+1,team_start,team_link);
        if(result == -1 ||(t1 != -1 && result > t1)){
            result = t1;
        }
        team_start.remove(team_start.size()-1);
        //link팀 추가
        team_link.add(index);
        int t2 = go(index+1,team_start,team_link);
        if(result == -1 ||(t2 != -1 && result > t2)){
            result = t2;
        }
        team_link.remove(team_link.size()-1);

        return result;
    }
}
