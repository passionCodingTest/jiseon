package programmers;

import java.util.Stack;
class s1 {
    static Stack<Integer> list = new Stack<>();

    static int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    public static void main(String[] args) {
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int prev = 0;
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                int temp = board[j][moves[i]-1];
                if(temp != 0){
                    if(prev == temp){
                        answer += 2;
                        list.pop();
                    }
                    else{
                        list.push(temp);
                    }
                    board[j][moves[i]-1] = 0;
                    prev = list.peek();

                    break;
                }
            }
        }
        return answer;
    }
}