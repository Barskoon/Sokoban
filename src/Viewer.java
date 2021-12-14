import javax.swing.*;
import java.awt.*;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    private JLabel levelLabel;
    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();

        JMenuBar menuBar = createLevelMenu(controller);
        menuBar.setBackground(new Color(215,64,37));

        JButton restartButton = createRestartButton(controller);
        menuBar.add(restartButton);

        levelLabel = createLevelLabel();
        menuBar.add(levelLabel);
        canvas = new Canvas(model);
        frame = new JFrame("PokeBan");
        frame.setSize(501,565);
        frame.setLocationRelativeTo(null);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(controller);
        frame.setJMenuBar(menuBar);
        frame.add("Center", canvas);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void update() {
        canvas.repaint();
    }

    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You are won!");
        return true;
    }
    private JMenuBar createLevelMenu(Controller controller) {
        JMenuBar menuBar = new JMenuBar();
        JMenu levelMenu = new JMenu("Levels");
        levelMenu.setForeground(new Color(255,203,50));
        JMenuItem [] level = new JMenuItem[10];

        for (int i = 0; i<9; i++) {
            level[i] = new JMenuItem("Level "+ (i + 1));
            level[i].addActionListener(controller);
            level[i].setActionCommand("level" + (i + 1));
            level[i].setBackground(new Color(53,103,177));
            level[i].setForeground(new Color(255,203,50));
            levelMenu.add(level[i]);
        }

        menuBar.add(levelMenu);

        return menuBar;
    }

    private JButton createRestartButton(Controller controller) {
        JButton button = new JButton("Reset");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.addActionListener(controller);
        button.setActionCommand("resetButton");
        button.setForeground(new Color(255,203,50));
        return button;
    }

    private JLabel createLevelLabel() {
        JLabel label = new JLabel("Level #1");
        label.setBorder(BorderFactory.createEmptyBorder(0, 300, 0, 0));
        label.setForeground(new Color(255,203,50));
        return label;
    }
    public void setLevelLabel(int lvl) {
        levelLabel.setText("Level #" + lvl);
    }
    public void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(frame, "Error: " + error);
    }
}
