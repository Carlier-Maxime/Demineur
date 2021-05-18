import javax.swing.*;
import java.awt.*;

public class Case extends JButton {
    //attribute
    private Plateau refPlateau;
    private int posX;
    private int posY;
    //constructor
    Case(Plateau refPlateau, int posX, int posY) {
        super("");
        this.refPlateau=refPlateau;
        this.posX=posX;
        this.posY=posY;
        this.setMinimumSize(new Dimension(25,25));
        this.setMaximumSize(new Dimension(25,25));
        this.setPreferredSize(new Dimension(25,25));
        this.setSize(25,25);
        this.setVisible(true);
        this.addActionListener(event -> RightClic());
    }
    //getter & setter
    //methode
    private void RightClic() {
        System.out.println("clic");
    }
}
