package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Monk extends Character {
    private int maxHeal = 4;// максимальная величина лечения
    private double minHpToHeal = 0.25; // минимальный уровень hp для начала лечения самого себя
    private int maxMana = 10;
    private int mana;

    public Monk(String name, int x, int y) {
        super(name, 32, "human", "male", 1, 1, 2, x, y);
        mana = maxMana;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana: " + mana;
    }

    public String getInfo() {
        return "Monk";
    }

    public void heal(Character character) {
        int healValue = random.nextInt(maxHeal);
        if ((character.hp + healValue) > character.maxHp) {
            character.hp = character.maxHp;
        } else {
            character.hp += healValue;
        }
    }

    @Override
    // когда уровень hp низкий - может лечится и атаковать
    public void attack(Character character) {
        if ((this.hp < this.maxHp * minHpToHeal) && (this.status == "alive")) {
            this.heal(this);
            super.attack(character);
        } else {
            super.attack(character);
        }
    }

    @Override
    public void step(List<Character> enemyTeam, List<Character> myTeam) {
        if (!status.equals("alive")) {
            return;
        }
        if (mana < 2) {
            mana++;
            return;
        }

        ArrayList<Character> sortTeam = new ArrayList<>(myTeam);

        sortTeam.sort(new Comparator<Character>() {
            @Override
            public int compare(Character char1, Character char2) {
                return (char2.maxHp - char2.hp) - (char1.maxHp - char1.hp);
            }
        });

        int countDead = 0;

        for (Character friend : sortTeam) {
            if (friend.status.equals("dead")) {
                countDead++;
            }
        }
        if (countDead >= 3) {
            if (mana < maxMana) {
                mana++;
                return;
            }
            sortTeam.getFirst().status = "alive";
            sortTeam.getFirst().hp = sortTeam.getFirst().maxHp;
            mana = 0;
            return;

        }

        for (Character friend : sortTeam) {
            if (friend.status.equals("alive")) {
                heal(friend);
                mana -= 2;
                return;
            }
        }
    }

}
