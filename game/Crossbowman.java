package game;

public class Crossbowman extends Character {

    private int ingureChance = 20; // шанс увернуться при побеге в процентах

    public Crossbowman(String name, int x, int y) {
        super(name, 15, "human", "male", 5, 0, 6, x, y);
    }

    @Override
    public String toString() {
        return "Class: Crossbowman, " + super.toString();
    }

    @Override
    // при получении урона в спину может увернуться
    public void getDamage(Character character) {
        int chance = random.nextInt(fullPercent);
        if (chance < ingureChance) {
            System.out.println(this.name + " dodged from backstub when retreating!");
        } else {
            System.out.println(this.name + " got backstub when retreating!");
            if (this.hp - character.damage <= 0) {
                this.hp = 0;
                this.status = "dead";
            } else {
                this.hp -= character.damage;
            }
        }
    }
}
