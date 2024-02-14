package game;

public class Peasant extends Character {

    public Peasant(String name) {
        super(name, 5, "human", "male", 1, 0, 1);

    }

    // ничего не умеет кроме копания огорода, быстро умирает

    @Override
    public String toString() {
        if (this.status == "dead") {
            System.out.println("Agriculture has suffered!");
            return ("Name: " + name + ", gender: " + gender + ", race: " + race + ",  hp: " + hp + ", status: "
                    + status);
        } else {
            return ("Name: " + name + ", gender: " + gender + ", race: " + race + ",  hp: " + hp + ", status: "
                    + status);
        }
    }
}
