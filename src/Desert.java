
public class Desert {
    public static final int LARGEUR = 5;
    public static final int HAUTEUR = 5;

    public static int niveauTempete=0;
    private static Case[][] cases;
    private Oeil oeil;



    public static Case[][] getCases() {
        return cases;
    }

    public static void setCases(Case[][] cases) {
        Desert.cases = cases;
    }

    public Oeil getOeil() {
        for(Case[] c : cases){
            for(Case d : c){
                if(d instanceof Oeil)
                    return (Oeil)d;
            }
        }
        System.out.println("oeil inconnu :");
        return new Oeil(0,0);
    }

    public void setOeil(int i, int j) {

        this.cases[i][j]=new Oeil(i, j);
    }

    //constructeur de la classe desert
    public Desert(Case[][] cases) {
        Desert.cases = cases;
        for (int i = 0; i < Desert.HAUTEUR; i++) {
            for (int j = 0; j < Desert.LARGEUR; j++) {
                cases[i][j] = new Case(i, j);
            }
        }
        this.oeil=getOeil();
    }

    //selectionner une case
    public static Case getCase(int i, int j) {
        return cases[i][j];
    }

    public void setCaseContenu(int i, int j) {
        cases[i][j].setContenu(new Joueur());
    }

    public void setCaseContenu2(int i, int j) {
        cases[i][j].setContenu2(new Joueur());
    }

    public void setCaseContenu3(int i, int j) {
        cases[i][j].setContenu3(new Joueur());
    }

    //declaration du desert
    public void declarer(int i, int j, int sable) {
        cases[i][j].setNiveausable(sable);
    }

    public void souffler(Direction direction, int force) {
        Oeil oeil = getOeil();
        direction=direction.getOpposee();
        if(direction==Direction.EST || direction==Direction.SUD){
            for (int i = cases.length - 1; i >= 0; i--) {
                for (int j = cases[i].length - 1; j >= 0; j--) {
                    Case c = cases[i][j];
                    /*if (c.getNiveausable() > 0) {
                    Case voisin = c.getVoisin(direction);
                    if (voisin != null) {
                        c.ensabler(force);
                        int niveauSable = c.getNiveausable();
                        //c.setNiveausable(voisin.getNiveausable());
                        voisin.setNiveausable(niveauSable);
                    }
                }*/
                    if (c instanceof Oeil && oeil == c) {
                        deplaceOeil(i,j,direction, force);
                    }
                }
            }
        }
        else{
        int n = cases.length;
        int m = cases[0].length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Case c = cases[i][j];
                /*if (c.getNiveausable() > 0) {
                    Case voisin = c.getVoisin(direction);
                    if (voisin != null) {
                        c.ensabler(force);
                        int niveauSable = c.getNiveausable();
                        //c.setNiveausable(voisin.getNiveausable());
                        voisin.setNiveausable(niveauSable);
                    }
                }*/
                if (c instanceof Oeil && oeil == c) {
                    deplaceOeil(i,j,direction, force);
                }
            }
        }
        }
    }

    public void dechaine(){
        //if(niveauTempete<14)
        niveauTempete++;
    }


    public void transformerEnOeil(int i, int j) {
        if (cases[i][j] instanceof Oeil) {
            return; // Si la case est déjà un œil, on ne fait rien
        }
        // Créer un nouvel œil à la position donnée
        Oeil nouvelOeil = new Oeil(i, j);
        // Enregistrer le niveau de sable de la case qui était à la position de l'œil
        nouvelOeil.setNiveausable(cases[i][j].getNiveausable());
        // Remplacer la case par le nouvel œil
        cases[i][j] = nouvelOeil;
    }

    public void transformerEnCase(int i, int j) {
        if ((cases[i][j] instanceof Oeil==false)) {
            return; // Si la case n'est pas un case, on ne fait rien
        }
        // Créer une nouvelle case à la position donnée
        Case nouvelleCase = new Case(i, j);
        // Enregistrer le niveau de sable de la case qui était à la position de la case
        nouvelleCase.setNiveausable(cases[i][j].getNiveausable());
        // Remplacer la case par la nouvelle case
        cases[i][j] = nouvelleCase;
    }


    public void deplaceOeil(int i, int j, Direction direction, int force) {
        Case voisin = cases[i][j].getVoisin(direction);
        int nouveauSable=voisin.getNiveausable()+force;
        if (voisin != null) {
            transformerEnCase(i, j);
            cases[i][j].setNiveausable(nouveauSable);
            transformerEnOeil(voisin.getI(), voisin.getJ());
        }
    }

    public void explorer(Direction direction){
        int i=getIJoueur();
        int j=getJJoueur();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getPosition()==false){
            voisin.retourner();
            Vue.nbaction++;
        }
    }

    public void explorerActuelle(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];

        actuelle.retourner();
        Vue.nbaction++;

    }

    public void explorerActuelle2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];

        actuelle.retourner();
        Vue.nbaction2++;

    }

    public void explorerActuelle3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];

        actuelle.retourner();
        Vue.nbaction3++;

    }

    public void eauUp(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Oasis){
            actuelle.getContenu().eau_up(2);
        }

    }

    public void eauUp2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Oasis){
            actuelle.getContenu2().eau_up(2);
        }

    }

    public void eauUp3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Oasis){
            actuelle.getContenu3().eau_up(2);
        }

    }

    public boolean gagner(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Piste){
            return true;
        }
        return false;
    }

    public boolean gagner2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Piste){
            return true;
        }
        return false;
    }

    public boolean gagner3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];
        if(actuelle.getPosition() && actuelle.getContenuzone()==TypeZone.Piste){
            return true;
        }
        return false;
    }

    public boolean gagnerPartie(){
        if(gagner() || gagner2()|| gagner3()){
            return true;
        }
        return false;
    }

    public void deplaceJoueur(Direction direction) {
        int i=getIJoueur();
        int j=getJJoueur();
        Joueur c=cases[i][j].getContenu();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getNiveausable()<2 && voisin instanceof Oeil==false && voisin.getPosition()==false) {
            voisin.setContenu(c);
            cases[i][j].videContenu();
            Vue.nbaction++;
        }
    }

    public void desensablevoisin(Direction direction){
        int i=getIJoueur();
        int j=getJJoueur();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null){
            voisin.desensabler();
            Vue.nbaction++;
        }
    }

    public void desensableActuelle(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];

        actuelle.desensabler();
        Vue.nbaction++;

    }

    public void explorer2(Direction direction){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getPosition()==false){
            voisin.retourner();
            Vue.nbaction2++;
        }
    }


    public void deplaceJoueur2(Direction direction) {
        int i=getIJoueur2();
        int j=getJJoueur2();
        Joueur c=cases[i][j].getContenu2();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getNiveausable()<2 && voisin instanceof Oeil==false && voisin.getPosition()==false) {
            voisin.setContenu2(c);
            cases[i][j].videContenu2();
            Vue.nbaction2++;
        }
    }

    public void desensablevoisin2(Direction direction){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null){
            voisin.desensabler();
            Vue.nbaction2++;
        }
    }

    public void desensableActuelle2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];

        actuelle.desensabler();
        Vue.nbaction2++;

    }

    public void explorer3(Direction direction){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getPosition()==false){
            voisin.retourner();
            Vue.nbaction3++;

        }
    }

    public Piece quelPiece(TypeZone t){
        if(t==TypeZone.Indice){
            return Piece.moteur;
        }else if(t==TypeZone.Indice2){
            return Piece.helice;
        }else if(t==TypeZone.Indice3){
            return Piece.gouvernail;
        }else if(t==TypeZone.Indice4){
            return Piece.capteur;
        }
        return null;
    }

    public void ramasser(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];
        TypeZone t=actuelle.getContenuzone();
        if(actuelle.getPosition()) {
            if (actuelle.getContenuzone() == TypeZone.Indice || actuelle.getContenuzone() == TypeZone.Indice2 || actuelle.getContenuzone() == TypeZone.Indice3 || actuelle.getContenuzone() == TypeZone.Indice4) {
                actuelle.videContenuzone();
                actuelle.getContenu().addPiece(quelPiece(t));
            }
        }
    }

    public void ramasser2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];
        TypeZone t=actuelle.getContenuzone();
        if(actuelle.getPosition()) {
            if (actuelle.getContenuzone() == TypeZone.Indice || actuelle.getContenuzone() == TypeZone.Indice2 || actuelle.getContenuzone() == TypeZone.Indice3 || actuelle.getContenuzone() == TypeZone.Indice4) {
                actuelle.videContenuzone();
                actuelle.getContenu2().addPiece(quelPiece(t));
            }
        }
    }

    public void ramasser3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];
        TypeZone t=actuelle.getContenuzone();
        if(actuelle.getPosition()) {
            if (actuelle.getContenuzone() == TypeZone.Indice || actuelle.getContenuzone() == TypeZone.Indice2 || actuelle.getContenuzone() == TypeZone.Indice3 || actuelle.getContenuzone() == TypeZone.Indice4) {
                actuelle.videContenuzone();
                actuelle.getContenu3().addPiece(quelPiece(t));
            }
        }
    }


    public void deplaceJoueur3(Direction direction) {
        int i=getIJoueur3();
        int j=getJJoueur3();
        Joueur c=cases[i][j].getContenu3();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null && voisin.getNiveausable()<2 && voisin instanceof Oeil==false && voisin.getPosition()==false) {
            voisin.setContenu3(c);
            cases[i][j].videContenu3();
            Vue.nbaction3++;
        }
    }

    public void desensablevoisin3(Direction direction){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case voisin = cases[i][j].getVoisin(direction);
        if (voisin != null){
            voisin.desensabler();
            Vue.nbaction3++;
        }
    }

    public void desensableActuelle3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];

        actuelle.desensabler();
        Vue.nbaction3++;

    }

    public int niveauEau(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];

        return actuelle.getContenu().getEau();

    }

    public int niveauEau2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];

        return actuelle.getContenu2().getEau();

    }

    public int niveauEau3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];

        return actuelle.getContenu3().getEau();

    }

    public boolean mortdeSoif(){
        if(niveauEau()==0 || niveauEau2()==0 || niveauEau3()==0)
            return true;
        return false;
    }

    public void eauDown(){
        int i=getIJoueur();
        int j=getJJoueur();
        Case actuelle = cases[i][j];

        if(!(actuelle.getContenuzone()==TypeZone.Tunnel)){
            actuelle.getContenu().eau_down();
        }

    }

    public void eauDown2(){
        int i=getIJoueur2();
        int j=getJJoueur2();
        Case actuelle = cases[i][j];

        if(!(actuelle.getContenuzone()==TypeZone.Tunnel)){
            actuelle.getContenu2().eau_down();
        }
    }

    public void eauDown3(){
        int i=getIJoueur3();
        int j=getJJoueur3();
        Case actuelle = cases[i][j];

        if(!(actuelle.getContenuzone()==TypeZone.Tunnel)){
            actuelle.getContenu3().eau_down();
        }
    }



    public int getIJoueur(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu() instanceof Joueur)
                    return d.getI();
            }
        }
        return -1;
    }

    public int getJJoueur(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu() instanceof Joueur)
                    return d.getJ();
            }
        }
        return -1;
    }

    public int getIJoueur2(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu2() instanceof Joueur)
                    return d.getI();
            }
        }
        return -1;
    }

    public int getJJoueur2(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu2() instanceof Joueur)
                    return d.getJ();
            }
        }
        return -1;
    }
    public int getIJoueur3(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu3() instanceof Joueur)
                    return d.getI();
            }
        }
        return -1;
    }

    public int getJJoueur3(){
        for(Case[] c : cases){
            for(Case d : c){
                if(d.getContenu3() instanceof Joueur)
                    return d.getJ();
            }
        }
        return -1;
    }

    public Case getVoisin(Case c, Direction direction){
        return c.getVoisin(direction);
    }

    public void setCase(Case c,int i, int j){
        c.setJ(j);
        c.setI(i);
        c.setNiveausable(cases[i][j].getNiveausable());
    }

    public int totalSable(){
        int res=0;
        for(Case[] c : cases){
            for(Case d : c){
                if(d instanceof Oeil==false)
                res+=d.getNiveausable();
            }
        }
        return res;
    }


    @Override
    public String toString() {
        for (int i = 0; i < HAUTEUR; i++) {
            for (int j = 0; j < LARGEUR; j++) {
                System.out.print(cases[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

}
