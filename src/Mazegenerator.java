import static java.lang.Math.random;

public class Mazegenerator {

public static Window window;


    //depth first;
    static int[][] newMaze(int width, int height, Window window) {
        Mazegenerator.window = window;
        long start = System.currentTimeMillis();
        int[][] maze = new int[height][width];
        boolean[][] visited = new boolean[height][width];
        visit(1, 1, maze, visited);
        maze[0][1] = 1;
        maze[maze.length - 1][maze[0].length - 2] = 1;
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms to create");


        return maze;
    }

    static void visit(int row, int col, int[][] maze, boolean[][] visited) {
        visited[row][col] = true;
        maze[row][col] = 1;
        int[] directions = new int[4];
        int dir = 1;
        while (dir < 5) {

            int index = (int) (Math.random() * 4);
            if (directions[index] == 0) {
                directions[index] = dir++;
            }
        }
        window.drawMaze(maze);

        for (int i = 0; i < directions.length; i++) {
            go(row, col, maze, visited, directions[i]);
        }
    }

    static void go(int row, int col, int[][] maze, boolean[][] visited, int direction) {
        //up
        if (direction == 1 && row - 2 > 0 && !visited[row - 2][col]) {
            maze[row - 1][col] = 1;
            visit(row - 2, col, maze, visited);
        }
        //down
        if (direction == 2 && row + 2 < maze.length && !visited[row + 2][col]) {
            maze[row + 1][col] = 1;
            visit(row + 2, col, maze, visited);
        }
        //left
        if (direction == 3 && col - 2 > 0 && !visited[row][col - 2]) {
            maze[row][col - 1] = 1;
            visit(row, col - 2, maze, visited);
        }
        //right
        if (direction == 4 && col + 2 < maze[0].length && !visited[row][col + 2]) {
            maze[row][col + 1] = 1;
            visit(row, col + 2, maze, visited);
        }
    }

}
