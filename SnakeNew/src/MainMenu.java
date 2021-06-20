import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu(){
        this.setSize(Vars.WINDOW_WIDTH, Vars.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        this.setTitle("SNAKE");

        JTextPane instructionText = new JTextPane();
        instructionText.setBounds(Vars.INSTRUCTION_TEXT_X, Vars.INSTRUCTION_TEXT_Y, Vars.INSTRUCTION_TEXT_WIDTH,  Vars.INSTRUCTION_TEXT_HEIGHT);
        instructionText.setEditable(false);
        instructionText.setOpaque(false);
        instructionText.setBorder(BorderFactory.createEmptyBorder());
        instructionText.setText("Welcome to Jenny and David Snake Game!!\n\nGame Instructions:\nUp Arrow - Move Snake Up\nDown Arrow - Move Snake Down\nLeft Arrow - Move Snake Left\nRight Arrow - Move Snake Right");

        JLabel chooseLevel = new JLabel("Select Level:");
        chooseLevel.setBounds(Vars.CHOOSE_LEVEL_LABEL_X,Vars.CHOOSE_LEVEL_LABEL_Y,Vars.CHOOSE_LEVEL_LABEL_WIDTH,Vars.CHOOSE_LEVEL_LABEL_HEIGHT);
        this.add(chooseLevel);


        JComboBox comboBoxLevel = new JComboBox();
        comboBoxLevel.setModel(new DefaultComboBoxModel(Vars.DIFFECULTY_LEVEL));
        comboBoxLevel.setBounds(Vars.COMBO_BOX_LEVEL_X, Vars.COMBO_BOX_LEVEL_Y, Vars.COMBO_BOX_LEVEL_WIDTH, Vars.COMBO_BOX_LEVEL_HEIGHT);
        this.add(comboBoxLevel);


        JButton startGameButton = new JButton();
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBoxLevel.getSelectedItem() == "Easy")
                    Vars.interval = Vars.EASY_LEVEL_INTERVAL;

                if (comboBoxLevel.getSelectedItem() == "Medium")
                    Vars.interval = Vars.MEDIUM_LEVEL_INTERVAL;

                if (comboBoxLevel.getSelectedItem() == "Hard")
                    Vars.interval = Vars.HARD_LEVEL_INTERVAL;

                new SnakeFrame();
            }
        });

        startGameButton.setBounds(Vars.START_GAME_BUTTON_X,Vars.START_GAME_BUTTON_Y,Vars.START_GAME_BUTTON_WIDTH,Vars.START_GAME_BUTTON_HEIGHT);
        startGameButton.setText("Start");

        this.add(instructionText);
        this.add(startGameButton);
        this.setVisible(true);

    }
}
