/* David Frucht 19/06/2021 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vars {

    /* Window Size */

    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 800;


    /* Matrix drawing data */

    static final int COLS = 10;
    static final int ROWS = 10;
    static final int ORIGIN_X = 0;
    static final int ORIGIN_Y = 0;
    static final int CELL_SIZE = 60;

    static final int UP_BORDER = 0;
    static final int DOWN_BORDER = 9;
    static final int LEFT_BORDER = 0;
    static final int RIGHT_BORDER = 9;

    /* Tracking Score */

    static int scoreCounter = 0 ;

    /* Food image GIF */

    static Image apple;
    {
        try {
            apple = ImageIO.read(getClass().getResource("apple.gif"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




    static boolean winner = false ;         // is it relevant ?
    static final int WINING_SCORE = 102;
    static boolean inGame = true ;          // why is it used ?

    static boolean canChangeDirection = true;

    /*  List for storing snake and food coordinates */
    static List<Point> Points = new ArrayList<>();
    static Point Food = new Point(0, 0);

    static final int HEAD_OF_SNAKE = 0;

    static final int EASY_LEVEL_INTERVAL = 400;
    static final int MEDIUM_LEVEL_INTERVAL = 300;
    static final int HARD_LEVEL_INTERVAL = 200;

    static Timer timer;




}
