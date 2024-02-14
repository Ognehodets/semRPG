package game;
public class Crossbowman extends Character {
    
    private int ingureChance = 20; // шанс увернуться при побеге в процентах


    public Crossbowman(String name, String gender) {
        super(name, 15, "human", gender, 5, 0, 6);
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
