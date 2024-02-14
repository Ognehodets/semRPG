package game;
public class Spearman extends Character {
    private int hp;

    public Spearman(String name, String gender) {
        super(name, 35, "orc", gender, 2, 1, 2);

    }

    @Override
    // при побеге использует броню
    public void getDamage(Character character) {
        System.out.println(this.name + " got reduced damage when retreating!");
        if (this.hp - character.damage + this.armor <= 0) {
            this.hp = 0;
            this.status = "dead";
        } else {
            this.hp = this.hp - character.damage + this.armor;
        }
    }

}
