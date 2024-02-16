package game;

public class Wisard extends Character {
    private int fireAttackChance = 50;// шанс в процентах дополнительно к атаке сотворить огненную стрелу
    private int maxFireDamage = 3;// максимальный дополнительный магический урон

    public Wisard(String name, int x, int y) {
        super(name, 35, "dark elf", "female", 4, 0, 3, x, y);
    }

    @Override
    public String toString() {
        return "Class: Wisard, " + super.toString();
    }

    // к атаке с вероятностью 50% может сотворить огненную стрелу
    public void fireArrow(Character character) {
        if ((this.status == "alive") && (character.status == "alive")) {
            int сhance = random.nextInt(fullPercent);
            if (сhance < fireAttackChance) {
                int fireDamage = random.nextInt(maxFireDamage);// генерирует дополнительный магический урон
                System.out.println(this.name + " attacks with fire arrow - " + fireDamage + " bonus damage!");
                if (character.hp - fireDamage <= 0) {
                    character.hp = 0;
                    character.status = "dead";
                } else {
                    character.hp = character.hp - fireDamage;
                }
            }
        }
    }

    // используется в групповой дуэли
    public void fireBall(Character char1, Character char2, Character char3) {
        char1.hp -= this.damage;
        char2.hp -= this.damage;
        char3.hp -= this.damage;

    }

    @Override
    // может добавить атаку огненной стрелой
    public void attack(Character character) {
        this.fireArrow(character);
        super.attack(character);
    }

}
