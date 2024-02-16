package game;

public class Monk extends Character {
    private int maxHeal = 4;// максимальная величина леченияъ
    private double minHpToHeal = 0.25; // минимальный уровень hp для начала лечения самого себя

    public Monk(String name, int x, int y) {
        super(name, 32, "human", "male", 2, 1, 2,x,y);
    }

@Override
public String toString() {
       return "Class: Monk, " + super.toString();
}

    public void heal(Character character) {
        int healValue = random.nextInt(maxHeal);
        if ((character.hp + healValue) > character.maxHp) {
            character.hp = character.maxHp;
            System.out.println(this.name + " restors " + character.name + "'s hp to full");
        } else {
            character.hp += healValue;
            System.out.println(this.name + " restors " + character.name + "'s hp by " + healValue);
        }
    }

    @Override
    // когда уровень hp низкий - может лечится и атаковать
    public void attack(Character character) {
        if ((this.hp < this.maxHp*minHpToHeal) && (this.status == "alive")) {
            this.heal(this);
            super.attack(character);
        } else {
            super.attack(character);
        }
    }

}
