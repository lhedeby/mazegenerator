public class Solver {

    static Window window;
    public static void solveMaze(int[][] maze, int startRow, int startCol, int endRow, int endCol, Window window) {
        Solver.window = window;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        long start = System.currentTimeMillis();
        move(startRow, startCol, maze, visited, endRow, endCol);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms to solve");

    }


    private static int move(int row, int col, int[][] maze, boolean[][] visited, int endRow, int endCol) {

        visited[row][col] = true;
        window.drawMaze(maze);
        maze[row][col] = 2;
        if (row == endRow && col == endCol) return 1;
        if (row - 1 > 0 && maze[row - 1][col] == 1 && !visited[row - 1][col]) {
            if(move(row - 1, col, maze, visited, endRow, endCol) == 1) return 1;
        }
        if (row + 1 < maze.length && maze[row + 1][col] == 1 && !visited[row + 1][col]) {
            if(move(row + 1, col, maze, visited, endRow, endCol) == 1) return 1;
        }
        if (col - 1 > 0 && maze[row][col - 1] == 1 && !visited[row][col - 1]) {
            if(move(row, col - 1, maze, visited, endRow, endCol) == 1) return 1;
        }
        if (col + 1 < maze[0].length && maze[row][col + 1] == 1 && !visited[row][col + 1]) {
            if(move(row, col + 1, maze, visited, endRow, endCol) == 1) return 1;
        }
        maze[row][col] = 1;
        return 0;
    }
}
