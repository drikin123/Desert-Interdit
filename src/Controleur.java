import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controleur extends JPanel {
    private Desert desert;
    private int tailleCase = 100;

    private JLabel labelTempete;

    static ImageIcon[] imagesTempete = {
            new ImageIcon("./images/tempete/dechaine.png"),
            new ImageIcon("./images/tempete/dechaine (1).png"),
            new ImageIcon("./images/tempete/dechaine (2).png"),
            new ImageIcon("./images/tempete/dechaine (3).png"),
            new ImageIcon("./images/tempete/dechaine (4).png"),
            new ImageIcon("./images/tempete/dechaine (5).png"),
            new ImageIcon("./images/tempete/dechaine (6).png"),
            new ImageIcon("./images/tempete/dechaine (7).png"),
            new ImageIcon("./images/tempete/dechaine (8).png"),
            new ImageIcon("./images/tempete/dechaine (9).png"),
            new ImageIcon("./images/tempete/dechaine (10).png"),
            new ImageIcon("./images/tempete/dechaine (11).png"),
            new ImageIcon("./images/tempete/dechaine (12).png"),
            new ImageIcon("./images/tempete/dechaine (13).png")
    };


    public static ImageIcon getImagesTempete(int nb) {
        return imagesTempete[nb];
    }

    public Controleur(Desert d) {
        this.desert = d;
        setBackground(new java.awt.Color(100, 100, 100));
        setPreferredSize(new Dimension(Desert.HAUTEUR * tailleCase, Desert.LARGEUR * tailleCase));
        JLabel label = new JLabel();
        label.setIcon(getImagesTempete(Desert.niveauTempete));
        this.labelTempete = label;
        add(labelTempete); // Ajout de labelTempete au panneau une fois initialisé


    }



    public int getTailleCase() {
        return tailleCase;
    }

    public JLabel getLabelTempete() {
        return labelTempete;
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Desert.HAUTEUR; i++) {
            for (int j = 0; j < Desert.LARGEUR; j++) {
                ImageIcon imga = new ImageIcon("./images/sahara.jpg");
                g.drawImage(imga.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                if(desert.getCase(i,j).getContenuzone()==TypeZone.Oasis || desert.getCase(i,j).getContenuzone()==TypeZone.Oasis2){
                    ImageIcon img = new ImageIcon("./images/arbre.png");
                    g.drawImage(img.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Oasis){
                        ImageIcon imgc = new ImageIcon("./images/oasis.png");
                        g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                    if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Oasis2){
                        ImageIcon imgc = new ImageIcon("./images/feinte.png");
                        g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                }
                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Crash){
                    ImageIcon imgc = new ImageIcon("./images/crash.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }

                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Piste){
                    ImageIcon imgc = new ImageIcon("./images/piste.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }

                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Indice){
                    ImageIcon imgc = new ImageIcon("./images/moteur.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }
                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Indice2){
                    ImageIcon imgc = new ImageIcon("./images/helice.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }
                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Indice3){
                    ImageIcon imgc = new ImageIcon("./images/gouvernail.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }
                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Indice4){
                    ImageIcon imgc = new ImageIcon("./images/capteur.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }

                if(desert.getCase(i,j).getPosition() && desert.getCase(i,j).getContenuzone()==TypeZone.Tunnel){
                    ImageIcon imgc = new ImageIcon("./images/tunnel.png");
                    g.drawImage(imgc.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }

                if(desert.getCase(i, j) instanceof Oeil){
                    ImageIcon img = new ImageIcon("./images/oeil.png");
                    g.drawImage(img.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                }
                else if (desert.getCase(i, j).getNiveausable() > 1) {
                    ImageIcon img = new ImageIcon("./images/niveau2.png");
                    g.drawImage(img.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                } else if (desert.getCase(i, j).getNiveausable() == 1){
                    ImageIcon img = new ImageIcon("./images/niveau.png");
                    g.drawImage(img.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    if(desert.getCase(i, j).getContenu() instanceof Joueur){
                        ImageIcon imgb = new ImageIcon("./images/perso.png");
                        g.drawImage(imgb.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                    if(desert.getCase(i, j).getContenu2() instanceof Joueur){
                        ImageIcon imgb = new ImageIcon("./images/perso2.png");
                        g.drawImage(imgb.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                    if(desert.getCase(i, j).getContenu3() instanceof Joueur){
                        ImageIcon imgb = new ImageIcon("./images/perso3.png");
                        g.drawImage(imgb.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                }
                else {
                    if (desert.getCase(i, j).getContenu() instanceof Joueur) {
                        ImageIcon img = new ImageIcon("./images/perso.png");
                        g.drawImage(img.getImage(), j * tailleCase, i * tailleCase, tailleCase, tailleCase, null);
                    }
                    if(desert.getCase(i, j).getContenu2() instanceof Joueur){
                        ImageIcon imgb = new ImageIcon("./images/perso2.png");
                        g.drawImage(imgb.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                    if(desert.getCase(i, j).getContenu3() instanceof Joueur){
                        ImageIcon imgb = new ImageIcon("./images/perso3.png");
                        g.drawImage(imgb.getImage(), j*tailleCase, i*tailleCase, tailleCase, tailleCase, null);
                    }
                }
            }
        }
    }

    public void ecranFinal(JFrame frame,String  message) {


        if(Desert.niveauTempete>13 || desert.totalSable()>=43 || desert.mortdeSoif() || desert.gagnerPartie()){
            // Supprimer le panneau de jeu actuel (this)
            frame.getContentPane().remove(this);
        }


            // Créer un nouveau panneau pour l'écran de fin
            JPanel panel = new JPanel(new BorderLayout());

            JLabel label = new JLabel(message, SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);

            JButton exitButton = new JButton("Quitter");
            panel.add(exitButton, BorderLayout.SOUTH);

            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }

            });







        // Ajouter le nouveau panneau à la fenêtre et rafraîchir

            frame.getContentPane().add(panel);
            frame.revalidate();
            frame.repaint();


    }


}


