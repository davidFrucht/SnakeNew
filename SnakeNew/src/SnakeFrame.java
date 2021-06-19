/* David Frucht 19/06/2021 */

import javax.swing.*;

public class SnakeFrame extends JFrame {

    GamePanel gameScene;
    Vars vars = new Vars();


    public static void main(String[] args) {

        new SnakeFrame();
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
        gameScene.setBounds(0,0,vars.WINDOW_WIDTH,vars.WINDOW_HEIGHT);

        this.add(gameScene);
        this.addKeyListener(keybordActions);

    }

    public GamePanel getGameScene() {

        return gameScene;
    }
}
