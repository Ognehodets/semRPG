// маг лечит за один ход одного самого больного среди своих



package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import game.*;
import game.Character;

public class Main {

    public static ArrayList<Character> darkTeam = new ArrayList<>();
    public static ArrayList<Character> holyTeam = new ArrayList<>();
    public static ArrayList<Character> allTeam = new ArrayList<>();

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

        int teamSize = 10;

        // наполнение первой и второй команды
        for (int i = 1; i < teamSize + 1; i++) {
            darkTeam.add(creatRandomCharacter(getName(), i, 1));
            holyTeam.add(creatRandomCharacter(getName(), i, 10));
        }

        // // всех в одну кучу сгрупировали

        allTeam.addAll(darkTeam);
        allTeam.addAll(holyTeam);
        allTeam.sort(new Comparator<Character>() {
            @Override
            public int compare(Character char1, Character char2) {
                return char2.speed - char1.speed;
            }
        });

        Scanner scanner = new Scanner(System.in);
        while (true) {
            View.view();
            scanner.nextLine();
            int sumHpDark = 0;
            int sumHpHolly = 0;
            for (Character dark : darkTeam) {
                sumHpDark += dark.getHp();
            }
            if (sumHpDark == 0) {
                System.out.println("HolyTeam wins!!!!");
                break;
            }

            for (Character holy : holyTeam) {
                sumHpHolly += holy.getHp();
            }
            if (sumHpHolly == 0) {
                System.out.println("DarkTeam wins!!!!");
                break;
            }

            for (Character unit : allTeam) {
                if (holyTeam.contains(unit))
                    unit.step(darkTeam, holyTeam);
                else
                    unit.step(holyTeam, darkTeam);

            }
        }

        
    }
}