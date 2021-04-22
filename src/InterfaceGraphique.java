import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGraphique extends JFrame {
    //attribute
    //JButton[][] jeu;
    InterfaceGraphique(String title, int width, int height) {
        // creation de la fenetre
        super(title);
        // Menu
        JMenuBar menu = new JMenuBar();
        // Menu - Game
        JMenu game = new JMenu("Game");
        JMenuItem newG = new JMenuItem("New game");
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
        gameSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameSettings();
            }
        });
        settings.add(apparence);
        settings.add(gameSettings);
        menu.add(settings);
        // Menu - Help
        JMenu help = new JMenu("Help");
        JMenuItem rule = new JMenuItem("Rules");
        JMenuItem astuce = new JMenuItem("Astuce");
        JMenuItem aPropos = new JMenuItem("A propos");
        help.add(rule);
        help.add(astuce);
        help.add(aPropos);
        menu.add(help);
        // Menu - Quit
        JMenu quit = new JMenu("Quit");
        JMenuItem saveQuit = new JMenuItem("Save & quit");
        JMenuItem quitGame = new JMenuItem("Quit");
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceGraphique.super.dispose();
            }
        });
        quit.add(quitGame);
        quit.add(saveQuit);
        menu.add(quit);

        this.add(menu,BorderLayout.PAGE_START);
        //Creation de l'espace du plateau
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel,BorderLayout.CENTER);
        //finalisation de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(width, height);
        this.setVisible(true);
    }


}
