/* David Frucht 19/06/2021 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybordActions implements KeyListener {

    private SnakeFrame frame;

    public KeybordActions (SnakeFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyTyped (KeyEvent e) {
    }

    @Override
    public void keyPressed (KeyEvent e) {

        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                frame.getGameScene().snake.SetDirection(Directions.Direction.Left);
                break;

            case KeyEvent.VK_RIGHT:
                frame.getGameScene().snake.SetDirection(Directions.Direction.Right);
                break;

            case KeyEvent.VK_DOWN:
                frame.getGameScene().snake.SetDirection(Directions.Direction.Down);
                break;

            case KeyEvent.VK_UP:
                frame.getGameScene().snake.SetDirection(Directions.Direction.Up);
                break;

            case KeyEvent.VK_SPACE:
                frame.getGameScene().snake.SetDirection(Directions.Direction.Space);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
