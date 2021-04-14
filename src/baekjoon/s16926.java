package baekjoon;

import java.util.*;
public class s16926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //배열을 먼저 그룹을 짓는다(돌아가는것끼리) ->1차원으로 만든다
        //1차원 배열을 r번 회전 (다시 그룹에 넣을때 구현하면됨)
        //다시 그룹에 넣는다.
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        int groupn = Math.min(n,m)/2;
        //k는 바깥에서부터 k번 떨어진것을 뜻함 ex>제일 바깥쪽은 0번, 그다음 안쪽은 1번
        for (int k=0; k<groupn; k++) { //k번 그룹
            ArrayList<Integer> group = new ArrayList<>();
            for (int j=k; j<m-k; j++) {
                group.add(a[k][j]); //상
            }
            for (int i=k+1; i<n-k-1; i++) {
                group.add(a[i][m-k-1]);  //우
            }
            for (int j=m-k-1; j>k; j--) {
                group.add(a[n-k-1][j]); //하
            }
            for (int i=n-k-1; i>k; i--) {
                group.add(a[i][k]); //좌
            }
            groups.add(group);
        }
        for (int k=0; k<groupn; k++) {
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = r % len; //회전을 너무 많이 하면 배열의 크기보다 커지는 것을 방지
                                //ex)5의 크기 배열일때 6번회전이면 1번 회전과 같다.
            for (int j=k; j<m-k; j++, index = (index+1) % len) {
                a[k][j] = group.get(index);
            }
            for (int i=k+1; i<n-k-1; i++, index = (index+1) % len) {
                a[i][m-k-1] = group.get(index);
            }
            for (int j=m-k-1; j>k; j--, index = (index+1) % len) {
                a[n-k-1][j] = group.get(index);
            }
            for (int i=n-k-1; i>k; i--, index = (index+1) % len) {
                a[i][k] = group.get(index);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
