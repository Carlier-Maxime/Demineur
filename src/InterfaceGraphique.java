import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterfaceGraphique extends JFrame {
    //attribute
    private Plateau plateau;
    private JPanel panelPlateau;
    private Case[][] jeu;
    //constructor
    InterfaceGraphique(String title, int width, int height) {
        // creation de la fenetre
        super(title);
        //init plateau
        this.plateau = new Plateau(this,10,10,43);
        this.jeu = new Case[10][10];
        // Menu
        JMenuBar menu = new JMenuBar();
        // Menu - Game
        JMenu game = new JMenu("Game");
        JMenuItem newG = new JMenuItem("New game");
        newG.addActionListener((event) -> displayPlateau());
        JMenuItem loadG = new JMenuItem("Load game");
        JMenuItem saveG = new JMenuItem("Save game");
        game.add(newG);
        game.add(loadG);
        game.add(saveG);
        menu.add(game);
        // Menu - Settings
        JMenu settings = new JMenu("Settings");
        JMenuItem apparence = new JMenuItem("Apparence");
        JMenuItem gameSettings =  new JMenuItem("Game settings");
        gameSettings.addActionListener((event) -> new GameSettings(plateau));
        settings.add(apparence);
        settings.add(gameSettings);
        menu.add(settings);
        // Menu - Help
        JMenu help = new JMenu("Help");
        JMenuItem rule = new JMenuItem("Rules");
        JMenuItem astuce = new JMenuItem("Astuce");
        JMenuItem aPropos = new JMenuItem("A propos");
        aPropos.addActionListener((event) -> {
            System.out.println("nbBombes : "+plateau.getNbrBombes());
            System.out.println("dimX : "+plateau.getDimX());
            System.out.println("dimY : "+plateau.getDimY());
        });
        help.add(rule);
        help.add(astuce);
        help.add(aPropos);
        menu.add(help);
        // Menu - Quit
        JMenu quit = new JMenu("Quit");
        JMenuItem saveQuit = new JMenuItem("Save & quit");
        JMenuItem quitGame = new JMenuItem("Quit");
        quitGame.addActionListener((event) -> InterfaceGraphique.super.dispose());
        quit.add(quitGame);
        quit.add(saveQuit);
        menu.add(quit);

        this.add(menu,BorderLayout.PAGE_START);
        //Creation de l'espace du plateau
        panelPlateau = new JPanel();
        panelPlateau.setBackground(Color.DARK_GRAY);
        panelPlateau.setLayout(new BoxLayout(panelPlateau,BoxLayout.Y_AXIS));
        this.add(panelPlateau,BorderLayout.CENTER);
        //finalisation de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(width, height);
        this.setVisible(true);
    }
    //methode
    public void displayPlateau() {
        panelPlateau.removeAll();
        plateau.initJeu();
        jeu = new Case[plateau.getDimY()][plateau.getDimX()];
        for (int i=0; i<plateau.getDimY(); i++) {
            JPanel ligne =  new JPanel();
            ligne.setLayout(new BoxLayout(ligne,BoxLayout.X_AXIS));
            ligne.setBackground(Color.DARK_GRAY);
            for (int j=0; j<plateau.getDimX(); j++) {
                jeu[i][j] = new Case(plateau,j,i);
                ligne.add(jeu[i][j]);
            }
            ligne.setPreferredSize(ligne.getPreferredSize());
            panelPlateau.add(ligne);
        }
        panelPlateau.setPreferredSize(getPreferredSize());
        this.pack();
    }


}
