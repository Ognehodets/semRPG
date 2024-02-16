package main;

import java.util.ArrayList;
import java.util.Random;
import game.*;
import game.Character;

public class Main {

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    private static Character creatRandomCharacter(String charName, int x, int y) {
        Random random = new Random();
        int typeCharacter = random.nextInt(7);
        switch (typeCharacter) {
            case 0:
                return new Crossbowman(charName, x, y);
            case 1:
                return new Monk(charName, x, y);
            case 2:
                return new Peasant(charName, x, y);
            case 3:
                return new Rogue(charName, x, y);
            case 4:
                return new Sniper(charName, x, y);
            case 5:
                return new Spearman(charName, x, y);
            case 6:
                return new Wisard(charName, x, y);
            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Character> team1 = new ArrayList<>();
        ArrayList<Character> team2 = new ArrayList<>();
        int teamSize = 10;

        // наполнение первой и второй команды
        for (int i = 0; i < teamSize; i++) {
            team1.add(creatRandomCharacter(getName(), i, 0));
            team2.add(creatRandomCharacter(getName(), i, 9));
        }

        // печать первой команды
        System.out.println("Team 1: ");
        for (int i = 0; i < teamSize; i++) {
            System.out.println(team1.get(i));
        }

        // печать второй команды
        System.out.println("Team 2: ");
        for (int i = 0; i < teamSize; i++) {
            System.out.println(team2.get(i));
        }

        // выбор случайного персонажа из 1 команды
        Character hero = team1.get(random.nextInt(teamSize));
        System.out.println("Member of team 1: ");
        System.out.println(hero);
        // выбор ближайшего к нему врага
        Character enemy = hero.getTarget(team2);
        System.out.println("Member of team 2: ");
        System.out.println(enemy);
        System.out.println("Distance betwean them: ");
        System.out.println(hero.position.getDistance(enemy.position));
    }
}