/* David Frucht 19/06/2021 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeFrame extends JFrame {

    GamePanel gameScene;
    Vars vars = new Vars();


    public static void main(String[] args) {

        new MainMenu();
    }

    public SnakeFrame(){
        this.setVisible(true);
        this.setSize(vars.WINDOW_WIDTH, vars.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        this.setTitle("SNAKE");

        KeybordActions keybordActions = new KeybordActions(this);

        gameScene = new GamePanel();
        gameScene.setBounds(Vars.WINDOW_X,Vars.WINDOW_Y,vars.WINDOW_WIDTH,vars.WINDOW_HEIGHT);

        this.add(gameScene);
        this.addKeyListener(keybordActions);

    }

    public GamePanel getGameScene() {

        return gameScene;
    }
}
