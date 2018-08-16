import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window {
    public final int WIDTH;
    public final int HEIGHT;
    public final int SQUARE_SIZE = 7;
    int fps = 60;
    JFrame frame;
    int insetX = 45;
    int insetY = 60;
    int x = 0;

    public Window(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.frame = new JFrame();


    }

    public void init() {
        frame.setTitle("Maze");
        frame.setSize(WIDTH + 100, HEIGHT + 100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void drawMaze(int[][] maze) {
        Graphics g = frame.getGraphics();
        g.setColor(Color.blue);
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                if(maze[i][j] == 1)
                    g.setColor(Color.BLUE);
                else if(maze[i][j] == 2)
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.BLACK);
                g.fillRect(j * SQUARE_SIZE + insetX, i * SQUARE_SIZE + insetY, SQUARE_SIZE, SQUARE_SIZE);

            }
        }
        //g.setColor(Color.BLACK);
        //g.fillRect(0,0,5,100);
    }
}
