import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Plateau {
    //attribute
    private final InterfaceGraphique refUI;
    private int dimX;
    private int dimY;
    private int nbrBombes;
    private int bombeDiscover;
    private int[][][] jeu;
    private boolean firstReveal;
    private int nbRemainingCase;
    //constructor
    public Plateau(InterfaceGraphique UI, int dimX, int dimY, int nbrBombes) {
        this.refUI = UI;
        this.dimX = dimX;
        this.dimY = dimY;
        this.nbrBombes = nbrBombes;
        bombeDiscover = 0;
        this.jeu = new int[dimY][dimX][3];
        firstReveal = true;
        nbRemainingCase = dimX*dimY;
    }
    //getter & setter

    public InterfaceGraphique getRefUI() {
        return refUI;
    }

    public int getDimX() {
        return dimX;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public int getNbrBombes() {
        return nbrBombes;
    }

    public void setNbrBombes(int nbrBombes) {
        this.nbrBombes = nbrBombes;
    }

    //methode
    private void generateBombes() {
        Integer[] tabBombes = new Integer[dimX*dimY];
        for (int i=0; i < dimY*dimX; i++) {
            if (i<nbrBombes) {
                tabBombes[i]=1;
            } else {
                tabBombes[i]=0;
            }
        }
        List<Integer> listBombes = Arrays.asList(tabBombes);
        Collections.shuffle(listBombes);
        int index=0;
        for (int i=0; i<dimY; i++) {
            for (int j=0; j<dimX; j++) {
                jeu[i][j][0]=listBombes.get(index);
                index++;
            }
        }
    }
    private int calculAdjacence(int i, int j) {
        int n = 0;
        for (int y=i-1; y<=i+1; y++) {
            for (int x=j-1; x<=j+1; x++) {
                if ((y!=i || x!=j) && y>=0 && y<dimY && x>=0 && x<dimX) {
                    if (jeu[y][x][0]==1) n++;
                }
            }
        }
        return n;
    }
    public void initJeu() {
        jeu = new int[dimY][dimX][3];
        generateBombes();
        for (int i=0; i<jeu.length; i++) {
            for (int j=0; j<jeu[i].length; j++) {
                jeu[i][j][1]=calculAdjacence(i,j);
                jeu[i][j][2]=0;
            }
        }
        firstReveal = true;
    }
    public int[] getInfoCase(int posX, int posY) {
        return jeu[posY][posX];
    }

    public void gameOver(){
        refUI.showAllCase();
        new LoseView();
    }

    public void isWin(){
        if (nbrBombes==bombeDiscover || nbRemainingCase==nbrBombes-bombeDiscover){
            refUI.showAllCase();
            new WinView();
        }
    }
    public void setBombeDiscover(int bombeDiscover){
        this.bombeDiscover = bombeDiscover;
    }

    public int getBombeDiscover() {
        return bombeDiscover;
    }

    public boolean isFirstReveal() {
        return firstReveal;
    }

    public void setFirstReveal(boolean firstReveal) {
        this.firstReveal = firstReveal;
    }

    public void setNbRemainingCase(int nbRemainingCase) {
        this.nbRemainingCase = nbRemainingCase;
    }

    public int getNbRemainingCase() {
        return nbRemainingCase;
    }
}
