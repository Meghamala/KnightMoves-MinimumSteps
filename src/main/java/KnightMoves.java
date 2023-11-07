import java.util.ArrayList;
import java.util.List;

public class KnightMoves {

    static int[][] directions = new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{-2,1},{-2,-1},{2,1},{2,-1}};
    static List<Integer[]> result = new ArrayList<>();
    static boolean[][] seen;
    static int m;
    static int n;

    public static boolean isValid(int x, int y, int[][] board) {
        return x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1;
    }

    public static List<Integer[]> knightMoves(int[][] board) {
        m = board.length;
        n = board[0].length;
        seen = new boolean[m][n];

        if(board[0][0] == 1){
            seen[0][0] = true;
            result.add(new Integer[]{0, 0});
            dfs(0, 0, board);
        }

        return result;
    }

    private static void dfs(int r, int c, int[][] board) {
        for(int[] direction: directions){
            int nr = r+direction[0], nc = c+direction[1];

            if(isValid(nr,nc,board) && !seen[nr][nc]){
                seen[nr][nc] = true;
                result.add(new Integer[]{nr, nc});
                dfs(nr,nc,board);
            }
        }
    }



    public static void main(String[] args) {
        int[][] board = {{1, -1, 1, 1}, {1, -1, -1, 1}, {1, 1, -1, 1}, {1, 1, 1, 1}};

        List<Integer[]> moves = knightMoves(board);

        for (Integer[] move : moves) {
            System.out.println("(" + move[0] + ", " + move[1] + ")");
        }
    }
}

