public class Main {
    public static void main(String[] args) {
        // Création du désert
        Case[][] cases = new Case[Desert.HAUTEUR][Desert.LARGEUR];

        Desert desert = new Desert(cases);

        // Vérification de l'affichage des cases
        System.out.println("De base : ");
        System.out.println(desert);
        System.out.println(desert.totalSable());

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
        System.out.println(desert);
        System.out.println(desert.totalSable());

        // Test de l'ajout de l'oeil
        System.out.println("Ajout Oeil : ");
        desert.setOeil(2,2);
        System.out.println(desert);


        // Test de la méthode souffler
        System.out.println("Apres souffle :");
        int res=0;
        /*while(res<10){
            desert.souffler(Direction.random(),1);
            System.out.println(desert);
            res++;
        }*/

        /*desert.deplaceOeil(0,2,Direction.NORD);
        System.out.println(desert);
        desert.deplaceOeil(0,2,Direction.NORD);
        System.out.println(desert);*/

        /*// Test de la méthode deplacer de l'oeil
        System.out.println("Deplacer l'Oeil : ");
        desert.getOeil().deplaceCase(Direction.OUEST);
        System.out.println(desert);*/


        // Test de la méthode Joueur
        System.out.println("Ajout Joueur : ");
        desert.setCaseContenu(0,4);
        desert.setCaseContenu2(0,4);
        System.out.println(desert);

        desert.deplaceJoueur(Direction.OUEST);
        System.out.println(desert);
        desert.deplaceJoueur(Direction.OUEST);
        System.out.println(desert);
        desert.deplaceJoueur(Direction.OUEST);
        System.out.println(desert);
        desert.deplaceJoueur(Direction.SUD);
        System.out.println(desert);


    }
}
