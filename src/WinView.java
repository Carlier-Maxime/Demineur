import javax.swing.*;
import java.awt.*;

public class WinView extends JFrame {
    public WinView() {
        super("Win Game");
        try {
            ImageIcon img = new ImageIcon("src/data/win.jpg");
            JLabel label = new JLabel();
            label.setIcon(img);
            add(label);
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        setSize(225,225);
        Dimension dimScreen = getToolkit().getScreenSize();
        setLocation(dimScreen.width/2-299/2, dimScreen.height/2-190/2);
        setVisible(true);
    }
}
