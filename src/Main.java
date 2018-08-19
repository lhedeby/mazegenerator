public class Main {
    public static void main(String[] args) {
        Window window = new Window(300,300);
        window.init();
        int[][] maze;//Mazegenerator.newMaze(81,81);
        //Solver.solveMaze(maze, 0, 1, maze.length - 1, maze[0].length - 2);


        while(true) {


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maze = Mazegenerator.newMaze(41,41, window);
            Solver.solveMaze(maze, 0, 1, maze.length - 1, maze[0].length - 2, window);
            window.drawMaze(maze);

        }

    }
}
