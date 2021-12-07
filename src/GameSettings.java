import javax.swing.*;

public class GameSettings extends JFrame {
    //attribute
    private final Plateau refPlateau;
    private final JTextField nbBombe = new JTextField();
    private final JTextField nbCaseX = new JTextField();
    private final JTextField nbCaseY = new JTextField();
    //constructor
    GameSettings(Plateau plateau) {
        // init frame
        super("Game settings");
        refPlateau = plateau;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        this.add(panel);
        // panel 1 (nbBombes)
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        JLabel label1 = new JLabel("Nbr Bombes :    ");
        nbBombe.setText(String.valueOf(refPlateau.getNbrBombes()));
        panel1.add(label1);
        panel1.add(nbBombe);
        panel.add(panel1);
        // panel 2 (nbCaseX)
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        JLabel label2 = new JLabel("Nbr case en X : ");
        nbCaseX.setText(String.valueOf(refPlateau.getDimX()));
        panel2.add(label2);
        panel2.add(nbCaseX);
        panel.add(panel2);
        // panel 3 (nbCaseY)
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        JLabel label3 = new JLabel("Nbr case en Y : ");
        nbCaseY.setText(String.valueOf(refPlateau.getDimY()));
        panel3.add(label3);
        panel3.add(nbCaseY);
        panel.add(panel3);
        // panel 4 (Bouton)
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        JButton ButtonCancel = new JButton("Cancel");
        ButtonCancel.addActionListener((event) -> this.dispose());
        JButton ButtonDone = new JButton("Done");
        ButtonDone.addActionListener((event) -> {
            refPlateau.setNbrBombes(Integer.parseInt(nbBombe.getText()));
            refPlateau.setDimX(Integer.parseInt(nbCaseX.getText()));
            refPlateau.setDimY(Integer.parseInt(nbCaseY.getText()));
            this.dispose();
        });
        panel4.add(ButtonDone);
        panel4.add(ButtonCancel);
        panel.add(panel4);
        // finalisation de la fenêtre
        this.pack();
        this.setSize(300,125);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
}
