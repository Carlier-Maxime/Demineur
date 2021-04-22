import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
    //attribute
    private int dimX;
    private int dimY;
    private int nbrBombes;
    private int[][][] jeu;
    //constructor
    public Plateau(int dimX, int dimY, int nbrBombes) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.nbrBombes = nbrBombes;
        this.jeu = new int[dimY][dimX][2];
        initJeu();
    }
    //methode
    private void generateBombes() {
        int[] tabBombes = new int[dimX*dimY];
        for (int i=0; i < dimY*dimX; i++) {
            if (i<nbrBombes) {
                tabBombes[i]=1;
            } else {
                tabBombes[i]=0;
            }
        }
        List listBombes = new ArrayList();
        Collections.addAll(listBombes,tabBombes);
        Collections.shuffle(listBombes);
        int index=0;
        for (int i=0; i<dimY; i++) {
            for (int j=0; j<dimX; j++) {
                jeu[i][j][0]=(int) listBombes.get(index);
                index++;
            }
        }
    }
    private int calculAdjacence(int i, int j) {
        int n = 0;
        for (int y=i-1; y<i+1; i++) {
            for (int x=j-1; x<j+1; j++) {
                if (y!=i && x!=j && y>0 && y<dimY && x>0 && x<dimX) {
                  n++;
                }
            }
        }
        return n;
    }
    private void initJeu() {
        generateBombes();
        for (int i=0; i<jeu.length; i++) {
            for (int j=0; j<jeu[i].length; j++) {
                jeu[i][j][1]=calculAdjacence(i,j);
                jeu[i][j][2]=0;
            }
        }
    }
}
