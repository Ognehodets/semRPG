package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wisard extends Character {
    private int fireAttackChance = 50;// шанс в процентах дополнительно к атаке сотворить огненную стрелу
    private int maxFireDamage = 3;// максимальный дополнительный магический урон
    private int maxHeal = 4;// максимальная величина лечения
    private int maxMana = 10;
    private int mana;

    public Wisard(String name, int x, int y) {
        super(name, 35, "dark elf", "female", 1, 0, 3, x, y);
        mana = maxMana;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana: " + mana;
    }

    public String getInfo() {
        return "Wizard";
    }

    public void heal(Character character) {
        int healValue = random.nextInt(maxHeal);
        if ((character.hp + healValue) > character.maxHp) {
            character.hp = character.maxHp;
        } else {
            character.hp += healValue;
        }
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

    @Override
    // может добавить атаку огненной стрелой
    public void attack(Character character) {
        this.fireArrow(character);
        super.attack(character);
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
            sortTeam.getFirst().hp = sortTeam.getFirst().maxHp/2;
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
