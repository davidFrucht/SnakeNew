/* David Frucht 19/06/2021 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vars {

    /* Game panel bounds */

    static final int WINDOW_X = 0;
    static final int WINDOW_Y = 0;
    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 800;


    /* Main Menu components bounds */

    static final int INSTRUCTION_TEXT_X = 50;
    static final int INSTRUCTION_TEXT_Y = 50;
    static final int INSTRUCTION_TEXT_WIDTH = 400;
    static final int INSTRUCTION_TEXT_HEIGHT = 200;

    static final int CHOOSE_LEVEL_LABEL_X = 50;
    static final int CHOOSE_LEVEL_LABEL_Y = 250;
    static final int CHOOSE_LEVEL_LABEL_WIDTH = 86;
    static final int CHOOSE_LEVEL_LABEL_HEIGHT = 22;

    static final int COMBO_BOX_LEVEL_X = 200;
    static final int COMBO_BOX_LEVEL_Y = 250;
    static final int COMBO_BOX_LEVEL_WIDTH = 86;
    static final int COMBO_BOX_LEVEL_HEIGHT = 22;

    static final int START_GAME_BUTTON_X = 300;
    static final int START_GAME_BUTTON_Y = 300;
    static final int START_GAME_BUTTON_WIDTH = 100;
    static final int START_GAME_BUTTON_HEIGHT = 50;




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

    /* Draw Score data */

    static final int FONT_SIZE = 22;
    static final int DRAW_SCORE_X = 10;
    static final int DRAW_SCORE_Y = WINDOW_WIDTH / 2 + 250;


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

    /* DELAY INTERVALS - GAME LEVEL */

    static Timer timer;

    static final String DIFFECULTY_LEVEL[] = {"Easy", "Medium", "Hard"};
    static int interval = 400;
    static final int EASY_LEVEL_INTERVAL = 400;
    static final int MEDIUM_LEVEL_INTERVAL = 300;
    static final int HARD_LEVEL_INTERVAL = 200;












}
