/* David Frucht 19/06/2021 */
import javax.swing.*;
import java.util.*;

public class Snake {

    Directions.Direction Direction;

    private int numX, numY;             // used to add x and y values to point list ***** how to move from vars ****

    Random rand;                        // used for random place the food


    public boolean GetWinner () {

        return Vars.winner ;

    }

    public int GetScoreCounter () {

        return Vars.scoreCounter;

    }

    public Snake(int numX, int numY) {

        this.numX = numX;
        this.numY = numY;
        rand = new Random();


        CreateNewFood();

        /* Init snake in length of 4 */
        Vars.Points.add(new Point(numX / 2 + 1, numY / 2));
        Vars.Points.add(new Point(numX / 2 + 0, numY / 2));
        Vars.Points.add(new Point(numX / 2 - 1, numY / 2));
        Vars.Points.add(new Point(numX / 2 - 2, numY / 2));

        /* Default Direction to move is Right */
        Direction = Directions.Direction.Right;

    }

    public void Move() {

        int count = Vars.Points.size();

        for (int i = count - 1; i > 0; --i)                    //  move all snake
            Vars.Points.get(i).Set(Vars.Points.get(i - 1));

        switch (Direction) {                                    // head direction
            case Left:
                Vars.Points.get(0).X = (Vars.Points.get(0).X + numX - 1) % numX;
                break;
            case Right:
                Vars.Points.get(0).X = (Vars.Points.get(0).X + 1) % numX;
                break;
            case Up:
                Vars.Points.get(0).Y = (Vars.Points.get(0).Y + numY - 1) % numY;
                break;
            case Down:
                Vars.Points.get(0).Y = (Vars.Points.get(0).Y + 1) % numY;
                break;
            case Space:
                endGame();
                break;
        }

        CheckCollision();

        if (Vars.Points.size() == Vars.WINING_SCORE) {
            Vars.winner = true;
              return;
        }

        if (CanEat())
            FinishEating();

        Vars.canChangeDirection = true;


    }

    private void CheckCollision () {

        /* The below if's list all the possibilities of loosing the game */
        /* Vars.HEAD_OF_SNAKE + 1 is used to check if the second element of the snake touching the border, while the head is already on the opposite side */

        for (int i = Vars.Points.size() - 1; i > 0; i--) {

            if ((Vars.Points.get(i).X == Vars.Points.get(Vars.HEAD_OF_SNAKE).X && Vars.Points.get(i).Y == Vars.Points.get(Vars.HEAD_OF_SNAKE).Y) ||           // the head of snake touches body of snake
                (Vars.Points.get(Vars.HEAD_OF_SNAKE + 1).X == Vars.LEFT_BORDER && Vars.Points.get(Vars.HEAD_OF_SNAKE).X == Vars.RIGHT_BORDER) ||              // the head is in border left
                (Vars.Points.get(Vars.HEAD_OF_SNAKE + 1).X == Vars.RIGHT_BORDER && Vars.Points.get(Vars.HEAD_OF_SNAKE).X == Vars.LEFT_BORDER) ||              // the head is in border right
                (Vars.Points.get(Vars.HEAD_OF_SNAKE + 1).Y == Vars.UP_BORDER && Vars.Points.get(Vars.HEAD_OF_SNAKE).Y == Vars.DOWN_BORDER) ||                 // the head is in border up
                (Vars.Points.get(Vars.HEAD_OF_SNAKE + 1).Y == Vars.DOWN_BORDER && Vars.Points.get(Vars.HEAD_OF_SNAKE).Y == Vars.UP_BORDER ))                  // the head is in border down
                    endGame();

            }
    }

    private Boolean CanEat()
    {
        if (Vars.Points.get(Vars.HEAD_OF_SNAKE).Equals(Vars.Food))                       // if the x and y of the snake's head is equal to food then eat
            return true;

        return false;
    }

    private void FinishEating()
    {
        /* Adding the last points will enlarge the snake */
        Point last = Vars.Points.get(Vars.Points.size() - 1);
        Vars.Points.add(new Point(last.X, last.Y));

        Vars.scoreCounter++ ;
        CreateNewFood();
    }

    private void CreateNewFood()
    {
        boolean newFood = true;

        /* The while loop is used for checking that the new food will not be in the same location of the snake */

        while (newFood)
        {
            Vars.Food.X = rand.nextInt(numX) + 0;
            Vars.Food.Y = rand.nextInt(numY) + 0;

            newFood = false;

            for (int i = 0; i < Vars.Points.size(); i++)
                if (Vars.Points.get(i).Equals(Vars.Food))
                    newFood = true;
        }
    }

    public void SetDirection(Directions.Direction direction)
    {

        if (Vars.canChangeDirection)
        {
            if (Direction == Direction.Left && direction == Directions.Direction.Right) {
                return;
            }

            if (Direction == Direction.Right && direction == Direction.Left) {
                return;
            }

            if (Direction == Direction.Up && direction == Direction.Down) {
                return;
            }

            if (Direction == Direction.Down && direction == Direction.Up) {
                //boolean canChangeDirection=true;
                return;
            }

            if (Direction == Directions.Direction.Space)
                Vars.canChangeDirection  = false ;

                Direction = direction;
                Vars.canChangeDirection = false;
        }
    }

    private void endGame()
    {
        Vars.inGame = false;
        JOptionPane.showMessageDialog(null, "Game Over");
        System.exit(0);
    }

}
