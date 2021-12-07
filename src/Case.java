import javax.swing.*;
import java.awt.*;

public class Case extends JButton {
    //attribute
    private final Plateau refPlateau;
    private final int posX;
    private final int posY;
    //constructor
    Case(Plateau refPlateau, int posX, int posY) {
        super();
        this.refPlateau=refPlateau;
        this.posX=posX;
        this.posY=posY;
        this.addActionListener(event -> RightClic());
        setBackground(Color.GRAY);
        setText("?");
    }
    //getter & setter
    //methode
    private void RightClic() {
        if (infoCase()[2]==0){
            if (infoCase()[0]==1) {
                setText("¤");
                setBackground(new Color(199,0,0));
                System.out.println("PERDU !!!");
            }
            else {
                setBackground(new Color(16*infoCase()[1],128-16*infoCase()[1],0));
                setText(Integer.toString(infoCase()[1]));
                if (infoCase()[1]==0) System.out.println("reveal other case because 0 bombe adjacent, soon");
            }
            infoCase()[2]=1;
        }
    }

    private int[] infoCase(){
        return refPlateau.getInfoCase(posX,posY);
    }
}
