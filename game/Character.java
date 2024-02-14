package game;

import java.util.Random;

public abstract class Character {
    protected Random random = new Random();
    protected String name;
    protected int hp;
    protected int maxHp;
    protected String race;
    protected String gender;
    protected int speed;
    protected int armor;
    protected int damage;
    protected String status = "alive";
    private double hpToRetreat = 0.33; // минимальный уровень hp для попытки сбежать
    protected int fullPercent = 100;
    protected int chanceToRetreat = 20; // вероятность в процентах сбежать при низком уровне хп

    public Character(String name, Integer hp, String race, String gender, int speed, int armor, int damage) {
        this.maxHp = hp;
        this.name = name;
        this.hp = hp;
        this.race = race;
        this.gender = gender;
        this.speed = speed;
        this.armor = armor;
        this.damage = damage;
    }

    // может использоваться при тактическом или территориальном сражении
    int go(Integer place) {
        return place - speed;
    }

    // атакует врага (во время дуэли)
    public void attack(Character character) {
        if ((this.status == "alive") && (character.status == "alive")) {// мертвый или сбежавший персонаж не может
                                                                        // атаковать
            if (character.hp - damage + character.armor <= 0) {
                character.hp = 0;
                character.status = "dead";
            } else {
                character.hp = character.hp - damage + character.armor;// персонаж получает повреждение, равное урону
                                                                       // врага минус собственная броня
            }
        }
    }

    // получает при побеге и без учета брони
    public void getDamage(Character character) {
        if (character.status == "alive") {// мертвый или бежавший персонаж не может бить в спину
            System.out.println(this.name + " got backstub when retreating!");
            if (this.hp - character.damage <= 0) {
                this.hp = 0;
                this.status = "dead";
            } else {
                this.hp -= character.damage;
            }
        }
    }

    // при снижении уровня hp может попытаться сбежать с поля боя
    public void tryToRetreat(Character character) {
        if ((this.hp < this.maxHp * hpToRetreat) && (this.status == "alive") && (character.status == "alive")) {
            int chance = random.nextInt(fullPercent);
            if (chance < chanceToRetreat) {
                System.out.println(this.name + " retreating from battlefield");
                this.status = "retreated";
                this.getDamage(character);// получает удар в спину без брони
            }
        }
    }

    // дуэль двух персонажей до смерти одного из них или побега
    public void duel(Character character) {
        System.out.println(this);
        System.out.println(character);
        while (this.status == "alive" && character.status == "alive") {
            this.attack(character);
            this.tryToRetreat(character);
            character.attack(this);
            character.tryToRetreat(this);
            System.out.println(this);
            System.out.println(character);
        }
        System.out.println("------------");
    }

    @Override
    public String toString() {
        return ("Name: " + name + ", gender: " + gender + ", race: " + race + ",  hp: " + hp + ", status: " + status);
    }

}
