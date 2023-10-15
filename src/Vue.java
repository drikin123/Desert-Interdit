import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;



public class Vue{
    static Direction choix=Direction.EST;


    static int nbaction=0;
    static int nbaction2=0;
    static int nbaction3=0;

    private static JLabel labelActions = new JLabel("Nombre d'actions : 0");

    static String[] perso ={
            "jotaro",
            "polnareff",
            "kakyoin"
    };

    static String choixPerso=perso[0];



    public static void main(String[] args) {
        // Création du désert
        Case[][] cases = new Case[Desert.HAUTEUR][Desert.LARGEUR];

        Desert desert = new Desert(cases);

        // Ajout de sable sur certaines cases
        System.out.println("Avec sable : ");
        desert.declarer(0, 2, 1);
        desert.declarer(1, 1, 2);
        desert.declarer(1, 3, 3);
        desert.declarer(2, 0, 1);
        desert.declarer(2, 4, 1);
        desert.declarer(3, 1, 2);
        desert.declarer(3, 3, 1);
        desert.declarer(4, 2, 1);

        desert.setCaseContenu(0,4);
        desert.setCaseContenu2(0,4);
        desert.setCaseContenu3(0,4);
        desert.getCase(0,0).setContenuzone(TypeZone.Oasis);
        desert.getCase(0,4).setContenuzone(TypeZone.Crash);
        desert.getCase(0,2).setContenuzone(TypeZone.Indice);
        desert.getCase(1,3).setContenuzone(TypeZone.Indice2);
        desert.getCase(2,4).setContenuzone(TypeZone.Indice3);
        desert.getCase(2,0).setContenuzone(TypeZone.Indice4);
        desert.getCase(3,3).setContenuzone(TypeZone.Oasis2);
        desert.getCase(4,0).setContenuzone(TypeZone.Tunnel);
        desert.getCase(4,1).setContenuzone(TypeZone.Tunnel);
        desert.getCase(3,1).setContenuzone(TypeZone.Tunnel);
        desert.getCase(3,2).setContenuzone(TypeZone.Tunnel);
        desert.getCase(4,3).setContenuzone(TypeZone.Oasis);
        desert.getCase(4,4).setContenuzone(TypeZone.Piste);
        desert.setOeil(2,2);

        Controleur jeu = new Controleur(desert);
        JLabel labelTempete = jeu.getLabelTempete();
        JFrame frame = new JFrame("Jeu de désert");
        frame.getContentPane().add(jeu);



        // Création du bouton "Souffler"
        JButton soufflerButton = new JButton("Souffler");
        soufflerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le vent souffle !");
                System.out.println(desert);
                desert.souffler(Direction.random(), 1);
                desert.dechaine();
                nbaction=0;
                nbaction2=0;
                nbaction3=0;
                jeu.ecranFinal(frame,"Le jeu est fini!");
                jeu.repaint();
                System.out.println(Desert.niveauTempete);
                // Mise à jour de l'image de la tempête
                ImageIcon nouvelleImageTempete = Controleur.getImagesTempete(Desert.niveauTempete);
                labelTempete.setIcon(nouvelleImageTempete);
                labelTempete.repaint();
            }
        });

        // Création du bouton "droite"
        JButton droiteButton = new JButton("droite");
        droiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("droite");
                choix=Direction.EST;
            }
        });

        JButton gaucheButton = new JButton("gauche");
        gaucheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("gauche");
                choix=Direction.OUEST;
            }
        });

        JButton hautButton = new JButton("haut");
        hautButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("haut");
                choix=Direction.NORD;
            }
        });

        JButton basButton = new JButton("bas");
        basButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bas");
                choix=Direction.SUD;
            }
        });


        JButton deplaceButton = new JButton("deplace");
        deplaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                    if(nbaction<4){
                        System.out.println("deplace");
                        desert.deplaceJoueur(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[1]){
                    if(nbaction2<4){
                        System.out.println("deplace");
                        desert.deplaceJoueur2(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[2]){
                    if(nbaction3<4){
                        System.out.println("deplace");
                        desert.deplaceJoueur3(choix);

                        jeu.repaint();
                    }
                }


            }
        });

        JButton desensableButton = new JButton("desensable");
        desensableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                    if(nbaction<4){
                        System.out.println("desensable");
                        desert.desensablevoisin(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[1]){
                    if(nbaction2<4){
                        System.out.println("desensable");
                        desert.desensablevoisin2(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[2]){
                    if(nbaction3<4){
                        System.out.println("desensable");
                        desert.desensablevoisin3(choix);

                        jeu.repaint();
                    }
                }


            }
        });

        JButton desensable2Button = new JButton("desensableact");
        desensable2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                    if(nbaction<4){
                        System.out.println("desensableact");
                        desert.desensableActuelle();

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[1]){
                    if(nbaction2<4){
                        System.out.println("desensableact");
                        desert.desensableActuelle2();

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[2]){
                    if(nbaction3<4){
                        System.out.println("desensableact");
                        desert.desensableActuelle3();

                        jeu.repaint();
                    }
                }


            }
        });

        JButton explorerButton = new JButton("explorer");
        explorerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                    if(nbaction<4){
                        System.out.println("explorer");
                        desert.explorer(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[1]){
                    if(nbaction2<4){
                        System.out.println("explorer");
                        desert.explorer2(choix);

                        jeu.repaint();
                    }
                }else if(choixPerso==perso[2]){
                    if(nbaction3<4){
                        System.out.println("explorer");
                        desert.explorer3(choix);

                        jeu.repaint();
                    }
                }


            }
        });

        JButton exploreractButton = new JButton("exploreract");
        exploreractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                    if(nbaction<4){
                        System.out.println("exploreract");
                        desert.explorerActuelle();
                        desert.eauUp();
                        desert.eauUp2();
                        desert.eauUp3();
                        jeu.ecranFinal(frame,"Le jeu est fini!");
                        jeu.repaint();
                    }
                }else if(choixPerso==perso[1]){
                    if(nbaction2<4){
                        System.out.println("exploreract");
                        desert.explorerActuelle2();
                        desert.eauUp();
                        desert.eauUp2();
                        desert.eauUp3();
                        jeu.ecranFinal(frame,"Le jeu est fini!");
                        jeu.repaint();
                    }
                }else if(choixPerso==perso[2]){
                    if(nbaction3<4){
                        System.out.println("exploreract");
                        desert.explorerActuelle3();
                        desert.eauUp();
                        desert.eauUp2();
                        desert.eauUp3();
                        jeu.ecranFinal(frame,"Le jeu est fini!");
                        jeu.repaint();
                    }
                }


            }
        });


        JButton ramasseractButton = new JButton("ramasser");
        ramasseractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choixPerso==perso[0]){
                        System.out.println("ramasser");
                        desert.ramasser();
                        jeu.repaint();

                }else if(choixPerso==perso[1]){
                    System.out.println("ramasser");
                    desert.ramasser2();
                    jeu.repaint();
                }else if(choixPerso==perso[2]){
                    System.out.println("ramasser");
                    desert.ramasser3();
                    jeu.repaint();
                }


            }
        });

        JButton persoButton = new JButton("changement");
        persoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(choixPerso){
                    case "jotaro":
                        choixPerso=perso[1];
                                break;
                    case "polnareff":
                        choixPerso=perso[2];
                        break;
                    case "kakyoin":
                        choixPerso=perso[0];
                        break;
                }
                    System.out.println("changement");
                    jeu.repaint();


            }
        });

        JButton chaleurButton = new JButton("chaleur");
        chaleurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("chaleur"+desert.mortdeSoif());
                desert.eauDown();
                desert.eauDown2();
                desert.eauDown3();
                frame.revalidate();
                jeu.ecranFinal(frame,"Le jeu est fini !");
                jeu.repaint();



            }
        });

        // Ajout des boutons au conteneur principal
        JPanel buttonsPanel = new JPanel();
        JPanel buttonsPanel2 = new JPanel();



        buttonsPanel2.add(soufflerButton);
        buttonsPanel2.add(gaucheButton);
        buttonsPanel2.add(hautButton);
        buttonsPanel2.add(basButton);
        buttonsPanel2.add(droiteButton);
        buttonsPanel2.add(persoButton);
        buttonsPanel2.add(chaleurButton);
        frame.getContentPane().add(buttonsPanel2, BorderLayout.NORTH);

        buttonsPanel.add(deplaceButton);
        buttonsPanel.add(explorerButton);
        buttonsPanel.add(exploreractButton);
        buttonsPanel.add(desensableButton);
        buttonsPanel.add(desensable2Button);
        buttonsPanel.add(ramasseractButton);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);



        // Création du panneau pour la tempête
        JPanel tempetePanel = new JPanel();
        tempetePanel.setLayout(new BoxLayout(tempetePanel, BoxLayout.Y_AXIS));
        tempetePanel.add(labelTempete);

        // Ajout du panneau pour la tempête à la fenêtre
        frame.getContentPane().add(tempetePanel, BorderLayout.EAST);


        JLabel labelActions = new JLabel("C'est parti!");
        frame.add(labelActions, BorderLayout.WEST);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);






    }
}
