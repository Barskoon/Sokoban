import javax.swing.JPanel;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image[] imageGoal = new Image[9];

    public Canvas(Model model) {
        this.model = model;
        setBackground(new Color(60,116,9));
        setOpaque(true);
        File fileNameImageGamer = new File ("images/gamer.png");
        File fileNameImageWall = new File ("images/wall.png");
        File fileNameImageBox = new File ("images/box.png");
        File fileNameImageGoal1 = new File ("images/goal1.png");
        File fileNameImageGoal2 = new File ("images/goal2.png");
        File fileNameImageGoal3 = new File ("images/goal3.png");
        File fileNameImageGoal4 = new File ("images/goal4.png");
        File fileNameImageGoal5 = new File ("images/goal5.png");
        File fileNameImageGoal6 = new File ("images/goal6.png");
        File fileNameImageGoal7 = new File ("images/goal7.png");
        File fileNameImageGoal8 = new File ("images/goal8.png");
        File fileNameImageGoal9 = new File ("images/goal9.png");

        try{
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal[0] = ImageIO.read(fileNameImageGoal1);
            imageGoal[1] = ImageIO.read(fileNameImageGoal2);
            imageGoal[2] = ImageIO.read(fileNameImageGoal3);
            imageGoal[3] = ImageIO.read(fileNameImageGoal4);
            imageGoal[4] = ImageIO.read(fileNameImageGoal5);
            imageGoal[5] = ImageIO.read(fileNameImageGoal6);
            imageGoal[6] = ImageIO.read(fileNameImageGoal7);
            imageGoal[7] = ImageIO.read(fileNameImageGoal8);
            imageGoal[8] = ImageIO.read(fileNameImageGoal9);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        int start = 0;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 0;
        int level = model.getLevel() - 1;

        int[][] desktop = model.getDesktop();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j <desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                      g.drawImage(imageGamer, x, y, null);
                } else if (desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if (desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if (desktop[i][j] == 4) {
                    g.drawImage(imageGoal[level], x, y, null);
                }
                x = x + width + offset;
            }
            x = start;
            y = y + height + offset;
        }
    }
}
