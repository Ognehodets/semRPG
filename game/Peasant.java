package game;

public class Peasant extends Character {

    public Peasant(String name,int x, int y) {
        super(name, 5, "human", "male", 1, 0, 1,x,y);

    }

    // ничего не умеет кроме копания огорода, быстро умирает

    @Override
    public String toString() {
        if (this.status == "dead") {
            System.out.println("Agriculture has suffered!");
            return "Class: Peasant, " + super.toString(); 
        } else {
            return "Class: Peasant, " + super.toString();
        }
    }
}
