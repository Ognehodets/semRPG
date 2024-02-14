package main;

import game.*;
/*Крестьянин+
Разбойник+
Снайпер+
Колдун+
Копейщик+
Арбалетчик+
Монах +
Для каждого определить 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).*/

public class Main {
    public static void main(String[] args) {
        Crossbowman crossbowman = new Crossbowman("Boris", "male");
        Monk monk = new Monk("Nikodim", "human", "male");
        // monk.duel(crossbowman);
        // crossbowman.hp=0;
        Peasant peasant = new Peasant("Evpatiy");
        Rogue rogue = new Rogue("Robin Hood", "human", "male");
        // peasant.duel(rogue);
        Sniper sniper = new Sniper("Kate Bishop", "female");
        // sniper.duel(crossbowman);
        Wisard wisard = new Wisard("Liriel", "female");
        // wisard.duel(sniper);
        Spearman spearman = new Spearman("Gork", "male");
        // spearman.duel(wisard);
        // печать всех персонажей:
        System.out.println(crossbowman);
        System.out.println(monk);
        System.out.println(peasant);
        System.out.println(rogue);
        System.out.println(sniper);
        System.out.println(wisard);
        System.out.println(spearman);
        

    }
}