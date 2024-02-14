package game;

public class Sniper extends Character {

    private double minHpToPowerShot = 0.2;// минимальный уровень hp в процентах для усиленной атаки
    private int maxPowerMultiplier = 3; // максимальный множитель усиления атаки

    public Sniper(String name, String gender) {
        super(name, 20, "elf", gender, 5, 0, 7);

    }

    // при снижении хп ниже 20 % наносит от 2 до 3-кратного урона
    public void powerShot() {
        int powerMultiplier = random.nextInt(1, maxPowerMultiplier) + 1;
        System.out.println(this.name + "'s attack grows " + powerMultiplier + " times!!");
        this.damage = powerMultiplier * this.damage;
    }

    @Override
    public void attack(Character character) {
        if ((this.hp < this.maxHp * minHpToPowerShot) && (this.status == "alive")) {
            this.powerShot();
        } else {
            super.attack(character);
        }
    }

}
