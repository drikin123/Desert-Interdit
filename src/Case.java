public class Case {

    public static int coordVI=0;
    public static int coordVJ=0;
    private int niveausable; //niveau de sable présent sur la case
    private int i, j; //coordonees de la case

    private boolean position;
    private Joueur contenu;
    private Joueur contenu2;
    private Joueur contenu3;
    private TypeZone contenuzone;

    public boolean getPosition() {
        return position;
    }

    public TypeZone getContenuzone() {
        return contenuzone;
    }

    public void videContenuzone(){
        this.contenuzone=null;
    }

    public void setContenuzone(TypeZone contenuzone) {
        this.contenuzone = contenuzone;
    }

    public int getNiveausable() {
        return this.niveausable;
    }

    public Joueur getContenu() {
        return this.contenu;
    }

    public void videContenu(){
        this.contenu=null;
    }

    public void setContenu(Joueur contenu) {
        this.contenu = contenu;
    }

    public Joueur getContenu2() {
        return this.contenu2;
    }

    public void videContenu2(){
        this.contenu2=null;
    }

    public void setContenu2(Joueur contenu) {
        this.contenu2 = contenu;
    }

    public Joueur getContenu3() {
        return this.contenu3;
    }

    public void videContenu3(){
        this.contenu3=null;
    }

    public void setContenu3(Joueur contenu) {
        this.contenu3 = contenu;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setNiveausable(int niveausable) {
        this.niveausable = niveausable;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    //constructeur de la classe case
    public Case (int i, int j){
        this.niveausable=0; //initialisation à 0
        this.i=i;
        this.j=j;
        this.contenuzone=null;
        this.contenu=null;
        this.contenu2=null;
        this.contenu3=null;
        this.position=false;
    }

    public void retourner (){
        this.position=true;
    }

    //methode permettant d'augmenter le niveau de sable
    public void ensabler(int cb){
        this.niveausable+=cb; //incrementation niveau sable
    }

    //methode permettant de diminuer le niveau de sable
    public void desensabler(){
        if(this.niveausable==1) //verification
        this.niveausable--; //decrementation niveau sable
    }

    public Case getVoisin(Direction direction){
        switch (direction) {
            case NORD:
                if (i > 0){ // vérification que la case nord existe
                    return Desert.getCase(i - 1, j);} //nord de la case actuelle
                else
                    return null;
            case EST:
                if (j < Desert.LARGEUR - 1){// vérification que la case est existe
                    return Desert.getCase(i, j + 1);} //est de la case actuelle
                else
                    return null;
            case SUD:
                if (i < Desert.HAUTEUR - 1){ // vérification que la case sud existe
                    return Desert.getCase(i + 1, j);} //sud de la case actuelle
                else
                    return null;
            case OUEST:
                if (j > 0){ // vérification que la case ouest existe
                    return Desert.getCase(i, j - 1);} //ouest de la case actuelle
                else
                    return null;
            default:
                return null; //Retourne null si la direction n'est pas valide
        }
    }

    public void deplaceCase(Direction direction){
        if (this.niveausable > 0) { // Vérifie si la case a du sable
            Case voisin = this.getVoisin(direction);
            if (voisin != null && voisin.getNiveausable() == 0) { // Vérifie si le voisin est valide et n'a pas de sable
                this.setNiveausable(0); // Supprime le sable de la case actuelle
                voisin.setNiveausable(1); // Ajoute un sable à la case voisine
                this.setI(voisin.getI()); // Déplace la case actuelle vers la case voisine
                this.setJ(voisin.getJ());
            }
        }
    }



    //affichage
    public String toString() {
        if(getContenu()!=null || getContenu2()!=null || getContenu3()!=null){
            return "#";
        }
        return String.valueOf(niveausable);
    }
}
