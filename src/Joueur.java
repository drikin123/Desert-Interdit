import java.lang.reflect.Array;
import java.util.ArrayList;

public class Joueur {


    private int eau;
    private ArrayList<Piece> piece;

    public Joueur() {
        this.eau = 5;
        this.piece = new ArrayList<>();
    }

    public int getEau() {
        return eau;
    }

    public void setEau(int eau) {
        if (this.eau+eau <=5  )
        this.eau += eau;
    }

    public ArrayList<Piece> getPiece() {
        return this.piece;
    }

    public void addPiece(Piece piece) {
        this.piece.add(piece);
    }


    public void eau_down() {
        if(this.eau>0)this.eau--;
    }

    public void eau_up(int i) {
        this.eau+=i;
    }

        public String toString(){
            return "#";
        }
}





