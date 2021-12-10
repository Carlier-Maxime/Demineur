import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1) RightClic();
                if (e.getButton()==3) leftClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setBackground(Color.GRAY);
        setForeground(new Color(203, 201, 201));
        setText("?");
    }
    //getter & setter
    //methode
    private void RightClic() {
        if (!reveal()) refPlateau.gameOver();
        refPlateau.isWin();
    }

    public boolean reveal(){
        if (infoCase()[2]==2){
            if (infoCase()[0]==1) refPlateau.setBombeDiscover(refPlateau.getBombeDiscover()-1);
        }
        if (infoCase()[2]!=1){
            if (infoCase()[0]==1) {
                setText("¤");
                setBackground(new Color(199,0,0));
                infoCase()[2]=1;
                return false;
            }
            else {
                setBackground(new Color(16*infoCase()[1],128-16*infoCase()[1],0));
                setText(Integer.toString(infoCase()[1]));
                if (infoCase()[1]==0) {
                    infoCase()[2]=1;
                    for (int i=posY-1; i<=posY+1; i++){
                        for (int j=posX-1; j<=posX+1; j++){
                            if ((i!=posY || j!=posX) && i>=0 && j>=0 && i<refPlateau.getDimY() && j<refPlateau.getDimX()){
                                Case caze = refPlateau.getRefUI().getCase(i, j);
                                if (caze.infoCase()[2]==1) continue;
                                new Thread(caze::reveal).start();
                            }
                        }
                    }
                }
            }
        }
        infoCase()[2]=1;
        return true;
    }

    private int[] infoCase(){
        return refPlateau.getInfoCase(posX,posY);
    }

    @Override
    public String toString() {
        return "Case{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public void leftClick(){
        if (infoCase()[2]==0) {
            if (infoCase()[0]==1) refPlateau.setBombeDiscover(refPlateau.getBombeDiscover()+1);
            setText("¶");
            setBackground(new Color(0, 22, 172));
            infoCase()[2]=2;
            refPlateau.isWin();
        }
    }
}
