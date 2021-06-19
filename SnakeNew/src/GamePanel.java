/* David Frucht 19/06/2021 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    /* Constructors*/
    Snake snake = new Snake(Vars.COLS,Vars.ROWS);
    Vars vars = new Vars();

    public static void main(String[] args) {
        GamePanel snake = new GamePanel();

    }

    public void LoadImages () {
        ImageIcon appleImage = new ImageIcon("C:/Users/david/Desktop/SnakeNew/apple.gif");
        Vars.apple = appleImage.getImage();
    }

    GamePanel() {

        this.init();
        this.LoadImages ();

        new Thread(() -> {
            while(Vars.inGame){

                snake.SetDirection(snake.Direction);//added a call to a function that will update the Direction property
                snake.Move();//added a function that will recalibrate all the points of the snake's body parts
                repaint();

                try{
                    Thread.sleep(Vars.interval);
                }catch (Exception e){
                    System.out.println("unable to make the thread to sleep");
                }
            }
        }).start();


        this.setPreferredSize(new Dimension(Vars.WINDOW_WIDTH,Vars.WINDOW_HEIGHT));
        Vars.timer = new Timer(Vars.EASY_LEVEL_INTERVAL, this);
        Vars.timer.start();
        snake.Move();
    }

    public void init(){
        this.setVisible(true);
        this.setDoubleBuffered(true);
        this.setSize(Vars.WINDOW_WIDTH, Vars.WINDOW_HEIGHT);
        this.setLayout(null);
    }

    public void DrawScore (Graphics g){
        Font f = new Font("Arial", Font.BOLD , Vars.FONT_SIZE );
        g.setColor(Color.BLUE);
        g.setFont(f);
        g.drawString("SCORE: " + snake.GetScoreCounter() , Vars.DRAW_SCORE_X ,Vars.DRAW_SCORE_Y);
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);                // white panel background

        DrawScore(g);

        /* Draw Matrix */

        g.setColor(Color.lightGray);
        for (int i = 0; i < Vars.ROWS + 1; i++) {
            g.drawLine(Vars.ORIGIN_X, Vars.ORIGIN_Y + i * Vars.CELL_SIZE, Vars.ORIGIN_X + Vars.COLS * Vars.CELL_SIZE, Vars.ORIGIN_Y + i * Vars.CELL_SIZE);
        }

        for (int i = 0; i < Vars.COLS + 1; i++) {
            g.drawLine(Vars.ORIGIN_X + i * Vars.CELL_SIZE, Vars.ORIGIN_Y, Vars.ORIGIN_X + i * Vars.CELL_SIZE, Vars.ORIGIN_Y + Vars.ROWS * Vars.CELL_SIZE);
        }

        /* Draw Snake */

        g.setColor(Color.GREEN);
        for (int i = 0; i < vars.Points.size(); i++) {
            int x = Vars.CELL_SIZE * vars.Points.get(i).X;  //added CELL_SIZE *
            int y = Vars.CELL_SIZE * vars.Points.get(i).Y;
            g.fillRect(Vars.CELL_SIZE * vars.Points.get(i).X, Vars.CELL_SIZE * vars.Points.get(i).Y, Vars.CELL_SIZE - 1, Vars.CELL_SIZE - 1);
        }

        /* Draw Food */

        g.drawImage(Vars.apple, Vars.CELL_SIZE * vars.Food.X, Vars.CELL_SIZE * vars.Food.Y, Vars.CELL_SIZE, Vars.CELL_SIZE,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

}
