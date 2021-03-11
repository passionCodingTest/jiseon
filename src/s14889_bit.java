import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class s14889_bit {

    static int n;
    static int[][] s;
    static ArrayList<Integer> team_start,team_link;

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        team_start = new ArrayList<Integer>();
        team_link = new ArrayList<Integer>();
        n = sc.nextInt();
        s = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                s[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<(1<<n);i++){
            int cnt = 0;
            int start = 0;
            int link = 0;
            for(int j=0;j<n;j++){
                if((i&(1<<j)) != 0){
                    team_start.add(j);
                }
                else{
                    team_link.add(j);
                }
            }
            if(team_start.size() == n/2 && team_link.size() == n/2){
                for(int k=0;k<n/2;k++){
                    for(int l=0;l<n/2;l++){
                        if(k == l) continue;
                        start += s[team_start.get(k)][team_start.get(l)];
                        link += s[team_link.get(k)][team_link.get(l)];
                    }
                }
                int diff = Math.abs(start-link);
                if(diff < min) min =diff;
            }
            team_start.clear();
            team_link.clear();

        }
        System.out.println(min);
    }


}
